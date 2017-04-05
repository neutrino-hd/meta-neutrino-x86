FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://10-monitor.conf"

EXTRA_OECONF_append += "--enable-suid-wrapper"

FILES_${PN}_append += " /usr/libexec"

PACKAGECONFIG_append += "xshmfence dri3 glamor xinerama"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/xorg.conf.d
	install -m 0644 ${WORKDIR}/10-monitor.conf ${D}/${sysconfdir}/X11/xorg.conf.d/10-monitor.conf
}
