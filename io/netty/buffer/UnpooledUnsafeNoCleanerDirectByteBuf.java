package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

class UnpooledUnsafeNoCleanerDirectByteBuf
  extends UnpooledUnsafeDirectByteBuf
{
  UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    super(paramByteBufAllocator, paramInt1, paramInt2);
  }
  
  protected ByteBuffer allocateDirect(int paramInt)
  {
    return PlatformDependent.allocateDirectNoCleaner(paramInt);
  }
  
  public ByteBuf capacity(int paramInt)
  {
    checkNewCapacity(paramInt);
    if (paramInt == capacity()) {
      return this;
    }
    trimIndicesToCapacity(paramInt);
    setByteBuffer(reallocateDirect(this.buffer, paramInt), false);
    return this;
  }
  
  protected void freeDirect(ByteBuffer paramByteBuffer)
  {
    PlatformDependent.freeDirectNoCleaner(paramByteBuffer);
  }
  
  ByteBuffer reallocateDirect(ByteBuffer paramByteBuffer, int paramInt)
  {
    return PlatformDependent.reallocateDirectNoCleaner(paramByteBuffer, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledUnsafeNoCleanerDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */