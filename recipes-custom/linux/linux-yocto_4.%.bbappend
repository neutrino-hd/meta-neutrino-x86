FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://vm_kvm.cfg \
	    file://config_task_io_accounting.cfg \
	    file://wlan.cfg \
	    file://dvb.cfg \
	    file://bluetooth.cfg \
	    file://gfx.cfg \
	    file://soundcard.cfg \
"

