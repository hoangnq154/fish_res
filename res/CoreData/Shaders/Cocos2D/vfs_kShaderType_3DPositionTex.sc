�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�+��h�Pzi�m=}-�GL_���Aq�|X�ĻA�u�8~t�}��η�w҃��!k�Q,�sC��b:�хEw>��-�q�j�#�n�ц޻O�4	r��4άț��s���$�����l<.W��Ы�"6��i}�#8�δď݋=��M����Pa 8�������5o�(g=[z�܈���cS����]�Mb7|4\�征��m}��H/��!O�sH�@��䒇[@�i�*��Ёi=У��M�P�J�j�RO:��@�0uxs�pq������$x�(���<�Z�iV�#��[~dc珛A�(�����+�2=�fv����\���.^6Մx�7m�+p��N���7��B��r�8�
��r��S-)��%��<���t���caK/��k�FJ9��d����}�ʺG�Ɵ�}���|5���sXse�5�7	�r�(_>iiܫ���OrojMatrix;

void main()
{
    gl_Position = mul(mul(u_viewProj,CC_MVMatrix) , vec4(a_position.xyz, 1.0));
    v_texCoord = a_te�coord0;
    v_texCoord.y = 1.0 - v_texCoord.y;

    vec3 _normalVector = a_normal;
}



#endif

#ifdef FS
$input v_texCoord

#i=clude "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_MVMatrix;
unif�rm mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
uniform vec4 C9_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);

uniform vec4 u_color;


void main()
{d    gl_FragColor = vec4(texture2D(CC_Texture0, v_texCoord).rgb,1.0);
}


#endif
