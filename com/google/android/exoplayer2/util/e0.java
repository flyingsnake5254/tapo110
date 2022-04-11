package com.google.android.exoplayer2.util;

public final class e0
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  
  public e0(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    i(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void a()
  {
    int i = this.c;
    if (i >= 0)
    {
      int j = this.b;
      if ((i < j) || ((i == j) && (this.d == 0)))
      {
        bool = true;
        break label38;
      }
    }
    boolean bool = false;
    label38:
    g.g(bool);
  }
  
  private int f()
  {
    int i = 0;
    for (int j = 0; !d(); j++) {}
    if (j > 0) {
      i = e(j);
    }
    return (1 << j) - 1 + i;
  }
  
  private boolean j(int paramInt)
  {
    boolean bool = true;
    if ((2 <= paramInt) && (paramInt < this.b))
    {
      byte[] arrayOfByte = this.a;
      if ((arrayOfByte[paramInt] == 3) && (arrayOfByte[(paramInt - 2)] == 0) && (arrayOfByte[(paramInt - 1)] == 0)) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    int i = this.c;
    int j = paramInt / 8;
    int k = i + j;
    int m = this.d + paramInt - j * 8;
    paramInt = k;
    j = m;
    if (m > 7)
    {
      paramInt = k + 1;
      j = m - 8;
    }
    boolean bool1 = true;
    k = paramInt;
    paramInt = i;
    for (;;)
    {
      i = paramInt + 1;
      if ((i > k) || (k >= this.b)) {
        break;
      }
      paramInt = i;
      if (j(i))
      {
        k++;
        paramInt = i + 2;
      }
    }
    paramInt = this.b;
    boolean bool2 = bool1;
    if (k >= paramInt) {
      if ((k == paramInt) && (j == 0)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public boolean c()
  {
    int i = this.c;
    int j = this.d;
    boolean bool1 = false;
    for (int k = 0; (this.c < this.b) && (!d()); k++) {}
    int m;
    if (this.c == this.b) {
      m = 1;
    } else {
      m = 0;
    }
    this.c = i;
    this.d = j;
    boolean bool2 = bool1;
    if (m == 0)
    {
      bool2 = bool1;
      if (b(k * 2 + 1)) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean d()
  {
    boolean bool;
    if ((this.a[this.c] & 128 >> this.d) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    k();
    return bool;
  }
  
  public int e(int paramInt)
  {
    this.d += paramInt;
    int i = 0;
    int j;
    int k;
    for (;;)
    {
      j = this.d;
      k = 2;
      if (j <= 8) {
        break;
      }
      m = j - 8;
      this.d = m;
      arrayOfByte = this.a;
      j = this.c;
      i |= (arrayOfByte[j] & 0xFF) << m;
      if (!j(j + 1)) {
        k = 1;
      }
      this.c = (j + k);
    }
    byte[] arrayOfByte = this.a;
    int m = this.c;
    int n = arrayOfByte[m];
    if (j == 8)
    {
      this.d = 0;
      if (!j(m + 1)) {
        k = 1;
      }
      this.c = (m + k);
    }
    a();
    return -1 >>> 32 - paramInt & (i | (n & 0xFF) >> 8 - j);
  }
  
  public int g()
  {
    int i = f();
    int j;
    if (i % 2 == 0) {
      j = -1;
    } else {
      j = 1;
    }
    return j * ((i + 1) / 2);
  }
  
  public int h()
  {
    return f();
  }
  
  public void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = 0;
    a();
  }
  
  public void k()
  {
    int i = this.d;
    int j = 1;
    i++;
    this.d = i;
    if (i == 8)
    {
      this.d = 0;
      i = this.c;
      if (j(i + 1)) {
        j = 2;
      }
      this.c = (i + j);
    }
    a();
  }
  
  public void l(int paramInt)
  {
    int i = this.c;
    int j = paramInt / 8;
    int k = i + j;
    this.c = k;
    j = this.d + (paramInt - j * 8);
    this.d = j;
    paramInt = i;
    if (j > 7)
    {
      this.c = (k + 1);
      this.d = (j - 8);
      paramInt = i;
    }
    for (;;)
    {
      i = paramInt + 1;
      if (i > this.c) {
        break;
      }
      paramInt = i;
      if (j(i))
      {
        this.c += 1;
        paramInt = i + 2;
      }
    }
    a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */