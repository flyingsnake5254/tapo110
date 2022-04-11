package com.tplink.iot.cloud.bean.share.result;

import com.google.gson.i;

public class DeviceShareActionHandleResult
{
  private Integer code;
  private i data;
  private String message;
  private String shareId;
  
  public Integer getCode()
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
  
  public String getShareId()
  {
    return this.shareId;
  }
  
  public void setCode(Integer paramInteger)
  {
    this.code = paramInteger;
  }
  
  public void setData(i parami)
  {
    this.data = parami;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setShareId(String paramString)
  {
    this.shareId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\result\DeviceShareActionHandleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */