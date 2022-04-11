package org.bouncycastle.asn1;

import java.io.IOException;

public class n0
  extends b
{
  public n0(e parame)
    throws IOException
  {
    super(parame.c().e("DER"), 0);
  }
  
  public n0(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public n0(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }
  
  static n0 r(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 1)
    {
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte.length - 1;
      byte[] arrayOfByte = new byte[j];
      if (j != 0) {
        System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, paramArrayOfByte.length - 1);
      }
      return new n0(arrayOfByte, i);
    }
    throw new IllegalArgumentException("truncated BIT STRING detected");
  }
  
  public static n0 s(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof n0)))
    {
      if ((paramObject instanceof m1))
      {
        paramObject = (m1)paramObject;
        return new n0(((b)paramObject).d, ((b)paramObject).f);
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (n0)q.i((byte[])paramObject);
          return (n0)paramObject;
        }
        catch (Exception localException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("encoding error in getInstance: ");
          ((StringBuilder)paramObject).append(localException.toString());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (n0)paramObject;
  }
  
  public static n0 t(x paramx, boolean paramBoolean)
  {
    paramx = paramx.o();
    if ((!paramBoolean) && (!(paramx instanceof n0))) {
      return r(((n)paramx).o());
    }
    return s(paramx);
  }
  
  void g(p paramp)
    throws IOException
  {
    byte[] arrayOfByte1 = b.m(this.d, this.f);
    int i = arrayOfByte1.length + 1;
    byte[] arrayOfByte2 = new byte[i];
    arrayOfByte2[0] = ((byte)(byte)q());
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, i - 1);
    paramp.g(3, arrayOfByte2);
  }
  
  int h()
  {
    return y1.a(this.d.length + 1) + 1 + this.d.length + 1;
  }
  
  boolean j()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */