package kotlin.v;

import kotlin.jvm.internal.j;

class g
  extends f
{
  public static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static long c(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 < paramLong2) {
      l = paramLong2;
    }
    return l;
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static long e(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 > paramLong2) {
      l = paramLong2;
    }
    return l;
  }
  
  public static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt3)
    {
      if (paramInt1 < paramInt2) {
        return paramInt2;
      }
      if (paramInt1 > paramInt3) {
        return paramInt3;
      }
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append('.');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static b g(int paramInt1, int paramInt2)
  {
    return b.c.a(paramInt1, paramInt2, -1);
  }
  
  public static b h(b paramb, int paramInt)
  {
    j.e(paramb, "$this$step");
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    f.a(bool, Integer.valueOf(paramInt));
    b.a locala = b.c;
    int i = paramb.a();
    int j = paramb.b();
    if (paramb.c() <= 0) {
      paramInt = -paramInt;
    }
    return locala.a(i, j, paramInt);
  }
  
  public static d i(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= Integer.MIN_VALUE) {
      return d.y.a();
    }
    return new d(paramInt1, paramInt2 - 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\v\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */