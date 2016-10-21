DESCRIPTION = "RAR archiver"
HOMEPAGE = "http://www.rarlab.com/"
LICENSE = "unRAR"
LIC_FILES_CHKSUM = "file://${WORKDIR}/unRAR;md5=261de2144caea81021822d80c54ddb8d"

PR = "r0"

SRC_URI = "http://www.rarlab.com/rar/unrarsrc-${PV}.tar.gz \
	   file://unRAR \
	   file://makefile.patch \
"

SRC_URI[md5sum] = "588b3fadc04eea7372cbfe98e4709aee"
SRC_URI[sha256sum] = "e470c584332422893fb52e049f2cbd99e24dc6c6da971008b4e2ae4284f8796c"


S = "${WORKDIR}/unrar"

inherit autotools-brokensep


do_compile() {
	make unrar
}

do_install() {
	install -d ${D}/usr/bin
	install -m 755 ${S}/unrar ${D}/usr/bin
}

BBCLASSEXTEND = "native"

FILES_${PN} = "/usr"

INSANE_SKIP_${PN} = "ldflags"

