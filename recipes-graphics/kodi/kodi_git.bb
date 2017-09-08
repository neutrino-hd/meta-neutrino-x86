include kodi.inc
FILESPATH =. "${FILE_DIRNAME}/files:"
SRC_URI_append = " file://0100-dlldvdnav-no-win32.patch \
  file://kodi.service \
  file://kodi.tar.gz \
  "

inherit cmake gettext pythonnative systemd
S = "${WORKDIR}/git"
OECMAKE_SOURCEPATH = "${S}/project/cmake"


DEPENDS = " \
  cmake-native \
  dbus \
  gperf-native \
  swig-native \
  texturepacker-native \
  jsonschemabuilder-native \
  virtual/libsdl-native \
  yasm-native \
  zip-native \
  alsa-lib \
  avahi \
  bzip2 \
  crossguid \
  curl \
  ffmpeg \
  freetype \
  fribidi \
  giflib \
  gnutls-native \
  jasper \
  jpeg \
  libass \
  libcec \
  libcdio \
  libdrm \
  libmicrohttpd \
  libmodplug \
  libnfs \
  libnss-mdns \
  libpcre \
  libpng \
  libtinyxml \
  libxml2 \
  libxslt \
  lzo \
  mpeg2dec \
  openssl \
  python \
  samba \
  sqlite3 \
  taglib \
  virtual/egl \
  yajl \
  zlib \
  ${@enable_glew(bb, d)} \
  "

PROVIDES = "xbmc"
PACKAGECONFIG ??= " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', ' x11', '', d)} opengl vaapi pulseaudio mysql vdpau"
PACKAGECONFIG_append_ion330 = " vdpau"

PACKAGECONFIG[opengl] = "-DENABLE_OPENGL=ON -DENABLE_OPENGLES=OFF,-DENABLE_OPENGL=OFF -DENABLE_OPENGLES=ON,virtual/libgl"
PACKAGECONFIG[openglesv2] = "-DENABLE_OPENGL=OFF -DENABLE_OPENGLES=ON,-DENABLE_OPENGL=ON -DENABLE_OPENGLES=OFF,virtual/egl"
PACKAGECONFIG[vaapi] = "-DENABLE_VAAPI=ON,-DENABLE_VAAPI=OFF,libva"
PACKAGECONFIG[vdpau] = "-DENABLE_VDPAU=ON,-DENABLE_VDPAU=OFF,libvdpau"
PACKAGECONFIG[mysql] = "-DENABLE_MYSQLCLIENT=ON,-DENABLE_MYSQLCIENT=OFF,mysql5"
PACKAGECONFIG[x11] = "-DENABLE_X11=ON,-DENABLE_X11=OFF,libxinerama libxmu libxrandr libxtst"
PACKAGECONFIG[pulseaudio] = "-DENABLE_PULSEAUDIO=ON,-DENABLE_PULSEAUDIO=OFF,pulseaudio"
PACKAGECONFIG[lcms] = "-DENABLE_LCMS2=ON,-DENABLE_LCMS2=OFF,lcms"



# To find Java
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"
#  -DWITH_ARCH=${TARGET_ARCH} \#

EXTRA_OECMAKE_append = " \
  -DNATIVEPREFIX=${STAGING_DIR_NATIVE}${prefix_native} \
  -DWITH_CPU=${TARGET_ARCH} \
  -DENABLE_DBUS=ON \
  -DENABLE_SDL=ON \
  -DENABLE_CEC=ON \
  -DENABLE_SSH=OFF \
  -DENABLE_SMBCLIENT=ON \
  -DENABLE_DVDCSS=OFF \
  -DENABLE_AVAHI=ON \
  -DENABLE_PLIST=OFF \
  -DENABLE_INTERNAL_FFMPEG=OFF \
  -DWITH_FFMPEG=${STAGING_EXECPREFIXDIR} \
  -DENABLE_INTERNAL_CROSSGUID=OFF \
  -DWITH_TEXTUREPACKER=${STAGING_BINDIR_NATIVE}TexturePacker \
  -DENABLE_LDGOLD=OFF \
  -DCMAKE_SHARED_LINKER_FLAGS:STRING="${OECMAKE_CXX_LINK_FLAGS}" \
  "

# for python modules
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
export PYTHON_DIR

def enable_glew(bb, d):
    if bb.utils.contains('PACKAGECONFIG', 'x11', True, False, d) and bb.utils.contains('DISTRO_FEATURES', 'opengl', True, False, d):
        return "glew"
    return ""

do_install_append() {
  install -d ${D}/home/builder
  cp -rf ${WORKDIR}/.kodi ${D}/home/builder
}

INSANE_SKIP_${PN} = "already-stripped"

FILES_${PN} += "${datadir}/xsessions ${datadir}/icons ${libdir}/xbmc ${datadir}/xbmc /home/builder"
FILES_${PN}-dbg += "${libdir}/kodi/.debug ${libdir}/kodi/*/.debug ${libdir}/kodi/*/*/.debug ${libdir}/kodi/*/*/*/.debug"


RDEPENDS_{PN} += "python-threading python-shell python-compression python-imaging mariadb"
RRECOMMENDS_${PN}_append = " \
  python \
  python-ctypes \
  python-lang \
  python-re \
  python-netclient \
  python-html \
  python-difflib \
  python-json \
  python-zlib \
  python-shell \
  python-sqlite3 \
  "
RRECOMMENDS_${PN}_append_libc-glibc = " glibc-charmap-utf-8 glibc-gconv-unicode glibc-gconv-utf-32"
RPROVIDES_${PN} += "xbmc"


