SUMMARY = "DeadBeef - The Ultimate Music Player"
SECTION = "audio/players"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
# FIXME: There are many more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "gtk+ ffmpeg jansson virtual/gettext curl libsamplerate0 libidn gnutls libmad gmp nettle intltool-native mpg123 faad2 wavpack"

RDEPENDS_${PN} = "deadbeef-mpris2-plugin"

SRC_URI = "git://github.com/Alexey-Yakovenko/deadbeef.git;branch=0.7 \
"

SRCREV = "${AUTOREV}"
PV = "0.7"

S = "${WORKDIR}/git"

inherit autotools pkgconfig gettext

EXTRA_OECONF += "--disable-gtk3 \
		 --enable-gtk2 \
"

FILES_${PN} += "/usr/share"

INSANE_SKIP_${PN} = "textrel"
