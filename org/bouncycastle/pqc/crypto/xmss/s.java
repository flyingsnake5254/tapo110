package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.crypto.w.b;
import org.bouncycastle.util.a;
import org.bouncycastle.util.f;

public final class s
  extends b
{
  private final r d;
  private final byte[] f;
  private final byte[] q;
  private final byte[] x;
  private final byte[] y;
  private final BDS z;
  
  private s(b paramb)
  {
    super(true);
    Object localObject1 = b.a(paramb);
    this.d = ((r)localObject1);
    Objects.requireNonNull(localObject1, "params == null");
    int i = ((r)localObject1).c();
    byte[] arrayOfByte1 = b.b(paramb);
    if (arrayOfByte1 != null)
    {
      Objects.requireNonNull(b.c(paramb), "xmss == null");
      int j = ((r)localObject1).d();
      int k = f.a(arrayOfByte1, 0);
      if (u.l(j, k))
      {
        this.f = u.g(arrayOfByte1, 4, i);
        j = 4 + i;
        this.q = u.g(arrayOfByte1, j, i);
        j += i;
        this.x = u.g(arrayOfByte1, j, i);
        j += i;
        this.y = u.g(arrayOfByte1, j, i);
        i = j + i;
        localObject1 = u.g(arrayOfByte1, i, arrayOfByte1.length - i);
        try
        {
          localObject1 = (BDS)u.f((byte[])localObject1, BDS.class);
          ((BDS)localObject1).setXMSS(b.c(paramb));
          ((BDS)localObject1).validate();
          if (((BDS)localObject1).getIndex() == k)
          {
            this.z = ((BDS)localObject1);
            return;
          }
          paramb = new java/lang/IllegalStateException;
          paramb.<init>("serialized BDS has wrong index");
          throw paramb;
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
      throw new IllegalArgumentException("index out of bounds");
    }
    arrayOfByte1 = b.d(paramb);
    if (arrayOfByte1 != null)
    {
      if (arrayOfByte1.length == i) {
        this.f = arrayOfByte1;
      } else {
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
      }
    }
    else {
      this.f = new byte[i];
    }
    byte[] arrayOfByte2 = b.e(paramb);
    if (arrayOfByte2 != null)
    {
      if (arrayOfByte2.length == i) {
        this.q = arrayOfByte2;
      } else {
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
      }
    }
    else {
      this.q = new byte[i];
    }
    arrayOfByte2 = b.f(paramb);
    if (arrayOfByte2 != null)
    {
      if (arrayOfByte2.length == i) {
        this.x = arrayOfByte2;
      } else {
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
      }
    }
    else {
      this.x = new byte[i];
    }
    Object localObject2 = b.g(paramb);
    if (localObject2 != null)
    {
      if (localObject2.length == i) {
        this.y = ((byte[])localObject2);
      } else {
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
      }
    }
    else {
      this.y = new byte[i];
    }
    localObject2 = b.h(paramb);
    if (localObject2 != null)
    {
      this.z = ((BDS)localObject2);
    }
    else
    {
      if ((b.i(paramb) < (1 << ((r)localObject1).d()) - 2) && (arrayOfByte2 != null) && (arrayOfByte1 != null)) {
        paramb = new BDS((r)localObject1, arrayOfByte2, arrayOfByte1, (g)new g.b().l(), b.i(paramb));
      } else {
        paramb = new BDS((r)localObject1, b.i(paramb));
      }
      this.z = paramb;
    }
  }
  
  public r b()
  {
    return this.d;
  }
  
  public byte[] c()
  {
    int i = this.d.c();
    Object localObject = new byte[i + 4 + i + i + i];
    f.d(this.z.getIndex(), (byte[])localObject, 0);
    u.e((byte[])localObject, this.f, 4);
    int j = 4 + i;
    u.e((byte[])localObject, this.q, j);
    j += i;
    u.e((byte[])localObject, this.x, j);
    u.e((byte[])localObject, this.y, j + i);
    try
    {
      byte[] arrayOfByte = u.o(this.z);
      return a.l((byte[])localObject, arrayOfByte);
    }
    catch (IOException localIOException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error serializing bds state: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
  }
  
  public static class b
  {
    private final r a;
    private int b = 0;
    private byte[] c = null;
    private byte[] d = null;
    private byte[] e = null;
    private byte[] f = null;
    private BDS g = null;
    private byte[] h = null;
    private r i = null;
    
    public b(r paramr)
    {
      this.a = paramr;
    }
    
    public s j()
    {
      return new s(this, null);
    }
    
    public b k(BDS paramBDS)
    {
      this.g = paramBDS;
      return this;
    }
    
    public b l(int paramInt)
    {
      this.b = paramInt;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */