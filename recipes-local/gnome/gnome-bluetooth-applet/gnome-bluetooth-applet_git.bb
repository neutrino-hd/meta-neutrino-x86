SUMMARY = "Gnome Bluetooth Applet"
DESCRIPTION = "gnome-bluetooth-applet is a fork of the Bluetooth applet code that was removed from gnome-bluetooth during the GNOME 3.8 release cycle along with the fallback mode."
LICENSE = "GPLv2.0+"
SECTION = "console/network"

LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "gtk+ glib-2.0 dbus json-glib libnotify libsoup-2.4 intltool-native gobject-introspection-native gnome-bluetooth"

inherit autotools pkgconfig gtk-doc gobject-introspection

SRC_URI = " \
    git://github.com/City-busz/gnome-bluetooth-applet.git;protocol=https \
"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"

do_configure_prepend () {
    sed -i "s|GNOME_COMMON_INIT|#GNOME_COMMON_INIT|" ${S}/configure.ac
    sed -i "s|GNOME_DEBUG_CHECK|#GNOME_DEBUG_CHECK|" ${S}/configure.ac
    sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.ac
}
