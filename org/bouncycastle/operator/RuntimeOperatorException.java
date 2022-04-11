package org.bouncycastle.operator;

public class RuntimeOperatorException
  extends RuntimeException
{
  private Throwable cause;
  
  public RuntimeOperatorException(String paramString)
  {
    super(paramString);
  }
  
  public RuntimeOperatorException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\operator\RuntimeOperatorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */