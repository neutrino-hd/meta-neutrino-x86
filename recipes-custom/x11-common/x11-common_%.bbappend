FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://00-keyboard.conf \
		   file://default.xmodmap \
"

do_install_append() {
install -d ${D}${sysconfdir}/X11/xorg.conf.d
install -m 644 ${WORKDIR}/00-keyboard.conf ${D}${sysconfdir}/X11/xorg.conf.d
install -m 0755 ${WORKDIR}/default.xmodmap ${D}${sysconfdir}/X11/default.xmodmap
}

RDEPENDS_${PN} = "dbus-x11 xmodmap xdpyinfo formfactor"
