�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ����4��^r� pd�r;9Q�pWZ)V���U,��7N(�Ļ�:�]|�`���Вm�ű�(Ls�Qq�Ye��o:�� zHj��[=��7U��oU��ƌ�t�s*Q��/۷���5����#���,��`t��˾�w8k��"[�.8¸��ݨ=��V��Ơ&
$����ś��/5�V5x��ē��=eY����U�Py"gHL�����b��G��}�l@
�P�����i3��^�g�녧n:⥟�Vi�]��=X��Dxg��8�tbA�oj��Jқ��Vo�/���N�e�dW���4Te$�û]�?�N����1�0 �$[�������&7���m\~�/t��_���	��N��a�/���u��xDxR��C��:���;���w,Kֹy�$|=��]ܒ��g�ŭ����H���Q0�����zT5v�YO�*�o�&J&gx�����q?   v_texCoord = a_texcoord0;
}


#endif

#ifdef FS
$input v_texCoord

#include "../Library/Base/common.sh"

uniform mat4 CC_PMa�rix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatr:x[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Ran�om01;

SAMPLER2D (CC_Texture0,0);




void main()
{
    gl_FragColor = texture2D(CC_Texture0, v_texCoord);
//    gl_FragColor =Zvec4(v_texCoord.x,v_texCoord.y,0.0,1.0);
}



#endif
