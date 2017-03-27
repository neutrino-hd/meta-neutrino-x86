SUMMARY = "GTK+ applet for NetworkManager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "gtk+3 libnotify libsecret networkmanager dbus dbus-glib-native \
           gconf libgnome-keyring iso-codes nss modemmanager \
           intltool-native gconf-native \
"

inherit autotools gconf gsettings gtk-icon-cache gobject-introspection

SRC_URI = "git://github.com/NetworkManager/network-manager-applet.git;protocol=https"

SRC_REV = "${AUTOREV}"

PACKAGECONFIG[bluetooth] = "--with-gcr,--without-gcr,,gnome-bluetooth"
PACKAGECONFIG[modemmanager] = "--with-wwan,--without-wwan,ofono"
PACKAGECONFIG ??= "--with-wwan ofono"


do_configure_append() {
    # Sigh... --enable-compile-warnings=no doesn't actually turn off -Werror
    for i in $(find ${B} -name "Makefile") ; do
        sed -i -e s:-Werror::g $i
    done
}

RDEPENDS_${PN} =+ "networkmanager"

FILES_${PN}_append += "${datadir}"
FILES_${PN}-dev += "${libdir}/gnome-bluetooth/plugins/libnma.la"
FILES_${PN}-staticdev += "${libdir}/gnome-bluetooth/plugins/libnma.a"
FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"
