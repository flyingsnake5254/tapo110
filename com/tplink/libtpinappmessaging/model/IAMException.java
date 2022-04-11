package com.tplink.libtpinappmessaging.model;

public class IAMException
  extends Exception
{
  private int errorCode;
  
  public IAMException(int paramInt, String paramString)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpinappmessaging\model\IAMException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */