
SUMMARY = "Add LuaJIT to rootfs"
HOMEPAGE = "http://luajit.org/index.html"
LICENSE = "MIT"
FILESEXTRAPATHS_prepend  := "${THISDIR}/${PN}:"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "http://luajit.org/download/LuaJIT-${PV}.tar.gz"

SRC_URI[md5sum] = "dd9c38307f2223a504cbfb96e477eca0"
SRC_URI[sha256sum] = "620fa4eb12375021bef6e4f237cbd2dd5d49e56beb414bee052c746beef1807d"


S = "${WORKDIR}/LuaJIT-${PV}"

inherit autotools-brokensep

BUILD_CC_ARCH_append_x86 = ' -m32'

INSANE_SKIP_${PN} = "already-stripped"

do_configure_prepend() {
	sed -i "s|/usr/local|/usr|" ${S}/Makefile
	sed -i "s|5.1|5.2|" ${S}/Makefile
}

FILES_${PN} += "/usr"


