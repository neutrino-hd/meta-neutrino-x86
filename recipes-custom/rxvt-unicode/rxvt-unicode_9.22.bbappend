do_configure_prepend() {    
	sed -i "s|tic|#tic|" ${S}/doc/Makefile.in
	sed -i "s|@TIC|#@TIC|" ${S}/doc/Makefile.in
}

do_install_append () {
	ln -sf ${bindir}/xrvt ${D}${bindir}/uxrvt
}

