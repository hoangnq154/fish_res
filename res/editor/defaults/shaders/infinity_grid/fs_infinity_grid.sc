�GSN    �̅9��N79_Qnxpe��I�zh�6y���Fć��U��+��^i� !<�B&/7�7C@2Y[���]w��Tgґ� �,S�Ut�4���Ӑu΁��U/(�6�.�f�!���?SSO��[#�7�q�(�`b�����a�1��LW�᧍��r��� ���8��F:i�.����u8�� h8�b.ā����&1��W��4��= T<��������?&�gs"p2������5,����P�og	�����(y��{��;�>K]�Q�Ԫ��Y��1�*��e0�ꊙ{��M�/��VOz��l�~+
�-@�F�^����$!�/��	�|�h�3�q+e��X�#��λ�,E�!&�gL���Vά��{ze\׮�6�4t��X�܅UлN��r�=���~��^CvI.����9���9���:4S��,�[?/�
�{Ǒ��=À����>���F:U���ǣm<~�c\�qDA�,�8o1 y�����I10 - min(line, 2.0)) * 0.1);
    // z axis
    if(fragPos3D.x > -1 * minimumx && fragPos3D.x < 1 * minimumx)
        {color.z = �.0;color.w = (2.0 - min(line, 2.0));}
    // x axis
    if(fragPos3D.z > -1 * minimumz && fragPos3D.z < 1 * minimumz)
        {0olor.x = 1.0;color.w = (2.0 - min(line, 2.0));}
    return color;
}



float computeDepth(vec3 pos) {
    vec4 clip_space_pos =�mul(mul(u_proj , u_view) , vec4(pos.xyz, 1.0));
    return (clip_space_pos.z / clip_space_pos.w);
}



float computeLinearDepthRvec3 pos) {
float near =u_nearfar.x;
float far  = u_nearfar.y;
    vec4 clip_space_pos = mul(mul(u_proj , u_view) , vec4(pos.xy, 1.0));
    float clip_space_depth = (clip_space_pos.z / clip_space_pos.w) * 2.0 - 1.0; // put back between -1 and 1
    float�linearDepth = (2.0 * near * far) / (far + near - clip_space_depth * (far - near)); // get linear value between 0.01 and 100
   Lreturn linearDepth / far; // normalize
}


float computeDepth2(vec3 pos) {
	vec4 clip_space_pos =  mul(mul(u_proj , u_view) , v�c4(pos.xyz, 1.0));
	float clip_space_depth = clip_space_pos.z / clip_space_pos.w;

	float far = gl_DepthRange.far;
	float near � gl_DepthRange.near;

	float depth = (((far-near) * clip_space_depth) + near + far) / 2.0;

	return depth;
}

void main()
{
   Jfloat t = -v_nearPoint.y / (v_farPoint.y - v_nearPoint.y);
        vec3 fragPos3D = v_nearPoint + t * (v_farPoint - v_nearPointZ;
        gl_FragDepth = computeDepth2(fragPos3D);
        gl_FragColor = grid(fragPos3D, 1.0 ,true) * float(t > -0.001);

    (    float linearDepth = computeLinearDepth(fragPos3D);
            float fading = max(0, (0.25 - linearDepth));
            gl_vragColor.a *= fading;

}


