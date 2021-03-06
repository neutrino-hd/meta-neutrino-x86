SUMMARY = "VDR plugin to handle kodi clients."
HOMEPAGE = "https://github.com/FernetMenta/vdr-plugin-vnsiserver"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI = "git://github.com/FernetMenta/vdr-plugin-vnsiserver.git;branch=master;protocol=https \
		   file://allowed_hosts.conf \
"

SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "vdr"

inherit pkgconfig gettext

do_install () {
  oe_runmake install DESTDIR=${D}
  install -d ${D}${sysconfdir}/vdr/plugins/vnsiserver
  install -m 0644 ${WORKDIR}/allowed_hosts.conf ${D}${sysconfdir}/vdr/plugins/vnsiserver/allowed_hosts.conf
}

FILES_${PN}_append = " ${libdir}/vdr/*"
FILES_${PN}-dbg_append = " ${libdir}/vdr/.debug"
