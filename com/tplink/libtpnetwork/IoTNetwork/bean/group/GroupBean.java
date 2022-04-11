package com.tplink.libtpnetwork.IoTNetwork.bean.group;

import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.Utils.g;
import com.tplink.libtpnetwork.enumerate.EnumGroupState;
import java.io.Serializable;
import java.util.List;

public class GroupBean
  implements Serializable
{
  private GroupInfo groupInfo;
  private EnumGroupState groupState = EnumGroupState.LOADING;
  
  public GroupBean(GroupInfo paramGroupInfo)
  {
    this.groupInfo = paramGroupInfo;
  }
  
  public GroupBean(GroupInfo paramGroupInfo, EnumGroupState paramEnumGroupState)
  {
    this.groupInfo = paramGroupInfo;
    this.groupState = paramEnumGroupState;
  }
  
  public String getAvatarUrl()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if (localGroupInfo != null) {
      return localGroupInfo.getAvatarUrl();
    }
    return null;
  }
  
  public int getBrightness()
  {
    return g.b(this.groupInfo);
  }
  
  public long getCreateTime()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if ((localGroupInfo != null) && (localGroupInfo.getCtime() != null)) {
      return this.groupInfo.getCtime().longValue();
    }
    return 0L;
  }
  
  public String getFamilyId()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if (localGroupInfo != null) {
      return localGroupInfo.getFamilyId();
    }
    return null;
  }
  
  public String getGroupId()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if (localGroupInfo != null) {
      return localGroupInfo.getId();
    }
    return "";
  }
  
  public GroupInfo getGroupInfo()
  {
    return this.groupInfo;
  }
  
  public EnumGroupState getGroupState()
  {
    return this.groupState;
  }
  
  public String getName()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if (localGroupInfo != null) {
      return localGroupInfo.getName();
    }
    return "";
  }
  
  public String getRoomId()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if (localGroupInfo != null) {
      return localGroupInfo.getRoomId();
    }
    return null;
  }
  
  public List<String> getThingNames()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if (localGroupInfo != null) {
      return localGroupInfo.getThingNames();
    }
    return null;
  }
  
  public boolean isBulbGroup()
  {
    return true;
  }
  
  public boolean isCommon()
  {
    GroupInfo localGroupInfo = this.groupInfo;
    if ((localGroupInfo != null) && (localGroupInfo.getCommon() != null)) {
      return this.groupInfo.getCommon().booleanValue();
    }
    return false;
  }
  
  public boolean isDeviceOn()
  {
    return g.k(this.groupInfo);
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.groupState == EnumGroupState.EMPTY) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOffLine()
  {
    boolean bool;
    if (this.groupState == EnumGroupState.OFFLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOnline()
  {
    boolean bool;
    if (this.groupState == EnumGroupState.ONLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPartOffline()
  {
    boolean bool;
    if (this.groupState == EnumGroupState.PART_OFFLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setGroupInfo(GroupInfo paramGroupInfo)
  {
    this.groupInfo = paramGroupInfo;
  }
  
  public void setGroupState(EnumGroupState paramEnumGroupState)
  {
    this.groupState = paramEnumGroupState;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\group\GroupBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */