package org.bouncycastle.crypto.p;

import org.bouncycastle.util.e;

public class f
  extends a
{
  static final int[] d = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int[] m = new int[64];
  private int n;
  
  public f()
  {
    reset();
  }
  
  public f(f paramf)
  {
    super(paramf);
    y(paramf);
  }
  
  private int s(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 ^ 0xFFFFFFFF) & paramInt3 ^ paramInt2 & paramInt1;
  }
  
  private int t(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 ^ paramInt1 & paramInt2 ^ paramInt2 & paramInt3;
  }
  
  private int u(int paramInt)
  {
    return (paramInt << 10 | paramInt >>> 22) ^ (paramInt >>> 2 | paramInt << 30) ^ (paramInt >>> 13 | paramInt << 19);
  }
  
  private int v(int paramInt)
  {
    return (paramInt << 7 | paramInt >>> 25) ^ (paramInt >>> 6 | paramInt << 26) ^ (paramInt >>> 11 | paramInt << 21);
  }
  
  private int w(int paramInt)
  {
    return paramInt >>> 3 ^ (paramInt >>> 7 | paramInt << 25) ^ (paramInt >>> 18 | paramInt << 14);
  }
  
  private int x(int paramInt)
  {
    return paramInt >>> 10 ^ (paramInt >>> 17 | paramInt << 15) ^ (paramInt >>> 19 | paramInt << 13);
  }
  
  private void y(f paramf)
  {
    super.n(paramf);
    this.e = paramf.e;
    this.f = paramf.f;
    this.g = paramf.g;
    this.h = paramf.h;
    this.i = paramf.i;
    this.j = paramf.j;
    this.k = paramf.k;
    this.l = paramf.l;
    int[] arrayOfInt = paramf.m;
    System.arraycopy(arrayOfInt, 0, this.m, 0, arrayOfInt.length);
    this.n = paramf.n;
  }
  
  public String b()
  {
    return "SHA-224";
  }
  
  public e copy()
  {
    return new f(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    o();
    org.bouncycastle.util.f.d(this.e, paramArrayOfByte, paramInt);
    org.bouncycastle.util.f.d(this.f, paramArrayOfByte, paramInt + 4);
    org.bouncycastle.util.f.d(this.g, paramArrayOfByte, paramInt + 8);
    org.bouncycastle.util.f.d(this.h, paramArrayOfByte, paramInt + 12);
    org.bouncycastle.util.f.d(this.i, paramArrayOfByte, paramInt + 16);
    org.bouncycastle.util.f.d(this.j, paramArrayOfByte, paramInt + 20);
    org.bouncycastle.util.f.d(this.k, paramArrayOfByte, paramInt + 24);
    reset();
    return 28;
  }
  
  public int e()
  {
    return 28;
  }
  
  public void m(e parame)
  {
    y((f)parame);
  }
  
  protected void p()
  {
    int[] arrayOfInt2;
    for (int i1 = 16; i1 <= 63; i1++)
    {
      int[] arrayOfInt1 = this.m;
      i2 = x(arrayOfInt1[(i1 - 2)]);
      arrayOfInt2 = this.m;
      arrayOfInt1[i1] = (i2 + arrayOfInt2[(i1 - 7)] + w(arrayOfInt2[(i1 - 15)]) + this.m[(i1 - 16)]);
    }
    int i2 = this.e;
    int i3 = this.f;
    int i4 = this.g;
    int i5 = this.h;
    int i6 = this.i;
    int i7 = this.j;
    int i8 = this.k;
    int i9 = this.l;
    i1 = 0;
    int i10 = 0;
    while (i1 < 8)
    {
      int i11 = v(i6);
      int i12 = s(i6, i7, i8);
      arrayOfInt2 = d;
      i9 += i11 + i12 + arrayOfInt2[i10] + this.m[i10];
      i5 += i9;
      i9 += u(i2) + t(i2, i3, i4);
      i10++;
      i12 = i8 + (v(i5) + s(i5, i6, i7) + arrayOfInt2[i10] + this.m[i10]);
      i8 = i4 + i12;
      i4 = i12 + (u(i9) + t(i9, i2, i3));
      i10++;
      i7 += v(i8) + s(i8, i5, i6) + arrayOfInt2[i10] + this.m[i10];
      i3 += i7;
      i7 += u(i4) + t(i4, i9, i2);
      i10++;
      i6 += v(i3) + s(i3, i8, i5) + arrayOfInt2[i10] + this.m[i10];
      i2 += i6;
      i6 += u(i7) + t(i7, i4, i9);
      i10++;
      i5 += v(i2) + s(i2, i3, i8) + arrayOfInt2[i10] + this.m[i10];
      i9 += i5;
      i5 += u(i6) + t(i6, i7, i4);
      i10++;
      i12 = i8 + (v(i9) + s(i9, i2, i3) + arrayOfInt2[i10] + this.m[i10]);
      i8 = i4 + i12;
      i4 = i12 + (u(i5) + t(i5, i6, i7));
      i10++;
      i3 += v(i8) + s(i8, i9, i2) + arrayOfInt2[i10] + this.m[i10];
      i7 += i3;
      i3 += u(i4) + t(i4, i5, i6);
      i10++;
      i2 += v(i7) + s(i7, i8, i9) + arrayOfInt2[i10] + this.m[i10];
      i6 += i2;
      i2 += u(i3) + t(i3, i4, i5);
      i10++;
      i1++;
    }
    this.e += i2;
    this.f += i3;
    this.g += i4;
    this.h += i5;
    this.i += i6;
    this.j += i7;
    this.k += i8;
    this.l += i9;
    this.n = 0;
    for (i1 = 0; i1 < 16; i1++) {
      this.m[i1] = 0;
    }
  }
  
  protected void q(long paramLong)
  {
    if (this.n > 14) {
      p();
    }
    int[] arrayOfInt = this.m;
    arrayOfInt[14] = ((int)(paramLong >>> 32));
    arrayOfInt[15] = ((int)(paramLong & 0xFFFFFFFFFFFFFFFF));
  }
  
  protected void r(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramArrayOfByte[paramInt];
    int i2 = paramInt + 1;
    paramInt = paramArrayOfByte[i2];
    int i3 = i2 + 1;
    i2 = paramArrayOfByte[i3];
    i3 = paramArrayOfByte[(i3 + 1)];
    paramArrayOfByte = this.m;
    int i4 = this.n;
    paramArrayOfByte[i4] = (i3 & 0xFF | i1 << 24 | (paramInt & 0xFF) << 16 | (i2 & 0xFF) << 8);
    paramInt = i4 + 1;
    this.n = paramInt;
    if (paramInt == 16) {
      p();
    }
  }
  
  public void reset()
  {
    super.reset();
    this.e = -1056596264;
    this.f = 914150663;
    this.g = 812702999;
    this.h = -150054599;
    this.i = -4191439;
    this.j = 1750603025;
    this.k = 1694076839;
    this.l = -1090891868;
    this.n = 0;
    for (int i1 = 0;; i1++)
    {
      int[] arrayOfInt = this.m;
      if (i1 == arrayOfInt.length) {
        break;
      }
      arrayOfInt[i1] = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */