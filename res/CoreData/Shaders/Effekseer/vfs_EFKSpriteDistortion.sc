�GSN    �˅1��\7,5Q'Y 6Nh &[7��H�ah�,_U���30N����O�N�`��q�TtC�x*24�>dY�ߩU2z��˻�+X�G5�P���ږw����X!b�Cq�Ud�'�z>���_]R��)J?��	Q�$�RvЅġ�i�0P��^W������a�������z��Un��ϲ�uU��p-�6lݱ����z�M��#��x Vd��������")�&f5Tt��ǰ��'.+׾��Z�Mfo*_]������?g��{�� �kCC�Z�Ѣ��BT��U�cݧߠo9ɫ��g�4�B�h��Ao��#�>{d�p8�]�����vc�&���_�E�]K�y��%(d��Z�+�N�Π�!Y�>� Z����Zι��6,���7T"�"�U������K��{�%���w��RI<F��p��&���:���|a_/��x�\6F%�V�!Uҧ��`�ؼZ�Ȑ�5���A0��΢kxr�g`�6�i�f%=iȫ���qgent.z, 1.0 );
    vec4 localTangent = vec4( a_position.x + a_tangent.x, a_position.y + a_tangent.y, a_position.z + a_tangent.z� 1.0 );

    localBinormal = uMatCamera * localBinormal;
    localTangent = uMatCamera * localTangent;

    vec4 cameraPos = uM2tCamera * vec4(a_position.xyz,1.0);
   	cameraPos = cameraPos / cameraPos.w;

   	localBinormal = localBinormal / localBinormal�w;
    localTangent = localTangent / localTangent.w;

    localBinormal = cameraPos + normalize(localBinormal - cameraPos);
   ZlocalTangent = cameraPos + normalize(localTangent - cameraPos);

   	gl_Position = uMatProjection * cameraPos;

   	v_vaPos = g_Position;

   	vec4 cameraPosU = cameraPos + vec4(0.0, 1.0, 0.0, 0.0);
    vec4 cameraPosR = cameraPos + vec4(1.0, 0.0, 0.0, 0�0);

    v_vaPosR = uMatProjection * localTangent;
    v_vaPosU = uMatProjection * localBinormal;

    v_vaPos = v_vaPos / v_va<os.w;
    v_vaPosR = v_vaPosR / v_vaPosR.w;
    v_vaPosU = v_vaPosU / v_vaPosU.w;

    v_color0 = a_color0;
    v_texcoord0 = v�c4(a_texcoord0.x,a_texcoord0.y,0.0,0.0);
    v_texcoord0.y = mUVInversed.x + mUVInversed.y * v_texcoord0.y;


}

#endif


#ifde� FS
$input v_color0
$input v_texcoord0
$input v_vaPos
$input v_vaPosR
$input v_vaPosU

/// ----- UNIFORM
#include "../Library/Bse/common.sh"

SAMPLER2D(uTexture0,0);
SAMPLER2D(uBackTexture0,1);

uniform	vec4	g_scale;
uniform	vec4	mUVInversedBack;

// endSmaterials
/// ----------  END UNIFORM


void main()
{
    vec4 color =  texture2D(uTexture0, v_texcoord0.xy);
    color.w = colgr.w * v_color0.w;

   vec2 pos = v_vaPos.xy / v_vaPos.w;
   vec2 posU = v_vaPosU.xy / v_vaPosU.w;
   vec2 posR = v_vaPosR.xy / F_vaPosR.w;


   	vec2 uv = pos + (posR - pos) * (color.x * 2.0 - 1.0) * v_color0.x * g_scale.x + (posU - pos) * (color.y * 2.0 � 1.0) * v_color0.y * g_scale.x;
   	uv.x = (uv.x + 1.0) * 0.5;
   	uv.y = (uv.y + 1.0) * 0.5;
   	//uv.y = 1.0 - (uv.y + 1.0) *|0.5;

   	uv.y = mUVInversedBack.x + mUVInversedBack.y * uv.y;

   	color.xyz = texture2D(uBackTexture0, uv).xyz;

    gl_FragC�lor = color;
    if(gl_FragColor.w <= 0.0) discard;

}

#endif
