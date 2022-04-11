package org.apache.commons.lang.exception;

import java.io.PrintWriter;

public abstract interface b
{
  public abstract Throwable getCause();
  
  public abstract String getMessage(int paramInt);
  
  public abstract void printPartialStackTrace(PrintWriter paramPrintWriter);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\exception\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */