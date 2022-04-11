package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

public final class a2
  extends y
{
  public static final a2 c = new a2();
  
  public void dispatch(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    throw new UnsupportedOperationException();
  }
  
  public boolean isDispatchNeeded(f paramf)
  {
    j.f(paramf, "context");
    return false;
  }
  
  public String toString()
  {
    return "Unconfined";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\a2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */