package kotlin;

import kotlin.jvm.internal.j;

public final class k
{
  public static final Object a(Throwable paramThrowable)
  {
    j.e(paramThrowable, "exception");
    return new Result.Failure(paramThrowable);
  }
  
  public static final void b(Object paramObject)
  {
    if (!(paramObject instanceof Result.Failure)) {
      return;
    }
    throw ((Result.Failure)paramObject).exception;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */