package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.internal.ObjectUtil;

public final class PreferHeapByteBufAllocator
  implements ByteBufAllocator
{
  private final ByteBufAllocator allocator;
  
  public PreferHeapByteBufAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    this.allocator = ((ByteBufAllocator)ObjectUtil.checkNotNull(paramByteBufAllocator, "allocator"));
  }
  
  public ByteBuf buffer()
  {
    return this.allocator.heapBuffer();
  }
  
  public ByteBuf buffer(int paramInt)
  {
    return this.allocator.heapBuffer(paramInt);
  }
  
  public ByteBuf buffer(int paramInt1, int paramInt2)
  {
    return this.allocator.heapBuffer(paramInt1, paramInt2);
  }
  
  public int calculateNewCapacity(int paramInt1, int paramInt2)
  {
    return this.allocator.calculateNewCapacity(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf compositeBuffer()
  {
    return this.allocator.compositeHeapBuffer();
  }
  
  public CompositeByteBuf compositeBuffer(int paramInt)
  {
    return this.allocator.compositeHeapBuffer(paramInt);
  }
  
  public CompositeByteBuf compositeDirectBuffer()
  {
    return this.allocator.compositeDirectBuffer();
  }
  
  public CompositeByteBuf compositeDirectBuffer(int paramInt)
  {
    return this.allocator.compositeDirectBuffer(paramInt);
  }
  
  public CompositeByteBuf compositeHeapBuffer()
  {
    return this.allocator.compositeHeapBuffer();
  }
  
  public CompositeByteBuf compositeHeapBuffer(int paramInt)
  {
    return this.allocator.compositeHeapBuffer(paramInt);
  }
  
  public ByteBuf directBuffer()
  {
    return this.allocator.directBuffer();
  }
  
  public ByteBuf directBuffer(int paramInt)
  {
    return this.allocator.directBuffer(paramInt);
  }
  
  public ByteBuf directBuffer(int paramInt1, int paramInt2)
  {
    return this.allocator.directBuffer(paramInt1, paramInt2);
  }
  
  public ByteBuf heapBuffer()
  {
    return this.allocator.heapBuffer();
  }
  
  public ByteBuf heapBuffer(int paramInt)
  {
    return this.allocator.heapBuffer(paramInt);
  }
  
  public ByteBuf heapBuffer(int paramInt1, int paramInt2)
  {
    return this.allocator.heapBuffer(paramInt1, paramInt2);
  }
  
  public ByteBuf ioBuffer()
  {
    return this.allocator.heapBuffer();
  }
  
  public ByteBuf ioBuffer(int paramInt)
  {
    return this.allocator.heapBuffer(paramInt);
  }
  
  public ByteBuf ioBuffer(int paramInt1, int paramInt2)
  {
    return this.allocator.heapBuffer(paramInt1, paramInt2);
  }
  
  public boolean isDirectBufferPooled()
  {
    return this.allocator.isDirectBufferPooled();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\PreferHeapByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */