SUMMARY = "pasystray - pulseaudio systray"
SECTION = "audio"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"
DEPENDS = "gtk+ gtk+3 pulseaudio"

SRC_URI = "git://github.com/christophgysin/pasystray;protocol=https \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN} = "/usr \
	       /etc \
"

