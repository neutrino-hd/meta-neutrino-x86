include kodi.inc
FILESPATH =. "${FILE_DIRNAME}/texturepacker-files:"

inherit cmake gettext pythonnative native
S = "${WORKDIR}/git"
OECMAKE_SOURCEPATH = "${S}/tools/depends/native/TexturePacker"
DEPENDS = " \
  lzo-native \
  libpng-native \
  giflib-native \
  libjpeg-turbo-native \
  "

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

EXTRA_OECMAKE_append = " \
  -DCORE_SOURCE_DIR=${S} \
"
CXXFLAGS_append = " -DTARGET_POSIX -std=c++0x -I${S}/xbmc/linux"

do_install() {
  install -m 0755 -d ${D}${bindir}
  install -m 0755 ${B}/TexturePacker ${D}${bindir}
}
