package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.y;

final class e
  extends w0
  implements i, Executor
{
  private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");
  private final ConcurrentLinkedQueue<Runnable> d;
  private final c f;
  private volatile int inFlightTasks;
  private final int q;
  private final TaskMode x;
  
  public e(c paramc, int paramInt, TaskMode paramTaskMode)
  {
    this.f = paramc;
    this.q = paramInt;
    this.x = paramTaskMode;
    this.d = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
  }
  
  private final void u(Runnable paramRunnable, boolean paramBoolean)
  {
    do
    {
      AtomicIntegerFieldUpdater localAtomicIntegerFieldUpdater = c;
      if (localAtomicIntegerFieldUpdater.incrementAndGet(this) <= this.q)
      {
        this.f.w(paramRunnable, this, paramBoolean);
        return;
      }
      this.d.add(paramRunnable);
      if (localAtomicIntegerFieldUpdater.decrementAndGet(this) >= this.q) {
        return;
      }
      paramRunnable = (Runnable)this.d.poll();
    } while (paramRunnable != null);
  }
  
  public void c()
  {
    Runnable localRunnable = (Runnable)this.d.poll();
    if (localRunnable != null)
    {
      this.f.w(localRunnable, this, true);
      return;
    }
    c.decrementAndGet(this);
    localRunnable = (Runnable)this.d.poll();
    if (localRunnable != null) {
      u(localRunnable, true);
    }
  }
  
  public void close()
  {
    throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
  }
  
  public void dispatch(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    u(paramRunnable, false);
  }
  
  public TaskMode e()
  {
    return this.x;
  }
  
  public void execute(Runnable paramRunnable)
  {
    j.f(paramRunnable, "command");
    u(paramRunnable, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[dispatcher = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */