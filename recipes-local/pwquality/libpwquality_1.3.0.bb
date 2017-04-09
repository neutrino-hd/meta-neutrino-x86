SUMMARY = "libpwquality"
DESCRIPTION = "pwquality Linux-PAM module"


LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bd2f1386df813a459a0c34fde676fc2"

SRC_URI = "https://github.com/libpwquality/libpwquality/releases/download/libpwquality-1.3.0/libpwquality-1.3.0.tar.bz2"


DEPENDS = "libpam cracklib python3-native"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools-brokensep gettext pkgconfig


EXTRA_OECONF += "--disable-python-bindings"


SRC_URI[md5sum] = "2a3d4ba1d11b52b4f6a7f39622ebf736"
SRC_URI[sha256sum] = "74d2ea90e103323c1f2d6a6cc9617cdae6877573eddb31aaf31a40f354cc2d2a"

FILES_${PN} += "/usr/lib/security/pam_pwquality.so"

