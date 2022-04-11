package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.util.o0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract interface v
{
  @Deprecated
  public abstract void A(int paramInt, @Nullable e0.a parama);
  
  public abstract void Q(int paramInt, @Nullable e0.a parama, Exception paramException);
  
  public abstract void a0(int paramInt, @Nullable e0.a parama);
  
  public abstract void f0(int paramInt1, @Nullable e0.a parama, int paramInt2);
  
  public abstract void g0(int paramInt, @Nullable e0.a parama);
  
  public abstract void l0(int paramInt, @Nullable e0.a parama);
  
  public abstract void y(int paramInt, @Nullable e0.a parama);
  
  public static class a
  {
    public final int a;
    @Nullable
    public final e0.a b;
    private final CopyOnWriteArrayList<a> c;
    
    public a()
    {
      this(new CopyOnWriteArrayList(), 0, null);
    }
    
    private a(CopyOnWriteArrayList<a> paramCopyOnWriteArrayList, int paramInt, @Nullable e0.a parama)
    {
      this.c = paramCopyOnWriteArrayList;
      this.a = paramInt;
      this.b = parama;
    }
    
    public void a(Handler paramHandler, v paramv)
    {
      com.google.android.exoplayer2.util.g.e(paramHandler);
      com.google.android.exoplayer2.util.g.e(paramv);
      this.c.add(new a(paramHandler, paramv));
    }
    
    public void b()
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        v localv = locala.b;
        o0.z0(locala.a, new i(this, localv));
      }
    }
    
    public void c()
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        v localv = locala.b;
        o0.z0(locala.a, new h(this, localv));
      }
    }
    
    public void d()
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        v localv = locala.b;
        o0.z0(locala.a, new j(this, localv));
      }
    }
    
    public void e(int paramInt)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        v localv = locala.b;
        o0.z0(locala.a, new l(this, localv, paramInt));
      }
    }
    
    public void f(Exception paramException)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        v localv = locala.b;
        o0.z0(locala.a, new k(this, localv, paramException));
      }
    }
    
    public void g()
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        v localv = locala.b;
        o0.z0(locala.a, new g(this, localv));
      }
    }
    
    public void t(v paramv)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.b == paramv) {
          this.c.remove(locala);
        }
      }
    }
    
    @CheckResult
    public a u(int paramInt, @Nullable e0.a parama)
    {
      return new a(this.c, paramInt, parama);
    }
    
    private static final class a
    {
      public Handler a;
      public v b;
      
      public a(Handler paramHandler, v paramv)
      {
        this.a = paramHandler;
        this.b = paramv;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */