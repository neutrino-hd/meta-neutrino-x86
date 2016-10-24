SUMMARY = "Sublime Text is a sophisticated text editor for code, markup and prose"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"

SRC_URI = "https://download.sublimetext.com/sublime_text_3_build_3126_x64.tar.bz2 \
	   file://license \
	   file://subl \
"


DEPENDS = "libx11 glib-2.0"

SRC_URI[md5sum] = "acc34252b0ea7dff1f581c5db1564dcb"
SRC_URI[sha256sum] = "18db132e9a305fa3129014b608628e06f9442f48d09cfe933b3b1a84dd18727a"



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
