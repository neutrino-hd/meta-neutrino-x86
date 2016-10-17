DESCRIPTION = "awesome copycat themes"
HOMEPAGE = "https://github.com/copycat-killer/awesome-copycats"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "awesome lain unclutter rxvt-unicode lua5.2 builder"
RDEPENDS_${PN} += "make"

SRC_URI = "git://github.com/copycat-killer/awesome-copycats.git \
	   file://rc.lua \
"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "3"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/home/builder/.config/awesome
	cp -rf ${S}/* ${D}/home/builder/.config/awesome
	chown -R builder:builder ${D}/home/builder/.config/awesome
	install -m 644 ${WORKDIR}/rc.lua ${D}/home/builder/.config/awesome/rc.lua
}

FILES_${PN} = "/home"

