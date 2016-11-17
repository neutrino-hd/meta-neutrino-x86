SUMMARY = "XSel -- manipulate the X selection"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
# FIXME: There are many more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "libx11"

SRC_URI = "git://github.com/kfish/xsel.git \
"

SRCREV = "${AUTOREV}"


S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend() {
	ln -sf ${S}/README.md ${S}/README
}
