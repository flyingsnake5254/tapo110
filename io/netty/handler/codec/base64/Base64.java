package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

public final class Base64
{
  private static final byte EQUALS_SIGN = 61;
  private static final byte EQUALS_SIGN_ENC = -1;
  private static final int MAX_LINE_LENGTH = 76;
  private static final byte NEW_LINE = 10;
  private static final byte WHITE_SPACE_ENC = -5;
  
  private static byte[] alphabet(Base64Dialect paramBase64Dialect)
  {
    return ((Base64Dialect)ObjectUtil.checkNotNull(paramBase64Dialect, "dialect")).alphabet;
  }
  
  private static boolean breakLines(Base64Dialect paramBase64Dialect)
  {
    return ((Base64Dialect)ObjectUtil.checkNotNull(paramBase64Dialect, "dialect")).breakLinesByDefault;
  }
  
  private static byte[] decodabet(Base64Dialect paramBase64Dialect)
  {
    return ((Base64Dialect)ObjectUtil.checkNotNull(paramBase64Dialect, "dialect")).decodabet;
  }
  
  public static ByteBuf decode(ByteBuf paramByteBuf)
  {
    return decode(paramByteBuf, Base64Dialect.STANDARD);
  }
  
  public static ByteBuf decode(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return decode(paramByteBuf, paramInt1, paramInt2, Base64Dialect.STANDARD);
  }
  
