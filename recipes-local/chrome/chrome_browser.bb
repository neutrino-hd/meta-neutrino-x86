SUMMARY = "Google Chrome"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
	   file://license \
"

SRC_URI[md5sum] = "52a4341475511d3627a86a344c0831ce"
SRC_URI[sha256sum] = "4a62a77b3c7960f9313d41a40f645b7178d6a8b91f9f1141d7664026692ef63d"

DEPENDS = "xz-native"
RDEPENDS_${PN} += "cups"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/usr/bin ${D}/usr/share/applications ${D}/opt/google
	cp -rf ${S}/opt/* ${D}/opt/
	cp -rf ${S}/usr/* ${D}/usr/
	cp -rf ${S}/etc/* ${D}${sysconfdir}
	for i in 16 32 48 128 256;do
		x='x'
		install -d ${D}/usr/share/icons/hicolor/$i$x$i/apps
		cp -f ${S}/opt/google/chrome/product_logo_$i.png ${D}/usr/share/icons/hicolor/$i$x$i/apps/google-chrome.png
	done
}

FILES_${PN} = "/usr \
	       /opt \
	       /etc \
"

INSANE_SKIP_${PN}_append += "already-stripped ldflags build-deps file-rdeps"
