FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://bluetooth.cfg \
	    file://config_task_io_accounting.cfg \
	    file://dvb.cfg \
  	    file://gfx.cfg \
	    file://soundcard.cfg \
	    file://usb_config.cfg \
	    file://vm_kvm.cfg \
	    file://wlan.cfg \
	    file://x86_dev.cfg \
	    file://pcmcia.cfg \
	    file://0001-dvb-usb-don-t-use-stack-for-firmware-load.patch \
"

