SECTION = "console/network"
DEPENDS = "ncurses gnutls gpgme"
DESCRIPTION = "Mutt is a small but very powerful text-based \
MIME mail client. It is highly configurable, and is well-suited \
to the mail power user with advanced features like key \
bindings, keyboard macros, mail threading, regular expression \
searches, and a powerful pattern matching language for selecting \
groups of messages."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
PR = "r2"

RDEPENDS_${PN} = "perl"

SRC_URI = "ftp://ftp.mutt.org/pub/mutt/mutt-${PV}.tar.gz \
	   file://dont_use_host_includes.patch \
"

S = "${WORKDIR}/mutt-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-gnutls \
"

CPPFLAGS = "-I${STAGING_INCDIR}"


SRC_URI[md5sum] = "04ae5b20cee7d746a246968e4a8cb9fa"
SRC_URI[sha256sum] = "e9c6f88e83d48690033f0d862a70293ac746286b77241554f5448bc23bd0d6df"

