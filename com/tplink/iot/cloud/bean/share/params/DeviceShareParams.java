package com.tplink.iot.cloud.bean.share.params;

public class DeviceShareParams
{
  private String appCategory;
  private String deviceType;
  private boolean isSubThing;
  private long shareExpires;
  private String sharerUserName;
  private String thingName;
  
  public DeviceShareParams() {}
  
  public DeviceShareParams(String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.thingName = paramString1;
    this.sharerUserName = paramString2;
    this.shareExpires = paramLong;
    this.appCategory = paramString3;
    this.isSubThing = paramBoolean;
    this.deviceType = paramString4;
  }
  
  public String getAppCategory()
  {
    return this.appCategory;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public long getShareExpires()
  {
    return this.shareExpires;
  }
  
  public String getSharerUserName()
  {
    return this.sharerUserName;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public boolean isSubThing()
  {
    return this.isSubThing;
  }
  
  public void setAppCategory(String paramString)
  {
    this.appCategory = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setShareExpires(long paramLong)
  {
    this.shareExpires = paramLong;
  }
  
  public void setSharerUserName(String paramString)
  {
    this.sharerUserName = paramString;
  }
  
  public void setSubThing(boolean paramBoolean)
  {
    this.isSubThing = paramBoolean;
  }
  
  public void setThingName(String paramString)
  {
    this.thingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\params\DeviceShareParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */