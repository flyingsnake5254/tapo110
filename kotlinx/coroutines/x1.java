package kotlinx.coroutines;

import kotlin.jvm.internal.j;

public final class x1
{
  private static final ThreadLocal<q0> a = new ThreadLocal();
  public static final x1 b = new x1();
  
  public final q0 a()
  {
    ThreadLocal localThreadLocal = a;
    q0 localq0 = (q0)localThreadLocal.get();
    if (localq0 == null)
    {
      localq0 = t0.a();
      localThreadLocal.set(localq0);
    }
    return localq0;
  }
  
  public final void b()
  {
    a.set(null);
  }
  
  public final void c(q0 paramq0)
  {
    j.f(paramq0, "eventLoop");
    a.set(paramq0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\x1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */