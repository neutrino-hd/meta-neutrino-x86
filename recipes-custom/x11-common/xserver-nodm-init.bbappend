FILESEXTRAPATHS_prepend := "${THISDIR}/xserver-nodm-init:"

SRC_URI_append += "file://xserver-nodm.service \
"

do_install_append() {
	sed -i "s:/home/root:/home/builder:; s:root:builder:; s:@BLANK_ARGS@:${BLANK_ARGS}:" \
        ${D}${sysconfdir}/default/xserver-nodm
	install -m 644 ${WORKDIR}/xserver-nodm.service ${D}/lib/systemd/system/xserver-nodm.service
}

