SUMMARY = "Redshift - adjusts the color temperature of your screen according to your surroundings"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "intltool-native libxcb libx11 python-pyxdg"
RDEPENDS_${PN} = "python3-pygobject geoclue  "

SRC_URI = "git://github.com/jonls/redshift.git;protocol=https"

SRCREV = "${AUTOREV}"

inherit autotools gettext

S = "${WORKDIR}/git"

FILES_${PN} = "/usr"

