�GSN    ���6��H~/H]=].tge��R�|n�y_��%e[�Ә�C�^���i�.�i;49�G6UT���V}�#t�ͻN�#B�Zw�{乃ؐ-����dh�lv�Ux�B�z:��FBS��[v$�&�l�j�(`�����e�l�� �م���\����:���c��Qt5�J�׺�u!,��m;�0!����䰋��V����xt /�ʌ�����Y�\/H!ݺ���o?|����R�Yd=*D���ί� F��f�tn�wKE�X����C?�y�aѾ��u=����?�_��X��R[^��w�b0-�h #�	�Ү��7.�"��� �g�yP�}��$.l枚�(�����*�:!�,Z����Zٹ��.#��R�5j�yq��Y���
��I��x�-���u��x5xp]��]��;��5���9&��>�f4[?�
�N܊��fϗ�C����p���F:S���ȭjDu7�u|�6�
�i@&tN.�����[i_ambient;
varying vec3 v_diffuse;
varying vec3 model_position;
varying vec4 p_position;
varying float time;

vec4 getPosition(o�t vec3 normal)
{
    float blendWeight = a_blendWeight[0];

    int matrixIndex = int (a_blendIndex[0]) * 3;
    vec4 matrixPal6tte1 = u_matrixPalette[matrixIndex] * blendWeight;
    vec4 matrixPalette2 = u_matrixPalette[matrixIndex + 1] * blendWeight;
  � vec4 matrixPalette3 = u_matrixPalette[matrixIndex + 2] * blendWeight;
    
    
    blendWeight = a_blendWeight[1];
    if (blndWeight > 0.0)
    {
        matrixIndex = int(a_blendIndex[1]) * 3;
        matrixPalette1 += u_matrixPalette[matrixIndex] * lendWeight;
        matrixPalette2 += u_matrixPalette[matrixIndex + 1] * blendWeight;
        matrixPalette3 += u_matrixPalette�matrixIndex + 2] * blendWeight;
        
        blendWeight = a_blendWeight[2];
        if (blendWeight > 0.0)
        {
     L      matrixIndex = int(a_blendIndex[2]) * 3;
            matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
       �    matrixPalette2 += u_matrixPalette[matrixIndex + 1] * blendWeight;
            matrixPalette3 += u_matrixPalette[matrixIndex�+ 2] * blendWeight;
            
            blendWeight = a_blendWeight[3];
            if (blendWeight > 0.0)
            {
 J              matrixIndex = int(a_blendIndex[3]) * 3;
                matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeiht;
                matrixPalette2 += u_matrixPalette[matrixIndex + 1] * blendWeight;
                matrixPalette3 += u_matripPalette[matrixIndex + 2] * blendWeight;
            }
        }
    }

    vec4 _skinnedPosition;
    vec4 position = vec4(a_poCition, 1.0);
    _skinnedPosition.x = dot(position, matrixPalette1);
    _skinnedPosition.y = dot(position, matrixPalette2);
  � _skinnedPosition.z = dot(position, matrixPalette3);
    _skinnedPosition.w = position.w;

    vec4 n = vec4(a_normal,0.0);
   |normal.x = dot(n, matrixPalette1);
    normal.y = dot(n, matrixPalette2);
    normal.z = dot(n, matrixPalette3);


    return _�kinnedPosition;
}

void main()
{
    vec3 new_normal = a_normal;
	vec4 position = u_hasSkin>0?getPosition(new_normal):vec4(a_po�ition,1.0);
	vec3 v_FragPos = vec3(CC_MVMatrix * position);
	vec3 v_normal = CC_NormalMatrix * new_normal;

    //p_position = a_MMatrix * u_ViewPMatrix * position;

	//light
	vec3 lightDir = normalize(light_position);
	//lightDir = vec3(0,1,0);
    vec3 �orm = normalize(v_normal);

    //ambient
	v_ambient = vec3(light_ambient_coefficient) *  light_intensities;

    // diffuse
	f�oat diffCoefficient = max(dot(lightDir,norm),0.0);
	v_diffuse = diffCoefficient  * light_intensities ;

 	TextureCoordOut = a_t,xCoord;
    TextureCoordOut.y = 1.0 - TextureCoordOut.y;

    model_position = vec3(u_MMatrix * position);

    p_position =  uViewPMatrix * vec4(model_position,1.0);


 	gl_Position = CC_PMatrix * vec4(v_FragPos,1.0);


 }
