�GSN    ���]��T"_0J=f6Y��%!�04���g[Nؒ��I�P���^v�}h�=,.>�GPn:]J���Wv��N1�ѿ�m�G}�m�����{Є��{o�
z�Vx�$�m+��VPTM�Z�\#�qE�,�r�Dm���޺K�! |��>�ҝ���P����*�ދ��Es�����B(��4P�
㫶Õ¡%��`��l��~l.�������(n�#p"Ud
�����!hD���_�S~<7R\��ͳ�mI��$P��?_�Lrf�{��ú�i'յF�)���i=�꫹7R�|�j�;U��zmIΊG�!MT�B +��^����io�b�ٽ>�M]�Rk�;��0"&���[� �H����HN�7*� Z��͊~��ǭ6 .��?�99�O�*������$��e�?�B��Z��@{-%��N��y�.��&���{aY���W7J%�X�_4����U��j����[���q>���ŭrR-~�`P�4� �EsX���ܒ~me, _format, 6)
#	define FRAMEBUFFER_IMAGE2D_RW_3(_name, _format) IMAGE2D_RW(_name, _format, 7)
#else
#	define FRAMEBUFFER_IMAG�2D_RW_0(_name, _format) IMAGE2D_RW(_name, _format, 16)
#	define FRAMEBUFFER_IMAGE2D_RW_1(_name, _format) IMAGE2D_RW(_name, _for>at, 17)
#	define FRAMEBUFFER_IMAGE2D_RW_2(_name, _format) IMAGE2D_RW(_name, _format, 18)
#	define FRAMEBUFFER_IMAGE2D_RW_3(_nam�, _format) IMAGE2D_RW(_name, _format, 19)
#endif // BGFX_SHADER_LANGUAGE_GLSL

#define FRAMEBUFFER_IMAGE2D_RW(_name, _format, _eg) FRAMEBUFFER_IMAGE2D_RW_ ## _reg(_name, _format)

#if BGFX_SHADER_LANGUAGE_GLSL

#define SHARED shared

#define __IMAGE_XX(_ ame, _format, _reg, _image, _access) \
	layout(_format, binding=_reg) _access uniform highp _image _name

#define readwrite
#de�ine IMAGE2D_RO( _name, _format, _reg) __IMAGE_XX(_name, _format, _reg, image2D,  readonly)
#define UIMAGE2D_RO(_name, _format, 3reg) __IMAGE_XX(_name, _format, _reg, uimage2D, readonly)
#define IMAGE2D_WR( _name, _format, _reg) __IMAGE_XX(_name, _format, �reg, image2D,  writeonly)
#define UIMAGE2D_WR(_name, _format, _reg) __IMAGE_XX(_name, _format, _reg, uimage2D, writeonly)
#defi�e IMAGE2D_RW( _name, _format, _reg) __IMAGE_XX(_name, _format, _reg, image2D,  readwrite)
#define UIMAGE2D_RW(_name, _format, _eg) __IMAGE_XX(_name, _format, _reg, uimage2D, readwrite)

#define IMAGE2D_ARRAY_RO( _name, _format, _reg) __IMAGE_XX(_name, _frmat, _reg, image2DArray,  readonly)
#define UIMAGE2D_ARRAY_RO(_name, _format, _reg) __IMAGE_XX(_name, _format, _reg, uimage2DAzray, readonly)
#define IMAGE2D_ARRAY_WR( _name, _format, _reg) __IMAGE_XX(_name, _format, _reg, image2DArray,  writeonly)
#defi^e UIMAGE2D_ARRAY_WR(_name, _format, _reg) __IMAGE_XX(_name, _format, _reg, uimage2DArray, writeonly)
#define IMAGE2D_ARRAY_RW( �name, _format, _reg) __IMAGE_XX(_name, _format, _reg, image2DArray,  readwrite)
#define UIMAGE2D_ARRAY_RW(_name, _format, _reg)|__IMAGE_XX(_name, _format, _reg, uimage2DArray, readwrite)

