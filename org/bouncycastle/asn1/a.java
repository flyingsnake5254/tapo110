package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class a
  extends q
{
  protected final boolean c;
  protected final int d;
  protected final byte[] f;
  
  a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    this.c = paramBoolean;
    this.d = paramInt;
    this.f = org.bouncycastle.util.a.g(paramArrayOfByte);
  }
  
  public static a o(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof a)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = o(q.i((byte[])paramObject));
          return (a)paramObject;
        }
        catch (IOException paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to construct object from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (a)paramObject;
  }
  
  private byte[] q(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((paramArrayOfByte[0] & 0x1F) == 31)
    {
      i = 2;
      int j = paramArrayOfByte[1] & 0xFF;
      if ((j & 0x7F) != 0) {
        for (;;)
        {
          k = i;
          if (j < 0) {
            break;
          }
          k = i;
          if ((j & 0x80) == 0) {
            break;
          }
          j = paramArrayOfByte[i] & 0xFF;
          i++;
        }
      }
      throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
    }
    int k = 1;
    int i = paramArrayOfByte.length - k + 1;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, k, arrayOfByte, 1, i - 1);
    arrayOfByte[0] = ((byte)(byte)paramInt);
    return arrayOfByte;
  }
  
  boolean f(q paramq)
  {
    boolean bool1 = paramq instanceof a;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramq = (a)paramq;
    bool1 = bool2;
    if (this.c == paramq.c)
    {
      bool1 = bool2;
      if (this.d == paramq.d)
      {
        bool1 = bool2;
        if (org.bouncycastle.util.a.c(this.f, paramq.f)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  void g(p paramp)
    throws IOException
  {
    int i;
    if (this.c) {
      i = 96;
    } else {
      i = 64;
    }
    paramp.f(i, this.d, this.f);
  }
  
  int h()
    throws IOException
  {
    return y1.b(this.d) + y1.a(this.f.length) + this.f.length;
  }
  
  public int hashCode()
  {
    return this.c ^ this.d ^ org.bouncycastle.util.a.w(this.f);
  }
  
  public boolean j()
  {
    return this.c;
  }
  
  public int m()
  {
    return this.d;
  }
  
  public byte[] n()
  {
    return org.bouncycastle.util.a.g(this.f);
  }
  
  public q p(int paramInt)
    throws IOException
  {
    if (paramInt < 31)
    {
      byte[] arrayOfByte1 = d();
      byte[] arrayOfByte2 = q(paramInt, arrayOfByte1);
      if ((arrayOfByte1[0] & 0x20) != 0) {
        arrayOfByte2[0] = ((byte)(byte)(arrayOfByte2[0] | 0x20));
      }
      return q.i(arrayOfByte2);
    }
    throw new IOException("unsupported tag number");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */