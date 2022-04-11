package org.bouncycastle.crypto.p;

import org.bouncycastle.util.e;
import org.bouncycastle.util.f;

public class g
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
  
  public g()
  {
    reset();
  }
  
  public g(g paramg)
  {
    super(paramg);
    y(paramg);
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
  
  private void y(g paramg)
  {
    super.n(paramg);
    this.e = paramg.e;
    this.f = paramg.f;
    this.g = paramg.g;
    this.h = paramg.h;
    this.i = paramg.i;
    this.j = paramg.j;
    this.k = paramg.k;
    this.l = paramg.l;
    int[] arrayOfInt = paramg.m;
    System.arraycopy(arrayOfInt, 0, this.m, 0, arrayOfInt.length);
    this.n = paramg.n;
  }
  
  public String b()
  {
    return "SHA-256";
  }
  
  public e copy()
  {
    return new g(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    o();
    f.d(this.e, paramArrayOfByte, paramInt);
    f.d(this.f, paramArrayOfByte, paramInt + 4);
    f.d(this.g, paramArrayOfByte, paramInt + 8);
    f.d(this.h, paramArrayOfByte, paramInt + 12);
    f.d(this.i, paramArrayOfByte, paramInt + 16);
    f.d(this.j, paramArrayOfByte, paramInt + 20);
    f.d(this.k, paramArrayOfByte, paramInt + 24);
    f.d(this.l, paramArrayOfByte, paramInt + 28);
    reset();
    return 32;
  }
  
  public int e()
  {
    return 32;
  }
  
  public void m(e parame)
  {
    y((g)parame);
  }
  
  protected void p()
  {
    int[] arrayOfInt1;
    for (int i1 = 16; i1 <= 63; i1++)
    {
      arrayOfInt1 = this.m;
      i2 = x(arrayOfInt1[(i1 - 2)]);
      int[] arrayOfInt2 = this.m;
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
      arrayOfInt1 = d;
      i11 = i9 + (i11 + i12 + arrayOfInt1[i10] + this.m[i10]);
      i9 = i5 + i11;
      i5 = i11 + (u(i2) + t(i2, i3, i4));
      i10++;
      i8 += v(i9) + s(i9, i6, i7) + arrayOfInt1[i10] + this.m[i10];
      i4 += i8;
      i8 += u(i5) + t(i5, i2, i3);
      i10++;
      i7 += v(i4) + s(i4, i9, i6) + arrayOfInt1[i10] + this.m[i10];
      i3 += i7;
      i7 += u(i8) + t(i8, i5, i2);
      i10++;
      i6 += v(i3) + s(i3, i4, i9) + arrayOfInt1[i10] + this.m[i10];
      i2 += i6;
      i6 += u(i7) + t(i7, i8, i5);
      i10++;
      i11 = i9 + (v(i2) + s(i2, i3, i4) + arrayOfInt1[i10] + this.m[i10]);
      i9 = i5 + i11;
      i5 = i11 + (u(i6) + t(i6, i7, i8));
      i10++;
      i4 += v(i9) + s(i9, i2, i3) + arrayOfInt1[i10] + this.m[i10];
      i8 += i4;
      i4 += u(i5) + t(i5, i6, i7);
      i10++;
      i3 += v(i8) + s(i8, i9, i2) + arrayOfInt1[i10] + this.m[i10];
      i7 += i3;
      i3 += u(i4) + t(i4, i5, i6);
      i10++;
      i2 += v(i7) + s(i7, i8, i9) + arrayOfInt1[i10] + this.m[i10];
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
    this.e = 1779033703;
    this.f = -1150833019;
    this.g = 1013904242;
    this.h = -1521486534;
    this.i = 1359893119;
    this.j = -1694144372;
    this.k = 528734635;
    this.l = 1541459225;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */