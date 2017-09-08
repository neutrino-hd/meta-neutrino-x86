SUMMARY = "Kodi's Tvheadend HTSP client addon"
HOMEPAGE = "https://github.com/kodi-pvr/pvr.hts"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/client.h;beginline=6;endlinde=19;md5=yyy"

SRC_URI = "git://github.com/kodi-pvr/pvr.hts.git;branch=Krypton"
SRCREV = "${AUTOREV}"
PV = "3.4.22-git${SRCPV}"
FILESPATH =. "${FILE_DIRNAME}/kodi-addon-hts-files:"

inherit cmake

S = "${WORKDIR}/git"
DEPENDS = " \
  kodi \
  kodiplatform \
  p8-platform \
  "

EXTRA_OECMAKE_append = " \
  -DCMAKE_MODULE_PATH=${STAGING_DATADIR}/kodi/cmake \
  -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}${prefix} \
  -DKODI_INCLUDE_DIR=${STAGING_INCDIR}/kodi \
  "

FILES_SOLIBSDEV_append = " ${libdir}/kodi/addons/pvr.hts/pvr.hts${SOLIBSDEV}"
FILES_${PN}_append = " ${libdir}/kodi/addons/pvr.hts/* ${datadir}/kodi/addons/pvr.hts/*"
FILES_${PN}-dbg_append = " ${libdir}/kodi/addons/pvr.hts/.debug"
