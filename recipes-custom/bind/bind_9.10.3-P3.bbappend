do_configure_append() {
	sed -i -e "s,use diagnostics;,#use diagnostics;," ${S}/util/mksymtbl.pl
}

