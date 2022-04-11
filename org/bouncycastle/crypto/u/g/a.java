package org.bouncycastle.crypto.u.g;

public class a
  implements b
{
  private long[] a;
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    long[] arrayOfLong1 = d.h();
    if (paramLong > 0L)
    {
      long[] arrayOfLong2 = org.bouncycastle.util.a.j(this.a);
      long l;
      do
      {
        if ((1L & paramLong) != 0L) {
          d.f(arrayOfLong1, arrayOfLong2);
        }
        d.i(arrayOfLong2, arrayOfLong2);
        l = paramLong >>> 1;
        paramLong = l;
      } while (l > 0L);
    }
    d.a(arrayOfLong1, paramArrayOfByte);
  }
  
  public void init(byte[] paramArrayOfByte)
  {
    this.a = d.c(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */