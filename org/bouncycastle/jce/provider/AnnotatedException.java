package org.bouncycastle.jce.provider;

public class AnnotatedException
  extends Exception
{
  private Throwable _underlyingException;
  
  public AnnotatedException(String paramString)
  {
    this(paramString, null);
  }
  
  public AnnotatedException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._underlyingException = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this._underlyingException;
  }
  
  Throwable getUnderlyingException()
  {
    return this._underlyingException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\AnnotatedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */