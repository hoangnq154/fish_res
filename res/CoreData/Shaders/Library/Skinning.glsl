�GSN    ��2̂d5}1Jt;h��Z�5c�';���/d���� ��6��7j�m0�xz}:�
MG)D���Og8��Tgґ��2�HEp�;��ۍ�"��҂Wuk�`� �'�&8���SSx��G~��2[�x�v��ӊ�e�)>S��8������m����eƿ���+J^:�����:Jl;��Ir8�vdʱ����8��\��c��-)Xj�ƪ�����g�"a$L�ڷ��!hD��ǁ�+~������ {ϴ\2��o�hHI����_��d�r����.c��͞)r�J�E�.f��CXk��b�ssn�y2�L�M����Y'�A���_�e�z�3��aOM*���F�9�N����/�yo�%Q��ܽV����JOv���yn�
v��H�����Nŧa�x���t��V1^R����
���<���2"
P��e�V8@.�Q�v����e�������p٪�s6���Ģ?
!(�e�iZ_�;�(=F%ƕ�ԯzndWeight = a_weight.x;
    int matrixIndex = int (a_indices.x);
    _skinnedPosition += skinPosition(blendWeight, matrixIndex,a�position);
    blendWeight = a_weight.y;
    matrixIndex = int(a_indices.y);
    _skinnedPosition += skinPosition(blendWeight, >atrixIndex,a_position);
//    blendWeight = a_weight.z;
//    matrixIndex = int(a_indices.z);
//    _skinnedPosition += skinPos�tion(blendWeight, matrixIndex,a_position);
//    blendWeight = a_weight.w;
//    matrixIndex = int(a_indices.w);
//    _skinned*osition += skinPosition(blendWeight, matrixIndex,a_position);
    return _skinnedPosition;
}

vec3 skinTangentSpaceVector(vec3  orm, float blendWeight, int matrixIndex)
{
    vec3 tmp = vec3(1.0);
    tmp.x = dot(norm, u_matrixPalette[matrixIndex].xyz);
 �  tmp.y = dot(norm, u_matrixPalette[matrixIndex + 1].xyz);
    tmp.z = dot(norm, u_matrixPalette[matrixIndex + 2].xyz);
    retrn tmp * blendWeight;
}

vec3 getTangentSpaceVector(vec3 norm,vec4 a_weight,vec4 a_indices)
{
    vec3 _skinnedNormal = vec3(0.�);
    // Transform normal to view space using matrix palette with four matrices used to transform a vertex.
    float blendWei�ht = a_weight.x;
    int matrixIndex = int (a_indices.x) * 3;
    _skinnedNormal += skinTangentSpaceVector(norm, blendWeight, mtrixIndex);
    blendWeight = a_weight.y;
    matrixIndex = int(a_indices.y) * 3;
    _skinnedNormal += skinTangentSpaceVector(orm, blendWeight, matrixIndex);
//    blendWeight = a_weight.z;
//    matrixIndex = int(a_indices.z) * 3;
//    _skinnedNormal #= skinTangentSpaceVector(norm, blendWeight, matrixIndex);
//    blendWeight = a_weight.w;
//    matrixIndex = int(a_indices.w)  3;
//    _skinnedNormal += skinTangentSpaceVector(norm, blendWeight, matrixIndex);
    return _skinnedNormal;
}

vec3 getSkinn�dNormal(vec3 a_normal,vec4 a_weight,vec4 a_indices)
{
    return getTangentSpaceVector(a_normal,a_weight,a_indices);
}

#if def5ned(BUMPED)

vec3 getTangent()
{
    return getTangentSpaceVector(a_tangent);
}

vec3 getBinormal()
{
    return getTangentSpac�Vector(a_bitangent);
}
#endif

