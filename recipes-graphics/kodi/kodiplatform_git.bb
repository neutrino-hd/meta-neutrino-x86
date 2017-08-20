SUMMARY = "Kodi add-on platform support library"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/util/XMLUtils.h;beginline=7;endline=20;md5=96ab1f5a84ee13f38b9bd68028a7607f"
SRC_URI = "git://github.com/xbmc/kodi-platform.git;branch=master"
SRCREV = "36fb49371dbce49bf470a5bb1fc51b74b4a3612d"
PV = "17.1-git${SRCPV}"
FILESPATH =. "${FILE_DIRNAME}/kodiplatform-files:"

inherit cmake
S = "${WORKDIR}/git"
DEPENDS = " \
  kodi \
  libtinyxml \
  "
EXTRA_OECMAKE_append = " \
  -DCMAKE_MODULE_PATH=${STAGING_DATADIR}/kodi/cmake \
  -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}${prefix} \
  -DKODI_INCLUDE_DIR=${STAGING_INCDIR}/kodi \
  -DBUILD_SHARED_LIBS=1 \
  "
FILES_${PN}-dev += "${libdir}/kodiplatform/*"


do_install_append () {
  sed -i 's/-fdebug-prefix-map[^ ]*//g; s/--sysroot=[^ ]*//g; s/CXX=[^ ]*//g; s/CC=[^ ]*//g; s/DEPENDENCIES=.*/DEPENDENCIES=-lpthread -ltinyxml/g; s#-L${STAGING_DIR_TARGET}${libdir}##g' ${D}${libdir}/pkgconfig/*.pc
}

