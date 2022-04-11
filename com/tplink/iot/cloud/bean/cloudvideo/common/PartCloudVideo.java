package com.tplink.iot.cloud.bean.cloudvideo.common;

public class PartCloudVideo
{
  private long duration;
  private String m3u8;
  private long startTimestamp;
  private String uri;
  private long uriExpiresAt;
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public String getM3u8()
  {
    return this.m3u8;
  }
  
  public long getStartTimestamp()
  {
    return this.startTimestamp;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public long getUriExpiresAt()
  {
    return this.uriExpiresAt;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setM3u8(String paramString)
  {
    this.m3u8 = paramString;
  }
  
  public void setStartTimestamp(long paramLong)
  {
    this.startTimestamp = paramLong;
  }
  
  public void setUri(String paramString)
  {
    this.uri = paramString;
  }
  
  public void setUriExpiresAt(long paramLong)
  {
    this.uriExpiresAt = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\PartCloudVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */