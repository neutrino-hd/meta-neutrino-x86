DESCRIPTION = "A storage daemon that implements well-defined D-Bus interfaces that can be used to query and manipulate storage devices."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=73d83aebe7e4b62346afde80e0e94273"

DEPENDS = "libatasmart sg3-utils polkit libgudev dbus-glib dbus-glib-native glib-2.0 intltool-native lvm2 \
    dbus-glib-native libxslt-native parted packagekit \
"
# optional dependencies: device-mapper parted

DEPENDS += "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
"

SRC_URI = " \
    http://hal.freedesktop.org/releases/${BPN}-${PV}.tar.gz;name=${BPN} \
    file://optional-depends.patch \
    file://0001-fix-build-with-newer-glibc-versions.patch \
    file://dont_check_for_polkit_backend.patch \
    file://udisks.service \
"

SRC_URI[udisks.md5sum] = "f630eefa51b95d6485eb3246bc1bea9a"
SRC_URI[udisks.sha256sum] = "7dc1a150a6a31b2727144603fa5a8f9852696fc5bdc4a11917b9b0f1b8e3dcf1"


inherit autotools-brokensep systemd gtk-doc pkgconfig

PACKAGECONFIG ??= "parted"
PACKAGECONFIG[parted] = "--enable-parted,--disable-parted,parted"

EXTRA_OECONF = "--disable-man-pages --libdir=${base_libdir} --sbindir=${base_sbindir}"
EXTRA_OEMAKE = "udevrulesdir=${nonarch_base_libdir}/udev/rules.d/"

FILES_${PN} += "${libdir}/polkit-1/extensions/*.so \
                ${datadir}/dbus-1/ \
                ${datadir}/polkit-1 \
                ${nonarch_base_libdir}/udev/* \
		/run \
		/lib/polkit-1 \
"

FILES_${PN}-dbg += "${nonarch_base_libdir}/udev/.debug"

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"

