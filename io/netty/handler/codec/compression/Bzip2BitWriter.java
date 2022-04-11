package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

final class Bzip2BitWriter
{
  private long bitBuffer;
  private int bitCount;
  
  void flush(ByteBuf paramByteBuf)
  {
    int i = this.bitCount;
    if (i > 0)
    {
      long l = this.bitBuffer;
      int j = 64 - i;
      if (i <= 8) {
        paramByteBuf.writeByte((int)(l >>> j << 8 - i));
      } else if (i <= 16) {
        paramByteBuf.writeShort((int)(l >>> j << 16 - i));
      } else if (i <= 24) {
        paramByteBuf.writeMedium((int)(l >>> j << 24 - i));
      } else {
        paramByteBuf.writeInt((int)(l >>> j << 32 - i));
      }
    }
  }
  
  void writeBits(ByteBuf paramByteBuf, int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt <= 32))
    {
      int i = this.bitCount;
      long l = paramLong << 64 - paramInt >>> i | this.bitBuffer;
      i += paramInt;
      paramInt = i;
      paramLong = l;
      if (i >= 32)
      {
        paramByteBuf.writeInt((int)(l >>> 32));
        paramLong = l << 32;
        paramInt = i - 32;
      }
      this.bitBuffer = paramLong;
      this.bitCount = paramInt;
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("count: ");
    paramByteBuf.append(paramInt);
    paramByteBuf.append(" (expected: 0-32)");
    throw new IllegalArgumentException(paramByteBuf.toString());
  }
  
  void writeBoolean(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    int i = this.bitCount + 1;
    long l1 = this.bitBuffer;
    long l2 = 0L;
    if (paramBoolean) {
      l3 = 1L << 64 - i;
    } else {
      l3 = 0L;
    }
    long l3 = l1 | l3;
    if (i == 32)
    {
      paramByteBuf.writeInt((int)(l3 >>> 32));
      i = 0;
      l3 = l2;
    }
    this.bitBuffer = l3;
    this.bitCount = i;
  }
  
  void writeInt(ByteBuf paramByteBuf, int paramInt)
  {
    writeBits(paramByteBuf, 32, paramInt);
  }
  
  void writeUnary(ByteBuf paramByteBuf, int paramInt)
  {
    if (paramInt >= 0)
    {
      while (paramInt > 0)
      {
        writeBoolean(paramByteBuf, true);
        paramInt--;
      }
      writeBoolean(paramByteBuf, false);
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("value: ");
    paramByteBuf.append(paramInt);
    paramByteBuf.append(" (expected 0 or more)");
    throw new IllegalArgumentException(paramByteBuf.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2BitWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */