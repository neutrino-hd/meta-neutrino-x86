FILESEXTRAPATHS_prepend := "${THISDIR}/files:"


SRC_URI_append += " \
	file://default.xmodmap \
"


do_install_append() {
	install -m 0755 ${WORKDIR}/default.xmodmap ${D}${sysconfdir}/X11/default.xmodmap
}

