SUMMARY = "VDR skindesigner plugin"
LICENSE = "GPLv2" 
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"


SRC_URI = "git://projects.vdr-developer.org/git/vdr-plugin-skindesigner.git;protocol=http;name=skindesigner \
		   git://github.com/tomsax56/shady.git;protocol=https;name=shady;destsuffix=git/skins/shady \
		   file://0001-fix-Makefile.patch \	
"

SRCREV_skindesigner = "${AUTOREV}"
SRCREV_shady = "${AUTOREV}"

inherit pkgconfig gettext autotools-brokensep

S = "${WORKDIR}/git"

DEPENDS = " \
	cairo \
	librsvg \
	libxml2 \
	jpeg \
	libpng  \
	curl \
	font-opensans \
	vdr \
"

RDEPENDS_${PN} += "bash"

EXTRA_OEMAKE = ' SDKSTAGE="${STAGING_DIR_HOST}" '
TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	oe_runmake DESTDIR=${D} PREFIX=${prefix} install	
	install -d ${D}/usr/share/fonts
	install -m 0755 ${S}/fonts/VDROpenSans/* ${D}/usr/share/fonts
	install -m 0644 ${S}/skins/shady/themes/default/shady-default.theme ${D}${sysconfdir}/vdr/themes/shady-default.theme
}

FILES_${PN} = " \
	${sysconfdir}/vdr \
	${libdir}/libskindesignerapi* \
	${libdir}/vdr/* \
	${datadir}/vdr/plugins/skindesigner/* \
	${datadir}/fonts \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
