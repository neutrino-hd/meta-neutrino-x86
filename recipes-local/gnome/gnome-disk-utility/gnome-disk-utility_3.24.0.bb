SUMMARY = "GNOME disk utility"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "glib-2.0 gtk+3 libnotify libsecret xz udisks2 \
    virtual/libx11 intltool-native systemd libxslt-native \
    libpwquality libcanberra libdvdread gnome-doc-utils \
"

RDEPENDS_${PN} = "libdvdread"

inherit gnomebase gtk-icon-cache distro_features_check pkgconfig gettext gsettings

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI += "file://Makefile_am.patch \
"

SRC_URI[archive.md5sum] = "bf31db0fa2a79a58c254aab95d825752"
SRC_URI[archive.sha256sum] = "c5f8b1d8aad3136353e4ad4f33c7635bcb563b1adce59d3338202e260a7f3cf3"

GNOME_COMPRESS_TYPE="xz"

EXTRA_OECONF += "--disable-gsd-plugin"

do_configure_prepend() {
	rm -r ${S}/doc/Makefile.am && touch ${S}/doc/Makefile.am
}

FILES_${PN} = "/usr"
