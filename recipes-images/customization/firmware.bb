

SUMMARY = "linux firmware - taken from Ubuntu 16.04"
DESCRIPTION = ""
HOMEPAGE = ""
SECTION = "libs"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://license;md5=17a6b3d5436a55985b200c725761907a"


SRC_URI = "file://firmware.tar.gz \
	   file://license \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/lib/firmware
	install -m 0644 ${WORKDIR}/firmware/* ${D}/lib/firmware
}

FILES_${PN} += "/lib/firmware"

