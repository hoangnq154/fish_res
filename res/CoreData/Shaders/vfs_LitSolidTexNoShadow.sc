�GSN    �˅1��\7,5V'pcw2toT��6�6e�$<غ�$^h����t�&�N��b�p<�N%�5py|pj���Rv��!B1��!�u�'aQ����Ӑu΁��UMo�Wy�I/�-�z+�΂GS]��Y{#]�TJ�#�%�Ww�����j�:��'�ȋ���A����8���}��G�?��E>��>P�伳�ݚ�8��Q��oбtb+�������5a� y#5o�����oON�����Je&!Q[������?j��`��;�0
�8ן듖Z��*�FѲ��r*����p��@�%��:&x��g�{bI�4c@�k�^����'g�(���*#�oK�a��$x�ç[�$�U����,�}(�:X�ށ�����)&���{0b�+|��`���ߘH	��{�%���w��P2xR����6���t���53_��A�Q#Ld��n܊��U�´Y����r�²^Tk��ԡ�zYe7�5�SW�d�nN-C�����[vnput
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#include "Library/Varying.glsl"

/// Common (uniforms,sample�s, transforms ... )
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = te+ture2D(u_diffuseTex,v_texcoord0);

    vec3 environmentColor = GetEnvironmentColor(v_normal);
    vec3 lightColor = GetLight�olor(v_normal);

    gl_FragColor = vec4((lightColor + environmentColor) * texColor.rgb,1.0);
}

#endif
