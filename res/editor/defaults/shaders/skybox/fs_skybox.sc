�GSN    �̅9��N79_Qn^��W�qd�`{_���Xi> ����O��%��QW�qy�nC49�PMor���[ u�Zb��� �+P�^5�j��Ȭj؀��?dk�Vh�Ur�+�a"���Hoy��Dp��#�!�Mo�׉�b�0Mơ8գ���a����*���+��Gw�����u*,��Z(�+*Ĝ�����eP��T��*��&
%�������r�Mp[7B���ρ=cT����P�M+rgHL���.n��4j��k�{_C�v��폮=��W���n6̯��o�[�E�=h��Ew>��2�_oTT�x /������vg�����82�?d�(ϻqTg|���&�����bP�%*�z����Z��͝-6�� �:?d�6o�D�v�����D��_�"���i��1P0 ��t�y�.��1���2,W��i�[2`$��VD���:����Ɵ�}���R, ���sXs~�&I�:GG�_�kW1xh,ĝ���micColor[2][0],u_sceneHemisphericColor[2][1],u_sceneHemisphericColor[2][2]);

    float h = normalize( v_FragPos.xyz + offset.xy�).y;
    gl_FragColor = vec4( mix( groundColor.xyz, mix(equatorColor.xyz,skyColor.xyz,0.2), max( pow( max( h , 0.05), exponent.+), 0.1 ) ), 1.0 );
}






