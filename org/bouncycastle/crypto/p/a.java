package org.bouncycastle.crypto.p;

import org.bouncycastle.crypto.h;
import org.bouncycastle.util.e;

public abstract class a
  implements h, e
{
  private final byte[] a = new byte[4];
  private int b;
  private long c;
  
  protected a()
  {
    this.b = 0;
  }
  
  protected a(a parama)
  {
    n(parama);
  }
  
  public void c(byte paramByte)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    arrayOfByte[i] = ((byte)paramByte);
    if (j == arrayOfByte.length)
    {
      r(arrayOfByte, 0);
      this.b = 0;
    }
    this.c += 1L;
  }
  
  public int k()
  {
    return 64;
  }
  
  protected void n(a parama)
  {
    byte[] arrayOfByte = parama.a;
    System.arraycopy(arrayOfByte, 0, this.a, 0, arrayOfByte.length);
    this.b = parama.b;
    this.c = parama.c;
  }
  
  public void o()
  {
    long l = this.c;
    byte b1 = Byte.MIN_VALUE;
    for (byte b2 = b1;; b2 = b1)
    {
      c(b2);
      if (this.b == 0) {
        break;
      }
      b1 = 0;
    }
    q(l << 3);
    p();
  }
  
  protected abstract void p();
  
  protected abstract void q(long paramLong);
  
  protected abstract void r(byte[] paramArrayOfByte, int paramInt);
  
  public void reset()
  {
    this.c = 0L;
    this.b = 0;
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = this.a;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = ((byte)0);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = Math.max(0, paramInt2);
    paramInt2 = i;
    byte[] arrayOfByte;
    int m;
    if (this.b != 0) {
      for (paramInt2 = 0; paramInt2 < j; paramInt2 = i)
      {
        arrayOfByte = this.a;
        int k = this.b;
        m = k + 1;
        this.b = m;
        i = paramInt2 + 1;
        arrayOfByte[k] = ((byte)paramArrayOfByte[(paramInt2 + paramInt1)]);
        if (m == 4)
        {
          r(arrayOfByte, 0);
          this.b = 0;
          paramInt2 = i;
          break;
        }
      }
    }
    for (i = paramInt2;; i = m + 4)
    {
      m = i;
      i = m;
      if (m >= (j - paramInt2 & 0xFFFFFFFC) + paramInt2) {
        break;
      }
      r(paramArrayOfByte, paramInt1 + m);
    }
    while (i < j)
    {
      arrayOfByte = this.a;
      paramInt2 = this.b;
      this.b = (paramInt2 + 1);
      arrayOfByte[paramInt2] = ((byte)paramArrayOfByte[(i + paramInt1)]);
      i++;
    }
    this.c += j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */