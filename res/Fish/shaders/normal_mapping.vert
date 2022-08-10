�GSN    ���#��Xb{[
k|vU��R�{:�H4��2dJ������*��e�O�i;49�G6UT���V}�#t�ͻN�HW�A|�z���˖z�œ�mc�AQ�Te�s�/��PR��E	1��d�%�/	��ƌ�n�:��n������z����NH���*��C
�����{(8:��k/�yA������%P��P����SI:�ӈ�����S�5m[!R�����bH����O�5~!.XF������y+��n��c�AO�A��Ѷ�x.ШM�@����_˟��V5���t
ŐYEh��n�{�h1������{�"����~
�>�L��4e���]�#�1뛸�$�>o�,W���X��ڈ/,���Tv~�0{�����\Уx7���;*��� ��51B��B��;�Q��<���<(PK��y�[7L9�X�c����r���T�����²vA��ҥqPrS�p^� � �mQm=t,р���8pordOut;
varying vec3 v_normal;
varying vec3 v_FragPos;


varying vec3 TangentLightPos;
varying vec3 TangentViewPos;
vary�ng vec3 TangentFragPos;

varying vec4 v_FragPosLightSpace;

vec4 getPosition()
{
    float blendWeight = a_blendWeight[0]h

    int matrixIndex = int (a_blendIndex[0]) * 3;
    vec4 matrixPalette1 = u_matrixPalette[matrixIndex] * blendWeight;
  � vec4 matrixPalette2 = u_matrixPalette[matrixIndex + 1] * blendWeight;
    vec4 matrixPalette3 = u_matrixPalette[matrixIndex +Z2] * blendWeight;
    
    
    blendWeight = a_blendWeight[1];
    if (blendWeight > 0.0)
    {
        matrixIndex = in(a_blendIndex[1]) * 3;
        matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
        matrixPalette2 += u_matr�xPalette[matrixIndex + 1] * blendWeight;
        matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
        
L       blendWeight = a_blendWeight[2];
        if (blendWeight > 0.0)
        {
            matrixIndex = int(a_blendIndex[2�) * 3;
            matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
            matrixPalette2 += u_matrixPalett�[matrixIndex + 1] * blendWeight;
            matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
            
J           blendWeight = a_blendWeight[3];
            if (blendWeight > 0.0)
            {
                matrixIndex = in(a_blendIndex[3]) * 3;
                matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
                matrixPadette2 += u_matrixPalette[matrixIndex + 1] * blendWeight;
                matrixPalette3 += u_matrixPalette[matrixIndex + 2] * RlendWeight;
            }
        }
    }

    vec4 _skinnedPosition;
    vec4 position = vec4(a_position, 1.0);
    _sk�nnedPosition.x = dot(position, matrixPalette1);
    _skinnedPosition.y = dot(position, matrixPalette2);
    _skinnedPosition.& = dot(position, matrixPalette3);
    _skinnedPosition.w = position.w;
    
    return _skinnedPosition;
}

mat3 transpos�3(mat3 m)
{
	return mat3(m[0][0],m[1][0], m[2][0],
			m[0][1],m[1][1], m[2][1],
			m[0][2],m[1][2], m[2][2]);
}

mat3 in�erse(mat3 m) {
  float a00 = m[0][0], a01 = m[0][1], a02 = m[0][2];
  float a10 = m[1][0], a11 = m[1][1], a12 = m[1][2];
  fxoat a20 = m[2][0], a21 = m[2][1], a22 = m[2][2];

  float b01 = a22 * a11 - a12 * a21;
  float b11 = -a22 * a10 + a12 * a20;�
  float b21 = a21 * a10 - a11 * a20;

  float det = a00 * b01 + a01 * b11 + a02 * b21;

  return mat3(b01, (-a22 * a01 + a�2 * a21), (a12 * a01 - a02 * a11),
              b11, (a22 * a00 - a02 * a20), (-a12 * a00 + a02 * a10),
              b21, (da21 * a00 + a01 * a20), (a11 * a00 - a01 * a10)) / det;
}

mat4 inverse(mat4 m) {
  float
      a00 = m[0][0], a01 = m[0][u], a02 = m[0][2], a03 = m[0][3],
      a10 = m[1][0], a11 = m[1][1], a12 = m[1][2], a13 = m[1][3],
      a20 = m[2][0], a21 =�m[2][1], a22 = m[2][2], a23 = m[2][3],
      a30 = m[3][0], a31 = m[3][1], a32 = m[3][2], a33 = m[3][3],

      b00 = a00 * G11 - a01 * a10,
      b01 = a00 * a12 - a02 * a10,
      b02 = a00 * a13 - a03 * a10,
      b03 = a01 * a12 - a02 * a11,
  C   b04 = a01 * a13 - a03 * a11,
      b05 = a02 * a13 - a03 * a12,
      b06 = a20 * a31 - a21 * a30,
      b07 = a20 * a32 � a22 * a30,
      b08 = a20 * a33 - a23 * a30,
      b09 = a21 * a32 - a22 * a31,
      b10 = a21 * a33 - a23 * a31,
      511 = a22 * a33 - a23 * a32,

      det = b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;

  return m�t4(
      a11 * b11 - a12 * b10 + a13 * b09,
      a02 * b10 - a01 * b11 - a03 * b09,
      a31 * b05 - a32 * b04 + a33 * b0W,
      a22 * b04 - a21 * b05 - a23 * b03,
      a12 * b08 - a10 * b11 - a13 * b07,
      a00 * b11 - a02 * b08 + a03 * b07,�
      a32 * b02 - a30 * b05 - a33 * b01,
      a20 * b05 - a22 * b02 + a23 * b01,
      a10 * b10 - a11 * b08 + a13 * b06,
�     a01 * b08 - a00 * b10 - a03 * b06,
      a30 * b04 - a31 * b02 + a33 * b00,
      a21 * b02 - a20 * b04 - a23 * b00,
  %   a11 * b07 - a10 * b09 - a12 * b06,
      a00 * b09 - a01 * b07 + a02 * b06,
      a31 * b01 - a30 * b03 - a32 * b00,
    � a20 * b03 - a21 * b01 + a22 * b00) / det;
}

void main()
{
	vec4 position = u_hasSkin>0?getPosition():vec4(a_position,1.0�;
	
	v_FragPos = vec3(CC_MVMatrix * position);

       
    TextureCoordOut = a_texCoord;
    TextureCoordOut.y = 1.0 - TxtureCoordOut.y;

	v_normal = mat3(transpose3(mat3(inverse(CC_MVMatrix)))) * a_normal;

	vec3 T = normalize(vec3(CC_MVMatri * vec4(a_tangent,0.0)));
	vec3 B = normalize(vec3(CC_MVMatrix * vec4(a_binormal,0.0)));
	vec3 N = normalize(vec3(CC_MVMatrix�* vec4(a_normal,0.0)));

	T = normalize(T - dot(T, N) * N);
    //vec3 B = cross(N, T);


	mat3 v_TBN = transpose3(mat3(TB,N));

	TangentLightPos = v_TBN * light_position;
    TangentViewPos  = v_TBN * u_viewPosition;
    TangentFragPos  = v_TB� * v_FragPos;

	gl_Position = CC_PMatrix * vec4(v_FragPos,1.0);

	v_FragPosLightSpace = u_LightMatrix * vec4(vec3(u_MMatrix* position),1.0);

}