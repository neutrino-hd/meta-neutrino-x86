PACKAGECONFIG_append += "gallium gallium-llvm dri3 r600 xa" 

MESA_LLVM_RELEASE = "3.8.0"

# reminder: for now its ok to take llvm-config from host ... fix me!
EXTRA_OECONF = "--enable-shared-glapi"
