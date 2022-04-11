package org.bouncycastle.crypto.prng;

public class c
  implements g
{
  private static long a = 10L;
  private long b;
  private long c;
  private org.bouncycastle.crypto.g d;
  private byte[] e;
  private byte[] f;
  
  public c(org.bouncycastle.crypto.g paramg)
  {
    this.d = paramg;
    this.f = new byte[paramg.e()];
    this.c = 1L;
    this.e = new byte[paramg.e()];
    this.b = 1L;
  }
  
  private void d()
  {
    g(this.f);
    long l = this.c;
    this.c = (1L + l);
    e(l);
    f(this.f);
  }
  
  private void e(long paramLong)
  {
    for (int i = 0; i != 8; i++)
    {
      this.d.c((byte)(int)paramLong);
      paramLong >>>= 8;
    }
  }
  
  private void f(byte[] paramArrayOfByte)
  {
    this.d.doFinal(paramArrayOfByte, 0);
  }
  
  private void g(byte[] paramArrayOfByte)
  {
    this.d.update(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void h()
  {
    long l = this.b;
    this.b = (1L + l);
    e(l);
    g(this.e);
    g(this.f);
    f(this.e);
    if (this.b % a == 0L) {
      d();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      g(paramArrayOfByte);
      g(this.f);
      f(this.f);
      return;
    }
    finally {}
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    i(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void c(long paramLong)
  {
    try
    {
      e(paramLong);
      g(this.f);
      f(this.f);
      return;
    }
    finally {}
  }
  
  public void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      h();
      int i = 0;
      int k;
      for (int j = paramInt1;; j = k)
      {
        k = j;
        if (k == paramInt2 + paramInt1) {
          break;
        }
        j = i;
        if (i == this.e.length)
        {
          h();
          j = 0;
        }
        paramArrayOfByte[k] = ((byte)this.e[j]);
        k++;
        i = j + 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */