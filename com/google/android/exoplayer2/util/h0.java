package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.w0;

public final class h0
  implements w
{
  private final h c;
  private boolean d;
  private long f;
  private long q;
  private t1 x;
  
  public h0(h paramh)
  {
    this.c = paramh;
    this.x = t1.a;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
    if (this.d) {
      this.q = this.c.elapsedRealtime();
    }
  }
  
  public void b()
  {
    if (!this.d)
    {
      this.q = this.c.elapsedRealtime();
      this.d = true;
    }
  }
  
  public t1 c()
  {
    return this.x;
  }
  
  public void d()
  {
    if (this.d)
    {
      a(p());
      this.d = false;
    }
  }
  
  public void e(t1 paramt1)
  {
    if (this.d) {
      a(p());
    }
    this.x = paramt1;
  }
  
  public long p()
  {
    long l1 = this.f;
    long l2 = l1;
    if (this.d)
    {
      l2 = this.c.elapsedRealtime() - this.q;
      t1 localt1 = this.x;
      if (localt1.c == 1.0F) {
        l2 = w0.d(l2);
      } else {
        l2 = localt1.a(l2);
      }
      l2 = l1 + l2;
    }
    return l2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */