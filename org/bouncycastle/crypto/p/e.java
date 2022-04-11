package org.bouncycastle.crypto.p;

import org.bouncycastle.util.f;

public class e
  extends a
{
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int[] i = new int[80];
  private int j;
  
  public e()
  {
    reset();
  }
  
  public e(e parame)
  {
    super(parame);
    s(parame);
  }
  
  private void s(e parame)
  {
    this.d = parame.d;
    this.e = parame.e;
    this.f = parame.f;
    this.g = parame.g;
    this.h = parame.h;
    int[] arrayOfInt = parame.i;
    System.arraycopy(arrayOfInt, 0, this.i, 0, arrayOfInt.length);
    this.j = parame.j;
  }
  
  private int t(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 ^ 0xFFFFFFFF) & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int u(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  private int v(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  public String b()
  {
    return "SHA-1";
  }
  
  public org.bouncycastle.util.e copy()
  {
    return new e(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    o();
    f.d(this.d, paramArrayOfByte, paramInt);
    f.d(this.e, paramArrayOfByte, paramInt + 4);
    f.d(this.f, paramArrayOfByte, paramInt + 8);
    f.d(this.g, paramArrayOfByte, paramInt + 12);
    f.d(this.h, paramArrayOfByte, paramInt + 16);
    reset();
    return 20;
  }
  
  public int e()
  {
    return 20;
  }
  
  public void m(org.bouncycastle.util.e parame)
  {
    parame = (e)parame;
    super.n(parame);
    s(parame);
  }
  
  protected void p()
  {
    int[] arrayOfInt;
    for (int k = 16; k < 80; k++)
    {
      arrayOfInt = this.i;
      m = arrayOfInt[(k - 3)] ^ arrayOfInt[(k - 8)] ^ arrayOfInt[(k - 14)] ^ arrayOfInt[(k - 16)];
      arrayOfInt[k] = (m >>> 31 | m << 1);
    }
    int m = this.d;
    int n = this.e;
    k = this.f;
    int i1 = this.g;
    int i2 = this.h;
    int i3 = 0;
    int i5;
    for (int i4 = 0; i3 < 4; i4++)
    {
      i5 = t(n, k, i1);
      arrayOfInt = this.i;
      i6 = i4 + 1;
      i2 += (m << 5 | m >>> 27) + i5 + arrayOfInt[i4] + 1518500249;
      n = n >>> 2 | n << 30;
      i5 = t(m, n, k);
      arrayOfInt = this.i;
      i4 = i6 + 1;
      i1 += (i2 << 5 | i2 >>> 27) + i5 + arrayOfInt[i6] + 1518500249;
      m = m >>> 2 | m << 30;
      i5 = t(i2, m, n);
      arrayOfInt = this.i;
      i6 = i4 + 1;
      k += (i1 << 5 | i1 >>> 27) + i5 + arrayOfInt[i4] + 1518500249;
      i2 = i2 >>> 2 | i2 << 30;
      i5 = t(i1, i2, m);
      arrayOfInt = this.i;
      i4 = i6 + 1;
      n += (k << 5 | k >>> 27) + i5 + arrayOfInt[i6] + 1518500249;
      i1 = i1 >>> 2 | i1 << 30;
      m += (n << 5 | n >>> 27) + t(k, i1, i2) + this.i[i4] + 1518500249;
      k = k >>> 2 | k << 30;
      i3++;
    }
    i3 = 0;
    while (i3 < 4)
    {
      i5 = v(n, k, i1);
      arrayOfInt = this.i;
      i6 = i4 + 1;
      i2 += (m << 5 | m >>> 27) + i5 + arrayOfInt[i4] + 1859775393;
      n = n >>> 2 | n << 30;
      i5 = v(m, n, k);
      arrayOfInt = this.i;
      i4 = i6 + 1;
      i1 += (i2 << 5 | i2 >>> 27) + i5 + arrayOfInt[i6] + 1859775393;
      m = m >>> 2 | m << 30;
      i5 = v(i2, m, n);
      arrayOfInt = this.i;
      i6 = i4 + 1;
      k += (i1 << 5 | i1 >>> 27) + i5 + arrayOfInt[i4] + 1859775393;
      i2 = i2 >>> 2 | i2 << 30;
      i5 = v(i1, i2, m);
      arrayOfInt = this.i;
      i4 = i6 + 1;
      n += (k << 5 | k >>> 27) + i5 + arrayOfInt[i6] + 1859775393;
      i1 = i1 >>> 2 | i1 << 30;
      m += (n << 5 | n >>> 27) + v(k, i1, i2) + this.i[i4] + 1859775393;
      k = k >>> 2 | k << 30;
      i3++;
      i4++;
    }
    i3 = 0;
    while (i3 < 4)
    {
      i5 = u(n, k, i1);
      arrayOfInt = this.i;
      i6 = i4 + 1;
      i2 += (m << 5 | m >>> 27) + i5 + arrayOfInt[i4] - 1894007588;
      n = n >>> 2 | n << 30;
      i5 = u(m, n, k);
      arrayOfInt = this.i;
      i4 = i6 + 1;
      i1 += (i2 << 5 | i2 >>> 27) + i5 + arrayOfInt[i6] - 1894007588;
      m = m >>> 2 | m << 30;
      i5 = u(i2, m, n);
      arrayOfInt = this.i;
      i6 = i4 + 1;
      k += (i1 << 5 | i1 >>> 27) + i5 + arrayOfInt[i4] - 1894007588;
      i2 = i2 >>> 2 | i2 << 30;
      i5 = u(i1, i2, m);
      arrayOfInt = this.i;
      i4 = i6 + 1;
      n += (k << 5 | k >>> 27) + i5 + arrayOfInt[i6] - 1894007588;
      i1 = i1 >>> 2 | i1 << 30;
      m += (n << 5 | n >>> 27) + u(k, i1, i2) + this.i[i4] - 1894007588;
      k = k >>> 2 | k << 30;
      i3++;
      i4++;
    }
    int i6 = 0;
    i3 = i4;
    i4 = i6;
    while (i4 <= 3)
    {
      i5 = v(n, k, i1);
      arrayOfInt = this.i;
      i6 = i3 + 1;
      i2 += (m << 5 | m >>> 27) + i5 + arrayOfInt[i3] - 899497514;
      n = n >>> 2 | n << 30;
      i5 = v(m, n, k);
      arrayOfInt = this.i;
      i3 = i6 + 1;
      i1 += (i2 << 5 | i2 >>> 27) + i5 + arrayOfInt[i6] - 899497514;
      m = m >>> 2 | m << 30;
      i5 = v(i2, m, n);
      arrayOfInt = this.i;
      i6 = i3 + 1;
      k += (i1 << 5 | i1 >>> 27) + i5 + arrayOfInt[i3] - 899497514;
      i2 = i2 >>> 2 | i2 << 30;
      i5 = v(i1, i2, m);
      arrayOfInt = this.i;
      i3 = i6 + 1;
      n += (k << 5 | k >>> 27) + i5 + arrayOfInt[i6] - 899497514;
      i1 = i1 >>> 2 | i1 << 30;
      m += (n << 5 | n >>> 27) + v(k, i1, i2) + this.i[i3] - 899497514;
      k = k >>> 2 | k << 30;
      i4++;
      i3++;
    }
    this.d += m;
    this.e += n;
    this.f += k;
    this.g += i1;
    this.h += i2;
    this.j = 0;
    for (k = 0; k < 16; k++) {
      this.i[k] = 0;
    }
  }
  
  protected void q(long paramLong)
  {
    if (this.j > 14) {
      p();
    }
    int[] arrayOfInt = this.i;
    arrayOfInt[14] = ((int)(paramLong >>> 32));
    arrayOfInt[15] = ((int)paramLong);
  }
  
  protected void r(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte[paramInt];
    int m = paramInt + 1;
    paramInt = paramArrayOfByte[m];
    int n = m + 1;
    m = paramArrayOfByte[n];
    n = paramArrayOfByte[(n + 1)];
    paramArrayOfByte = this.i;
    int i1 = this.j;
    paramArrayOfByte[i1] = (n & 0xFF | k << 24 | (paramInt & 0xFF) << 16 | (m & 0xFF) << 8);
    paramInt = i1 + 1;
    this.j = paramInt;
    if (paramInt == 16) {
      p();
    }
  }
  
  public void reset()
  {
    super.reset();
    this.d = 1732584193;
    this.e = -271733879;
    this.f = -1732584194;
    this.g = 271733878;
    this.h = -1009589776;
    this.j = 0;
    for (int k = 0;; k++)
    {
      int[] arrayOfInt = this.i;
      if (k == arrayOfInt.length) {
        break;
      }
      arrayOfInt[k] = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */