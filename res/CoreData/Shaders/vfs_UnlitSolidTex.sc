�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B8�5ppp:^	���A	}��8x�Ľ�S�Vm�a�쁓�uȉШ}.)�w�Dp�<�-*��W&3�9�$?g�/:�F-��pG�����o�;Z��"4�壜�C����"���-ڃ+`Q5�J�־�ulw��b2�/?�����"��I��a��=)~i��������yJ�%g1	nMрų��akM��ϫ6�Pb+gSH������G+��\/��x�kIO������D��k�x��߽s:𣂅0v�_��t��=.��#�thK�yj�*�����+C�(���+�p�bK�#��?+$X�G�6��+�Yl�/P����l����oP,���zn�0s�U�~���7��h.��C�.�-��+��Q3@ś��7���{���.(Pг`�^s)A�W�-6ܕ��}���[����s���B4����?Cs?�uY�+�.�&v Ǘ���?"Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texColor = texture2D(u_diffuseTex,v_texcoord0);
�   gl_FragColor = vec4(texColor.rgb,texColor.a);
}

#endif
