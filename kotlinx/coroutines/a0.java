package kotlinx.coroutines;

import kotlin.a;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

public final class a0
{
  public static final void a(f paramf, Throwable paramThrowable)
  {
    j.f(paramf, "context");
    j.f(paramThrowable, "exception");
    try
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)paramf.get(CoroutineExceptionHandler.g);
      if (localCoroutineExceptionHandler != null)
      {
        localCoroutineExceptionHandler.handleException(paramf, paramThrowable);
        return;
      }
      z.a(paramf, paramThrowable);
      return;
    }
    finally
    {
      z.a(paramf, b(paramThrowable, localThrowable));
    }
  }
  
  public static final Throwable b(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    j.f(paramThrowable1, "originalException");
    j.f(paramThrowable2, "thrownException");
    if (paramThrowable1 == paramThrowable2) {
      return paramThrowable1;
    }
    paramThrowable2 = new RuntimeException("Exception while trying to handle coroutine exception", paramThrowable2);
    a.a(paramThrowable2, paramThrowable1);
    return paramThrowable2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */