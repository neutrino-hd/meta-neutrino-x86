DESCRIPTION = "ConnMan management interface done in GTK+"
DEPENDS = "connman dbus gtk+3 glib-2.0 intltool-native gsettings-desktop-schemas"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit autotools pkgconfig

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/jgke/connman-gtk.git;protocol=https"

S = "${WORKDIR}/git/"

FILES_${PN} += "/usr/share"

pkg_postinst_connman-gtk() {
	/usr/bin/glib-compile-schemas /usr/share/glib-2.0/schemas
}
