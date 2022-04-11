package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.w.a0;

public class f0
  implements i0
{
  protected p0 a;
  protected int b;
  protected int c;
  protected org.bouncycastle.crypto.u.a d;
  protected org.bouncycastle.crypto.u.a e;
  protected byte[] f;
  protected byte[] g;
  protected int h;
  
  public f0(p0 paramp0, org.bouncycastle.crypto.u.a parama1, org.bouncycastle.crypto.u.a parama2, int paramInt1, int paramInt2)
    throws IOException
  {
    this(paramp0, parama1, parama2, paramInt1, paramInt2, 1);
  }
  
  f0(p0 paramp0, org.bouncycastle.crypto.u.a parama1, org.bouncycastle.crypto.u.a parama2, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (m1.P(paramp0))
    {
      this.h = paramInt3;
      if (paramInt3 != 1)
      {
        if (paramInt3 == 2)
        {
          paramInt3 = 12;
          this.c = 0;
        }
        else
        {
          throw new TlsFatalAlert((short)80);
        }
      }
      else
      {
        paramInt3 = 4;
        this.c = 8;
      }
      this.a = paramp0;
      this.b = paramInt2;
      int i = paramInt1 * 2 + paramInt3 * 2;
      byte[] arrayOfByte1 = m1.d(paramp0, i);
      Object localObject1 = new a0(arrayOfByte1, 0, paramInt1);
      int j = paramInt1 + 0;
      Object localObject2 = new a0(arrayOfByte1, j, paramInt1);
      j += paramInt1;
      paramInt1 = j + paramInt3;
      byte[] arrayOfByte2 = org.bouncycastle.util.a.s(arrayOfByte1, j, paramInt1);
      j = paramInt1 + paramInt3;
      arrayOfByte1 = org.bouncycastle.util.a.s(arrayOfByte1, paramInt1, j);
      if (j == i)
      {
        if (paramp0.isServer())
        {
          this.d = parama2;
          this.e = parama1;
          this.f = arrayOfByte1;
          this.g = arrayOfByte2;
          paramp0 = (p0)localObject1;
          localObject1 = localObject2;
          localObject2 = paramp0;
        }
        else
        {
          this.d = parama1;
          this.e = parama2;
          this.f = arrayOfByte2;
          this.g = arrayOfByte1;
        }
        paramp0 = new byte[paramInt3 + this.c];
        parama1 = this.d;
        paramInt1 = paramInt2 * 8;
        parama1.a(true, new org.bouncycastle.crypto.w.a((a0)localObject1, paramInt1, paramp0));
        this.e.a(false, new org.bouncycastle.crypto.w.a((a0)localObject2, paramInt1, paramp0));
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (d(paramInt2) >= 0)
    {
      byte[] arrayOfByte1 = this.g;
      int i = arrayOfByte1.length + this.c;
      Object localObject = new byte[i];
      int j = this.h;
      if (j != 1)
      {
        if (j == 2)
        {
          m1.E0(paramLong, (byte[])localObject, i - 8);
          for (i = 0;; i++)
          {
            arrayOfByte1 = this.g;
            if (i >= arrayOfByte1.length) {
              break;
            }
            j = localObject[i];
            localObject[i] = ((byte)(byte)(arrayOfByte1[i] ^ j));
          }
        }
        else
        {
          throw new TlsFatalAlert((short)80);
        }
      }
      else
      {
        System.arraycopy(arrayOfByte1, 0, localObject, 0, arrayOfByte1.length);
        j = this.c;
        System.arraycopy(paramArrayOfByte, paramInt1, localObject, i - j, j);
      }
      i = this.c;
      j = paramInt2 - i;
      paramInt2 = this.e.b(j);
      arrayOfByte1 = new byte[paramInt2];
      byte[] arrayOfByte2 = c(paramLong, paramShort, paramInt2);
      localObject = new org.bouncycastle.crypto.w.a(null, this.b * 8, (byte[])localObject, arrayOfByte2);
      try
      {
        this.e.a(false, (e)localObject);
        paramInt1 = this.e.c(paramArrayOfByte, paramInt1 + i, j, arrayOfByte1, 0) + 0;
        i = this.e.doFinal(arrayOfByte1, paramInt1);
        if (paramInt1 + i == paramInt2) {
          return arrayOfByte1;
        }
        throw new TlsFatalAlert((short)80);
      }
      catch (Exception paramArrayOfByte)
      {
        throw new TlsFatalAlert((short)20, paramArrayOfByte);
      }
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] b(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte1 = this.f;
    int i = arrayOfByte1.length + this.c;
    Object localObject = new byte[i];
    int j = this.h;
    if (j != 1)
    {
      if (j == 2)
      {
        m1.E0(paramLong, (byte[])localObject, i - 8);
        for (j = 0;; j++)
        {
          arrayOfByte1 = this.f;
          if (j >= arrayOfByte1.length) {
            break;
          }
          k = localObject[j];
          localObject[j] = ((byte)(byte)(arrayOfByte1[j] ^ k));
        }
      }
      throw new TlsFatalAlert((short)80);
    }
    System.arraycopy(arrayOfByte1, 0, localObject, 0, arrayOfByte1.length);
    m1.E0(paramLong, (byte[])localObject, this.f.length);
    j = this.d.b(paramInt2);
    int k = this.c;
    j = k + j;
    arrayOfByte1 = new byte[j];
    if (k != 0) {
      System.arraycopy(localObject, i - k, arrayOfByte1, 0, k);
    }
    i = this.c;
    byte[] arrayOfByte2 = c(paramLong, paramShort, paramInt2);
    localObject = new org.bouncycastle.crypto.w.a(null, this.b * 8, (byte[])localObject, arrayOfByte2);
    try
    {
      this.d.a(true, (e)localObject);
      paramInt2 = i + this.d.c(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte1, i);
      paramInt1 = this.d.doFinal(arrayOfByte1, paramInt2);
      if (paramInt2 + paramInt1 == j) {
        return arrayOfByte1;
      }
      throw new TlsFatalAlert((short)80);
    }
    catch (Exception paramArrayOfByte)
    {
      throw new TlsFatalAlert((short)80, paramArrayOfByte);
    }
  }
  
  protected byte[] c(long paramLong, short paramShort, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[13];
    m1.E0(paramLong, arrayOfByte, 0);
    m1.I0(paramShort, arrayOfByte, 8);
    m1.O0(this.a.b(), arrayOfByte, 9);
    m1.x0(paramInt, arrayOfByte, 11);
    return arrayOfByte;
  }
  
  public int d(int paramInt)
  {
    return paramInt - this.b - this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */