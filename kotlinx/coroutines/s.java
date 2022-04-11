package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.internal.j;
import kotlin.k;

public final class s
{
  public static final <T> Object a(Object paramObject)
  {
    if (Result.isSuccess-impl(paramObject))
    {
      k.b(paramObject);
    }
    else
    {
      paramObject = Result.exceptionOrNull-impl(paramObject);
      if (paramObject == null) {
        j.n();
      }
      paramObject = new r((Throwable)paramObject, false, 2, null);
    }
    return paramObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */