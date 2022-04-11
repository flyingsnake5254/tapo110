package com.tplink.iot.cloud.bean.family.common;

import com.google.gson.q.c;
import java.util.List;

public class FamilyInfo
{
  private String id;
  @c("default")
  private boolean isDefault;
  private String name;
  private List<RoomInfo> rooms;
  
  public FamilyInfo() {}
  
  public FamilyInfo(String paramString1, String paramString2)
  {
    this.id = paramString1;
    this.name = paramString2;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<RoomInfo> getRooms()
  {
    return this.rooms;
  }
  
  public boolean isDefault()
  {
    return this.isDefault;
  }
  
  public void setDefault(boolean paramBoolean)
  {
    this.isDefault = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRooms(List<RoomInfo> paramList)
  {
    this.rooms = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\family\common\FamilyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */