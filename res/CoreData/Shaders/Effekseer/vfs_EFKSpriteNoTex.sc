�GSN    �˅1��\7,5Q'Y 6Nh &[7��H�ah�,_U���30N����O�N�`��q�TtC�x*24�>JR@���]}��d�л�-C�Fa�y���ќk����uv�Q8�ot�0�a!���qH��[ v&�+
�	Q�$�RvЅġ�m�,m��(�線��J������7��M�H����s>>��NF<�'cȁ����"ǿ.��&��omT'��������)j�
t$	~��ݰ�� ~L�����JT9.[^������9y��G��}�l@
�T�����Wڇg�x�녧n:⥟�Vr�J��3f��ECd��w�t0-�s,��^����$c�����{
�63�e��5T*k����6��Π�!Y�0.�,F������!�� �yV+�<~�]�r�����H��n�Zz�Rω��R6>A����u�Q��9���.MP��o�_4Q*��#����3���Y����wæ�My\���ʸOEn4�eK�6O� �i_:oAƇ���[? 	v_vaPos = gl_Position;

   	vec4 cameraPosU = cameraPos + vec4(0.0, 1.0, 0.0, 0.0);
    vec4 cameraPosR = cameraPos + vec4(1.�, 0.0, 0.0, 0.0);

    v_vaPosR = uMatProjection * cameraPosR;
    v_vaPosU = uMatProjection * cameraPosU;

    v_vaPos = v_vaP<s / v_vaPos.w;
    v_vaPosR = v_vaPosR / v_vaPosR.w;
    v_vaPosU = v_vaPosU / v_vaPosU.w;

    v_color0 = a_color0;
    v_texc�ord0 = vec4(a_texcoord0.x,a_texcoord0.y,0.0,0.0);
    v_texcoord0.y = mUVInversed.x + mUVInversed.y * v_texcoord0.y;

}

#endifp
#ifdef FS

$input v_color0
$input v_texcoord0
$input v_vaPos
$input v_vaPosR
$input v_vaPosU

/// ----- UNIFORM
#include "../Lbrary/Base/common.sh"

SAMPLER2D(uTexture0,0);

// Materials
uniform vec4 u_time;
// end materials
/// ----------  END UNIFORM
�
void main()
{
    gl_FragColor = v_vaPos;
    if(gl_FragColor.w <= 0.0) discard;

}

#endif
