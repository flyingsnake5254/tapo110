package org.mp4parser.aspectj.lang;

public class NoAspectBoundException
  extends RuntimeException
{
  Throwable cause;
  
  public NoAspectBoundException() {}
  
  public NoAspectBoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\mp4parser\aspectj\lang\NoAspectBoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */