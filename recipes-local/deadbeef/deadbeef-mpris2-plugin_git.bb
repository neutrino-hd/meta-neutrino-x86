SUMMARY = "DeadBeef Mpris Plugin"
SECTION = "audio/players"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "glib-2.0 deadbeef"

SRC_URI = "git://github.com/Serranya/deadbeef-mpris2-plugin.git;protocol=https \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN} = "/usr/lib"


