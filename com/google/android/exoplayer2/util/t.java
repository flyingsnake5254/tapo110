package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nonnull;

public final class t<T>
{
  private final h a;
  private final r b;
  private final b<T> c;
  private final CopyOnWriteArraySet<c<T>> d;
  private final ArrayDeque<Runnable> e;
  private final ArrayDeque<Runnable> f;
  private boolean g;
  
  public t(Looper paramLooper, h paramh, b<T> paramb)
  {
    this(new CopyOnWriteArraySet(), paramLooper, paramh, paramb);
  }
  
  private t(CopyOnWriteArraySet<c<T>> paramCopyOnWriteArraySet, Looper paramLooper, h paramh, b<T> paramb)
  {
    this.a = paramh;
    this.d = paramCopyOnWriteArraySet;
    this.c = paramb;
    this.e = new ArrayDeque();
    this.f = new ArrayDeque();
    this.b = paramh.b(paramLooper, new b(this));
  }
  
  private boolean d(Message paramMessage)
  {
    paramMessage = this.d.iterator();
    do
    {
      if (!paramMessage.hasNext()) {
        break;
      }
      ((c)paramMessage.next()).b(this.c);
    } while (!this.b.c(0));
    return true;
  }
  
  public void a(T paramT)
  {
    if (this.g) {
      return;
    }
    g.e(paramT);
    this.d.add(new c(paramT));
  }
  
  @CheckResult
  public t<T> b(Looper paramLooper, b<T> paramb)
  {
    return new t(this.d, paramLooper, this.a, paramb);
  }
  
  public void c()
  {
    if (this.f.isEmpty()) {
      return;
    }
    if (!this.b.c(0))
    {
      r localr = this.b;
      localr.b(localr.a(0));
    }
    boolean bool = this.e.isEmpty();
    this.e.addAll(this.f);
    this.f.clear();
    if ((bool ^ true)) {
      return;
    }
    while (!this.e.isEmpty())
    {
      ((Runnable)this.e.peekFirst()).run();
      this.e.removeFirst();
    }
  }
  
  public void g(int paramInt, a<T> parama)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = new CopyOnWriteArraySet(this.d);
    this.f.add(new a(localCopyOnWriteArraySet, paramInt, parama));
  }
  
  public void h()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).c(this.c);
    }
    this.d.clear();
    this.g = true;
  }
  
  public void i(T paramT)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.a.equals(paramT))
      {
        localc.c(this.c);
        this.d.remove(localc);
      }
    }
  }
  
  public void j(int paramInt, a<T> parama)
  {
    g(paramInt, parama);
    c();
  }
  
  public static abstract interface a<T>
  {
    public abstract void invoke(T paramT);
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(T paramT, p paramp);
  }
  
  private static final class c<T>
  {
    @Nonnull
    public final T a;
    private p.b b;
    private boolean c;
    private boolean d;
    
    public c(@Nonnull T paramT)
    {
      this.a = paramT;
      this.b = new p.b();
    }
    
    public void a(int paramInt, t.a<T> parama)
    {
      if (!this.d)
      {
        if (paramInt != -1) {
          this.b.a(paramInt);
        }
        this.c = true;
        parama.invoke(this.a);
      }
    }
    
    public void b(t.b<T> paramb)
    {
      if ((!this.d) && (this.c))
      {
        p localp = this.b.e();
        this.b = new p.b();
        this.c = false;
        paramb.a(this.a, localp);
      }
    }
    
    public void c(t.b<T> paramb)
    {
      this.d = true;
      if (this.c) {
        paramb.a(this.a, this.b.e());
      }
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (c.class == paramObject.getClass())) {
        return this.a.equals(((c)paramObject).a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */