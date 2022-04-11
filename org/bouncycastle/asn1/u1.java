package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

class u1
  implements Enumeration
{
  private i a;
  private Object b;
  
  public u1(byte[] paramArrayOfByte)
  {
    this.a = new i(paramArrayOfByte, true);
    this.b = a();
  }
  
  private Object a()
  {
    try
    {
      q localq = this.a.t();
      return localq;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed DER construction: ");
      localStringBuilder.append(localIOException);
      throw new ASN1ParsingException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public boolean hasMoreElements()
  {
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object nextElement()
  {
    Object localObject = this.b;
    this.b = a();
    return localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */