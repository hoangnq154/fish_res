�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B8�5ppp:^���Z8ٕ=_?��&�x�!}R�,���ц}����ct�Wa�fe�<�v���@�U�qY��s �[�Ff��ܛ�Y�0x�� �Ý���V����EO���=��E^8��˲�cX>��j:�% ؂Սڳ�4��A����\N7���ꇔ��4k�({pSb��Ǭ��o ����O�Py"4����Х$e��	k�\W�|_K�L��퐘Y��f�f�څ�o:�ꀊq��W�^'��g��o�+�t8��Q����k!�$����f)�cX�=��"e ����n�R����'M�&�;U����^����=�� �i:b�8q��^ʄ���B��q�|h���}��!5xp]��A��!�R��2���wm9��S�|v�,�U6����#���[����{���J;�����~Ex7�a�5�
�'p=c&ę���Sjniforms,samplers, transforms ... )
#include "Library/Common.glsl"
#include "Library/Lighting.glsl"

void main()
{
    vec4 texC�lor = texture2D(u_diffuseTex,v_texcoord0);
    gl_FragColor = vec4(texColor.rgb,texColor.a);
}

#endif
