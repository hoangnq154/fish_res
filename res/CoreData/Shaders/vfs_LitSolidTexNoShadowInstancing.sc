�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B"�6($U	�Ωa>Q+E=��:��KWp�f����P����9RR�k[�~G�k�`-��?	��	�	�{<�!�V-������Vp��)����p����U�֗��o%+N�$�랻V}o;��j8�⠰ؙޱ$��a�� ��Y0~i��������yJ�%g1	nMĎڧ��("F����6�o*!WG⬑���E��2H��Q4�]BG�Z�����_��g�*����a=����l���W�YOb��f�QVbE�|3�%�����cb�'���	�a�`X�}��[M*����$�_����bO�:-�(F��ƹ\����/,���0j�wz�����H����{�.�@��y�� F]G�� ��'���=���y&R���qk��nƜ��1�ŷG����S֬�Lv5���ģmS1�h^�w�l�OU*j̚���q#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#include "Library/Varying.glsl"

/// Common (unif�rms,samplers, transforms ... )
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColors= texture2D(u_diffuseTex,v_texcoord0);

    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLig�tColor(v_normal);

    gl_FragColor = vec4((lightColor + environmentColor) * texColor.rgb,1.0);
}

#endif
