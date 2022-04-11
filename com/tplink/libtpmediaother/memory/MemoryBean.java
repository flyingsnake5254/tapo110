package com.tplink.libtpmediaother.memory;

import java.io.Serializable;

public class MemoryBean
  implements Serializable
{
  private String deviceAlias;
  private String deviceAvatarUrl;
  private long groupId;
  private long id;
  private boolean isMark;
  private String locationName;
  private String thumbnailPath;
  private long timestamp;
  private int videoLength;
  private String videoPath;
  
  public MemoryBean clone()
  {
    MemoryBean localMemoryBean = new MemoryBean();
    localMemoryBean.setId(this.id);
    localMemoryBean.setGroupId(this.groupId);
    localMemoryBean.setDeviceAvatarUrl(this.deviceAvatarUrl);
    localMemoryBean.setDeviceAlias(this.deviceAlias);
    localMemoryBean.setMark(this.isMark);
    localMemoryBean.setTimestamp(this.timestamp);
    localMemoryBean.setVideoPath(this.videoPath);
    localMemoryBean.setThumbnailPath(this.thumbnailPath);
    localMemoryBean.setVideoLength(this.videoLength);
    localMemoryBean.setLocationName(this.locationName);
    return localMemoryBean;
  }
  
  public String getDeviceAlias()
  {
    return this.deviceAlias;
  }
  
  public String getDeviceAvatarUrl()
  {
    return this.deviceAvatarUrl;
  }
  
  public long getGroupId()
  {
    return this.groupId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getLocationName()
  {
    return this.locationName;
  }
  
  public String getThumbnailPath()
  {
    return this.thumbnailPath;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getVideoLength()
  {
    return this.videoLength;
  }
  
  public String getVideoPath()
  {
    return this.videoPath;
  }
  
  public boolean isMark()
  {
    return this.isMark;
  }
  
  public void setDeviceAlias(String paramString)
  {
    this.deviceAlias = paramString;
  }
  
  public void setDeviceAvatarUrl(String paramString)
  {
    this.deviceAvatarUrl = paramString;
  }
  
  public void setGroupId(long paramLong)
  {
    this.groupId = paramLong;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setLocationName(String paramString)
  {
    this.locationName = paramString;
  }
  
  public void setMark(boolean paramBoolean)
  {
    this.isMark = paramBoolean;
  }
  
  public void setThumbnailPath(String paramString)
  {
    this.thumbnailPath = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void setVideoLength(int paramInt)
  {
    this.videoLength = paramInt;
  }
  
  public void setVideoPath(String paramString)
  {
    this.videoPath = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\memory\MemoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */