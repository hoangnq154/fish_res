�GSN    �̅9��N79+B ,Wr:*	��T�x`�n4.���(]����O�
�1��[�t{�re+�CF_���ky��xů��+P�Vs�a�����J祿�2E/�q�@u�h�Q*��K8��[v4��	Q�?�Ww��횙x�KU��(·����a����+���T��y�����4Ycq��O*r�lc聅��0_��E��=��Qi8�������te�*x?9�͢Ԛ�&jN����]�+:IF�༣��?b��v��x�>xD�G��瞁f��~�lԿ� +�ꋇ~�� �k��Ct��n�.+Q�xf��
����kd�(����(�-�3��%@g|���}�;�����'�6g� Q��������!q\���}�d=��H���@��H��c�%�Y�;��ZkRQ��]��0������#aP޹y�<V'��h����?�ܧZ����7��U<�����f!$�&�i]F�
�(oE=܆�ԸorojectedPoint.xyz / unprojectedPoint.w;
}

vec3 gridPlane[6] = vec3[] (
    vec3(-1, -1, 0), vec3(1, -1, 0), vec3(-1, 1, 0),
  � vec3(1, 1, 0), vec3(1, -1, 0), vec3(1, 1, 0)
);

void main()
{

    vec4 position = vec4(a_position.xyz,1.0);
    vec3 p = pos:tion.xyz;
    v_nearPoint = UnprojectPoint(p.x,p.y,0.0,u_view,u_proj);
    v_farPoint = UnprojectPoint(p.x,p.y,1.0,u_view,u_pro�);

    v_FragPos = mul(mul(u_view ,u_worldMatrix) ,  position);
    mat4 mvp = u_viewProj ;
    gl_Position = position;
}