  public static ByteBuf decode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, Base64Dialect paramBase64Dialect)
  {
    return decode(paramByteBuf, paramInt1, paramInt2, paramBase64Dialect, paramByteBuf.alloc());
  }
  
  public static ByteBuf decode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, Base64Dialect paramBase64Dialect, ByteBufAllocator paramByteBufAllocator)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "src");
    ObjectUtil.checkNotNull(paramBase64Dialect, "dialect");
    return new Decoder(null).decode(paramByteBuf, paramInt1, paramInt2, paramByteBufAllocator, paramBase64Dialect);
  }
  
  public static ByteBuf decode(ByteBuf paramByteBuf, Base64Dialect paramBase64Dialect)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "src");
    paramBase64Dialect = decode(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes(), paramBase64Dialect);
    paramByteBuf.readerIndex(paramByteBuf.writerIndex());
    return paramBase64Dialect;
  }
  
  static int decodedBufferSize(int paramInt)
  {
    return paramInt - (paramInt >>> 2);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf)
  {
    return encode(paramByteBuf, Base64Dialect.STANDARD);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return encode(paramByteBuf, paramInt1, paramInt2, Base64Dialect.STANDARD);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, Base64Dialect paramBase64Dialect)
  {
    return encode(paramByteBuf, paramInt1, paramInt2, breakLines(paramBase64Dialect), paramBase64Dialect);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return encode(paramByteBuf, paramInt1, paramInt2, paramBoolean, Base64Dialect.STANDARD);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, boolean paramBoolean, Base64Dialect paramBase64Dialect)
  {
    return encode(paramByteBuf, paramInt1, paramInt2, paramBoolean, paramBase64Dialect, paramByteBuf.alloc());
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, boolean paramBoolean, Base64Dialect paramBase64Dialect, ByteBufAllocator paramByteBufAllocator)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "src");
    ObjectUtil.checkNotNull(paramBase64Dialect, "dialect");
    paramByteBufAllocator = paramByteBufAllocator.buffer(encodedBufferSize(paramInt2, paramBoolean)).order(paramByteBuf.order());
    paramBase64Dialect = alphabet(paramBase64Dialect);
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < paramInt2 - 2)
    {
      encode3to4(paramByteBuf, i + paramInt1, 3, paramByteBufAllocator, j, paramBase64Dialect);
      int m = k + 4;
      int n = j;
      k = m;
      if (paramBoolean)
      {
        n = j;
        k = m;
        if (m == 76)
        {
          paramByteBufAllocator.setByte(j + 4, 10);
          n = j + 1;
          k = 0;
        }
      }
      i += 3;
      j = n + 4;
    }
    k = j;
    if (i < paramInt2)
    {
      encode3to4(paramByteBuf, i + paramInt1, paramInt2 - i, paramByteBufAllocator, j, paramBase64Dialect);
      k = j + 4;
    }
    paramInt1 = k;
    if (k > 1)
    {
      paramInt1 = k;
      if (paramByteBufAllocator.getByte(k - 1) == 10) {
        paramInt1 = k - 1;
      }
    }
    return paramByteBufAllocator.slice(0, paramInt1);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, Base64Dialect paramBase64Dialect)
  {
    return encode(paramByteBuf, breakLines(paramBase64Dialect), paramBase64Dialect);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    return encode(paramByteBuf, paramBoolean, Base64Dialect.STANDARD);
  }
  
  public static ByteBuf encode(ByteBuf paramByteBuf, boolean paramBoolean, Base64Dialect paramBase64Dialect)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "src");
    paramBase64Dialect = encode(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes(), paramBoolean, paramBase64Dialect);
    paramByteBuf.readerIndex(paramByteBuf.writerIndex());
    return paramBase64Dialect;
  }
  
  private static void encode3to4(ByteBuf paramByteBuf1, int paramInt1, int paramInt2, ByteBuf paramByteBuf2, int paramInt3, byte[] paramArrayOfByte)
  {
    ByteOrder localByteOrder1 = paramByteBuf1.order();
    ByteOrder localByteOrder2 = ByteOrder.BIG_ENDIAN;
    int i = 0;
    int j = 0;
    if (localByteOrder1 == localByteOrder2)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 <= 0) {
            paramInt1 = j;
          } else {
            paramInt1 = toIntBE(paramByteBuf1.getMedium(paramInt1));
          }
        }
        else {
          paramInt1 = toIntBE(paramByteBuf1.getShort(paramInt1));
        }
      }
      else {
        paramInt1 = toInt(paramByteBuf1.getByte(paramInt1));
      }
      encode3to4BigEndian(paramInt1, paramInt2, paramByteBuf2, paramInt3, paramArrayOfByte);
    }
    else
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 <= 0) {
            paramInt1 = i;
          } else {
            paramInt1 = toIntLE(paramByteBuf1.getMedium(paramInt1));
          }
        }
        else {
          paramInt1 = toIntLE(paramByteBuf1.getShort(paramInt1));
        }
      }
      else {
        paramInt1 = toInt(paramByteBuf1.getByte(paramInt1));
      }
      encode3to4LittleEndian(paramInt1, paramInt2, paramByteBuf2, paramInt3, paramArrayOfByte);
    }
  }
  
  private static void encode3to4BigEndian(int paramInt1, int paramInt2, ByteBuf paramByteBuf, int paramInt3, byte[] paramArrayOfByte)
  {
    if (paramInt2 != 1)
    {
      int j;
      if (paramInt2 != 2)
      {
        if (paramInt2 == 3)
        {
          int i = paramArrayOfByte[(paramInt1 >>> 18)];
          paramInt2 = paramArrayOfByte[(paramInt1 >>> 12 & 0x3F)];
          j = paramArrayOfByte[(paramInt1 >>> 6 & 0x3F)];
          paramByteBuf.setInt(paramInt3, paramArrayOfByte[(paramInt1 & 0x3F)] | i << 24 | paramInt2 << 16 | j << 8);
        }
      }
      else
      {
        paramInt2 = paramArrayOfByte[(paramInt1 >>> 18)];
        j = paramArrayOfByte[(paramInt1 >>> 12 & 0x3F)];
        paramByteBuf.setInt(paramInt3, paramArrayOfByte[(paramInt1 >>> 6 & 0x3F)] << 8 | paramInt2 << 24 | j << 16 | 0x3D);
      }
    }
    else
    {
      paramInt2 = paramArrayOfByte[(paramInt1 >>> 18)];
      paramByteBuf.setInt(paramInt3, paramArrayOfByte[(paramInt1 >>> 12 & 0x3F)] << 16 | paramInt2 << 24 | 0x3D00 | 0x3D);
    }
  }
  
  private static void encode3to4LittleEndian(int paramInt1, int paramInt2, ByteBuf paramByteBuf, int paramInt3, byte[] paramArrayOfByte)
  {
    if (paramInt2 != 1)
    {
      int j;
      if (paramInt2 != 2)
      {
        if (paramInt2 == 3)
        {
          paramInt2 = paramArrayOfByte[(paramInt1 >>> 18)];
          int i = paramArrayOfByte[(paramInt1 >>> 12 & 0x3F)];
          j = paramArrayOfByte[(paramInt1 >>> 6 & 0x3F)];
          paramByteBuf.setInt(paramInt3, paramArrayOfByte[(paramInt1 & 0x3F)] << 24 | paramInt2 | i << 8 | j << 16);
        }
      }
      else
      {
        j = paramArrayOfByte[(paramInt1 >>> 18)];
        paramInt2 = paramArrayOfByte[(paramInt1 >>> 12 & 0x3F)];
        paramByteBuf.setInt(paramInt3, paramArrayOfByte[(paramInt1 >>> 6 & 0x3F)] << 16 | j | paramInt2 << 8 | 0x3D000000);
      }
    }
    else
    {
      paramInt2 = paramArrayOfByte[(paramInt1 >>> 18)];
      paramByteBuf.setInt(paramInt3, paramArrayOfByte[(paramInt1 >>> 12 & 0x3F)] << 8 | paramInt2 | 0x3D0000 | 0x3D000000);
    }
  }
  
  static int encodedBufferSize(int paramInt, boolean paramBoolean)
  {
    long l1 = (paramInt << 2) / 3L;
    long l2 = 3L + l1 & 0xFFFFFFFFFFFFFFFC;
    long l3 = l2;
    if (paramBoolean) {
      l3 = l2 + l1 / 76L;
    }
    if (l3 < 2147483647L) {
      paramInt = (int)l3;
    } else {
      paramInt = Integer.MAX_VALUE;
    }
    return paramInt;
  }
  
  private static int toInt(byte paramByte)
  {
    return (paramByte & 0xFF) << 16;
  }
  
  private static int toIntBE(int paramInt)
  {
    return paramInt & 0xFF | 0xFF0000 & paramInt | 0xFF00 & paramInt;
  }
  
  private static int toIntBE(short paramShort)
  {
    return (paramShort & 0xFF) << 8 | (0xFF00 & paramShort) << 8;
  }
  
  private static int toIntLE(int paramInt)
  {
    return (paramInt & 0xFF0000) >>> 16 | (paramInt & 0xFF) << 16 | 0xFF00 & paramInt;
  }
  
  private static int toIntLE(short paramShort)
  {
    return paramShort & 0xFF00 | (paramShort & 0xFF) << 16;
  }
  
  private static final class Decoder
    implements ByteProcessor
  {
    private final byte[] b4 = new byte[4];
    private int b4Posn;
    private byte[] decodabet;
    private ByteBuf dest;
    private int outBuffPosn;
    
    private static int decode4to3(byte[] paramArrayOfByte1, ByteBuf paramByteBuf, int paramInt, byte[] paramArrayOfByte2)
    {
      int i = paramArrayOfByte1[0];
      int j = paramArrayOfByte1[1];
      int k = paramArrayOfByte1[2];
      if (k == 61)
      {
        m = paramArrayOfByte2[i];
        k = paramArrayOfByte2[j];
        paramByteBuf.setByte(paramInt, (m & 0xFF) << 2 | (k & 0xFF) >>> 4);
        return 1;
      }
      int m = paramArrayOfByte1[3];
      if (m == 61)
      {
        m = paramArrayOfByte2[j];
        try
        {
          if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN)
          {
            m = (m & 0xF) << 4 | ((paramArrayOfByte2[i] & 0x3F) << 2 | (m & 0xF0) >> 4) << 8 | (paramArrayOfByte2[k] & 0xFC) >>> 2;
          }
          else
          {
            i = paramArrayOfByte2[i];
            k = paramArrayOfByte2[k];
            m = ((m & 0xF) << 4 | (k & 0xFC) >>> 2) << 8 | (i & 0x3F) << 2 | (m & 0xF0) >> 4;
          }
          paramByteBuf.setShort(paramInt, m);
          return 2;
        }
        catch (IndexOutOfBoundsException paramArrayOfByte1)
        {
          throw new IllegalArgumentException("not encoded in Base64");
        }
      }
      try
      {
        if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN)
        {
          k = (paramArrayOfByte2[i] & 0x3F) << 18 | (paramArrayOfByte2[j] & 0xFF) << 12 | (paramArrayOfByte2[k] & 0xFF) << 6;
          m = paramArrayOfByte2[m] & 0xFF;
        }
        else
        {
          j = paramArrayOfByte2[j];
          k = paramArrayOfByte2[k];
          k = (paramArrayOfByte2[i] & 0x3F) << 2 | (j & 0xF) << 12 | (j & 0xF0) >>> 4 | (k & 0x3) << 22 | (k & 0xFC) << 6;
          m = paramArrayOfByte2[m];
          m = (m & 0xFF) << 16;
        }
        paramByteBuf.setMedium(paramInt, m | k);
        return 3;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte1)
      {
        throw new IllegalArgumentException("not encoded in Base64");
      }
    }
    
    ByteBuf decode(ByteBuf paramByteBuf, int paramInt1, int paramInt2, ByteBufAllocator paramByteBufAllocator, Base64Dialect paramBase64Dialect)
    {
      this.dest = paramByteBufAllocator.buffer(Base64.decodedBufferSize(paramInt2)).order(paramByteBuf.order());
      this.decodabet = Base64.decodabet(paramBase64Dialect);
      try
      {
        paramByteBuf.forEachByte(paramInt1, paramInt2, this);
        paramByteBuf = this.dest.slice(0, this.outBuffPosn);
        return paramByteBuf;
      }
      finally
      {
        this.dest.release();
        PlatformDependent.throwException(paramByteBuf);
      }
      return null;
    }
    
    public boolean process(byte paramByte)
      throws Exception
    {
      if (paramByte > 0)
      {
        byte[] arrayOfByte = this.decodabet;
        int i = arrayOfByte[paramByte];
        if (i >= -5)
        {
          boolean bool1 = true;
          boolean bool2 = bool1;
          if (i >= -1)
          {
            localObject = this.b4;
            int j = this.b4Posn;
            i = j + 1;
            this.b4Posn = i;
            localObject[j] = ((byte)paramByte);
            bool2 = bool1;
            if (i > 3)
            {
              i = this.outBuffPosn;
              this.outBuffPosn = (i + decode4to3((byte[])localObject, this.dest, i, arrayOfByte));
              this.b4Posn = 0;
              if (paramByte != 61) {
                bool2 = bool1;
              } else {
                bool2 = false;
              }
            }
          }
          return bool2;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid Base64 input character: ");
      ((StringBuilder)localObject).append((short)(paramByte & 0xFF));
      ((StringBuilder)localObject).append(" (decimal)");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\base64\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */