SUMMARY = "lightweight DLNA/UPnP-AV server targeted at embedded systems"
HOMEPAGE = "http://sourceforge.net/projects/minidlna/"
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b1a795ac1a06805cf8fd74920bc46b5c"
DEPENDS = "libexif libjpeg-turbo libid3tag flac libvorbis sqlite3 ffmpeg util-linux virtual/libiconv"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/minidlna/minidlna/${PV}/minidlna-${PV}.tar.gz \
		file://minidlna-${DISTRO}.conf \
		file://minidlna.service \
"

SRC_URI[md5sum] = "5f59700431e9f66198238deeb4e0d0de"
SRC_URI[sha256sum] = "8d34436580c4c44be25976d5e46bc5b71af69bf441c4492774eac001164c4433"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools-brokensep gettext systemd

PACKAGES =+ "${PN}-utils"

FILES_${PN}-utils = "${bindir}/test*"

CONFFILES_${PN} = "${sysconfdir}/minidlna.conf"

SYSTEMD_SERVICE_${PN} = "minidlna.service"

do_configure_prepend() {
	sed -i "s|Coolstream|${MACHINE}|" ${WORKDIR}/minidlna-${DISTRO}.conf
}

do_install_append() {
	install -d ${D}${sysconfdir} ${D}${systemd_unitdir}/system ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
	install -m 644 ${WORKDIR}/minidlna-${DISTRO}.conf ${D}${sysconfdir}/minidlna.conf
	install -m 644 ${WORKDIR}/minidlna.service ${D}${systemd_unitdir}/system/minidlna.service
	ln -sf ${systemd_unitdir}/system/minidlna.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/minidlna.service
}
