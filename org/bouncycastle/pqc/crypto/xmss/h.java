package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

final class h
{
  private final j a;
  private final e b;
  private byte[] c;
  private byte[] d;
  
  protected h(j paramj)
  {
    Objects.requireNonNull(paramj, "params == null");
    this.a = paramj;
    int i = paramj.b();
    this.b = new e(paramj.a(), i);
    this.c = new byte[i];
    this.d = new byte[i];
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, g paramg)
  {
    int i = this.a.b();
    Objects.requireNonNull(paramArrayOfByte, "startHash == null");
    if (paramArrayOfByte.length == i)
    {
      Objects.requireNonNull(paramg, "otsHashAddress == null");
      Objects.requireNonNull(paramg.d(), "otsHashAddress byte array == null");
      int j = paramInt1 + paramInt2;
      if (j <= this.a.d() - 1)
      {
        if (paramInt2 == 0) {
          return paramArrayOfByte;
        }
        paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2 - 1, paramg);
        paramg = ((g.b)((g.b)new g.b().g(paramg.b())).h(paramg.c())).p(paramg.g()).n(paramg.e()).o(j - 1);
        paramInt1 = 0;
        Object localObject = (g)((g.b)paramg.f(0)).l();
        paramg = this.b.c(this.d, ((g)localObject).d());
        localObject = (g)((g.b)((g.b)((g.b)new g.b().g(((l)localObject).b())).h(((l)localObject).c())).p(((g)localObject).g()).n(((g)localObject).e()).o(((g)localObject).f()).f(1)).l();
        localObject = this.b.c(this.d, ((g)localObject).d());
        byte[] arrayOfByte = new byte[i];
        while (paramInt1 < i)
        {
          arrayOfByte[paramInt1] = ((byte)(byte)(paramArrayOfByte[paramInt1] ^ localObject[paramInt1]));
          paramInt1++;
        }
        return this.b.a(paramg, arrayOfByte);
      }
      throw new IllegalArgumentException("max chain length must not be greater than w");
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("startHash needs to be ");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append("bytes");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  private byte[] b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.c())) {
      return this.b.c(this.c, u.p(paramInt, 32));
    }
    throw new IllegalArgumentException("index out of bounds");
  }
  
  protected e c()
  {
    return this.b;
  }
  
  protected j d()
  {
    return this.a;
  }
  
  protected k e(g paramg)
  {
    Objects.requireNonNull(paramg, "otsHashAddress == null");
    byte[][] arrayOfByte = new byte[this.a.c()][];
    for (int i = 0; i < this.a.c(); i++)
    {
      paramg = (g)((g.b)((g.b)((g.b)new g.b().g(paramg.b())).h(paramg.c())).p(paramg.g()).n(i).o(paramg.f()).f(paramg.a())).l();
      arrayOfByte[i] = a(b(i), 0, this.a.d() - 1, paramg);
    }
    return new k(this.a, arrayOfByte);
  }
  
  protected byte[] f()
  {
    return u.c(this.d);
  }
  
  protected byte[] g(byte[] paramArrayOfByte, g paramg)
  {
    paramg = (g)((g.b)((g.b)new g.b().g(paramg.b())).h(paramg.c())).p(paramg.g()).l();
    return this.b.c(paramArrayOfByte, paramg.d());
  }
  
  void h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Objects.requireNonNull(paramArrayOfByte1, "secretKeySeed == null");
    if (paramArrayOfByte1.length == this.a.b())
    {
      Objects.requireNonNull(paramArrayOfByte2, "publicSeed == null");
      if (paramArrayOfByte2.length == this.a.b())
      {
        this.c = paramArrayOfByte1;
        this.d = paramArrayOfByte2;
        return;
      }
      throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
    }
    throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */