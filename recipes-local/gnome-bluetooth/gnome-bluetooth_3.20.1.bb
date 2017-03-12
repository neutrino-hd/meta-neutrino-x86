SUMMARY = "GNOME bluetooth manager"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a \
                    file://COPYING.LIB;md5=a6f89e2100d9b6cdffcea4f398e37343 \
"

SECTION = "x11/gnome"

DEPENDS = "udev gtk+3 libnotify libcanberra intltool-native \
    ${@bb.utils.contains('DISTRO_FEATURES','bluez5','bluez5','bluez4',d)} \
"

inherit gnomebase gtk-icon-cache gobject-introspection

SRC_URI[archive.md5sum] = "0768931f17eaba8b05eddacf17204f60"
SRC_URI[archive.sha256sum] = "ea9050b5f3b94ef279febae4cb789c2500a25344c784f650fe7f932fcd6798fe"


FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"

do_configure_prepend() {
	sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.ac
}
