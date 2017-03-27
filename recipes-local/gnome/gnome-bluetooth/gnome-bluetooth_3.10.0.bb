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

SRC_URI[archive.md5sum] = "c112cdca037f90168b04c0f12855006a"
SRC_URI[archive.sha256sum] = "7ee4ad464abfed59f04d1a471eb25cfb95fc34eeefbe4c47580dbb50df2ab712"


FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"
FILES_${PN}-dev += "/usr/lib/gnome-bluetooth/libgnome-bluetooth-applet.so"

EXTRA_OECONF += "--enable-documentation=no"

do_configure_prepend() {
	sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.ac
}

do_compile_prepend () {
	export GIR_EXTRA_LIBS_PATH="${B}/lib/.libs"
}
