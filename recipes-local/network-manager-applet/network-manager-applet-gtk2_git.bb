SUMMARY = "GTK+ applet for NetworkManager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "gtk+ gtk-doc libnotify libsecret networkmanager libgnome-keyring iso-codes intltool-native"
RDEPENDS_${PN} =+ "networkmanager gnome-keyring"

SRC_URI = "git://github.com/jlindgren90/network-manager-applet-gtk2.git;protocol=https;branch=nm-1-4"

SRCREV = "${AUTOREV}"

inherit autotools gconf gobject-introspection

S = "${WORKDIR}/git"

do_configure_prepend() {
	cp -rf ${STAGING_DATADIR}/gtk-doc/data/gtk-doc.make ${S}
}

FILES_${PN} = "/usr \
	       /etc \
"
