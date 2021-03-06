DESCRIPTION = "An archive manager for the GNOME environment"
LICENSE = "GPLv2 & LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "x11/gnome"
DEPENDS="gtk+ libgnomeui gnome-common gnome-vfs libglade libbonoboui gconf-native intltool-native nautilus libarchive"
RDEPENDS_${PN} = "unzip tar xz binutils unrar gzip bzip2"

SRC_URI_append += "file://dont_build_broken_doc.patch \
		   file://file-roller_ipk \
"

GNOME_COMPRESS_TYPE = "gz"

inherit gnome gobject-introspection gconf

do_install_append() {
	install -m 755 ${WORKDIR}/file-roller_ipk ${D}${bindir}
	sed -i "s|Exec=file-roller %U|Exec=file-roller_ipk|" ${D}/usr/share/applications/file-roller.desktop
}

FILES_${PN} += " \
                ${libdir}/nautilus/extensions-2.0 \
               "

FILES_${PN}-dbg += " \
                ${libdir}/nautilus/extensions-2.0/.debug \
                ${libexecdir}/file-roller/.debug \
               "

RDEPENDS_${PN} += "nautilus"

SRC_URI[archive.md5sum] = "1c542e629930762bb179e3feccd1a125"
SRC_URI[archive.sha256sum] = "f1e3c4efae8defbe33c2acc299979e0ce0d664d1e6cd282335e1f46c2f94d3d0"
