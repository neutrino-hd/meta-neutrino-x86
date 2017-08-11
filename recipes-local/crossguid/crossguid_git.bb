SUMMARY = "minimal, cross platform, C++ GUID library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1373274bc8d8001edc54933919f36f68"

SRC_URI = "git://github.com/graeme-hill/crossguid;branch=master \
  "
SRCREV = "fef89a4174a7bf8cd99fa9154864ce9e8e3bf989"
PV = "1.0+git${SRCPV}"
PR = "r0"

S = "${WORKDIR}/git"

DEPENDS = "util-linux"

do_compile() {
  ${CXX} ${CXXFLAGS} -std=c++11 -c ${S}/guid.cpp -o ${B}/guid.o -DGUID_LIBUUID
  ${AR} rvs ${B}/libcrossguid.a ${B}/guid.o
}

do_install() {
  install -m 0755 -d ${D}${libdir} ${D}${includedir}
  install -m 0644 ${B}/libcrossguid.a ${D}${libdir}
  install -m 0644 ${B}/guid.h ${D}${includedir}
}
