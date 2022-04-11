package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.jvm.internal.j;

public abstract class ContinuationImpl
  extends BaseContinuationImpl
{
  private final f _context;
  private transient c<Object> intercepted;
  
  public ContinuationImpl(c<Object> paramc)
  {
    this(paramc, localf);
  }
  
  public ContinuationImpl(c<Object> paramc, f paramf)
  {
    super(paramc);
    this._context = paramf;
  }
  
  public f getContext()
  {
    f localf = this._context;
    j.c(localf);
    return localf;
  }
  
  public final c<Object> intercepted()
  {
    Object localObject = this.intercepted;
    if (localObject == null)
    {
      localObject = (d)getContext().get(d.e);
      if (localObject != null)
      {
        localObject = ((d)localObject).interceptContinuation(this);
        if (localObject != null) {}
      }
      else
      {
        localObject = this;
      }
      this.intercepted = ((c)localObject);
    }
    return (c<Object>)localObject;
  }
  
  protected void releaseIntercepted()
  {
    c localc = this.intercepted;
    if ((localc != null) && (localc != this))
    {
      f.b localb = getContext().get(d.e);
      j.c(localb);
      ((d)localb).releaseInterceptedContinuation(localc);
    }
    this.intercepted = b.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\ContinuationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */