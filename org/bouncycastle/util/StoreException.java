package org.bouncycastle.util;

public class StoreException
  extends RuntimeException
{
  private Throwable _e;
  
  public StoreException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._e = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this._e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\StoreException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */