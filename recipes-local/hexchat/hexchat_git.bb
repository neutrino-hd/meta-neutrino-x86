SUMMARY = "hexchat - an open source irc client"
SECTION = "network/chat"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = ""

SRC_URI = "https://github.com/hexchat/hexchat.git \
"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake

