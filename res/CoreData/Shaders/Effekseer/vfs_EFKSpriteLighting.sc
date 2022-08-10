�GSN    �˅1��\7,5Q'Y 6Nh &[7��H�ah�,_U���30N����O�N�`��q�TtC�r$<7�^KZ0E	@���U� \�˿ �bW�Vm�`�둍�=ҋ��!g�Q}�So�:�?D���[VB	��[\$��'�%�Ww��흗`�o5��)�����a����7���z��Un��Ͷ�y#-�k 2�6<ޚ��Ǒ#��.��:��htT<�Ψ���߾i�3e%7͸Ǭ������I�}Q[�����8��/��-x�{HD�c׶���U�o�(����i1����Y]�M��j��Y}�	�tbA�oj��Jҭ��k|�/���pT�xW�u��<T*k���A�;�Y����( �'=�1�ف�Q���-P(��R��8p�������U��v�Bk�/��K��Z+K΀%��<���t���caS%��b�W#P.�C�ܑ��~�Ż�쒡��/��ܣm[e�u�y0�o�aF6rNgэ���[?  // uv
    v_texcoord0 = vec4(a_texcoord0.x,a_texcoord0.y,0.0,0.0);
    v_texcoord0.y = mUVInversed.x + mUVInversed.y * v_texc�ord0.y;
    v_texcoord1 = vec4(a_texcoord1.x,a_texcoord1.y,0.0,0.0);
    v_texcoord1.y = mUVInversed.x + mUVInversed.y * v_texc<ord1.y;

    // NBT
    vec3 worldNormal = (a_normal - vec3(0.5, 0.5, 0.5)) * 2.0;
    vec3 worldTangent = (a_tangent - vec3(0.�, 0.5, 0.5)) * 2.0;
    vec3 worldBinormal = cross(worldNormal, worldTangent);

    v_WorldN = worldNormal;
    v_WorldB = worlBinormal;
    v_WorldT = worldTangent;
    vec3 pixelNormalDir = vec3(0.5, 0.5, 1.0);

   vec4 cameraPos = uMatCamera * vec4(woldPos, 1.0);
   	cameraPos = cameraPos / cameraPos.w;

   	gl_Position = uMatProjection * cameraPos;

    v_WorldP = worldPos;
�   v_color0 = a_color0;

    v_ScreenUV.xy = gl_Position.xy / gl_Position.w;
    v_ScreenUV.xy = vec2(v_ScreenUV.x + 1.0, v_Scr	enUV.y + 1.0) * 0.5;
}

#endif


#ifdef FS
$input v_color0
$input v_texcoord0
$input v_texcoord1
$input v_WorldP
$input v_World�
$input v_WorldT
$input v_WorldB
$input v_ScreenUV

/// ----- UNIFORM
#include "../Library/Base/common.sh"

SAMPLER2D(ColorText�re,0);
SAMPLER2D(NormalTexture,1);

uniform vec4 LightDirection;
uniform vec4 LightColor;
uniform vec4 LightAmbient;

// Materils
uniform vec4 u_time;
// end materials
/// ----------  END UNIFORM


void main()
{

    vec3 texNormal = (texture2D(NormalTexure, v_texcoord0.xy).xyz - 0.5) * 2.0;
    mat3 normalMatrix = mat3(v_WorldT.xyz, v_WorldB.xyz, v_WorldN.xyz );
    vec3 localNgrmal = normalize( normalMatrix * texNormal );
    float diffuse = max(0.0, dot(localNormal, LightDirection.xyz));

    gl_FragC_lor = v_color0 * texture2D(ColorTexture, v_texcoord0.xy);
    gl_FragColor.xyz = gl_FragColor.xyz * (LightColor.xyz * diffuse +�LightAmbient.xyz);

    if(gl_FragColor.w <= 0.0) discard;

}

#endif
