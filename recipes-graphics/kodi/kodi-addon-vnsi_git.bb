SUMMARY = "Kodi Media Center PVR plugins"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/client.cpp;beginline=1;endline=19;md5=82e42788a0ee73e7556f60a02f794d38"

DEPENDS = " \
            zip-native \
            kodi \
            kodiplatform \
          "

SRCREV_pvrvnsi = "${AUTOREV}"

SRCREV_FORMAT = "pvrvnsi"

PV = "2.6.23+gitr${SRCPV}"
SRC_URI = "git://github.com/kodi-pvr/pvr.vdr.vnsi.git;branch=Krypton;destsuffix=pvr.vdr.vnsi;name=pvrvnsi \
          "
FILESPATH =. "${FILE_DIRNAME}/kodi-addon-vnsi-files:"

inherit cmake pkgconfig gettext

S = "${WORKDIR}/pvr.vdr.vnsi"

PACKAGECONFIG ??= " opengl"
PACKAGECONFIG[opengl] = ",,virtual/libgl"
PACKAGECONFIG[openglesv2] = ",,virtual/egl"

EXTRA_OECMAKE = " \
	  -DADDONS_TO_BUILD=pvr.vdr.vnsi \
	  -DADDON_SRC_PREFIX=${WORKDIR}/git \
	  -DCMAKE_BUILD_TYPE=Debug \
	  -DCMAKE_INSTALL_PREFIX=${datadir}/kodi/addons \
      -DCMAKE_MODULE_PATH=${STAGING_DATADIR}/kodi/cmake \
      -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}${prefix} \
      -DKODI_INCLUDE_DIR=${STAGING_INCDIR}/kodi \
      -DPACKAGE_ZIP=1 \
        "

do_compile_prepend() {
	sed -i -e 's:I/usr/include:I${STAGING_INCDIR}:g' \
	       -e 's:-pipe:${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} -pipe:g' \
	          ${B}/CMakeFiles/*/flags.make
	sed -i -e 's:-pipe:${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} -pipe:g'\
	          ${B}/CMakeFiles/*/link.txt
}

# Make zip package for manual installation
do_install_append() {
	install -d ${D}${datadir}/kodi/addons/packages/
	( cd ${D}${datadir}/kodi/addons
	  zip -r ${D}${datadir}/kodi/addons/packages/pvr.vdr.vnsi-${PV}.zip pvr.vdr.vnsi -x '*.debug*' )
}

# Doesn't get added automagically, dlopen()?
RDEPENDS_${PN} = "kodiplatform"

FILES_SOLIBSDEV_append = " ${datadir}/kodi/addons/pvr.vdr.vnsi/pvr.vdr.vnsi${SOLIBSDEV}"
FILES_${PN}_append = " ${libdir}/kodi/addons ${datadir}/kodi/addons"
FILES_${PN}-dbg_append = " ${libdir}/kodi/addons/pvr.vdr.vnsi/.debug"
