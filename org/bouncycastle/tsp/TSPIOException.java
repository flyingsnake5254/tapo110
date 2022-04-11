package org.bouncycastle.tsp;

import java.io.IOException;

public class TSPIOException
  extends IOException
{
  Throwable underlyingException;
  
  public TSPIOException(String paramString)
  {
    super(paramString);
  }
  
  public TSPIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.underlyingException = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.underlyingException;
  }
  
  public Exception getUnderlyingException()
  {
    return (Exception)this.underlyingException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\tsp\TSPIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */