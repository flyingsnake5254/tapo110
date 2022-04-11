package b.d.e0.i;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class g
{
  private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new b(null));
  private final Activity b;
  private ScheduledFuture<?> c = null;
  
  public g(Activity paramActivity)
  {
    this.b = paramActivity;
    b();
  }
  
  private void a()
  {
    ScheduledFuture localScheduledFuture = this.c;
    if (localScheduledFuture != null)
    {
      localScheduledFuture.cancel(true);
      this.c = null;
    }
  }
  
  public void b()
  {
    a();
    this.c = this.a.schedule(new f(this.b), 300L, TimeUnit.SECONDS);
  }
  
  public void c()
  {
    a();
    this.a.shutdown();
  }
  
  private static final class b
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setDaemon(true);
      return paramRunnable;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\i\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */