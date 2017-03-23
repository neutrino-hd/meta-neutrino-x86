SUMMARY = "gsimplecal - a simple calender applet"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=239aae7512a946b36683c2e43dd39ae9"
SECTION = "x11/office"
DEPENDS = "gtk+ tango-icon-theme"

inherit autotools pkgconfig gtk-icon-cache gsettings gobject-introspection


SRC_URI += "git://github.com/dmedvinsky/gsimplecal.git;protocol=https \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--enable-gtk2"
