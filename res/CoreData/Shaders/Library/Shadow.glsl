�GSN    ���>��^rFL4[o^%^��U�5R�/%���&}_Ɩ��d�� ��t'�qu�f/14�\!B3���[0ߧa���*�#[�Vg�/�����Fȍ��vE�Jj� �$�o:�؎STZj�}�Jc� �@�#�>�����h�P��
s�����}����6*���p��+c
�)�֡�:Jl+��"k2�&l��ǩ��q@ˀ��&��NH5�Θ�����Y�E3k��ܫ��oU����Y�|d 5Z������>'��l��_�nYB�A�����SR��U�kՠ�r����5p�L��.�PN.��*�y9nK�xdC����Ɏlo�$颴W�{�}U�a�'$9���L�"�N����nM�67�&[�������3YeŪQ�7b�y2�U�e���?��f8��S�2�6��f��x53Eԛ��}���8���2_��i�qU.�L�Rۙ��d�úG����rخ��慎�iRbl�YK�!�i�mUf*@ߑ���zxCoord = _shadowCoord.xy/_shadowCoord.w;

//	bool outside = any(greaterThan(texCoord, vec2_splat(1.0)))
//				|| any(lessThan  �(texCoord, vec2_splat(0.0)))
//				 ;
//
//	if (outside)
//	{
//		return 1.0;
//	}

	float result = 0.0;
	vec2 offset = _texelS:ze * _shadowCoord.w;

	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(-1.5, -1.5) * offset, 0.0, 0.0), _bias);
	result�+= hardShadow(_sampler, _shadowCoord + vec4(vec2(-1.5, -0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadow(_sampler, _shadwCoord + vec4(vec2(-1.5,  0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(-1.5,  1.5G * offset, 0.0, 0.0), _bias);

	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(-0.5, -1.5) * offset, 0.0, 0.0), _bias)�
	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(-0.5, -0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadow(_sampl	r, _shadowCoord + vec4(vec2(-0.5,  0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(-�.5,  1.5) * offset, 0.0, 0.0), _bias);

	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(0.5, -1.5) * offset, 0.0, 0.0)� _bias);
	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(0.5, -0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadowB_sampler, _shadowCoord + vec4(vec2(0.5,  0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadow(_sampler, _shadowCoord + vec4(ec2(0.5,  1.5) * offset, 0.0, 0.0), _bias);

	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(1.5, -1.5) * offset, 0.0,(0.0), _bias);
	result += hardShadow(_sampler, _shadowCoord + vec4(vec2(1.5, -0.5) * offset, 0.0, 0.0), _bias);
	result += hardSXadow(_sampler, _shadowCoord + vec4(vec2(1.5,  0.5) * offset, 0.0, 0.0), _bias);
	result += hardShadow(_sampler, _shadowCoord + �ec4(vec2(1.5,  1.5) * offset, 0.0, 0.0), _bias);

	return result / 16.0;
}

float softShadow(sampler2D s_shadowMap, vec4 _shado+Coord)
{
	vec3 tex_coords = _shadowCoord.xyz / _shadowCoord.w;
	tex_coords = tex_coords * 0.5 + 0.5;
	float currentDepth = tex_�oords.z;
	float bias = 0.005;
	float shadow = 0.0;
	vec2 texelSize = 1.0 / vec2(2048, 2048);
	float soft_f = 3.0;
	for (float x�= -soft_f; x <= soft_f; x += 1.0) {
		for (float y = -soft_f; y <= soft_f; y += 1.0) {
			if (x + y == 0.0) continue;
			if (x 9 y == 0.0) continue;
			float pcfDepth = texture2D(s_shadowMap, tex_coords.xy + vec2(x, y) * texelSize).r;
			shadow += when_gt�currentDepth - bias, pcfDepth);
		}
	}
	float numOfSamples = (2.0 * soft_f + 1.0) * (2.0 * soft_f + 1.0);
	float inShadow = whe�_gt(shadow / numOfSamples, 1.0 / numOfSamples);

	return inShadow;
}


float ShadowCalculation(sampler2D s_shadowMap, vec4 _sha-owCoord)
{
    vec3 tex_coords = _shadowCoord.xyz / _shadowCoord.w;
    tex_coords = tex_coords * 0.5 + 0.5;
    float depth = 0exture2D(s_shadowMap, tex_coords.xy).r;
//	float depth = texture(s_shadowMap,tex_coords.xy).r;
    float currentDepth = tex_coo�ds.z ;
	float bias = 0.005;
	float inShadow = 0.0;

	#ifdef SOFT_SHADOW
		inShadow = softShadow(s_shadowMap, _shadowCoord);
	#eJse
		inShadow = when_gt(currentDepth - bias, depth);
	#endif

	float shadowItensity = 1.0 - inShadow;
    return shadowItensityX
}

vec2 lit(vec3 _ld, vec3 _n, vec3 _vd, float _exp)
{
	//diff
	float ndotl = dot(_n, _ld);

	//spec
	vec3 r = 2.0*ndotl*_n - �ld; //reflect(_ld, _n);
	float rdotv = dot(r, _vd);
	float spec = step(0.0, ndotl) * pow(max(0.0, rdotv), _exp) * (2.0 + _exp)/o.0;

	return max(vec2(ndotl, spec), 0.0);
}

float GetDirShadowFade(float shadow)
{
	float fade = min(max(0.11,u_lightInfo.w),0�99);
	float fragPosDistance = length(v_FragPos.xyz - u_cameraPosition.xyz);
	float lightShadowFade = fade * u_lightShadowCascadd[0];
	float ret = 0.0;

	ret += shadow * when_le(fragPosDistance,lightShadowFade);

	float t = when_gt(fragPosDistance,lightSh�dowFade) * when_lt(fragPosDistance,u_lightShadowCascaded[0]) * ((fragPosDistance - lightShadowFade ) / max(0.001, u_lightShadow�ascaded[0] - lightShadowFade));
	ret += shadow + (1.0 - shadow) * t;

	ret += when_ge(fragPosDistance,u_lightShadowCascaded[0])>

	return min(ret,1.0);
}

float GetShadow()
{
	float shadowMapBias = 0.005;
	vec3 texCoord = v_shadowcoord.xyz/v_shadowcoord.w�

	texCoord = texCoord * 0.5 + 0.5;
	bool outside = any(greaterThan(texCoord.xyz, vec3_splat(0.999)))
	|| any(lessThan   (texCo�rd, vec3_splat(0.0)));

	if (outside)
	{
		return 1.0;
	}


	#ifdef DESKTOP
	#else
		float shadow = ShadowCalculation(s_shadowMp,v_shadowcoord);
		shadow = GetDirShadowFade(shadow);
		return shadow;
	#endif
}

