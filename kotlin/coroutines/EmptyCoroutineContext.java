package kotlin.coroutines;

import java.io.Serializable;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

public final class EmptyCoroutineContext
  implements f, Serializable
{
  public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
  private static final long serialVersionUID = 0L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public <R> R fold(R paramR, p<? super R, ? super f.b, ? extends R> paramp)
  {
    j.e(paramp, "operation");
    return paramR;
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    j.e(paramc, "key");
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    j.e(paramc, "key");
    return this;
  }
  
  public f plus(f paramf)
  {
    j.e(paramf, "context");
    return paramf;
  }
  
  public String toString()
  {
    return "EmptyCoroutineContext";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\EmptyCoroutineContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */