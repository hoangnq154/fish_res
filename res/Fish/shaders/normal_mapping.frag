�GSN    �˅1��\7=*h.dRH|&S��W�bq�40���?dZؖ��O��1��s�ge�si14�
B%SN@���[u��Or�Ľ�,Q�\b�/�����o䣀�Qi��=
�)�w'���]P@��HV}1� �w9�6�VS�։��z�&V��N1�����v٤��"����V:i�g�ϲ�c"8��s-�4)���ӱ��4��V����&~G�醴����{j�0epr��ށ��.kq����[�KX?&]L���Ϳ�>n��
n��u�>[O���煁C��e�xܟ��;^����v�Y�Z�4�hBa��b�HQ�o#������rQ�9����3b� 3�r��8 *�����R�����;;�&G�ށ�^���'P3��R�8l�7i��Z���S��Q��~�k���;��X1b��H��&�|��^���.(Pޢi�qU�
�j%܋��t�؆E�������M=�Ӧ�=t0�`P�4T�c�(_>iE;�����}ient;
uniform vec3 material_diffuse;
uniform vec3 material_specular;
uniform float material_shininess;

uniform vec3 light�position;
uniform vec3 light_intensities;
uniform float light_attenuation;
uniform float light_ambient_coefficient;

unifo!m vec4 u_color;
uniform vec3 u_viewPosition;
uniform int u_hasShadow;

uniform sampler2D u_normalTex;
uniform sampler2D u_�pecularTex;
uniform sampler2D u_shadowTex;

float ShadowCalculation(vec4 fragPosLightSpace)
{
    // perform perspective dvide
    vec3 projCoords = fragPosLightSpace.xyz / fragPosLightSpace.w;
    // transform to [0,1] range
    projCoords = proCoords * 0.5 + 0.5;
    // get closest depth value from light's perspective (using [0,1] range fragPosLight as coords)
    fl�at closestDepth = texture2D(u_shadowTex, projCoords.xy).r; 
    // get depth of current fragment from light's perspective
   Lfloat currentDepth = projCoords.z;
    // calculate bias (based on depth map resolution and slope)
    vec3 normal = normaliz�(v_normal);
    vec3 lightDir = normalize(light_position - v_FragPos);
    float bias = max(0.05 * (1.0 - dot(normal, lightDi�)), 0.005);
    // check whether current frag pos is in shadow
    float shadow = currentDepth - bias > closestDepth  ? 1.0 :J0.0;
    // PCF
    shadow = 0.0;
	float s = 1.0 / 1024.0;
    vec2 texelSize = vec2(s , s) ;
    for(int x = -1; x <= 1; X+x)
    {
        for(int y = -1; y <= 1; ++y)
        {
            float pcfDepth = texture2D(u_shadowTex, projCoords.xy # vec2(x, y) * texelSize).r; 
            shadow += currentDepth - bias > pcfDepth  ? 1.0 : 0.0;        
        }    
    }:    shadow /= 9.0;
    
    // keep the shadow at 0.0 when outside the far_plane region of the light's frustum.
    if(projC�ords.z > 1.0)
        shadow = 0.0;
        
    return shadow;
}


void main(void)
{
	// init value
	vec3 lightDir =|normalize(light_position - v_FragPos);
	vec3 viewDir = normalize(u_viewPosition - v_FragPos);
	vec3 halfwayDir = normalize(li�htDir + viewDir);
	vec3 norm = normalize(v_normal);


	vec3 objColor = texture2D(CC_Texture0, TextureCoordOut).rgb;
	vec3 �ormalTagent = texture2D(u_normalTex, TextureCoordOut).rgb;
	normalTagent = normalize(normalTagent * 2.0 - 1.0);

	vec3 specuxarColor = texture2D(u_specularTex, TextureCoordOut).rgb;

	vec3 ligthDirTangent = TangentLightPos - TangentFragPos;

	//amb�ent
	vec3 ambient = light_ambient_coefficient * light_intensities  * objColor + material_ambient;
	

	// diffuse
	float di�fCoefficient = max(dot(normalize(ligthDirTangent),normalTagent),0.0);
	vec3 diffuse = diffCoefficient * light_intensities*  ob#Color * material_diffuse;


	//specular 
	vec3 reflectDir = reflect(normalize(ligthDirTangent),normalTagent);

	float spe'Coefficient = pow(max(dot(-normalize(TangentViewPos - TangentFragPos),reflectDir),0.0),material_shininess);
	vec3 specular = s�ecCoefficient * light_intensities  * specularColor * material_specular;

	//shadow cal
	float shadow = (u_hasShadow>0)? ShadIwCalculation(v_FragPosLightSpace):0.0;

	// linear color
	vec3 linearColor = ambient + (diffuse + specular ) * (1.0 - shadowJ;

	 gl_FragColor = vec4(linearColor,1) *u_color ;

}