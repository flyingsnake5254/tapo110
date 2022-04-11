package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class r
  implements y
{
  private final s a;
  private final long b;
  
  public r(s params, long paramLong)
  {
    this.a = params;
    this.b = paramLong;
  }
  
  private z b(long paramLong1, long paramLong2)
  {
    return new z(paramLong1 * 1000000L / this.a.e, this.b + paramLong2);
  }
  
  public y.a a(long paramLong)
  {
    g.i(this.a.k);
    Object localObject1 = this.a;
    Object localObject2 = ((s)localObject1).k;
    long[] arrayOfLong = ((s.a)localObject2).a;
    localObject2 = ((s.a)localObject2).b;
    int i = o0.h(arrayOfLong, ((s)localObject1).j(paramLong), true, false);
    long l1 = 0L;
    long l2;
    if (i == -1) {
      l2 = 0L;
    } else {
      l2 = arrayOfLong[i];
    }
    if (i != -1) {
      l1 = localObject2[i];
    }
    localObject1 = b(l2, l1);
    if ((((z)localObject1).b != paramLong) && (i != arrayOfLong.length - 1))
    {
      i++;
      return new y.a((z)localObject1, b(arrayOfLong[i], localObject2[i]));
    }
    return new y.a((z)localObject1);
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long i()
  {
    return this.a.g();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */