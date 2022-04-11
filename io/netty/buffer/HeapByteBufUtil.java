package io.netty.buffer;

final class HeapByteBufUtil
{
  static byte getByte(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt];
  }
  
  static int getInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  static int getIntLE(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return paramArrayOfByte[(paramInt + 7)] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  static long getLongLE(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)(paramArrayOfByte[(paramInt + 1)] & 0xFF | i << 8);
  }
  
  static short getShortLE(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)(paramArrayOfByte[(paramInt + 1)] << 8 | i & 0xFF);
  }
  
  static int getUnsignedMedium(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    return paramArrayOfByte[(paramInt + 2)] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  static int getUnsignedMediumLE(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | i & 0xFF | (j & 0xFF) << 8;
  }
  
  static void setByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
  }
  
  static void setInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 >>> 24));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)(paramInt2 >>> 16));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(byte)paramInt2);
  }
  
  static void setIntLE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(byte)(paramInt2 >>> 16));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(byte)(paramInt2 >>> 24));
  }
  
  static void setLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(byte)(int)(paramLong >>> 56));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(byte)(int)(paramLong >>> 48));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(byte)(int)(paramLong >>> 40));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(byte)(int)(paramLong >>> 32));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(byte)(int)paramLong);
  }
  
  static void setLongLE(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(byte)(int)paramLong);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(byte)(int)(paramLong >>> 32));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(byte)(int)(paramLong >>> 40));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(byte)(int)(paramLong >>> 48));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(byte)(int)(paramLong >>> 56));
  }
  
  static void setMedium(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 >>> 16));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(byte)paramInt2);
  }
  
  static void setMediumLE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(byte)(paramInt2 >>> 16));
  }
  
  static void setShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)paramInt2);
  }
  
  static void setShortLE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)(paramInt2 >>> 8));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\HeapByteBufUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */