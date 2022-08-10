�GSN    ���#��Xb{[
k|vU��R�{:�#!��3uܖ�� �!�(��S�rt�&f()/�@A4U]�ȽG��˫�y<�\{�{����J��>OA�oW�~T��[ ��[Hj�X�.@6�	�	 �8�MqɅě�8� R��4�ǣ���a����<�֗��n#0N�)�읮:]llҕk(�+*Ĝ����eP��r��&��iM>�������=i�*5=cV������;~H����R�Yd=*@������,x��a��tm�lTC�R����Ɛ>�o���r7����f�P��h��Hk��k�y}B�)N-������k`�b���_�(O�aV�g��=)nމ�S�9�����.�7� S����b����`Pe��R�8y�!T��U�����S��u�%�+��~��Bb[X��%��u���`���#3W��`�F%Fz�E�x*ޙ��z���Y����Eڮ�Q0��δB+~�jZ�=#
�g�|	U= i�����[ratrixPalette2 = u_matrixPalette[matrixIndex + 1] * blendWeight;
    vec4 matrixPalette3 = u_matrixPalette[matrixIndex + 2] * bl�ndWeight;
    
    
    blendWeight = a_blendWeight[1];
    if (blendWeight > 0.0)
    {
        matrixIndex = int(a_blendIndex1]) * 3;
        matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
        matrixPalette2 += u_matrixPalette[matrix�ndex + 1] * blendWeight;
        matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
        
        blendWeightZ= a_blendWeight[2];
        if (blendWeight > 0.0)
        {
            matrixIndex = int(a_blendIndex[2]) * 3;
            marixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
            matrixPalette2 += u_matrixPalette[matrixIndex + 1] * ble�dWeight;
            matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
            
            blendWeight = a3blendWeight[3];
            if (blendWeight > 0.0)
            {
                matrixIndex = int(a_blendIndex[3]) * 3;
      �         matrixPalette1 += u_matrixPalette[matrixIndex] * blendWeight;
                matrixPalette2 += u_matrixPalette[matrix�ndex + 1] * blendWeight;
                matrixPalette3 += u_matrixPalette[matrixIndex + 2] * blendWeight;
            }
      J }
    }

    vec4 _skinnedPosition;
    vec4 position = vec4(a_position, 1.0);
    _skinnedPosition.x = dot(position, matrixPaette1);
    _skinnedPosition.y = dot(position, matrixPalette2);
    _skinnedPosition.z = dot(position, matrixPalette3);
    _skannedPosition.w = position.w;
    
    return _skinnedPosition;
}

mat3 transpose3(mat3 m)
{
	return mat3(m[0][0],m[1][0], m[2][ ],
			m[0][1],m[1][1], m[2][1],
			m[0][2],m[1][2], m[2][2]);
}

mat3 inverse(mat3 m) {
  float a00 = m[0][0], a01 = m[0][1], a�2 = m[0][2];
  float a10 = m[1][0], a11 = m[1][1], a12 = m[1][2];
  float a20 = m[2][0], a21 = m[2][1], a22 = m[2][2];

  float|b01 = a22 * a11 - a12 * a21;
  float b11 = -a22 * a10 + a12 * a20;
  float b21 = a21 * a10 - a11 * a20;

  float det = a00 * b0� + a01 * b11 + a02 * b21;

  return mat3(b01, (-a22 * a01 + a02 * a21), (a12 * a01 - a02 * a11),
              b11, (a22 * a00 � a02 * a20), (-a12 * a00 + a02 * a10),
              b21, (-a21 * a00 + a01 * a20), (a11 * a00 - a01 * a10)) / det;
}

mat4 invqrse(mat4 m) {
  float
      a00 = m[0][0], a01 = m[0][1], a02 = m[0][2], a03 = m[0][3],
      a10 = m[1][0], a11 = m[1][1], a12�= m[1][2], a13 = m[1][3],
      a20 = m[2][0], a21 = m[2][1], a22 = m[2][2], a23 = m[2][3],
      a30 = m[3][0], a31 = m[3][1],�a32 = m[3][2], a33 = m[3][3],

      b00 = a00 * a11 - a01 * a10,
      b01 = a00 * a12 - a02 * a10,
      b02 = a00 * a13 - a0z * a10,
      b03 = a01 * a12 - a02 * a11,
      b04 = a01 * a13 - a03 * a11,
      b05 = a02 * a13 - a03 * a12,
      b06 = a2t * a31 - a21 * a30,
      b07 = a20 * a32 - a22 * a30,
      b08 = a20 * a33 - a23 * a30,
      b09 = a21 * a32 - a22 * a31,
  �   b10 = a21 * a33 - a23 * a31,
      b11 = a22 * a33 - a23 * a32,

      det = b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 -b04 * b07 + b05 * b06;

  return mat4(
      a11 * b11 - a12 * b10 + a13 * b09,
      a02 * b10 - a01 * b11 - a03 * b09,
      31 * b05 - a32 * b04 + a33 * b03,
      a22 * b04 - a21 * b05 - a23 * b03,
      a12 * b08 - a10 * b11 - a13 * b07,
      a00 *�b11 - a02 * b08 + a03 * b07,
      a32 * b02 - a30 * b05 - a33 * b01,
      a20 * b05 - a22 * b02 + a23 * b01,
      a10 * b10 z a11 * b08 + a13 * b06,
      a01 * b08 - a00 * b10 - a03 * b06,
      a30 * b04 - a31 * b02 + a33 * b00,
      a21 * b02 - a20�* b04 - a23 * b00,
      a11 * b07 - a10 * b09 - a12 * b06,
      a00 * b09 - a01 * b07 + a02 * b06,
      a31 * b01 - a30 * b0W - a32 * b00,
      a20 * b03 - a21 * b01 + a22 * b00) / det;
}

void main()
{
	vec4 position = u_hasSkin>0?getPosition():vec4(�_position,1);

	v_v4TexCoord = u_VPLightMatrix * u_MMatrix * position;
	gl_Position = v_v4TexCoord;

}