�GSN    ���>��_qZ!r8:RNo1eS��U�xd�+ ͺ�(q[��͚N��N��b�s<�Q3Q�CF9Y���Pm�Tgґ��$D�^p�{���ҁ"����hh�u�Ti�%�.8���[Dx�4�Mk�X �p�'�Pz���ގi�MI��<������z����3���7��y�J�槟b4#0��ZW�'"χ����8��I��#��i +��������)^�M`>q������.x����N�^h;(Lp��қ��+d��\y��L;�wAF�Q��㞁Y�� �eѴ��a:�������b��Xg��f�&L+�k1>������..�.���N�8C�#	�(ϻqTg~���Q������$�0;�=]���j����{ze\׮�5n�K�����	����{��L�� ��RRAÉ��#�.��t���2"X��<�b�r�-U����v�٣��ԋ}ؼ�`>����rR/)�-�-�e�]dqe bݝ���JV.y) * 1.0) * waterFactorX ;
    wave_uv.y = cos(CC_CosTime.w + (tilledUV.x +tilledUV.y) * 1.0) * waterFactorY;


    gl_FragCo�or = v_fragmentColor * texture2D(CC_Texture0, tilledUV + wave_uv);
    //gl_FragColor = vec4(v_texCoord,0.0,1.0);
}
