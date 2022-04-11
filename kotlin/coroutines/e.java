package kotlin.coroutines;

import kotlin.Result;
import kotlin.Result.a;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

public final class e
{
  public static final <T> void a(l<? super c<? super T>, ? extends Object> paraml, c<? super T> paramc)
  {
    j.e(paraml, "$this$startCoroutine");
    j.e(paramc, "completion");
    paraml = a.c(a.a(paraml, paramc));
    paramc = kotlin.p.a;
    Result.a locala = Result.Companion;
    paraml.resumeWith(Result.constructor-impl(paramc));
  }
  
  public static final <R, T> void b(kotlin.jvm.b.p<? super R, ? super c<? super T>, ? extends Object> paramp, R paramR, c<? super T> paramc)
  {
    j.e(paramp, "$this$startCoroutine");
    j.e(paramc, "completion");
    paramc = a.c(a.b(paramp, paramR, paramc));
    paramp = kotlin.p.a;
    paramR = Result.Companion;
    paramc.resumeWith(Result.constructor-impl(paramp));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */