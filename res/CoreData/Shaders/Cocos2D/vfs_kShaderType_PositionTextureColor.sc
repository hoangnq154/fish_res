�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��4�Pzi�m=}-�PU']���Xj��N�݌�0R�bF{�i�똝�x����4^V�Dl�Yx�B�`'��J�W�8)d%��j��Cw��ʥ�Q�s*Q��/۷���5����#��7Κ+s����{x��>I�-ߜ��뚋?��V��"��) 7	�Բ�����>q�Ec�����EyO����Q�Rj;tj�Ӗ���,g��}��E�pDL�G�����@ڥU�cյ��u=����?�[��=D��^BZ��f�yoeN�r'������[M�8�����d_�a��'$>���k�,�X����yg�p&�*X��������)7��]�8n�:r��C���J��R��x�k���;��V("V��b��'�	��aޫ�>%��b�[XA�X�-ߧ��`�ؼZ��ԋs£�N,���ݥz@Q,�lr�-�,�KmKm(݆���[3 vec4(a_position.xyz, 1.0));
    v_fragmentColor = a_color0;
    v_texCoord = a_texcoord0;
}



#endif

#ifdef FS

$input v_fra�mentColor, v_texCoord

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
unif<rm mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform ve�4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);


void main(S
{
    gl_FragColor = v_fragmentColor *  texture2D(CC_Texture0, v_texCoord);
}



#endif
