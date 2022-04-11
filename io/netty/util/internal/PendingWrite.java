package io.netty.util.internal;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;

public final class PendingWrite
{
  private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public PendingWrite newObject(ObjectPool.Handle<PendingWrite> paramAnonymousHandle)
    {
      return new PendingWrite(paramAnonymousHandle, null);
    }
  });
  private final ObjectPool.Handle<PendingWrite> handle;
  private Object msg;
  private Promise<Void> promise;
  
  private PendingWrite(ObjectPool.Handle<PendingWrite> paramHandle)
  {
    this.handle = paramHandle;
  }
  
  public static PendingWrite newInstance(Object paramObject, Promise<Void> paramPromise)
  {
    PendingWrite localPendingWrite = (PendingWrite)RECYCLER.get();
    localPendingWrite.msg = paramObject;
    localPendingWrite.promise = paramPromise;
    return localPendingWrite;
  }
  
  public boolean failAndRecycle(Throwable paramThrowable)
  {
    ReferenceCountUtil.release(this.msg);
    Promise localPromise = this.promise;
    if (localPromise != null) {
      localPromise.setFailure(paramThrowable);
    }
    return recycle();
  }
  
  public Object msg()
  {
    return this.msg;
  }
  
  public Promise<Void> promise()
  {
    return this.promise;
  }
  
  public boolean recycle()
  {
    this.msg = null;
    this.promise = null;
    this.handle.recycle(this);
    return true;
  }
  
  public Promise<Void> recycleAndGet()
  {
    Promise localPromise = this.promise;
    recycle();
    return localPromise;
  }
  
  public boolean successAndRecycle()
  {
    Promise localPromise = this.promise;
    if (localPromise != null) {
      localPromise.setSuccess(null);
    }
    return recycle();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\PendingWrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */