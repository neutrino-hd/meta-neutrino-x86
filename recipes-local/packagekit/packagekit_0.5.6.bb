SUMMARY = "PackageKit package management abstraction"
SECTION = "libs"
LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = "gtk+ python polkit dbus dbus-glib dbus-glib-native glib-2.0 sqlite3 opkg intltool intltool-native"
RDEPENDS_${PN} = "opkg bash"

inherit gnome pythonnative python-dir gconf 

SRC_URI = "http://www.freedesktop.org/software/PackageKit/releases/PackageKit-${PV}.tar.bz2;name=archive \
           file://configurefix.patch \
           file://opkgfixes.patch \
           file://0001-Don-t-call-deprecated-glib-functions-and-use-the-new.patch \
          "

SRC_URI[archive.md5sum] = "33a3127e9ed41e26671786aee9fe56ff"
SRC_URI[archive.sha256sum] = "8dae41493dfb011442746d252b3435bf3204e17bf7c47e396f90fbd215260e14"

S = "${WORKDIR}/PackageKit-${PV}"

PACKAGECONFIG ??= ""
PACKAGECONFIG[service-packs] = "--enable-service-packs,--disable-service-packs,libarchive"

EXTRA_OECONF = "--with-security-framework=dummy \
                --disable-opkg \
                --disable-tests \
                --disable-ruck \
                --disable-qt \
                --disable-gstreamer-plugin \
                --disable-local  \
                --disable-networkmanager \
                --disable-device-rebind \
                ac_cv_path_XMLTO=no \
"

do_configure_append() {
    for i in $(find . -name Makefile) ; do
        sed -i -e s:${STAGING_DIR_NATIVE}::g \
               -e s:/usr/bin/intltool-merge:${STAGING_BINDIR_NATIVE}/intltool-merge:g \
               $i
    done
    # broken and unneeded
    sed -i "s|#!/bin/sh|exit 0|" ${S}/py-compile
}



PACKAGES =+ "${PN}-website"
PACKAGES =+ "${PN}-gtkmodule"

FILES_${PN} += "${libdir}/packagekit-backend/*.so ${libdir}/pm-utils ${datadir}/dbus-1/system-services/ ${datadir}/PolicyKit ${datadir}/PackageKit ${libdir}/python2.7"
FILES_${PN}-gtkmodule = "${libdir}/gtk-2.0/*/*.so"
FILES_${PN}-dbg += "${libdir}/packagekit-backend/.debug/*.so ${libdir}/gtk-2.0/*/.debug"
FILES_${PN}-dev += "${libdir}/packagekit-backend/*.la ${libdir}/gtk-2.0/*/*.la"
FILES_${PN}-staticdev += "${libdir}/packagekit-backend/*.a ${libdir}/gtk-2.0/*/*.a"
FILES_${PN}-website = "${datadir}/PackageKit/website"


