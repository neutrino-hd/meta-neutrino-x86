SUMMARY = "Portable C library for multiline text editing"
HOMEPAGE = "http://projects.gnome.org/gtksourceview/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "gtk+ libxml2 intltool-native"

PNAME = "gtksourceview"

SRCREV = "${AUTOREV}"
PR = "1"

S = "${WORKDIR}/git"

inherit gnomebase lib_package gettext

# overrule SRC_URI from gnome.conf
SRC_URI = "git://github.com/GNOME/gtksourceview.git;branch=gnome-3-18;protocol=http \
           file://gtk-doc.make \
           file://suppress-string-format-literal-warning.patch \
"
SRC_URI[archive.md5sum] = "1219ad1694df136f126507466aeb41aa"
SRC_URI[archive.sha256sum] = "c585773743b1df8a04b1be7f7d90eecdf22681490d6810be54c81a7ae152191e"

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
    sed -i -e s:docs::g ${S}/Makefile.am
    echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
}

FILES_${PN} += " ${datadir}/gtksourceview-3.0"

