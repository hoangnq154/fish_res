�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��4�Pzi�m=}-�PU']���Xj��Wx�ɺ�b�FY�m�����[ږ��nk�Jv�Ch�B�{ ��	_�C�85v ��j�[�Lj�����a�k��1������p����7��j�+s����{x��>I�#8ه����8��I��.��=C7�ϗ�����#=�2{9x��ſ��oOb����H�ib*0s������5PՓG��}�l@
�T�����i.��g�f����i+����y�L��d��toQ��n�H~I�{8�F���ɾGQ�"�ę�3e�cP�|��q"i�̴w��O����yg�=&�&F����\��ƻ"$���hG�,s��_ˆ�����{�*�h��u��MEԏ��#���&���65L���D>J/��d�����������qĦ�J6���ƹsl+�.J�/
�P�gX|T;��巎$RVMatrix) , vec4(a_position.xyz,1.0));
    //gl_PointSize = a_texcoord0.x;
    v_fragmentColor = vec4(a_color0.rgb * a_color0.a � u_alpha.x, a_color0.a * u_alpha.x);
}


#endif

#ifdef FS
$input v_fragmentColor


#include "../Library/Base/common.sh"


unif<rm mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_M�ltiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
unifrm vec4 CC_Random01;


void main()
{
    gl_FragColor = v_fragmentColor;
}


#endif
