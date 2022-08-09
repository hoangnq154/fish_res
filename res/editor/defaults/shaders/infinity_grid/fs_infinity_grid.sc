�GSN    �̅9��N79_Qnxpe��I�zh�6y���Fć��-��-��i�th�=*4�Fy!D	���>v�c�Ӫ�bC�Vt�i��ΰ�:ҋ��ec�6�.�g� a���8]U$��T%A1��,9�3�Cq݊�i�0R�� s���㛵���U"���v��BY^|��鼉)3`��e)�1/ʂ����>��V����n)T1���创��84�$z?	sB��ά��cR���F�+<$_E�����m+��=��i�hL^�C���ݓA	��b�i׿��)h����V?�[��u��.��p�hjD�5%��^����1'�f���J�(@�i\�z��%1o����m�Z����b�=*�t����X����8\e��� U0�S=�U�K���лN��b�k�B��u��M)P��J��y�@��Y���waX��x�_8M"��uU�؞�}�ȰG����w���[uA����?!~�c\�y �o�(kE*�����W?0.0, 0.0, (2.0 - min(line, 2.0)) * 0.1);
    // z axis
    if(fragPos3D.x > -1 * minimumx && fragPos3D.x < 1 * minimumx)
   �    {color.z = 1.0;color.w = (2.0 - min(line, 2.0));}
    // x axis
    if(fragPos3D.z > -1 * minimumz && fragPos3D.z < 1 * m:nimumz)
        {color.x = 1.0;color.w = (2.0 - min(line, 2.0));}
    return color;
}



float computeDepth(vec3 pos) {�    vec4 clip_space_pos = mul(mul(u_proj , u_view) , vec4(pos.xyz, 1.0));
    return (clip_space_pos.z / clip_space_pos.w);
}w



float computeLinearDepth(vec3 pos) {
float near =u_nearfar.x;
float far  = u_nearfar.y;
    vec4 clip_space_pos = mulFmul(u_proj , u_view) , vec4(pos.xyz, 1.0));
    float clip_space_depth = (clip_space_pos.z / clip_space_pos.w) * 2.0 - 1.0; //�put back between -1 and 1
    float linearDepth = (2.0 * near * far) / (far + near - clip_space_depth * (far - near)); // get  inear value between 0.01 and 100
    return linearDepth / far; // normalize
}


float computeDepth2(vec3 pos) {
	vec4 cli�_space_pos =  mul(mul(u_proj , u_view) , vec4(pos.xyz, 1.0));
	float clip_space_depth = clip_space_pos.z / clip_space_pos.w;
�
	float far = gl_DepthRange.far;
	float near = gl_DepthRange.near;

	float depth = (((far-near) * clip_space_depth) + near +Jfar) / 2.0;

	return depth;
}

void main()
{
    float t = -v_nearPoint.y / (v_farPoint.y - v_nearPoint.y);
        vec@ fragPos3D = v_nearPoint + t * (v_farPoint - v_nearPoint);
        gl_FragDepth = computeDepth2(fragPos3D);
        gl_FragCodor = grid(fragPos3D, 1.0 ,true) * float(t > -0.001);

         float linearDepth = computeLinearDepth(fragPos3D);
           float fading = max(0, (0.25 - linearDepth));
            gl_FragColor.a *= fading;

}


