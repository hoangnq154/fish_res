�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����2YE�jJ�
�!�m"��[k��Y5� �J�$�d������Vp��-������s��� �ў��n?*E�%����T(:��a}�婨Ξ߫/��|�� ��-
W.����͛��H�\4B6ͼ����On�����Qh#2ZL������,y��*n��u�0JF�Y�����@ډg�e��n:⥟�?��^�t��EA}��-�S3�x#��9����OG��޷u�a�aL�v�%x螎�"�Q����.�qE�?[����^���JO\׮R�ze�5h�������^T��t�d���o��y1H��C��w�Q��t���9"R��,�~8A9�
�"8қ��<�çX����p֣�D5�Ӌ�?!}�h\�,
�"�aP-|R0�����0Texcoord0Final.glsl"
     #include "Library/Macro/ShadowCoordFinal.glsl"
}
#endif

#ifdef FS

/// input
#define USING_INOUT_NOR�AL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHADOWCOORD
#include "Library/Varying.glsl"

/// Common (uniforms,samplers transforms ... )
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(�_diffuseTex,v_texcoord0);
    gl_FragColor = vec4(texColor.rgb,1.0);
}

#endif
