SUMMARY = "GTK+ applet for NetworkManager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "gtk+ libnotify libsecret networkmanager libgnome-keyring iso-codes intltool-native iso-codes"
RDEPENDS_${PN} =+ "networkmanager gnome-keyring"

SRC_URI = "git://github.com/jlindgren90/network-manager-applet-gtk2.git;protocol=https;branch=nma-1-0"

SRCREV = "${AUTOREV}"

inherit autotools gettext gconf gobject-introspection

S = "${WORKDIR}/git"

CFLAGS = "-Wno-error=misleading-indentation"

FILES_${PN} = "/usr \
	       /etc \
"
