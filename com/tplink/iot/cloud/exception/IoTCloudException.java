package com.tplink.iot.cloud.exception;

import com.google.gson.i;

public class IoTCloudException
  extends Exception
{
  private int code;
  private i data;
  private String message;
  
  public IoTCloudException() {}
  
  public IoTCloudException(int paramInt, String paramString)
  {
    super(paramString);
    this.code = paramInt;
    this.message = paramString;
  }
  
  public IoTCloudException(int paramInt, String paramString, i parami)
  {
    super(paramString);
    this.code = paramInt;
    this.message = paramString;
    this.data = parami;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public i getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setData(i parami)
  {
    this.data = parami;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\exception\IoTCloudException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */