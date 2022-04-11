package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

class Bzip2BitReader
{
  private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
  private long bitBuffer;
  private int bitCount;
  private ByteBuf in;
  
  boolean hasReadableBits(int paramInt)
  {
    if (paramInt >= 0)
    {
      boolean bool;
      if ((this.bitCount < paramInt) && ((this.in.readableBytes() << 3 & 0x7FFFFFFF) < paramInt - this.bitCount)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected value greater than 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean hasReadableBytes(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 268435455)) {
      return hasReadableBits(paramInt << 3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 0-");
    localStringBuilder.append(268435455);
    localStringBuilder.append(')');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean isReadable()
  {
    boolean bool;
    if ((this.bitCount <= 0) && (!this.in.isReadable())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  int readBits(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 32))
    {
      int i = this.bitCount;
      long l1 = this.bitBuffer;
      int j = i;
      long l2 = l1;
      if (i < paramInt)
      {
        j = this.in.readableBytes();
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              l2 = this.in.readUnsignedInt();
              j = 32;
            }
            else
            {
              l2 = this.in.readUnsignedMedium();
              j = 24;
            }
          }
          else
          {
            l2 = this.in.readUnsignedShort();
            j = 16;
          }
        }
        else
        {
          l2 = this.in.readUnsignedByte();
          j = 8;
        }
        l2 = l1 << j | l2;
        j = i + j;
        this.bitBuffer = l2;
      }
      j -= paramInt;
      this.bitCount = j;
      if (paramInt != 32) {
        l1 = (1 << paramInt) - 1;
      } else {
        l1 = 4294967295L;
      }
      return (int)(l2 >>> j & l1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 0-32 )");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean readBoolean()
  {
    boolean bool = true;
    if (readBits(1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  int readInt()
  {
    return readBits(32);
  }
  
  void refill()
  {
    int i = this.in.readUnsignedByte();
    this.bitBuffer = (this.bitBuffer << 8 | i);
    this.bitCount += 8;
  }
  
  void setByteBuf(ByteBuf paramByteBuf)
  {
    this.in = paramByteBuf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2BitReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */