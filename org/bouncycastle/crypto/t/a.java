package org.bouncycastle.crypto.t;

import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.u.b;

public class a
  implements j
{
  private byte[] a;
  private byte[] b;
  private int c;
  private c d;
  private org.bouncycastle.crypto.v.a e;
  private int f;
  
  public a(c paramc, int paramInt)
  {
    this(paramc, paramInt, null);
  }
  
  public a(c paramc, int paramInt, org.bouncycastle.crypto.v.a parama)
  {
    if (paramInt % 8 == 0)
    {
      this.d = new b(paramc);
      this.e = parama;
      this.f = (paramInt / 8);
      this.a = new byte[paramc.getBlockSize()];
      this.b = new byte[paramc.getBlockSize()];
      this.c = 0;
      return;
    }
    throw new IllegalArgumentException("MAC size must be multiple of 8");
  }
  
  public int a()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.d.b();
  }
  
  public void c(byte paramByte)
  {
    int i = this.c;
    byte[] arrayOfByte = this.b;
    if (i == arrayOfByte.length)
    {
      this.d.d(arrayOfByte, 0, this.a, 0);
      this.c = 0;
    }
    arrayOfByte = this.b;
    i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = ((byte)paramByte);
  }
  
  public void d(e parame)
  {
    reset();
    this.d.a(true, parame);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.d.getBlockSize();
    if (this.e == null) {
      for (;;)
      {
        int j = this.c;
        if (j >= i) {
          break;
        }
        this.b[j] = ((byte)0);
        this.c = (j + 1);
      }
    }
    if (this.c == i)
    {
      this.d.d(this.b, 0, this.a, 0);
      this.c = 0;
    }
    this.e.a(this.b, this.c);
    this.d.d(this.b, 0, this.a, 0);
    System.arraycopy(this.a, 0, paramArrayOfByte, paramInt, this.f);
    reset();
    return this.f;
  }
  
  public void reset()
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = this.b;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = ((byte)0);
    }
    this.c = 0;
    this.d.reset();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      int i = this.d.getBlockSize();
      int j = this.c;
      int k = i - j;
      int m = paramInt1;
      int n = paramInt2;
      if (paramInt2 > k)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.b, j, k);
        this.d.d(this.b, 0, this.a, 0);
        this.c = 0;
        paramInt2 -= k;
        m = paramInt1 + k;
        paramInt1 = paramInt2;
        paramInt2 = m;
        for (;;)
        {
          m = paramInt2;
          n = paramInt1;
          if (paramInt1 <= i) {
            break;
          }
          this.d.d(paramArrayOfByte, paramInt2, this.a, 0);
          paramInt1 -= i;
          paramInt2 += i;
        }
      }
      System.arraycopy(paramArrayOfByte, m, this.b, this.c, n);
      this.c += n;
      return;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\t\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */