SUMMARY = "IPTV Simple PVR"
HOMEPAGE = "https://github.com/kodi-pvr/pvr.iptvsimple"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://src/client.h;beginline=9;endline=22;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/kodi-pvr/pvr.iptvsimple.git;branch=Krypton"
SRCREV = "${AUTOREV}"
PV = "17.4"
FILESPATH =. "${FILE_DIRNAME}/kodi-addon-iptvsimple-files:"

inherit cmake

S = "${WORKDIR}/git"
DEPENDS = " \
  kodi \
  kodiplatform \
  p8-platform \
  zlib \
  "

EXTRA_OECMAKE_append = " \
  -DCMAKE_MODULE_PATH=${STAGING_DATADIR}/kodi/cmake \
  -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}${prefix} \
  -DKODI_INCLUDE_DIR=${STAGING_INCDIR}/kodi \
  "

FILES_SOLIBSDEV_append = " ${libdir}/kodi/addons/pvr.iptvsimple/pvr.iptvsimple${SOLIBSDEV}"
FILES_${PN}_append = " ${libdir}/kodi/addons/pvr.iptvsimple/* ${datadir}/kodi/addons/pvr.iptvsimple/*"
FILES_${PN}-dbg_append = " ${libdir}/kodi/addons/pvr.iptvsimple/.debug"
