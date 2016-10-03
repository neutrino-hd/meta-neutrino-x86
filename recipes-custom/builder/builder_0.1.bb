SUMMARY = "New user to do specific job"
DESCRIPTION = "This recipe create a new user named ${PN}, who is used for specific jobs like building."
SECTION = "x11"
PR = "r6"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://builder_session.sh;endline=5;md5=84796c3c41785d86100fdabcbdade00e"

inherit useradd

# builder user password is "builder"
BUILDER_PASSWORD ?= ".gLibiNXn0P12"
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --create-home \
                       --groups video,tty,audio \
                       --password ${BUILDER_PASSWORD} \
                       --user-group builder \
			-u 1200 \
"



