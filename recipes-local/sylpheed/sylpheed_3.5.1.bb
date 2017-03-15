SECTION = "x11/network"
SUMMARY = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls cairo pango libpng gdk-pixbuf glib-2.0 glib-2.0-native openssl"
RDEPENDS_${PN} = "sylpheed-doc"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4325afd396febcb659c36b49533135d4 \
                    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

PR = "r2"

SRC_URI = "http://sylpheed.sraoss.jp/sylpheed/v3.5/sylpheed-${PV}.tar.gz \
"

SRC_URI[md5sum] = "a93ded7120af2b96a6f9f41285a814fd"
SRC_URI[sha256sum] = "34c6dc6ab6104d685af0a2cdeb5dd8463944f11d35aa19e280042433f413cfb8"

FILES_${PN} += "${datadir}/pixmaps ${datadir}/applications"
FILES_${PN}-doc += "${datadir}"

CFLAGS += "-D_GNU_SOURCE"

do_configure_prepend() {
    mkdir -p m4
    for i in $(find ${S} -name "Makefile.am") ; do
        sed -i s:'-I$(includedir)'::g $i
    done
}

inherit autotools pkgconfig


