�GSN    ���>��_qZ!x":wSOt/��^�!!�'!6�ϗ.~Aϗ��S�
�+��k� pd�t!	2�3Q���)8�� t �˦�bP�Ra�y��؋F���ng�l�]e�B�n���^H� �Ap�[E�\�%�K{��ޛ�x�"nb��UW������z���,���~��	!w��Ы�{)+��:5 �;e��ק�=����7��zt$���啛��6g�5|(+v��ܻ��"[����m#(_]�����+g��'��
3�w@O���甒^��*�*е�h'����V?�R�M�^q��
x��(�B4;�=/��
����$.�'��_�(R�{\�g��=*�̀]�9�����bM�6,�iP�������80��6�6#�I��C�ˉ��Sޣa�_g�Kݸ;��RI<F��[��u�Q��,���2sz<��$�mF3��`Yŝ��;΀���ق%�ŘyA����1O!c�.�8 �.�(/y�����U/) * maxMagtunide;
    data1.y = ((data1.y * 2.0) - 1.0) * maxMagtunide;
    data1.z = ((data1.z * 2.0) - 1.0) * maxMagtunide;
 �  data1.w = 1.0;

    data2.x = ((data2.x * 2.0) - 1.0) * maxMagtunide;
    data2.y = ((data2.y * 2.0) - 1.0) * maxMagtunide;
 s  data2.z = ((data2.z * 2.0) - 1.0) * maxMagtunide;
    data2.w = 1.0;

    return mix(data1,data2,(time - v1) * height);
}

ve�4 getGPUSkinnedPositionFromTexWithTime(sampler2D u_TexAnim, float vertex_ID,float time)
{
    float width =  u_matrixPalette[1]Tx;
    float height = (u_matrixPalette[1].y);
    float maxMagtunide = u_matrixPalette[1].z;
    float lineCount = u_matrixPalete[0].w;

    // cal u
    float u = fract(vertex_ID / width);
    // cal v
    //float perPixel = lineCount / height;
    //fl�at v = float(int(time * height)) / height;
    //v += floor(vertex_ID / width) * perPixel;
    //float v = time + floor(vertex_%D / width) * perPixel;

    float v= (time + (floor(vertex_ID / width))) / lineCount;


    vec4 data1 = texture2DLod(u_TexAnim�vec2(u,v),0);

    data1.x = ((data1.x * 2.0) - 1.0) * maxMagtunide;
    data1.y = ((data1.y * 2.0) - 1.0) * maxMagtunide;
    �ata1.z = ((data1.z * 2.0) - 1.0) * maxMagtunide;
    data1.w = 1.0;
    return data1;
}


vec4 getGPUSkinnedPosition(sampler2D _TexAnim, float index)
{
    return getGPUSkinnedPositionFromTexWithTime(u_TexAnim,index,u_matrixPalette[0].x);
}

#endif

#ifdf INSTANCING

mat4 getInstanceMatrix(vec4 i_data0,vec4 i_data1,vec4 i_data2,vec4 i_data3)
{
    mat4 model;
    model[0] = i_da|a0;
    model[1] = i_data1;
    model[2] = i_data2;
    model[3] = i_data3;

    model[3].w = 1.0;

    return model;
}

#endif: