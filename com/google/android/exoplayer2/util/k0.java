package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class k0<V>
{
  private long[] a;
  private V[] b;
  private int c;
  private int d;
  
  public k0()
  {
    this(10);
  }
  
  public k0(int paramInt)
  {
    this.a = new long[paramInt];
    this.b = f(paramInt);
  }
  
  private void b(long paramLong, V paramV)
  {
    int i = this.c;
    int j = this.d;
    Object[] arrayOfObject = this.b;
    i = (i + j) % arrayOfObject.length;
    this.a[i] = paramLong;
    arrayOfObject[i] = paramV;
    this.d = (j + 1);
  }
  
  private void d(long paramLong)
  {
    int i = this.d;
    if (i > 0)
    {
      int j = this.c;
      int k = this.b.length;
      if (paramLong <= this.a[((j + i - 1) % k)]) {
        c();
      }
    }
  }
  
  private void e()
  {
    int i = this.b.length;
    if (this.d < i) {
      return;
    }
    int j = i * 2;
    long[] arrayOfLong = new long[j];
    Object[] arrayOfObject = f(j);
    j = this.c;
    i -= j;
    System.arraycopy(this.a, j, arrayOfLong, 0, i);
    System.arraycopy(this.b, this.c, arrayOfObject, 0, i);
    j = this.c;
    if (j > 0)
    {
      System.arraycopy(this.a, 0, arrayOfLong, i, j);
      System.arraycopy(this.b, 0, arrayOfObject, i, this.c);
    }
    this.a = arrayOfLong;
    this.b = arrayOfObject;
    this.c = 0;
  }
  
  private static <V> V[] f(int paramInt)
  {
    return new Object[paramInt];
  }
  
  @Nullable
  private V h(long paramLong, boolean paramBoolean)
  {
    Object localObject = null;
    long l2;
    for (long l1 = Long.MAX_VALUE; this.d > 0; l1 = l2)
    {
      l2 = paramLong - this.a[this.c];
      if ((l2 < 0L) && ((paramBoolean) || (-l2 >= l1))) {
        break;
      }
      localObject = k();
    }
    return (V)localObject;
  }
  
  @Nullable
  private V k()
  {
    boolean bool;
    if (this.d > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    Object[] arrayOfObject = this.b;
    int i = this.c;
    Object localObject = arrayOfObject[i];
    arrayOfObject[i] = null;
    this.c = ((i + 1) % arrayOfObject.length);
    this.d -= 1;
    return (V)localObject;
  }
  
  public void a(long paramLong, V paramV)
  {
    try
    {
      d(paramLong);
      e();
      b(paramLong, paramV);
      return;
    }
    finally
    {
      paramV = finally;
      throw paramV;
    }
  }
  
  public void c()
  {
    try
    {
      this.c = 0;
      this.d = 0;
      Arrays.fill(this.b, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public V g(long paramLong)
  {
    try
    {
      Object localObject1 = h(paramLong, false);
      return (V)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  @Nullable
  public V i()
  {
    try
    {
      Object localObject1;
      if (this.d == 0) {
        localObject1 = null;
      } else {
        localObject1 = k();
      }
      return (V)localObject1;
    }
    finally {}
  }
  
  @Nullable
  public V j(long paramLong)
  {
    try
    {
      Object localObject1 = h(paramLong, true);
      return (V)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public int l()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */