package com.google.common.collect;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

class z<K, V>
  extends x<K, V>
{
  @MonotonicNonNullDecl
  transient long[] H3;
  private transient int I3;
  private transient int J3;
  private final boolean K3;
  
  z()
  {
    this(3);
  }
  
  z(int paramInt)
  {
    this(paramInt, 1.0F, false);
  }
  
  z(int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat);
    this.K3 = paramBoolean;
  }
  
  public static <K, V> z<K, V> G()
  {
    return new z();
  }
  
  public static <K, V> z<K, V> H(int paramInt)
  {
    return new z(paramInt);
  }
  
  private int I(int paramInt)
  {
    return (int)(this.H3[paramInt] >>> 32);
  }
  
  private void J(int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = this.H3;
    arrayOfLong[paramInt1] = (arrayOfLong[paramInt1] & 0xFFFFFFFF | paramInt2 << 32);
  }
  
  private void K(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -2) {
      this.I3 = paramInt2;
    } else {
      L(paramInt1, paramInt2);
    }
    if (paramInt2 == -2) {
      this.J3 = paramInt1;
    } else {
      J(paramInt2, paramInt1);
    }
  }
  
  private void L(int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = this.H3;
    arrayOfLong[paramInt1] = (arrayOfLong[paramInt1] & 0xFFFFFFFF00000000 | paramInt2 & 0xFFFFFFFF);
  }
  
  void B(int paramInt)
  {
    super.B(paramInt);
    this.H3 = Arrays.copyOf(this.H3, paramInt);
  }
  
  public void clear()
  {
    super.clear();
    this.I3 = -2;
    this.J3 = -2;
  }
  
  void f(int paramInt)
  {
    if (this.K3)
    {
      K(I(paramInt), q(paramInt));
      K(this.J3, paramInt);
      K(paramInt, -2);
      this.y += 1;
    }
  }
  
  int g(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 >= size()) {
      i = paramInt2;
    }
    return i;
  }
  
  int n()
  {
    return this.I3;
  }
  
  int q(int paramInt)
  {
    return (int)this.H3[paramInt];
  }
  
  void t(int paramInt, float paramFloat)
  {
    super.t(paramInt, paramFloat);
    this.I3 = -2;
    this.J3 = -2;
    long[] arrayOfLong = new long[paramInt];
    this.H3 = arrayOfLong;
    Arrays.fill(arrayOfLong, -1L);
  }
  
  void u(int paramInt1, K paramK, V paramV, int paramInt2)
  {
    super.u(paramInt1, paramK, paramV, paramInt2);
    K(this.J3, paramInt1);
    K(paramInt1, -2);
  }
  
  void w(int paramInt)
  {
    int i = size() - 1;
    K(I(paramInt), q(paramInt));
    if (paramInt < i)
    {
      K(I(i), paramInt);
      K(paramInt, q(i));
    }
    super.w(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */