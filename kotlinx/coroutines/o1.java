package kotlinx.coroutines;

import kotlin.jvm.internal.j;

public final class o1
  implements o0, m
{
  public static final o1 c = new o1();
  
  public boolean c(Throwable paramThrowable)
  {
    j.f(paramThrowable, "cause");
    return false;
  }
  
  public void dispose() {}
  
  public String toString()
  {
    return "NonDisposableHandle";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\o1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */