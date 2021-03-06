DESCRIPTION = "The image supports X11 with i3 wm, it aims at neutrino-mp developement"

IMAGE_FEATURES += "splash package-management x11-base dev-pkgs tools-sdk"
IMAGE_FEATURES_append += "${@'' if IMAGETYPE != 'debug' else 'tools-debug eclipse-debug tools-profile tools-testapps debug-tweaks dbg-pkgs ptest-pkgs'}"

LICENSE = "MIT"
LIC_FILES_CHKSUM  = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRCURI = "file://system-builder.conf \
"

FILES_${PN} = "${sysconfdir}/dbus-1/system.d/system-builder.conf"

include neutrino-image-base-dev.inc 

DEPENDS = "zip-native python3-pip-native glibc-locale qemuwrapper-cross"


do_install_append () {
    install -D -m 0644 ${WORKDIR}/system-builder.conf ${D}${sysconfdir}/dbus-1/system.d/system-builder.conf
}

IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    packagegroup-base \
    packagegroup-self-hosted \
    kernel-dev kernel-devsrc \
"

IMAGE_INSTALL_append += " \
	vdr \
	vdr-plugin-dvbapi \
	vdr-plugin-vnsiserver \
	kodi \
	kodi-addon-vnsi \
"

IMAGE_INSTALL_append += " \
	alsa-utils \
	bash \
	blueman \
	chrome \
	chrpath \
	cifs-utils \
	cmake \
	coreutils \
	cpio \
	deadbeef \
	dmenu \
	evince \
	exfat-utils \
	feh \
	file-roller \
	firmware \
	gcalctool \
	gconf-editor \
	gimp \
	git \
	glibc-charmaps \
	glibc-gconvs \
	glibc-localedatas \
	gnome-disk-utility \
	gnome-terminal \
	gnupg \
	gparted \
	gthumb \
	gvfs-bash-completion \
	gvfs-locale-de \
	gvfsd-ftp \
	gzip \
	i3 \
	i3-status \
	image-config \
	imagemagick \
	ir-keytable \
	inetutils-ftp \
	kernel-devsrc \
	libntfs-3g \
	libsdl \
	libsmbclient \
	libxml2-python \
	lirc \
	lirc-exec \
	lirc-plugins \
	local-build \
	localedef \
	mc \
	mediathekview \
	meld \
	minicom \
	minidlna \
	mobile-broadband-provider-info \
	modemmanager \
	mpv \
	multipath-tools \
	nano \
	nautilus \
	network-manager-applet-gtk2 \
	networkmanager \
	notify-osd \
	ntfs-3g \
	ntfsprogs \
	ntpdate \
	oscam \
	parcellite \
	parcellite-locale-de \
	pasystray \
	pavucontrol \
	perl-misc \
	perl-modules \
	polkit-gnome \
	procps \
	pugixml \
	pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluetooth-policy \
	pulseaudio-module-bluez5-device \
	pulseaudio-module-bluez5-discover \
	pulseaudio-server \
	pulseaudio-misc \
	python-modules \
	python3-modules \
	python3-pip \
	rc-keymaps \
	samba \
	screenfetch \
	settings-daemon \
	shutdown-desktop \
	skype \
	socat \
	sublime \
	subversion \
	sudo \
	sylpheed \
	tango-icon-theme \
	texinfo \
	tzdata \
	tzdata-europe \
	unclutter \
	unrar \
	upower \
	usb-modeswitch \
	util-linux \
	v86d \
	vim \
	vsftpd \
	wget \
	wpa-supplicant \
	xchat \
	xdg-utils \
	xf86-input-synaptics \
	xf86-input-vmmouse \
	xf86-video-ati \
	xf86-video-modesetting \
	xf86-video-nouveau \
	xf86-video-vmware \
"

IMAGE_INSTALL_append += " \
	python-argparse \
	python-compile \
	python-compression \
	python-core \
	python-curses \
	python-debugger \
	python-difflib \
	python-distutils \
	python-fcntl \
	python-html \
	python-json \
	python-logging \
	python-misc \
	python-mmap \
	python-multiprocessing \
	python-netclient \
	python-netserver \
	python-pickle \
	python-pkgutil \
	python-pprint \
	python-resource \
	python-shell \
	python-sqlite3 \
	python-subprocess \
	python-textutils \
	python-unittest \
	python-unixadmin \
	python-xmlrpc \
"

IMAGE_INSTALL_append += " \
	python3-compile \
	python3-compression \
	python3-core \
	python3-curses \
	python3-debugger \
	python3-difflib \
	python3-distutils \
	python3-fcntl \
	python3-html \
	python3-json \
	python3-logging \
	python3-misc \
	python3-mmap \
	python3-multiprocessing \
	python3-netclient \
	python3-netserver \
	python3-pickle \
	python3-pkgutil \
	python3-pprint \
	python3-pydoc \
	python3-resource \
	python3-shell \
	python3-sqlite3 \
	python3-unittest \
	python3-unixadmin \
	python3-xmlrpc \
"
