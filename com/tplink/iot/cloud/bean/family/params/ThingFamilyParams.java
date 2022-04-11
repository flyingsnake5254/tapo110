package com.tplink.iot.cloud.bean.family.params;

import java.util.List;

public class ThingFamilyParams
{
  private String familyId;
  private String roomId;
  private List<String> thingNames;
  
  public ThingFamilyParams() {}
  
  public ThingFamilyParams(String paramString1, String paramString2, List<String> paramList)
  {
    this.familyId = paramString1;
    this.roomId = paramString2;
    this.thingNames = paramList;
  }
  
  public ThingFamilyParams(String paramString, List<String> paramList)
  {
    this.familyId = paramString;
    this.thingNames = paramList;
  }
  
  public String getFamilyId()
  {
    return this.familyId;
  }
  
  public String getRoomId()
  {
    return this.roomId;
  }
  
  public List<String> getThingNames()
  {
    return this.thingNames;
  }
  
  public void setFamilyId(String paramString)
  {
    this.familyId = paramString;
  }
  
  public void setRoomId(String paramString)
  {
    this.roomId = paramString;
  }
  
  public void setThingNames(List<String> paramList)
  {
    this.thingNames = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\family\params\ThingFamilyParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */