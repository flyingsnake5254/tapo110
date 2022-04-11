package com.jcraft.jsch;

class JSchAuthCancelException
  extends JSchException
{
  String method;
  
  JSchAuthCancelException() {}
  
  JSchAuthCancelException(String paramString)
  {
    super(paramString);
    this.method = paramString;
  }
  
  public String getMethod()
  {
    return this.method;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\JSchAuthCancelException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */