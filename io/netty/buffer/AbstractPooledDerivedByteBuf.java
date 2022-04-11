package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectPool.Handle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractPooledDerivedByteBuf
  extends AbstractReferenceCountedByteBuf
{
  private ByteBuf parent;
  private final ObjectPool.Handle<AbstractPooledDerivedByteBuf> recyclerHandle;
  private AbstractByteBuf rootParent;
  
  AbstractPooledDerivedByteBuf(ObjectPool.Handle<? extends AbstractPooledDerivedByteBuf> paramHandle)
  {
    super(0);
    this.recyclerHandle = paramHandle;
  }
  
  public final ByteBufAllocator alloc()
  {
    return unwrap().alloc();
  }
  
  public byte[] array()
  {
    return unwrap().array();
  }
  
  protected final void deallocate()
  {
    ByteBuf localByteBuf = this.parent;
    this.recyclerHandle.recycle(this);
    localByteBuf.release();
  }
  
  final ByteBuf duplicate0()
  {
    ensureAccessible();
    return new PooledNonRetainedDuplicateByteBuf(this, unwrap());
  }
  
  public boolean hasArray()
  {
    return unwrap().hasArray();
  }
  
  public boolean hasMemoryAddress()
  {
    return unwrap().hasMemoryAddress();
  }
  
  final <U extends AbstractPooledDerivedByteBuf> U init(AbstractByteBuf paramAbstractByteBuf, ByteBuf paramByteBuf, int paramInt1, int paramInt2, int paramInt3)
  {
    paramByteBuf.retain();
    this.parent = paramByteBuf;
    this.rootParent = paramAbstractByteBuf;
    try
    {
      maxCapacity(paramInt3);
      setIndex0(paramInt1, paramInt2);
      resetRefCnt();
      return this;
    }
    finally
    {
      this.rootParent = null;
      this.parent = null;
      paramByteBuf.release();
    }
  }
  
  public final ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    return nioBuffer(paramInt1, paramInt2);
  }
  
  public boolean isContiguous()
  {
    return unwrap().isContiguous();
  }
  
  public final boolean isDirect()
  {
    return unwrap().isDirect();
  }
  
  public boolean isReadOnly()
  {
    return unwrap().isReadOnly();
  }
  
  public final int nioBufferCount()
  {
    return unwrap().nioBufferCount();
  }
  
  @Deprecated
  public final ByteOrder order()
  {
    return unwrap().order();
  }
  
  final void parent(ByteBuf paramByteBuf)
  {
    this.parent = paramByteBuf;
  }
  
  public final ByteBuf retainedSlice()
  {
    int i = readerIndex();
    return retainedSlice(i, writerIndex() - i);
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    return new PooledNonRetainedSlicedByteBuf(this, unwrap(), paramInt1, paramInt2);
  }
  
  public final AbstractByteBuf unwrap()
  {
    return this.rootParent;
  }
  
  private static final class PooledNonRetainedDuplicateByteBuf
    extends UnpooledDuplicatedByteBuf
  {
    private final ReferenceCounted referenceCountDelegate;
    
    PooledNonRetainedDuplicateByteBuf(ReferenceCounted paramReferenceCounted, AbstractByteBuf paramAbstractByteBuf)
    {
      super();
      this.referenceCountDelegate = paramReferenceCounted;
    }
    
    public ByteBuf duplicate()
    {
      ensureAccessible();
      return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, this);
    }
    
    int refCnt0()
    {
      return this.referenceCountDelegate.refCnt();
    }
    
    boolean release0()
    {
      return this.referenceCountDelegate.release();
    }
    
    boolean release0(int paramInt)
    {
      return this.referenceCountDelegate.release(paramInt);
    }
    
    ByteBuf retain0()
    {
      this.referenceCountDelegate.retain();
      return this;
    }
    
    ByteBuf retain0(int paramInt)
    {
      this.referenceCountDelegate.retain(paramInt);
      return this;
    }
    
    public ByteBuf retainedDuplicate()
    {
      return PooledDuplicatedByteBuf.newInstance(unwrap(), this, readerIndex(), writerIndex());
    }
    
    public ByteBuf retainedSlice()
    {
      return retainedSlice(readerIndex(), capacity());
    }
    
    public ByteBuf retainedSlice(int paramInt1, int paramInt2)
    {
      return PooledSlicedByteBuf.newInstance(unwrap(), this, paramInt1, paramInt2);
    }
    
    public ByteBuf slice(int paramInt1, int paramInt2)
    {
      checkIndex(paramInt1, paramInt2);
      return new AbstractPooledDerivedByteBuf.PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), paramInt1, paramInt2);
    }
    
    ByteBuf touch0()
    {
      this.referenceCountDelegate.touch();
      return this;
    }
    
    ByteBuf touch0(Object paramObject)
    {
      this.referenceCountDelegate.touch(paramObject);
      return this;
    }
  }
  
  private static final class PooledNonRetainedSlicedByteBuf
    extends UnpooledSlicedByteBuf
  {
    private final ReferenceCounted referenceCountDelegate;
    
    PooledNonRetainedSlicedByteBuf(ReferenceCounted paramReferenceCounted, AbstractByteBuf paramAbstractByteBuf, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
      this.referenceCountDelegate = paramReferenceCounted;
    }
    
    public ByteBuf duplicate()
    {
      ensureAccessible();
      return new AbstractPooledDerivedByteBuf.PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, unwrap()).setIndex(idx(readerIndex()), idx(writerIndex()));
    }
    
    int refCnt0()
    {
      return this.referenceCountDelegate.refCnt();
    }
    
    boolean release0()
    {
      return this.referenceCountDelegate.release();
    }
    
    boolean release0(int paramInt)
    {
      return this.referenceCountDelegate.release(paramInt);
    }
    
    ByteBuf retain0()
    {
      this.referenceCountDelegate.retain();
      return this;
    }
    
    ByteBuf retain0(int paramInt)
    {
      this.referenceCountDelegate.retain(paramInt);
      return this;
    }
    
    public ByteBuf retainedDuplicate()
    {
      return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
    }
    
    public ByteBuf retainedSlice()
    {
      return retainedSlice(0, capacity());
    }
    
    public ByteBuf retainedSlice(int paramInt1, int paramInt2)
    {
      return PooledSlicedByteBuf.newInstance(unwrap(), this, idx(paramInt1), paramInt2);
    }
    
    public ByteBuf slice(int paramInt1, int paramInt2)
    {
      checkIndex(paramInt1, paramInt2);
      return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), idx(paramInt1), paramInt2);
    }
    
    ByteBuf touch0()
    {
      this.referenceCountDelegate.touch();
      return this;
    }
    
    ByteBuf touch0(Object paramObject)
    {
      this.referenceCountDelegate.touch(paramObject);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AbstractPooledDerivedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */