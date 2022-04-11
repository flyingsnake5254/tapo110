package kotlin;

import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

class i
{
  public static <T> f<T> a(LazyThreadSafetyMode paramLazyThreadSafetyMode, a<? extends T> parama)
  {
    j.e(paramLazyThreadSafetyMode, "mode");
    j.e(parama, "initializer");
    int i = g.a[paramLazyThreadSafetyMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          paramLazyThreadSafetyMode = new UnsafeLazyImpl(parama);
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
      else {
        paramLazyThreadSafetyMode = new l(parama);
      }
    }
    else {
      paramLazyThreadSafetyMode = new m(parama, null, 2, null);
    }
    return paramLazyThreadSafetyMode;
  }
  
  public static <T> f<T> b(a<? extends T> parama)
  {
    j.e(parama, "initializer");
    return new m(parama, null, 2, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */