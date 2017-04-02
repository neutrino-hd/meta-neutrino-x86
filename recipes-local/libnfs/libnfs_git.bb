SUMMARY = "libnfs - nfs library"
HOMEPAGE = "https://github.com/sahlberg/libnfs.git"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENCE-BSD.txt;md5=fc3e573fccd7ce0c86aa38b46a6414b3"


SRC_URI = "git://github.com/sahlberg/libnfs.git;protocol=https \
"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"

DEPENDS = ""


inherit autotools pkgconfig


