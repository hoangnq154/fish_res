�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu���(b�ׁ�T��d��v�xy�i/&14�p()^���O6��8x�Ľ� W�v�b�����q����h`�Wu�]a�|�M�סFU�}�O?�E�b�q�a\��ފ�Z�(o��/���̃����7���?)=E�<�ا�swU��b2�/lƏ���ӽ=��i��=��&
$����ś��/2�V6b�����Zq����U�d?|4\�征��mf��O/��!U�l@K�x���j�c�eʽ��e0�ꮨ)K�S��i��X^c��f�G:Hd�N$���Ҝ�mh�9��<O�Nf�|��8"1���]�"�Q����vM��(Z��������.#��R�8?�,B��Z�����S	��,�|=���v��[U	.����9�!��=���9aP��`�_$Oc�'�dĨ��y�͡G����]��n8�硂�3w;�2� �i�a]13X0�����R6;
    v_fragmentColor = a_color0;
}


#endif

#ifdef FS
$input v_fragmentColor


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


void main()
{
    gl_FragColor = v_fragmentColor;
}


#endif
