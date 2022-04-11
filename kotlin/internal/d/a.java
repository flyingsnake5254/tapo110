package kotlin.internal.d;

import kotlin.jvm.internal.j;

public class a
  extends kotlin.internal.a
{
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    j.e(paramThrowable1, "cause");
    j.e(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\internal\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */