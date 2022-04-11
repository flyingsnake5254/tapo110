package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.j;

public abstract class s0
  extends q0
{
  protected abstract Thread D();
  
  protected final void E(long paramLong, r0.a parama)
  {
    j.f(parama, "delayedTask");
    if (g0.a())
    {
      int i;
      if (this != i0.z) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    i0.z.P(paramLong, parama);
  }
  
  protected final void F()
  {
    Thread localThread = D();
    if (Thread.currentThread() != localThread)
    {
      y1 localy1 = z1.a();
      if (localy1 != null) {
        localy1.b(localThread);
      } else {
        LockSupport.unpark(localThread);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */