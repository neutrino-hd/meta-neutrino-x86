SUMMARY = "dmenu2"
HOMEPAGE = "https://bitbucket.org/melek/dmenu2/downloads"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3568a5036184e6bc7672a7343fdee806"

inherit autotools-brokensep
SRC_URI = "https://bitbucket.org/melek/dmenu2/downloads/dmenu2-${PV}.tar.gz"

SRC_URI[md5sum] = "bc694c8b9fa3b8f6e7be8046d46e5bc5"
SRC_URI[sha256sum] = "b2d7ff5eccd0676942caa2f82cb9c6c6bbea8e5812e19fba9de97140ebc78597"

inherit autotools
