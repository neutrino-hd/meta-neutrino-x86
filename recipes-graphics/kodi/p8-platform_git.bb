SUMMARY = "Platform support library used by libCEC and binary add-ons for Kodi"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/util/util.h;beginline=6;endline=18;md5=yyyy"
SRC_URI = "git://github.com/xbmc/xbmc.git;protocol=https;branch=Krypton \
"
SRCREV = "${AUTOREV}"
PV = "17.4"
PR = "r0"

FILESPATH =. "${FILE_DIRNAME}/p8-platform-files:"

inherit cmake
S = "${WORKDIR}/git"
DEPENDS = " \
  kodi \
  "
