SUMMARY = "Logos for the video disk recorder"
HOMEPAGE = "https://github.com/3PO/Senderlogos"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/license;md5=17a6b3d5436a55985b200c725761907a"


SRC_URI = "git://github.com/MarkusVolk/liquid-logos4anthra.git;protocol=https \
           file://license \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"



do_install () {
  install -d ${D}/usr/share/icons/vdr
  install -m 0644 ${S}/*.png ${D}/usr/share/icons/vdr
}


FILES_${PN} += "/usr/share/icons/vdr"
