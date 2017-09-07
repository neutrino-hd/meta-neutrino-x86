SUMMARY = "Google Chrome"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
	   file://license \
	   file://chrome.conf \
"

SRC_URI[md5sum] = "949b2e20ecfe0e77d3388f9f1c9a16ed"
SRC_URI[sha256sum] = "dc2b9ed36b1454c90675014f719dc23f3dfdf003a2a3552d0d066cc00c681c28"


do_unpack[depends] += "xz-native:do_populate_sysroot \ 
					   tar-native:do_populate_sysroot \
					   binutils-native:do_populate_sysroot \
"

RDEPENDS_${PN} += "cups"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/usr/bin ${D}/usr/share/applications ${D}/opt/google ${D}${sysconfdir}/tmpfiles.d
	cp -rf ${S}/opt/* ${D}/opt/
	cp -rf ${S}/usr/* ${D}/usr/
	cp -rf ${S}/chrome.conf ${D}${sysconfdir}/tmpfiles.d/chrome.conf
	ln -sf ./google-chrome-stable ${D}/usr/bin/google-chrome
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
