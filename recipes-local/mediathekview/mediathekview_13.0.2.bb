SUMMARY = "Mediathekview"
DESCRIPTION = ""
HOMEPAGE = "http://zdfmediathk.sourceforge.net/index.html"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://Copyright/_mediathekView-LICENSE.txt;md5=66e1eeb3afdf47b310a8c763864b70c8 \
"

SRC_URI = "https://download.mediathekview.de/stabil/MediathekView-${PV}.tar.gz \
	   file://mediathek.xml \
"

inherit useradd
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system \
		       --create-home \
                       --groups users,audio,video,shutdown,disk,adm,plugdev,tty,dialout \
		       --password ${BUILDER_PASSWORD} \
                       --user-group \
		       --shell /bin/bash \
		       --uid 1200 \
		       builder \
"

RDEPENDS_${PN} = "jre"

S= "${WORKDIR}/MediathekView-${PV}"

do_install() {
    install -d ${D}/opt/mediathekview ${D}/usr/bin ${D}/home/builder/.mediathek3/
    cp -rf ${S}/* ${D}/opt/mediathekview
    install -m 644 ${WORKDIR}/mediathek.xml ${D}/home/builder/.mediathek3/
    rm -rf ${D}/opt/mediathekview/*.exe
    rm -rf ${D}/opt/mediathekview/bin/*.exe
    ln -sf /opt/mediathekview/MediathekView.sh ${D}/usr/bin/mediathek_view
}

do_install_append() {
	chown -R builder.builder ${D}/home/builder/.mediathek3/
}

FILES_${PN} += "/opt \
		/usr \
		/home \
"

SRC_URI[md5sum] = "ff808910a562810ed5342975633b7912"
SRC_URI[sha256sum] = "7e3ebb497f812c8863b4d9b83a2eafd845052f66f8b2dfe370c471a709b00030"


