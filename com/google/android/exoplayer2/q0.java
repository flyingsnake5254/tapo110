package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.util.g;

public abstract class q0
  extends j2
{
  private final int c;
  private final p0 d;
  private final boolean e;
  
  public q0(boolean paramBoolean, p0 paramp0)
  {
    this.e = paramBoolean;
    this.d = paramp0;
    this.c = paramp0.a();
  }
  
  private int B(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = this.d.d(paramInt);
    } else if (paramInt < this.c - 1) {
      paramInt++;
    } else {
      paramInt = -1;
    }
    return paramInt;
  }
  
  private int C(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = this.d.c(paramInt);
    } else if (paramInt > 0) {
      paramInt--;
    } else {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public static Object v(Object paramObject)
  {
    return ((Pair)paramObject).second;
  }
  
  public static Object w(Object paramObject)
  {
    return ((Pair)paramObject).first;
  }
  
  public static Object y(Object paramObject1, Object paramObject2)
  {
    return Pair.create(paramObject1, paramObject2);
  }
  
  protected abstract int A(int paramInt);
  
  protected abstract j2 D(int paramInt);
  
  public int a(boolean paramBoolean)
  {
    if (this.c == 0) {
      return -1;
    }
    boolean bool = this.e;
    int i = 0;
    if (bool) {
      paramBoolean = false;
    }
    if (paramBoolean) {
      i = this.d.g();
    }
    while (D(i).q())
    {
      int j = B(i, paramBoolean);
      i = j;
      if (j == -1) {
        return -1;
      }
    }
    return A(i) + D(i).a(paramBoolean);
  }
  
  public final int b(Object paramObject)
  {
    boolean bool = paramObject instanceof Pair;
    int i = -1;
    if (!bool) {
      return -1;
    }
    Object localObject = w(paramObject);
    paramObject = v(paramObject);
    int j = s(localObject);
    if (j == -1) {
      return -1;
    }
    int k = D(j).b(paramObject);
    if (k != -1) {
      i = z(j) + k;
    }
    return i;
  }
  
  public int c(boolean paramBoolean)
  {
    int i = this.c;
    if (i == 0) {
      return -1;
    }
    if (this.e) {
      paramBoolean = false;
    }
    if (paramBoolean) {
      i = this.d.e();
    } else {
      i--;
    }
    while (D(i).q())
    {
      int j = C(i, paramBoolean);
      i = j;
      if (j == -1) {
        return -1;
      }
    }
    return A(i) + D(i).c(paramBoolean);
  }
  
  public int e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = this.e;
    int i = 0;
    int j = paramInt2;
    if (bool)
    {
      j = paramInt2;
      if (paramInt2 == 1) {
        j = 2;
      }
      paramBoolean = false;
    }
    int k = u(paramInt1);
    int m = A(k);
    j2 localj2 = D(k);
    if (j == 2) {
      paramInt2 = i;
    } else {
      paramInt2 = j;
    }
    paramInt1 = localj2.e(paramInt1 - m, paramInt2, paramBoolean);
    if (paramInt1 != -1) {
      return m + paramInt1;
    }
    for (paramInt1 = B(k, paramBoolean); (paramInt1 != -1) && (D(paramInt1).q()); paramInt1 = B(paramInt1, paramBoolean)) {}
    if (paramInt1 != -1) {
      return A(paramInt1) + D(paramInt1).a(paramBoolean);
    }
    if (j == 2) {
      return a(paramBoolean);
    }
    return -1;
  }
  
  public final j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
  {
    int i = t(paramInt);
    int j = A(i);
    int k = z(i);
    D(i).g(paramInt - k, paramb, paramBoolean);
    paramb.d += j;
    if (paramBoolean) {
      paramb.c = y(x(i), g.e(paramb.c));
    }
    return paramb;
  }
  
  public final j2.b h(Object paramObject, j2.b paramb)
  {
    Object localObject1 = w(paramObject);
    Object localObject2 = v(paramObject);
    int i = s(localObject1);
    int j = A(i);
    D(i).h(localObject2, paramb);
    paramb.d += j;
    paramb.c = paramObject;
    return paramb;
  }
  
  public int l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = this.e;
    int i = 0;
    int j = paramInt2;
    if (bool)
    {
      j = paramInt2;
      if (paramInt2 == 1) {
        j = 2;
      }
      paramBoolean = false;
    }
    int k = u(paramInt1);
    int m = A(k);
    j2 localj2 = D(k);
    if (j == 2) {
      paramInt2 = i;
    } else {
      paramInt2 = j;
    }
    paramInt1 = localj2.l(paramInt1 - m, paramInt2, paramBoolean);
    if (paramInt1 != -1) {
      return m + paramInt1;
    }
    for (paramInt1 = C(k, paramBoolean); (paramInt1 != -1) && (D(paramInt1).q()); paramInt1 = C(paramInt1, paramBoolean)) {}
    if (paramInt1 != -1) {
      return A(paramInt1) + D(paramInt1).c(paramBoolean);
    }
    if (j == 2) {
      return c(paramBoolean);
    }
    return -1;
  }
  
  public final Object m(int paramInt)
  {
    int i = t(paramInt);
    int j = z(i);
    Object localObject = D(i).m(paramInt - j);
    return y(x(i), localObject);
  }
  
  public final j2.c o(int paramInt, j2.c paramc, long paramLong)
  {
    int i = u(paramInt);
    int j = A(i);
    int k = z(i);
    D(i).o(paramInt - j, paramc, paramLong);
    Object localObject = x(i);
    if (!j2.c.a.equals(paramc.e)) {
      localObject = y(localObject, paramc.e);
    }
    paramc.e = localObject;
    paramc.s += k;
    paramc.t += k;
    return paramc;
  }
  
  protected abstract int s(Object paramObject);
  
  protected abstract int t(int paramInt);
  
  protected abstract int u(int paramInt);
  
  protected abstract Object x(int paramInt);
  
  protected abstract int z(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */