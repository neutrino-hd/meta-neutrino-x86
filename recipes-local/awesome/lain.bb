DESCRIPTION = "copycat lain"
HOMEPAGE = "https://github.com/copycat-killer/lain.git"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "lua5.2 awesome builder"
RDEPENDS_${PN} = "bash"


SRC_URI = "git://github.com/copycat-killer/lain.git \
"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"


do_install() {
	install -d ${D}/home/builder/.config/awesome/lain
	cp -rf ${S}/* ${D}/home/builder/.config/awesome/lain
	chown -R builder:builder ${D}/home/builder/.config/awesome/lain
}

FILES_${PN} = "/home"