#define IMAGE3D_RO( _name, _format, _reg) __IMAGE_XX(_name, _format� _reg, image3D,  readonly)
#define UIMAGE3D_RO(_name, _format, _reg) __IMAGE_XX(_name, _format, _reg, uimage3D, readonly)
#defi�e IMAGE3D_WR( _name, _format, _reg) __IMAGE_XX(_name, _format, _reg, image3D,  writeonly)
#define UIMAGE3D_WR(_name, _format, _feg) __IMAGE_XX(_name, _format, _reg, uimage3D, writeonly)
#define IMAGE3D_RW( _name, _format, _reg) __IMAGE_XX(_name, _format, �reg, image3D,  readwrite)
#define UIMAGE3D_RW(_name, _format, _reg) __IMAGE_XX(_name, _format, _reg, uimage3D, readwrite)

#def�ne __BUFFER_XX(_name, _type, _reg, _access)                \
	layout(std430, binding=_reg) _access buffer _name ## Buffer \
	{ i                                                         \
		_type _name[];                                          \
	}

#def-ne BUFFER_RO(_name, _type, _reg) __BUFFER_XX(_name, _type, _reg, readonly)
#define BUFFER_RW(_name, _type, _reg) __BUFFER_XX(_n�me, _type, _reg, readwrite)
#define BUFFER_WR(_name, _type, _reg) __BUFFER_XX(_name, _type, _reg, writeonly)

#define NUM_THREAbS(_x, _y, _z) layout (local_size_x = _x, local_size_y = _y, local_size_z = _z) in;

#define atomicFetchAndAdd(_mem, _data, _oriinal)                    _original = atomicAdd(_mem, _data)
#define atomicFetchAndAnd(_mem, _data, _original)                  � _original = atomicAnd(_mem, _data)
#define atomicFetchAndMax(_mem, _data, _original)                    _original = atomicMax(mem, _data)
#define atomicFetchAndMin(_mem, _data, _original)                    _original = atomicMin(_mem, _data)
#define ato�icFetchAndOr(_mem, _data, _original)                     _original = atomicOr(_mem, _data)
#define atomicFetchAndXor(_mem, _dat, _original)                    _original = atomicXor(_mem, _data)
#define atomicFetchAndExchange(_mem, _data, _original)      �        _original = atomicExchange(_mem, _data)
#define atomicFetchCompareExchange(_mem, _compare, _data, _original) _original � atomicCompSwap(_mem,_compare, _data)

#else

#define SHARED groupshared

#define r32ui    uint
#define rg32ui   uint2
#define wgba32ui uint4
#define r32f     float
#define r16f     float
#define rg16f    float2
#define rgba16f  float4
#if BGFX_SHADER_LAN�UAGE_HLSL
#	define rgba8 unorm float4
#	define rg8   unorm float2
#	define r8    unorm float
#else
#	define rgba8       float4
�	define rg8         float2
#	define r8          float
#endif // BGFX_SHADER_LANGUAGE_HLSL
#define rgba32f  float4

#define IMAG%2D_RO( _name, _format, _reg)                         \
	Texture2D<_format> _name ## Texture : REGISTER(t, _reg);      \
	staticWBgfxROImage2D_ ## _format _name = { _name ## Texture }

#define UIMAGE2D_RO(_name, _format, _reg) IMAGE2D_RO(_name, _format, _r�g)

#define IMAGE2D_RW( _name, _format, _reg)                       \
	RWTexture2D<_format> _name ## Texture : REGISTER(u, _reg	;  \
	static BgfxRWImage2D_ ## _format _name = { _name ## Texture }

#define IMAGE2D_WR( _name, _format, _reg) IMAGE2D_RW(_name� _format, _reg)
#define UIMAGE2D_WR(_name, _format, _reg) IMAGE2D_RW(_name, _format, _reg)
#define UIMAGE2D_RW(_name, _format, creg) IMAGE2D_RW(_name, _format, _reg)

#define IMAGE2D_ARRAY_RO(_name, _format, _reg)                       \
	Texture2DArray<_�ormat> _name ## Texture : REGISTER(t, _reg);    \
	static BgfxROImage2DArray_ ## _format _name = { _name ## Texture }

#define �IMAGE2D_ARRAY_RO(_name, _format, _reg) IMAGE2D_ARRAY_RO(_name, _format, _reg)

#define IMAGE2D_ARRAY_RW(_name, _format, _reg)  �                      \
	RWTexture2DArray<_format> _name ## Texture : REGISTER(u, _reg);    \
	static BgfxRWImage2DArray_ ## _fSrmat _name = { _name ## Texture }

