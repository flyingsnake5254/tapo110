package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.crypto.w.b;
import org.bouncycastle.util.a;

public final class n
  extends b
{
  private final m d;
  private final long f;
  private final BDSStateMap p0;
  private final byte[] q;
  private final byte[] x;
  private final byte[] y;
  private final byte[] z;
  
  private n(b paramb)
  {
    super(true);
    m localm = b.a(paramb);
    this.d = localm;
    Objects.requireNonNull(localm, "params == null");
    int i = localm.b();
    Object localObject = b.b(paramb);
    long l;
    if (localObject != null)
    {
      Objects.requireNonNull(b.c(paramb), "xmss == null");
      int j = localm.c();
      int k = (j + 7) / 8;
      l = u.a((byte[])localObject, 0, k);
      this.f = l;
      if (u.l(j, l))
      {
        k += 0;
        this.q = u.g((byte[])localObject, k, i);
        k += i;
        this.x = u.g((byte[])localObject, k, i);
        k += i;
        this.y = u.g((byte[])localObject, k, i);
        k += i;
        this.z = u.g((byte[])localObject, k, i);
        i = k + i;
        localObject = u.g((byte[])localObject, i, localObject.length - i);
        try
        {
          localObject = (BDSStateMap)u.f((byte[])localObject, BDSStateMap.class);
          ((BDSStateMap)localObject).setXMSS(b.c(paramb));
          this.p0 = ((BDSStateMap)localObject);
        }
        catch (ClassNotFoundException paramb)
        {
          throw new IllegalArgumentException(paramb.getMessage(), paramb);
        }
        catch (IOException paramb)
        {
          throw new IllegalArgumentException(paramb.getMessage(), paramb);
        }
      }
      else
      {
        throw new IllegalArgumentException("index out of bounds");
      }
    }
    else
    {
      this.f = b.d(paramb);
      byte[] arrayOfByte1 = b.e(paramb);
      if (arrayOfByte1 != null)
      {
        if (arrayOfByte1.length == i) {
          this.q = arrayOfByte1;
        } else {
          throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
        }
      }
      else {
        this.q = new byte[i];
      }
      localObject = b.f(paramb);
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.x = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
        }
      }
      else {
        this.x = new byte[i];
      }
      byte[] arrayOfByte2 = b.g(paramb);
      if (arrayOfByte2 != null)
      {
        if (arrayOfByte2.length == i) {
          this.y = arrayOfByte2;
        } else {
          throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
        }
      }
      else {
        this.y = new byte[i];
      }
      localObject = b.h(paramb);
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.z = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of root needs to be equal size of digest");
        }
      }
      else {
        this.z = new byte[i];
      }
      localObject = b.i(paramb);
      if (localObject != null) {}
      for (paramb = (b)localObject;; paramb = new BDSStateMap(localm, b.d(paramb), arrayOfByte2, arrayOfByte1))
      {
        this.p0 = paramb;
        return;
        l = b.d(paramb);
        if ((!u.l(localm.c(), l)) || (arrayOfByte2 == null) || (arrayOfByte1 == null)) {
          break;
        }
      }
      this.p0 = new BDSStateMap();
    }
  }
  
  public m b()
  {
    return this.d;
  }
  
  public byte[] c()
  {
    int i = this.d.b();
    int j = (this.d.c() + 7) / 8;
    Object localObject = new byte[j + i + i + i + i];
    u.e((byte[])localObject, u.p(this.f, j), 0);
    j += 0;
    u.e((byte[])localObject, this.q, j);
    j += i;
    u.e((byte[])localObject, this.x, j);
    j += i;
    u.e((byte[])localObject, this.y, j);
    u.e((byte[])localObject, this.z, j + i);
    try
    {
      localObject = a.l((byte[])localObject, u.o(this.p0));
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error serializing bds state: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      throw new IllegalStateException(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  public static class b
  {
    private final m a;
    private long b = 0L;
    private byte[] c = null;
    private byte[] d = null;
    private byte[] e = null;
    private byte[] f = null;
    private BDSStateMap g = null;
    private byte[] h = null;
    private r i = null;
    
    public b(m paramm)
    {
      this.a = paramm;
    }
    
    public n j()
    {
      return new n(this, null);
    }
    
    public b k(BDSStateMap paramBDSStateMap)
    {
      this.g = paramBDSStateMap;
      return this;
    }
    
    public b l(long paramLong)
    {
      this.b = paramLong;
      return this;
    }
    
    public b m(byte[] paramArrayOfByte)
    {
      this.e = u.c(paramArrayOfByte);
      return this;
    }
    
    public b n(byte[] paramArrayOfByte)
    {
      this.f = u.c(paramArrayOfByte);
      return this;
    }
    
    public b o(byte[] paramArrayOfByte)
    {
      this.d = u.c(paramArrayOfByte);
      return this;
    }
    
    public b p(byte[] paramArrayOfByte)
    {
      this.c = u.c(paramArrayOfByte);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */