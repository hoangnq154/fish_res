�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B8�5ppp:^	���A	}��8x�Ľ�S�Vm�a�쁓�uȉШ}.)�w�Dp�<�-*��W&3�9�$?g�/:�F-��pG�����o�;Z��"4�壜�C����"���-ڃ+`Q5�J�־�ulw��b2�/?�����"��I��a��=)~i��������yJ�%g1	nMрų��akM��ϫ6�Qb)(LD�����8T��c��i�]HD�P�����Y	��g�c����{Y����Y0�Q�E�s��^C`��m�hbF�idj�F�Q����p~�q����&�hR� ��2*%��� �u�Ό��.�2=� Z����M����3$��_�5g�S�U����\лH��A�<�_��z��ZJ-2@��y��"�J��t���xax��x�Q>O>��U��Ӎ|�ɹc����.ꔈ~y\�����?=!~�&R�=�i�io@{x�����U/; 
    modelView[0][2] = 0.0; 

    // Second colunm.
    modelView[1][0] = 0.0; 
    modelView[1][1] = 1.0; 
    modelView[1][�] = 0.0; 

    // Thrid colunm.
    modelView[2][0] = 0.0; 
    modelView[2][1] = 0.0; 
    modelView[2][2] = 1.0;

    // fixe7-size billboard
    // https://stackoverflow.com/questions/41767490/how-to-transform-vertices-in-vertex-shader-to-get-a-3d-bill�oard

    vec4 viewPos = mul(u_modelView, u_billboardCenter);
    float dist = -viewPos.z * 0.005;
    //gl_Position = mul(u_prj, (viewPos + vec4(a_position.xy*dist, 0, 0)));
    
    gl_Position = mul(u_proj, mul(modelView, vec4(a_position.xyz * dist, 1@0)));

    #include "Library/Macro/Texcoord0Final.glsl"
}

#endif

#ifdef FS

/// input
#define USING_INOUT_TEXCOORD0
#include �Library/Varying.glsl"

/// Common (uniforms,samplers, transforms ... )
#include "Library/Common.glsl"
#include "Library/Lightin.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex, v_texcoord0);
    gl_FragColor = vec4(texColor.rgb, texColor.�);
}

#endif
