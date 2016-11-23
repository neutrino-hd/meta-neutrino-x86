SUMMARY = "New user to do specific job"
DESCRIPTION = "This recipe create a new user named ${PN}, who is used for specific jobs like building."
SECTION = "x11"
PR = "r7"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# builder user password is "builder"
BUILDER_PASSWORD ?= ".gLibiNXn0P12"
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system \
		       --create-home \
                       --groups users,video,tty,audio,input,shutdown,disk,systemd-journal,plugdev,adm \
		       --password ${BUILDER_PASSWORD} \
                       --user-group \
		       --shell /bin/bash \
		       --uid 1200 \
		       builder \
"

SRC_URI = "file://system-builder.conf"

inherit allarch useradd

do_configure() {
    :
}

do_compile() {
    :
}

do_install() {
    install -D -m 0644 ${WORKDIR}/system-builder.conf ${D}${sysconfdir}/dbus-1/system.d/system-builder.conf
}

FILES_${PN} = "${sysconfdir}/dbus-1/system.d/system-builder.conf"

ALLOW_EMPTY_${PN} = "1"
