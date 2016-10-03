SUMMARY = "makefile for local neutrino build"
DESCRIPTION = "build neutrino using make"
HOMEPAGE = "http://www.tuxbox.org"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit useradd

# builder user password is "builder"
BUILDER_PASSWORD ?= ".gLibiNXn0P12"
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --create-home \
                       --groups video,tty,audio \
                       --password ${BUILDER_PASSWORD} \
                       --user-group builder \
"

SRC_URI = " \
	file://local_build.tar \
"

PV = "1"
PR = "1"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/home/builder
	cp -R ${WORKDIR}/local_build ${D}/home/builder
	chown -R builder:builder ${D}/home/builder/local_build
}

FILES_${PN} = "/home/builder/local_build"

