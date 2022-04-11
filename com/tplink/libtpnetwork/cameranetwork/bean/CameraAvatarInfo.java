package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.q.c;
import java.io.Serializable;

public class CameraAvatarInfo
  implements Cloneable, Serializable
{
  @c("avatarName")
  private String avatarName;
  @c("deviceAvatarRemoteUrl")
  private String avatarRemoteUrl;
  @c("isDefaultAvatarName")
  private Boolean isAvatarDefault;
  @c("isAvatarNameModified")
  private Boolean isAvatarNameModified;
  
  public CameraAvatarInfo clone()
  {
    CameraAvatarInfo localCameraAvatarInfo = new CameraAvatarInfo();
    localCameraAvatarInfo.avatarRemoteUrl = this.avatarRemoteUrl;
    localCameraAvatarInfo.avatarName = this.avatarName;
    localCameraAvatarInfo.isAvatarDefault = this.isAvatarDefault;
    localCameraAvatarInfo.isAvatarNameModified = this.isAvatarNameModified;
    return localCameraAvatarInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof CameraAvatarInfo))
    {
      paramObject = (CameraAvatarInfo)paramObject;
      if ((!this.avatarRemoteUrl.equals(((CameraAvatarInfo)paramObject).avatarRemoteUrl)) || (this.isAvatarDefault != ((CameraAvatarInfo)paramObject).isAvatarDefault) || (!this.avatarName.equals(((CameraAvatarInfo)paramObject).avatarName)) || (!this.isAvatarNameModified.equals(((CameraAvatarInfo)paramObject).isAvatarNameModified))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Boolean getAvatarDefault()
  {
    return this.isAvatarDefault;
  }
  
  public String getAvatarName()
  {
    return this.avatarName;
  }
  
  public Boolean getAvatarNameModified()
  {
    return this.isAvatarNameModified;
  }
  
  public String getAvatarRemoteUrl()
  {
    return this.avatarRemoteUrl;
  }
  
  public int hashCode()
  {
    Object localObject = this.avatarRemoteUrl;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = this.isAvatarDefault;
    int k;
    if (localObject != null) {
      k = ((Boolean)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = this.avatarName;
    int m;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = this.isAvatarNameModified;
    if (localObject != null) {
      i = ((Boolean)localObject).hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public void setAvatarDefault(Boolean paramBoolean)
  {
    this.isAvatarDefault = paramBoolean;
  }
  
  public void setAvatarName(String paramString)
  {
    this.avatarName = paramString;
  }
  
  public void setAvatarNameModified(Boolean paramBoolean)
  {
    this.isAvatarNameModified = paramBoolean;
  }
  
  public void setAvatarRemoteUrl(String paramString)
  {
    this.avatarRemoteUrl = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceState{, avatarRemoteUrl='");
    localStringBuilder.append(this.avatarRemoteUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAvatarDefault='");
    localStringBuilder.append(this.isAvatarDefault);
    localStringBuilder.append('\'');
    localStringBuilder.append(", avatarName='");
    localStringBuilder.append(this.avatarName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAvatarNameModified='");
    localStringBuilder.append(this.isAvatarNameModified);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\CameraAvatarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */