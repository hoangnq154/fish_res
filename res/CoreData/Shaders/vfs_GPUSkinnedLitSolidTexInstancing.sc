�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����2YE�jJ�
�,�h'���.an='�>�("h�2+�	V�?�Nv���ܴe�>MҮ88�㧖��e���6���T��Jo�����~*6��AQ����ȅġ?��eߦl��{i/�̔�����I�J>O!ݠ����lhD�����lB a`�Í���J��+L��,_�=IO�\�٢��.޹C�E�ДRÚ��|<�P�@�b��{El��q�\LjU�t -������+!�k����fO�xW�u��<g&���U�>�S����lC�sf�jP���Z��խ#5��;�v(�<{�����<��d2���%���~��>V-Vٔl��8�8���]KH��,�S8Mc�r�U����0�¶Y����<���Q8���ʯmX.�uV�0�i�i^qzL:�����[? #include "Library/Macro/NormalFinal.glsl"
     #include "Library/Macro/Texcoord0Final.glsl"
     #include "Library/Macro/Shado�CoordFinal.glsl"

    //gl_Position =  mul(u_modelViewProj , vec4(a_position.xy,1.0,1.0));
}
#endif

#ifdef FS

/// input
#defi=e USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#define USING_INOUT_SHADOWCOORD
#define USING_INOUT_FRAGPOS
#include "Librar�/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
//#define RECEIVED_SHADOW
#include "Library/Common.glsl"
#inclue "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
    vec3 environmentColor = GtEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4((environmentColor + lightC�lor) * texColor.rgb,1.0);
}

#endif
