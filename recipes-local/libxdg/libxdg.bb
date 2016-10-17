

DESCRIPTION = "awesome wm"
HOMEPAGE = "https://github.com/awesomeWM/awesome.git"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "imagemagick-native"

SRC_URI = "git://github.com/devnev/libxdg-basedir.git \
"

SRC_URI[md5sum] = "00ef1820feb4565562c78bebc9ed87c7"
SRC_URI[sha256sum] = "720b31d4ddf44ec56b518379c95438f622553a1804b8cfe252218149cd929c89"


SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"

inherit autotools
