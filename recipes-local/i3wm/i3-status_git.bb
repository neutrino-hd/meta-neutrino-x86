DESCRIPTION = "i3 - improved tiling manager"
HOMEPAGE = "https://i3wm.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "i3 libconfuse libnl alsa-lib pulseaudio asciidoc-native"

SRC_URI = "git://github.com/i3/i3status.git;protocoll=https;branch=master \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig gettext autotools-brokensep

do_configure_prepend () {
    sed -i "s|i3status manpage|i3status|" ${S}/Makefile    
    sed	-i "s|install -m 644 man/i3status.1|#install -m 644 man/i3status.1|" ${S}/Makefile
}

