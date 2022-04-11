package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.c;

public final class k
  extends r
{
  private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(k.class, "_resumed");
  private volatile int _resumed = 0;
  
  public k(c<?> paramc, Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramThrowable, paramBoolean);
  }
  
  public final boolean c()
  {
    return c.compareAndSet(this, 0, 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */