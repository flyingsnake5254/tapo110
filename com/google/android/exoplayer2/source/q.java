package com.google.android.exoplayer2.source;

public class q
  implements o0
{
  protected final o0[] c;
  
  public q(o0[] paramArrayOfo0)
  {
    this.c = paramArrayOfo0;
  }
  
  public final long a()
  {
    o0[] arrayOfo0 = this.c;
    int i = arrayOfo0.length;
    int j = 0;
    for (long l1 = Long.MAX_VALUE; j < i; l1 = l3)
    {
      long l2 = arrayOfo0[j].a();
      l3 = l1;
      if (l2 != Long.MIN_VALUE) {
        l3 = Math.min(l1, l2);
      }
      j++;
    }
    long l3 = l1;
    if (l1 == Long.MAX_VALUE) {
      l3 = Long.MIN_VALUE;
    }
    return l3;
  }
  
  public boolean c()
  {
    o0[] arrayOfo0 = this.c;
    int i = arrayOfo0.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfo0[j].c()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d(long paramLong)
  {
    boolean bool1 = false;
    boolean bool2;
    boolean bool4;
    do
    {
      long l1 = a();
      if (l1 == Long.MIN_VALUE) {
        break;
      }
      o0[] arrayOfo0 = this.c;
      int i = arrayOfo0.length;
      int j = 0;
      boolean bool3;
      for (bool2 = false; j < i; bool2 = bool3)
      {
        o0 localo0 = arrayOfo0[j];
        long l2 = localo0.a();
        int k;
        if ((l2 != Long.MIN_VALUE) && (l2 <= paramLong)) {
          k = 1;
        } else {
          k = 0;
        }
        if (l2 != l1)
        {
          bool3 = bool2;
          if (k == 0) {}
        }
        else
        {
          bool3 = bool2 | localo0.d(paramLong);
        }
        j++;
      }
      bool4 = bool1 | bool2;
      bool1 = bool4;
    } while (bool2);
    bool1 = bool4;
    return bool1;
  }
  
  public final long e()
  {
    o0[] arrayOfo0 = this.c;
    int i = arrayOfo0.length;
    int j = 0;
    for (long l1 = Long.MAX_VALUE; j < i; l1 = l3)
    {
      long l2 = arrayOfo0[j].e();
      l3 = l1;
      if (l2 != Long.MIN_VALUE) {
        l3 = Math.min(l1, l2);
      }
      j++;
    }
    long l3 = l1;
    if (l1 == Long.MAX_VALUE) {
      l3 = Long.MIN_VALUE;
    }
    return l3;
  }
  
  public final void f(long paramLong)
  {
    o0[] arrayOfo0 = this.c;
    int i = arrayOfo0.length;
    for (int j = 0; j < i; j++) {
      arrayOfo0[j].f(paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */