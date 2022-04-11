package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.coroutines.f.c;

public abstract interface CoroutineExceptionHandler
  extends f.b
{
  public static final a g = a.a;
  
  public abstract void handleException(f paramf, Throwable paramThrowable);
  
  public static final class a
    implements f.c<CoroutineExceptionHandler>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\CoroutineExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */