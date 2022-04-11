package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class a
{
  private final boolean a;
  private final Executor b;
  @VisibleForTesting
  final Map<c, d> c = new HashMap();
  private final ReferenceQueue<p<?>> d = new ReferenceQueue();
  private p.a e;
  private volatile boolean f;
  @Nullable
  private volatile c g;
  
  a(boolean paramBoolean)
  {
    this(paramBoolean, Executors.newSingleThreadExecutor(new a()));
  }
  
  @VisibleForTesting
  a(boolean paramBoolean, Executor paramExecutor)
  {
    this.a = paramBoolean;
    this.b = paramExecutor;
    paramExecutor.execute(new b());
  }
  
  void a(c paramc, p<?> paramp)
  {
    try
    {
      d locald = new com/bumptech/glide/load/engine/a$d;
      locald.<init>(paramc, paramp, this.d, this.a);
      paramc = (d)this.c.put(paramc, locald);
      if (paramc != null) {
        paramc.a();
      }
      return;
    }
    finally {}
  }
  
  void b()
  {
    while (!this.f) {
      try
      {
        c((d)this.d.remove());
        c localc = this.g;
        if (localc != null) {
          localc.a();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
  }
  
  void c(@NonNull d paramd)
  {
    try
    {
      this.c.remove(paramd.a);
      if (paramd.b)
      {
        Object localObject = paramd.c;
        if (localObject != null)
        {
          localObject = new p((u)localObject, true, false, paramd.a, this.e);
          this.e.d(paramd.a, (p)localObject);
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  void d(c paramc)
  {
    try
    {
      paramc = (d)this.c.remove(paramc);
      if (paramc != null) {
        paramc.a();
      }
      return;
    }
    finally {}
  }
  
  @Nullable
  p<?> e(c paramc)
  {
    try
    {
      paramc = (d)this.c.get(paramc);
      if (paramc == null) {
        return null;
      }
      p localp = (p)paramc.get();
      if (localp == null) {
        c(paramc);
      }
      return localp;
    }
    finally {}
  }
  
  /* Error */
  void f(p.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 124	com/bumptech/glide/load/engine/a:e	Lcom/bumptech/glide/load/engine/p$a;
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_1
    //   12: monitorexit
    //   13: return
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	a
    //   0	24	1	parama	p.a
    //   14	4	2	localObject1	Object
    //   19	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	14	finally
    //   15	17	14	finally
    //   2	4	19	finally
    //   11	13	19	finally
    //   17	19	19	finally
    //   20	22	19	finally
  }
  
  class a
    implements ThreadFactory
  {
    public Thread newThread(@NonNull final Runnable paramRunnable)
    {
      return new Thread(new a(paramRunnable), "glide-active-resources");
    }
    
    class a
      implements Runnable
    {
      a(Runnable paramRunnable) {}
      
      public void run()
      {
        Process.setThreadPriority(10);
        paramRunnable.run();
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      a.this.b();
    }
  }
  
  @VisibleForTesting
  static abstract interface c
  {
    public abstract void a();
  }
  
  @VisibleForTesting
  static final class d
    extends WeakReference<p<?>>
  {
    final c a;
    final boolean b;
    @Nullable
    u<?> c;
    
    d(@NonNull c paramc, @NonNull p<?> paramp, @NonNull ReferenceQueue<? super p<?>> paramReferenceQueue, boolean paramBoolean)
    {
      super(paramReferenceQueue);
      this.a = ((c)i.d(paramc));
      if ((paramp.f()) && (paramBoolean)) {
        paramc = (u)i.d(paramp.d());
      } else {
        paramc = null;
      }
      this.c = paramc;
      this.b = paramp.f();
    }
    
    void a()
    {
      this.c = null;
      clear();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */