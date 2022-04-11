package com.google.common.collect;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

class a0<E>
  extends y<E>
{
  @MonotonicNonNullDecl
  private transient int[] p0;
  @MonotonicNonNullDecl
  private transient int[] p1;
  private transient int p2;
  private transient int p3;
  
  a0(int paramInt)
  {
    super(paramInt);
  }
  
  public static <E> a0<E> x(int paramInt)
  {
    return new a0(paramInt);
  }
  
  private void y(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -2) {
      this.p2 = paramInt2;
    } else {
      this.p1[paramInt1] = paramInt2;
    }
    if (paramInt2 == -2) {
      this.p3 = paramInt1;
    } else {
      this.p0[paramInt2] = paramInt1;
    }
  }
  
  public void clear()
  {
    super.clear();
    this.p2 = -2;
    this.p3 = -2;
    Arrays.fill(this.p0, -1);
    Arrays.fill(this.p1, -1);
  }
  
  int f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 == size()) {
      i = paramInt2;
    }
    return i;
  }
  
  int i()
  {
    return this.p2;
  }
  
  int l(int paramInt)
  {
    return this.p1[paramInt];
  }
  
  void n(int paramInt, float paramFloat)
  {
    super.n(paramInt, paramFloat);
    int[] arrayOfInt = new int[paramInt];
    this.p0 = arrayOfInt;
    this.p1 = new int[paramInt];
    Arrays.fill(arrayOfInt, -1);
    Arrays.fill(this.p1, -1);
    this.p2 = -2;
    this.p3 = -2;
  }
  
  void o(int paramInt1, E paramE, int paramInt2)
  {
    super.o(paramInt1, paramE, paramInt2);
    y(this.p3, paramInt1);
    y(paramInt1, -2);
  }
  
  void p(int paramInt)
  {
    int i = size() - 1;
    super.p(paramInt);
    y(this.p0[paramInt], this.p1[paramInt]);
    if (i != paramInt)
    {
      y(this.p0[i], paramInt);
      y(paramInt, this.p1[i]);
    }
    this.p0[i] = -1;
    this.p1[i] = -1;
  }
  
  void t(int paramInt)
  {
    super.t(paramInt);
    int[] arrayOfInt = this.p0;
    int i = arrayOfInt.length;
    this.p0 = Arrays.copyOf(arrayOfInt, paramInt);
    this.p1 = Arrays.copyOf(this.p1, paramInt);
    if (i < paramInt)
    {
      Arrays.fill(this.p0, i, paramInt, -1);
      Arrays.fill(this.p1, i, paramInt, -1);
    }
  }
  
  public Object[] toArray()
  {
    return x1.f(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return x1.g(this, paramArrayOfT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */