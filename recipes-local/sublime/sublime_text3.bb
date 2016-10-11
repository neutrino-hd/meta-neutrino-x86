SUMMARY = "Sublime Text is a sophisticated text editor for code, markup and prose"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://download.sublimetext.com/sublime_text_3_build_3126_x32.tar.bz2 \
	   file://license \
	   file://subl \
"


DEPENDS = "libx11 glib-2.0"

SRC_URI[md5sum] = "622247d2314d1f9f4babf8592150ed09"
SRC_URI[sha256sum] = "92ffefa470f0777897ed0dfb7c1635426105271da9b5affbe8c1e82039718e29"


S = "${WORKDIR}/sublime_text_3"

do_install() {
	install -d ${D}/usr/share/applications ${D}/usr/bin ${D}/opt/sublime_text
	cp -rf ${S}/* ${D}/opt/sublime_text
	chmod 755  ${D}/opt/sublime_text/sublime_text ${D}/opt/sublime_text/crash_reporter \
		   ${D}/opt/sublime_text/plugin_host ${D}/opt/sublime_text/sublime.py
	for i in 16x16 32x32 48x48 128x128 256x256;do
		install -d ${D}/usr/share/icons/hicolor/$i/apps
		cp -f ${S}/Icon/$i/* ${D}/usr/share/icons/hicolor/$i/apps
	done
	install -m 644 ${S}/sublime_text.desktop ${D}/usr/share/applications
	install -m 755 ${WORKDIR}/subl ${D}/usr/bin/subl
}

FILES_${PN} = "/usr \
	       /opt \
"

INSANE_SKIP_${PN}_append += "already-stripped"
