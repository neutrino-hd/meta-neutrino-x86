FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://00-keyboard.conf"

do_install_append() {
install -d ${D}${sysconfdir}/X11/xorg.conf.d
install -m 644 ${WORKDIR}/00-keyboard.conf ${D}${sysconfdir}/X11/xorg.conf.d
}


