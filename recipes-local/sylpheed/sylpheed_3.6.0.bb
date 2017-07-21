SECTION = "x11/network"
SUMMARY = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls cairo pango libpng gdk-pixbuf glib-2.0 glib-2.0-native openssl"
RDEPENDS_${PN} = "sylpheed-doc"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4325afd396febcb659c36b49533135d4 \
                    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

PR = "r2"

SRC_URI = "http://sylpheed.sraoss.jp/sylpheed/v3.6/sylpheed-${PV}.tar.gz \
	   file://sylpheedrc \
"

SRC_URI[md5sum] = "7c2f7ea089b65b49c57080933779a405"
SRC_URI[sha256sum] = "126caae4188e41869966e43df8b948955d9555f58752c5576134ff2831b7fbaf"

FILES_${PN} += "${datadir}/pixmaps ${datadir}/applications /home/builder"
FILES_${PN}-doc += "${datadir}"

CFLAGS += "-D_GNU_SOURCE"

do_configure_prepend() {
    mkdir -p m4
    for i in $(find ${S} -name "Makefile.am") ; do
        sed -i s:'-I$(includedir)'::g $i
    done
}

do_install_append() {
    install -d ${D}/home/builder/.sylpheed-2.0
    install -m 644 ${WORKDIR}/sylpheedrc ${D}/home/builder/.sylpheed-2.0/sylpheedrc
}

inherit autotools pkgconfig


