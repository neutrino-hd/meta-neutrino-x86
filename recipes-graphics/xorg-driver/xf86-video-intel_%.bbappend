
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-intel \
           file://always_include_xorg_server.h.patch \
           "
           
PACKAGECONFIG ??= "xvmc sna udev ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'dri dri2 dri3', '', d)}"
