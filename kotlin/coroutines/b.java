package kotlin.coroutines;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

public abstract class b<B extends f.b, E extends B>
  implements f.c<E>
{
  private final f.c<?> a;
  private final l<f.b, E> b;
  
  public final boolean a(f.c<?> paramc)
  {
    j.e(paramc, "key");
    boolean bool;
    if ((paramc != this) && (this.a != paramc)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final E b(f.b paramb)
  {
    j.e(paramb, "element");
    return (f.b)this.b.invoke(paramb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */