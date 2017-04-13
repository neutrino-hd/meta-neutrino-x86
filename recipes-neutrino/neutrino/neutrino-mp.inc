# configure stuff goes here
#
N_CFLAGS = "-Wall -Wextra -Wshadow -g -O2 -fno-strict-aliasing -rdynamic -DENABLE_FREESATEPG -DNEW_LIBCURL -I${S}/lib/libcoolstream2 -I${STAGING_INCDIR}/freetype2"

N_CXXFLAGS = "${N_CFLAGS}"

N_LDFLAGS += "-Wl,--hash-style=gnu -Wl,-rpath-link, ${STAGING_LIBDIR} -lcurl -ldl"
N_CPPFLAGS = "-DDYNAMIC_LUAPOSIX -D__KERNEL_STRICT_NAMES -D__STDC_CONSTANT_MACROS"


CPPFLAGS = "${N_CPPFLAGS}"

EXTRA_OECONF = " \
	--enable-maintainer-mode \
	--enable-silent-rules \
	--enable-mdev \
	--enable-upnp \
	--enable-giflib \
	--enable-flac \
	--with-boxtype=generic \
	--with-stb-hal-includes=${STAGING_INCDIR}/libstb-hal \
	--with-target=native \
	--prefix=/usr \
	--exec_prefix=/usr/bin \
	--includedir=${prefix}/include \
	--with-configdir=/home/builder/.config/neutrino/config \
"

