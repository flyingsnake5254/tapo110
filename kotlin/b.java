package kotlin;

import kotlin.internal.a;
import kotlin.jvm.internal.j;

class b
{
  public static void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    j.e(paramThrowable1, "$this$addSuppressed");
    j.e(paramThrowable2, "exception");
    if (paramThrowable1 != paramThrowable2) {
      kotlin.internal.b.a.a(paramThrowable1, paramThrowable2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */