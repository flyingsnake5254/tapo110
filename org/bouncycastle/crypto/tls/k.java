package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;
import org.bouncycastle.util.f;

public class k
  implements i0
{
  private static final byte[] a = new byte[15];
  protected p0 b;
  protected org.bouncycastle.crypto.engines.c c;
  protected org.bouncycastle.crypto.engines.c d;
  protected byte[] e;
  protected byte[] f;
  
  public k(p0 paramp0)
    throws IOException
  {
    if (m1.P(paramp0))
    {
      this.b = paramp0;
      byte[] arrayOfByte1 = m1.d(paramp0, 88);
      a0 locala01 = new a0(arrayOfByte1, 0, 32);
      a0 locala02 = new a0(arrayOfByte1, 32, 32);
      byte[] arrayOfByte2 = a.s(arrayOfByte1, 64, 76);
      arrayOfByte1 = a.s(arrayOfByte1, 76, 88);
      this.c = new org.bouncycastle.crypto.engines.c();
      this.d = new org.bouncycastle.crypto.engines.c();
      if (paramp0.isServer())
      {
        this.e = arrayOfByte1;
        this.f = arrayOfByte2;
        paramp0 = locala02;
        locala02 = locala01;
      }
      else
      {
        this.e = arrayOfByte2;
        this.f = arrayOfByte1;
        paramp0 = locala01;
      }
      this.c.a(true, new b0(paramp0, this.e));
      this.d.a(false, new b0(locala02, this.f));
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (g(paramInt2) >= 0)
    {
      Object localObject = h(this.d, false, paramLong, this.f);
      int i = paramInt2 - 16;
      if (a.o(d((a0)localObject, f(paramLong, paramShort, i), paramArrayOfByte, paramInt1, i), a.s(paramArrayOfByte, paramInt1 + i, paramInt1 + paramInt2)))
      {
        localObject = new byte[i];
        this.d.c(paramArrayOfByte, paramInt1, i, (byte[])localObject, 0);
        return (byte[])localObject;
      }
      throw new TlsFatalAlert((short)20);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] b(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    a0 locala0 = h(this.c, true, paramLong, this.e);
    byte[] arrayOfByte = new byte[paramInt2 + 16];
    this.c.c(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    paramArrayOfByte = d(locala0, f(paramLong, paramShort, paramInt2), arrayOfByte, 0, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, paramInt2, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  protected byte[] c(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[12];
    m1.E0(paramLong, arrayOfByte, 4);
    for (int i = 0; i < 12; i++) {
      arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] ^ paramArrayOfByte[i]));
    }
    return arrayOfByte;
  }
  
  protected byte[] d(a0 parama0, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    org.bouncycastle.crypto.t.c localc = new org.bouncycastle.crypto.t.c();
    localc.d(parama0);
    j(localc, paramArrayOfByte1, 0, paramArrayOfByte1.length);
    j(localc, paramArrayOfByte2, paramInt1, paramInt2);
    i(localc, paramArrayOfByte1.length);
    i(localc, paramInt2);
    parama0 = new byte[localc.a()];
    localc.doFinal(parama0, 0);
    return parama0;
  }
  
  protected a0 e(m paramm)
  {
    byte[] arrayOfByte = new byte[64];
    paramm.c(arrayOfByte, 0, 64, arrayOfByte, 0);
    paramm = new a0(arrayOfByte, 0, 32);
    a.u(arrayOfByte, (byte)0);
    return paramm;
  }
  
  protected byte[] f(long paramLong, short paramShort, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[13];
    m1.E0(paramLong, arrayOfByte, 0);
    m1.I0(paramShort, arrayOfByte, 8);
    m1.O0(this.b.b(), arrayOfByte, 9);
    m1.x0(paramInt, arrayOfByte, 11);
    return arrayOfByte;
  }
  
  public int g(int paramInt)
  {
    return paramInt - 16;
  }
  
  protected a0 h(m paramm, boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    paramm.a(paramBoolean, new b0(null, c(paramLong, paramArrayOfByte)));
    return e(paramm);
  }
  
  protected void i(j paramj, int paramInt)
  {
    byte[] arrayOfByte = f.q(paramInt & 0xFFFFFFFF);
    paramj.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  protected void j(j paramj, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramj.update(paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2 % 16;
    if (paramInt1 != 0) {
      paramj.update(a, 0, 16 - paramInt1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */