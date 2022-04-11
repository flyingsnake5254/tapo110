package io.netty.handler.codec.redis;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;

final class RedisCodecUtil
{
  static byte[] longToAsciiBytes(long paramLong)
  {
    return Long.toString(paramLong).getBytes(CharsetUtil.US_ASCII);
  }
  
  static short makeShort(char paramChar1, char paramChar2)
  {
    if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
      paramChar1 |= paramChar2 << '\b';
    } else {
      paramChar1 = paramChar1 << '\b' | paramChar2;
    }
    return (short)paramChar1;
  }
  
  static byte[] shortToBytes(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
    {
      arrayOfByte[1] = ((byte)(byte)(paramShort >> 8 & 0xFF));
      arrayOfByte[0] = ((byte)(byte)(paramShort & 0xFF));
    }
    else
    {
      arrayOfByte[0] = ((byte)(byte)(paramShort >> 8 & 0xFF));
      arrayOfByte[1] = ((byte)(byte)(paramShort & 0xFF));
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisCodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */