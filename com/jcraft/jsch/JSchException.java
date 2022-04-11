package com.jcraft.jsch;

public class JSchException
  extends Exception
{
  private Throwable cause = null;
  
  public JSchException() {}
  
  public JSchException(String paramString)
  {
    super(paramString);
  }
  
  public JSchException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\JSchException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */