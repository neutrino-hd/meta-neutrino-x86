EXTRA_OECONF_append += "--enable-suid-wrapper"

FILES_${PN}_append += " /usr/libexec"

PACKAGECONFIG_append += "xshmfence dri3 glamor"
