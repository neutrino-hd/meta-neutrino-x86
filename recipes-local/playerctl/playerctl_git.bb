SUMMARY = "playerct- mpris command-line controller and library for spotify, vlc, audacious, bmp, xmms2, and others"
SECTION = "audio/plugins"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

DEPENDS = "glib-2.0 gtk-doc gobject-introspection"

SRC_URI = "git://github.com/acrisci/playerctl.git;protocol=https \
	   file://0001-Makefile.am-fix.patch \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig gtk-doc gobject-introspection

EXTRA_OECONF += "--disable-introspection" 

do_compile_prepend () {
    export GIR_EXTRA_LIBS_PATH="${S}/playerctl/.libs"
}

FILES_${PN} = "/usr"