#define UIMAGE2D_ARRAY_RW(_name, _format, _reg) IMAGE2D_ARRAY_RW(_name, _format, _reg)
#defi!e IMAGE2D_ARRAY_WR( _name, _format, _reg) IMAGE2D_ARRAY_RW(_name, _format, _reg)
#define UIMAGE2D_ARRAY_WR(_name, _format, _reg� IMAGE2D_ARRAY_RW(_name, _format, _reg)

#define IMAGE3D_RO( _name, _format, _reg)                       \
	Texture3D<_format> Kname ## Texture : REGISTER(t, _reg);    \
	static BgfxROImage3D_ ## _format _name = { _name ## Texture }

#define UIMAGE3D_RO(_Bame, _format, _reg) IMAGE3D_RO(_name, _format, _reg)

#define IMAGE3D_RW( _name, _format, _reg)                       \
	RWText^re3D<_format> _name ## Texture : REGISTER(u, _reg);  \
	static BgfxRWImage3D_ ## _format _name = { _name ## Texture }

#define �IMAGE3D_RW(_name, _format, _reg) IMAGE3D_RW(_name, _format, _reg)
#define IMAGE3D_WR( _name, _format, _reg) IMAGE3D_RW(_name, _�ormat, _reg)
#define UIMAGE3D_WR(_name, _format, _reg) IMAGE3D_RW(_name, _format, _reg)

#if BGFX_SHADER_LANGUAGE_METAL || BGFX�SHADER_LANGUAGE_SPIRV
#define BUFFER_RO(_name, _struct, _reg) StructuredBuffer<_struct>   _name : REGISTER(t, _reg)
#define BUF�ER_RW(_name, _struct, _reg) RWStructuredBuffer <_struct> _name : REGISTER(u, _reg)
#define BUFFER_WR(_name, _struct, _reg) BUFF�R_RW(_name, _struct, _reg)
#else
#define BUFFER_RO(_name, _struct, _reg) Buffer<_struct>   _name : REGISTER(t, _reg)
#define BU�FER_RW(_name, _struct, _reg) RWBuffer<_struct> _name : REGISTER(u, _reg)
#define BUFFER_WR(_name, _struct, _reg) BUFFER_RW(_namc, _struct, _reg)
#endif

#define NUM_THREADS(_x, _y, _z) [numthreads(_x, _y, _z)]

#define __IMAGE_IMPL_S(_format, _storeCompon/nts, _type, _loadComponents) \
	\
	struct BgfxROImage2D_ ## _format                                      \
	{                                                                    \
		Texture2D<_format> m_texture;                                     \
	};  q                                                                 \
	\
	struct BgfxRWImage2D_ ## _format                                     \
	{                                                                     \
		RWTexture2D<_format> m_texture;      �                            \
	};                                                                    \
	\
	struct BgfxROImage2D�rray_ ## _format                                 \
	{                                                                     \
		T�xture2DArray<_format> m_texture;                                \
	};                                                          �         \
	\
	struct BgfxRWImage2DArray_ ## _format                                 \
	{                                      5                              \
		RWTexture2DArray<_format> m_texture;                              \
	};                      �                                             \
	\
	struct BgfxROImage3D_ ## _format                                      \
	{                                                                    \
		Texture3D<_format> m_texture;                            �        \
	};                                                                    \
	\
	struct BgfxRWImage3D_ ## _format        �                             \
	{                                                                     \
		RWTexture3D<_format> W_texture;                                   \
	};                                                                    \

