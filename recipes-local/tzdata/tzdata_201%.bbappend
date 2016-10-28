###
### fix up a few things in tzdata_2013i:
### * /etc/timezone is not marked as config file
### * /etc/localtime symlink is packaged and not marked as config file
###
### instead of packaging the symlink, create it in postinst
### (symlinks marked as config are converted to files during update,
### probably an opkg bug...)

CONFFILES_${PN} += " \
	${sysconfdir}/timezone \
	"

do_install_append () {
	# rather create in postinst than package it...
	rm ${D}${sysconfdir}/localtime
}

# set localtime
pkg_postinst_${PN}_append () {
		ln -sf /usr/share/zoneinfo/Europe/Paris /etc/localtime
	fi
}
