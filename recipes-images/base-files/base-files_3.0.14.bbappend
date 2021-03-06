FILESEXTRAPATHS_prepend := "${THISDIR}/base-files:"

SRC_URI += "file://profile \
	    file://inputrc \
	    file://nsswitch.conf \
	    file://environment \
"

inherit systemd

BASEFILESISSUEINSTALL = "do_custom_baseissueinstall"

do_custom_baseissueinstall() {
	do_install_basefilesissue
	install -m 644 ${WORKDIR}/issue*  ${D}${sysconfdir}
	printf " __  __         __         ___       __"				>> ${D}${sysconfdir}/issue
	printf " __  __         __         ___       __"				>> ${D}${sysconfdir}/issue.net
	printf "\n%s" ' \\ \\/ /__  ____/ /____    / _ \\___  / /____ __'		>> ${D}${sysconfdir}/issue
	printf "\n%s" ' \\ \\/ /__  ____/ /____    / _ \\___  / /____ __' 		>> ${D}${sysconfdir}/issue.net
	printf "\n%s" '  \\  / _ \\/ __/ __/ _ \\  / ___/ _ \\/  ´_/ // /' 		>> ${D}${sysconfdir}/issue
	printf "\n%s" '  \\  / _ \\/ __/ __/ _ \\  / ___/ _ \\/  ´_/ // /' 		>> ${D}${sysconfdir}/issue.net
	printf "\n%s" '  /_/\\___/\\__/\\__/\\___/ /_/   \\___/_/\\_\\\\_, /' 		>> ${D}${sysconfdir}/issue
	printf "\n%s" '  /_/\\___/\\__/\\__/\\___/ /_/   \\___/_/\\_\\\\_, /' 		>> ${D}${sysconfdir}/issue.net
	printf "\n%s" '                                       /___/'			>> ${D}${sysconfdir}/issue
	printf "\n%s" '                                       /___/'			>> ${D}${sysconfdir}/issue.net
	printf "\n\nNeutrino-HD image (based on Yocto ${DISTRO} ${DISTRO_VERSION})" 	>> ${D}${sysconfdir}/issue
	printf "\n\nNeutrino-HD image (based on Yocto ${DISTRO} ${DISTRO_VERSION}) " 	>> ${D}${sysconfdir}/issue.net
	echo "\n%s %m %r" 								>> ${D}${sysconfdir}/issue
	echo "\n%s %m %r" 								>> ${D}${sysconfdir}/issue.net
	echo "%d, %t" 									>> ${D}${sysconfdir}/issue
	echo "%d, %t" 									>> ${D}${sysconfdir}/issue.net
	printf "\\\n \\\l\n"								>> ${D}${sysconfdir}/issue
	echo >> ${D}${sysconfdir}/issue
	echo >> ${D}${sysconfdir}/issue.net
}


do_install_append () {
	install -d ${D}${localstatedir}/update ${D}${systemd_unitdir}/system/multi-user.target.wants
	install -d ${D}/srv/audio ${D}/srv/movies ${D}/srv/pictures
	install -m 644 ${S}/environment ${D}${sysconfdir}/environment
	ln -s /lib/systemd/system/adduser.service ${D}${systemd_unitdir}/system/multi-user.target.wants/adduser.service
	rm ${D}${sysconfdir}/skel/.profile
}
