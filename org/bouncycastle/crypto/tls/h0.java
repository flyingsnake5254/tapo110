package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;

public class h0
  implements i0
{
  protected p0 a;
  protected byte[] b;
  protected boolean c;
  protected boolean d;
  protected c e;
  protected c f;
  protected y0 g;
  protected y0 h;
  
  public h0(p0 paramp0, c paramc1, c paramc2, org.bouncycastle.crypto.g paramg1, org.bouncycastle.crypto.g paramg2, int paramInt)
    throws IOException
  {
    this.a = paramp0;
    this.b = new byte['Ā'];
    paramp0.d().b(this.b);
    this.c = m1.N(paramp0);
    this.d = paramp0.e().n;
    int i = paramInt * 2 + paramg1.e() + paramg2.e();
    int j = i;
    if (!this.c) {
      j = i + (paramc1.getBlockSize() + paramc2.getBlockSize());
    }
    byte[] arrayOfByte = m1.d(paramp0, j);
    y0 localy01 = new y0(paramp0, paramg1, arrayOfByte, 0, paramg1.e());
    i = paramg1.e() + 0;
    y0 localy02 = new y0(paramp0, paramg2, arrayOfByte, i, paramg2.e());
    i += paramg2.e();
    org.bouncycastle.crypto.w.a0 locala01 = new org.bouncycastle.crypto.w.a0(arrayOfByte, i, paramInt);
    i += paramInt;
    org.bouncycastle.crypto.w.a0 locala02 = new org.bouncycastle.crypto.w.a0(arrayOfByte, i, paramInt);
    paramInt = i + paramInt;
    if (this.c)
    {
      paramg1 = new byte[paramc1.getBlockSize()];
      paramg2 = new byte[paramc2.getBlockSize()];
    }
    else
    {
      paramg1 = a.s(arrayOfByte, paramInt, paramc1.getBlockSize() + paramInt);
      paramInt += paramc1.getBlockSize();
      paramg2 = a.s(arrayOfByte, paramInt, paramc2.getBlockSize() + paramInt);
      paramInt += paramc2.getBlockSize();
    }
    if (paramInt == j)
    {
      if (paramp0.isServer())
      {
        this.g = localy02;
        this.h = localy01;
        this.e = paramc2;
        this.f = paramc1;
        paramp0 = new b0(locala02, paramg2);
        paramc1 = new b0(locala01, paramg1);
      }
      else
      {
        this.g = localy01;
        this.h = localy02;
        this.e = paramc1;
        this.f = paramc2;
        paramp0 = new b0(locala01, paramg1);
        paramc1 = new b0(locala02, paramg2);
      }
      this.e.a(true, paramp0);
      this.f.a(false, paramc1);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt1;
    int j = this.f.getBlockSize();
    int k = this.h.d();
    int m;
    if (this.d) {
      m = j + k;
    } else {
      m = Math.max(j, k + 1);
    }
    int n = m;
    if (this.c) {
      n = m + j;
    }
    if (paramInt2 >= n)
    {
      boolean bool = this.d;
      if (bool) {
        m = paramInt2 - k;
      } else {
        m = paramInt2;
      }
      if (m % j == 0)
      {
        Object localObject;
        if (bool)
        {
          n = i + paramInt2;
          localObject = a.s(paramArrayOfByte, n - k, n);
          if ((a.o(this.h.a(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2 - k), (byte[])localObject) ^ true)) {
            throw new TlsFatalAlert((short)20);
          }
        }
        paramInt1 = i;
        n = m;
        if (this.c)
        {
          this.f.a(false, new b0(null, paramArrayOfByte, i, j));
          paramInt1 = i + j;
          n = m - j;
        }
        paramInt2 = 0;
        while (paramInt2 < n)
        {
          localObject = this.f;
          m = paramInt1 + paramInt2;
          ((c)localObject).d(paramArrayOfByte, m, paramArrayOfByte, m);
          paramInt2 += j;
        }
        if (this.d) {
          paramInt2 = 0;
        } else {
          paramInt2 = k;
        }
        m = c(paramArrayOfByte, paramInt1, n, j, paramInt2);
        if (m == 0) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
        m = n - m;
        if (!this.d)
        {
          m -= k;
          i = paramInt1 + m;
          localObject = a.s(paramArrayOfByte, i, i + k);
          paramInt2 |= a.o(this.h.b(paramLong, paramShort, paramArrayOfByte, paramInt1, m, n - k, this.b), (byte[])localObject) ^ true;
        }
        if (paramInt2 == 0) {
          return a.s(paramArrayOfByte, paramInt1, paramInt1 + m);
        }
        throw new TlsFatalAlert((short)20);
      }
      throw new TlsFatalAlert((short)21);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] b(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.e.getBlockSize();
    int j = this.g.d();
    Object localObject = this.a.b();
    boolean bool = this.d;
    if (!bool) {
      k = paramInt2 + j;
    } else {
      k = paramInt2;
    }
    int k = i - 1 - k % i;
    int m;
    if (!bool)
    {
      m = k;
      if (this.a.e().m) {}
    }
    else
    {
      m = k;
      if (!((x)localObject).g())
      {
        m = k;
        if (!((x)localObject).i())
        {
          m = (255 - k) / i;
          m = k + d(this.a.c(), m) * i;
        }
      }
    }
    j = j + paramInt2 + m + 1;
    bool = this.c;
    k = j;
    if (bool) {
      k = j + i;
    }
    localObject = new byte[k];
    if (bool)
    {
      byte[] arrayOfByte = new byte[i];
      this.a.d().b(arrayOfByte);
      this.e.a(true, new b0(null, arrayOfByte));
      System.arraycopy(arrayOfByte, 0, localObject, 0, i);
      k = i + 0;
    }
    else
    {
      k = 0;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, localObject, k, paramInt2);
    int n = k + paramInt2;
    j = n;
    if (!this.d)
    {
      paramArrayOfByte = this.g.a(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2);
      System.arraycopy(paramArrayOfByte, 0, localObject, n, paramArrayOfByte.length);
      j = n + paramArrayOfByte.length;
    }
    paramInt1 = j;
    paramInt2 = 0;
    for (;;)
    {
      j = k;
      if (paramInt2 > m) {
        break;
      }
      localObject[paramInt1] = ((byte)(byte)m);
      paramInt2++;
      paramInt1++;
    }
    while (j < paramInt1)
    {
      this.e.d((byte[])localObject, j, (byte[])localObject, j);
      j += i;
    }
    if (this.d)
    {
      paramArrayOfByte = this.g.a(paramLong, paramShort, (byte[])localObject, 0, paramInt1);
      System.arraycopy(paramArrayOfByte, 0, localObject, paramInt1, paramArrayOfByte.length);
    }
    return (byte[])localObject;
  }
  
  protected int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 + paramInt2;
    int j = paramArrayOfByte[(i - 1)];
    int k = (j & 0xFF) + 1;
    if (((m1.K(this.a)) && (k > paramInt3)) || (paramInt4 + k > paramInt2))
    {
      paramInt2 = 0;
      paramInt1 = 0;
      k = 0;
      paramInt4 = paramInt1;
    }
    else
    {
      paramInt2 = i - k;
      paramInt1 = 0;
    }
    for (;;)
    {
      paramInt3 = paramInt2 + 1;
      paramInt1 = (byte)(paramArrayOfByte[paramInt2] ^ j | paramInt1);
      if (paramInt3 >= i)
      {
        paramInt3 = k;
        paramInt2 = paramInt3;
        paramInt4 = paramInt1;
        if (paramInt1 != 0)
        {
          paramInt2 = paramInt3;
          break;
        }
        paramArrayOfByte = this.b;
        while (paramInt2 < 256)
        {
          paramInt4 = (byte)(paramArrayOfByte[paramInt2] ^ j | paramInt4);
          paramInt2++;
        }
        paramArrayOfByte[0] = ((byte)(byte)(paramArrayOfByte[0] ^ paramInt4));
        return k;
      }
      paramInt2 = paramInt3;
    }
  }
  
  protected int d(SecureRandom paramSecureRandom, int paramInt)
  {
    return Math.min(e(paramSecureRandom.nextInt()), paramInt);
  }
  
  protected int e(int paramInt)
  {
    if (paramInt == 0) {
      return 32;
    }
    int i = 0;
    while ((paramInt & 0x1) == 0)
    {
      i++;
      paramInt >>= 1;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */