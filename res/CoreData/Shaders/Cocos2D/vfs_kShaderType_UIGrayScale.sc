�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��4�Pzi�m=}-�PU']���Xj��N�݌�0R�b9`�f�����tڑƂ4BY�hy�Bi�s�{ ��	_�C�85v��U�&�ob��ۆ�8�BUJ��2�����!����8���,��`t��˾�w8k��"[�ʚ��$��K��o��i4T	�Ɗ�����2c�
C 6v��ЅۻtT����N�f.3	�χ��� j��{�� �kCC�Z�Ѣ��UT��I�^ѽ��
&꣋�r�H�O�^D��dE`��n�H~I�{8�F���ɾGQ�$�ę�3e�cP�|��q"i�̴w��R����sV�Yl�'W�������'���x�v~��BȈ� ��R��x�k���;��V("V��b��'�	��"���w,_��%�I[k�X�a*㗀�g�û�Ƅ�r���U0�ޫĦRVu,�~�y
�4�im/rS ݝ���fz,1.0));
    v_fragmentColor = a_color0;
    v_texCoord = a_texcoord0;
}


#endif

#ifdef FS

$input v_fragmentColor, v_texCoor�

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;Yuniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform v�c4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);




void main()
{
    vec4 c = teture2D(CC_Texture0, v_texCoord);
    c = v_fragmentColor * c;
    gl_FragColor.xyz = vec3(0.2126*c.r + 0.7152*c.g + 0.0722*c.b)U
    gl_FragColor.w = c.w;
}




#endif
