package com.tplink.iot.cloud.bean.group.common;

import com.google.gson.i;
import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.util.List;
import java.util.Map;

public class GroupInfo
{
  private String avatarUrl;
  private Long ctime;
  private i defaultStates;
  private String familyId;
  private String id;
  private Boolean isCommon;
  private String name;
  private Boolean onOffGradually;
  private i presets;
  private String roomId;
  @b(MapJsonAdapter.class)
  private Map<String, Object> stateDesired;
  private List<String> thingNames;
  
  public GroupInfo() {}
  
  public GroupInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, Map<String, Object> paramMap, i parami1, Boolean paramBoolean1, i parami2, Boolean paramBoolean2, Long paramLong)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.avatarUrl = paramString3;
    this.familyId = paramString4;
    this.roomId = paramString5;
    this.thingNames = paramList;
    this.stateDesired = paramMap;
    this.presets = parami1;
    this.isCommon = paramBoolean1;
    this.defaultStates = parami2;
    this.onOffGradually = paramBoolean2;
    this.ctime = paramLong;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public Boolean getCommon()
  {
    return this.isCommon;
  }
  
  public Long getCtime()
  {
    return this.ctime;
  }
  
  public i getDefaultStates()
  {
    return this.defaultStates;
  }
  
  public String getFamilyId()
  {
    return this.familyId;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Boolean getOnOffGradually()
  {
    return this.onOffGradually;
  }
  
  public i getPresets()
  {
    return this.presets;
  }
  
  public String getRoomId()
  {
    return this.roomId;
  }
  
  public Map<String, Object> getStateDesired()
  {
    return this.stateDesired;
  }
  
  public List<String> getThingNames()
  {
    return this.thingNames;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setCommon(Boolean paramBoolean)
  {
    this.isCommon = paramBoolean;
  }
  
  public void setCtime(Long paramLong)
  {
    this.ctime = paramLong;
  }
  
  public void setDefaultStates(i parami)
  {
    this.defaultStates = parami;
  }
  
  public void setFamilyId(String paramString)
  {
    this.familyId = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOnOffGradually(Boolean paramBoolean)
  {
    this.onOffGradually = paramBoolean;
  }
  
  public void setPresets(i parami)
  {
    this.presets = parami;
  }
  
  public void setRoomId(String paramString)
  {
    this.roomId = paramString;
  }
  
  public void setStateDesired(Map<String, Object> paramMap)
  {
    this.stateDesired = paramMap;
  }
  
  public void setThingNames(List<String> paramList)
  {
    this.thingNames = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\group\common\GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */