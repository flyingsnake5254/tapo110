package org.apache.commons.io;

import java.io.IOException;

@Deprecated
public class IOExceptionWithCause
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public IOExceptionWithCause(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public IOExceptionWithCause(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\IOExceptionWithCause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */