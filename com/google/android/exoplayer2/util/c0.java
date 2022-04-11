package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;

public final class c0
{
  public byte[] a;
  private int b;
  private int c;
  private int d;
  
  public c0()
  {
    this.a = o0.f;
  }
  
  public c0(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public c0(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.d = paramInt;
  }
  
  private void a()
  {
    int i = this.b;
    if (i >= 0)
    {
      int j = this.d;
      if ((i < j) || ((i == j) && (this.c == 0)))
      {
        bool = true;
        break label38;
      }
    }
    boolean bool = false;
    label38:
    g.g(bool);
  }
  
  public int b()
  {
    return (this.d - this.b) * 8 - this.c;
  }
  
  public void c()
  {
    if (this.c == 0) {
      return;
    }
    this.c = 0;
    this.b += 1;
    a();
  }
  
  public int d()
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    return this.b;
  }
  
  public int e()
  {
    return this.b * 8 + this.c;
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 < 32) {
      i = paramInt1 & (1 << paramInt2) - 1;
    }
    int j = Math.min(8 - this.c, paramInt2);
    int k = this.c;
    int m = 8 - k - j;
    byte[] arrayOfByte = this.a;
    paramInt1 = this.b;
    arrayOfByte[paramInt1] = ((byte)(byte)((65280 >> k | (1 << m) - 1) & arrayOfByte[paramInt1]));
    k = paramInt2 - j;
    arrayOfByte[paramInt1] = ((byte)(byte)(i >>> k << m | arrayOfByte[paramInt1]));
    paramInt1++;
    while (k > 8)
    {
      this.a[paramInt1] = ((byte)(byte)(i >>> k - 8));
      k -= 8;
      paramInt1++;
    }
    m = 8 - k;
    arrayOfByte = this.a;
    arrayOfByte[paramInt1] = ((byte)(byte)(arrayOfByte[paramInt1] & (1 << m) - 1));
    arrayOfByte[paramInt1] = ((byte)(byte)((i & (1 << k) - 1) << m | arrayOfByte[paramInt1]));
    r(paramInt2);
    a();
  }
  
  public boolean g()
  {
    boolean bool;
    if ((this.a[this.b] & 128 >> this.c) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    q();
    return bool;
  }
  
  public int h(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    this.c += paramInt;
    int i = 0;
    int j;
    for (;;)
    {
      j = this.c;
      if (j <= 8) {
        break;
      }
      k = j - 8;
      this.c = k;
      arrayOfByte = this.a;
      j = this.b;
      this.b = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << k;
    }
    byte[] arrayOfByte = this.a;
    int m = this.b;
    int k = arrayOfByte[m];
    if (j == 8)
    {
      this.c = 0;
      this.b = (m + 1);
    }
    a();
    return -1 >>> 32 - paramInt & (i | (k & 0xFF) >> 8 - j);
  }
  
  public void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = (paramInt2 >> 3) + paramInt1;
    while (paramInt1 < i)
    {
      arrayOfByte = this.a;
      j = this.b;
      k = j + 1;
      this.b = k;
      m = arrayOfByte[j];
      j = this.c;
      paramArrayOfByte[paramInt1] = ((byte)(byte)(m << j));
      m = paramArrayOfByte[paramInt1];
      paramArrayOfByte[paramInt1] = ((byte)(byte)((0xFF & arrayOfByte[k]) >> 8 - j | m));
      paramInt1++;
    }
    paramInt1 = paramInt2 & 0x7;
    if (paramInt1 == 0) {
      return;
    }
    paramArrayOfByte[i] = ((byte)(byte)(paramArrayOfByte[i] & 255 >> paramInt1));
    int k = this.c;
    if (k + paramInt1 > 8)
    {
      paramInt2 = paramArrayOfByte[i];
      arrayOfByte = this.a;
      j = this.b;
      this.b = (j + 1);
      paramArrayOfByte[i] = ((byte)(byte)(paramInt2 | (arrayOfByte[j] & 0xFF) << k));
      this.c = (k - 8);
    }
    int j = this.c + paramInt1;
    this.c = j;
    byte[] arrayOfByte = this.a;
    int m = this.b;
    k = arrayOfByte[m];
    paramInt2 = paramArrayOfByte[i];
    paramArrayOfByte[i] = ((byte)(byte)((byte)((0xFF & k) >> 8 - j << 8 - paramInt1) | paramInt2));
    if (j == 8)
    {
      this.c = 0;
      this.b = (m + 1);
    }
    a();
  }
  
  public long j(int paramInt)
  {
    if (paramInt <= 32) {
      return o0.L0(h(paramInt));
    }
    return o0.K0(h(paramInt - 32), h(32));
  }
  
  public void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
    a();
  }
  
  public String l(int paramInt, Charset paramCharset)
  {
    byte[] arrayOfByte = new byte[paramInt];
    k(arrayOfByte, 0, paramInt);
    return new String(arrayOfByte, paramCharset);
  }
  
  public void m(d0 paramd0)
  {
    o(paramd0.d(), paramd0.f());
    p(paramd0.e() * 8);
  }
  
  public void n(byte[] paramArrayOfByte)
  {
    o(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void o(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = 0;
    this.d = paramInt;
  }
  
  public void p(int paramInt)
  {
    int i = paramInt / 8;
    this.b = i;
    this.c = (paramInt - i * 8);
    a();
  }
  
  public void q()
  {
    int i = this.c + 1;
    this.c = i;
    if (i == 8)
    {
      this.c = 0;
      this.b += 1;
    }
    a();
  }
  
  public void r(int paramInt)
  {
    int i = paramInt / 8;
    int j = this.b + i;
    this.b = j;
    paramInt = this.c + (paramInt - i * 8);
    this.c = paramInt;
    if (paramInt > 7)
    {
      this.b = (j + 1);
      this.c = (paramInt - 8);
    }
    a();
  }
  
  public void s(int paramInt)
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.b += paramInt;
    a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */