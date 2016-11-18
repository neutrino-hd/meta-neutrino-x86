require llvm.inc

DEPENDS += "zlib"

EXTRA_OECONF += "--enable-zlib \
		 --enable-targets=r600 \
"
SRC_URI[md5sum] = "f1e14e949f8df3047c59816c55278cec"
SRC_URI[sha256sum] = "b39a69e501b49e8f73ff75c9ad72313681ee58d6f430bfad4d81846fe92eb9ce"


# Fails to build with thumb-1 (qemuarm)
# | {standard input}: Assembler messages:
# | {standard input}:22: Error: selected processor does not support Thumb mode `stmdb sp!,{r0,r1,r2,r3,lr}'
# | {standard input}:31: Error: lo register required -- `ldmia sp!,{r0,r1,r2,r3,lr}'
# | {standard input}:32: Error: lo register required -- `ldr pc,[sp],#4'
# | make[3]: *** [/home/jenkins/oe/world/shr-core/tmp-glibc/work/armv5te-oe-linux-gnueabi/llvm3.3/3.3-r0/llvm-3.3.build/lib/Target/ARM/Release/ARMJITInfo.o] Error 1
ARM_INSTRUCTION_SET = "arm"
