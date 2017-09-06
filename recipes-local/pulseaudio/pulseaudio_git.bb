require pulseaudio.inc

SRC_URI = "git://anongit.freedesktop.org/git/pulseaudio/pulseaudio.git;branch=master;protocol=http \
           file://0001-client-conf-Add-allow-autospawn-for-root.patch \
           file://volatiles.04_pulse \
"

SRCREV = "${AUTOREV}"
PV = "10.99"

S = "${WORKDIR}/git"

do_configure_prepend() {
    mkdir -p ${S}/build-aux
    touch ${S}/build-aux/config.rpath  
}


do_compile_prepend() {
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}
