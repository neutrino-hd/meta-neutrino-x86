FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://20-intel.conf"

EXTRA_OECONF_append += "--enable-suid-wrapper"

do_install_append() {
	install -d ${D}/etc/X11/xorg.conf.d
	install -m 0644 ${WORKDIR}/20-intel.conf ${D}/etc/X11/xorg.conf.d/20-intel.conf
}

FILES_${PN}_append += " /usr/libexec"

PACKAGECONFIG_append += "xshmfence dri3 glamor xinerama"
