DESCRIPTION = "The image supports X11 with awesome wm, it aims at neutrino-mp developement and contains terminal, editor, file manager"

IMAGE_FEATURES += "splash package-management x11-base ssh-server-openssh hwcodecs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRCREV ?= "fb1df184b96e0b5a29f330ba4fbf6555f9034eda"
SRC_URI = "git://git.yoctoproject.org/poky;branch=morty \
	   file://system-builder.conf \
           file://Yocto_Build_Appliance.vmx \
           file://Yocto_Build_Appliance.vmxf \
	   file://mimeapps.list \
           file://README_VirtualBox_Guest_Additions.txt \
          "

FILES_${PN} = "${sysconfdir}/dbus-1/system.d/system-builder.conf"


include neutrino-image-base-dev.inc 

IMAGE_FEATURES_append += "dev-pkgs tools-sdk" 

IMAGE_FEATURES_append += "${@'' if IMAGETYPE != 'debug' else 'tools-debug eclipse-debug tools-profile tools-testapps debug-tweaks'}"

EXTRA_FEATURES_append += "${@'' if IMAGETYPE != 'debug' else 'dbg-pkgs ptest-pkgs'}"


DEPENDS = "zip-native adduser"

do_install_append () {
    install -D -m 0644 ${WORKDIR}/system-builder.conf ${D}${sysconfdir}/dbus-1/system.d/system-builder.conf
}

IMAGE_INSTALL += " \
	${NEUTRINO_FLAVOUR} \
	neutrino-feed-config \
	neutrino-plugins \
	neutrino-plugin-xupnpd \
	neutrino-plugin-netzkino \
	neutrino-plugin-rss \
	neutrino-plugin-localtv \
	neutrino-plugin-buli \
	neutrino-plugin-wetter \
	neutrino-plugin-mtv \
	neutrino-plugin-mytvpro \
	neutrino-plugin-myspass \
	neutrino-plugin-mediathek \
	neutrino-plugin-youtube \
	neutrino-plugin-webtv \
	neutrino-plugin-rockpalast \
	neutrino-plugin-logo \
"

IMAGE_INSTALL_append += " \
	kernel-devsrc \
	localedef \
	glibc-locale \
	glibc-charmaps \
	glibc-localedata-de-de \
	glibc-localedata-en-us \
	glibc-localedata-translit-combining \
	vsftpd \
	pugixml \
	mc \
	ni-logos \
	bash \
	nano \
	git \
	samba \
	cmake \
	image-config \
	xdg-utils \
	subversion \
	xarchiver \
	vim \
	include-meta-neutrino \
	local-build \
	multipath-tools \
	evince \
	gparted \
	i3 \
	i3-status \
	dmenu \
	feh \
	rxvt-unicode \
	sublime \
	nautilus \
	settings-daemon \
	shutdown-desktop \
	libsdl \
	sudo \
	udev-extraconf \
	xf86-input-synaptics \
	xf86-video-vmware \
	xf86-input-vmmouse \
	xf86-video-modesetting \
	xf86-video-ati \
	xf86-video-nouveau \
	ntpdate \
	imagemagick \
	gthumb \
	deadbeef \
	mpv \
	xchat \
	gnupg \
	meld \
	minidlna \
	tango-icon-theme \
	unrar \
	sylpheed \
	chrome \
	texinfo \
	chrpath \
	libxml2-python \
	wget \
	cpio \
	coreutils \
	util-linux \
	gzip \
	socat \
	libsdl \
	wpa-supplicant \
	tzdata \
	minicom \
	pulseaudio-server \
	pavucontrol \
	pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluetooth-policy \
	pulseaudio-module-bluez5-device \
	pulseaudio-module-bluez5-discover \
	pasystray \
	screenfetch \
	polkit-gnome \
	inetutils-ftp \
	libsmbclient \
	cifs-utils \
	gvfsd-ftp \
	gvfs-bash-completion \
	gvfs-locale-de \
	parcellite \
	parcellite-locale-de \
	networkmanager \
	network-manager-applet \
	mobile-broadband-provider-info \
	modemmanager \
	usb-modeswitch \
"

IMAGE_INSTALL_append += " \
	python-core \
	python-textutils \
	python-sqlite3 \
	python-pickle \
	python-logging \
	python-curses \
	python-compile \
	python-fcntl \
	python-shell \
	python-misc \
	python-multiprocessing \
	python-subprocess \
	python-xmlrpc \
	python-netclient \
	python-netserver \
	python-distutils \
	python-unixadmin \
	python-compression \
	python-json \
	python-unittest \
	python-mmap \
	python-difflib \
	python-pprint \
	python-debugger \
	python-pkgutil \
	python-argparse \
	python-html \
	python-resource \
"

IMAGE_INSTALL_append += " \
	python3-core \
	python3-textutils \
	python3-sqlite3 \
	python3-pickle \
	python3-logging \
	python3-curses \
	python3-compile \
	python3-fcntl \
	python3-shell \
	python3-misc \
	python3-multiprocessing \
	python3-subprocess \
	python3-xmlrpc \
	python3-netclient \
	python3-netserver \
	python3-distutils \
	python3-unixadmin \
	python3-compression \
	python3-json \
	python3-unittest \
	python3-mmap \
	python3-difflib \
	python3-pprint \
	python3-debugger \
	python3-pkgutil \
	python3-pydoc \
	python3-resource \
	python3-html \
"
