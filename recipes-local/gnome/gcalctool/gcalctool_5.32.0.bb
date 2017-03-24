SUMMARY = "gcalctool is a powerful calculator"
SECTION = "x11"
DEPENDS = "gtk+ gnome-doc-utils gconf-native intltool-native"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SHRT_VER = "${@d.getVar('PV').split('.')[0]}.${@d.getVar('PV').split('.')[1]}"
SRC_URI = "http://download.gnome.org/sources/${BPN}/${SHRT_VER}/${BP}.tar.gz"

SRC_URI[md5sum] = "48db927c6e7ee1d5395f953a8c184c98"
SRC_URI[sha256sum] = "346f645c0fdef900642f6e9a2c18e7ba9a7ca9bc62fe2b08eb418f065a425c89"

inherit autotools pkgconfig gconf gobject-introspection gettext

EXTRA_OECONF = "--disable-scrollkeeper \
		--with-gtk=2.0 \
"

do_configure_prepend() {
    sed -i -e "s: help: :g" ${S}/Makefile.am
    rm -f ${S}/m4/gnome-doc-utils.m4
    sed -i "s|GNOME_MAINTAINER_MODE_DEFINES|#GNOME_MAINTAINER_MODE_DEFINES|" ${S}/configure.ac
    sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.ac
}

FILES_${PN} = "/usr"
