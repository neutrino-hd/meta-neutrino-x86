SUMMARY = "neutrino meta layer"
DESCRIPTION = "include meta-neutrino into the image"
HOMEPAGE = "http://www.tuxbox.org"
SECTION = "libs"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-2-Clause;md5=8bef8e6712b1be5aa76af1ebde9d6378"

DEPENDS += "adduser"
RDEPENDS_${PN} += "bash"
SRC_URI = " \
	git://github.com/neutrino-hd/meta-neutrino-x86.git;branch=morty \
	file://bblayers.conf \
"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/home/builder/poky/git/meta-neutrino-x86 ${D}/home/builder/poky/git/build/conf
	tar cfv packed_layer.tar -C ${S} .
	tar -xf packed_layer.tar -C ${D}/home/builder/poky/git/meta-neutrino-x86
	install -m 644 ${YOCTO_BASEDIR}/meta-neutrino-x86/example/local.conf.sample ${D}/home/builder/poky/git/build/conf/local.conf
	install -m 644 ${WORKDIR}/bblayers.conf ${D}/home/builder/poky/git/build/conf/bblayers.conf
}

FILES_${PN} = "/home/builder/poky \
"

INSANE_SKIP_${PN} = "host-user-contaminated"
