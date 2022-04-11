package org.bouncycastle.cms;

import java.io.IOException;

public class CMSStreamException
  extends IOException
{
  private final Throwable underlying;
  
  CMSStreamException(String paramString)
  {
    super(paramString);
    this.underlying = null;
  }
  
  CMSStreamException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.underlying = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.underlying;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cms\CMSStreamException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */