SUMMARY = 'Customize stuff in the image without having to touch other packages'
LICENSE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit allarch

SRC_URI = " \
	file://COPYING.MIT \
	file://default.bootlogd \
	file://00aliases \
	file://bashrc \
	file://xinitrc \
	file://profile \
	file://Xresources \
	file://gtkrc \
"

DEPENDS += "builder"

PR = "r1"

S = "${WORKDIR}"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
	install -d ${D}/home/builder/pictures ${D}/home/builder/movies ${D}/home/builder/audio \
		${D}/home/builder/documents ${D}${sysconfdir}/systemd/system/getty.target.wants/
	install -m 0644 -D ${S}/default.bootlogd ${D}${sysconfdir}/default/bootlogd 
	install -m 0644 -D ${S}/00aliases        ${D}${sysconfdir}/profile.d/00aliases
	for i in root builder;do
		install -m 0644 -D ${S}/bashrc        ${D}/home/$i/.bashrc
		install -m 0644 -D ${S}/xinitrc        ${D}/home/$i/.xinitrc
		install -m 0644 -D ${S}/profile        ${D}/home/$i/.profile
		install -m 0644 -D ${S}/Xresources        ${D}/home/$i/.Xresources
		install -m 0644 -D ${S}/gtkrc        ${D}/home/$i/.gtkrc-2.0
	done
}

CONFFILES_$PN = " \
	/etc/default/bootlogd \
"

FILES_${PN} +=" \
	/home \
"
