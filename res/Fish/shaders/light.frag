�GSN    ���t��^rFa",3$t_��R�{!�'1���W!|@ˇ��*�� ��s�~6u�y	/}�%ggM:pj���Mv��t�Т�4S�\c�i���ЖwϦ��s=�/n�By�&�.#��_WS��[ v$�&�l�j�( ������-F��	}��ڱ�J���� ��1��SQs�����}W::�Ar�'4聘����[}�A��&��~?���ֱ�7i�35'c�ɽ��=T����U�Py"gXE���έ�9n��l��B�''�@��䒇[@�i�*̹�e7۬��p��&�tq��Sc��m�Z\�c@�F�^����$z�'���*�(R�{f�v��>5n���B�.�����sC�zt�C��V����&k׳R�+h�qi��H���F��v��7�V?�����\FRbRB��L��!���0���.h}���q=��-Ҏ��f͌�����6��iO����?!~�gI��x�5<rSa귖��Kime.w + (tilledUV.x +tilledUV.y) * 1.0) * waterFactorX ;
    wave_uv.y = cos(CC_CosTime.w + (tilledUV.x +tilledUV.y) * 1.0) * �aterFactorY;


    gl_FragColor = v_fragmentColor * texture2D(CC_Texture0, tilledUV + wave_uv);
    //gl_FragColor = vec4(vtexCoord,0.0,1.0);
}
