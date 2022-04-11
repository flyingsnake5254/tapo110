package kotlinx.coroutines;

import kotlin.coroutines.a;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.d.a;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.coroutines.f.c;
import kotlin.jvm.internal.j;

public abstract class y
  extends a
  implements d
{
  public y()
  {
    super(d.e);
  }
  
  public abstract void dispatch(f paramf, Runnable paramRunnable);
  
  public void dispatchYield(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    dispatch(paramf, paramRunnable);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    j.f(paramc, "key");
    return d.a.a(this, paramc);
  }
  
  public final <T> c<T> interceptContinuation(c<? super T> paramc)
  {
    j.f(paramc, "continuation");
    return new j0(this, paramc);
  }
  
  public boolean isDispatchNeeded(f paramf)
  {
    j.f(paramf, "context");
    return true;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    j.f(paramc, "key");
    return d.a.b(this, paramc);
  }
  
  public final y plus(y paramy)
  {
    j.f(paramy, "other");
    return paramy;
  }
  
  public void releaseInterceptedContinuation(c<?> paramc)
  {
    j.f(paramc, "continuation");
    d.a.c(this, paramc);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h0.a(this));
    localStringBuilder.append('@');
    localStringBuilder.append(h0.b(this));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */