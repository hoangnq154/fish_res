�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KZ{�c�����U҇��x)�@j�Ux�&�{:���^yj�X�[\$�� �7�Lf��᷶K�0p��1�ŏ�ݲ6���� �ʊ��~#0U�>�햢Y8˞k'9�$%ŋ�ٰ҃/��k����\D;�ֈ�챲�>`�)pp.D+ܨ����X~����l�ll.PJ������b��}�(z�gDD�����<j��%�I׽�ns����p�S��^s��Y_h��n�S4%	�4di������&B�)���K �`V�=��"e ���]�m�]����H�so�iƺ�S����b<,�� �v1j�+r�%�^�����N��9�8�@�;��R1H��J�����&���6"Lњc�_0O��a[Ԕ��1�������pԣ�G<A�°ɾ~Exq�g\�6[;�x�g]-y�����ssl"
     #include "Library/Macro/ShadowCoordFinal.glsl"
     #include "Library/Macro/FragPosFinal.glsl"
}
#endif

#ifdef FS

//� input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHADOWCOORD
#define USING_INOUT_FRAGPOS

#i=clude "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#define RECEIVED_SHADOW
#include "Library/Common.�lsl"
#include "Library/Lighting.glsl"

void main()
{

    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 light9olor = GetLightColor(v_normal);

    gl_FragColor = vec4((lightColor + environmentColor) * u_matDiffColor.rgb ,1.0);
}

#endif
