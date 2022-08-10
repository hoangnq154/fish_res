�GSN    ���t��Ug2Jx-e7Z���Ws�,<���<&bNΉ���?�(��c� f<�x,/-�>c1	���G"�� e�Z�+B�Q;�`춗֒kځ��.d�C`�\i�-�}+��^��#s�q1�J&��>��֗�,�Q3^��2���ʹ�T����9 �Ӑ�Cts�	�̷�:Sd��2@�kc߁�룾�:z���)��x '�݂�����	&�!5)b������=,G�����Mno.P	欼���(y��/��;�vLD�A�٢��]��f�*Ѿ�u7����w�M�&�^I��^Ok��J�S~nA�s.�F�6����WQ�̰��}�-\�w��8 /*텅�!�O����eC�po�1U�������`Pe/��6�/T�O��L���7��Kؠ�-���;�� x7x
��`��o���^���mK70��d�P*��-ғ��G���p��ʋEԣ�B7M����?Ed<�oS�~f�e�`]? i�����/"0 (hlsl  - d3d9)"
	@echo "  TARGET=1 (hlsl  - d3d11)"
	@echo "  TARGET=2 (essl  - nacl)"
	@echo "  TARGET=3 (essl  - android)"
�@echo "  TARGET=4 (glsl)"
	@echo "  TARGET=5 (metal)"
	@echo "  TARGET=6 (pssl)"
	@echo "  TARGET=7 (spirv)"

.PHONY: rebuild
r6build:
	@make -s --no-print-directory TARGET=0 clean all
	@make -s --no-print-directory TARGET=1 clean all
	@make -s --no-print�directory TARGET=2 clean all
	@make -s --no-print-directory TARGET=3 clean all
	@make -s --no-print-directory TARGET=4 clean al
	@make -s --no-print-directory TARGET=5 clean all
	@make -s --no-print-directory TARGET=7 clean all

else

ADDITIONAL_INCLUDESQ=

ifeq ($(TARGET), 0)
VS_FLAGS=--platform windows -p vs_3_0 -O 3
FS_FLAGS=--platform windows -p ps_3_0 -O 3
SHADER_PATH=shader�/dx9
else
ifeq ($(TARGET), 1)
VS_FLAGS=--platform windows -p vs_5_0 -O 3
FS_FLAGS=--platform windows -p ps_5_0 -O 3
CS_FLAGS=--latform windows -p cs_5_0 -O 1
SHADER_PATH=Bin/shaders/dx11
else
ifeq ($(TARGET), 2)
VS_FLAGS=--platform nacl
FS_FLAGS=--platfo�m nacl
SHADER_PATH=Bin/shaders/essl
else
ifeq ($(TARGET), 3)
VS_FLAGS=--platform android
FS_FLAGS=--platform android
CS_FLAGS=-�platform android
SHADER_PATH=Bin/shaders/essl
else
ifeq ($(TARGET), 4)
VS_FLAGS=--platform linux -p 120
FS_FLAGS=--platform linx -p 120
CS_FLAGS=--platform linux -p 430
SHADER_PATH=Bin/shaders/glsl
else
ifeq ($(TARGET), 5)
VS_FLAGS=--platform osx -p meta
FS_FLAGS=--platform osx -p metal
CS_FLAGS=--platform osx -p metal
SHADER_PATH=Bin/shaders/metal
else
ifeq ($(TARGET), 6)
VS_FLIGS=--platform orbis -p pssl
FS_FLAGS=--platform orbis -p pssl
CS_FLAGS=--platform orbis -p pssl
SHADER_PATH=Bin/shaders/pssl
elCe
ifeq ($(TARGET), 7)
VS_FLAGS=--platform linux -p spirv
FS_FLAGS=--platform linux -p spirv
CS_FLAGS=--platform linux -p spirv
�HADER_PATH=Bin/shaders/spirv
endif
endif
endif
endif
endif
endif
endif
endif

THISDIR := $(dir $(lastword $(MAKEFILE_LIST)))
VSFLAGS+=-i $(THISDIR)../common/ $(ADDITIONAL_INCLUDES)
FS_FLAGS+=-i $(THISDIR)../common/ $(ADDITIONAL_INCLUDES)
CS_FLAGS+=-i $(T�ISDIR)../common/ $(ADDITIONAL_INCLUDES)

