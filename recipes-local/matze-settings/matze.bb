DESCRIPTION = "Matze Settings A+H 22.07.2016,Danke Matze"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://license;md5=17a6b3d5436a55985b200c725761907a"
HOMEPAGE = "http://matzesetting.brinkster.net/"

S = "${WORKDIR}"

PR = "r4"

SRC_URI = " \
        file://ubouquets.xml \
	file://services.xml \
	file://bouquets.xml \
	file://license \
"
do_install () {
	install -d ${D}/home/builder/.config/neutrino/config/zapit  
        install -D -m 644 ${WORKDIR}/*.xml ${D}/home/builder/.config/neutrino/config/zapit
}

FILES_${PN} = "\
    /home/builder/.config/neutrino/config/zapit/ubouquets.xml \
    /home/builder/.config/neutrino/config/zapit/services.xml \
    /home/builder/.config/neutrino/config/zapit/bouquets.xml \
"

SRC_URI[md5sum] = "3668a887329a101e0db795a058eb330c"
SRC_URI[sha256sum] = "db3a1bd5c069ba4da71362eb98d397e03998b596ffd1171077008a0767592e40"
