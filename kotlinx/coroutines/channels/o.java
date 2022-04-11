package kotlinx.coroutines.channels;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.a;
import kotlinx.coroutines.a0;

public class o<E>
  extends g<E>
  implements p<E>
{
  public o(kotlin.coroutines.f paramf, f<E> paramf1)
  {
    super(paramf, paramf1, true);
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  protected void r0(Throwable paramThrowable, boolean paramBoolean)
  {
    j.f(paramThrowable, "cause");
    if ((!w0().m(paramThrowable)) && (!paramBoolean)) {
      a0.a(getContext(), paramThrowable);
    }
  }
  
  protected void z0(kotlin.p paramp)
  {
    j.f(paramp, "value");
    v.a.a(w0(), null, 1, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */