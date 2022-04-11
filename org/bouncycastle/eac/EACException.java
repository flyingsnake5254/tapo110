package org.bouncycastle.eac;

public class EACException
  extends Exception
{
  private Throwable cause;
  
  public EACException(String paramString)
  {
    super(paramString);
  }
  
  public EACException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\eac\EACException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */