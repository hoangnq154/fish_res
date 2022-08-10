�GSN    ���w��Sq6=Z==h��Z�q!�1u���5%����v��!�l�pn�h ;4�(>5^��� y��Td'�ʽ�W�Zm����ۜk�ş�5&�zo�Bl��k9��	[_Hj��[=��7U��Mq��䗝{�0U��4������|���� +���,ہL
.��н�?:�� j.�-?ι�����8��E��&��u#��������o&�|>r�����<|N����N�[F.3L@�����$m��/��
/�kr\�P���S�e�G٤��xh����p�S�A�
3�h\|��f�sdI�|8��t����ba�&���(�yP�v��$.l枚�(�����# �!.�&G���Q����oP#���*b�)u��N�������x�|>���i�ZkRQ��B��0���5���8-Q��y�[7L9�X�h�؆�r�μP����z���L+Z���ªqSd8�K~�'?�I�WqHn�׭��qe MAX_SPLIT_COUNT 3
#endif

// light position
uniform vec4 u_lightPosition;
// light direction
uniform vec4 u_lightDirection;
/� light color
uniform vec4 u_lightColor;
// light info : type ,shadow split count
uniform vec4 u_lightInfo;
// light view projec'ions
uniform mat4 u_lightSpaceMatries[MAX_SPLIT_COUNT];
// shadow viewports (for split in one texture)
uniform mat4 u_shadowVie�ports[MAX_SPLIT_COUNT];
// shadow splits
uniform vec4 u_shadowSplits;
// direction light cascaded
uniform vec4 u_lightShadowCasaded;
// cascaded viewport for shadow pass write
uniform vec4 u_cascadedViewport;


#if defined(SKINNING)
uniform vec4 u_matrix>alette[180];
#if !defined(SKINNING_JOINT_COUNT)
#define SKINNING_JOINT_COUNT 60
#endif
#endif

#if defined GPU_SKINNING
uniform�vec4 u_matrixPalette[2];
#endif


/// Fragment shader uniform

uniform vec4 u_sceneHemisphericColor[3];
uniform vec4 u_ambientClor;

uniform vec4 u_matDiffColor;
uniform vec4 u_matEmissiveColor;
uniform vec4 u_matEnvMapColor;
uniform vec4 u_matSpecColor;�
#ifdef PBR
uniform vec4 cRoughness;
uniform vec4 cMetallic;
uniform vec4 cLightRad;
uniform vec4 cLightLength;
#endif
