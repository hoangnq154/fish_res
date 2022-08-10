�GSN    �˅1��\7=*h.c._o-oT��T�e!�'6C�Ρ3e]ϰ��R�1�0��e�|r�= &*+�GWs?���Yt��p
�̡�.Y�c�l����kڂ��:�Sy�Ii�/�b!���WD@@��G$��w%�"�(u��˗�k�0Hۡ8դ���r���� �϶-��Wc�����ml)��R$	�,+΀������.��.��tnj��������o&�S"p2��䷈�;_Q����6�Zg<"4_������m}��N/��o�lHi�Z��͈�j�x�cַ��e0�꛴p�S�@�tq��NE`�u�)+Q�[+�6����e|�"���	�k\�YX�t��%8.mᘧ[�v�J����,
�%*�z���Z��ӑ%��x�8r�7z��N���	��B��e��ݸ�� F1��L��#�7��3���(Y��|�Q4A��i����f�ųZ����{���N8���ʠ@Vl<�cQ�b~�i�g@2=V,��陬zrial_diffuse;
uniform vec3 material_specular;
uniform float material_shininess;

uniform vec3 light_position;
uniform vec3 ligh�_intensities;
uniform float light_attenuation;
uniform float light_ambient_coefficient;

uniform vec4 u_color;
uniform vec3 u_v:ewPosition;
uniform int u_hasShadow;

uniform sampler2D u_normalTex;
uniform sampler2D u_specularTex;
uniform sampler2D u_shado�Tex;

float ShadowCalculation(vec4 fragPosLightSpace)
{
    // perform perspective divide
    vec3 projCoords = fragPosLightSpae.xyz / fragPosLightSpace.w;
    // transform to [0,1] range
    projCoords = projCoords * 0.5 + 0.5;
    // get closest depth alue from light's perspective (using [0,1] range fragPosLight as coords)
    float closestDepth = texture2D(u_shadowTex, projCo�rds.xy).r; 
    // get depth of current fragment from light's perspective
    float currentDepth = projCoords.z;
    // calculae bias (based on depth map resolution and slope)
    vec3 normal = normalize(v_normal);
    vec3 lightDir = normalize(light_pos�tion - v_FragPos);
    float bias = max(0.05 * (1.0 - dot(normal, lightDir)), 0.005);
    // check whether current frag pos is �n shadow
    float shadow = currentDepth - bias > closestDepth  ? 1.0 : 0.0;
    // PCF
    shadow = 0.0;
	float s = 1.0 / 1024D0;
    vec2 texelSize = vec2(s , s) ;
    for(int x = -1; x <= 1; ++x)
    {
        for(int y = -1; y <= 1; ++y)
        {
   S        float pcfDepth = texture2D(u_shadowTex, projCoords.xy + vec2(x, y) * texelSize).r; 
            shadow += currentDepth % bias > pcfDepth  ? 1.0 : 0.0;        
        }    
    }
    shadow /= 9.0;
    
    // keep the shadow at 0.0 when outside tXe far_plane region of the light's frustum.
    if(projCoords.z > 1.0)
        shadow = 0.0;
        
    return shadow;
}


voi� main(void)
{
	// init value
	vec3 lightDir = normalize(light_position - v_FragPos);
	vec3 viewDir = normalize(u_viewPosition -|v_FragPos);
	vec3 halfwayDir = normalize(lightDir + viewDir);
	vec3 norm = normalize(v_normal);


	vec3 objColor = texture2D(CC�Texture0, TextureCoordOut).rgb;
	vec3 normalTagent = texture2D(u_normalTex, TextureCoordOut).rgb;
	normalTagent = normalize(nor�alTagent * 2.0 - 1.0);

	vec3 specularColor = texture2D(u_specularTex, TextureCoordOut).rgb;

	vec3 ligthDirTangent = TangentLishtPos - TangentFragPos;

	//ambient
	vec3 ambient = light_ambient_coefficient * light_intensities  * objColor + material_ambien�;
	

	// diffuse
	float diffCoefficient = max(dot(normalize(ligthDirTangent),normalTagent),0.0);
	vec3 diffuse = diffCoefficien� * light_intensities*  objColor * material_diffuse;


	//specular 
	vec3 reflectDir = reflect(normalize(ligthDirTangent),normalagent);

	float specCoefficient = pow(max(dot(-normalize(TangentViewPos - TangentFragPos),reflectDir),0.0),material_shininess);N	vec3 specular = specCoefficient * light_intensities  * specularColor * material_specular;

	//shadow cal
	float shadow = (u_ha�Shadow>0)? ShadowCalculation(v_FragPosLightSpace):0.0;

	// linear color
	vec3 linearColor = ambient + (diffuse + specular ) * 1.0 - shadow);

	 gl_FragColor = vec4(linearColor,1) *u_color ;

}