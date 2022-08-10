�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����9RR�k[�~G�k�`-��?	��	�	�{<�!�V-������Vp��)����p����U�֗��o%+N�$�랻V}o;��j8�⠰ؙޱ$��a�� ��Y0~i�����ޱ�O� J5X7ư���� [b����6�[n).PL�ً���B��)[��,Z�Nby���ᑀR��F�hʱ��/帔�x�Y�_�\��SIh��f�:TXs�S-�!�Q��ɾkc�$��
�a	�T�3�%&d���F�>�����HN�=,�<P��V���9_���wg�5?��B���IS��l�Vk�BƑr��J:R��M��'�^��7���.M��c�t8M*�V�a����3�������kӪ����ٵ0z`=�i�6�l�a\>q.Ň���[?   #include "Library/Macro/Texcoord0Final.glsl"
     #include "Library/Macro/ShadowCoordFinal.glsl"
     #include "Library/Macr�/FragPosFinal.glsl"
}


#endif

#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOT_SHADOWCOORD
#define USING_INOUT_FRAGPOS
#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#def�ne RECEIVED_SHADOW
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2DRu_diffuseTex,v_texcoord0);

    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_nomal);

    gl_FragColor = vec4((lightColor + environmentColor) * texColor.rgb,1.0);
}

#endif
