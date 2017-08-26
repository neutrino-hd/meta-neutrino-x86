SUMMARY = "VDR plugin SoftHD Device"
HOMEPAGE = "https://github.com/FernetMenta/vdr-plugin-vnsiserver"
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://README.txt;md5=1d2e6ece4ec829cdc1dcb628eb6e0fff"
SRC_URI = "git://github.com/pesintta/vdr-plugin-softhddevice.git;branch=vpp_support;protocol=https"

SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "vdr ffmpeg libx11 libxcb xcb-util-wm"

inherit pkgconfig gettext

do_install () {
  oe_runmake install DESTDIR=${D}
}

FILES_${PN}_append = " ${libdir}/vdr/*"
FILES_${PN}-dbg_append = " ${libdir}/vdr/.debug"
