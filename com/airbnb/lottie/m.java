package com.airbnb.lottie;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.v.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class m<T>
{
  public static Executor a = ;
  private final Set<h<T>> b;
  private final Set<h<Throwable>> c;
  private final Handler d;
  @Nullable
  private volatile l<T> e;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public m(Callable<l<T>> paramCallable)
  {
    this(paramCallable, false);
  }
  
  /* Error */
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  m(Callable<l<T>> paramCallable, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 49	java/util/LinkedHashSet
    //   8: dup
    //   9: iconst_1
    //   10: invokespecial 52	java/util/LinkedHashSet:<init>	(I)V
    //   13: putfield 54	com/airbnb/lottie/m:b	Ljava/util/Set;
    //   16: aload_0
    //   17: new 49	java/util/LinkedHashSet
    //   20: dup
    //   21: iconst_1
    //   22: invokespecial 52	java/util/LinkedHashSet:<init>	(I)V
    //   25: putfield 56	com/airbnb/lottie/m:c	Ljava/util/Set;
    //   28: aload_0
    //   29: new 58	android/os/Handler
    //   32: dup
    //   33: invokestatic 64	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   36: invokespecial 67	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   39: putfield 69	com/airbnb/lottie/m:d	Landroid/os/Handler;
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 71	com/airbnb/lottie/m:e	Lcom/airbnb/lottie/l;
    //   47: iload_2
    //   48: ifeq +35 -> 83
    //   51: aload_0
    //   52: aload_1
    //   53: invokeinterface 77 1 0
    //   58: checkcast 79	com/airbnb/lottie/l
    //   61: invokespecial 83	com/airbnb/lottie/m:l	(Lcom/airbnb/lottie/l;)V
    //   64: goto +36 -> 100
    //   67: astore_1
    //   68: aload_0
    //   69: new 79	com/airbnb/lottie/l
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 86	com/airbnb/lottie/l:<init>	(Ljava/lang/Throwable;)V
    //   77: invokespecial 83	com/airbnb/lottie/m:l	(Lcom/airbnb/lottie/l;)V
    //   80: goto +20 -> 100
    //   83: getstatic 32	com/airbnb/lottie/m:a	Ljava/util/concurrent/Executor;
    //   86: new 9	com/airbnb/lottie/m$b
    //   89: dup
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 89	com/airbnb/lottie/m$b:<init>	(Lcom/airbnb/lottie/m;Ljava/util/concurrent/Callable;)V
    //   95: invokeinterface 95 2 0
    //   100: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	m
    //   0	101	1	paramCallable	Callable<l<T>>
    //   0	101	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   51	64	67	finally
  }
  
  private void g(Throwable paramThrowable)
  {
    try
    {
      Object localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>(this.c);
      if (((List)localObject).isEmpty())
      {
        d.d("Lottie encountered an error but no failure listener was added:", paramThrowable);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).a(paramThrowable);
      }
      return;
    }
    finally {}
  }
  
  private void h()
  {
    this.d.post(new a());
  }
  
  private void i(T paramT)
  {
    try
    {
      Object localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>(this.b);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).a(paramT);
      }
      return;
    }
    finally {}
  }
  
  private void l(@Nullable l<T> paraml)
  {
    if (this.e == null)
    {
      this.e = paraml;
      h();
      return;
    }
    throw new IllegalStateException("A task may only be set once.");
  }
  
  public m<T> e(h<Throwable> paramh)
  {
    try
    {
      if ((this.e != null) && (this.e.a() != null)) {
        paramh.a(this.e.a());
      }
      this.c.add(paramh);
      return this;
    }
    finally {}
  }
  
  public m<T> f(h<T> paramh)
  {
    try
    {
      if ((this.e != null) && (this.e.b() != null)) {
        paramh.a(this.e.b());
      }
      this.b.add(paramh);
      return this;
    }
    finally {}
  }
  
  public m<T> j(h<Throwable> paramh)
  {
    try
    {
      this.c.remove(paramh);
      return this;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public m<T> k(h<T> paramh)
  {
    try
    {
      this.b.remove(paramh);
      return this;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (m.a(m.this) == null) {
        return;
      }
      l locall = m.a(m.this);
      if (locall.b() != null) {
        m.b(m.this, locall.b());
      } else {
        m.c(m.this, locall.a());
      }
    }
  }
  
  private class b
    extends FutureTask<l<T>>
  {
    b()
    {
      super();
    }
    
    protected void done()
    {
      if (isCancelled()) {
        return;
      }
      try
      {
        m.d(m.this, (l)get());
      }
      catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
      m.d(m.this, new l(localInterruptedException));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */