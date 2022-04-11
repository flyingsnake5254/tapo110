package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class DailyPlaybackFilter
{
  private final int channel;
  private final String date;
  @c("end_index")
  private final int endIndex;
  private final int id;
  @c("start_index")
  private final int startIndex;
  
  public DailyPlaybackFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.id = paramInt1;
    this.channel = paramInt2;
    this.startIndex = paramInt3;
    this.endIndex = paramInt4;
    this.date = paramString;
  }
  
  public DailyPlaybackFilter(int paramInt, String paramString)
  {
    this(paramInt, 0, 0, 0, paramString, 14, null);
  }
  
  public DailyPlaybackFilter(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, 0, paramInt2, paramInt3, paramString, 2, null);
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final int component2()
  {
    return this.channel;
  }
  
  public final int component3()
  {
    return this.startIndex;
  }
  
  public final int component4()
  {
    return this.endIndex;
  }
  
  public final String component5()
  {
    return this.date;
  }
  
  public final DailyPlaybackFilter copy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    j.e(paramString, "date");
    return new DailyPlaybackFilter(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DailyPlaybackFilter))
      {
        paramObject = (DailyPlaybackFilter)paramObject;
        if ((this.id == ((DailyPlaybackFilter)paramObject).id) && (this.channel == ((DailyPlaybackFilter)paramObject).channel) && (this.startIndex == ((DailyPlaybackFilter)paramObject).startIndex) && (this.endIndex == ((DailyPlaybackFilter)paramObject).endIndex) && (j.a(this.date, ((DailyPlaybackFilter)paramObject).date))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getChannel()
  {
    return this.channel;
  }
  
  public final String getDate()
  {
    return this.date;
  }
  
  public final int getEndIndex()
  {
    return this.endIndex;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final int getStartIndex()
  {
    return this.startIndex;
  }
  
  public int hashCode()
  {
    int i = this.id;
    int j = this.channel;
    int k = this.startIndex;
    int m = this.endIndex;
    String str = this.date;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DailyPlaybackFilter(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", channel=");
    localStringBuilder.append(this.channel);
    localStringBuilder.append(", startIndex=");
    localStringBuilder.append(this.startIndex);
    localStringBuilder.append(", endIndex=");
    localStringBuilder.append(this.endIndex);
    localStringBuilder.append(", date=");
    localStringBuilder.append(this.date);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DailyPlaybackFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */