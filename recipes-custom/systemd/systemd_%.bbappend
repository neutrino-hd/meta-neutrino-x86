FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += " \
	file://getty@.service \
	file://00-create-volatile.conf \
"

do_install_append() {
	install -m0644 ${WORKDIR}/getty@.service ${D}/lib/systemd/system/getty@.service
	sed -i "s|slave|shared|" ${D}/lib/systemd/system/systemd-udevd.service
}

PACKAGECONFIG_append += "resolved"
