package com.tplink.iot.dailysummary.network.bean.common;

public class SummaryImage
{
  private long length;
  private long startOffset;
  private String uri;
  private long uriExpiresAt;
  
  public long getLength()
  {
    return this.length;
  }
  
  public long getStartOffset()
  {
    return this.startOffset;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public long getUriExpiresAt()
  {
    return this.uriExpiresAt;
  }
  
  public void setLength(long paramLong)
  {
    this.length = paramLong;
  }
  
  public void setStartOffset(long paramLong)
  {
    this.startOffset = paramLong;
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
    localStringBuilder.append("Image{uri='");
    localStringBuilder.append(this.uri);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startOffset=");
    localStringBuilder.append(this.startOffset);
    localStringBuilder.append(", length=");
    localStringBuilder.append(this.length);
    localStringBuilder.append(", uriExpiresAt=");
    localStringBuilder.append(this.uriExpiresAt);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\SummaryImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */