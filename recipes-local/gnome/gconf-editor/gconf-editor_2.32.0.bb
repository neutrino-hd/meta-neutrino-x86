DESCRIPTION = "Editor for the gnome registry"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "gconf-native intltool-native polkit gconf gtk+ pango dbus-glib libxml2"

GNOME_COMPRESS_TYPE = "gz"
inherit gnome gconf gettext pkgconfig gobject-introspection

SRC_URI[archive.md5sum] = "aa3eeca77a6f873311531d35b26c30c7"
SRC_URI[archive.sha256sum] = "7a529deafc3952b78ff2cab43b50ca4d9e46966da87cfb92476f4f3cb232eefa"


do_configure_prepend() {
	ln -sf ${STAGING_DATADIR_NATIVE}/aclocal/* ${S}/m4
	rm ${S}/m4/gnome-doc-utils.m4 && touch ${S}/m4/gnome-doc-utils.m4
	sed -i -e s:docs::g ${S}/Makefile.am
}


EXTRA_OECONF = "--with-gtk=2.0"

FILES_${PN} += "${datadir}/icons"
