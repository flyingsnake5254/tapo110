package com.tplink.iot.cloud.bean.share.params;

public class DeviceUserRoleParams
{
  private boolean isSubThing;
  private String thingName;
  
  public DeviceUserRoleParams() {}
  
  public DeviceUserRoleParams(String paramString, boolean paramBoolean)
  {
    this.thingName = paramString;
    this.isSubThing = paramBoolean;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public boolean isSubThing()
  {
    return this.isSubThing;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\params\DeviceUserRoleParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */