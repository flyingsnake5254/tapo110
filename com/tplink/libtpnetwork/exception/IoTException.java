package com.tplink.libtpnetwork.exception;

public class IoTException
  extends Exception
{
  private int errCode;
  private String msg;
  
  public IoTException(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.msg = paramString;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\exception\IoTException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */