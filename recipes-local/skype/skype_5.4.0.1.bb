SUMMARY = "Skype for linux"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://repo.skype.com/deb/pool/main/s/skypeforlinux/skypeforlinux_${PV}_amd64.deb \
		   file://license \
"

DEPENDS = "xz-native"

SRC_URI[md5sum] = "82dd3d59fde84c4e5b62d69208d8879c"
SRC_URI[sha256sum] = "1f31c0e9379f680f2ae2b4db3789e936627459fe0677306895a7fa096c7db2c5"


do_install() {
	cp -rf ${WORKDIR}/usr ${D}/usr
	cp -rf ${WORKDIR}/opt ${D}/opt
}

FILES_${PN} = "/usr \
	       /opt \
"

INSANE_SKIP_${PN}_append += "already-stripped build-deps libdir"
