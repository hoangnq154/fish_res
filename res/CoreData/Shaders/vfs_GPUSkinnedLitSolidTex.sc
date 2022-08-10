�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����2YE�jJ�
�!�m"��[k��Y5� �J�$�d������Vp��-������s��� �ў��n?*E�%����T(:��a}�婨Ξ߫/��|�� ��-
W.����͛��H�\4B6ͼ����On�����Zm&)[	�ߑ���E��(P��?\�Q~ �\��S@��c�x٢��V2����1�R�@�t��M��n�:#R�t%��^����e`�-���&A�-�0��7)o���a��u����g�:!�%A����s����2	j?���7Rl�*q��[���H��N���|k�Bƒ8��S;��F��4�ü5���xQ��e�\J%��j����3�����r«�{-��ʾfL?�tP��a�N[1|LgΘ���q?    #include "Library/Macro/Texcoord0Final.glsl"
     #include "Library/Macro/ShadowCoordFinal.glsl"

}
#endif

#ifdef FS

/// �nput
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHADOWCOORD
#define USING_INOUT_FRAGPOS
#incl&de "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#define RECEIVED_SHADOW
#include "Library/Common.gls�"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
    vec3 environment9olor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4((environmentColorN+ lightColor) * texColor.rgb,1.0);
}

#endif
