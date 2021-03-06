DESCRIPTION = "YouTube Live Plugin"
LICENSE = "GPL-2.0"
MAINTAINER = "Jacek Jendrzej"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
HOMEPAGE = "http://www.dbox2world.net/board293-cst-coolstream/board313-cst-coolstream-downloads/board319-coolstream-plugins/p177078-youtubelive-0-2/#post177078"
DEPENDS = "lua"

S = "${WORKDIR}"

PR = "0.2"

SRC_URI = "file://YouTubeLive.lua \
	   file://YouTubeLive.cfg \
	   file://YouTubeLive_hint.png \
   	   file://ytlive.url \
"

do_install () {
	install -d ${D}/home/builder/.config/neutrino/plugins ${D}/home/builder/.config/neutrino/config
	install -m 644 ${S}/YouTubeLive.lua ${D}/home/builder/.config/neutrino/plugins
	install -m 644 ${S}/YouTubeLive.cfg ${D}/home/builder/.config/neutrino/plugins
	install -m 644 ${S}/YouTubeLive_hint.png ${D}/home/builder/.config/neutrino/plugins
	install -m 644 ${S}/ytlive.url ${D}/home/builder/.config/neutrino/config
}

FILES_${PN} += "/home \
"
