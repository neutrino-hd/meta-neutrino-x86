SUMMARY = "oracle jdk 8"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "http://ftp.heanet.ie/mirrors/funtoo/distfiles/oracle-java/jdk-${PV}-linux-x64.tar.gz \
	   file://license \
"

S = "${WORKDIR}/jdk1.8.0_144"

do_install() {
	install -d ${D}/usr
	cp -rf ${S}/* ${D}/usr
}

FILES_${PN} = "/usr \
"

RCONFLICTS_${PN} += "jre"

INSANE_SKIP_${PN} += "already-stripped build-deps libdir dev-so"

SRC_URI[md5sum] = "2d59a3add1f213cd249a67684d4aeb83"
SRC_URI[sha256sum] = "e8a341ce566f32c3d06f6d0f0eeea9a0f434f538d22af949ae58bc86f2eeaae4"


INSANE_SKIP_${PN} += "ldflags" 
BBCLASSEXTEND = "native"
