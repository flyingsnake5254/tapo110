package org.bouncycastle.cert.cmp;

public class CMPException
  extends Exception
{
  private Throwable cause;
  
  public CMPException(String paramString)
  {
    super(paramString);
  }
  
  public CMPException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\cmp\CMPException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */