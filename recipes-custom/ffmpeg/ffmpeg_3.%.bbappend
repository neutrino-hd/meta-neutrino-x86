FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS_append += "libroxml rtmpdump openssl virtual/libiconv"

SRC_URI_append += " \
		   file://0001-Revert-lavc-Switch-bitrate-to-64bit-unless-compatibi.patch;apply=no \
		   file://0002-add-HDS-ro_new.patch \
"

PACKAGECONFIG ??= "avdevice avfilter avcodec avformat swresample swscale bzlib gpl lzma libroxml librtmp libvorbis openssl theora x264 x11 xv"

PACKAGECONFIG[librtmp] = "--enable-librtmp,--disable-librtmp,rtmpdump"
PACKAGECONFIG[libroxml] = "--enable-libroxml,--disable-libroxml,libroxml"


