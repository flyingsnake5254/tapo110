package io.netty.buffer;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCountedByteBuf
  extends AbstractByteBuf
{
  private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
  private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCountedByteBuf.class, "refCnt");
  private static final ReferenceCountUpdater<AbstractReferenceCountedByteBuf> updater = new ReferenceCountUpdater()
  {
    protected long unsafeOffset()
    {
      return AbstractReferenceCountedByteBuf.REFCNT_FIELD_OFFSET;
    }
    
    protected AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> updater()
    {
      return AbstractReferenceCountedByteBuf.AIF_UPDATER;
    }
  };
  private volatile int refCnt = updater.initialValue();
  
  protected AbstractReferenceCountedByteBuf(int paramInt)
  {
    super(paramInt);
  }
  
  private boolean handleRelease(boolean paramBoolean)
  {
    if (paramBoolean) {
      deallocate();
    }
    return paramBoolean;
  }
  
  protected abstract void deallocate();
  
  boolean isAccessible()
  {
    return updater.isLiveNonVolatile(this);
  }
  
  public int refCnt()
  {
    return updater.refCnt(this);
  }
  
  public boolean release()
  {
    return handleRelease(updater.release(this));
  }
  
  public boolean release(int paramInt)
  {
    return handleRelease(updater.release(this, paramInt));
  }
  
  protected final void resetRefCnt()
  {
    updater.resetRefCnt(this);
  }
  
  public ByteBuf retain()
  {
    return (ByteBuf)updater.retain(this);
  }
  
  public ByteBuf retain(int paramInt)
  {
    return (ByteBuf)updater.retain(this, paramInt);
  }
  
  protected final void setRefCnt(int paramInt)
  {
    updater.setRefCnt(this, paramInt);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AbstractReferenceCountedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */