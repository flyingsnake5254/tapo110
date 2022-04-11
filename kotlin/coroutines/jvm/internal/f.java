package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

public final class f
{
  public static final <T> c<T> a(c<? super T> paramc)
  {
    j.e(paramc, "completion");
    return paramc;
  }
  
  public static final void b(c<?> paramc)
  {
    j.e(paramc, "frame");
  }
  
  public static final void c(c<?> paramc)
  {
    j.e(paramc, "frame");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */