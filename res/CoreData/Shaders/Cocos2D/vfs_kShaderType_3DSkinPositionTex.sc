�GSN    �˅1��\7,5Q	(Kitge��R�|n�nu��$@ؗ�� �!�!��p�TtC�s >>�VU^���>Iw��d�Ӑ�:u�Aq�+��͆m����fn�fw�_r�B�g ��WQN�X�[1�J�b�~�Mn���Ћd�sUJ��2�����!����%��7Κ+s����{x��>I(�6%�����ݟ%����t��si%����ϥ�E�
Cc���Ԛ�&jN����]�+ad�ܕ���$s��	a��i�>@K������C�\�oϝقM2𸄓-+��Y�a��Zc��0�0YTi�o+�+�
����{�"����~
�9�P��8"1���]�"�Q����vM�� Z������&7���m\H�^��D�Þb��N��z� .�V��X��Q0��%��_���=���
w>��B�ml�,�N:涧�%�����xؽ�PS��ľrw;�2��r�pb>qE=ݑ���2QNING_JOINT_COUNT * 3];

uniform vec3 u_sceneHemisphericColor[3];
uniform vec4 u_lightDirection;
uniform vec4 u_lightColor;


ve�4 getPosition(vec4 a_blendWeight,vec4 a_blendIndex,vec3 a_position)
{
    float blendWeight = a_blendWeight[0];

    int matrixndex = int (a_blendIndex[0]) * 3;
    vec4 matrixPalette1 = mul(u_matrixPalette[matrixIndex] , blendWeight);
    vec4 matrixPal�tte2 = mul(u_matrixPalette[matrixIndex + 1] , blendWeight);
    vec4 matrixPalette3 = mul(u_matrixPalette[matrixIndex + 2] , blndWeight);


    blendWeight = a_blendWeight[1];
    if (blendWeight > 0.0)
    {
        matrixIndex = int(a_blendIndex[1]) * ];
        matrixPalette1 += mul(u_matrixPalette[matrixIndex] , blendWeight);
        matrixPalette2 += mul(u_matrixPalette[matr�xIndex + 1] , blendWeight);
        matrixPalette3 += mul(u_matrixPalette[matrixIndex + 2] , blendWeight);

        blendWeightL= a_blendWeight[2];
        if (blendWeight > 0.0)
        {
            matrixIndex = int(a_blendIndex[2]) * 3;
            ma�rixPalette1 += mul(u_matrixPalette[matrixIndex] , blendWeight);
            matrixPalette2 += mul(u_matrixPalette[matrixIndex +�1] , blendWeight);
            matrixPalette3 += mul(u_matrixPalette[matrixIndex + 2] , blendWeight);

            blendWeight W a_blendWeight[3];
            if (blendWeight > 0.0)
            {
                matrixIndex = int(a_blendIndex[3]) * 3;
   S            matrixPalette1 += mul(u_matrixPalette[matrixIndex] , blendWeight);
                matrixPalette2 += mul(u_matrixPadette[matrixIndex + 1] , blendWeight);
                matrixPalette3 += mul(u_matrixPalette[matrixIndex + 2] , blendWeight);
           }
        }
    }

    vec4 _skinnedPosition;
    vec4 position = vec4(a_position, 1.0);
    _skinnedPosition.x = dot(�osition, matrixPalette1);
    _skinnedPosition.y = dot(position, matrixPalette2);
    _skinnedPosition.z = dot(position, matrixalette3);
    _skinnedPosition.w = position.w;

    return _skinnedPosition;
}

uniform mat4 u_viewProjMatrix;

void main()
{
 �  gl_Position = mul(mul(u_viewProj,CC_MVMatrix) , getPosition(a_weight,a_indices,a_position.xyz));
    v_texCoord = a_texcoord0�
    v_texCoord.y = 1.0 - v_texCoord.y;

    vec3 _normalVector = a_normal;

}



#endif

#ifdef FS
$input v_texCoord
$input v_xightColor

#include "../Library/Base/common.sh"

uniform mat4 CC_PMatrix;
uniform mat4 CC_MultiViewPMatrix[4];
uniform mat4 CC_�VMatrix;
uniform mat4 CC_MVPMatrix;
uniform mat4 CC_MultiViewMVPMatrix[4];
uniform mat3 CC_NormalMatrix;
uniform vec4 CC_Time;
�niform vec4 CC_SinTime;
uniform vec4 CC_CosTime;
uniform vec4 CC_Random01;

SAMPLER2D (CC_Texture0,0);

uniform vec4 u_color;

Cvoid main()
{
    gl_FragColor = vec4(texture2D(CC_Texture0, v_texCoord).rgb ,1.0);
}


#endif
