package org.bouncycastle.crypto.t;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.f;

public class c
  implements j
{
  private final org.bouncycastle.crypto.c a = null;
  private final byte[] b = new byte[1];
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private final byte[] p = new byte[16];
  private int q = 0;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  private static final long e(int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0xFFFFFFFF) * paramInt2;
  }
  
  private void f()
  {
    int i1 = this.q;
    if (i1 < 16)
    {
      this.p[i1] = ((byte)1);
      i1++;
      while (i1 < 16)
      {
        this.p[i1] = ((byte)0);
        i1++;
      }
    }
    long l1 = f.g(this.p, 0) & 0xFFFFFFFF;
    long l2 = f.g(this.p, 4) & 0xFFFFFFFF;
    long l3 = f.g(this.p, 8) & 0xFFFFFFFF;
    long l4 = 0xFFFFFFFF & f.g(this.p, 12);
    i1 = (int)(this.r + (l1 & 0x3FFFFFF));
    this.r = i1;
    this.s = ((int)(this.s + ((l2 << 32 | l1) >>> 26 & 0x3FFFFFF)));
    this.t = ((int)(this.t + ((l2 | l3 << 32) >>> 20 & 0x3FFFFFF)));
    this.u = ((int)(this.u + ((l4 << 32 | l3) >>> 14 & 0x3FFFFFF)));
    int i2 = (int)(this.v + (l4 >>> 8));
    this.v = i2;
    if (this.q == 16) {
      this.v = (i2 + 16777216);
    }
    long l5 = e(i1, this.c) + e(this.s, this.k) + e(this.t, this.j) + e(this.u, this.i) + e(this.v, this.h);
    long l6 = e(this.r, this.d);
    long l7 = e(this.s, this.c);
    long l8 = e(this.t, this.k);
    long l9 = e(this.u, this.j);
    long l10 = e(this.v, this.i);
    long l11 = e(this.r, this.e);
    long l12 = e(this.s, this.d);
    long l13 = e(this.t, this.c);
    long l14 = e(this.u, this.k);
    long l15 = e(this.v, this.j);
    long l16 = e(this.r, this.f);
    long l17 = e(this.s, this.e);
    long l18 = e(this.t, this.d);
    long l19 = e(this.u, this.c);
    long l20 = e(this.v, this.k);
    l4 = e(this.r, this.g);
    l1 = e(this.s, this.f);
    l2 = e(this.t, this.e);
    l3 = e(this.u, this.d);
    long l21 = e(this.v, this.c);
    i2 = (int)l5 & 0x3FFFFFF;
    this.r = i2;
    l10 = l6 + l7 + l8 + l9 + l10 + (l5 >>> 26);
    i1 = (int)l10 & 0x3FFFFFF;
    this.s = i1;
    l11 = l11 + l12 + l13 + l14 + l15 + (l10 >>> 26);
    this.t = ((int)l11 & 0x3FFFFFF);
    l19 = l16 + l17 + l18 + l19 + l20 + (l11 >>> 26);
    this.u = ((int)l19 & 0x3FFFFFF);
    l4 = l4 + l1 + l2 + l3 + l21 + (l19 >>> 26);
    this.v = ((int)l4 & 0x3FFFFFF);
    i2 += (int)(l4 >>> 26) * 5;
    this.r = i2;
    this.s = (i1 + (i2 >>> 26));
    this.r = (i2 & 0x3FFFFFF);
  }
  
  private void g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 32)
    {
      Object localObject = this.a;
      int i1 = 16;
      if ((localObject != null) && ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length != 16))) {
        throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
      }
      int i2 = f.g(paramArrayOfByte1, 0);
      int i3 = f.g(paramArrayOfByte1, 4);
      int i4 = f.g(paramArrayOfByte1, 8);
      int i5 = f.g(paramArrayOfByte1, 12);
      this.c = (0x3FFFFFF & i2);
      i2 = (i2 >>> 26 | i3 << 6) & 0x3FFFF03;
      this.d = i2;
      i3 = (i3 >>> 20 | i4 << 12) & 0x3FFC0FF;
      this.e = i3;
      i4 = (i4 >>> 14 | i5 << 18) & 0x3F03FFF;
      this.f = i4;
      i5 = i5 >>> 8 & 0xFFFFF;
      this.g = i5;
      this.h = (i2 * 5);
      this.i = (i3 * 5);
      this.j = (i4 * 5);
      this.k = (i5 * 5);
      org.bouncycastle.crypto.c localc = this.a;
      if (localc != null)
      {
        localObject = new byte[16];
        localc.a(true, new a0(paramArrayOfByte1, 16, 16));
        this.a.d(paramArrayOfByte2, 0, (byte[])localObject, 0);
        paramArrayOfByte1 = (byte[])localObject;
        i1 = 0;
      }
      this.l = f.g(paramArrayOfByte1, i1 + 0);
      this.m = f.g(paramArrayOfByte1, i1 + 4);
      this.n = f.g(paramArrayOfByte1, i1 + 8);
      this.o = f.g(paramArrayOfByte1, i1 + 12);
      return;
    }
    throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
  }
  
  public int a()
  {
    return 16;
  }
  
  public String b()
  {
    Object localObject;
    if (this.a == null)
    {
      localObject = "Poly1305";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Poly1305-");
      ((StringBuilder)localObject).append(this.a.b());
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  public void c(byte paramByte)
    throws IllegalStateException
  {
    byte[] arrayOfByte = this.b;
    arrayOfByte[0] = ((byte)paramByte);
    update(arrayOfByte, 0, 1);
  }
  
  public void d(e parame)
    throws IllegalArgumentException
  {
    byte[] arrayOfByte;
    if (this.a != null)
    {
      if ((parame instanceof b0))
      {
        parame = (b0)parame;
        arrayOfByte = parame.a();
        parame = parame.b();
      }
      else
      {
        throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
      }
    }
    else {
      arrayOfByte = null;
    }
    if ((parame instanceof a0))
    {
      g(((a0)parame).a(), arrayOfByte);
      reset();
      return;
    }
    throw new IllegalArgumentException("Poly1305 requires a key.");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    if (paramInt + 16 <= paramArrayOfByte.length)
    {
      if (this.q > 0) {
        f();
      }
      int i1 = this.s;
      int i2 = this.r;
      i1 += (i2 >>> 26);
      this.s = i1;
      int i3 = i2 & 0x3FFFFFF;
      this.r = i3;
      i2 = this.t + (i1 >>> 26);
      this.t = i2;
      int i4 = i1 & 0x3FFFFFF;
      this.s = i4;
      i1 = this.u + (i2 >>> 26);
      this.u = i1;
      i2 &= 0x3FFFFFF;
      this.t = i2;
      int i5 = this.v + (i1 >>> 26);
      this.v = i5;
      i1 &= 0x3FFFFFF;
      this.u = i1;
      int i6 = i3 + (i5 >>> 26) * 5;
      this.r = i6;
      i3 = i5 & 0x3FFFFFF;
      this.v = i3;
      int i7 = i4 + (i6 >>> 26);
      this.s = i7;
      int i8 = i6 & 0x3FFFFFF;
      this.r = i8;
      int i9 = i8 + 5;
      int i10 = (i9 >>> 26) + i7;
      int i11 = (i10 >>> 26) + i2;
      int i12 = (i11 >>> 26) + i1;
      i5 = (i12 >>> 26) + i3 - 67108864;
      i4 = (i5 >>> 31) - 1;
      i6 = i4 ^ 0xFFFFFFFF;
      i9 = i8 & i6 | i9 & 0x3FFFFFF & i4;
      this.r = i9;
      i7 = i7 & i6 | i10 & 0x3FFFFFF & i4;
      this.s = i7;
      i2 = i2 & i6 | i11 & 0x3FFFFFF & i4;
      this.t = i2;
      i1 = 0x3FFFFFF & i12 & i4 | i1 & i6;
      this.u = i1;
      i3 = i3 & i6 | i5 & i4;
      this.v = i3;
      long l1 = ((i9 | i7 << 26) & 0xFFFFFFFF) + (this.l & 0xFFFFFFFF);
      long l2 = i7 >>> 6 | i2 << 20;
      long l3 = this.m;
      long l4 = i2 >>> 12 | i1 << 14;
      long l5 = this.n;
      long l6 = i1 >>> 18 | i3 << 8;
      long l7 = this.o;
      f.e((int)l1, paramArrayOfByte, paramInt);
      l2 = (l2 & 0xFFFFFFFF) + (l3 & 0xFFFFFFFF) + (l1 >>> 32);
      f.e((int)l2, paramArrayOfByte, paramInt + 4);
      l5 = (l4 & 0xFFFFFFFF) + (l5 & 0xFFFFFFFF) + (l2 >>> 32);
      f.e((int)l5, paramArrayOfByte, paramInt + 8);
      f.e((int)((l6 & 0xFFFFFFFF) + (0xFFFFFFFF & l7) + (l5 >>> 32)), paramArrayOfByte, paramInt + 12);
      reset();
      return 16;
    }
    throw new OutputLengthException("Output buffer is too short.");
  }
  
  public void reset()
  {
    this.q = 0;
    this.v = 0;
    this.u = 0;
    this.t = 0;
    this.s = 0;
    this.r = 0;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i1 = 0;
    while (paramInt2 > i1)
    {
      if (this.q == 16)
      {
        f();
        this.q = 0;
      }
      int i2 = Math.min(paramInt2 - i1, 16 - this.q);
      System.arraycopy(paramArrayOfByte, i1 + paramInt1, this.p, this.q, i2);
      i1 += i2;
      this.q += i2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\t\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */