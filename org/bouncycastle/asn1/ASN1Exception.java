package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Exception
  extends IOException
{
  private Throwable cause;
  
  ASN1Exception(String paramString)
  {
    super(paramString);
  }
  
  ASN1Exception(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\ASN1Exception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */