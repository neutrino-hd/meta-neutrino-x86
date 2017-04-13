SUMMARY = "Neutrino MP"
DESCRIPTION = "Seifes Neutrino-MP for multiple Platforms."
HOMEPAGE = "http://www.tuxbox.org"
SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.GPL;md5=751419260aa954499f7abaabaa882bbe"

inherit autotools pkgconfig

DEPENDS += " \
	builder \
	curl \
	ffmpeg \
	flac \
	freetype \
	freetype-native \
	gettext \
	giflib \
	libbluray \
	libdvbsi++ \
	libid3tag \
	libjpeg-turbo \
	libmad \
	libpng \
	libsigc++ \
	lua \
	luaposix \
	openssl \
	openthreads \
	virtual/stb-hal-libs \
	virtual/libiconv \
	gdk-pixbuf \
	fontconfig \
	atk \
	cairo \
	libpng \
	pixman \
	cogl-1.0 \
	clutter-1.0 \
	harfbuzz \
	pango \
	json-glib \
	libxcomposite \
"

RCONFLICTS_${PN} = "neutrino-hd neutrino-ni"
RDEPENDS_${PN} += "libao-plugin-libalsa libao-plugin-libpulse fbshot"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "3"

SRC_URI = "git://github.com/neutrino-mp/neutrino-mp.git;protocol=http \
	file://timezone.xml \
	file://custom-poweroff.init \
	file://COPYING.GPL \
	file://pre-wlan0.sh \
	file://post-wlan0.sh \
	file://mount.mdev \
	file://icons.tar.gz \
	file://var.tar.gz \
"

S = "${WORKDIR}/git"

include neutrino-mp.inc

do_configure_prepend() {
	ln -sf ${B}/src/gui/version.h ${S}/src/gui/
	sed -i "s|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|${YT_DEV_KEY}|" ${S}/src/neutrino.cpp
	sed -i "s|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|${TMDB_DEV_KEY}|" ${S}/src/neutrino.cpp
sed -i "s|XXXXXXXXXXXXXXXX|${SHOUTCAST_DEV_KEY}|" ${S}/src/neutrino.cpp
}

do_compile () {
	# unset CFLAGS CXXFLAGS LDFLAGS
	oe_runmake CFLAGS="${N_CFLAGS}" CXXFLAGS="${N_CXXFLAGS}" LDFLAGS="${N_LDFLAGS}"
}


do_install_prepend () {
	install -d ${D}/${sysconfdir}/init.d ${D}${sysconfdir}/network ${D}/home/builder/.config/neutrino
	install -m 755 ${WORKDIR}/custom-poweroff.init ${D}${sysconfdir}/init.d/custom-poweroff
	install -m 755 ${WORKDIR}/pre-wlan0.sh ${D}${sysconfdir}/network/
	install -m 755 ${WORKDIR}/post-wlan0.sh ${D}${sysconfdir}/network/
	install -m 644 ${WORKDIR}/timezone.xml ${D}${sysconfdir}/timezone.xml
	install -d ${D}/var/cache
	install -d ${D}${localstatedir}/tuxbox
	install -d ${D}/lib/mdev/fs
	install -m 755 ${WORKDIR}/mount.mdev ${D}/lib/mdev/fs/mount
	echo "version=${DISTRO_VERSION}  `date +%Y-%m-%d` `date +%H:%M`"    > ${D}/.version  
	echo "creator=${CREATOR}"             >> ${D}/.version 
	echo "imagename=Neutrino-MP"             >> ${D}/.version 
	echo "homepage=${HOMEPAGE}"              >> ${D}/.version 
}

do_install_append() {
	install -d ${D}/share
	ln -s ${datadir}/tuxbox ${D}/share/
	ln -s ${datadir}/fonts  ${D}/share/
	if [ -d ${WORKDIR}/icons ];then
		install -m 644 ${WORKDIR}/icons/* ${D}/usr/share/tuxbox/neutrino/icons/
	fi
	if [ -d ${WORKDIR}/var ];then
		install -d ${D}/var/tuxbox/plugins/webtv
		install -m 644 ${WORKDIR}/var/tuxbox/config/* ${D}/home/builder/.config/neutrino
		install -m 644 ${WORKDIR}/var/tuxbox/plugins/webtv/* ${D}/var/tuxbox/plugins/webtv
	fi
}

FILES_${PN} += "\
	/.version \
	/home/builder \
	/share \
	/usr/share \
	/var/cache \
	/var/tuxbox/plugins \
	/var/httpd/styles \
	/lib \
"

pkg_preinst_${PN} () {
	if [ -f /home/builder/.config/neutrino/config/zapit/frontend.conf ];then
		mv /home/builder/.config/neutrino/zapit/frontend.conf /home/builder/.config/neutrino/config/zapit/frontend.conf.orig
	fi
}

pkg_postinst_${PN} () {
	update-alternatives --install /bin/backup.sh backup.sh /usr/bin/backup.sh 100
	update-alternatives --install /bin/install.sh install.sh /usr/bin/install.sh 100
	update-alternatives --install /bin/restore.sh restore.sh /usr/bin/restore.sh 100
	# pic2m2v is only available on platforms that use "real" libstb-hal
	if which pic2m2v >/dev/null 2>&1; then
		# neutrino icon path
		I=/usr/share/tuxbox/neutrino/icons
		pic2m2v $I/mp3.jpg $I/radiomode.jpg $I/scan.jpg $I/shutdown.jpg $I/start.jpg
	fi
	if [ -f /home/builder/.config/neutrino/config/zapit/frontend.conf.orig ];then 
		mv /home/builder/.config/neutrino/config/zapit/frontend.conf.orig /home/builder/.config/neutrino/config/zapit/frontend.conf
	fi
}

