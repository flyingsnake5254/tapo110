package io.reactivex.d0.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.e0.c;
import io.reactivex.e0.d;
import io.reactivex.j0.a;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

final class b
  extends w
{
  private final Handler c;
  private final boolean d;
  
  b(Handler paramHandler, boolean paramBoolean)
  {
    this.c = paramHandler;
    this.d = paramBoolean;
  }
  
  public w.c b()
  {
    return new a(this.c, this.d);
  }
  
  @SuppressLint({"NewApi"})
  public c d(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    Objects.requireNonNull(paramRunnable, "run == null");
    Objects.requireNonNull(paramTimeUnit, "unit == null");
    paramRunnable = a.t(paramRunnable);
    paramRunnable = new b(this.c, paramRunnable);
    Message localMessage = Message.obtain(this.c, paramRunnable);
    if (this.d) {
      localMessage.setAsynchronous(true);
    }
    this.c.sendMessageDelayed(localMessage, paramTimeUnit.toMillis(paramLong));
    return paramRunnable;
  }
  
  private static final class a
    extends w.c
  {
    private final Handler c;
    private final boolean d;
    private volatile boolean f;
    
    a(Handler paramHandler, boolean paramBoolean)
    {
      this.c = paramHandler;
      this.d = paramBoolean;
    }
    
    @SuppressLint({"NewApi"})
    public c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      Objects.requireNonNull(paramRunnable, "run == null");
      Objects.requireNonNull(paramTimeUnit, "unit == null");
      if (this.f) {
        return d.a();
      }
      paramRunnable = a.t(paramRunnable);
      paramRunnable = new b.b(this.c, paramRunnable);
      Message localMessage = Message.obtain(this.c, paramRunnable);
      localMessage.obj = this;
      if (this.d) {
        localMessage.setAsynchronous(true);
      }
      this.c.sendMessageDelayed(localMessage, paramTimeUnit.toMillis(paramLong));
      if (this.f)
      {
        this.c.removeCallbacks(paramRunnable);
        return d.a();
      }
      return paramRunnable;
    }
    
    public void dispose()
    {
      this.f = true;
      this.c.removeCallbacksAndMessages(this);
    }
    
    public boolean isDisposed()
    {
      return this.f;
    }
  }
  
  private static final class b
    implements Runnable, c
  {
    private final Handler c;
    private final Runnable d;
    private volatile boolean f;
    
    b(Handler paramHandler, Runnable paramRunnable)
    {
      this.c = paramHandler;
      this.d = paramRunnable;
    }
    
    public void dispose()
    {
      this.c.removeCallbacks(this);
      this.f = true;
    }
    
    public boolean isDisposed()
    {
      return this.f;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	io/reactivex/d0/b/b$b:d	Ljava/lang/Runnable;
      //   4: invokeinterface 41 1 0
      //   9: goto +8 -> 17
      //   12: astore_1
      //   13: aload_1
      //   14: invokestatic 47	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   17: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	18	0	this	b
      //   12	2	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	9	12	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\d0\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */