SUMMARY = "dmenu2"
HOMEPAGE = "http://tools.suckless.org/dmenu/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0b1fc9c92e5a8dbd403666c7c953b6d6"


SRC_URI = "git://git.suckless.org/dmenu;tag=4.6 \
	   file://0001-edit_config_mk.patch \
"

S = "${WORKDIR}/git"
SRCREV = "4.6"

DEPENDS = "libx11 libxinerama libxft freetype"
RDEPENDS_${PN} = "libx11-locale"

inherit autotools-brokensep pkgconfig

do_configure_prepend() {
    sed -i "s|Ifreetype2|${STAGING_INCDIR}/freetype2|" ${S}/config.mk
}

INSANE_SKIP_${PN} += "already-stripped"
