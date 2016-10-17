FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += " \
	file://getty@tty1.service \
"

do_install_append() {
	install -m 0644 -D ${WORKDIR}/getty@tty1.service        ${D}${sysconfdir}/systemd/system/getty.target.wants/getty@tty1.service
}