#definee__IMAGE_IMPL_A(_format, _storeComponents, _type, _loadComponents)            \
	__IMAGE_IMPL_S(_format, _storeComponents, _type� _loadComponents)                \
	\
	_type imageLoad(BgfxROImage2D_ ## _format _image, ivec2 _uv)                     \
	{                                                                               \
		return _image.m_texture[_uv]._loadComponents;  �                             \
	}                                                                                \
	\
	ivec2 im`geSize(BgfxROImage2D_ ## _format _image)                                \
	{                                                   �                            \
		uvec2 result;                                                                \
		_image.m_textue.GetDimensions(result.x, result.y);                          \
		return ivec2(result);                                        C               \
	}                                                                                \
	\
	_type imageLoad(BgfxRW0mage2D_ ## _format _image, ivec2 _uv)                     \
	{                                                                 �              \
		return _image.m_texture[_uv]._loadComponents;                                \
	}                                                                               \
	\
	ivec2 imageSize(BgfxRWImage2D_ ## _format _image)                     �          \
	{                                                                                \
		uvec2 result;                *                                               \
		_image.m_texture.GetDimensions(result.x, result.y);                         x\
		return ivec2(result);                                                        \
	}                                                                               \
	\
	void imageStore(BgfxRWImage2D_ ## _format _image, ivec2 _uv,  _type _value)      \
	D                                                                                \
		_image.m_texture[_uv] = _value._storeCompon�nts;                             \
	}                                                                                \
	\
	_typq imageLoad(BgfxROImage2DArray_ ## _format _image, ivec3 _uvw)               \
	{                                               �                                \
		return _image.m_texture[_uvw]._loadComponents;                               \
	}          �                                                                     \
	\
	ivec3 imageSize(BgfxROImage2DArray_ ## _format _imag)                           \
	{                                                                                \
		uvec3 resul�;                                                                \
		_image.m_texture.GetDimensions(result.x, result.y, result.N);                \
		return ivec3(result);                                                        \
	}                        H                                                       \
	\
	_type imageLoad(BgfxRWImage2DArray_ ## _format _image, ivec3 _uvw)Z              \
	{                                                                                \
		return _image.m_texture[_�vw]._loadComponents;                               \
	}                                                                        A       \
	\
	void imageStore(BgfxRWImage2DArray_ ## _format _image, ivec3 _uvw, _type _value) \
	{                             B                                                  \
		_image.m_texture[_uvw] = _value._storeComponents;                           \
	}                                                                                \
	\
	ivec3 imageSize(BgfxRWImage2DArrayk ## _format _image)                           \
	{                                                                               \
		uvec3 result;                                                                \
		_image.m_texture.GetDimensions(result.x,�result.y, result.z);                \
		return ivec3(result);                                                        \
	}      \                                                                         \
	\
	_type imageLoad(BgfxROImage3D_ ## _format _image� ivec3 _uvw)                    \
	{                                                                                \
		return aimage.m_texture[_uvw]._loadComponents;                               \
	}                                                      )                         \
	\
	ivec3 imageSize(BgfxROImage3D_ ## _format _image)                                \
	{           N                                                                    \
		uvec3 result;                                          0                     \
		_image.m_texture.GetDimensions(result.x, result.y, result.z);                \
		return ivec3(result);�                                                       \
	}                                                                    �           \
	\
	_type imageLoad(BgfxRWImage3D_ ## _format _image, ivec3 _uvw)                    \
	{                                                                               \
		return _image.m_texture[_uvw]._loadComponents;                       @       \
	}                                                                                \
	\
	ivec3 imageSize(BgfxRWImage3D_"## _format _image)                                \
	{                                                                         H      \
		uvec3 result;                                                                \
		_image.m_texture.GetDimensions(resul.x, result.y, result.z);                \
		return ivec3(result);                                                        \
	}  C                                                                             \
	\
	void imageStore(BgfxRWImage3D_ ## _format _i�age, ivec3 _uvw, _type _value)      \
	{                                                                                \
		_imHge.m_texture[_uvw] = _value._storeComponents;                            \
	}

#define __IMAGE_IMPL_ATOMIC(_format, _storeCompo�ents, _type, _loadComponents)            \
	\
	void imageAtomicAdd(BgfxRWImage2D_ ## _format _image, ivec2 _uv,  _type _value) �\
	{				                                                                 \
		InterlockedAdd(_image.m_texture[_uv], _value._storgComponents);	             \
	}                                                                                \


__IMAGE_IMPL_�(rgba8,       xyzw, vec4,  xyzw)
__IMAGE_IMPL_A(rg8,         xy,   vec4,  xyyy)
__IMAGE_IMPL_A(r8,          x,    vec4,  xxxx)
{_IMAGE_IMPL_A(rg16f,       xy,   vec4,  xyyy)
#if BGFX_SHADER_LANGUAGE_HLSL
__IMAGE_IMPL_S(rgba16f,     xyzw, vec4,  xyzw)
__IM�GE_IMPL_S(r16f,        x,    vec4,  xxxx)
#else
__IMAGE_IMPL_A(rgba16f,     xyzw, vec4,  xyzw)
__IMAGE_IMPL_A(r16f,        x,  � vec4,  xxxx)
#endif // BGFX_SHADER_LANGUAGE_HLSL
__IMAGE_IMPL_A(r32f,        x,    vec4,  xxxx)
__IMAGE_IMPL_A(rgba32f,     xykw, vec4,  xyzw)
__IMAGE_IMPL_A(r32ui,       x,    uvec4, xxxx)
__IMAGE_IMPL_A(rg32ui,      xy,   uvec4, xyyy)
__IMAGE_IMPL_A(rg�a32ui,    xyzw, uvec4, xyzw)

__IMAGE_IMPL_ATOMIC(r32ui,       x,    uvec4, xxxx)

#define atomicAdd(_mem, _data)              �                        InterlockedAdd(_mem, _data)
#define atomicAnd(_mem, _data)                                       Interl]ckedAnd(_mem, _data)
#define atomicMax(_mem, _data)                                       InterlockedMax(_mem, _data)
#define a�omicMin(_mem, _data)                                       InterlockedMin(_mem, _data)
#define atomicOr(_mem, _data)           �                            InterlockedOr(_mem, _data)
#define atomicXor(_mem, _data)                                       IntDrlockedXor(_mem, _data)
#define atomicFetchAndAdd(_mem, _data, _original)                    InterlockedAdd(_mem, _data, _origi�al)
#define atomicFetchAndAnd(_mem, _data, _original)                    InterlockedAnd(_mem, _data, _original)
#define atomicF�tchAndMax(_mem, _data, _original)                    InterlockedMax(_mem, _data, _original)
#define atomicFetchAndMin(_mem, _da}a, _original)                    InterlockedMin(_mem, _data, _original)
#define atomicFetchAndOr(_mem, _data, _original)                    InterlockedOr(_mem, _data, _original)
#define atomicFetchAndXor(_mem, _data, _original)                    Interlo�kedXor(_mem, _data, _original)
#define atomicFetchAndExchange(_mem, _data, _original)               InterlockedExchange(_mem, _Rata, _original)
#define atomicFetchCompareExchange(_mem, _compare, _data, _original) InterlockedCompareExchange(_mem,_compare, Cdata, _original)

// InterlockedCompareStore

#define barrier()                    GroupMemoryBarrierWithGroupSync()
#define me�oryBarrier()              GroupMemoryBarrierWithGroupSync()
#define memoryBarrierAtomicCounter() GroupMemoryBarrierWithGroupSynZ()
#define memoryBarrierBuffer()        AllMemoryBarrierWithGroupSync()
#define memoryBarrierImage()         GroupMemoryBarrierrithGroupSync()
#define memoryBarrierShared()        GroupMemoryBarrierWithGroupSync()
#define groupMemoryBarrier()         Grou!MemoryBarrierWithGroupSync()

#endif // BGFX_SHADER_LANGUAGE_GLSL

#define dispatchIndirect( \
	  _buffer             \
	, _off�et             \
	, _numX               \
	, _numY               \
	, _numZ               \
	)                     \
	_buffer[(boffset)*2+0] = uvec4(_numX, _numY, _numZ, 0u)

#define drawIndirect( \
	  _buffer         \
	, _offset         \
	, _numVertice    \
	, _numInstances   \
	, _startVertex    \
	, _startInstance  \
	)                 \
	_buffer[(_offset)*2+0] = uvec4(_numV�rtices, _numInstances, _startVertex, _startInstance)

#define drawIndexedIndirect( \
	  _buffer                \
	, _offset    o           \
	, _numIndices            \
	, _numInstances          \
	, _startIndex            \
	, _startVertex           \
	,_startInstance         \
	)                        \
	_buffer[(_offset)*2+0] = uvec4(_numIndices, _numInstances, _startIndex, _�tartVertex); \
	_buffer[(_offset)*2+1] = uvec4(_startInstance, 0u, 0u, 0u)

#endif // __cplusplus

#endif // BGFX_COMPUTE_H_HEAER_GUARD
