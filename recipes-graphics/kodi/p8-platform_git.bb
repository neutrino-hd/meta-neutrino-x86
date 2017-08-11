SUMMARY = "Platform support library used by libCEC and binary add-ons for Kodi"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/util/util.h;beginline=6;endline=18;md5=yyyy"
SRC_URI = "git://github.com/xbmc/platform.git;branch=master \
  file://0001-config-set-absolute-libdir.patch \
  "
SRCREV = "81c38cd885f822983dbf27b198239729bae13786"
PV = "17.1-git${SRCPV}"
FILESPATH =. "${FILE_DIRNAME}/p8-platform-files:"

inherit cmake
S = "${WORKDIR}/git"
DEPENDS = " \
  kodi \
  "
