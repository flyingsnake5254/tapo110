package com.tplink.libtpnetwork.cameranetwork.bean;

import android.text.TextUtils;
import com.google.gson.q.c;

public class DeviceAvatarFeatureInfo
{
  @c("avatarName")
  private String avatarName;
  @c("isDefaultAvatarName")
  private Boolean isDefaultAvatarName;
  
  public DeviceAvatarFeatureInfo() {}
  
  public DeviceAvatarFeatureInfo(Boolean paramBoolean, String paramString)
  {
    this.isDefaultAvatarName = paramBoolean;
    this.avatarName = paramString;
  }
  
  public DeviceAvatarFeatureInfo clone()
  {
    DeviceAvatarFeatureInfo localDeviceAvatarFeatureInfo = new DeviceAvatarFeatureInfo();
    localDeviceAvatarFeatureInfo.setDefaultAvatarName(isDefaultAvatarName());
    localDeviceAvatarFeatureInfo.setAvatarName(getAvatarName());
    return localDeviceAvatarFeatureInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (DeviceAvatarFeatureInfo)paramObject;
      Object localObject = this.isDefaultAvatarName;
      if (localObject != null ? !((Boolean)localObject).equals(((DeviceAvatarFeatureInfo)paramObject).isDefaultAvatarName) : ((DeviceAvatarFeatureInfo)paramObject).isDefaultAvatarName != null) {
        return false;
      }
      localObject = this.avatarName;
      paramObject = ((DeviceAvatarFeatureInfo)paramObject).avatarName;
      if (localObject != null) {
        bool = ((String)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAvatarName()
  {
    if (TextUtils.isEmpty(this.avatarName)) {
      return "Home";
    }
    return this.avatarName;
  }
  
  String getInnerUseAvatarName()
  {
    return this.avatarName;
  }
  
  public int hashCode()
  {
    Object localObject = this.isDefaultAvatarName;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((Boolean)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = this.avatarName;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    }
    return j * 31 + i;
  }
  
  public Boolean isDefaultAvatarName()
  {
    return this.isDefaultAvatarName;
  }
  
  public void mergeFrom(DeviceAvatarFeatureInfo paramDeviceAvatarFeatureInfo)
  {
    if (paramDeviceAvatarFeatureInfo.isDefaultAvatarName() != null) {
      setDefaultAvatarName(paramDeviceAvatarFeatureInfo.isDefaultAvatarName());
    }
    if (paramDeviceAvatarFeatureInfo.getAvatarName() != null) {
      setAvatarName(paramDeviceAvatarFeatureInfo.getInnerUseAvatarName());
    }
  }
  
  public void setAvatarName(String paramString)
  {
    this.avatarName = paramString;
  }
  
  public void setDefaultAvatarName(Boolean paramBoolean)
  {
    this.isDefaultAvatarName = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAvatarFeatureInfo{isDefaultAvatarName=");
    localStringBuilder.append(this.isDefaultAvatarName);
    localStringBuilder.append(", avatarName='");
    localStringBuilder.append(this.avatarName);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\DeviceAvatarFeatureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */