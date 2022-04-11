package com.google.common.collect;

import java.util.Arrays;

class z1<K>
  extends y1<K>
{
  transient long[] i;
  private transient int j;
  private transient int k;
  
  z1(int paramInt)
  {
    this(paramInt, 1.0F);
  }
  
  z1(int paramInt, float paramFloat)
  {
    super(paramInt, paramFloat);
  }
  
  private int E(int paramInt)
  {
    return (int)(this.i[paramInt] >>> 32);
  }
  
  private int F(int paramInt)
  {
    return (int)this.i[paramInt];
  }
  
  private void G(int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = this.i;
    arrayOfLong[paramInt1] = (arrayOfLong[paramInt1] & 0xFFFFFFFF | paramInt2 << 32);
  }
  
  private void H(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -2) {
      this.j = paramInt2;
    } else {
      I(paramInt1, paramInt2);
    }
    if (paramInt2 == -2) {
      this.k = paramInt1;
    } else {
      G(paramInt2, paramInt1);
    }
  }
  
  private void I(int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = this.i;
    arrayOfLong[paramInt1] = (arrayOfLong[paramInt1] & 0xFFFFFFFF00000000 | paramInt2 & 0xFFFFFFFF);
  }
  
  public void a()
  {
    super.a();
    this.j = -2;
    this.k = -2;
  }
  
  int e()
  {
    int m = this.j;
    int n = m;
    if (m == -2) {
      n = -1;
    }
    return n;
  }
  
  void n(int paramInt, float paramFloat)
  {
    super.n(paramInt, paramFloat);
    this.j = -2;
    this.k = -2;
    long[] arrayOfLong = new long[paramInt];
    this.i = arrayOfLong;
    Arrays.fill(arrayOfLong, -1L);
  }
  
  void o(int paramInt1, K paramK, int paramInt2, int paramInt3)
  {
    super.o(paramInt1, paramK, paramInt2, paramInt3);
    H(this.k, paramInt1);
    H(paramInt1, -2);
  }
  
  void p(int paramInt)
  {
    int m = C() - 1;
    H(E(paramInt), F(paramInt));
    if (paramInt < m)
    {
      H(E(m), paramInt);
      H(paramInt, F(m));
    }
    super.p(paramInt);
  }
  
  int s(int paramInt)
  {
    int m = F(paramInt);
    paramInt = m;
    if (m == -2) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  int t(int paramInt1, int paramInt2)
  {
    int m = paramInt1;
    if (paramInt1 == C()) {
      m = paramInt2;
    }
    return m;
  }
  
  void y(int paramInt)
  {
    super.y(paramInt);
    long[] arrayOfLong = this.i;
    int m = arrayOfLong.length;
    arrayOfLong = Arrays.copyOf(arrayOfLong, paramInt);
    this.i = arrayOfLong;
    Arrays.fill(arrayOfLong, m, paramInt, -1L);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\z1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */