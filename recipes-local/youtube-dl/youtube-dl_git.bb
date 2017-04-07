SUMMARY = "youtube-dl"
DESCRIPTION = "download videos from youtube or other video platforms"
SECTION = "multimedia"
HOMEPAGE = "https://github.com/rg3/youtube-dl.git"
DEPENDS = "zip-native \
"

LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

SRC_URI = "git://github.com/rg3/youtube-dl.git;protocol=https \
"

SRCREV = "${AUTOREV}"

inherit autotools-brokensep pkgconfig

S = "${WORKDIR}/git"

do_configure_prepend() {
    sed -i "s|PREFIX ?= /usr/local|PREFIX ?= /usr|" ${S}/Makefile
    sed -i "s|pandoc|#pandoc|" ${S}/Makefile
    sed -i "s|install -m 644 youtube-dl.1|#install -m 644 youtube-dl.1|" ${S}/Makefile
}

FILES_${PN} = "/usr \
               /etc \
"
