DESCRIPTION = "The image supports X11 with awesome wm, it aims at neutrino-mp developement and contains terminal, editor, file manager"

IMAGE_FEATURES += "splash package-management x11-base ssh-server-openssh hwcodecs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRCREV ?= "2679a347c576f5411fbe802d2f6201c94036ecb2"
SRC_URI = "git://git.yoctoproject.org/poky;branch=morty \
           file://Yocto_Build_Appliance.vmx \
           file://Yocto_Build_Appliance.vmxf \
	   file://mimeapps.list \
           file://README_VirtualBox_Guest_Additions.txt \
          "

include neutrino-image-base-dev.inc

DEPENDS = "zip-native builder"

IMAGE_FEATURES_append += " \
	dev-pkgs \
	tools-sdk \
	tools-debug \
	eclipse-debug \
	tools-profile \
	tools-testapps \
	debug-tweaks \
"

EXTRA_IMAGE_FEATURES_append = "dbg-pkgs \
			       ptest-pkgs \
"

IMAGE_INSTALL += " \
	${NEUTRINO_FLAVOUR} \
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
"

IMAGE_INSTALL_append += " \
	kernel-devsrc \
	glibc-locale \
	localedef \
	glibc-charmaps \
	glibc-localedata-de-de \
	glibc-localedata-translit-combining \
	neutrino-mp \
	vsftpd \
	pugixml \
	firmware \
	mc \
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
	awesome \
	sublime \
	nautilus \
	settings-daemon \
	shutdown-desktop \
	libsdl \
	sudo \
	connman-gnome \
	udev-extraconf \
	xf86-video-vmware \
	xf86-input-vmmouse \
	ntpdate \
	imagemagick \
	gthumb \
	deadbeef \
	mpv \
	xchat \
	gnupg \
	meld \
	tango-icon-theme \
	unrar \
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
"
