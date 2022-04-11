package org.bouncycastle.operator;

public class OperatorException
  extends Exception
{
  private Throwable cause;
  
  public OperatorException(String paramString)
  {
    super(paramString);
  }
  
  public OperatorException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\operator\OperatorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */