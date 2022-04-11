package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import java.io.IOException;

public final class o
  implements b0, b0.a
{
  public final b0 c;
  @Nullable
  private b0.a d;
  private a[] f;
  private long q;
  long x;
  long y;
  
  public o(b0 paramb0, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.c = paramb0;
    this.f = new a[0];
    long l;
    if (paramBoolean) {
      l = paramLong1;
    } else {
      l = -9223372036854775807L;
    }
    this.q = l;
    this.x = paramLong1;
    this.y = paramLong2;
  }
  
  private g2 g(long paramLong, g2 paramg2)
  {
    long l1 = o0.q(paramg2.f, 0L, paramLong - this.x);
    long l2 = paramg2.g;
    long l3 = this.y;
    if (l3 == Long.MIN_VALUE) {
      paramLong = Long.MAX_VALUE;
    } else {
      paramLong = l3 - paramLong;
    }
    paramLong = o0.q(l2, 0L, paramLong);
    if ((l1 == paramg2.f) && (paramLong == paramg2.g)) {
      return paramg2;
    }
    return new g2(l1, paramLong);
  }
  
  private static boolean t(long paramLong, com.google.android.exoplayer2.trackselection.g[] paramArrayOfg)
  {
    if (paramLong != 0L)
    {
      int i = paramArrayOfg.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject = paramArrayOfg[j];
        if (localObject != null)
        {
          localObject = ((com.google.android.exoplayer2.trackselection.g)localObject).s();
          if (!y.a(((Format)localObject).H3, ((Format)localObject).p1)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public long a()
  {
    long l1 = this.c.a();
    if (l1 != Long.MIN_VALUE)
    {
      long l2 = this.y;
      if ((l2 == Long.MIN_VALUE) || (l1 < l2)) {
        return l1;
      }
    }
    return Long.MIN_VALUE;
  }
  
  public boolean c()
  {
    return this.c.c();
  }
  
  public boolean d(long paramLong)
  {
    return this.c.d(paramLong);
  }
  
  public long e()
  {
    long l1 = this.c.e();
    if (l1 != Long.MIN_VALUE)
    {
      long l2 = this.y;
      if ((l2 == Long.MIN_VALUE) || (l1 < l2)) {
        return l1;
      }
    }
    return Long.MIN_VALUE;
  }
  
  public void f(long paramLong)
  {
    this.c.f(paramLong);
  }
  
  boolean h()
  {
    boolean bool;
    if (this.q != -9223372036854775807L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public long i(long paramLong)
  {
    this.q = -9223372036854775807L;
    a[] arrayOfa = this.f;
    int i = arrayOfa.length;
    boolean bool1 = false;
    for (int j = 0; j < i; j++)
    {
      a locala = arrayOfa[j];
      if (locala != null) {
        locala.d();
      }
    }
    long l = this.c.i(paramLong);
    if (l != paramLong)
    {
      bool2 = bool1;
      if (l < this.x) {
        break label111;
      }
      paramLong = this.y;
      if (paramLong != Long.MIN_VALUE)
      {
        bool2 = bool1;
        if (l > paramLong) {
          break label111;
        }
      }
    }
    boolean bool2 = true;
    label111:
    com.google.android.exoplayer2.util.g.g(bool2);
    return l;
  }
  
  public long j(long paramLong, g2 paramg2)
  {
    long l = this.x;
    if (paramLong == l) {
      return l;
    }
    paramg2 = g(paramLong, paramg2);
    return this.c.j(paramLong, paramg2);
  }
  
  public long k()
  {
    if (h())
    {
      l1 = this.q;
      this.q = -9223372036854775807L;
      l2 = k();
      if (l2 != -9223372036854775807L) {
        l1 = l2;
      }
      return l1;
    }
    long l1 = this.c.k();
    if (l1 == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    long l2 = this.x;
    boolean bool1 = true;
    if (l1 >= l2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.util.g.g(bool2);
    l2 = this.y;
    boolean bool2 = bool1;
    if (l2 != Long.MIN_VALUE) {
      if (l1 <= l2) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    com.google.android.exoplayer2.util.g.g(bool2);
    return l1;
  }
  
  public void l(b0.a parama, long paramLong)
  {
    this.d = parama;
    this.c.l(this, paramLong);
  }
  
  public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    this.f = new a[paramArrayOfn0.length];
    n0[] arrayOfn0 = new n0[paramArrayOfn0.length];
    int i = 0;
    for (int j = 0;; j++)
    {
      int k = paramArrayOfn0.length;
      n0 localn0 = null;
      if (j >= k) {
        break;
      }
      a[] arrayOfa = this.f;
      arrayOfa[j] = ((a)paramArrayOfn0[j]);
      if (arrayOfa[j] != null) {
        localn0 = arrayOfa[j].a;
      }
      arrayOfn0[j] = localn0;
    }
    long l1 = this.c.m(paramArrayOfg, paramArrayOfBoolean1, arrayOfn0, paramArrayOfBoolean2, paramLong);
    if (h())
    {
      l2 = this.x;
      if ((paramLong == l2) && (t(l2, paramArrayOfg)))
      {
        l2 = l1;
        break label146;
      }
    }
    long l2 = -9223372036854775807L;
    label146:
    this.q = l2;
    if (l1 != paramLong) {
      if (l1 >= this.x)
      {
        paramLong = this.y;
        if ((paramLong == Long.MIN_VALUE) || (l1 <= paramLong)) {}
      }
      else
      {
        bool = false;
        break label205;
      }
    }
    boolean bool = true;
    label205:
    com.google.android.exoplayer2.util.g.g(bool);
    for (j = i; j < paramArrayOfn0.length; j++)
    {
      if (arrayOfn0[j] == null)
      {
        this.f[j] = null;
      }
      else
      {
        paramArrayOfg = this.f;
        if ((paramArrayOfg[j] == null) || (paramArrayOfg[j].a != arrayOfn0[j])) {
          paramArrayOfg[j] = new a(arrayOfn0[j]);
        }
      }
      paramArrayOfn0[j] = this.f[j];
    }
    return l1;
  }
  
  public void p(b0 paramb0)
  {
    ((b0.a)com.google.android.exoplayer2.util.g.e(this.d)).p(this);
  }
  
  public void q()
    throws IOException
  {
    this.c.q();
  }
  
  public void r(b0 paramb0)
  {
    ((b0.a)com.google.android.exoplayer2.util.g.e(this.d)).n(this);
  }
  
  public TrackGroupArray s()
  {
    return this.c.s();
  }
  
  public void u(long paramLong, boolean paramBoolean)
  {
    this.c.u(paramLong, paramBoolean);
  }
  
  public void v(long paramLong1, long paramLong2)
  {
    this.x = paramLong1;
    this.y = paramLong2;
  }
  
  private final class a
    implements n0
  {
    public final n0 a;
    private boolean b;
    
    public a(n0 paramn0)
    {
      this.a = paramn0;
    }
    
    public void a()
      throws IOException
    {
      this.a.a();
    }
    
    public int b(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
    {
      if (o.this.h()) {
        return -3;
      }
      if (this.b)
      {
        paramDecoderInputBuffer.m(4);
        return -4;
      }
      paramInt = this.a.b(parami1, paramDecoderInputBuffer, paramInt);
      if (paramInt == -5)
      {
        Format localFormat = (Format)com.google.android.exoplayer2.util.g.e(parami1.b);
        paramInt = localFormat.X3;
        if ((paramInt != 0) || (localFormat.Y3 != 0))
        {
          paramDecoderInputBuffer = o.this;
          l = paramDecoderInputBuffer.x;
          int i = 0;
          if (l != 0L) {
            paramInt = 0;
          }
          if (paramDecoderInputBuffer.y == Long.MIN_VALUE) {
            i = localFormat.Y3;
          }
          parami1.b = localFormat.a().M(paramInt).N(i).E();
        }
        return -5;
      }
      parami1 = o.this;
      long l = parami1.y;
      if ((l != Long.MIN_VALUE) && (((paramInt == -4) && (paramDecoderInputBuffer.x >= l)) || ((paramInt == -3) && (parami1.e() == Long.MIN_VALUE) && (!paramDecoderInputBuffer.q))))
      {
        paramDecoderInputBuffer.f();
        paramDecoderInputBuffer.m(4);
        this.b = true;
        return -4;
      }
      return paramInt;
    }
    
    public int c(long paramLong)
    {
      if (o.this.h()) {
        return -3;
      }
      return this.a.c(paramLong);
    }
    
    public void d()
    {
      this.b = false;
    }
    
    public boolean g()
    {
      boolean bool;
      if ((!o.this.h()) && (this.a.g())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */