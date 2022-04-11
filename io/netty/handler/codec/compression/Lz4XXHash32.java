package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

public final class Lz4XXHash32
  extends ByteBufChecksum
{
  private static final XXHash32 XXHASH32 = XXHashFactory.fastestInstance().hash32();
  private final int seed;
  private boolean used;
  private int value;
  
  public Lz4XXHash32(int paramInt)
  {
    this.seed = paramInt;
  }
  
  public long getValue()
  {
    if (this.used) {
      return this.value & 0xFFFFFFF;
    }
    throw new IllegalStateException();
  }
  
  public void reset()
  {
    this.used = false;
  }
  
  public void update(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void update(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    if (!this.used)
    {
      if (paramByteBuf.hasArray()) {
        this.value = XXHASH32.hash(paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt1, paramInt2, this.seed);
      } else {
        this.value = XXHASH32.hash(CompressionUtil.safeNioBuffer(paramByteBuf, paramInt1, paramInt2), this.seed);
      }
      this.used = true;
      return;
    }
    throw new IllegalStateException();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.used)
    {
      this.value = XXHASH32.hash(paramArrayOfByte, paramInt1, paramInt2, this.seed);
      this.used = true;
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Lz4XXHash32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */