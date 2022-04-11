package org.bouncycastle.pkcs;

import java.io.IOException;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n2.b;
import org.bouncycastle.asn1.q;

public class a
{
  private static org.bouncycastle.asn1.n2.a[] a = new org.bouncycastle.asn1.n2.a[0];
  private b b;
  
  public a(b paramb)
  {
    this.b = paramb;
  }
  
  public a(byte[] paramArrayOfByte)
    throws IOException
  {
    this(a(paramArrayOfByte));
  }
  
  private static b a(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = b.f(q.i(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public b b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return b().equals(((a)paramObject).b());
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pkcs\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */