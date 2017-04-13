inherit core-image module-base setuptools3

NOHDD = "1"

# add default password for root
ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd;"
set_root_passwd() {
   ROOTPW_ENCRYPTED=""
   if [ -n "${ROOTPW}" ]; then
   ROOTPW_ENCRYPTED=`openssl passwd -crypt -quiet ${ROOTPW}`
   else
   ROOTPW_ENCRYPTED="wYNffsf6sozwE"
   fi
   sed "s%^root:[^:]*:%root:${ROOTPW_ENCRYPTED}:%" \
       < ${IMAGE_ROOTFS}/etc/shadow \
       > ${IMAGE_ROOTFS}/etc/shadow.new;
   mv ${IMAGE_ROOTFS}/etc/shadow.new ${IMAGE_ROOTFS}/etc/shadow ;
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Do a quiet boot with limited console messages
APPEND += "rootfstype=ext4 quiet"

IMAGE_CMD_ext4_append () {
	# We don't need to reserve much space for root, 0.5% is more than enough
	tune2fs -m 0.5 ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ext4
}

fakeroot do_populate_poky_src () {
	# Create a symlink, needed for out-of-tree kernel modules build
	lnr ${IMAGE_ROOTFS}${KERNEL_SRC_PATH} ${IMAGE_ROOTFS}/lib/modules/${KERNEL_VERSION}/build

	# Allow builder to use sudo
	echo "builder ALL=(ALL) NOPASSWD: ALL" >> ${IMAGE_ROOTFS}/etc/sudoers

	# Load tap/tun at startup
	ln -sr ${IMAGE_ROOTFS}/usr/sbin/iptables ${IMAGE_ROOTFS}/sbin/iptables
	echo "tun" >> ${IMAGE_ROOTFS}/etc/modules

	# Use Clearlooks GTK+ theme
	mkdir -p ${IMAGE_ROOTFS}/etc/gtk-2.0
	echo 'gtk-theme-name = "Clearlooks"' > ${IMAGE_ROOTFS}/etc/gtk-2.0/gtkrc

	# setuid loadkeys
	chmod u+s ${IMAGE_ROOTFS}/usr/bin/loadkeys

	# setuid Xorg
	chmod u+s ${IMAGE_ROOTFS}/usr/libexec/Xorg

	# set permissions
	chown -R builder:builder ${IMAGE_ROOTFS}/home/builder
	chown -R builder:builder ${IMAGE_ROOTFS}/usr/local
}

IMAGE_PREPROCESS_COMMAND += "do_populate_poky_src; "

addtask rootfs after do_unpack

python () {
	# Ensure we run these usually noexec tasks
	d.delVarFlag("do_fetch", "noexec")
	d.delVarFlag("do_unpack", "noexec")
}

INSANE_SKIP_${PN} = "host-user-contaminated"
