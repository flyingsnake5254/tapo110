package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.w.b;

public final class o
  extends b
{
  private final m d;
  private final byte[] f;
  private final byte[] q;
  
  private o(b paramb)
  {
    super(false);
    Object localObject = b.a(paramb);
    this.d = ((m)localObject);
    Objects.requireNonNull(localObject, "params == null");
    int i = ((m)localObject).b();
    localObject = b.b(paramb);
    if (localObject != null)
    {
      if (localObject.length == i + i)
      {
        this.f = u.g((byte[])localObject, 0, i);
        this.q = u.g((byte[])localObject, i + 0, i);
      }
      else
      {
        throw new IllegalArgumentException("public key has wrong size");
      }
    }
    else
    {
      localObject = b.c(paramb);
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.f = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("length of root must be equal to length of digest");
        }
      }
      else {
        this.f = new byte[i];
      }
      paramb = b.d(paramb);
      if (paramb != null)
      {
        if (paramb.length == i) {
          this.q = paramb;
        } else {
          throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
        }
      }
      else {
        this.q = new byte[i];
      }
    }
  }
  
  public m b()
  {
    return this.d;
  }
  
  public byte[] c()
  {
    return u.c(this.q);
  }
  
  public byte[] d()
  {
    return u.c(this.f);
  }
  
  public byte[] e()
  {
    int i = this.d.b();
    byte[] arrayOfByte = new byte[i + i];
    u.e(arrayOfByte, this.f, 0);
    u.e(arrayOfByte, this.q, i + 0);
    return arrayOfByte;
  }
  
  public static class b
  {
    private final m a;
    private byte[] b = null;
    private byte[] c = null;
    private byte[] d = null;
    
    public b(m paramm)
    {
      this.a = paramm;
    }
    
    public o e()
    {
      return new o(this, null);
    }
    
    public b f(byte[] paramArrayOfByte)
    {
      this.c = u.c(paramArrayOfByte);
      return this;
    }
    
    public b g(byte[] paramArrayOfByte)
    {
      this.b = u.c(paramArrayOfByte);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */