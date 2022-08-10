�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����<HH�lV�:#�&�b;���Y	\N�X�L��P�5�Pp��ۜ�m� pi��8�ެ���;����WO��q��To�`�ݶ�s)��(J�代؞߬1����)��x !�׀�����Y�M4X0�ߢ���)eO���u�xT	q|�Ӌ���\��3]η]�xDD���˳�i)ש_�U��ΕP��΂|�K�I�\)��!��q�7{F�N+��ݔ��vo�2�Ƒ�a�#^�`��[P(���@�;�_����+�E�f��ȷR����h+�� �*\'�-o��K�����	U���.���;��;q<<c��F��9���v��yo3��i�S%Bd��i��ܬz�޴G�ɪ�sڠ�>�����jYh8�tR�4� �WQ>hS=�����@
void main()
{
     #include "../../CoreData/Shaders/Library/Macro/PositionFinal.glsl" 
     #include "../../CoreData/Shaders/L�brary/Macro/NormalFinal.glsl"
     #include "../../CoreData/Shaders/Library/Macro/Texcoord0Final.glsl" 
     #include "../../Co!eData/Shaders/Library/Macro/ShadowCoordFinal.glsl"
     #include "../../CoreData/Shaders/Library/Macro/FragPosFinal.glsl"
     �     vec3 fragPos = v_FragPos;
     vec4 causticUV = mul(u_causticMat,vec4(fragPos,1.0)); 
	 v_causticUV.x = (causticUV.x+ 1.0)U2.0 ;
	  v_causticUV.y = (causticUV.y+ 1.0)/2.0 ;
}
#endif

#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT1TEXCOORD0
#define USING_INOUT_SHADOWCOORD
#define USING_INOUT_FRAGPOS
#include "../../CoreData/Shaders/Library/Varying.glsl"
$i�put v_causticUV

/// Common (uniforms,samplers, transforms ... )
//#define RECEIVED_SHADOW
#include "../../CoreData/Shaders/Libary/Common.glsl"
#include "../../CoreData/Shaders/Library/Lighting.glsl"

SAMPLER2D(u_causticTex,1);

void main()
{
	vec4 texCo�or = texture2D(u_diffuseTex,v_texcoord0);
    vec4 causticColor = texture2D(u_causticTex,v_causticUV);
    float dir = GetDiffu�eDirectionLight(v_normal);
    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_noral);

    gl_FragColor = vec4((environmentColor + lightColor) * texColor.rgb + causticColor.rgb * dir,1.0);

}

#endif








