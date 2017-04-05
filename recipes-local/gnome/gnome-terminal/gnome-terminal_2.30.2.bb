SUMMARY = "GNOME Terminal"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=5b51eba4ba4cafe64073227530c061ed"
DEPENDS = "gtk+ glib-2.0 startup-notification dbus-glib vte9 gnome-doc-utils intltool-native gconf-native zlib-native libice"
RDEPENDS_${PN} = "termcap"
PR = "r1"

inherit gnome pkgconfig gconf

SRC_URI += " \
    file://0001-Makefile.am-do-not-build-help.patch \
"

EXTRA_OECONF += "--disable-scrollkeeper"

CFLAGS += "-lz -lICE"

SRC_URI[archive.md5sum] = "74c4528f00067072c2bd867d1f8fe844"
SRC_URI[archive.sha256sum] = "2c7af2250698b9f9f53c6eaa93211c1118cf2c7e29cbbacfd1e8a6a10069e07a"
GNOME_COMPRESS_TYPE="bz2"

RRECOMMENDS_${PN} += "gnome-common-schemas"

do_configure_prepend() {	
	sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.ac        
	sed -i "s|GNOME_COMMON_INIT|#GNOME_COMMON_INIT|" ${S}/configure.ac        
	sed -i "s|GNOME_MAINTAINER_MODE_DEFINES|#GNOME_MAINTAINER_MODE_DEFINES|" ${S}/configure.ac
}
