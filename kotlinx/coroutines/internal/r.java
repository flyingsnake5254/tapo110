package kotlinx.coroutines.internal;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.a;

public final class r
{
  public static final Throwable a(a<?> parama, Throwable paramThrowable)
  {
    j.f(parama, "$this$tryRecover");
    j.f(paramThrowable, "exception");
    a<?> locala = parama;
    if (!(parama instanceof q)) {
      locala = null;
    }
    parama = (q)locala;
    if (parama != null)
    {
      parama = parama.q;
      if (parama != null) {
        return s.k(paramThrowable, parama);
      }
    }
    return paramThrowable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */