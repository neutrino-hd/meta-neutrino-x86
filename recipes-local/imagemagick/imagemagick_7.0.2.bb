SUMMARY = "ImageMagick is an image convertion tools"
SECTION = "console/utils"
LICENSE = "ImageMagick"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
# FIXME: There are many more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "lcms bzip2 jpeg libpng librsvg tiff zlib fftw freetype"

# Important note: tarballs for all patchsets within a version are deleted when
# a new pachset is created. To avoid multiple patches for each patchset, try to
# update to the last pachset of a version
PATCHSET = "10"
SRC_URI = "http://www.imagemagick.org/download/releases/ImageMagick-${PV}-${PATCHSET}.tar.xz \
"
SRC_URI[md5sum] = "e1cb23d9c10a8eff228ef30ee281711a"
SRC_URI[sha256sum] = "dad306bfd7730e1665c6fdb6eb478fb2c41e2db71ab56451bbaebe9df546b1d2"

S = "${WORKDIR}/ImageMagick-${PV}-${PATCHSET}"

inherit autotools pkgconfig update-alternatives

# xml disabled because it's using xml2-config --prefix to determine prefix which returns just /usr with our libxml2
# if someone needs xml support then fix it first
EXTRA_OECONF = "--program-prefix= --without-perl --disable-openmp --without-xml --disable-opencl"

CACHED_CONFIGUREVARS = "ac_cv_sys_file_offset_bits=yes"
PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}"
PACKAGECONFIG[graphviz] = "--with-gvc,--without-gvc,graphviz"
PACKAGECONFIG[jp2] = "--with-jp2,,jasper"
PACKAGECONFIG[lzma] = "--with-lzma,--without-lzma,xz"
PACKAGECONFIG[openjpeg] = "--with-openjp2,--without-openjp2,openjpeg"
PACKAGECONFIG[pango] = "--with-pango,--without-pango,pango cairo"
PACKAGECONFIG[webp] = "--with-webp,--without-webp,libwebp"
PACKAGECONFIG[wmf] = "--with-wmf,--without-wmf,libwmf"
PACKAGECONFIG[x11] = "--with-x,--without-x,virtual/libx11 libxext libxt"

FILES_${PN} += "${libdir}/ImageMagick-${PV}/modules-Q16/*/*.so \
                ${libdir}/ImageMagick-${PV}/modules-Q16/*/*.la \
                ${libdir}/ImageMagick-${PV}/modules-Q16/filters \
                ${libdir}/ImageMagick-${PV}/modules-Q16/coders \
                ${libdir}/ImageMagick-${PV}/config-Q16* \
                ${datadir}/ImageMagick-7 "

FILES_${PN}-dev += "${libdir}/ImageMagick-${PV}/modules-Q16/*/*.a"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${PV}/modules-Q16/*/.debug/*"

BBCLASSEXTEND = "native"

