DESCRIPTION = "libconfuse -  a configuration file parser library written in c"
HOMEPAGE = "https://github.com/martinh/libconfuse/commits/master"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = ""

SRC_URI = "git://github.com/martinh/libconfuse.git;protocoll=https;branch=master \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

do_configure_prepend() {
	ln -sf ${S}/config.rpath ${S}/support/config.rpath
} 
