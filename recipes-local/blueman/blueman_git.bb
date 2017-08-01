DESCRIPTION = "blueman - a bluetooth manager"
HOMEPAGE = "https://github.com/blueman-project/blueman"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

DEPENDS = "intltool-native bluez5 python3-cython-native gtk+3 python3-dbus python3 python3-native intltool \
           startup-notification polkit gettext pulseaudio python3-pygobject nautilus \
"
RDEPENDS_${PN} = "python3-dbus python3 \
		  dbus bluez5 obex-data-server \
"

SRC_URI = "git://github.com/blueman-project/blueman.git;protocol=https;branch=master \
"
SRCREV = "5aaba8219680b74673e99139c3cb5c319df85dc8"

S = "${WORKDIR}/git"

inherit pkgconfig autotools python3-dir gconf gobject-introspection gsettings

EXTRA_OECONF += "--disable-runtime-deps-check \
		 --enable-polkit \
		 --enable-nautilus-sendto \
		 --with-systemdunitdir=${systemd_unitdir}/system/ \
"

FILES_${PN} = "/usr \
	       /lib \
	       /etc \
"
