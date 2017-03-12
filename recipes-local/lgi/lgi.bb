

DESCRIPTION = "lgi"
HOMEPAGE = "https://github.com/pavouk/lgi.git "
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "imagemagick-native gobject-introspection glib-2.0 libffi lua5.2"

SRC_URI = "git://github.com/pavouk/lgi.git \
"

SRC_URI[md5sum] = "6733044b23ae21c902c26e51e52e5ab9"
SRC_URI[sha256sum] = "ea41f6ac258efea1db30be1cfcec6f10174e8e1fa0ef595ef73f63c3c20fb45b"



SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"

inherit autotools-brokensep

do_configure_prepend() {
	sed -i "s|%VERSION%-1|%VERSION%-2|" ${S}/rockspec.in
}

do_install_prepend() {
	find ${B}/. -type f -print0 | xargs -0 sed -i "s|5.1|5.2|"
	find ${B}/. -type f -print0 | xargs -0 sed -i "s|51|52|"
}

do_install() {
	make install PREFIX=/usr DESTDIR=${D}
}
		
FILES_${PN} = "/usr"

