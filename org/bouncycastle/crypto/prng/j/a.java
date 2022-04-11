package org.bouncycastle.crypto.prng.j;

import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;

public class a
  implements c
{
  private byte[] a;
  private byte[] b;
  private long c;
  private org.bouncycastle.crypto.prng.d d;
  private j e;
  private int f;
  
  public a(j paramj, int paramInt, org.bouncycastle.crypto.prng.d paramd, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramInt <= d.b(paramj))
    {
      if (paramd.b() >= paramInt)
      {
        this.f = paramInt;
        this.d = paramd;
        this.e = paramj;
        paramd = org.bouncycastle.util.a.m(c(), paramArrayOfByte2, paramArrayOfByte1);
        paramj = new byte[paramj.a()];
        this.a = paramj;
        paramj = new byte[paramj.length];
        this.b = paramj;
        org.bouncycastle.util.a.u(paramj, (byte)1);
        d(paramd);
        this.c = 1L;
        return;
      }
      throw new IllegalArgumentException("Not enough entropy for security strength required");
    }
    throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
  }
  
  private byte[] c()
  {
    byte[] arrayOfByte = this.d.a();
    if (arrayOfByte.length >= (this.f + 7) / 8) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Insufficient entropy provided by entropy source");
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    e(paramArrayOfByte, (byte)0);
    if (paramArrayOfByte != null) {
      e(paramArrayOfByte, (byte)1);
    }
  }
  
  private void e(byte[] paramArrayOfByte, byte paramByte)
  {
    this.e.d(new a0(this.a));
    j localj = this.e;
    Object localObject = this.b;
    localj.update((byte[])localObject, 0, localObject.length);
    this.e.c(paramByte);
    if (paramArrayOfByte != null) {
      this.e.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    this.e.doFinal(this.a, 0);
    this.e.d(new a0(this.a));
    localObject = this.e;
    paramArrayOfByte = this.b;
    ((j)localObject).update(paramArrayOfByte, 0, paramArrayOfByte.length);
    this.e.doFinal(this.b, 0);
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int i = paramArrayOfByte1.length * 8;
    if (i <= 262144)
    {
      if (this.c > 140737488355328L) {
        return -1;
      }
      byte[] arrayOfByte1 = paramArrayOfByte2;
      if (paramBoolean)
      {
        b(paramArrayOfByte2);
        arrayOfByte1 = null;
      }
      if (arrayOfByte1 != null) {
        d(arrayOfByte1);
      }
      int j = paramArrayOfByte1.length;
      paramArrayOfByte2 = new byte[j];
      int k = paramArrayOfByte1.length / this.b.length;
      this.e.d(new a0(this.a));
      for (int m = 0; m < k; m++)
      {
        localObject = this.e;
        byte[] arrayOfByte2 = this.b;
        ((j)localObject).update(arrayOfByte2, 0, arrayOfByte2.length);
        this.e.doFinal(this.b, 0);
        localObject = this.b;
        System.arraycopy(localObject, 0, paramArrayOfByte2, localObject.length * m, localObject.length);
      }
      Object localObject = this.b;
      if (localObject.length * k < j)
      {
        this.e.update((byte[])localObject, 0, localObject.length);
        this.e.doFinal(this.b, 0);
        localObject = this.b;
        System.arraycopy(localObject, 0, paramArrayOfByte2, localObject.length * k, j - k * localObject.length);
      }
      d(arrayOfByte1);
      this.c += 1L;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
      return i;
    }
    throw new IllegalArgumentException("Number of bits per request limited to 262144");
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    d(org.bouncycastle.util.a.l(c(), paramArrayOfByte));
    this.c = 1L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */