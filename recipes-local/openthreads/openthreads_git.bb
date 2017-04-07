
SUMMARY = "OpenThreads is a cross platform, object orientated threading library."
DESCRIPTION = "OpenThreads is a cross platform, object orientated threading library."
HOMEPAGE = "http://www.openscenegraph.org/"
SECTION = "libs"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=9226151d58bcdf987ed14e7dc8cedcbc \
"
DEPENDS = ""

SRCREV = "${AUTOREV}"


SRC_URI = "git://github.com/neutrino-hd/openthreads_svn14828.git;protocol=https \
           file://002-omit-policy-cmp0014.patch;pnum=0 \
"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release \
                  -DCMAKE_SYSTEM_NAME=Linux \
                  -D_OPENTHREADS_ATOMIC_USE_GCC_BUILTINS_EXITCODE=1 \
                  -D_OPENTHREADS_ATOMIC_USE_GCC_BUILTINS=1 \
"