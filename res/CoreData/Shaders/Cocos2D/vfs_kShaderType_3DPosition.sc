�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu���(b�ׁ�T��d��k�g�h ;4�Y!DI@���d y��iC�С�-D�H^t�;�ڶ�lב��dq�hy�Bi��Su��TH��B	�$(�N�#�Z8��ܗ�c�R��Z}�ԝ���X����~��7��S^w�����E:93��7m8�������
D��.��&��omT'��������4t�&yc���Ԛ�&jN����Y�+a}�����#b��b��x�>ni�f��֔�S[��d�lע��v6��ͨ5@�Q�x�b��BBg��q�SlnD�=-	�4�����55�A����}�-�=��85k���v�>�����-� '�C>���P�凌!q\���+o�8i�������U��v�Bk�=��~�� PP��W��_���t���9iz��,�qD'�(�~Ǒ��3���@�΄�r���U0�ޫĦ?!+�qP�5"�t�aJv1 ?̗�ܬ$oosition.xyz, 1.0));
    v_color = a_color0;
}



#endif

#ifdef FS
$input v_color
#include "../Library/Base/common.sh"

uniform�mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_Mult:ViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform�vec4 CC_Random01;

//SAMPLER2D (CC_Texture0,0);

uniform vec4 u_color;


void main()
{
    gl_FragColor = vec4(v_color.rgb,1.0)A
}


#endif
