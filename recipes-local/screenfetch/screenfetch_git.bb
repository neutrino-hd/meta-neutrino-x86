SUMMARY = "screenfetch - fetch system information"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/KittyKatt/screenFetch.git;protocol=http \
"

SRCREV = "${AUTOREV}"


S = "${WORKDIR}/git"


do_install() {
	install -d ${D}/usr/bin
	install -m 755 ${S}/screenfetch-dev ${D}/usr/bin/screenfetch
}

SRC_URI[md5sum] = "d7935040ee244fa93b84812e7274a4c3"
SRC_URI[sha256sum] = "60bd7b2a2cea1526768cf067814ab4fe41e8d6087c99628db6777b5f00e50d32"
