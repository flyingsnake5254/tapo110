package org.bouncycastle.openssl;

import java.io.IOException;

public class PEMException
  extends IOException
{
  Exception underlying;
  
  public PEMException(String paramString)
  {
    super(paramString);
  }
  
  public PEMException(String paramString, Exception paramException)
  {
    super(paramString);
    this.underlying = paramException;
  }
  
  public Throwable getCause()
  {
    return this.underlying;
  }
  
  public Exception getUnderlyingException()
  {
    return this.underlying;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\openssl\PEMException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */