require samba.inc
require samba-basic.inc
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r7"

SRC_URI += "\
    file://config-h.patch \
    file://documentation.patch;patchdir=.. \
    file://documentation2.patch;patchdir=.. \
    file://fhs-filespaths.patch;patchdir=.. \
    file://installswat.sh.patch;patchdir=.. \
    file://pam-examples.patch;patchdir=.. \
    file://smbclient-pager.patch;patchdir=.. \
    file://undefined-symbols.patch;patchdir=.. \
    file://usershare.patch;patchdir=.. \
    file://smbtar-bashism.patch;patchdir=.. \
    file://dont-build-VFS-examples.patch;patchdir=.. \
    file://bug_221618_precise-64bit-prototype.patch;patchdir=.. \
    file://bug_598313_upstream_7499-nss_wins-dont-clobber-daemons-logs.patch;patchdir=.. \
    file://bug_387266_upstream_4104_mention-kerberos-in-smbspool-manpage.patch;patchdir=.. \
    file://bug_604768_upstream_7826_drop-using-samba-link.patch;patchdir=.. \
    file://bug_604768_upstream_7826_fix-WHATSNEW-link.patch;patchdir=.. \
    file://waf-as-source.patch;patchdir=.. \
    file://smbtorture-manpage.patch;patchdir=.. \
    file://libutil_drop_AI_ADDRCONFIG.patch;patchdir=.. \
    file://shadow_copy2_backport.patch;patchdir=.. \
    file://only_export_public_symbols.patch;patchdir=.. \
    file://configure-disable-getaddrinfo-cross.patch;patchdir=.. \
    file://configure-disable-core_pattern-cross-check.patch;patchdir=.. \
"
SRC_URI[md5sum] = "fbb245863eeef2fffe172df779a217be"
SRC_URI[sha256sum] = "4f5a171a8d902c6b4f822ed875c51eb8339196d9ccf0ecd7f6521c966b3514de"

S = "${WORKDIR}/samba-${PV}/source3"

EXTRA_OECONF += "\
	ac_cv_path_PYTHON=/not/exist \
	ac_cv_path_PYTHON_CONFIG=/not/exist \
	SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
	samba_cv_CC_NEGATIVE_ENUM_VALUES=yes \
	linux_getgrouplist_ok=no \
	samba_cv_HAVE_BROKEN_GETGROUPS=no \
	samba_cv_HAVE_FTRUNCATE_EXTEND=yes \
	samba_cv_have_setresuid=yes \
	samba_cv_have_setresgid=yes \
	samba_cv_HAVE_WRFILE_KEYTAB=yes \
	samba_cv_linux_getgrouplist_ok=yes \
	"

do_configure() {
	gnu-configize --force
	oe_runconf
}

do_compile () {
	base_do_compile
}

do_install_append() {
	rmdir "${D}${localstatedir}/lock"
	rmdir "${D}${localstatedir}/run"
	rmdir --ignore-fail-on-non-empty "${D}${localstatedir}"
}

pkg_postinst_${PN} () {
	if [ "x$D" != "x" ] ; then
		exit 1
	fi

	# create the samba user, and add user to group users
	username='smbuser'
	adduser --disabled-password $username
	# FIXME: use addgroup if busybox addgroup is ready
	sed -i -e "s/^users:.*/&${username}/g" /etc/group
	mkdir /home/${username}/smbdata
	chown -R smbuser:users /home/${username}/smbdata
}
