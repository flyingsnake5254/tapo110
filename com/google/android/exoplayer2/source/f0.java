package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract interface f0
{
  public abstract void N(int paramInt, e0.a parama, a0 parama0);
  
  public abstract void e0(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0);
  
  public abstract void i0(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0, IOException paramIOException, boolean paramBoolean);
  
  public abstract void l(int paramInt, @Nullable e0.a parama, a0 parama0);
  
  public abstract void m(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0);
  
  public abstract void p(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0);
  
  public static class a
  {
    public final int a;
    @Nullable
    public final e0.a b;
    private final CopyOnWriteArrayList<a> c;
    private final long d;
    
    public a()
    {
      this(new CopyOnWriteArrayList(), 0, null, 0L);
    }
    
    private a(CopyOnWriteArrayList<a> paramCopyOnWriteArrayList, int paramInt, @Nullable e0.a parama, long paramLong)
    {
      this.c = paramCopyOnWriteArrayList;
      this.a = paramInt;
      this.b = parama;
      this.d = paramLong;
    }
    
    private long b(long paramLong)
    {
      long l = w0.e(paramLong);
      paramLong = -9223372036854775807L;
      if (l != -9223372036854775807L) {
        paramLong = this.d + l;
      }
      return paramLong;
    }
    
    public void A(x paramx, int paramInt1, int paramInt2, @Nullable Format paramFormat, int paramInt3, @Nullable Object paramObject, long paramLong1, long paramLong2)
    {
      B(paramx, new a0(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, b(paramLong1), b(paramLong2)));
    }
    
    public void B(x paramx, a0 parama0)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f0 localf0 = locala.b;
        o0.z0(locala.a, new f(this, localf0, paramx, parama0));
      }
    }
    
    public void C(f0 paramf0)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.b == paramf0) {
          this.c.remove(locala);
        }
      }
    }
    
    public void D(int paramInt, long paramLong1, long paramLong2)
    {
      E(new a0(1, paramInt, null, 3, null, b(paramLong1), b(paramLong2)));
    }
    
    public void E(a0 parama0)
    {
      e0.a locala = (e0.a)com.google.android.exoplayer2.util.g.e(this.b);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala1 = (a)localIterator.next();
        f0 localf0 = locala1.b;
        o0.z0(locala1.a, new b(this, localf0, locala, parama0));
      }
    }
    
    @CheckResult
    public a F(int paramInt, @Nullable e0.a parama, long paramLong)
    {
      return new a(this.c, paramInt, parama, paramLong);
    }
    
    public void a(Handler paramHandler, f0 paramf0)
    {
      com.google.android.exoplayer2.util.g.e(paramHandler);
      com.google.android.exoplayer2.util.g.e(paramf0);
      this.c.add(new a(paramHandler, paramf0));
    }
    
    public void c(int paramInt1, @Nullable Format paramFormat, int paramInt2, @Nullable Object paramObject, long paramLong)
    {
      d(new a0(1, paramInt1, paramFormat, paramInt2, paramObject, b(paramLong), -9223372036854775807L));
    }
    
    public void d(a0 parama0)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f0 localf0 = locala.b;
        o0.z0(locala.a, new e(this, localf0, parama0));
      }
    }
    
    public void q(x paramx, int paramInt)
    {
      r(paramx, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
    
    public void r(x paramx, int paramInt1, int paramInt2, @Nullable Format paramFormat, int paramInt3, @Nullable Object paramObject, long paramLong1, long paramLong2)
    {
      s(paramx, new a0(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, b(paramLong1), b(paramLong2)));
    }
    
    public void s(x paramx, a0 parama0)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f0 localf0 = locala.b;
        o0.z0(locala.a, new g(this, localf0, paramx, parama0));
      }
    }
    
    public void t(x paramx, int paramInt)
    {
      u(paramx, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
    
    public void u(x paramx, int paramInt1, int paramInt2, @Nullable Format paramFormat, int paramInt3, @Nullable Object paramObject, long paramLong1, long paramLong2)
    {
      v(paramx, new a0(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, b(paramLong1), b(paramLong2)));
    }
    
    public void v(x paramx, a0 parama0)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f0 localf0 = locala.b;
        o0.z0(locala.a, new d(this, localf0, paramx, parama0));
      }
    }
    
    public void w(x paramx, int paramInt1, int paramInt2, @Nullable Format paramFormat, int paramInt3, @Nullable Object paramObject, long paramLong1, long paramLong2, IOException paramIOException, boolean paramBoolean)
    {
      y(paramx, new a0(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, b(paramLong1), b(paramLong2)), paramIOException, paramBoolean);
    }
    
    public void x(x paramx, int paramInt, IOException paramIOException, boolean paramBoolean)
    {
      w(paramx, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramIOException, paramBoolean);
    }
    
    public void y(x paramx, a0 parama0, IOException paramIOException, boolean paramBoolean)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f0 localf0 = locala.b;
        o0.z0(locala.a, new c(this, localf0, paramx, parama0, paramIOException, paramBoolean));
      }
    }
    
    public void z(x paramx, int paramInt)
    {
      A(paramx, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
    
    private static final class a
    {
      public Handler a;
      public f0 b;
      
      public a(Handler paramHandler, f0 paramf0)
      {
        this.a = paramHandler;
        this.b = paramf0;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */