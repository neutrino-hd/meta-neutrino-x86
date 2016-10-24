SUMMARY = "makefile for local neutrino build"
DESCRIPTION = "build neutrino using make"
HOMEPAGE = "http://www.tuxbox.org"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"


SRC_URI = " \
	file://local_build.tar \
"

PV = "1"
PR = "1"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/home/builder ${D}/usr/local
	cp -R ${WORKDIR}/local_build ${D}/home/builder
}

FILES_${PN} = "/home/builder/local_build \
	       /usr/local \
"
INSANE_SKIP_${PN} = "host-user-contaminated"
