package org.bouncycastle.crypto.p;

import org.bouncycastle.util.MemoableResetException;
import org.bouncycastle.util.e;

public class j
  extends c
{
  private int p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v;
  private long w;
  private long x;
  
  public j(int paramInt)
  {
    if (paramInt < 512)
    {
      if (paramInt % 8 == 0)
      {
        if (paramInt != 384)
        {
          paramInt /= 8;
          this.p = paramInt;
          B(paramInt * 8);
          reset();
          return;
        }
        throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
      }
      throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
    }
    throw new IllegalArgumentException("bitLength cannot be >= 512");
  }
  
  public j(j paramj)
  {
    super(paramj);
    this.p = paramj.p;
    m(paramj);
  }
  
  private static void A(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      z((int)(paramLong >>> 32), paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 4) {
        z((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt1 + 4, paramInt2 - 4);
      }
    }
  }
  
  private void B(int paramInt)
  {
    this.f = -3482333909917012819L;
    this.g = 2216346199247487646L;
    this.h = -7364697282686394994L;
    this.i = 65953792586715988L;
    this.j = -816286391624063116L;
    this.k = 4512832404995164602L;
    this.l = -5033199132376557362L;
    this.m = -124578254951840548L;
    c((byte)83);
    c((byte)72);
    c((byte)65);
    c((byte)45);
    c((byte)53);
    c((byte)49);
    c((byte)50);
    c((byte)47);
    if (paramInt > 100)
    {
      c((byte)(paramInt / 100 + 48));
      paramInt %= 100;
    }
    for (;;)
    {
      c((byte)(paramInt / 10 + 48));
      int i = paramInt % 10;
      do
      {
        c((byte)(i + 48));
        break;
        i = paramInt;
      } while (paramInt <= 10);
    }
    v();
    this.q = this.f;
    this.r = this.g;
    this.s = this.h;
    this.t = this.i;
    this.u = this.j;
    this.v = this.k;
    this.w = this.l;
    this.x = this.m;
  }
  
  private static void z(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt3 = Math.min(4, paramInt3);
    for (;;)
    {
      paramInt3--;
      if (paramInt3 < 0) {
        break;
      }
      paramArrayOfByte[(paramInt2 + paramInt3)] = ((byte)(byte)(paramInt1 >>> (3 - paramInt3) * 8));
    }
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SHA-512/");
    localStringBuilder.append(Integer.toString(this.p * 8));
    return localStringBuilder.toString();
  }
  
  public e copy()
  {
    return new j(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    v();
    A(this.f, paramArrayOfByte, paramInt, this.p);
    A(this.g, paramArrayOfByte, paramInt + 8, this.p - 8);
    A(this.h, paramArrayOfByte, paramInt + 16, this.p - 16);
    A(this.i, paramArrayOfByte, paramInt + 24, this.p - 24);
    A(this.j, paramArrayOfByte, paramInt + 32, this.p - 32);
    A(this.k, paramArrayOfByte, paramInt + 40, this.p - 40);
    A(this.l, paramArrayOfByte, paramInt + 48, this.p - 48);
    A(this.m, paramArrayOfByte, paramInt + 56, this.p - 56);
    reset();
    return this.p;
  }
  
  public int e()
  {
    return this.p;
  }
  
  public void m(e parame)
  {
    parame = (j)parame;
    if (this.p == parame.p)
    {
      super.u(parame);
      this.q = parame.q;
      this.r = parame.r;
      this.s = parame.s;
      this.t = parame.t;
      this.u = parame.u;
      this.v = parame.v;
      this.w = parame.w;
      this.x = parame.x;
      return;
    }
    throw new MemoableResetException("digestLength inappropriate in other");
  }
  
  public void reset()
  {
    super.reset();
    this.f = this.q;
    this.g = this.r;
    this.h = this.s;
    this.i = this.t;
    this.j = this.u;
    this.k = this.v;
    this.l = this.w;
    this.m = this.x;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */