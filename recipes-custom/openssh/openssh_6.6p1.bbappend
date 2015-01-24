
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://sshd_config \
	    file://sshd_banner \
"

# no compile problems with uclibc here. therefore overriding default bb settings
EXTRA_OECONF_append_libc-uclibc=" --with-pam"

do_install_append () {
	install -m 0644 ${WORKDIR}/sshd_banner ${D}${sysconfdir}/ssh/sshd_banner
}

FILES_${PN}-sshd += "${sysconfdir}/ssh/sshd_banner"
