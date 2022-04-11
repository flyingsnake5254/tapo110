package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.q.c;

public class DeviceFeatureInfo
{
  @c("deviceAvatarFeatureInfo")
  private DeviceAvatarFeatureInfo deviceAvatarFeatureInfo;
  @c("lastUpdateTimestamp")
  private transient Long lastUpdateTimestamp;
  
  public DeviceFeatureInfo clone()
  {
    DeviceFeatureInfo localDeviceFeatureInfo = new DeviceFeatureInfo();
    localDeviceFeatureInfo.setLastUpdateTimestamp(getLastUpdateTimestamp());
    DeviceAvatarFeatureInfo localDeviceAvatarFeatureInfo = this.deviceAvatarFeatureInfo;
    if (localDeviceAvatarFeatureInfo != null) {
      localDeviceFeatureInfo.setDeviceAvatarFeatureInfo(localDeviceAvatarFeatureInfo.clone());
    }
    return localDeviceFeatureInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      Object localObject = (DeviceFeatureInfo)paramObject;
      paramObject = this.lastUpdateTimestamp;
      if (paramObject != null ? !((Long)paramObject).equals(((DeviceFeatureInfo)localObject).lastUpdateTimestamp) : ((DeviceFeatureInfo)localObject).lastUpdateTimestamp != null) {
        return false;
      }
      paramObject = this.deviceAvatarFeatureInfo;
      localObject = ((DeviceFeatureInfo)localObject).deviceAvatarFeatureInfo;
      if (paramObject != null) {
        bool = ((DeviceAvatarFeatureInfo)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public DeviceAvatarFeatureInfo getDeviceAvatarFeatureInfo()
  {
    return this.deviceAvatarFeatureInfo;
  }
  
  public Long getLastUpdateTimestamp()
  {
    return this.lastUpdateTimestamp;
  }
  
  public int hashCode()
  {
    Object localObject = this.lastUpdateTimestamp;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((Long)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = this.deviceAvatarFeatureInfo;
    if (localObject != null) {
      i = ((DeviceAvatarFeatureInfo)localObject).hashCode();
    }
    return j * 31 + i;
  }
  
  public void mergeFrom(DeviceFeatureInfo paramDeviceFeatureInfo)
  {
    if (paramDeviceFeatureInfo.getLastUpdateTimestamp() != null) {
      this.lastUpdateTimestamp = paramDeviceFeatureInfo.getLastUpdateTimestamp();
    }
    if (paramDeviceFeatureInfo.getDeviceAvatarFeatureInfo() != null)
    {
      DeviceAvatarFeatureInfo localDeviceAvatarFeatureInfo = this.deviceAvatarFeatureInfo;
      if (localDeviceAvatarFeatureInfo == null) {
        this.deviceAvatarFeatureInfo = paramDeviceFeatureInfo.getDeviceAvatarFeatureInfo().clone();
      } else {
        localDeviceAvatarFeatureInfo.mergeFrom(paramDeviceFeatureInfo.getDeviceAvatarFeatureInfo());
      }
    }
  }
  
  public void setDeviceAvatarFeatureInfo(DeviceAvatarFeatureInfo paramDeviceAvatarFeatureInfo)
  {
    this.deviceAvatarFeatureInfo = paramDeviceAvatarFeatureInfo;
  }
  
  public void setLastUpdateTimestamp(Long paramLong)
  {
    this.lastUpdateTimestamp = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceFeatureInfo{lastUpdateTimestamp=");
    localStringBuilder.append(this.lastUpdateTimestamp);
    localStringBuilder.append(", deviceAvatarFeatureInfo=");
    Object localObject = this.deviceAvatarFeatureInfo;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((DeviceAvatarFeatureInfo)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\DeviceFeatureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */