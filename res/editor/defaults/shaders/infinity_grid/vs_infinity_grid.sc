�GSN    �̅9��N79+B ,Wr:*	��T�x`�n4.���(]������4��^r�2g}�M:q-�GU2`	�ߥB2~��$~����H;�KZs�k���Ӗ}����#@H�`\�=
�!�~;ҧ�$VF�z�_G �E�\�%���ې�y�Y6`��<������e���*!��m��~�����}o6��q9�bn��ة���_˛��=��|te�����o�5t"8 ���"aN����5E2P@�㪃��,��	P��w�SL^�\�����<m��o�9���r<�&p�P��h��T"��o�n+^�=&��^��ɐez�k����(�y�c��;$~����6�6����/�go� Q������67���<"�T�U����\ЦU��y�Vv���~��-N��[��;�J��t���!$]Dޡb�@>I.��i%ܑ��3���X����k���J<�ோ�?Gs1�OQ�pXO�v�kwei����[..0));
    return unprojectedPoint.xyz / unprojectedPoint.w;
}

vec3 gridPlane[6] = vec3[] (
    vec3(-1, -1, 0), vec3(1, -�, 0), vec3(-1, 1, 0),
    vec3(1, 1, 0), vec3(1, -1, 0), vec3(1, 1, 0)
);

void main()
{

    vec4 position = vec4(a_pos:tion.xyz,1.0);
    vec3 p = position.xyz;
    v_nearPoint = UnprojectPoint(p.x,p.y,0.0,u_view,u_proj);
    v_farPoint = Unpr�jectPoint(p.x,p.y,1.0,u_view,u_proj);

    v_FragPos = mul(mul(u_view ,u_worldMatrix) ,  position);
    mat4 mvp = u_viewPro ;
    gl_Position = position;
}

