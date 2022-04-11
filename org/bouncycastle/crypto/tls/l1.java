package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;

public class l1
  implements i0
{
  protected p0 a;
  protected m b;
  protected m c;
  protected y0 d;
  protected y0 e;
  protected boolean f;
  
  public l1(p0 paramp0, m paramm1, m paramm2, g paramg1, g paramg2, int paramInt, boolean paramBoolean)
    throws IOException
  {
    boolean bool = paramp0.isServer();
    this.a = paramp0;
    this.f = paramBoolean;
    this.b = paramm1;
    this.c = paramm2;
    int i = paramInt * 2 + paramg1.e() + paramg2.e();
    byte[] arrayOfByte = m1.d(paramp0, i);
    y0 localy01 = new y0(paramp0, paramg1, arrayOfByte, 0, paramg1.e());
    int j = paramg1.e() + 0;
    y0 localy02 = new y0(paramp0, paramg2, arrayOfByte, j, paramg2.e());
    j += paramg2.e();
    paramg1 = new a0(arrayOfByte, j, paramInt);
    j += paramInt;
    paramp0 = new a0(arrayOfByte, j, paramInt);
    if (j + paramInt == i)
    {
      if (bool)
      {
        this.d = localy02;
        this.e = localy01;
        this.b = paramm2;
        this.c = paramm1;
        paramm1 = paramp0;
        paramp0 = paramg1;
      }
      else
      {
        this.d = localy01;
        this.e = localy02;
        this.b = paramm1;
        this.c = paramm2;
        paramm1 = paramg1;
      }
      paramg1 = paramm1;
      paramm2 = paramp0;
      if (paramBoolean)
      {
        paramm2 = new byte[8];
        paramg1 = new b0(paramm1, paramm2);
        paramm2 = new b0(paramp0, paramm2);
      }
      this.b.a(true, paramg1);
      this.c.a(false, paramm2);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.f) {
      d(this.c, false, paramLong);
    }
    int i = this.e.d();
    if (paramInt2 >= i)
    {
      i = paramInt2 - i;
      byte[] arrayOfByte = new byte[paramInt2];
      this.c.c(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
      c(paramLong, paramShort, arrayOfByte, i, paramInt2, arrayOfByte, 0, i);
      return a.s(arrayOfByte, 0, i);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] b(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.f) {
      d(this.b, true, paramLong);
    }
    byte[] arrayOfByte = new byte[paramInt2 + this.d.d()];
    this.b.c(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    paramArrayOfByte = this.d.a(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2);
    this.b.c(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte, paramInt2);
    return arrayOfByte;
  }
  
  protected void c(long paramLong, short paramShort, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
    throws IOException
  {
    if (a.o(a.s(paramArrayOfByte1, paramInt1, paramInt2), this.e.a(paramLong, paramShort, paramArrayOfByte2, paramInt3, paramInt4))) {
      return;
    }
    throw new TlsFatalAlert((short)20);
  }
  
  protected void d(m paramm, boolean paramBoolean, long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    m1.E0(paramLong, arrayOfByte, 0);
    paramm.a(paramBoolean, new b0(null, arrayOfByte));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\l1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */