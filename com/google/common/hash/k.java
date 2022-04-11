package com.google.common.hash;

import java.io.Serializable;

final class k
  extends n
  implements Serializable, i
{
  public long a()
  {
    long l1 = this.p0;
    n.b[] arrayOfb = this.z;
    long l2 = l1;
    if (arrayOfb != null)
    {
      int i = arrayOfb.length;
      int j = 0;
      for (;;)
      {
        l2 = l1;
        if (j >= i) {
          break;
        }
        n.b localb = arrayOfb[j];
        l2 = l1;
        if (localb != null) {
          l2 = l1 + localb.c;
        }
        j++;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public void add(long paramLong)
  {
    Object localObject = this.z;
    long l;
    if (localObject == null)
    {
      l = this.p0;
      if (d(l, l + paramLong)) {}
    }
    else
    {
      int[] arrayOfInt = (int[])n.c.get();
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (arrayOfInt != null)
      {
        bool2 = bool1;
        if (localObject != null)
        {
          int i = localObject.length;
          bool2 = bool1;
          if (i >= 1)
          {
            localObject = localObject[(i - 1 & arrayOfInt[0])];
            bool2 = bool1;
            if (localObject != null)
            {
              l = ((n.b)localObject).c;
              bool2 = ((n.b)localObject).a(l, l + paramLong);
              if (bool2) {
                return;
              }
            }
          }
        }
      }
      i(paramLong, arrayOfInt, bool2);
    }
  }
  
  public double doubleValue()
  {
    return a();
  }
  
  public float floatValue()
  {
    return (float)a();
  }
  
  final long g(long paramLong1, long paramLong2)
  {
    return paramLong1 + paramLong2;
  }
  
  public void increment()
  {
    add(1L);
  }
  
  public int intValue()
  {
    return (int)a();
  }
  
  public long longValue()
  {
    return a();
  }
  
  public String toString()
  {
    return Long.toString(a());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */