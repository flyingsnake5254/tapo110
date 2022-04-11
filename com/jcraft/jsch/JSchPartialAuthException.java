package com.jcraft.jsch;

class JSchPartialAuthException
  extends JSchException
{
  String methods;
  
  public JSchPartialAuthException() {}
  
  public JSchPartialAuthException(String paramString)
  {
    super(paramString);
    this.methods = paramString;
  }
  
  public String getMethods()
  {
    return this.methods;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\JSchPartialAuthException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */