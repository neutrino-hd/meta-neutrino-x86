SUMMARY = "notify-osd - canonical notification daemon"
SECTION = "extras"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
DEPENDS = "dbus-glib-native libnotify libwnck3"


SRC_URI = "https://launchpad.net/notify-osd/precise/0.9.34/+download/notify-osd-0.9.34.tar.gz \
"

inherit autotools pkgconfig


SRC_URI[md5sum] = "18d9a95467daac570789fb7893011595"
SRC_URI[sha256sum] = "12080deeaa5e1e10b420117351c2bd5db3421b0d1efcab8ee8052c808c3aaa3c"

do_configure_prepend () {
    sed -i "s|GNOME_COMMON_INIT|#GNOME_COMMON_INIT|" ${S}/configure.in
    sed -i "s|GNOME_COMPILE_WARNINGS|#GNOME_COMPILE_WARNINGS|" ${S}/configure.in
}


FILES_${PN} += "/usr/share"
