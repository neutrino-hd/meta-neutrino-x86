SUMMARY = "Icon theme"
SECTION = "icons"
HOMEPAGE = ""

DEPENDS += "gtk+ icon-naming-utils-native intltool-native imagemagick imagemagick-native gconf-native"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=b66026716fdf499434f80b11851a6cdd"

SRC_URI = "https://launchpad.net/ubuntu/+archive/primary/+files/tango-icon-theme_${PV}.orig.tar.gz \
	   file://configure.patch \
"

SRC_URI[md5sum] = "0795895d2f20eddcbd2bffe94ed431a6"
SRC_URI[sha256sum] = "6e98d8032d57d818acc907ec47e6a718851ff251ae7c29aafb868743eb65c88e"


S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig gettext gconf

do_configure_prepend() {
	sed -i "s|ICONMAP=|ICONMAP=${STAGING_LIBEXECDIR_NATIVE}/icon-name-mapping|" ${S}/configure.ac
}

FILES_${PN} = "/usr"

