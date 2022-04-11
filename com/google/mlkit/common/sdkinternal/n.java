package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
public class n
{
  private final Object a = new Object();
  @GuardedBy("lock")
  private boolean b;
  @GuardedBy("lock")
  private final Queue<b> c = new ArrayDeque();
  private final AtomicReference<Thread> d = new AtomicReference();
  
  private final void c()
  {
    synchronized (this.a)
    {
      if (this.c.isEmpty())
      {
        this.b = false;
        return;
      }
      b localb = (b)this.c.remove();
      d(localb.a, localb.b);
      return;
    }
  }
  
  private final void d(Executor paramExecutor, Runnable paramRunnable)
  {
    paramExecutor.execute(new c0(this, paramRunnable));
  }
  
  @KeepForSdk
  public void a(Executor paramExecutor, Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      if (this.b)
      {
        Queue localQueue = this.c;
        b localb = new com/google/mlkit/common/sdkinternal/n$b;
        localb.<init>(paramExecutor, paramRunnable, null);
        localQueue.add(localb);
        return;
      }
      this.b = true;
      d(paramExecutor, paramRunnable);
      return;
    }
  }
  
  final class a
    implements Closeable
  {
    private a()
    {
      boolean bool;
      if ((Thread)n.b(n.this).getAndSet(Thread.currentThread()) == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool);
    }
    
    public final void close()
    {
      n.b(n.this).set(null);
      n.e(n.this);
    }
  }
  
  static final class b
  {
    final Executor a;
    final Runnable b;
    
    private b(Executor paramExecutor, Runnable paramRunnable)
    {
      this.a = paramExecutor;
      this.b = paramRunnable;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */