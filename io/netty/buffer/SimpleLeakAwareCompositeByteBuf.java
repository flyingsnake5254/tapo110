package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

class SimpleLeakAwareCompositeByteBuf
  extends WrappedCompositeByteBuf
{
  final ResourceLeakTracker<ByteBuf> leak;
  
  SimpleLeakAwareCompositeByteBuf(CompositeByteBuf paramCompositeByteBuf, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    super(paramCompositeByteBuf);
    this.leak = ((ResourceLeakTracker)ObjectUtil.checkNotNull(paramResourceLeakTracker, "leak"));
  }
  
  private void closeLeak(ByteBuf paramByteBuf)
  {
    this.leak.close(paramByteBuf);
  }
  
  private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf paramByteBuf)
  {
    return newLeakAwareByteBuf(paramByteBuf, unwrap(), this.leak);
  }
  
  public ByteBuf asReadOnly()
  {
    return newLeakAwareByteBuf(super.asReadOnly());
  }
  
  public ByteBuf duplicate()
  {
    return newLeakAwareByteBuf(super.duplicate());
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
    return newLeakAwareByteBuf(super.order(paramByteOrder));
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return newLeakAwareByteBuf(super.readRetainedSlice(paramInt));
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return newLeakAwareByteBuf(super.readSlice(paramInt));
  }
  
  public boolean release()
  {
    ByteBuf localByteBuf = unwrap();
    if (super.release())
    {
      closeLeak(localByteBuf);
      return true;
    }
    return false;
  }
  
  public boolean release(int paramInt)
  {
    ByteBuf localByteBuf = unwrap();
    if (super.release(paramInt))
    {
      closeLeak(localByteBuf);
      return true;
    }
    return false;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return newLeakAwareByteBuf(super.retainedDuplicate());
  }
  
  public ByteBuf retainedSlice()
  {
    return newLeakAwareByteBuf(super.retainedSlice());
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return newLeakAwareByteBuf(super.retainedSlice(paramInt1, paramInt2));
  }
  
  public ByteBuf slice()
  {
    return newLeakAwareByteBuf(super.slice());
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return newLeakAwareByteBuf(super.slice(paramInt1, paramInt2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\SimpleLeakAwareCompositeByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */