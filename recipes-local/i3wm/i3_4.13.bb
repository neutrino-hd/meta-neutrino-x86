DESCRIPTION = "i3 - improved tiling manager"
HOMEPAGE = "https://i3wm.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "libev libx11 libxcb xcb-util-xrm yajl xcb-util-wm xcb-util-cursor glib-2.0 libpcre pango libxkbcommon startup-notification cairo xcb-util-keysyms"

RDEPENDS_${PN} += "xwininfo xdotool xev xbacklight gsimplecal unclutter playerctl"

SRC_URI = "http://i3wm.org/downloads/i3-${PV}.tar.bz2 \
	   file://i3_config \
	   file://i3-get-window-criteria \
	   file://raise_or_run.sh \
	   file://toggle_touchpad.sh \
	   file://starter.sh \
"

SRC_URI[md5sum] = "08d17dcf1fde665a15f7d411486546ae"
SRC_URI[sha256sum] = "94c13183e527a984132a3b050c8bf629626502a6e133e07b413641aec5f8cf8a"

inherit pkgconfig autotools

do_install_append() {
	for i in root builder;do
		install -d ${D}/home/$i/.config/i3/scripts 
		install -m 0644 -D ${WORKDIR}/i3_config ${D}/home/$i/.config/i3/config
		install -m 0755 -D ${WORKDIR}/*_starter.sh ${D}/home/$i/.config/i3/scripts
	done
	install -m 0755 -D ${WORKDIR}/i3-get-window-criteria ${D}${bindir}
	install -m 0755 -D ${WORKDIR}/raise_or_run.sh ${D}${bindir}
	install -m 0755 -D ${WORKDIR}/toggle_touchpad.sh ${D}${bindir}
}

FILES_${PN}_append += "/usr/share/xsessions \
		       /home \
"

RDEPENDS_${PN} += "wmctrl bash"
