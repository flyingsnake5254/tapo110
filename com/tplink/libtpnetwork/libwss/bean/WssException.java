package com.tplink.libtpnetwork.libwss.bean;

public class WssException
  extends Exception
{
  private int code;
  private String message;
  
  public WssException(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.message = paramString;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\WssException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */