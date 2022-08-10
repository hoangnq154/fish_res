�GSN    �˅1��\7,5Q'Y 6Nh &[7��H�ah�,yQ�ŧ+]��Ξ��+��R$�+ay�~&/?�p[5D���k}�~
Չ��._� G9�y���Ϙ�ƛ�ms�@8�.��l<���TpF ��F>��	�?�Dl�Ȓ��x�Y|��#<�嫖��`����(��*��b)!W��Ѕ� ��m%�v�����#��E�o��BM"����Ѐ��5o�(g=[z�ۈ���Zq����U�:)WO���η�9?��?P��o�HDO�x��Ϝ�D	�>�1���f<��͆k��o�0h��V@C��q�!R�t%������GM����D�}�kV�~��4s*ʯ�g�#�U����7�5 �$������ڻ/��I�,b�6o�U�HŒ�+��u��x�Fz�h��u��MEԏ��#���&���65L���]8Gk��c]���3���R����m޻�L7A���ޠ7Zt2�s`�0�r�b>iR �؊��6IMatrix) , vec4(a_position.xyz,1.0));
	v_light = a_color0;
	v_dark = a_color1;
	v_texCoord = a_texcoord0;

}

#endif



#ifdef F�
$input v_texCoord, v_light, v_dark

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPM2trix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatr�x;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0)A

void main()
{
	vec4 texColor = texture2D(CC_Texture0, v_texCoord);
	float alpha = texColor.a * v_light.a;
	gl_FragColor.a = apha;
	gl_FragColor.rgb = (1.0 - texColor.rgb) * v_dark.rgb * alpha + texColor.rgb * v_light.rgb;

}

#endif