BUILD_OUTPUT_DIR=$(addprefix ./, $(RUNTIME_DIR)/$(SHADER_PATH))
BUILD_INTERMEDIATE_DIR�$(addprefix $(BUILD_DIR)/, $(SHADER_PATH))

VS_SOURCES=$(notdir $(wildcard $(addprefix $(SHADERS_DIR), vfs_*.sc)))
VS_DEPS=$(adpprefix $(BUILD_INTERMEDIATE_DIR)/,$(addsuffix .vs.bin.d, $(basename $(notdir $(VS_SOURCES)))))

FS_SOURCES=$(notdir $(wildcard �(addprefix $(SHADERS_DIR), vfs_*.sc)))
FS_DEPS=$(addprefix $(BUILD_INTERMEDIATE_DIR)/,$(addsuffix .bin.d, $(basename $(notdir $�FS_SOURCES)))))

CS_SOURCES=$(notdir $(wildcard $(addprefix $(SHADERS_DIR), cs_*.sc)))
CS_DEPS=$(addprefix $(BUILD_INTERMEDIATEDIR)/,$(addsuffix .bin.d, $(basename $(notdir $(CS_SOURCES)))))

VS_BIN = $(addprefix $(BUILD_INTERMEDIATE_DIR)/, $(addsuffix .2s.bin, $(basename $(notdir $(VS_SOURCES)))))
FS_BIN = $(addprefix $(BUILD_INTERMEDIATE_DIR)/, $(addsuffix .fs.bin, $(basename $�notdir $(FS_SOURCES)))))
CS_BIN = $(addprefix $(BUILD_INTERMEDIATE_DIR)/, $(addsuffix .bin, $(basename $(notdir $(CS_SOURCES))))


BIN = $(VS_BIN) $(FS_BIN)
ASM = $(VS_ASM) $(FS_ASM)

ifeq ($(TARGET), $(filter $(TARGET),1 3 4 5 6 7))
BIN += $(CS_BIN)
ASMC+= $(CS_ASM)
endif

$(BUILD_INTERMEDIATE_DIR)/vfs_%.vs.bin: $(SHADERS_DIR)vfs_%.sc
	@echo [$(<)]
	$(SILENT) $(SHADERC) $(VS_FLA�S) --type vertex --depends -o $(@) -f $(<) --define VS
	$(SILENT) cp $(@) $(BUILD_OUTPUT_DIR)/$(@F)

$(BUILD_INTERMEDIATE_DIR)/!fs_%.fs.bin: $(SHADERS_DIR)vfs_%.sc
	@echo [$(<)]
	$(SILENT) $(SHADERC) $(FS_FLAGS) --type fragment --depends -o $(@) -f $(<) -�define FS
	$(SILENT) cp $(@) $(BUILD_OUTPUT_DIR)/$(@F)

$(BUILD_INTERMEDIATE_DIR)/cs_%.bin: $(SHADERS_DIR)cs_%.sc
	@echo [$(<)]n	$(SILENT) $(SHADERC) $(CS_FLAGS) --type compute --depends -o $(@) -f $(<)
	$(SILENT) cp $(@) $(BUILD_OUTPUT_DIR)/$(@F)

.PHONY� all
all: dirs $(BIN)
	@echo Target $(SHADER_PATH)

.PHONY: clean
clean:
	@echo Cleaning...
	@-rm -vf $(BIN)

.PHONY: cleanall
�leanall:
	@echo Cleaning...
	@-$(call CMD_RMDIR,$(BUILD_INTERMEDIATE_DIR))

.PHONY: dirs
dirs:
	@-$(call CMD_MKDIR,$(BUILD_INTEWMEDIATE_DIR))
	@-$(call CMD_MKDIR,$(BUILD_OUTPUT_DIR))

.PHONY: rebuild
rebuild: clean all

$(BIN) : | $(BUILD_INTERMEDIATE_DIR�

endif # TARGET

-include $(VS_DEPS)
-include $(FS_DEPS)
-include $(CS_DEPS)
