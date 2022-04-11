package androidx.lifecycle;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.y;

public final class PausingDispatcher
  extends y
{
  public final DispatchQueue dispatchQueue = new DispatchQueue();
  
  public void dispatch(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    this.dispatchQueue.runOrEnqueue(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\PausingDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */