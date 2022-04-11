package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.prng.j.c;

public class h
{
  private final SecureRandom a;
  private final e b;
  private byte[] c;
  private int d = 256;
  private int e = 256;
  
  public h(SecureRandom paramSecureRandom, boolean paramBoolean)
  {
    this.a = paramSecureRandom;
    this.b = new a(paramSecureRandom, paramBoolean);
  }
  
  public h(e parame)
  {
    this.a = null;
    this.b = parame;
  }
  
  public SP800SecureRandom a(j paramj, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new SP800SecureRandom(this.a, this.b.get(this.e), new a(paramj, paramArrayOfByte, this.c, this.d), paramBoolean);
  }
  
  public SP800SecureRandom b(g paramg, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new SP800SecureRandom(this.a, this.b.get(this.e), new b(paramg, paramArrayOfByte, this.c, this.d), paramBoolean);
  }
  
  public h c(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
    return this;
  }
  
  private static class a
    implements b
  {
    private final j a;
    private final byte[] b;
    private final byte[] c;
    private final int d;
    
    public a(j paramj, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    {
      this.a = paramj;
      this.b = paramArrayOfByte1;
      this.c = paramArrayOfByte2;
      this.d = paramInt;
    }
    
    public c a(d paramd)
    {
      return new org.bouncycastle.crypto.prng.j.a(this.a, this.d, paramd, this.c, this.b);
    }
  }
  
  private static class b
    implements b
  {
    private final g a;
    private final byte[] b;
    private final byte[] c;
    private final int d;
    
    public b(g paramg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    {
      this.a = paramg;
      this.b = paramArrayOfByte1;
      this.c = paramArrayOfByte2;
      this.d = paramInt;
    }
    
    public c a(d paramd)
    {
      return new org.bouncycastle.crypto.prng.j.b(this.a, this.d, paramd, this.c, this.b);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */