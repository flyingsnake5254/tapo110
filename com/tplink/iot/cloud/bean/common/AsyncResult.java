package com.tplink.iot.cloud.bean.common;

import com.google.gson.i;

public class AsyncResult
{
  private int code;
  private i data;
  private String message;
  private String requestId;
  
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
  
  public String getRequestId()
  {
    return this.requestId;
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
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\common\AsyncResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */