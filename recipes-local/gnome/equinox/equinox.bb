SUMMARY = "equinox gtk engine"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "gtk+"

inherit autotools pkgconfig gtk-icon-cache gsettings gobject-introspection


SRC_URI += "https://dl.opendesktop.org/api/files/download/id/1463004028/121881-equinox-1.50.tar.gz \
"

S = "${WORKDIR}/equinox-1.50"

SRC_URI[md5sum] = "f5ab68e50e128ee5186265b80d5cf1bd"
SRC_URI[sha256sum] = "0cf8b8cc841e0da7d4a08ab5a70d3bb330fd76bdcb03165a47aaddcd47e02227"

FILES_${PN} = "/usr \
"
