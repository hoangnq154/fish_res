�GSN    �̅9��N79_QnY7b��U�yt�'uS���Yi?������!��
e�'}}�x:r�PU2IR"���w�V���x�O<�Zs�}칃ؐ-����dh�m}�Ys� �|'�ă]U(S�L�qG9��#�2�w���c�BR5��;�����vޤ��1��1��SQs��߼�wW::�Ak;�1)�������7����,��xx%��������4o�gx1yJ�⢥��B����Y�+(5Q\�蛁��?+��
j�Vn�mNO�P��F��c�I׼�[cّݶZj�M�I�O��^_~��q�YdK�o5z�=�#ޭ��gk�.����x�P�P��>:Է�i�v�6����4�`o�"M���M����%vT���<n�<p��E�����K��&�-{�N��h��Z::M��G��<�2��;���
-ҡS�Q4M.��dÐ��z��Y����C���
bl�����iRbm�cN�8  �C�d]-=iߑ���@sceneHemisphericColor[2][0],u_sceneHemisphericColor[2][1],u_sceneHemisphericColor[2][2]);

    float h = normalize( v_FragPos�xyz + offset.xyz).y;
    gl_FragColor = vec4( mix( groundColor.xyz, mix(equatorColor.xyz,skyColor.xyz,0.2), max( pow( max( h ,s0.05), exponent.x), 0.1 ) ), 1.0 );
}






