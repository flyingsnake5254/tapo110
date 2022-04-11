package com.tplink.iot.dailysummary.network.bean.common;

public class SummaryVideo
{
  private long duration;
  private String m3u8;
  private String resolution;
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
  
  public String getResolution()
  {
    return this.resolution;
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
  
  public void setResolution(String paramString)
  {
    this.resolution = paramString;
  }
  
  public void setUri(String paramString)
  {
    this.uri = paramString;
  }
  
  public void setUriExpiresAt(long paramLong)
  {
    this.uriExpiresAt = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Video{uri='");
    localStringBuilder.append(this.uri);
    localStringBuilder.append('\'');
    localStringBuilder.append(", m3u8='");
    localStringBuilder.append(this.m3u8);
    localStringBuilder.append('\'');
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", resolution='");
    localStringBuilder.append(this.resolution);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uriExpiresAt=");
    localStringBuilder.append(this.uriExpiresAt);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\SummaryVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */