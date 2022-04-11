package com.tplink.libtpnetwork.IoTNetwork;

import com.google.gson.q.c;

public class TPIoTResponse
{
  @c("error_code")
  private int errorCode;
  @c("error_msg")
  private String errorMsg;
  private long responseTimeMils;
  private String result;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public long getResponseTimeMils()
  {
    return this.responseTimeMils;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }
  
  public void setResponseTimeMils(long paramLong)
  {
    this.responseTimeMils = paramLong;
  }
  
  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\TPIoTResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */