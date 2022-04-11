package com.tplink.iot.dailysummary.network.bean.common;

import java.util.List;

public class SummaryClip
{
  private Long createdTime;
  private String eventLocalTime;
  private List<SummaryImage> image;
  private Long splitPoint;
  private String uuid;
  private List<SummaryClipVideo> video;
  
  public Long getCreatedTime()
  {
    return this.createdTime;
  }
  
  public String getEventLocalTime()
  {
    return this.eventLocalTime;
  }
  
  public List<SummaryImage> getImage()
  {
    return this.image;
  }
  
  public Long getSplitPoint()
  {
    return this.splitPoint;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public List<SummaryClipVideo> getVideo()
  {
    return this.video;
  }
  
  public void setCreatedTime(Long paramLong)
  {
    this.createdTime = paramLong;
  }
  
  public void setEventLocalTime(String paramString)
  {
    this.eventLocalTime = paramString;
  }
  
  public void setImage(List<SummaryImage> paramList)
  {
    this.image = paramList;
  }
  
  public void setSplitPoint(Long paramLong)
  {
    this.splitPoint = paramLong;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setVideo(List<SummaryClipVideo> paramList)
  {
    this.video = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryClip{uuid='");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createdTime=");
    localStringBuilder.append(this.createdTime);
    localStringBuilder.append(", eventLocalTime='");
    localStringBuilder.append(this.eventLocalTime);
    localStringBuilder.append('\'');
    localStringBuilder.append(", splitPoint=");
    localStringBuilder.append(this.splitPoint);
    localStringBuilder.append(", video=");
    localStringBuilder.append(this.video);
    localStringBuilder.append(", image=");
    localStringBuilder.append(this.image);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\SummaryClip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */