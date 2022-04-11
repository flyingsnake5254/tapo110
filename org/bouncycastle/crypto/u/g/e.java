package org.bouncycastle.crypto.u.g;

import org.bouncycastle.util.a;
import org.bouncycastle.util.f;

public class e
  implements c
{
  private byte[] a;
  private long[][] b;
  
  public void a(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = this.b[(paramArrayOfByte[15] & 0xFF)];
    long l1 = arrayOfLong[0];
    long l2 = arrayOfLong[1];
    for (int i = 14; i >= 0; i--)
    {
      arrayOfLong = this.b[(paramArrayOfByte[i] & 0xFF)];
      long l3 = l2 << 56;
      l2 = (l2 >>> 8 | l1 << 56) ^ arrayOfLong[1];
      l1 = l1 >>> 8 ^ arrayOfLong[0] ^ l3 ^ l3 >>> 1 ^ l3 >>> 2 ^ l3 >>> 7;
    }
    f.l(l1, paramArrayOfByte, 0);
    f.l(l2, paramArrayOfByte, 8);
  }
  
  public void init(byte[] paramArrayOfByte)
  {
    long[][] arrayOfLong = this.b;
    int i = 2;
    if (arrayOfLong == null) {
      this.b = new long['Ā'][2];
    } else if (a.c(this.a, paramArrayOfByte)) {
      return;
    }
    paramArrayOfByte = a.g(paramArrayOfByte);
    this.a = paramArrayOfByte;
    d.b(paramArrayOfByte, this.b[1]);
    paramArrayOfByte = this.b;
    d.g(paramArrayOfByte[1], paramArrayOfByte[1]);
    while (i < 256)
    {
      paramArrayOfByte = this.b;
      d.d(paramArrayOfByte[(i >> 1)], paramArrayOfByte[i]);
      paramArrayOfByte = this.b;
      d.o(paramArrayOfByte[i], paramArrayOfByte[1], paramArrayOfByte[(i + 1)]);
      i += 2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */