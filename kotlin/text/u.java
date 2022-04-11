package kotlin.text;

import kotlin.jvm.internal.j;

class u
  extends t
{
  public static Integer k(String paramString)
  {
    j.e(paramString, "$this$toIntOrNull");
    return l(paramString, 10);
  }
  
  public static final Integer l(String paramString, int paramInt)
  {
    j.e(paramString, "$this$toIntOrNull");
    a.a(paramInt);
    int i = paramString.length();
    if (i == 0) {
      return null;
    }
    int j = 0;
    int k = paramString.charAt(0);
    int m = j.g(k, 48);
    int n = -2147483647;
    int i1 = 1;
    if (m < 0)
    {
      if (i == 1) {
        return null;
      }
      if (k == 45)
      {
        n = Integer.MIN_VALUE;
        k = 1;
      }
      else if (k == 43)
      {
        k = 0;
      }
      else
      {
        return null;
      }
    }
    else
    {
      k = 0;
      i1 = 0;
    }
    int i2 = -59652323;
    m = i1;
    while (m < i)
    {
      int i3 = b.b(paramString.charAt(m), paramInt);
      if (i3 < 0) {
        return null;
      }
      i1 = i2;
      if (j < i2) {
        if (i2 == -59652323)
        {
          i2 = n / paramInt;
          i1 = i2;
          if (j >= i2) {}
        }
        else
        {
          return null;
        }
      }
      i2 = j * paramInt;
      if (i2 < n + i3) {
        return null;
      }
      j = i2 - i3;
      m++;
      i2 = i1;
    }
    if (k != 0) {
      paramString = Integer.valueOf(j);
    } else {
      paramString = Integer.valueOf(-j);
    }
    return paramString;
  }
  
  public static Long m(String paramString)
  {
    j.e(paramString, "$this$toLongOrNull");
    return n(paramString, 10);
  }
  
  public static final Long n(String paramString, int paramInt)
  {
    j.e(paramString, "$this$toLongOrNull");
    a.a(paramInt);
    int i = paramString.length();
    if (i == 0) {
      return null;
    }
    int j = 0;
    int k = paramString.charAt(0);
    int m = j.g(k, 48);
    long l1 = -9223372036854775807L;
    int n = 1;
    if (m < 0)
    {
      if (i == 1) {
        return null;
      }
      if (k == 45)
      {
        l1 = Long.MIN_VALUE;
        j = 1;
        break label94;
      }
      if (k == 43) {
        j = 1;
      } else {
        return null;
      }
    }
    n = 0;
    label94:
    long l2 = 0L;
    long l4;
    for (long l3 = -256204778801521550L; j < i; l3 = l4)
    {
      m = b.b(paramString.charAt(j), paramInt);
      if (m < 0) {
        return null;
      }
      l4 = l3;
      if (l2 < l3) {
        if (l3 == -256204778801521550L)
        {
          l3 = l1 / paramInt;
          l4 = l3;
          if (l2 >= l3) {}
        }
        else
        {
          return null;
        }
      }
      l3 = l2 * paramInt;
      l2 = m;
      if (l3 < l1 + l2) {
        return null;
      }
      l2 = l3 - l2;
      j++;
    }
    if (n != 0) {
      paramString = Long.valueOf(l2);
    } else {
      paramString = Long.valueOf(-l2);
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */