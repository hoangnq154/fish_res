�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KZ{�c�����U҇��x)�@j�Ux�&�{:���^yj�X�[\$�� �7�Lf��᷶K�0p��1�ŏ�ݲ6���� �ʊ��~#0U�>�햢Y8˞k'4�! ފ���ܗ3��]��.��tnd��������t)�z=x��ݰ�� ~L����H�^e<!Q[������m"��a���>f�W�����u�e�$߼��"Y����?�_�B�W��.�� �ygR�xNh������Io�9��a�bW�z��=Z f���>�m��Ϳ�!�7*�kx����Mӭș#*S�� �8M�7|�[�A�ʇb��[��~�'���9��M-��L��z���;���gW��"�^"Oi������zݦ�����x���)SN���¢oBuT�bZ�0
�U�A|Bi桝��4MMAL
#define USING_INOUT_TEXCOORD0
#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#include "Li�rary/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);

   svec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4(�lightColor + environmentColor) * texColor.rgb,1.0);
}

#endif
