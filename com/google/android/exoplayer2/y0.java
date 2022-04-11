package com.google.android.exoplayer2;

@Deprecated
public class y0
  implements x0
{
  private final long a = -9223372036854775807L;
  private final long b = -9223372036854775807L;
  private final boolean c = false;
  
  private static void o(u1 paramu1, long paramLong)
  {
    long l1 = paramu1.V() + paramLong;
    long l2 = paramu1.v();
    paramLong = l1;
    if (l2 != -9223372036854775807L) {
      paramLong = Math.min(l1, l2);
    }
    paramu1.seekTo(Math.max(paramLong, 0L));
  }
  
  public boolean a(u1 paramu1, t1 paramt1)
  {
    paramu1.e(paramt1);
    return true;
  }
  
  public boolean b(u1 paramu1)
  {
    if (!this.c) {
      paramu1.T();
    } else if ((g()) && (paramu1.h())) {
      o(paramu1, -this.a);
    }
    return true;
  }
  
  public boolean c(u1 paramu1, int paramInt, long paramLong)
  {
    paramu1.B(paramInt, paramLong);
    return true;
  }
  
  public boolean d(u1 paramu1, boolean paramBoolean)
  {
    paramu1.F(paramBoolean);
    return true;
  }
  
  public boolean e(u1 paramu1, int paramInt)
  {
    paramu1.setRepeatMode(paramInt);
    return true;
  }
  
  public boolean f(u1 paramu1)
  {
    if (!this.c) {
      paramu1.S();
    } else if ((k()) && (paramu1.h())) {
      o(paramu1, this.b);
    }
    return true;
  }
  
  public boolean g()
  {
    boolean bool;
    if ((this.c) && (this.a <= 0L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean h(u1 paramu1)
  {
    paramu1.prepare();
    return true;
  }
  
  public boolean i(u1 paramu1)
  {
    paramu1.n();
    return true;
  }
  
  public boolean j(u1 paramu1)
  {
    paramu1.y();
    return true;
  }
  
  public boolean k()
  {
    boolean bool;
    if ((this.c) && (this.b <= 0L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean l(u1 paramu1, boolean paramBoolean)
  {
    paramu1.p(paramBoolean);
    return true;
  }
  
  public long m(u1 paramu1)
  {
    long l;
    if (this.c) {
      l = this.b;
    } else {
      l = paramu1.L();
    }
    return l;
  }
  
  public long n(u1 paramu1)
  {
    long l;
    if (this.c) {
      l = this.a;
    } else {
      l = paramu1.W();
    }
    return l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\y0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */