#!/bin/bash

if id "builder" >/dev/null 2>&1; then
        echo "user exists"
else
	# add user builder with password builder
	useradd -m -p .gLibiNXn0P12 -s /bin/bash builder
	# add builder into groups
	usermod -a -G users,audio,video,input,shutdown,disk,adm,plugdev,tty,systemd-journal builder
	# chown directories to builder
	chown -R builder:builder ${IMAGE_ROOTFS}/home/builder
	chown -R builder:builder ${IMAGE_ROOTFS}/usr/share/tuxbox
	chown -R builder:builder ${IMAGE_ROOTFS}/etc/neutrino
	chown -R builder:builder ${IMAGE_ROOTFS}/var/tuxbox
	chown -R builder:builder ${IMAGE_ROOTFS}/usr/local
fi

