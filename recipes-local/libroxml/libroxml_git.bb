DESCRIPTION = "Small, fast and powerful xml library"
AUTHOR = "Tristan Lelong <tristan.lelong@libroxml.net>"
HOMEPAGE = "http://www.libroxml.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"


SRC_URI = "git://github.com/blunderer/libroxml.git;protocol=git"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
inherit cmake

EXTRA_OECMAKE = " \ 
	-DCONFIG_XML_READ_WRITE=0 \
	-DCONFIG_XML_SMALL_INPUT_FILE=1 \
	-DCONFIG_XML_COMMIT_XML_TREE=0 \
	-DCONFIG_XML_XPATH_ENGINE=0 \
"

PACKAGES =+ "roxml roxml-dbg"
FILES_roxml = "${bindir}/*"
FILES_roxml-dbg = "${bindir}/.debug/*"



