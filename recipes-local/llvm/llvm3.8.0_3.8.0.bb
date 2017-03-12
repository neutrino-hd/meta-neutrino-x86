require llvm.inc

DEPENDS += "zlib"

SRC_URI[md5sum] = "07a7a74f3c6bd65de4702bf941b511a0"
SRC_URI[sha256sum] = "555b028e9ee0f6445ff8f949ea10e9cd8be0d084840e21fbbe1d31d51fc06e46"

# Fails to build with thumb-1 (qemuarm)
# | {standard input}: Assembler messages:
# | {standard input}:22: Error: selected processor does not support Thumb mode `stmdb sp!,{r0,r1,r2,r3,lr}'
# | {standard input}:31: Error: lo register required -- `ldmia sp!,{r0,r1,r2,r3,lr}'
# | {standard input}:32: Error: lo register required -- `ldr pc,[sp],#4'
# | make[3]: *** [/home/jenkins/oe/world/shr-core/tmp-glibc/work/armv5te-oe-linux-gnueabi/llvm3.3/3.3-r0/llvm-3.3.build/lib/Target/ARM/Release/ARMJITInfo.o] Error 1
ARM_INSTRUCTION_SET = "arm"
