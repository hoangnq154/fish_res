�GSN    �˅1��\7=*h.c(Lx7oI���pe�78���&d�Ћ�D��N��`�5[�B)W-�[].W]���A h��rJ���7D�+\z�k�쁆�oڗ��f&�@|�Em�h�k-���$VN��@|_1��dU�>�R#�����z�2]�� )������|���!��.��D	L:�5�ئ�n/,��v9�H:ʜ����<��Q��o��~3T'��������2r�({kqa������"iE�����Sd.3]�����,y��h��x�>]u�Z�����X[��o�y����r*���� z��x�s��Roa��g�n0-�|3��^����$x�/���
�mT�{X�j��6T1o���B�,�^����yg�2=� Z����\���#0���d�=&��_���РB��z�.�=��h��PdxR��V��2���5���>,[K��m�K8M,��nA����|�š\��ҡ=ҡ�J?k���ޢvQn,�&I�:@O�_�g^0oCܚ���	r mat4 u_MMatrix;
uniform sampler2D u_causticTex;

float calc(vec2 p){
    return p.x * p.x - p.y;
}
vec2 pixel_step = vec2(0.1,�.1);
vec3 color = vec3(0.0,0.0,0.0);

void main(void)
{

	vec3 objColor  = texture2D(CC_Texture0, TextureCoordOut).rgb;


	vec2sprojectTexCoord = vec2(0.0,0.0);
	projectTexCoord.x = p_position.x / p_position.w / 2.0 + 0.5;
	projectTexCoord.y = -p_position�y / p_position.w / 2.0 + 0.5;

	if(clamp(projectTexCoord.x,0.0,1.0) == projectTexCoord.x && clamp(projectTexCoord.y,0.0,1.0) ==ZprojectTexCoord.y)
	{
		color = texture2D(u_causticTex,projectTexCoord).rgb;
	}


//	vec2 v_causticsCoord2 = vec2(TextureCoordOt.x - (model_position.z + 90.0) / 18.0 ,TextureCoordOut.y - (model_position.x + 90.0) / 18.0 ) / 4.0 ;
//	vec3 causticColor  = �exture2D(u_causticTex,v_causticsCoord2).rgb;

	vec3 diffuse = (v_diffuse * 1.0 + v_ambient) * objColor + v_diffuse * color * 1.Y;

	gl_FragColor = vec4(diffuse,1.0)  * u_color /** smoothstep(0.0,length(fwidthcustom),1.0 - length(TextureCoordOut))*/;

}
