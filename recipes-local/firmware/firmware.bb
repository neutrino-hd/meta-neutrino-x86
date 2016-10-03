
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://dvb-usb-SkyStar_USB_HD_FW_v17_63.HEX.fw \
"
	
do_install () {
	install -d ${D}${base_libdir}/firmware
	install -m 644 ${WORKDIR}/dvb-usb-SkyStar_USB_HD_FW_v17_63.HEX.fw ${D}${base_libdir}/firmware/dvb-usb-SkyStar_USB_HD_FW_v17_63.HEX.fw
}

FILES_${PN} = "/lib/firmware"

