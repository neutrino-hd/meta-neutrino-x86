DESCRIPTION = "Image with Sato, a mobile environment and visual style for \
mobile devices. The image supports X11 with a Sato theme, Pimlico \
applications, and contains terminal, editor, and file manager."

IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-openssh hwcodecs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRCREV ?= "2679a347c576f5411fbe802d2f6201c94036ecb2"
SRC_URI = "git://git.yoctoproject.org/poky;branch=master \
           file://Yocto_Build_Appliance.vmx \
           file://Yocto_Build_Appliance.vmxf \
	   file://mimeapps.list \
           file://README_VirtualBox_Guest_Additions.txt \
          "

include neutrino-image-base-dev.inc

DEPENDS = "zip-native"

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
	xterm \
	xdg-utils \
	meld \
	subversion \
	epiphany \
	xarchiver \
	vim \
	include-meta-neutrino \
	local-build \
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
	multipath-tools \
	hplip \
	evince \
"

