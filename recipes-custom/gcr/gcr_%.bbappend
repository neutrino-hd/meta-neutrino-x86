do_install_append() {
	rm -rf ${D}/usr/share/GConf/gsettings/org.gnome.crypto.pgp.convert
	rm -rf ${D}/usr/share/glib-2.0
}
