�GSN    �˅1��\7,5Q'RFwt:vOƏ_�sh�'u$�ӊ0Fj����*��"��$�'\R�B8�5ppq:^���Z8ٕ=_?��&�x�!}R�,���ц}����ct�Wa�fe�<�v���@�U�XG3��#W�8�Pb�ܝ��~�1X��.ڵ�侗:����*���+��Gw�J����{?9��w}�lb�������8��c����TN:��������5c�[/V,Ѧ���&bB�����sb-5_[������"eϩ|�t�qDN�X�����<��*�*���l&���:v�L�^�QJ��EC!��p�sdI�t +�H�����$.�d����mO�b�e��!$o����!�]�Σ�M�4#�[����PĬ��kPtRǧR�yN%�b�U�K���РF��p�)���r��\FRtR����u�_��^���1-Q��x�l>��~Ҝ��E�ɢE����.���yA��ʸ?C0~�&J�:�a�mV	tE>ٛ���JB;
   float t2 = u_cascadedViewport[2];
   float t3 = u_cascadedViewport[3];

   u =  t0 + (t2 - t0) * u;
   v =  t1 + (t3 - t1)�* v;

   gl_Position.x = u * 2.0 - 1.0;
   gl_Position.y = v * 2.0 - 1.0;
}

#endif


/// Frag shader
#ifdef FS

#include "Libr2ry/Common.glsl"

void main()
{
    gl_FragColor = vec4_splat(0.0);
}

#endif
