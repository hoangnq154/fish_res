�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��4�Pzi�m=}-�PU']���Xj��N�݌�0R�bF{�i�똝�x����4^V�Dl�Yx�B�`'��J�W�8)d%��j��Cw��ʥ�Q�s*Q��/۷���5����#��7Κ+s����{x��>I�-ߜ��뚋?��V��"��) 7	�Բ�����>q�Ec�����EyO����Q�Rj;tj�Ӗ���,g��}��E�pDL�G�����@ڥU�cյ��u=����?�[��=D��^BZ��f�yoeN�r'������[M�8�����d_�a��'$>���k�,�X����yg�&!�/[����Zɶ��)��I�S_b�:q�����G��E	��n�4*���t��Q\,��Z��3���9���w4a��{�@>I��d����|���X����7���yA����pDh*�iQ�dT�l�eG35Uߝ���	pjMatrix,CC_MVMatrix) , vec4(a_position.xyz, 1.0));
    v_fragmentColor = vec4(a_color0.rgb * a_color0.a * u_alpha.x, a_color0.a�* u_alpha.x);;
    v_texCoord = a_texcoord0;
}



#endif

#ifdef FS
$input v_fragmentColor, v_texCoord

#include "../Library/Ba e/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix�
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform ve4 CC_CosTime;
uniform vec4 CC_Random01;

//SAMPLER2D (CC_Texture0,0);


void main()
{
    // gl_FragColor = v_fragmentColor * txture2D(CC_Texture0, v_texCoord);

    gl_FragColor = v_fragmentColor * step(0.0, 1.0 - length(v_texCoord));
}


#endif
