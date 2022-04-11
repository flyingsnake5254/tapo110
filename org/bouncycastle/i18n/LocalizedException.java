package org.bouncycastle.i18n;

public class LocalizedException
  extends Exception
{
  private Throwable cause;
  protected a message;
  
  public LocalizedException(a parama) {}
  
  public LocalizedException(a parama, Throwable paramThrowable) {}
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public a getErrorMessage()
  {
    return this.message;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\i18n\LocalizedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */