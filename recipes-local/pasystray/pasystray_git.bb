SUMMARY = "pasystray - pulseaudio systray"
SECTION = "audio"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"
DEPENDS = "gtk+ pulseaudio gdk-pixbuf libnotify"
RDEPENDS_${PN} += "gdk-pixbuf-loader-ani gdk-pixbuf-loader-bmp gdk-pixbuf-loader-gif gdk-pixbuf-loader-icns \
	     gdk-pixbuf-loader-ico gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-png gdk-pixbuf-loader-pnm \
             gdk-pixbuf-loader-qtif gdk-pixbuf-loader-tga gdk-pixbuf-loader-xbm gdk-pixbuf-loader-xpm"

SRC_URI = "git://github.com/christophgysin/pasystray;protocol=https \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-gtk=2 \
"

FILES_${PN} = "/usr \
	       /etc \
"

