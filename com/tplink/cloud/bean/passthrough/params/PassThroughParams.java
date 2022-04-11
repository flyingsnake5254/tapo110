package com.tplink.cloud.bean.passthrough.params;

public class PassThroughParams<T>
{
  private String deviceId;
  private T requestData;
  
  public PassThroughParams() {}
  
  public PassThroughParams(String paramString, T paramT)
  {
    this.deviceId = paramString;
    this.requestData = paramT;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public T getRequestData()
  {
    return (T)this.requestData;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setRequestData(T paramT)
  {
    this.requestData = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\passthrough\params\PassThroughParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */