�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����2YE�jJ�
�,�h'���.an='�>�("h�2+�	V�?�Nv���ܴe�>MҮ88�㧖��e���6���T��Jo�����~*6��AQ����ȅġ5��k����#$����͛��2d�&g)TA������(`R����+(SD���Ư�$m��|��^o�CY�Z�����N�� �nݶ�esÚ��%T�p�e�9�RJg��#�=I_f�^'�l�����`k�i����z�NV�~��+y���>�"�X����,E�Y4�i���V���$e^���8r�|�������H��y�e���9��RRQM��C��0�S��6���.ns��c�f4[(��iE�����˹F�������G0���ª{Rg~�U5�v[@�i�xG+-̒���[JSING_INOUT_TEXCOORD0
#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#include "Library/Common.�lsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
    gl_FragColor n vec4(texColor.rgb,1.0);
}

#endif
