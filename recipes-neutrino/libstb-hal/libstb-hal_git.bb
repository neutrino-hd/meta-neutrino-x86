##
##

SUMMARY = "Library to abstract STB hardware. Supports Tripledragon, AZbox ME, Fulan Spark boxes as well as generic PC hardware and the Raspberry Pi right now."
DESCRIPTION = "Library to abstract STB hardware."
HOMEPAGE = "https://github.com/neutrino-mp"
SECTION = "libs"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${THISDIR}/libstb-hal/COPYING.GPL;md5=751419260aa954499f7abaabaa882bbe"

#
# this stuff really is machine specific, not CPU specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "\
	openthreads \
	ffmpeg \
	glew \
	freeglut \
	libao \
	libaio \
	gdk-pixbuf \
	fontconfig \
	atk \
	cairo \
	libpng \
	pixman \
	cogl-1.0 \
	clutter-1.0 \
	harfbuzz \
	freetype \
	pango \
	json-glib \
	libxcomposite \
"

# on coolstream, the same is provided by cs-drivers pkg (libcoolstream)
PROVIDES += "virtual/stb-hal-libs"

RDEPENDS_${PN} = "ffmpeg"

SRCREV = "${AUTOREV}"
PV = "0.1+git${SRCPV}"

# libstb-hal-bin package for testing binaries etc.
PACKAGES += "${PN}-bin"

LIBSTB_HAL_GIT ?= "git://github.com/neutrino-mp/libstb-hal.git;protocol=http"

SRC_URI = " \
	${LIBSTB_HAL_GIT} \
	file://0002-playback-use-external-player.patch \
	file://blank_480.mpg \
	file://blank_576.mpg \
	file://timer-wakeup.init \
	file://0001-xgl-threads.patch;apply=yes \
"

S = "${WORKDIR}/git"

# the build system is not really broken wrt separate builddir,
# but I want it to build inside the source for various reasons :-)
inherit autotools-brokensep pkgconfig


LDFLAGS = " -Wl,-rpath-link,${STAGING_LIBDIR} -lrt"

EXTRA_OECONF += "\
	--enable-maintainer-mode \
	--disable-silent-rules \
	--enable-shared \
	--enable-clutter \
	--with-boxtype=generic \
"

do_configure_prepend() {
	export AUTOMAKE="automake --foreign"
}

do_install_append() {
	install -d ${D}/${datadir}
}

# pic2m2v is included in lib package, because it is always needed,
# libstb-hal-bin contains all other binaries, which are rather for testing only
FILES_${PN} = "\
	${libdir}/* \
	${bindir}/pic2m2v \
	${datadir} \
"

FILES_${PN}-dev += "${includedir}/libstb-hal/*"

pkg_postinst_${PN} () {
	# after updating libstb-hal, neutrino should be restarted.
	touch /tmp/.restart
}
