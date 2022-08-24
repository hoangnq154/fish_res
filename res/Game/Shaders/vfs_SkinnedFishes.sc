�GSN    �˅1��\7,5V'pcw2toT��6�6e�$<غ�$^h����t�&�N��b�p<�N%�5py|pj���Rv��!B1��!�u�'aQ����ؕpՀ��$HH�zK�yN��IC���QK�W�UX~�T&�q�0�C,��Ӛ�~�VV��/ϸ����p���� 1���-ڃ,`s�E����n9+��B`8�+"�΢ԙ޹9��q����PA8G��������{S�[$^,ݺ����On����1�o*!WG⬍���
T��3Z��-S�Zb}�z�������c�o��ܛNۃ��#K�x�m�.H��=g��o�+�3Ad�I�����po����{@�d[�r��~"&x���S�*�O����f�'?�=���J���&Hv��]�v\H�4p�������J��7�*���i��R\qR����3������p7��/�\2O>��/[����<�çP����1��G<���®mVs'�EP�4�g�{^}*D�����mm mat4 u_causticMat;

void main()
{
     #include "../../CoreData/Shaders/Library/Macro/PositionFinal.glsl" 
     #include�"../../CoreData/Shaders/Library/Macro/NormalFinal.glsl"
     #include "../../CoreData/Shaders/Library/Macro/Texcoord0Final.gls?" 
     #include "../../CoreData/Shaders/Library/Macro/ShadowCoordFinal.glsl"
     #include "../../CoreData/Shaders/Library/M�cro/FragPosFinal.glsl"
     
     vec3 fragPos = v_FragPos;
     vec4 causticUV = mul(u_causticMat,vec4(fragPos,1.0)); 
	 v%causticUV.x = (causticUV.x+ 1.0)/2.0 ;
	  v_causticUV.y = (causticUV.y+ 1.0)/2.0 ;
}
#endif

#ifdef FS

/// input
#defi e USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHADOWCOORD
#define USING_INOUT_FRAGPOS
#include "..�../CoreData/Shaders/Library/Varying.glsl"
$input v_causticUV

/// Common (uniforms,samplers, transforms ... )
//#define REC)IVED_SHADOW
#include "../../CoreData/Shaders/Library/Common.glsl"
#include "../../CoreData/Shaders/Library/Lighting.glsl"

�AMPLER2D(u_causticTex,1);

void main()
{
	vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
    vec4 causticColor = tex�ure2D(u_causticTex,v_causticUV);
    float dir = GetDiffuseDirectionLight(v_normal);
    //vec3 environmentColor = GetEnvironentColor(v_normal);
    //vec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4(texColor.rgb + causticColor.rg * dir,1.0);

}

#endif








