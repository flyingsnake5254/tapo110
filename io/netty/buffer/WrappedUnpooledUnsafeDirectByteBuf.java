package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class WrappedUnpooledUnsafeDirectByteBuf
  extends UnpooledUnsafeDirectByteBuf
{
  WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator paramByteBufAllocator, long paramLong, int paramInt, boolean paramBoolean)
  {
    super(paramByteBufAllocator, PlatformDependent.directBuffer(paramLong, paramInt), paramInt, paramBoolean);
  }
  
  protected void freeDirect(ByteBuffer paramByteBuffer)
  {
    PlatformDependent.freeMemory(this.memoryAddress);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\WrappedUnpooledUnsafeDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */