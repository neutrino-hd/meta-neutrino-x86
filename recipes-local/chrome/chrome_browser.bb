SUMMARY = "Google Chrome"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
	   file://license \
	   file://google-chrome-stable \
"

SRC_URI[md5sum] = "94fca0b7e96f2cce5d421ecebad04cbf"
SRC_URI[sha256sum] = "888ce70f3b1eeb90abdb53b3f81a14ca5db0bc71d611272f417238ad5cbd48e3"

DEPENDS = "xz-native xz"
RDEPENDS_${PN} += "cups"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/usr/bin ${D}/usr/share/applications
	cp -rf ${S}/opt/* ${D}/opt
	cp -rf ${S}/usr/share/applications/* ${D}/usr/share/applications 
	for i in 16 32 48 128 256;do
		x='x'
		install -d ${D}/usr/share/icons/hicolor/$i$x$i/apps
		cp -f ${S}/opt/google/chrome/product_logo_$i.png ${D}/usr/share/icons/hicolor/$i$x$i/apps/google-chrome.png
	done
	install -m 755 ${WORKDIR}/google-chrome-stable ${D}/usr/bin/google-chrome-stable
}

FILES_${PN} = "/usr \
	       /opt \
"

INSANE_SKIP_${PN}_append += "already-stripped ldflags build-deps file-rdeps"
