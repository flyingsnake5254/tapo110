package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.p.c;
import org.bouncycastle.crypto.t.b;
import org.bouncycastle.util.a;

public class y0
{
  protected p0 a;
  protected byte[] b;
  protected j c;
  protected int d;
  protected int e;
  protected int f;
  
  public y0(p0 paramp0, g paramg, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramp0;
    paramArrayOfByte = new org.bouncycastle.crypto.w.a0(paramArrayOfByte, paramInt1, paramInt2);
    this.b = a.g(paramArrayOfByte.a());
    if ((paramg instanceof c))
    {
      this.d = 128;
      paramInt1 = 16;
    }
    else
    {
      this.d = 64;
      paramInt1 = 8;
    }
    this.e = paramInt1;
    if (m1.K(paramp0))
    {
      this.c = new z(paramg);
      if (paramg.e() == 20) {
        this.e = 4;
      }
    }
    else
    {
      this.c = new b(paramg);
    }
    this.c.d(paramArrayOfByte);
    this.f = this.c.a();
    if (paramp0.e().m) {
      this.f = Math.min(this.f, 10);
    }
  }
  
  public byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    x localx = this.a.b();
    boolean bool = localx.i();
    int i;
    if (bool) {
      i = 11;
    } else {
      i = 13;
    }
    byte[] arrayOfByte = new byte[i];
    m1.E0(paramLong, arrayOfByte, 0);
    m1.I0(paramShort, arrayOfByte, 8);
    if (!bool) {
      m1.O0(localx, arrayOfByte, 9);
    }
    m1.x0(paramInt2, arrayOfByte, i - 2);
    this.c.update(arrayOfByte, 0, i);
    this.c.update(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = new byte[this.c.a()];
    this.c.doFinal(paramArrayOfByte, 0);
    return e(paramArrayOfByte);
  }
  
  public byte[] b(long paramLong, short paramShort, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = a(paramLong, paramShort, paramArrayOfByte1, paramInt1, paramInt2);
    if (m1.K(this.a)) {
      paramInt1 = 11;
    } else {
      paramInt1 = 13;
    }
    paramInt1 = c(paramInt3 + paramInt1) - c(paramInt1 + paramInt2);
    for (;;)
    {
      paramInt1--;
      if (paramInt1 < 0) {
        break;
      }
      this.c.update(paramArrayOfByte2, 0, this.d);
    }
    this.c.c(paramArrayOfByte2[0]);
    this.c.reset();
    return paramArrayOfByte1;
  }
  
  protected int c(int paramInt)
  {
    return (paramInt + this.e) / this.d;
  }
  
  public int d()
  {
    return this.f;
  }
  
  protected byte[] e(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = this.f;
    if (i <= j) {
      return paramArrayOfByte;
    }
    return a.r(paramArrayOfByte, j);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\y0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */