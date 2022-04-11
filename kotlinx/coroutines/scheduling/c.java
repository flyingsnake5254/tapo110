package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.y;

public class c
  extends w0
{
  private CoroutineScheduler c;
  private final int d;
  private final int f;
  private final long q;
  private final String x;
  
  public c(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    this.d = paramInt1;
    this.f = paramInt2;
    this.q = paramLong;
    this.x = paramString;
    this.c = v();
  }
  
  public c(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, k.f, paramString);
  }
  
  private final CoroutineScheduler v()
  {
    return new CoroutineScheduler(this.d, this.f, this.q, this.x);
  }
  
  public void dispatch(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    try
    {
      CoroutineScheduler.G(this.c, paramRunnable, null, false, 6, null);
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      i0.z.dispatch(paramf, paramRunnable);
    }
  }
  
  public void dispatchYield(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    try
    {
      CoroutineScheduler.G(this.c, paramRunnable, null, true, 2, null);
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      i0.z.dispatchYield(paramf, paramRunnable);
    }
  }
  
  public final y u(int paramInt)
  {
    int i;
    if (paramInt > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new e(this, paramInt, TaskMode.PROBABLY_BLOCKING);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected positive parallelism level, but have ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString().toString());
  }
  
  public final void w(Runnable paramRunnable, i parami, boolean paramBoolean)
  {
    j.f(paramRunnable, "block");
    j.f(parami, "context");
    try
    {
      this.c.F(paramRunnable, parami, paramBoolean);
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      i0.z.J(this.c.D(paramRunnable, parami));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */