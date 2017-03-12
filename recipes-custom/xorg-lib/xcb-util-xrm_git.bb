DESCRIPTION = "xcb-util-xrm"
HOMEPAGE = "https://github.com/Airblader/xcb-util-xrm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

require recipes-graphics/xorg-lib/xcb-util.inc

DEPENDS += "libx11 libxcb xcb-util xcb-util-renderutil xcb-util-image"


SRC_URI = "git://github.com/Airblader/xcb-util-xrm.git;protocoll=https;branch=master \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

do_configure_prepend() {
	rm -rf ${S}/m4
	cd ${S} && git submodule update --init
}

