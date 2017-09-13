SUMMARY = "Sublime Text is a sophisticated text editor for code, markup and prose"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://download.sublimetext.com/sublime_text_3_build_3143_x64.tar.bz2 \
	   file://license \
	   file://subl \
"


RDEPENDS_${PN} = "libx11 glib-2.0"

SRC_URI[md5sum] = "9c4a9d09a4463caedb49e7742bed369f"
SRC_URI[sha256sum] = "9ce120c4f28b239d3b3860ee672d9d87e1397a4c08ee6c4e62fd6e261a296519"

S = "${WORKDIR}/sublime_text_3"

PV = "3143"

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
