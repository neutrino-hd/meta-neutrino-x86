SUMMARY = "add users"
DESCRIPTION = "This recipe is using features from useradd.bbclass"
PR = "r1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


inherit extrausers useradd 

SRC_URI = " \
"

S = "${WORKDIR}"


EXTRA_USERS_PARAMS = "\
useradd -p '' builder; \
groupadd users; \
groupmod -g 1000 users; \
usermod -s /bin/sh builder; \
"

PACKAGES_${PN} += "${PN}"


USERADD_PACKAGES = "${PN}"

USERADD_PARAM_${PN} = "-u 1202 -d /home/builder -r -s /bin/bash -P 'builder' builder"

GROUPADD_PARAM_${PN} = "-g 1000 users"

GROUPMEMS_PARAM_${PN} = ""



INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
