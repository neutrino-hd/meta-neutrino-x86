SUMMARY = "Mail is an email client for elementary OS"
SECTION = "mail"
HOMEPAGE = "https://code.launchpad.net/~elementary-apps/pantheon-mail/trunk"

DEPENDS += "vala webkitgtk"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=2a2244d5a13871ad950c55877546a6a2"

SRC_URI = "https://launchpad.net/pantheon-mail/loki/${PV}/+download/pantheon-mail-${PV}.tar.xz \
"

SRC_URI[md5sum] = "3f0757e6a915f82381b82f7389ae3a98"
SRC_URI[sha256sum] = "80c67d0c97ff103f18bf1047c844bef9a6f4dbc0f6a9bae34e64ad85541da0cf"

S = "${WORKDIR}/pantheon-${BPN}-${PV}"

inherit cmake pkgconfig



