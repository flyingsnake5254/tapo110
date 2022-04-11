package com.google.android.exoplayer2.source.u0;

import java.util.NoSuchElementException;

public abstract class a
  implements e
{
  private final long b;
  private final long c;
  private long d;
  
  public a(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    f();
  }
  
  protected final void c()
  {
    long l = this.d;
    if ((l >= this.b) && (l <= this.c)) {
      return;
    }
    throw new NoSuchElementException();
  }
  
  protected final long d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    boolean bool;
    if (this.d > this.c) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void f()
  {
    this.d = (this.b - 1L);
  }
  
  public boolean next()
  {
    this.d += 1L;
    return e() ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\u0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */