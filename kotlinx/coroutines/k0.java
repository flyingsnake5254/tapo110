package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.internal.q;

final class k0<T>
  extends q<T>
{
  private static final AtomicIntegerFieldUpdater x = AtomicIntegerFieldUpdater.newUpdater(k0.class, "_decision");
  private volatile int _decision = 0;
  
  public k0(f paramf, c<? super T> paramc)
  {
    super(paramf, paramc);
  }
  
  private final boolean w0()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 1) {
          return false;
        }
        throw new IllegalStateException("Already resumed".toString());
      }
    } while (!x.compareAndSet(this, 0, 2));
    return true;
  }
  
  private final boolean x0()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 2) {
          return false;
        }
        throw new IllegalStateException("Already suspended".toString());
      }
    } while (!x.compareAndSet(this, 0, 1));
    return true;
  }
  
  public int p0()
  {
    return 1;
  }
  
  protected void u(Object paramObject, int paramInt)
  {
    if (w0()) {
      return;
    }
    super.u(paramObject, paramInt);
  }
  
  public final Object v0()
  {
    if (x0()) {
      return a.d();
    }
    Object localObject = k1.e(L());
    if (!(localObject instanceof r)) {
      return localObject;
    }
    throw ((r)localObject).b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */