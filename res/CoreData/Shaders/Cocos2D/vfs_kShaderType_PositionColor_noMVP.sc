�GSN    �˅1��\7,5Q	(Kitge��R�|n�n4.���5 %����P�
�2��e�pr�^%2)�p(A.Y�ƩYl��7R'���+N�bF{�i�똝�x����4^K�Il�fi�?�C/���i.[��F"�[�wA��}N��ӊ�e�BUJ��2�����!����8�Ҹ*��YQto��֡�:-+��"G�7 ߇��� ��P��7��@;~?���ֱ�:r�gV$Y��ɲ��;~H����R�Yd=*_���Ι�_��4��r�q_G�C�߶ݶu?ʏd�cյ��u=����?�[��=D��X_Z��f�yoeN�r'������[\�%���O�3e�.P�p��5g(���x�/�]����#�|,�$Y����W����.#��R�8?�,B��Z�����S	��,�%���v��KF{��]�����,���8(ZP��e�x)0�X�-UԔ��|�š\��ɖ>ں�,>��ܜmXk�rM�!XO�e�<>BP&ڝ���1xyz,1.0));
    v_fragmentColor = a_color0;
}


#endif

#ifdef FS
$input v_fragmentColor


#include "../Library/Base/common.sh"
�
uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform matg CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime�
uniform vec4 CC_Random01;


void main()
{

    gl_FragColor = v_fragmentColor;
}


#endif
