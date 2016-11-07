SUMMARY = "Parcellite - lightweigth but feature rich Clipboard manager"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
# FIXME: There are many more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "gtk+ intltool-native"

SRC_URI = "git://github.com/rickyrockrat/parcellite.git \
"

SRCREV = "bb131cb391a47494484c39362de33e77bc259198"
PV = "${SRCPV}"


S = "${WORKDIR}/git"

inherit autotools gettext

SRC_URI[md5sum] = "727b4be38549d295ab38777cfce5482f"
SRC_URI[sha256sum] = "e1c5059e900be0a805b3272f0f86e06844042fe3e3d158ac821e092e6c3e3c23"
