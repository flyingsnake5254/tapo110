package com.google.android.exoplayer2.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;

public abstract class g<I extends DecoderInputBuffer, O extends f, E extends DecoderException>
  implements c<I, O, E>
{
  private final Thread a;
  private final Object b = new Object();
  private final ArrayDeque<I> c = new ArrayDeque();
  private final ArrayDeque<O> d = new ArrayDeque();
  private final I[] e;
  private final O[] f;
  private int g;
  private int h;
  private I i;
  private E j;
  private boolean k;
  private boolean l;
  private int m;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.e = paramArrayOfI;
    this.g = paramArrayOfI.length;
    int n = 0;
    for (int i1 = 0; i1 < this.g; i1++) {
      this.e[i1] = g();
    }
    this.f = paramArrayOfO;
    this.h = paramArrayOfO.length;
    for (i1 = n; i1 < this.h; i1++) {
      this.f[i1] = h();
    }
    paramArrayOfI = new a("ExoPlayer:SimpleDecoder");
    this.a = paramArrayOfI;
    paramArrayOfI.start();
  }
  
  private boolean f()
  {
    boolean bool;
    if ((!this.c.isEmpty()) && (this.h > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean k()
    throws InterruptedException
  {
    synchronized (this.b)
    {
      while ((!this.l) && (!f())) {
        this.b.wait();
      }
      if (this.l) {
        return false;
      }
      ??? = (DecoderInputBuffer)this.c.removeFirst();
      Object localObject7 = this.f;
      int n = this.h - 1;
      this.h = n;
      localObject7 = localObject7[n];
      boolean bool = this.k;
      this.k = false;
      if (((a)???).k())
      {
        ((a)localObject7).e(4);
      }
      else
      {
        if (((a)???).j()) {
          ((a)localObject7).e(Integer.MIN_VALUE);
        }
        DecoderException localDecoderException2;
        try
        {
          ??? = j((DecoderInputBuffer)???, (f)localObject7, bool);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          DecoderException localDecoderException1 = i(localOutOfMemoryError);
        }
        catch (RuntimeException localRuntimeException)
        {
          localDecoderException2 = i(localRuntimeException);
        }
        if (localDecoderException2 != null) {
          synchronized (this.b)
          {
            this.j = localDecoderException2;
            return false;
          }
        }
      }
      synchronized (this.b)
      {
        if (this.k)
        {
          ((f)localObject7).n();
        }
        else if (((a)localObject7).j())
        {
          this.m += 1;
          ((f)localObject7).n();
        }
        else
        {
          ((f)localObject7).f = this.m;
          this.m = 0;
          this.d.addLast(localObject7);
        }
        q((DecoderInputBuffer)???);
        return true;
      }
    }
  }
  
  private void n()
  {
    if (f()) {
      this.b.notify();
    }
  }
  
  private void o()
    throws DecoderException
  {
    DecoderException localDecoderException = this.j;
    if (localDecoderException == null) {
      return;
    }
    throw localDecoderException;
  }
  
  private void q(I paramI)
  {
    paramI.f();
    DecoderInputBuffer[] arrayOfDecoderInputBuffer = this.e;
    int n = this.g;
    this.g = (n + 1);
    arrayOfDecoderInputBuffer[n] = paramI;
  }
  
  private void s(O paramO)
  {
    paramO.f();
    f[] arrayOff = this.f;
    int n = this.h;
    this.h = (n + 1);
    arrayOff[n] = paramO;
  }
  
  private void t()
  {
    try
    {
      boolean bool;
      do
      {
        bool = k();
      } while (bool);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException(localInterruptedException);
    }
  }
  
  public final void flush()
  {
    synchronized (this.b)
    {
      this.k = true;
      this.m = 0;
      DecoderInputBuffer localDecoderInputBuffer = this.i;
      if (localDecoderInputBuffer != null)
      {
        q(localDecoderInputBuffer);
        this.i = null;
      }
      while (!this.c.isEmpty()) {
        q((DecoderInputBuffer)this.c.removeFirst());
      }
      while (!this.d.isEmpty()) {
        ((f)this.d.removeFirst()).n();
      }
      return;
    }
  }
  
  protected abstract I g();
  
  protected abstract O h();
  
  protected abstract E i(Throwable paramThrowable);
  
  @Nullable
  protected abstract E j(I paramI, O paramO, boolean paramBoolean);
  
  @Nullable
  public final I l()
    throws DecoderException
  {
    synchronized (this.b)
    {
      o();
      boolean bool;
      if (this.i == null) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.g(bool);
      int n = this.g;
      Object localObject2;
      if (n == 0)
      {
        localObject2 = null;
      }
      else
      {
        localObject2 = this.e;
        n--;
        this.g = n;
        localObject2 = localObject2[n];
      }
      this.i = ((DecoderInputBuffer)localObject2);
      return (I)localObject2;
    }
  }
  
  @Nullable
  public final O m()
    throws DecoderException
  {
    synchronized (this.b)
    {
      o();
      if (this.d.isEmpty()) {
        return null;
      }
      f localf = (f)this.d.removeFirst();
      return localf;
    }
  }
  
  public final void p(I paramI)
    throws DecoderException
  {
    synchronized (this.b)
    {
      o();
      boolean bool;
      if (paramI == this.i) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.a(bool);
      this.c.addLast(paramI);
      n();
      this.i = null;
      return;
    }
  }
  
  @CallSuper
  protected void r(O paramO)
  {
    synchronized (this.b)
    {
      s(paramO);
      n();
      return;
    }
  }
  
  @CallSuper
  public void release()
  {
    synchronized (this.b)
    {
      this.l = true;
      this.b.notify();
      try
      {
        this.a.join();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  protected final void u(int paramInt)
  {
    int n = this.g;
    int i1 = this.e.length;
    int i2 = 0;
    boolean bool;
    if (n == i1) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    DecoderInputBuffer[] arrayOfDecoderInputBuffer = this.e;
    n = arrayOfDecoderInputBuffer.length;
    while (i2 < n)
    {
      arrayOfDecoderInputBuffer[i2].o(paramInt);
      i2++;
    }
  }
  
  class a
    extends Thread
  {
    a(String paramString)
    {
      super();
    }
    
    public void run()
    {
      g.e(g.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */