SUMMARY = "VDR VNSI PVR client addon for Kodi"
HOMEPAGE = "https://github.com/kodi-pvr/pvr.vdr.vnsi"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/client.h;beginline=6;endlinde=19;md5=da29eb1df037b49a928ddc6dd353385b"

SRC_URI = "git://github.com/kodi-pvr/pvr.vdr.vnsi.git;branch=Krypton"
SRCREV = "960f2d36124f7e4e4aeec7b59b2d3c7781a1b233"
PV = "17.1-git${SRCPV}"
FILESPATH =. "${FILE_DIRNAME}/kodi-addon-vnsi-files:"

inherit cmake

S = "${WORKDIR}/git"
DEPENDS = " \
  kodi \
  kodiplatform \
  "

PACKAGECONFIG ??= " opengl"
PACKAGECONFIG[opengl] = ",,virtual/libgl"
PACKAGECONFIG[openglesv2] = ",,virtual/egl"

EXTRA_OECMAKE_append = " \
  -DCMAKE_MODULE_PATH=${STAGING_DATADIR}/kodi/cmake \
  -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}${prefix} \
  -DKODI_INCLUDE_DIR=${STAGING_INCDIR}/kodi \
  "

FILES_SOLIBSDEV_append = " ${libdir}/kodi/addons/pvr.vdr.vnsi/pvr.vdr.vnsi${SOLIBSDEV}"
FILES_${PN}_append = " ${libdir}/kodi/addons/pvr.vdr.vnsi/* ${datadir}/kodi/addons/pvr.vdr.vnsi/*"
FILES_${PN}-dbg_append = " ${libdir}/kodi/addons/pvr.vdr.vnsi/.debug"
