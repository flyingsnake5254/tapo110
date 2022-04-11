package com.jcraft.jsch;

public class SftpException
  extends Exception
{
  private Throwable cause = null;
  public int id;
  
  public SftpException(int paramInt, String paramString)
  {
    super(paramString);
    this.id = paramInt;
  }
  
  public SftpException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.id = paramInt;
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append(": ");
    localStringBuilder.append(getMessage());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SftpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */