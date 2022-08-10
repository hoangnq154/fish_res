�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����<HH�lV�:#�&�b;���Y~N��T L"��m�%�Eo�ɐ��#�VP��(���|���&�؆��t>!T�8����9)9��$�챾ɟŪ$��g����#/�𩠈���A�[.C=��隠�Cn���X�Yb!"|�Ŗ���D��#I��9K�M'	�[�����BՏh�kʩ��a!����Xx�M��t(��oa��l�S2~I�{8��RҬ��j}�$���_�&A�$3�w��8"*ڧ�z��{�Ϳ�!�7*�kx����MӭƗ-*���5^�/r��@���@��\q��7�Vh���n��R>6V��V��4������#(Q��b�^D'��U����0�¶Y����<���Q8���ʯmX.�tR�52�a�&U3nLk�����[<include "Library/Macro/Texcoord0Final.glsl"
     #include "Library/Macro/ShadowCoordFinal.glsl"
     #include "Library/Macro/Fr�gPosFinal.glsl"

}
#endif

#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHDOWCOORD
#define USING_INOUT_FRAGPOS
#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
//#define�RECEIVED_SHADOW
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_iffuseTex,v_texcoord0);
    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_normalG;

    gl_FragColor = vec4((environmentColor + lightColor) * texColor.rgb,1.0);
}

#endif
