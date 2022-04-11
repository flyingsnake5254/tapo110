package kotlinx.coroutines.channels;

import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.x;

public final class n
{
  public static final <E> r<E> a(d0 paramd0, kotlin.coroutines.f paramf, int paramInt, kotlin.jvm.b.p<? super p<? super E>, ? super c<? super kotlin.p>, ? extends Object> paramp)
  {
    j.f(paramd0, "$this$produce");
    j.f(paramf, "context");
    j.f(paramp, "block");
    f localf = i.a(paramInt);
    paramd0 = new o(x.c(paramd0, paramf), localf);
    paramd0.u0(CoroutineStart.DEFAULT, paramd0, paramp);
    return paramd0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */