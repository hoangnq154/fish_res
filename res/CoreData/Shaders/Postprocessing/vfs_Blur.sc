�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B8�5ppp:^	���A	}��Z?W�̭�0O�>Vg�j�Л͆m����#�
7�o�<�{:���TN�"�28n�5*�W*��aL�����/�<S��}������w����Z���7��i�H����5W0��j}�7"�����}P��E��)��psTd���좘��8j�#ppY9L������=u����S�l#4R������mf��'���>
�R��Ғ�_��d�7���4{啝�v�W�B�~��>��	�S:+�B/������9.�����g�=�j��,~do爞R�G�U����b+�YE�fź�Jވ��%,��'�2L�S� �r���+��u?��4�(���;��\>6V��V��4���3���$-z��#�L&��-]Ɩ��|�������rҽ�y��تpEl-�(�y]e�i�k^*yEi���ہ}rary/Common.glsl"
#include "../Library/Lighting.glsl"

#define LENGTH 0.0025

void main()
{
    vec4 color = texture2D(u_diffus�Tex,v_texcoord0);
     vec4 sum = vec4(0.0);

           // blur in y (vertical) take nine samples, with the distance LENGTH be'ween them
           sum += texture2D(u_diffuseTex, vec2(v_texcoord0.x - 4.0 * LENGTH, v_texcoord0.y)) * 0.05;
           sum +� texture2D(u_diffuseTex, vec2(v_texcoord0.x - 3.0 * LENGTH, v_texcoord0.y)) * 0.09;
           sum += texture2D(u_diffuseTex, vc2(v_texcoord0.x - 2.0 * LENGTH, v_texcoord0.y)) * 0.12;
           sum += texture2D(u_diffuseTex, vec2(v_texcoord0.x -       L+NGTH, v_texcoord0.y)) * 0.15;
           sum += texture2D(u_diffuseTex, vec2(v_texcoord0.x, v_texcoord0.y)) * 0.16;
           �um += texture2D(u_diffuseTex, vec2(v_texcoord0.x +       LENGTH, v_texcoord0.y)) * 0.15;
           sum += texture2D(u_diffuseT	x, vec2(v_texcoord0.x + 2.0 * LENGTH, v_texcoord0.y)) * 0.12;
           sum += texture2D(u_diffuseTex, vec2(v_texcoord0.x + 3.� * LENGTH, v_texcoord0.y)) * 0.09;
           sum += texture2D(u_diffuseTex, vec2(v_texcoord0.x + 4.0 * LENGTH, v_texcoord0.y))�* 0.05;

           gl_FragColor = sum;
}

#endif
