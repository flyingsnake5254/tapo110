package com.google.android.exoplayer2.o2.g0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.t;
import com.google.android.exoplayer2.util.g;

final class c
  extends t
{
  private final long c;
  
  public c(k paramk, long paramLong)
  {
    super(paramk);
    boolean bool;
    if (paramk.getPosition() >= paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.c = paramLong;
  }
  
  public long a()
  {
    return super.a() - this.c;
  }
  
  public long g()
  {
    return super.g() - this.c;
  }
  
  public long getPosition()
  {
    return super.getPosition() - this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\g0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */