�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KZ{�c�����U҇��x)�@j�Ux�&�{:���^yj�X�[\$�� �7�Lf��᷶K�0p��1�ŏ�ݲ6���� �ʊ��~#0U�>�햢Y8˞k'9�$%ŋ�ٰ҃/��k����\D;�ֈ�챲�>`�)pp.D+ܨ����X~����l�ll.PJ������b��}�(z�gDD�����<j��%�I׽�ns����p�S��^s��Y_h��n�S4%	�4di������&B�)���K �`V�=��"e ���]�m�]����H�so�iƺ�S����b<,�� �v1j�+r�%�^�����N��9�8�@�;��R1H��J�����&���6"Lњc�_0O��a[Ԕ��1�������pԣ�G<A�°ɾ~Exq�g\�6[;�x�g]-y�����ssl"
     #include "Library/Macro/ShadowCoordFinal.glsl"
     //#include "Library/Macro/FragPosFinal.glsl"

     v_FragPos = pos�tion.xyz;
}
#endif

#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHADOWCOOD
#define USING_INOUT_FRAGPOS

#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#define RECEIVE�_SHADOW
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTx,v_texcoord0.xy);
    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_normal);

 N  gl_FragColor = vec4((lightColor + environmentColor) * texColor.rgb,1.0);
}

#endif
