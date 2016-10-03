do_install_append() {
	sed -i "s:/home/root:/home/builder:; s:root:builder:; s:@BLANK_ARGS@:${BLANK_ARGS}:" \
        ${D}${sysconfdir}/default/xserver-nodm
}


