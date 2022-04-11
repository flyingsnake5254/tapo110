package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;

public final class UnpooledByteBufAllocator
  extends AbstractByteBufAllocator
  implements ByteBufAllocatorMetricProvider
{
  public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
  private final boolean disableLeakDetector;
  private final UnpooledByteBufAllocatorMetric metric = new UnpooledByteBufAllocatorMetric(null);
  private final boolean noCleaner;
  
  public UnpooledByteBufAllocator(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }
  
  public UnpooledByteBufAllocator(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramBoolean1, paramBoolean2, PlatformDependent.useDirectBufferNoCleaner());
  }
  
  public UnpooledByteBufAllocator(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramBoolean1);
    this.disableLeakDetector = paramBoolean2;
    if ((paramBoolean3) && (PlatformDependent.hasUnsafe()) && (PlatformDependent.hasDirectBufferNoCleanerConstructor())) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.noCleaner = paramBoolean1;
  }
  
  public CompositeByteBuf compositeDirectBuffer(int paramInt)
  {
    CompositeByteBuf localCompositeByteBuf = new CompositeByteBuf(this, true, paramInt);
    if (!this.disableLeakDetector) {
      localCompositeByteBuf = AbstractByteBufAllocator.toLeakAwareBuffer(localCompositeByteBuf);
    }
    return localCompositeByteBuf;
  }
  
  public CompositeByteBuf compositeHeapBuffer(int paramInt)
  {
    CompositeByteBuf localCompositeByteBuf = new CompositeByteBuf(this, false, paramInt);
    if (!this.disableLeakDetector) {
      localCompositeByteBuf = AbstractByteBufAllocator.toLeakAwareBuffer(localCompositeByteBuf);
    }
    return localCompositeByteBuf;
  }
  
  void decrementDirect(int paramInt)
  {
    this.metric.directCounter.add(-paramInt);
  }
  
  void decrementHeap(int paramInt)
  {
    this.metric.heapCounter.add(-paramInt);
  }
  
  void incrementDirect(int paramInt)
  {
    this.metric.directCounter.add(paramInt);
  }
  
  void incrementHeap(int paramInt)
  {
    this.metric.heapCounter.add(paramInt);
  }
  
  public boolean isDirectBufferPooled()
  {
    return false;
  }
  
  public ByteBufAllocatorMetric metric()
  {
    return this.metric;
  }
  
  protected ByteBuf newDirectBuffer(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (PlatformDependent.hasUnsafe())
    {
      if (this.noCleaner) {
        localObject = new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(this, paramInt1, paramInt2);
      } else {
        localObject = new InstrumentedUnpooledUnsafeDirectByteBuf(this, paramInt1, paramInt2);
      }
    }
    else {
      localObject = new InstrumentedUnpooledDirectByteBuf(this, paramInt1, paramInt2);
    }
    if (!this.disableLeakDetector) {
      localObject = AbstractByteBufAllocator.toLeakAwareBuffer((ByteBuf)localObject);
    }
    return (ByteBuf)localObject;
  }
  
  protected ByteBuf newHeapBuffer(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (PlatformDependent.hasUnsafe()) {
      localObject = new InstrumentedUnpooledUnsafeHeapByteBuf(this, paramInt1, paramInt2);
    } else {
      localObject = new InstrumentedUnpooledHeapByteBuf(this, paramInt1, paramInt2);
    }
    return (ByteBuf)localObject;
  }
  
  private static final class InstrumentedUnpooledDirectByteBuf
    extends UnpooledDirectByteBuf
  {
    InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator paramUnpooledByteBufAllocator, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    protected ByteBuffer allocateDirect(int paramInt)
    {
      ByteBuffer localByteBuffer = super.allocateDirect(paramInt);
      ((UnpooledByteBufAllocator)alloc()).incrementDirect(localByteBuffer.capacity());
      return localByteBuffer;
    }
    
    protected void freeDirect(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.capacity();
      super.freeDirect(paramByteBuffer);
      ((UnpooledByteBufAllocator)alloc()).decrementDirect(i);
    }
  }
  
  private static final class InstrumentedUnpooledHeapByteBuf
    extends UnpooledHeapByteBuf
  {
    InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator paramUnpooledByteBufAllocator, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    protected byte[] allocateArray(int paramInt)
    {
      byte[] arrayOfByte = super.allocateArray(paramInt);
      ((UnpooledByteBufAllocator)alloc()).incrementHeap(arrayOfByte.length);
      return arrayOfByte;
    }
    
    protected void freeArray(byte[] paramArrayOfByte)
    {
      int i = paramArrayOfByte.length;
      super.freeArray(paramArrayOfByte);
      ((UnpooledByteBufAllocator)alloc()).decrementHeap(i);
    }
  }
  
  private static final class InstrumentedUnpooledUnsafeDirectByteBuf
    extends UnpooledUnsafeDirectByteBuf
  {
    InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator paramUnpooledByteBufAllocator, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    protected ByteBuffer allocateDirect(int paramInt)
    {
      ByteBuffer localByteBuffer = super.allocateDirect(paramInt);
      ((UnpooledByteBufAllocator)alloc()).incrementDirect(localByteBuffer.capacity());
      return localByteBuffer;
    }
    
    protected void freeDirect(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.capacity();
      super.freeDirect(paramByteBuffer);
      ((UnpooledByteBufAllocator)alloc()).decrementDirect(i);
    }
  }
  
  private static final class InstrumentedUnpooledUnsafeHeapByteBuf
    extends UnpooledUnsafeHeapByteBuf
  {
    InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator paramUnpooledByteBufAllocator, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    protected byte[] allocateArray(int paramInt)
    {
      byte[] arrayOfByte = super.allocateArray(paramInt);
      ((UnpooledByteBufAllocator)alloc()).incrementHeap(arrayOfByte.length);
      return arrayOfByte;
    }
    
    protected void freeArray(byte[] paramArrayOfByte)
    {
      int i = paramArrayOfByte.length;
      super.freeArray(paramArrayOfByte);
      ((UnpooledByteBufAllocator)alloc()).decrementHeap(i);
    }
  }
  
  private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf
    extends UnpooledUnsafeNoCleanerDirectByteBuf
  {
    InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator paramUnpooledByteBufAllocator, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    protected ByteBuffer allocateDirect(int paramInt)
    {
      ByteBuffer localByteBuffer = super.allocateDirect(paramInt);
      ((UnpooledByteBufAllocator)alloc()).incrementDirect(localByteBuffer.capacity());
      return localByteBuffer;
    }
    
    protected void freeDirect(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.capacity();
      super.freeDirect(paramByteBuffer);
      ((UnpooledByteBufAllocator)alloc()).decrementDirect(i);
    }
    
    ByteBuffer reallocateDirect(ByteBuffer paramByteBuffer, int paramInt)
    {
      int i = paramByteBuffer.capacity();
      paramByteBuffer = super.reallocateDirect(paramByteBuffer, paramInt);
      ((UnpooledByteBufAllocator)alloc()).incrementDirect(paramByteBuffer.capacity() - i);
      return paramByteBuffer;
    }
  }
  
  private static final class UnpooledByteBufAllocatorMetric
    implements ByteBufAllocatorMetric
  {
    final LongCounter directCounter = PlatformDependent.newLongCounter();
    final LongCounter heapCounter = PlatformDependent.newLongCounter();
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(StringUtil.simpleClassName(this));
      localStringBuilder.append("(usedHeapMemory: ");
      localStringBuilder.append(usedHeapMemory());
      localStringBuilder.append("; usedDirectMemory: ");
      localStringBuilder.append(usedDirectMemory());
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    
    public long usedDirectMemory()
    {
      return this.directCounter.value();
    }
    
    public long usedHeapMemory()
    {
      return this.heapCounter.value();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */