SUMMARY = "dmenu2"
HOMEPAGE = "https://bitbucket.org/melek/dmenu2/downloads"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3135ca77fe174d2ab0cd96bbb138a3a2"


SRC_URI = "git://git.suckless.org/dmenu;tag=4.1"

S = "${WORKDIR}/git"
SRCREV = "4.1"

DEPENDS = "libx11 libxinerama libxft"

inherit autotools-brokensep pkgconfig

do_configure_prepend () {
    sed -i "s|/local||" ${S}/config.mk
    sed -i "s|/usr/X11R6/include|/usr/include/X11|" ${S}/config.mk
    sed -i "s|/usr/X11R6/lib|/usr/lib/X11|" ${S}/config.mk
}

INSANE_SKIP_${PN} += "already-stripped"
