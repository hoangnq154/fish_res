�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B8�5ppp:^	���A	}��Z?W�̭�0O�>Vg�j�Л͆m����#�
7�o�<�{:���TN�"�28n�5*�W*��aL�����/�<S��}������w����Z���7��i�H����5W0��j}�7"�����}P��E��)��psTd���좘��8j�#ppY9L������=u����S�l#4R������mf��'���>
�R��Ғ�_��d�7���4{啝�v�W�B�~��>��	�S:+�B/������9.�����g�=�j��,~do爞R�G�U����b+�YE�fź�Jވ��%,��'�2L�S� �r���+��u?��4�(���;��\>6V��V��4���3���$-z��#�L&��-]Ɩ��|�������rҽ�y��تpEl-�(�y]e�i�k^*yEi���ہ}rary/Common.glsl"
#include "../Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
 �  gl_FragColor = texColor;
}

#endif
