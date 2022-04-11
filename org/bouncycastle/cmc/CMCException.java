package org.bouncycastle.cmc;

public class CMCException
  extends Exception
{
  private final Throwable cause;
  
  public CMCException(String paramString)
  {
    this(paramString, null);
  }
  
  public CMCException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cmc\CMCException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */