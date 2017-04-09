DESCRIPTION = "Vino is an integrated VNC server for GNOME."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = "gtk+3 libgnomeui libglade  esound dbus-glib libxml2 gnutls libnotify3 gnome-vfs avahi zlib libjpeg-turbo glib-2.0 glib-2.0-native intltool-native gconf-native"

inherit autotools-brokensep gnomebase gconf gsettings gobject-introspection pkgconfig

SRC_URI = "git://git.gnome.org/browse/vino;protocol=https;branch=gnome-3-20"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILES_${PN} += "/usr/share/dbus-1"




