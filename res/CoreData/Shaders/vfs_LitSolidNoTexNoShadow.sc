�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KZ{�c�����U҇��x)�@j�Ux�&�{:���^yj�X�[\$�� �7�Lf��᷶K�0p��1�ŏ�ݲ6���� �ʊ��~#0U�>�햢Y8˞k'4�! ފ���ܗ3��]��.��tnd��������t)�z=x��ݰ�� ~L����H�^e<!Q[������m"��a���>f�W�����u�e�$߼��"Y����?�_�B�W��.�� �ygR�xNh������Io�9��a�bW�z��=Z f���>�m��Ϳ�!�7*�kx����Mӭș#*S�� �8M�7|�[�A�ʇb��[��~�'���9��M-��L��z���;���gW��"�^"Oi��.ݜ�����S����X�ŲvN��۹k=":�`V�<T:�I�OmSo�����6^L
#define USING_INOUT_TEXCOORD0
#include "Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#include "Libr�ry/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{

    vec3 environmentColor = GetEnvironmentColor(v_normal);
   svec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4((lightColor + environmentColor) * u_matDiffColor.rgb,1.0);
�

#endif
