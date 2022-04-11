package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.g;
import org.bouncycastle.util.a;

public class z0
  implements i0
{
  protected p0 a;
  protected y0 b;
  protected y0 c;
  
  public z0(p0 paramp0)
  {
    this.a = paramp0;
    this.b = null;
    this.c = null;
  }
  
  public z0(p0 paramp0, g paramg1, g paramg2)
    throws IOException
  {
    int i = 1;
    int j;
    if (paramg1 == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramg2 != null) {
      i = 0;
    }
    if (j == i)
    {
      this.a = paramp0;
      y0 localy0 = null;
      if (paramg1 != null)
      {
        i = paramg1.e() + paramg2.e();
        byte[] arrayOfByte = m1.d(paramp0, i);
        localy0 = new y0(paramp0, paramg1, arrayOfByte, 0, paramg1.e());
        j = paramg1.e() + 0;
        paramg1 = new y0(paramp0, paramg2, arrayOfByte, j, paramg2.e());
        if (j + paramg2.e() == i) {
          paramg2 = localy0;
        } else {
          throw new TlsFatalAlert((short)80);
        }
      }
      else
      {
        paramg1 = null;
        paramg2 = localy0;
      }
      if (paramp0.isServer())
      {
        this.b = paramg1;
        this.c = paramg2;
      }
      else
      {
        this.b = paramg2;
        this.c = paramg1;
      }
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    y0 localy0 = this.c;
    if (localy0 == null) {
      return a.s(paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
    }
    int i = localy0.d();
    if (paramInt2 >= i)
    {
      i = paramInt2 - i;
      int j = paramInt1 + i;
      if (a.o(a.s(paramArrayOfByte, j, paramInt2 + paramInt1), this.c.a(paramLong, paramShort, paramArrayOfByte, paramInt1, i))) {
        return a.s(paramArrayOfByte, paramInt1, j);
      }
      throw new TlsFatalAlert((short)20);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] b(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = this.b;
    if (localObject == null) {
      return a.s(paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
    }
    localObject = ((y0)localObject).a(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[localObject.length + paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    System.arraycopy(localObject, 0, arrayOfByte, paramInt2, localObject.length);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\z0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */