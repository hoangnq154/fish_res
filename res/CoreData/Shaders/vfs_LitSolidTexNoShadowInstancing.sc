�GSN    �˅1��\7,5V'pcw2toT��6�6e�$<غ�$^h����t�&�N��b�p<�N%�5py|pj���Rv��!B1��!�u�'aQ����ؕpՀ��$HH�zQ�cT��G ��X[I��[Te9�	�zZ�4�Vf��܎�x�3LǣcW������z����H漽;��O^O�#����T8��.V�A�͓���4P��m����RU �ܟ�����k�d|>{������-~@����]�Fb! N����׌@ªi��;�P~~�{��̺�<O��*�eս� {񤄍m�M� �
u��DJa��p�]4%�di������&B�)���K �`V�=��"e���B�$�����jD�Y4�C������5 \���+y�vP��B�����N��~�'���w��xRR��A�� ������63G_��o�]~m$��a3ږ��=���Y���>�� 0��ϩ?M7�t^� ["�c�gxX*ƛ���=vnal.glsl"
}


#endif

#ifdef FS

/// input
#define USING_INOUT_NORMAL
#define USING_INOUT_TEXCOORD0
#include "Librar�/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#include "Library/Common.glsl"
#include "Library/Lighting.g?sl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);

    vec3 environmentColor = GetEnvironmentCo�or(v_normal);
    vec3 lightColor = GetLightColor(v_normal);

    gl_FragColor = vec4((lightColor + environmentColor) * texClor.rgb,1.0);
}

#endif
