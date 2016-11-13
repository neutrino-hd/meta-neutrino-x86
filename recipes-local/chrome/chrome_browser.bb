SUMMARY = "Google Chrome"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_54.0.2840.100-1_amd64.deb \
	   file://license \
	   file://google-chrome-stable \
"

SRC_URI[md5sum] = "bdab2936bc4fc16f3a79651aa89a8128"
SRC_URI[sha256sum] = "89f0fc871ce19f68b9edfccd6eee1f81cc4b8f79b98a86a30296cf639bf28917"

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
