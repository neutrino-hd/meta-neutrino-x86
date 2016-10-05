DESCRIPTION = "meld - compare and merge files"
HOMEPAGE = "https://github.com/GNOME/meld.git"
SECTION = "console/utils"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "python itstool-native"
RDEPENDS_${PN} = "python-core gtk+ python-pygobject"

SRCREV ?= "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

SRC_URI = "git://github.com/GNOME/meld.git;branch=meld-3-14;protocol=http \
"

S = "${WORKDIR}/git"


inherit distutils gobject-introspection

FILES_${PN} += "/usr/share"
