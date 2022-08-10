�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��4�Pzi�m=}-�PU']���Xj��N�݌�0R�bF{�i�똝�x����4^V�Dl�Yx�B�`'��J�W�8)d%��j��Cw��ʥ�Q�s*Q��/۷���5����#��7Κ+s����{x��>I�-ߜ��뚋?��V��"��) 7	�Բ�����>q�Ec�����EyO����Q�Rj;tj�Ӗ���,g��}��E�pDL�G�����@ڥU�cյ��u=����?�[��=D��^BZ��f�yoeN�r'������[M�8�����d_�a��'$>���k�,�X����yg�p&�*X��������)7��]�8n�:r��C���J��R��x�k���;��V("V��b��'�	��^���3aS��$�8*)k�X�j쨜�z�ź[����k���V5I�ѯ©hgs1�K^�+�C�W	PA=۝���W?vec4(a_position.xyz, 1.0));
    v_fragmentColor = a_color0;
    v_texCoord = a_texcoord0;
}



#endif

#ifdef FS
$input v_fragm�ntColor, v_texCoord

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
unifor> mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4�CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);

uniform vec4 _effectColor;
uniform vec4 u_textColor;

uniform vec4 u_effectType;


void main()
{
   vec4 sample = texture2D(CC_Texture0, v_txCoord);
    // fontAlpha == 1 means the area of solid text (without edge)
    // fontAlpha == 0 means the area outside text, i�cluding outline area
    // fontAlpha == (0, 1) means the edge of text
    float fontAlpha = sample.g;

    // outlineAlpha == ] means the area of 'solid text' and 'solid outline'
    // outlineAlpha == 0 means the transparent area outside text and outlin�
    // outlineAlpha == (0, 1) means the edge of outline
    float outlineAlpha = sample.r;

    if (u_effectType.x == 0.0) // �raw text
    {
        gl_FragColor = mul(v_fragmentColor , vec4(u_textColor.rgb,  u_textColor.a * fontAlpha));
    }
    else f (u_effectType.x == 1.0) // draw outline
    {
        // multipy (1.0 - fontAlpha) to make the inner edge of outline smootherSand make the text itself transparent.
        gl_FragColor = mul(v_fragmentColor , vec4(u_effectColor.rgb, u_effectColor.a * ou|lineAlpha * (1.0 - fontAlpha)));
        //gl_FragColor = mul(v_fragmentColor , vec4(u_textColor.rgb, u_textColor.a * fontAlpha);
        //gl_FragColor = vec4(1.0,0.0,0.0,0.0);
    }
    else // draw shadow
    {
        gl_FragColor = v_fragmentColor *�vec4(u_effectColor.rgb, u_effectColor.a * outlineAlpha);
    }
}


#endif
