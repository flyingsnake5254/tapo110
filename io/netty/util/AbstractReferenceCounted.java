package io.netty.util;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCounted
  implements ReferenceCounted
{
  private static final AtomicIntegerFieldUpdater<AbstractReferenceCounted> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCounted.class, "refCnt");
  private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCounted.class, "refCnt");
  private static final ReferenceCountUpdater<AbstractReferenceCounted> updater = new ReferenceCountUpdater()
  {
    protected long unsafeOffset()
    {
      return AbstractReferenceCounted.REFCNT_FIELD_OFFSET;
    }
    
    protected AtomicIntegerFieldUpdater<AbstractReferenceCounted> updater()
    {
      return AbstractReferenceCounted.AIF_UPDATER;
    }
  };
  private volatile int refCnt = updater.initialValue();
  
  private boolean handleRelease(boolean paramBoolean)
  {
    if (paramBoolean) {
      deallocate();
    }
    return paramBoolean;
  }
  
  protected abstract void deallocate();
  
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
  
  public ReferenceCounted retain()
  {
    return updater.retain(this);
  }
  
  public ReferenceCounted retain(int paramInt)
  {
    return updater.retain(this, paramInt);
  }
  
  protected final void setRefCnt(int paramInt)
  {
    updater.setRefCnt(this, paramInt);
  }
  
  public ReferenceCounted touch()
  {
    return touch(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\AbstractReferenceCounted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */