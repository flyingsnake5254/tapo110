package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class YearlyPlaybackFilter
{
  private final List<Integer> channel;
  @c("end_date")
  private final String endDate;
  @c("start_date")
  private final String startDate;
  
  public YearlyPlaybackFilter(String paramString1, String paramString2)
  {
    this(null, paramString1, paramString2, 1, null);
  }
  
  public YearlyPlaybackFilter(List<Integer> paramList, String paramString1, String paramString2)
  {
    this.channel = paramList;
    this.startDate = paramString1;
    this.endDate = paramString2;
  }
  
  public final List<Integer> component1()
  {
    return this.channel;
  }
  
  public final String component2()
  {
    return this.startDate;
  }
  
  public final String component3()
  {
    return this.endDate;
  }
  
  public final YearlyPlaybackFilter copy(List<Integer> paramList, String paramString1, String paramString2)
  {
    j.e(paramList, "channel");
    j.e(paramString1, "startDate");
    j.e(paramString2, "endDate");
    return new YearlyPlaybackFilter(paramList, paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof YearlyPlaybackFilter))
      {
        paramObject = (YearlyPlaybackFilter)paramObject;
        if ((j.a(this.channel, ((YearlyPlaybackFilter)paramObject).channel)) && (j.a(this.startDate, ((YearlyPlaybackFilter)paramObject).startDate)) && (j.a(this.endDate, ((YearlyPlaybackFilter)paramObject).endDate))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<Integer> getChannel()
  {
    return this.channel;
  }
  
  public final String getEndDate()
  {
    return this.endDate;
  }
  
  public final String getStartDate()
  {
    return this.startDate;
  }
  
  public int hashCode()
  {
    Object localObject = this.channel;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.startDate;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.endDate;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("YearlyPlaybackFilter(channel=");
    localStringBuilder.append(this.channel);
    localStringBuilder.append(", startDate=");
    localStringBuilder.append(this.startDate);
    localStringBuilder.append(", endDate=");
    localStringBuilder.append(this.endDate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\YearlyPlaybackFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */