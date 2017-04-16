SUMMARY = "Skype for linux"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://repo.skype.com/deb/pool/main/s/skypeforlinux/skypeforlinux_${PV}_amd64.deb \
		   file://license \
"

DEPENDS = "xz-native"

SRC_URI[md5sum] = "a43c8f03ad19ce9839a0576846184622"
SRC_URI[sha256sum] = "b412a1aa8c25d624e8778c81cc276fe61015f548015d459f92020b0b7a3068a3"



do_install() {
	cp -rf ${WORKDIR}/usr ${D}/usr
	cp -rf ${WORKDIR}/opt ${D}/opt
}

FILES_${PN} = "/usr \
	       /opt \
"

INSANE_SKIP_${PN}_append += "already-stripped build-deps libdir"
