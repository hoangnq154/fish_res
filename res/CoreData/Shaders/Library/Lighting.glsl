�GSN    �˅1��_qZ*j5=jDCib��6e�$<غ�>Ul�����7�߇N�T5<�y	/45�Zqdd",���`M)��T1X����,S�8|\�[�ռ��M����W!&�A}�Yn�h�G	�ӳ/kw63�T�@6�qF�e�7�pF�����H�*~��9W������q����$��p��R\��ݺ�}::�Ah8�2d݋�����'���)��|tT>���ψ���)c�2g>[uB������g=�晈�jtMC#�����"f��j��r�nEO�\��뚝BH�i�*ֿ��a?ү��m�4�&�^'�RO=��q�tod�q8�[�����qQ�(���7�e�}Q�a��+e���i�}�����'�*� G���V���/L��C�u	T�:x��H�����U��x�9�R��)ܿI5RR��L��&���8���jaH��$�m"@.��hڋ��v�Ŷv����E���M�ѪȩqRI;�oL�1�c�g^0o{x�����@sceneHemisphericColor[1][2]);
    vec3 equatorColor = vec3(u_sceneHemisphericColor[2][0],u_sceneHemisphericColor[2][1],u_sceneH�misphericColor[2][2]);

    vec3 worldUp = vec3(0.0,1.0,0.0);
    float skyGroundDotMul = 2.5;
    float minEquatorMix = 0.5;
 s  float equatorColorBlur = 0.33;

    float upDot = dot(normalVector, worldUp);

    float adjustedDot = upDot * skyGroundDotMu�;
    vec3 skyGroundColor = lerp(groundColor, skyColor, saturate((adjustedDot + 1.0) * 0.5));

    //Work out equator lights brghtness
    float equatorBright = saturate(dot(equatorColor, equatorColor));

    //Blur equator color with sky and ground colos based on how bright it is.
    vec3 equatorBlurredColor = lerp(equatorColor, saturate(equatorColor + groundColor + skyColor),�equatorBright * equatorColorBlur);

    //Work out 3 way lerp inc equator light
    float smoothDot = pow(abs(upDot), 1.0);
   Lvec3 equatorColor2 = lerp(equatorBlurredColor, groundColor, smoothDot) * step(upDot, 0) + lerp(equatorBlurredColor, skyColor, s�oothDot) * step(0, upDot);


    return lerp(skyGroundColor, equatorColor2, saturate(equatorBright + minEquatorMix)) * 0.75;

 �  //return groundColor * -normalVector.y + skyColor * normalVector.y + equatorColor * (1,0 - abs(normalVector.y));
}


float GeDiffuseDirectionLight(vec3 normal)
{
    vec3 dir = -u_lightDirection.xyz;
    return max(dot(normal,normalize(dir) ), 0.0);
}
yfloat GetDiffuseLight(vec3 normal)
{
    vec3 dir = -u_lightDirection.xyz;
    return max(dot(normal,normalize(dir) ), 0.0);
}
vec3 GetEnvironmentColor(vec3 normal)
{
    float ambientStrenght = u_ambientColor.w;
    return ComputeHemisphericLight(normal;
}

float GetLightShadow()
{
    #ifdef RECEIVED_SHADOW
        return GetShadow();
    #else
        return 1.0;
    #endif
}�
vec3 GetLightColor(vec3 normal)
{
    int lightType = int(u_lightInfo.x);

    float diff = (lightType == DIRECTION_LIGHT)?GetiffuseDirectionLight(normal):GetDiffuseLight(normal);
    float shadow = GetLightShadow();
    return diff * shadow * u_lightCo�or.rgb;
}


