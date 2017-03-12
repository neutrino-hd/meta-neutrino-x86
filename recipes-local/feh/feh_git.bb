
DESCRIPTION = "AT command inout"

DEPENDS = "curl libx11 libpng libxinerama imlib2 libxt"
RDEPENDS_${PN} += "imlib2-loaders imlib2-filters"

SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRCREV = "${AUTOREV}"

SRC_URI = " \
    git://github.com/derf/feh.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

do_configure_prepend () {
    sed -i "s|/local||" ${S}/config.mk
}

FILES_${PN} += "/usr/share/icons"
