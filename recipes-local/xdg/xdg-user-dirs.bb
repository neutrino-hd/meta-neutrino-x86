DESCRIPTION = "xdg-user-dirs is a tool to help manage user directories like the desktop folder and the music folder"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://user-dirs.freedesktop.org/releases/xdg-user-dirs-0.15.tar.gz \
"

SRC_URI[md5sum] = "f5aaf5686ad7d8809a664bfb4566a54d"
SRC_URI[sha256sum] = "20b4a751f41d0554bce3e0ce5e8d934be98cc62d48f0b90a894c3e1916552786"

DEPENDS = " virtual/gettext"
PR = "r1"

S = "${WORKDIR}/xdg-user-dirs-0.15"

inherit autotools gettext


