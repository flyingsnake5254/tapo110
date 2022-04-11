package org.bouncycastle.tsp;

public class TSPException
  extends Exception
{
  Throwable underlyingException;
  
  public TSPException(String paramString)
  {
    super(paramString);
  }
  
  public TSPException(String paramString, Throwable paramThrowable)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\tsp\TSPException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */