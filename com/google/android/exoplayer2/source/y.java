package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

public final class y
  implements b0, b0.a
{
  public final e0.a c;
  private final long d;
  private final e f;
  private boolean p0;
  private long p1;
  private e0 q;
  private b0 x;
  @Nullable
  private b0.a y;
  @Nullable
  private a z;
  
  public y(e0.a parama, e parame, long paramLong)
  {
    this.c = parama;
    this.f = parame;
    this.d = paramLong;
    this.p1 = -9223372036854775807L;
  }
  
  private long t(long paramLong)
  {
    long l = this.p1;
    if (l != -9223372036854775807L) {
      paramLong = l;
    }
    return paramLong;
  }
  
  public long a()
  {
    return ((b0)o0.i(this.x)).a();
  }
  
  public boolean c()
  {
    b0 localb0 = this.x;
    boolean bool;
    if ((localb0 != null) && (localb0.c())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean d(long paramLong)
  {
    b0 localb0 = this.x;
    boolean bool;
    if ((localb0 != null) && (localb0.d(paramLong))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public long e()
  {
    return ((b0)o0.i(this.x)).e();
  }
  
  public void f(long paramLong)
  {
    ((b0)o0.i(this.x)).f(paramLong);
  }
  
  public void g(e0.a parama)
  {
    long l = t(this.d);
    parama = ((e0)com.google.android.exoplayer2.util.g.e(this.q)).a(parama, this.f, l);
    this.x = parama;
    if (this.y != null) {
      parama.l(this, l);
    }
  }
  
  public long h()
  {
    return this.p1;
  }
  
  public long i(long paramLong)
  {
    return ((b0)o0.i(this.x)).i(paramLong);
  }
  
  public long j(long paramLong, g2 paramg2)
  {
    return ((b0)o0.i(this.x)).j(paramLong, paramg2);
  }
  
  public long k()
  {
    return ((b0)o0.i(this.x)).k();
  }
  
  public void l(b0.a parama, long paramLong)
  {
    this.y = parama;
    parama = this.x;
    if (parama != null) {
      parama.l(this, t(this.d));
    }
  }
  
  public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    long l = this.p1;
    if ((l != -9223372036854775807L) && (paramLong == this.d))
    {
      this.p1 = -9223372036854775807L;
      paramLong = l;
    }
    return ((b0)o0.i(this.x)).m(paramArrayOfg, paramArrayOfBoolean1, paramArrayOfn0, paramArrayOfBoolean2, paramLong);
  }
  
  public void p(b0 paramb0)
  {
    ((b0.a)o0.i(this.y)).p(this);
    paramb0 = this.z;
    if (paramb0 != null) {
      paramb0.a(this.c);
    }
  }
  
  public void q()
    throws IOException
  {
    Object localObject;
    try
    {
      localObject = this.x;
      if (localObject != null)
      {
        ((b0)localObject).q();
      }
      else
      {
        localObject = this.q;
        if (localObject != null) {
          ((e0)localObject).n();
        }
      }
    }
    catch (IOException localIOException)
    {
      localObject = this.z;
      if (localObject == null) {
        break label70;
      }
    }
    if (!this.p0)
    {
      this.p0 = true;
      ((a)localObject).b(this.c, localIOException);
    }
    return;
    label70:
    throw localIOException;
  }
  
  public long r()
  {
    return this.d;
  }
  
  public TrackGroupArray s()
  {
    return ((b0)o0.i(this.x)).s();
  }
  
  public void u(long paramLong, boolean paramBoolean)
  {
    ((b0)o0.i(this.x)).u(paramLong, paramBoolean);
  }
  
  public void v(b0 paramb0)
  {
    ((b0.a)o0.i(this.y)).n(this);
  }
  
  public void w(long paramLong)
  {
    this.p1 = paramLong;
  }
  
  public void x()
  {
    if (this.x != null) {
      ((e0)com.google.android.exoplayer2.util.g.e(this.q)).g(this.x);
    }
  }
  
  public void y(e0 parame0)
  {
    boolean bool;
    if (this.q == null) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    this.q = parame0;
  }
  
  public void z(a parama)
  {
    this.z = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(e0.a parama);
    
    public abstract void b(e0.a parama, IOException paramIOException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */