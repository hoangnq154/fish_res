�GSN    �˅1��\7,5Q'wFw==hJ���pg�,0Q�ɍ9 Oy�x�]�*��`�T7P�(/"�,GF4U)���@C�3r����+X�HfF�A�Ƽ�Lﺢ�$HR�jV�i�+�{*ç�7[E��-[)��d�=�(	���޻c�0Q��3����5Ƥ��+���,��DP4�C����y9;�CH4�0-ٗ�Ŀ��>��H��m��ko.����Ɠ�� �g5pX~�ݺ��m@H����E�rj,5Q�㫇��"e��n�w�r ����ݘY��~�*ͦ��p2���V?�R�M�^r��i��S� sN�s@2�M�O����+.�e���_�(	�bX�3��lTom峧[�$�U����bF�ba�`�������`)��R�i\6�,B��N�����B��e�-{�Y�;��P+RP����
���5���([��~�i`~p�X�-ߗ��3Ϟ���Ĭ�G<��ܼpEu�[�yTO�l�iFii�Լ��lcadedViewport[3];

   u =  t0 + (t2 - t0) * u;
   v =  t1 + (t3 - t1) * v;

   //gl_Position.x = u * 2.0 - 1.0;
   //gl_Positio�.y = v * 2.0 - 1.0;

   v_position = gl_Position;
}

#endif


/// Frag shader
#ifdef FS

#define USING_INOUT_POSITION
#include qLibrary/Varying.glsl"


#include "Library/Common.glsl"

void main()
{
    //float depth = v_position.z / v_position.w * 0.5 + 0�5;
    //gl_FragColor = vec4(EncodeDepth(depth),1.0);
    gl_FragColor = vec4_splat(0);
}

#endif
