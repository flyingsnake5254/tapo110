package com.tplink.iot.cloud.bean.thing.result;

public class ThingBatchUnbindResult
{
  private int errorCode;
  private String thingName;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setThingName(String paramString)
  {
    this.thingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingBatchUnbindResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */