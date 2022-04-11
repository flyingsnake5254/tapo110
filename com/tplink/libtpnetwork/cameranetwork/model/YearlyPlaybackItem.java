package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class YearlyPlaybackItem
{
  private final String date;
  
  public YearlyPlaybackItem(String paramString)
  {
    this.date = paramString;
  }
  
  public final String component1()
  {
    return this.date;
  }
  
  public final YearlyPlaybackItem copy(String paramString)
  {
    j.e(paramString, "date");
    return new YearlyPlaybackItem(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof YearlyPlaybackItem))
      {
        paramObject = (YearlyPlaybackItem)paramObject;
        if (j.a(this.date, ((YearlyPlaybackItem)paramObject).date)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDate()
  {
    return this.date;
  }
  
  public int hashCode()
  {
    String str = this.date;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("YearlyPlaybackItem(date=");
    localStringBuilder.append(this.date);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\YearlyPlaybackItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */