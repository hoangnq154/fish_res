�GSN    ���Z��Nc9X	xHx75	��T�|u�-;J���3bFȆ�� ��w��!j�x}�&aC</�KV5D@��� MyӤt���*B�e9t�{��ȇ|����C!g�Gt�^d�&�k6���FS	��V_5�IE�\�)�Ml������0Q��N4�����[����*�֗
��n?0N�W����}cp��m;�0!������>��R��{҈Bm>������/c�^5Y+ܨ����X~����h�+|$��қ��+d��\b��J;�A`g�A�����<��l�x���ts񕅊L�W��tr��QC|�n�.+R�K/�6�����?�F���g�-O�p��= b���[�$�U����H�:)�;Yť����(���*�<n�x�X�������v�V'���D��V1{��J��<��� �ЈZK3z��,�S#Z"�� ř��z���C��ۋJҷ�V+��٨PBue�I�+�g�~W</ ?�����vcsCoord;
varying vec3 v_ambient;
varying vec3 v_diffuse;
varying vec3 model_position;
varying vec4 p_position;
varying flo�t time;

vec4 getPosition(out vec3 normal)
{
    float blendWeight = a_blendWeight[0];

    int matrixIndex = int (a_blen7Index[0]) * 3;
    vec4 matrixPalette1 = u_matrixPalette[matrixIndex] * blendWeight;
    vec4 matrixPalette2 = u_matrixPalett�[matrixIndex + 1] * blendWeight;
    vec4 matrixPalette3 = u_matrixPalette[matrixIndex + 2] * blendWeight;
    
    
    blndWeight = a_blendWeight[1];
    if (blendWeight > 0.0)
    {
        matrixIndex = int(a_blendIndex[1]) * 3;
        matriPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
        matrixPalette2 += u_matrixPalette[matrixIndex + 1] * blendWeig�t;
        matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
        
        blendWeight = a_blendWeight[2]W
        if (blendWeight > 0.0)
        {
            matrixIndex = int(a_blendIndex[2]) * 3;
            matrixPalette1 +=�u_matrixPalette[matrixIndex] * blendWeight;
            matrixPalette2 += u_matrixPalette[matrixIndex + 1] * blendWeight;
   �        matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
            
            blendWeight = a_blendWeigh[3];
            if (blendWeight > 0.0)
            {
                matrixIndex = int(a_blendIndex[3]) * 3;
             S  matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
                matrixPalette2 += u_matrixPalette[matrixIndex # 1] * blendWeight;
                matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
            }
        }=
    }

    vec4 _skinnedPosition;
    vec4 position = vec4(a_position, 1.0);
    _skinnedPosition.x = dot(position, matrix�alette1);
    _skinnedPosition.y = dot(position, matrixPalette2);
    _skinnedPosition.z = dot(position, matrixPalette3);
  | _skinnedPosition.w = position.w;

    vec4 n = vec4(a_normal,0.0);
    normal.x = dot(n, matrixPalette1);
    normal.y = d�t(n, matrixPalette2);
    normal.z = dot(n, matrixPalette3);


    return _skinnedPosition;
}

void main()
{
    vec3 �ew_normal = a_normal;
	vec4 position = u_hasSkin>0?getPosition(new_normal):vec4(a_position,1.0);
	vec3 v_FragPos = vec3(CC_MVYatrix * position);
	vec3 v_normal = CC_NormalMatrix * new_normal;

    //p_position = u_MMatrix * u_ViewPMatrix * position;�
	//light
	vec3 lightDir = normalize(light_position);
	//lightDir = vec3(0,1,0);
    vec3 norm = normalize(v_normal);

  � //ambient
	v_ambient = vec3(light_ambient_coefficient) *  light_intensities;

    // diffuse
	float diffCoefficient = max(-ot(lightDir,norm),0.0);
	v_diffuse = diffCoefficient  * light_intensities ;

 	TextureCoordOut = a_texCoord;
    TextureCoo6dOut.y = 1.0 - TextureCoordOut.y;

    model_position = vec3(u_MMatrix * position);

    p_position =  u_ViewPMatrix * vec4�model_position,1.0);


 	gl_Position = CC_PMatrix * vec4(v_FragPos,1.0);


 }
