DESCRIPTION = "libconfuse -  a configuration file parser library written in c"
HOMEPAGE = "https://github.com/martinh/libconfuse/commits/master"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "virtual/gettext"

SRC_URI = "git://github.com/martinh/libconfuse.git;protocol=https;branch=master \
	   file://0001-add_missing-support-file.patch \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

