SUMMARY = "VDR - The Video Disk Recorder"
HOMEPAGE = "http://www.tvdr.de/"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "ftp://ftp.tvdr.de/vdr/Developer/vdr-${PV}.tar.bz2 \
  file://vdr.service \
  file://Make.config \
  file://fix_for_gcc7.patch;apply=no \
  "

SRC_URI[md5sum] = "2afe8b899b3af1967320c216c1315f3e"
SRC_URI[sha256sum] = "d871170ee90ef2fc6293eefb44262b82b2e1f00f934681c721da7bd30e45bf22"


S = "${WORKDIR}/vdr-${PV}"

DEPENDS = "fontconfig freetype gettext virtual/libintl libcap jpeg ttf-bitstream-vera ncurses"
RDEPENDS_${PN} += "perl"

inherit pkgconfig systemd gettext

do_configure_append() {
  cp ${WORKDIR}/Make.config ${S}
}


do_install_prepend() {
      install -d ${D}/home/builder/.config/vdr ${D}/home/builder/movies
}


do_install () {
  oe_runmake 'DESTDIR=${D}' install-bin install-i18n install-includes install-pc
  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/vdr.service ${D}${systemd_unitdir}/system
}

PACKAGES_DYNAMIC += "^vdr-plugin-.*"

#TODO: Add locale files to corresponding package
python populate_packages_prepend () {
    vdr_libdir = d.expand('${libdir}/vdr')
    do_split_packages(d, vdr_libdir, '^libvdr-(.*)\.so\.${PV}$', 'vdr-plugin-%s', 'VDR Plugin %s', extra_depends='', prepend=True)
}

CONFFILES_${PN} += "${sysconfdir}/vdr/channels.conf \
  ${sysconfdir}/vdr/diseqc.conf \
  ${sysconfdir}/vdr/keymacros.conf \
  ${sysconfdir}/vdr/scr.conf \
  ${sysconfdir}/vdr/sources.conf \
  ${sysconfdir}/vdr/svdrphosts.conf \
  "

FILES_${PN} += "/home/builder"

SYSTEMD_SERVICE_${PN} = "vdr.service"

