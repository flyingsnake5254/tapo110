package com.tplink.iot.dailysummary.network.bean.common;

public class Summary
{
  private int clipSize;
  private String date;
  private long duration;
  private String eventId;
  private SummaryImage image;
  private int status;
  private String uuid;
  private SummaryVideo video;
  
  public int getClipSize()
  {
    return this.clipSize;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public SummaryImage getImage()
  {
    return this.image;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public SummaryVideo getVideo()
  {
    return this.video;
  }
  
  public void setClipSize(int paramInt)
  {
    this.clipSize = paramInt;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
  
  public void setImage(SummaryImage paramSummaryImage)
  {
    this.image = paramSummaryImage;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setVideo(SummaryVideo paramSummaryVideo)
  {
    this.video = paramSummaryVideo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Summary{uuid='");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.date);
    localStringBuilder.append('\'');
    localStringBuilder.append(", video=");
    localStringBuilder.append(this.video);
    localStringBuilder.append(", image=");
    localStringBuilder.append(this.image);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", eventId='");
    localStringBuilder.append(this.eventId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clipSize=");
    localStringBuilder.append(this.clipSize);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\Summary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */