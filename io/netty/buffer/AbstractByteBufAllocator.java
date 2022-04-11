package io.netty.buffer;

import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

public abstract class AbstractByteBufAllocator
  implements ByteBufAllocator
{
  static final int CALCULATE_THRESHOLD = 4194304;
  static final int DEFAULT_INITIAL_CAPACITY = 256;
  static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;
  static final int DEFAULT_MAX_COMPONENTS = 16;
  private final boolean directByDefault;
  private final ByteBuf emptyBuf;
  
  static
  {
    ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, new String[] { "toLeakAwareBuffer" });
  }
  
  protected AbstractByteBufAllocator()
  {
    this(false);
  }
  
  protected AbstractByteBufAllocator(boolean paramBoolean)
  {
    if ((paramBoolean) && (PlatformDependent.hasUnsafe())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.directByDefault = paramBoolean;
    this.emptyBuf = new EmptyByteBuf(this);
  }
  
  protected static ByteBuf toLeakAwareBuffer(ByteBuf paramByteBuf)
  {
    int i = 1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
    ResourceLeakTracker localResourceLeakTracker;
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        return paramByteBuf;
      }
      localResourceLeakTracker = AbstractByteBuf.leakDetector.track(paramByteBuf);
      localByteBuf = paramByteBuf;
      if (localResourceLeakTracker == null) {
        return localByteBuf;
      }
      paramByteBuf = new AdvancedLeakAwareByteBuf(paramByteBuf, localResourceLeakTracker);
    }
    else
    {
      localResourceLeakTracker = AbstractByteBuf.leakDetector.track(paramByteBuf);
      localByteBuf = paramByteBuf;
      if (localResourceLeakTracker == null) {
        return localByteBuf;
      }
      paramByteBuf = new SimpleLeakAwareByteBuf(paramByteBuf, localResourceLeakTracker);
    }
    ByteBuf localByteBuf = paramByteBuf;
    return localByteBuf;
  }
  
  protected static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf paramCompositeByteBuf)
  {
    int i = 1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
    ResourceLeakTracker localResourceLeakTracker;
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        return paramCompositeByteBuf;
      }
      localResourceLeakTracker = AbstractByteBuf.leakDetector.track(paramCompositeByteBuf);
      localCompositeByteBuf = paramCompositeByteBuf;
      if (localResourceLeakTracker == null) {
        return localCompositeByteBuf;
      }
      paramCompositeByteBuf = new AdvancedLeakAwareCompositeByteBuf(paramCompositeByteBuf, localResourceLeakTracker);
    }
    else
    {
      localResourceLeakTracker = AbstractByteBuf.leakDetector.track(paramCompositeByteBuf);
      localCompositeByteBuf = paramCompositeByteBuf;
      if (localResourceLeakTracker == null) {
        return localCompositeByteBuf;
      }
      paramCompositeByteBuf = new SimpleLeakAwareCompositeByteBuf(paramCompositeByteBuf, localResourceLeakTracker);
    }
    CompositeByteBuf localCompositeByteBuf = paramCompositeByteBuf;
    return localCompositeByteBuf;
  }
  
  private static void validate(int paramInt1, int paramInt2)
  {
    ObjectUtil.checkPositiveOrZero(paramInt1, "initialCapacity");
    if (paramInt1 <= paramInt2) {
      return;
    }
    throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public ByteBuf buffer()
  {
    if (this.directByDefault) {
      return directBuffer();
    }
    return heapBuffer();
  }
  
  public ByteBuf buffer(int paramInt)
  {
    if (this.directByDefault) {
      return directBuffer(paramInt);
    }
    return heapBuffer(paramInt);
  }
  
  public ByteBuf buffer(int paramInt1, int paramInt2)
  {
    if (this.directByDefault) {
      return directBuffer(paramInt1, paramInt2);
    }
    return heapBuffer(paramInt1, paramInt2);
  }
  
  public int calculateNewCapacity(int paramInt1, int paramInt2)
  {
    ObjectUtil.checkPositiveOrZero(paramInt1, "minNewCapacity");
    if (paramInt1 <= paramInt2)
    {
      if (paramInt1 == 4194304) {
        return 4194304;
      }
      if (paramInt1 > 4194304)
      {
        paramInt1 = paramInt1 / 4194304 * 4194304;
        if (paramInt1 <= paramInt2 - 4194304) {
          paramInt2 = paramInt1 + 4194304;
        }
        return paramInt2;
      }
      int i = 64;
      while (i < paramInt1) {
        i <<= 1;
      }
      return Math.min(i, paramInt2);
    }
    throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public CompositeByteBuf compositeBuffer()
  {
    if (this.directByDefault) {
      return compositeDirectBuffer();
    }
    return compositeHeapBuffer();
  }
  
  public CompositeByteBuf compositeBuffer(int paramInt)
  {
    if (this.directByDefault) {
      return compositeDirectBuffer(paramInt);
    }
    return compositeHeapBuffer(paramInt);
  }
  
  public CompositeByteBuf compositeDirectBuffer()
  {
    return compositeDirectBuffer(16);
  }
  
  public CompositeByteBuf compositeDirectBuffer(int paramInt)
  {
    return toLeakAwareBuffer(new CompositeByteBuf(this, true, paramInt));
  }
  
  public CompositeByteBuf compositeHeapBuffer()
  {
    return compositeHeapBuffer(16);
  }
  
  public CompositeByteBuf compositeHeapBuffer(int paramInt)
  {
    return toLeakAwareBuffer(new CompositeByteBuf(this, false, paramInt));
  }
  
  public ByteBuf directBuffer()
  {
    return directBuffer(256, Integer.MAX_VALUE);
  }
  
  public ByteBuf directBuffer(int paramInt)
  {
    return directBuffer(paramInt, Integer.MAX_VALUE);
  }
  
  public ByteBuf directBuffer(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return this.emptyBuf;
    }
    validate(paramInt1, paramInt2);
    return newDirectBuffer(paramInt1, paramInt2);
  }
  
  public ByteBuf heapBuffer()
  {
    return heapBuffer(256, Integer.MAX_VALUE);
  }
  
  public ByteBuf heapBuffer(int paramInt)
  {
    return heapBuffer(paramInt, Integer.MAX_VALUE);
  }
  
  public ByteBuf heapBuffer(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return this.emptyBuf;
    }
    validate(paramInt1, paramInt2);
    return newHeapBuffer(paramInt1, paramInt2);
  }
  
  public ByteBuf ioBuffer()
  {
    if ((!PlatformDependent.hasUnsafe()) && (!isDirectBufferPooled())) {
      return heapBuffer(256);
    }
    return directBuffer(256);
  }
  
  public ByteBuf ioBuffer(int paramInt)
  {
    if ((!PlatformDependent.hasUnsafe()) && (!isDirectBufferPooled())) {
      return heapBuffer(paramInt);
    }
    return directBuffer(paramInt);
  }
  
  public ByteBuf ioBuffer(int paramInt1, int paramInt2)
  {
    if ((!PlatformDependent.hasUnsafe()) && (!isDirectBufferPooled())) {
      return heapBuffer(paramInt1, paramInt2);
    }
    return directBuffer(paramInt1, paramInt2);
  }
  
  protected abstract ByteBuf newDirectBuffer(int paramInt1, int paramInt2);
  
  protected abstract ByteBuf newHeapBuffer(int paramInt1, int paramInt2);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(directByDefault: ");
    localStringBuilder.append(this.directByDefault);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AbstractByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */