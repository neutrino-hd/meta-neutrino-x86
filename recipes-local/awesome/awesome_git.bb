DESCRIPTION = "awesome wm"
HOMEPAGE = "https://github.com/awesomeWM/awesome.git"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "imagemagick-native coreutils-native xcb-util xcb-util-cursor xcb-util-keysyms xcb-util-wm xdg-utils libxdg \
	   libx11 libxkbcommon libxcb cairo dbus-glib pango startup-notification gdk-pixbuf glib-2.0 lua5.2 adduser xrdb \
"

RDEPENDS_${PN} = "lgi bash awesome-copycat"

SRC_URI = "git://github.com/awesomeWM/awesome.git;branch=3.5 \
	   file://0001-disable-grep-test.patch \
"

SRCREV = "${AUTOREV}"
PV = "3.5"
PR = "1"

S = "${WORKDIR}/git"

LDFLAGS = "-lm -ldl"

inherit cmake

# lgi is only a runtime dependency. there is no need to have it inside sysroot ... disable the check 
do_configure_prepend() {
	echo "exit 0" > ${S}/build-utils/lgi-check.sh
}

FILES_${PN} = "/usr"

BBCLASS_EXTEND = "native"

