�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��4�Pzi�m=}-�GL_���B2~��|�ь�-D�b9`�f�����tڑƂ4BY�hy�Bi�s�{ ��	_�C�85v��U�&�ob��ۆ�8�BUJ��2�����!����8���,��`t��˾�w8k��"[�ʚ��$��K��o��i4T	�Ɗ�����2c�
C 6v��ЅۻtT����N�f.3	�χ��� j��{�� �kCC�Z�Ѣ��UT��I�^ѽ��
&꣋�r�H�O�^D��dE`��n�H~I�{8�F���ɾGQ�$�ę�3e�cP�|��q"i�̴w��R����sV�Yl�'W�������'���x�v~��BȈ� ��R��x�k���;��V("V��b��'�	��"���w,_��%�I[k�X�a*㗀�g�û�Ƅ�r���Oq���λOEn4�gK�0C�C�Ed|T;�����[iec4(a_position.xyz,1.0));
    v_texCoord = a_texcoord0;
    v_fragmentColor = a_color0;
}


#endif

#ifdef FS
$input v_texCoord� v_fragmentColor

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform m2t4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC�Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);




void main()
{p     gl_FragColor = vec4( v_fragmentColor.rgb,v_fragmentColor.a) * texture2D(CC_Texture0, v_texCoord).a ;
}



#endif
