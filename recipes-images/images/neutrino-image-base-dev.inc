inherit core-image module-base extrausers qemu-native

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

# Ensure there's enough space to do a core-image-sato build, with rm_work enabled
#IMAGE_ROOTFS_EXTRA_SPACE = "41943040"

# Do a quiet boot with limited console messages
APPEND += "rootfstype=ext4 quiet"

# include sources in download folder
BA_INCLUDE_SOURCES ??= "0"

IMAGE_CMD_ext4_append () {
	# We don't need to reserve much space for root, 0.5% is more than enough
	tune2fs -m 0.5 ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ext4
}

fakeroot do_populate_poky_src () {
	# Because fetch2's git's unpack uses -s cloneflag, the unpacked git repo
	# will become invalid in the target.
	rm -rf ${WORKDIR}/git/.git
	rm -f ${WORKDIR}/git/.gitignore
	mkdir -p ${IMAGE_ROOTFS}/home/builder/poky/build/conf
	mkdir -p ${IMAGE_ROOTFS}/home/builder/poky/build/downloads
	cp -R ${WORKDIR}/git ${IMAGE_ROOTFS}/home/builder/poky


	if [ ${BA_INCLUDE_SOURCES} != 0 ]; then
		cp -RpL ${DL_DIR}/* ${IMAGE_ROOTFS}/home/builder/poky/build/downloads/
		# Remove the git2_* tarballs -- this is ok since we still have the git2/.
		rm -rf ${IMAGE_ROOTFS}/home/builder/poky/build/downloads/git2_*
	fi


	# Create a symlink, needed for out-of-tree kernel modules build
	lnr ${IMAGE_ROOTFS}${KERNEL_SRC_PATH} ${IMAGE_ROOTFS}/lib/modules/${KERNEL_VERSION}/build

	echo "INHERIT += \"rm_work\"" >> ${IMAGE_ROOTFS}/home/builder/poky/build/conf/auto.conf

	# add mimeapp.list
	install -d ${IMAGE_ROOTFS}/home/builder/.config ${IMAGE_ROOTFS}/home/builder/.local/share/applications
	install -m 644 ${WORKDIR}/mimeapps.list ${IMAGE_ROOTFS}/home/builder/.config/mimeapps.list
	ln -s /home/builder/.config/mimeapps.list ${IMAGE_ROOTFS}/home/builder/.local/share/applications/mimeapps.list

	# Assume we will need CDROM to install guest additions
	mkdir -p ${IMAGE_ROOTFS}/media/cdrom

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
}

IMAGE_PREPROCESS_COMMAND += "do_populate_poky_src; "

addtask rootfs after do_unpack

python () {
	# Ensure we run these usually noexec tasks
	d.delVarFlag("do_fetch", "noexec")
	d.delVarFlag("do_unpack", "noexec")
}

INSANE_SKIP_${PN} = "host-user-contaminated"
