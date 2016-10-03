SUMMARY = "Neutrino MP"
DESCRIPTION = "Seifes Neutrino-MP for multiple Platforms."
HOMEPAGE = "http://www.tuxbox.org"
SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.GPL;md5=751419260aa954499f7abaabaa882bbe"

inherit autotools pkgconfig

DEPENDS += " \
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
	lua5.2 \
	luaposix \
	openssl \
	openthreads \
	tremor \
	virtual/stb-hal-libs \
	virtual/libiconv \
"

RCONFLICTS_${PN} = "neutrino-hd neutrino-ni"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "3"

SRC_URI = "git://git.slknet.de/test-cst-next.git;protocol=http \
	file://0001-fix-for-gcc-6.x.patch \
	file://timezone.xml \
	file://custom-poweroff.init \
	file://COPYING.GPL \
	file://0001-uncooloff.c-add-include-stdbool.h.patch \
	file://hardware_caps.cpp \
	file://hardware_caps.h \
	file://pre-wlan0.sh \
	file://post-wlan0.sh \
	file://0001-fix-compilation-with-ffmpeg3.0.1.patch \
"


SRC_URI_append_libc-glibc = "file://0006-Makefile.am-we-don-t-need-liconv-for-glibc.patch\
"

S = "${WORKDIR}/git"

include neutrino-mp.inc

do_configure_prepend() {
	# change number to force rebuild "2"
	cp ${WORKDIR}/hardware_caps* ${S}/lib/libcoolstream2
	INSTALL="`which install` -p"
	export INSTALL
	ln -sf ${B}/src/gui/version.h ${S}/src/gui/
}

do_compile () {
	# unset CFLAGS CXXFLAGS LDFLAGS
	oe_runmake CFLAGS="${N_CFLAGS}" CXXFLAGS="${N_CXXFLAGS}" LDFLAGS="${N_LDFLAGS}"
}


do_install_prepend () {
# change number to force rebuild "1"
	install -d ${D}/${sysconfdir}/init.d ${D}${sysconfdir}/network
	install -m 755 ${WORKDIR}/custom-poweroff.init ${D}${sysconfdir}/init.d/custom-poweroff
	install -m 755 ${WORKDIR}/pre-wlan0.sh ${D}${sysconfdir}/network/
	install -m 755 ${WORKDIR}/post-wlan0.sh ${D}${sysconfdir}/network/
	install -m 644 ${WORKDIR}/timezone.xml ${D}${sysconfdir}/timezone.xml
	install -d ${D}/var/cache
	install -d ${D}/var/tuxbox/config/
	install -d ${D}/var/tuxbox/plugins/
	echo "version=${DISTRO_VERSION}  `date +%Y-%m-%d` `date +%H:%M`"    > ${D}/.version  
	echo "creator=${CREATOR}"             >> ${D}/.version 
	echo "imagename=Neutrino-MP"             >> ${D}/.version 
	echo "homepage=${HOMEPAGE}"              >> ${D}/.version 
}

FILES_${PN} += "\
	/.version \
	${sysconfdir} \
	/share \
	/usr/share \
	/var/cache \
	/var/tuxbox/plugins \
	/var/httpd/styles \
"

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
}
