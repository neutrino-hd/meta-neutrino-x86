do_install_append () {
	ln -sf ${bindir}/xrvt ${D}${bindir}/uxrvt
}
