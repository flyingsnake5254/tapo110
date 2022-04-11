package org.bouncycastle.util;

public class StreamParsingException
  extends Exception
{
  Throwable _e;
  
  public StreamParsingException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._e = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this._e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\StreamParsingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */