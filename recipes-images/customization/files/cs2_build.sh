#!/bin/sh

if [ ! -d ~/yocto-downloads ];then
	mkdir ~/yocto-downloads
fi
if [ ! -d ~/yocto ];then
	mkdir ~/yocto
fi
cd ~/yocto
if [ ! -d poky ];then
	git clone -b morty git://git.yoctoproject.org/poky
fi
cd poky
if [ ! -d meta-neutrino ];then
		git clone -b morty https://github.com/neutrino-hd/meta-neutrino.git
else
	cd meta-neutrino && git checkout morty && git pull && cd ..
fi
if [ ! -d meta-coolstream ];then
	git clone -b morty https://github.com/neutrino-hd/meta-coolstream.git
	export TEMPLATECONF=meta-coolstream/example
else
	cd meta-coolstream && git checkout morty && git pull
fi 
cd ~/yocto/poky
. ./oe-init-build-env build-hd2 
