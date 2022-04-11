package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.g0;

public abstract class d<T>
  extends o
{
  private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");
  private volatile Object _consensus = c.a();
  
  private final Object c(Object paramObject)
  {
    if (!f(paramObject)) {
      paramObject = this._consensus;
    }
    return paramObject;
  }
  
  public final Object a(Object paramObject)
  {
    Object localObject1 = this._consensus;
    Object localObject2 = localObject1;
    if (localObject1 == c.a()) {
      localObject2 = c(e(paramObject));
    }
    b(paramObject, localObject2);
    return localObject2;
  }
  
  public abstract void b(T paramT, Object paramObject);
  
  public final boolean d()
  {
    boolean bool;
    if (this._consensus != c.a()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract Object e(T paramT);
  
  public final boolean f(Object paramObject)
  {
    if (g0.a())
    {
      int i;
      if (paramObject != c.a()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    return a.compareAndSet(this, c.a(), paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */