package io.netty.buffer;

import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

class SimpleLeakAwareByteBuf
  extends WrappedByteBuf
{
  final ResourceLeakTracker<ByteBuf> leak;
  private final ByteBuf trackedByteBuf;
  
  SimpleLeakAwareByteBuf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    super(paramByteBuf1);
    this.trackedByteBuf = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf2, "trackedByteBuf"));
    this.leak = ((ResourceLeakTracker)ObjectUtil.checkNotNull(paramResourceLeakTracker, "leak"));
  }
  
  SimpleLeakAwareByteBuf(ByteBuf paramByteBuf, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    this(paramByteBuf, paramByteBuf, paramResourceLeakTracker);
  }
  
  private void closeLeak()
  {
    this.leak.close(this.trackedByteBuf);
  }
  
  private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf paramByteBuf, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    return newLeakAwareByteBuf(paramByteBuf, paramByteBuf, paramResourceLeakTracker);
  }
  
  private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf paramByteBuf)
  {
    return newLeakAwareByteBuf(paramByteBuf, this.trackedByteBuf, this.leak);
  }
  
  private static ByteBuf unwrapSwapped(ByteBuf paramByteBuf)
  {
    ByteBuf localByteBuf = paramByteBuf;
    if ((paramByteBuf instanceof SwappedByteBuf)) {
      do
      {
        localByteBuf = paramByteBuf.unwrap();
        paramByteBuf = localByteBuf;
      } while ((localByteBuf instanceof SwappedByteBuf));
    }
    return localByteBuf;
  }
  
  private ByteBuf unwrappedDerived(ByteBuf paramByteBuf)
  {
    Object localObject = unwrapSwapped(paramByteBuf);
    if ((localObject instanceof AbstractPooledDerivedByteBuf))
    {
      ((AbstractPooledDerivedByteBuf)localObject).parent(this);
      localObject = AbstractByteBuf.leakDetector.track(paramByteBuf);
      if (localObject == null) {
        return paramByteBuf;
      }
      return newLeakAwareByteBuf(paramByteBuf, (ResourceLeakTracker)localObject);
    }
    return newSharedLeakAwareByteBuf(paramByteBuf);
  }
  
  public ByteBuf asReadOnly()
  {
    return newSharedLeakAwareByteBuf(super.asReadOnly());
  }
  
  public ByteBuf duplicate()
  {
    return newSharedLeakAwareByteBuf(super.duplicate());
  }
  
  protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    return new SimpleLeakAwareByteBuf(paramByteBuf1, paramByteBuf2, paramResourceLeakTracker);
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    if (order() == paramByteOrder) {
      return this;
    }
    return newSharedLeakAwareByteBuf(super.order(paramByteOrder));
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return unwrappedDerived(super.readRetainedSlice(paramInt));
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return newSharedLeakAwareByteBuf(super.readSlice(paramInt));
  }
  
  public boolean release()
  {
    if (super.release())
    {
      closeLeak();
      return true;
    }
    return false;
  }
  
  public boolean release(int paramInt)
  {
    if (super.release(paramInt))
    {
      closeLeak();
      return true;
    }
    return false;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return unwrappedDerived(super.retainedDuplicate());
  }
  
  public ByteBuf retainedSlice()
  {
    return unwrappedDerived(super.retainedSlice());
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return unwrappedDerived(super.retainedSlice(paramInt1, paramInt2));
  }
  
  public ByteBuf slice()
  {
    return newSharedLeakAwareByteBuf(super.slice());
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return newSharedLeakAwareByteBuf(super.slice(paramInt1, paramInt2));
  }
  
  public ByteBuf touch()
  {
    return this;
  }
  
  public ByteBuf touch(Object paramObject)
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\SimpleLeakAwareByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */