package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.b.p;
import kotlinx.coroutines.d2.b;
import kotlinx.coroutines.internal.q;

public final class e0
{
  public static final <R> Object a(p<? super d0, ? super c<? super R>, ? extends Object> paramp, c<? super R> paramc)
  {
    q localq = new q(paramc.getContext(), paramc);
    paramp = b.d(localq, localq, paramp);
    if (paramp == a.d()) {
      f.c(paramc);
    }
    return paramp;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */