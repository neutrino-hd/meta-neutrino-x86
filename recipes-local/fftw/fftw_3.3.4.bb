DESCRIPTION = "FFTW"
SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "http://www.fftw.org/fftw-${PV}.tar.gz"
SRC_URI[md5sum] = "2edab8c06b24feeb3b82bbb3ebf3e7b3"
SRC_URI[sha256sum] = "8f0cde90929bc05587c3368d2f15cd0530a60b8a9912a8e2979a72dbe5af0982"

inherit autotools pkgconfig

# we had multiple recipes in the past
PROVIDES = "fftwl fftwf"

EXTRA_OECONF = "--disable-fortran --enable-shared --enable-threads"

FFTW_NEON = "${@bb.utils.contains('TUNE_FEATURES', 'neon', '--enable-neon', '', d)}"
FFTW_NEON_class-native = ""



BBCLASSEXTEND = "native"
