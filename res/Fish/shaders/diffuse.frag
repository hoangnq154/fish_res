�GSN    �˅1��\7=*h.dRNo1eS��U�xd�+ ͺ�(q[����E��"��s�sx�{L�)/>6Q��� }�|�Ӫ�bb�G`�j���ϗVΑɯ}wg�\q�W �-�g;���WD@@�(�O%�^�	�#�KmÅޑ�|�:\��������aщ��7���9��Do��϶�(W: ��w)�!?聘����[��]��(Ґxd?����آ�6i�"yx������BW����R�f*#W\������,��b�s�_S�[�����@�z�yѤ�nh��Ύl�3�Z�~��Px��1�'sS�o	�	�����	�*���(�n
�e��8!���9�;�N����b�0|�?k���Z����J$���y
n�k=�*�L�����d��s�{A���r��RI<A��K��
��� ���lL4��u�\6-��yUǑ��(���T����y���@mA�ѩĿvCh1�=2�z�i�8R-C�����prm vec4 u_color;
uniform mat4 u_MMatrix;
uniform sampler2D u_causticTex;

float calc(vec2 p){
    return p.x * p.x - p.y;�}
vec2 pixel_step = vec2(0.1,0.1);
vec3 color = vec3(0.0,0.0,0.0);

void main(void)
{

	vec3 objColor  = texture2D(CC_Te+ture0, TextureCoordOut).rgb;


	vec2 projectTexCoord = vec2(0.0,0.0);
	projectTexCoord.x = p_position.x / p_position.w / 2.� + 0.5;
	projectTexCoord.y = -p_position.y / p_position.w / 2.0 + 0.5;

	if(clamp(projectTexCoord.x,0.0,1.0) == projectTexCord.x && clamp(projectTexCoord.y,0.0,1.0) == projectTexCoord.y)
	{
		color = texture2D(u_causticTex,projectTexCoord).rgb;
	}d

//	vec2 v_causticsCoord2 = vec2(TextureCoordOut.x - (model_position.z + 90.0) / 18.0 ,TextureCoordOut.y - (model_position.x�+ 90.0) / 18.0 ) / 4.0 ;
//	vec3 causticColor  = texture2D(u_causticTex,v_causticsCoord2).rgb;

	vec3 diffuse = (v_diffuse *L1.0 + v_ambient) * objColor + v_diffuse * color * 1.5;

	gl_FragColor = vec4(diffuse,1.0)  * u_color /** smoothstep(0.0,lengt�(fwidthcustom),1.0 - length(TextureCoordOut))*/;

}
