SUMMARY = "Open Source multimedia player"
DESCRIPTION = "mpv is a fork of mplayer2 and MPlayer. It shares some features with the former projects while introducing many more."
SECTION = "multimedia"
HOMEPAGE = "http://www.mpv.io/"
DEPENDS = "zlib ffmpeg jpeg virtual/libx11 xsp libxv samba libxrandr mesa libdrm \
           libxscrnsaver libxinerama v4l-utils libbluray pulseaudio \
"

REQUIRED_DISTRO_FEATURES = "x11"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91f1cb870c1cc2d31351a4d2595441cb"

SRC_URI = "https://github.com/mpv-player/mpv/archive/v${PV}.tar.gz;name=mpv \
           http://www.freehackers.org/~tnagy/release/waf-1.9.8;name=waf;subdir=${BPN}-${PV} \
	   file://mpv \
"
SRC_URI[mpv.md5sum] = "5c85d1163911e49315a5bf1ca1fae13d"
SRC_URI[mpv.sha256sum] = "a41854fa0ac35b9c309ad692aaee67c8d4495c3546f11cb4cdd0a124195d3f15"

SRC_URI[waf.md5sum] = "fbb646eafa430f959743010c85e269be"
SRC_URI[waf.sha256sum] = "167dc42bab6d5bd823b798af195420319cb5c9b571e00db7d83df2a0fe1f4dbf"

inherit waf pkgconfig pythonnative distro_features_check

# Note: both lua and libass are required to get on-screen-display (controls)
PACKAGECONFIG ??= "lua libass"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,lua luajit"
PACKAGECONFIG[libass] = "--enable-libass,--disable-libass,libass"
PACKAGECONFIG[libarchive] = "--enable-libarchive,--disable-libarchive,libarchive"
PACKAGECONFIG[jack] = "--enable-jack, --disable-jack, jack"

SIMPLE_TARGET_SYS = "${@'${TARGET_SYS}'.replace('${TARGET_VENDOR}', '')}"
EXTRA_OECONF = " \
    --prefix=${prefix} \
    --target=${SIMPLE_TARGET_SYS} \
    --confdir=${sysconfdir} \
    --datadir=${datadir} \
    --disable-manpage-build \
    --enable-libsmbclient \
    --disable-encoding \
    --enable-libbluray \
    --disable-dvdread \
    --disable-dvdnav \
    --disable-cdda \
    --disable-uchardet \
    --disable-rubberband \
    --disable-lcms2 \
    --disable-vapoursynth \
    --disable-vapoursynth-lazy \
    ${PACKAGECONFIG_CONFARGS} \
"

do_configure_prepend () {
    ln -sf waf-1.9.8 ${S}/waf
    chmod +x ${S}/waf
    sed -i "s|TryExec=mpv|TryExec=mpv_si|" ${S}/etc/mpv.desktop
    sed -i "s|Exec=mpv --profile=pseudo-gui -- %U|Exec=mpv_si|" ${S}/etc/mpv.desktop
}

do_install_append () {
	install -m 755 ${WORKDIR}/mpv ${D}${bindir}/mpv_si
}
FILES_${PN} += "${datadir}/icons"
