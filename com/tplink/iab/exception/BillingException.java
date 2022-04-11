package com.tplink.iab.exception;

public class BillingException
  extends Exception
{
  private static final long serialVersionUID = 3335837619990195688L;
  public int errorCode;
  public String msg;
  
  public BillingException(String paramString)
  {
    this.msg = paramString;
  }
  
  public BillingException(String paramString, int paramInt)
  {
    this.msg = paramString;
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\exception\BillingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */