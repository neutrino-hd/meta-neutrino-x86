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
	file://bash_profile \
	file://Xresources \
	file://Xdefaults \
	file://gtkrc \
	file://cs1_build \
	file://cs2_build \
	file://00-keyboard.conf \
	file://default.xmodmap \
	file://locale.conf \
	file://locale.sh \
	file://wallpaper.tar.gz \
"

DEPENDS += "adduser"

PR = "r1"

S = "${WORKDIR}"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
	install -d ${D}${sysconfdir}/systemd/system/getty.target.wants/ \
		   ${D}${bindir} ${D}${sysconfdir}/X11/xorg.conf.d ${D}${sysconfdir}/profile.d
	install -m 0644 -D ${S}/default.bootlogd ${D}${sysconfdir}/default/bootlogd 
	install -m 0644 -D ${S}/00aliases        ${D}${sysconfdir}/profile.d/00aliases
	install -m 0755 -D ${S}/cs1_build     ${D}${bindir}/cs1_build
	install -m 0755 -D ${S}/cs2_build     ${D}${bindir}/cs2_build
	install -m 0644 -D ${S}/00-keyboard.conf ${D}${sysconfdir}/X11/xorg.conf.d
	install -m 0755 -D ${S}/default.xmodmap ${D}${sysconfdir}/X11/default.xmodmap
	install -m 0755 -D ${S}/locale.sh ${D}${sysconfdir}/profile.d
	install -m 0755 -D ${S}/locale.conf ${D}${sysconfdir}
	for i in root builder;do
		install -d ${D}/home/$i/pictures ${D}/home/$i/movies ${D}/home/$i/audio \
		${D}/home/$i/documents ${D}/home/$i/.wallpaper
		install -m 0644 -D ${S}/bashrc        ${D}/home/$i/.bashrc
		install -m 0644 -D ${S}/xinitrc        ${D}/home/$i/.xinitrc
		install -m 0644 -D ${S}/bash_profile        ${D}/home/$i/.bash_profile
		install -m 0644 -D ${S}/Xresources        ${D}/home/$i/.Xresources
		install -m 0644 -D ${S}/Xdefaults        ${D}/home/$i/.Xdefaults
		install -m 0644 -D ${S}/gtkrc        ${D}/home/$i/.gtkrc-2.0
		install -m 0644 -D ${S}/*.jpg	${D}/home/$i/.wallpaper
		install -m 0644 -D ${S}/*.png	${D}/home/$i/.wallpaper
	done
}

CONFFILES_$PN = " \
	/etc/default/bootlogd \
"

FILES_${PN} +=" \
	/home \
"
