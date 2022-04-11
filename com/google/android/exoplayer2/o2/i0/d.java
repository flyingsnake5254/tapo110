package com.google.android.exoplayer2.o2.i0;

import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.v;

final class d
  implements g
{
  private final long a;
  private final v b;
  private final v c;
  private long d;
  
  public d(long paramLong1, long paramLong2, long paramLong3)
  {
    this.d = paramLong1;
    this.a = paramLong3;
    v localv1 = new v();
    this.b = localv1;
    v localv2 = new v();
    this.c = localv2;
    localv1.a(0L);
    localv2.a(paramLong2);
  }
  
  public y.a a(long paramLong)
  {
    int i = o0.e(this.b, paramLong, true, true);
    z localz = new z(this.b.b(i), this.c.b(i));
    if ((localz.b != paramLong) && (i != this.b.c() - 1))
    {
      v localv = this.b;
      i++;
      return new y.a(localz, new z(localv.b(i), this.c.b(i)));
    }
    return new y.a(localz);
  }
  
  public boolean b(long paramLong)
  {
    v localv = this.b;
    int i = localv.c();
    boolean bool = true;
    if (paramLong - localv.b(i - 1) >= 100000L) {
      bool = false;
    }
    return bool;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if (b(paramLong1)) {
      return;
    }
    this.b.a(paramLong1);
    this.c.a(paramLong2);
  }
  
  void d(long paramLong)
  {
    this.d = paramLong;
  }
  
  public long f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long h(long paramLong)
  {
    int i = o0.e(this.c, paramLong, true, true);
    return this.b.b(i);
  }
  
  public long i()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\i0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */