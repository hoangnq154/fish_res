�GSN    �˅1��\7=*h.dRNo1eS��U�xd�+ ͺ�(q[����E��"��s�ge�si+>�NBV���Z[�cC����;_�c�l����|æ��e=�/�En�.�|#��SSS��G$�6�f�j�(v��ԑ�a�3P��N*�㧜��v����xO��:��H:�5����4Fxn��S2P�OFހ���q����&��xd+,����ڀ��V�(|4[z������4+��́J�\9o3WE�鼻��p+��j��t�z �C�߰��P��$�#�݅�
s��͝|��M�X��!��#�{}B�hd�F�^����GM����Q�(D�%M���5!$���@�!�Y����;D�yo�y�������26$�� �bq�y=��[���ޯF��x�^�=��v�YZP��C�� �_�����;$Z%��u�{y�V�$U�؄�g�ޓT����%�ŵ)yA���ί-g7�gS�TR�t�d^:yu��郬z_uv ;
    //finalUV.x += (CC_Time.y / (2.0 * M_PI)) * horizontalSpeed / 10.0 ;
    finalUV.x = fract(finalUV.x);

    gl_Fr�gColor = v_fragmentColor * texture2D(CC_Texture0, finalUV);
    //gl_FragColor = vec4(wave_uv,0.0,1.0);
}
