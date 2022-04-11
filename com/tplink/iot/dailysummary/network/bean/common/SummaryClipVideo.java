package com.tplink.iot.dailysummary.network.bean.common;

public class SummaryClipVideo
{
  private Long duration;
  private String m3u8;
  private Long startTimestamp;
  private String uri;
  private Long uriExpiresAt;
  
  public Long getDuration()
  {
    return this.duration;
  }
  
  public String getM3u8()
  {
    return this.m3u8;
  }
  
  public Long getStartTimestamp()
  {
    return this.startTimestamp;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public Long getUriExpiresAt()
  {
    return this.uriExpiresAt;
  }
  
  public void setDuration(Long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setM3u8(String paramString)
  {
    this.m3u8 = paramString;
  }
  
  public void setStartTimestamp(Long paramLong)
  {
    this.startTimestamp = paramLong;
  }
  
  public void setUri(String paramString)
  {
    this.uri = paramString;
  }
  
  public void setUriExpiresAt(Long paramLong)
  {
    this.uriExpiresAt = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryClipVideo{uri='");
    localStringBuilder.append(this.uri);
    localStringBuilder.append('\'');
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", m3u8='");
    localStringBuilder.append(this.m3u8);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startTimestamp=");
    localStringBuilder.append(this.startTimestamp);
    localStringBuilder.append(", uriExpiresAt=");
    localStringBuilder.append(this.uriExpiresAt);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\SummaryClipVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */