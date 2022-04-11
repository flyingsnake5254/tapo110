package com.tplink.iot.dailysummary.network.bean.result;

import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import java.util.List;

public class SummaryClipInfoResult
{
  private List<SummaryClip> clipList;
  private long clipSize;
  private String date;
  private long duration;
  private int status;
  private String uuid;
  
  public List<SummaryClip> getClipList()
  {
    return this.clipList;
  }
  
  public long getClipSize()
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
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public void setClipList(List<SummaryClip> paramList)
  {
    this.clipList = paramList;
  }
  
  public void setClipSize(long paramLong)
  {
    this.clipSize = paramLong;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryClipInfoResult{uuid='");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.date);
    localStringBuilder.append('\'');
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", clipSize=");
    localStringBuilder.append(this.clipSize);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", clipList=");
    localStringBuilder.append(this.clipList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\result\SummaryClipInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */