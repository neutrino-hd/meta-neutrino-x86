SUMMARY = "oracle jre 8"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "http://ftp.heanet.ie/mirrors/funtoo/distfiles/oracle-java/jdk-8u121-linux-x64.tar.gz \
	   file://license \
"

S = "${WORKDIR}/jdk1.8.0_121"

do_install() {
	install -d ${D}/usr
	cp -rf ${S}/jre/* ${D}/usr

}

FILES_${PN} = "/usr \
"
RCONFLICTS_${PN} += "jdk"

INSANE_SKIP_${PN} += "already-stripped build-deps libdir dev-so"

SRC_URI[md5sum] = "91972fb4e753f1b6674c2b952d974320"
SRC_URI[sha256sum] = "97e30203f1aef324a07c94d9d078f5d19bb6c50e638e4492722debca588210bc"



