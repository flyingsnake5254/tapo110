package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;

public class c
  extends q
{
  private static final byte[] c = { -1 };
  private static final byte[] d = { 0 };
  public static final c f = new c(false);
  public static final c q = new c(true);
  private final byte[] x;
  
  public c(boolean paramBoolean)
  {
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = c;
    } else {
      arrayOfByte = d;
    }
    this.x = arrayOfByte;
  }
  
  c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 1)
    {
      if (paramArrayOfByte[0] == 0) {
        this.x = d;
      } else if ((paramArrayOfByte[0] & 0xFF) == 255) {
        this.x = c;
      } else {
        this.x = a.g(paramArrayOfByte);
      }
      return;
    }
    throw new IllegalArgumentException("byte value should have 1 byte in it");
  }
  
  static c m(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 1)
    {
      if (paramArrayOfByte[0] == 0) {
        return f;
      }
      if ((paramArrayOfByte[0] & 0xFF) == 255) {
        return q;
      }
      return new c(paramArrayOfByte);
    }
    throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
  }
  
  public static c n(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof c)))
    {
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = (c)q.i((byte[])paramObject);
          return (c)paramObject;
        }
        catch (IOException localIOException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("failed to construct boolean from byte[]: ");
          ((StringBuilder)paramObject).append(localIOException.getMessage());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (c)paramObject;
  }
  
  public static c o(x paramx, boolean paramBoolean)
  {
    paramx = paramx.o();
    if ((!paramBoolean) && (!(paramx instanceof c))) {
      return m(((n)paramx).o());
    }
    return n(paramx);
  }
  
  public static c p(boolean paramBoolean)
  {
    c localc;
    if (paramBoolean) {
      localc = q;
    } else {
      localc = f;
    }
    return localc;
  }
  
  protected boolean f(q paramq)
  {
    boolean bool1 = paramq instanceof c;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool3 = bool2;
      if (this.x[0] == ((c)paramq).x[0]) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(1, this.x);
  }
  
  int h()
  {
    return 3;
  }
  
  public int hashCode()
  {
    return this.x[0];
  }
  
  boolean j()
  {
    return false;
  }
  
  public boolean q()
  {
    byte[] arrayOfByte = this.x;
    boolean bool = false;
    if (arrayOfByte[0] != 0) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    String str;
    if (this.x[0] != 0) {
      str = "TRUE";
    } else {
      str = "FALSE";
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */