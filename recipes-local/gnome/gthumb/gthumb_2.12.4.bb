SUMMARY = "gThumb is an image viewer and browser for the GNOME Desktop"
SECTION = "x11/gnome"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
DEPENDS = "glib-2.0 gtk+ libxml2 gnome-doc-utils libunique gconf libpng gstreamer1.0 jpeg tiff gstreamer1.0-plugins-base intltool-native gconf-native"

PR = "r4"

EXTRA_OECONF = "--disable-gnome-keyring --disable-libsoup --disable-exiv2 --disable-clutter"

inherit gnome pkgconfig gconf

SRC_URI[archive.md5sum] = "97fc13221b0c5d80c27a2e25a3a3ac6f"
SRC_URI[archive.sha256sum] = "cf809695230ab8892a078be454a42ade865754c72ec1da7c3d74d4310de54f1d"
GNOME_COMPRESS_TYPE="bz2"

SRC_URI += "file://parallel.patch \
            file://0001-Drop-help-directory-from-build.patch"

do_configure_prepend () {
    rm -f ${S}/m4/gnome-doc-utils.m4
    sed -i "s|GNOME_MAINTAINER_MODE_DEFINES|#GNOME_MAINTAINER_MODE_DEFINES|" ${S}/configure.ac
    sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.ac
}

do_install_append () {
    rm -f ${D}${libdir}/${BPN}/extensions/*.a
}

FILES_${PN} += "${datadir}/icons"
FILES_${PN} += "${libdir}/${BPN}/extensions/*.so \
                ${libdir}/${BPN}/extensions/*.extension"
FILES_${PN}-dev += "${libdir}/${BPN}/extensions/*.la"
FILES_${PN}-dbg += "${libdir}/${BPN}/extensions/.debug/"

