package org.bouncycastle.crypto.p;

import org.bouncycastle.util.e;

public class d
  extends a
{
  private int d;
  private int e;
  private int f;
  private int g;
  private int[] h = new int[16];
  private int i;
  
  public d()
  {
    reset();
  }
  
  public d(d paramd)
  {
    super(paramd);
    w(paramd);
  }
  
  private int s(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 ^ 0xFFFFFFFF) & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int t(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & (paramInt3 ^ 0xFFFFFFFF);
  }
  
  private int u(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int v(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 | paramInt3 ^ 0xFFFFFFFF) ^ paramInt2;
  }
  
  private void w(d paramd)
  {
    super.n(paramd);
    this.d = paramd.d;
    this.e = paramd.e;
    this.f = paramd.f;
    this.g = paramd.g;
    int[] arrayOfInt = paramd.h;
    System.arraycopy(arrayOfInt, 0, this.h, 0, arrayOfInt.length);
    this.i = paramd.i;
  }
  
  private int x(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  private void y(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(byte)(paramInt1 >>> 24));
  }
  
  public String b()
  {
    return "MD5";
  }
  
  public e copy()
  {
    return new d(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    o();
    y(this.d, paramArrayOfByte, paramInt);
    y(this.e, paramArrayOfByte, paramInt + 4);
    y(this.f, paramArrayOfByte, paramInt + 8);
    y(this.g, paramArrayOfByte, paramInt + 12);
    reset();
    return 16;
  }
  
  public int e()
  {
    return 16;
  }
  
  public void m(e parame)
  {
    w((d)parame);
  }
  
  protected void p()
  {
    int j = this.d;
    int k = this.e;
    int m = this.f;
    int n = this.g;
    int i1 = x(j + s(k, m, n) + this.h[0] - 680876936, 7) + k;
    n = x(n + s(i1, k, m) + this.h[1] - 389564586, 12) + i1;
    j = x(m + s(n, i1, k) + this.h[2] + 606105819, 17) + n;
    m = x(k + s(j, n, i1) + this.h[3] - 1044525330, 22) + j;
    k = x(i1 + s(m, j, n) + this.h[4] - 176418897, 7) + m;
    i1 = x(n + s(k, m, j) + this.h[5] + 1200080426, 12) + k;
    n = x(j + s(i1, k, m) + this.h[6] - 1473231341, 17) + i1;
    j = x(m + s(n, i1, k) + this.h[7] - 45705983, 22) + n;
    int i2 = x(k + s(j, n, i1) + this.h[8] + 1770035416, 7) + j;
    k = x(i1 + s(i2, j, n) + this.h[9] - 1958414417, 12) + i2;
    m = x(n + s(k, i2, j) + this.h[10] - 42063, 17) + k;
    j = x(j + s(m, k, i2) + this.h[11] - 1990404162, 22) + m;
    n = x(i2 + s(j, m, k) + this.h[12] + 1804603682, 7) + j;
    i1 = x(k + s(n, j, m) + this.h[13] - 40341101, 12) + n;
    k = x(m + s(i1, n, j) + this.h[14] - 1502002290, 17) + i1;
    j = x(j + s(k, i1, n) + this.h[15] + 1236535329, 22) + k;
    m = x(n + t(j, k, i1) + this.h[1] - 165796510, 5) + j;
    n = x(i1 + t(m, j, k) + this.h[6] - 1069501632, 9) + m;
    i1 = x(k + t(n, m, j) + this.h[11] + 643717713, 14) + n;
    k = x(j + t(i1, n, m) + this.h[0] - 373897302, 20) + i1;
    j = x(m + t(k, i1, n) + this.h[5] - 701558691, 5) + k;
    n = x(n + t(j, k, i1) + this.h[10] + 38016083, 9) + j;
    i1 = x(i1 + t(n, j, k) + this.h[15] - 660478335, 14) + n;
    m = x(k + t(i1, n, j) + this.h[4] - 405537848, 20) + i1;
    k = x(j + t(m, i1, n) + this.h[9] + 568446438, 5) + m;
    n = x(n + t(k, m, i1) + this.h[14] - 1019803690, 9) + k;
    j = x(i1 + t(n, k, m) + this.h[3] - 187363961, 14) + n;
    m = x(m + t(j, n, k) + this.h[8] + 1163531501, 20) + j;
    k = x(k + t(m, j, n) + this.h[13] - 1444681467, 5) + m;
    i2 = x(n + t(k, m, j) + this.h[2] - 51403784, 9) + k;
    n = x(j + t(i2, k, m) + this.h[7] + 1735328473, 14) + i2;
    i1 = x(m + t(n, i2, k) + this.h[12] - 1926607734, 20) + n;
    k = x(k + u(i1, n, i2) + this.h[5] - 378558, 4) + i1;
    m = x(i2 + u(k, i1, n) + this.h[8] - 2022574463, 11) + k;
    j = x(n + u(m, k, i1) + this.h[11] + 1839030562, 16) + m;
    i1 = x(i1 + u(j, m, k) + this.h[14] - 35309556, 23) + j;
    n = x(k + u(i1, j, m) + this.h[1] - 1530992060, 4) + i1;
    i2 = x(m + u(n, i1, j) + this.h[4] + 1272893353, 11) + n;
    j = x(j + u(i2, n, i1) + this.h[7] - 155497632, 16) + i2;
    k = x(i1 + u(j, i2, n) + this.h[10] - 1094730640, 23) + j;
    m = x(n + u(k, j, i2) + this.h[13] + 681279174, 4) + k;
    i2 = x(i2 + u(m, k, j) + this.h[0] - 358537222, 11) + m;
    n = x(j + u(i2, m, k) + this.h[3] - 722521979, 16) + i2;
    i1 = x(k + u(n, i2, m) + this.h[6] + 76029189, 23) + n;
    k = x(m + u(i1, n, i2) + this.h[9] - 640364487, 4) + i1;
    j = x(i2 + u(k, i1, n) + this.h[12] - 421815835, 11) + k;
    m = x(n + u(j, k, i1) + this.h[15] + 530742520, 16) + j;
    n = x(i1 + u(m, j, k) + this.h[2] - 995338651, 23) + m;
    i1 = x(k + v(n, m, j) + this.h[0] - 198630844, 6) + n;
    k = x(j + v(i1, n, m) + this.h[7] + 1126891415, 10) + i1;
    m = x(m + v(k, i1, n) + this.h[14] - 1416354905, 15) + k;
    j = x(n + v(m, k, i1) + this.h[5] - 57434055, 21) + m;
    i1 = x(i1 + v(j, m, k) + this.h[12] + 1700485571, 6) + j;
    k = x(k + v(i1, j, m) + this.h[3] - 1894986606, 10) + i1;
    n = x(m + v(k, i1, j) + this.h[10] - 1051523, 15) + k;
    m = x(j + v(n, k, i1) + this.h[1] - 2054922799, 21) + n;
    i1 = x(i1 + v(m, n, k) + this.h[8] + 1873313359, 6) + m;
    j = x(k + v(i1, m, n) + this.h[15] - 30611744, 10) + i1;
    n = x(n + v(j, i1, m) + this.h[6] - 1560198380, 15) + j;
    m = x(m + v(n, j, i1) + this.h[13] + 1309151649, 21) + n;
    k = x(i1 + v(m, n, j) + this.h[4] - 145523070, 6) + m;
    j = x(j + v(k, m, n) + this.h[11] - 1120210379, 10) + k;
    n = x(n + v(j, k, m) + this.h[2] + 718787259, 15) + j;
    m = x(m + v(n, j, k) + this.h[9] - 343485551, 21);
    this.d += k;
    this.e += m + n;
    this.f += n;
    this.g += j;
    this.i = 0;
    for (k = 0;; k++)
    {
      int[] arrayOfInt = this.h;
      if (k == arrayOfInt.length) {
        break;
      }
      arrayOfInt[k] = 0;
    }
  }
  
  protected void q(long paramLong)
  {
    if (this.i > 14) {
      p();
    }
    int[] arrayOfInt = this.h;
    arrayOfInt[14] = ((int)(0xFFFFFFFFFFFFFFFF & paramLong));
    arrayOfInt[15] = ((int)(paramLong >>> 32));
  }
  
  protected void r(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.h;
    int j = this.i;
    int k = j + 1;
    this.i = k;
    int m = paramArrayOfByte[paramInt];
    int n = paramArrayOfByte[(paramInt + 1)];
    int i1 = paramArrayOfByte[(paramInt + 2)];
    arrayOfInt[j] = ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | m & 0xFF | (n & 0xFF) << 8 | (i1 & 0xFF) << 16);
    if (k == 16) {
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
    this.i = 0;
    for (int j = 0;; j++)
    {
      int[] arrayOfInt = this.h;
      if (j == arrayOfInt.length) {
        break;
      }
      arrayOfInt[j] = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */