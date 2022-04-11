package com.tplink.iot.cloud.bean.cloudvideo.common;

import java.util.List;

public class CloudVideo
{
  private long createdTime;
  private String eventLocalTime;
  private List<CloudVideoThumbnail> image;
  private String uuid;
  private List<PartCloudVideo> video;
  
  public long getCreatedTime()
  {
    return this.createdTime;
  }
  
  public String getEventLocalTime()
  {
    return this.eventLocalTime;
  }
  
  public List<PartCloudVideo> getPartCloudVideos()
  {
    return this.video;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public List<CloudVideoThumbnail> getVideoThumbnails()
  {
    return this.image;
  }
  
  public void setCreatedTime(long paramLong)
  {
    this.createdTime = paramLong;
  }
  
  public void setEventLocalTime(String paramString)
  {
    this.eventLocalTime = paramString;
  }
  
  public void setPartCloudVideos(List<PartCloudVideo> paramList)
  {
    this.video = paramList;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setVideoThumbnails(List<CloudVideoThumbnail> paramList)
  {
    this.image = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\CloudVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */