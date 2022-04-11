package org.bouncycastle.crypto.prng.j;

import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.util.a;

public class b
  implements c
{
  private static final byte[] a = { 1 };
  private static final Hashtable b;
  private g c;
  private byte[] d;
  private byte[] e;
  private long f;
  private org.bouncycastle.crypto.prng.d g;
  private int h;
  private int i;
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    b = localHashtable;
    localHashtable.put("SHA-1", org.bouncycastle.util.d.b(440));
    localHashtable.put("SHA-224", org.bouncycastle.util.d.b(440));
    localHashtable.put("SHA-256", org.bouncycastle.util.d.b(440));
    localHashtable.put("SHA-512/256", org.bouncycastle.util.d.b(440));
    localHashtable.put("SHA-512/224", org.bouncycastle.util.d.b(440));
    localHashtable.put("SHA-384", org.bouncycastle.util.d.b(888));
    localHashtable.put("SHA-512", org.bouncycastle.util.d.b(888));
  }
  
  public b(g paramg, int paramInt, org.bouncycastle.crypto.prng.d paramd, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramInt <= d.a(paramg))
    {
      if (paramd.b() >= paramInt)
      {
        this.c = paramg;
        this.g = paramd;
        this.h = paramInt;
        this.i = ((Integer)b.get(paramg.b())).intValue();
        paramg = a.m(e(), paramArrayOfByte2, paramArrayOfByte1);
        paramd = d.c(this.c, paramg, this.i);
        this.d = paramd;
        paramg = new byte[paramd.length + 1];
        System.arraycopy(paramd, 0, paramg, 1, paramd.length);
        this.e = d.c(this.c, paramg, this.i);
        this.f = 1L;
        return;
      }
      throw new IllegalArgumentException("Not enough entropy for security strength required");
    }
    throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
  }
  
  private void c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 1;
    int k = 0;
    int m;
    while (j <= paramArrayOfByte2.length)
    {
      m = (paramArrayOfByte1[(paramArrayOfByte1.length - j)] & 0xFF) + (paramArrayOfByte2[(paramArrayOfByte2.length - j)] & 0xFF) + k;
      if (m > 255) {
        k = 1;
      } else {
        k = 0;
      }
      paramArrayOfByte1[(paramArrayOfByte1.length - j)] = ((byte)(byte)m);
      j++;
    }
    for (j = paramArrayOfByte2.length + 1; j <= paramArrayOfByte1.length; j++)
    {
      m = (paramArrayOfByte1[(paramArrayOfByte1.length - j)] & 0xFF) + k;
      if (m > 255) {
        k = 1;
      } else {
        k = 0;
      }
      paramArrayOfByte1[(paramArrayOfByte1.length - j)] = ((byte)(byte)m);
    }
  }
  
  private void d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.c.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    this.c.doFinal(paramArrayOfByte2, 0);
  }
  
  private byte[] e()
  {
    byte[] arrayOfByte = this.g.a();
    if (arrayOfByte.length >= (this.h + 7) / 8) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Insufficient entropy provided by entropy source");
  }
  
  private byte[] f(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.c.e()];
    d(paramArrayOfByte, arrayOfByte);
    return arrayOfByte;
  }
  
  private byte[] g(byte[] paramArrayOfByte, int paramInt)
  {
    int j = this.c.e();
    int k = paramInt / 8;
    int m = k / j;
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
    byte[] arrayOfByte2 = new byte[k];
    int n = this.c.e();
    paramArrayOfByte = new byte[n];
    for (paramInt = 0; paramInt <= m; paramInt++)
    {
      d(arrayOfByte1, paramArrayOfByte);
      int i1 = paramInt * n;
      int i2 = k - i1;
      j = i2;
      if (i2 > n) {
        j = n;
      }
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i1, j);
      c(arrayOfByte1, a);
    }
    return arrayOfByte2;
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int j = paramArrayOfByte1.length * 8;
    if (j <= 262144)
    {
      if (this.f > 140737488355328L) {
        return -1;
      }
      byte[] arrayOfByte1 = paramArrayOfByte2;
      if (paramBoolean)
      {
        b(paramArrayOfByte2);
        arrayOfByte1 = null;
      }
      if (arrayOfByte1 != null)
      {
        paramArrayOfByte2 = this.d;
        arrayOfByte2 = new byte[paramArrayOfByte2.length + 1 + arrayOfByte1.length];
        arrayOfByte2[0] = ((byte)2);
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, 1, paramArrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, this.d.length + 1, arrayOfByte1.length);
        paramArrayOfByte2 = f(arrayOfByte2);
        c(this.d, paramArrayOfByte2);
      }
      paramArrayOfByte2 = g(this.d, j);
      byte[] arrayOfByte2 = this.d;
      arrayOfByte1 = new byte[arrayOfByte2.length + 1];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 1, arrayOfByte2.length);
      arrayOfByte1[0] = ((byte)3);
      arrayOfByte1 = f(arrayOfByte1);
      c(this.d, arrayOfByte1);
      c(this.d, this.e);
      long l = this.f;
      int k = (byte)(int)(l >> 24);
      int m = (byte)(int)(l >> 16);
      int n = (byte)(int)(l >> 8);
      int i1 = (byte)(int)l;
      c(this.d, new byte[] { k, m, n, i1 });
      this.f += 1L;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
      return j;
    }
    throw new IllegalArgumentException("Number of bits per request limited to 262144");
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = e();
    paramArrayOfByte = a.n(a, this.d, arrayOfByte, paramArrayOfByte);
    paramArrayOfByte = d.c(this.c, paramArrayOfByte, this.i);
    this.d = paramArrayOfByte;
    arrayOfByte = new byte[paramArrayOfByte.length + 1];
    arrayOfByte[0] = ((byte)0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, paramArrayOfByte.length);
    this.e = d.c(this.c, arrayOfByte, this.i);
    this.f = 1L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */