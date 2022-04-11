package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class RecordPlanInfo
{
  private String enabled;
  private String friday;
  private String monday;
  private String saturday;
  private String sunday;
  private String thursday;
  private String tuesday;
  private String wednesday;
  
  public RecordPlanInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.enabled = paramString1;
    this.monday = paramString2;
    this.tuesday = paramString3;
    this.wednesday = paramString4;
    this.thursday = paramString5;
    this.friday = paramString6;
    this.saturday = paramString7;
    this.sunday = paramString8;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final String component2()
  {
    return this.monday;
  }
  
  public final String component3()
  {
    return this.tuesday;
  }
  
  public final String component4()
  {
    return this.wednesday;
  }
  
  public final String component5()
  {
    return this.thursday;
  }
  
  public final String component6()
  {
    return this.friday;
  }
  
  public final String component7()
  {
    return this.saturday;
  }
  
  public final String component8()
  {
    return this.sunday;
  }
  
  public final RecordPlanInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    j.e(paramString1, "enabled");
    return new RecordPlanInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RecordPlanInfo))
      {
        paramObject = (RecordPlanInfo)paramObject;
        if ((j.a(this.enabled, ((RecordPlanInfo)paramObject).enabled)) && (j.a(this.monday, ((RecordPlanInfo)paramObject).monday)) && (j.a(this.tuesday, ((RecordPlanInfo)paramObject).tuesday)) && (j.a(this.wednesday, ((RecordPlanInfo)paramObject).wednesday)) && (j.a(this.thursday, ((RecordPlanInfo)paramObject).thursday)) && (j.a(this.friday, ((RecordPlanInfo)paramObject).friday)) && (j.a(this.saturday, ((RecordPlanInfo)paramObject).saturday)) && (j.a(this.sunday, ((RecordPlanInfo)paramObject).sunday))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getFriday()
  {
    return this.friday;
  }
  
  public final String getMonday()
  {
    return this.monday;
  }
  
  public final String getSaturday()
  {
    return this.saturday;
  }
  
  public final String getSunday()
  {
    return this.sunday;
  }
  
  public final String getThursday()
  {
    return this.thursday;
  }
  
  public final String getTuesday()
  {
    return this.tuesday;
  }
  
  public final String getWednesday()
  {
    return this.wednesday;
  }
  
  public int hashCode()
  {
    String str = this.enabled;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.monday;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.tuesday;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.wednesday;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.thursday;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.friday;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.saturday;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = this.sunday;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i;
  }
  
  public final void setEnabled(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.enabled = paramString;
  }
  
  public final void setFriday(String paramString)
  {
    this.friday = paramString;
  }
  
  public final void setMonday(String paramString)
  {
    this.monday = paramString;
  }
  
  public final void setSaturday(String paramString)
  {
    this.saturday = paramString;
  }
  
  public final void setSunday(String paramString)
  {
    this.sunday = paramString;
  }
  
  public final void setThursday(String paramString)
  {
    this.thursday = paramString;
  }
  
  public final void setTuesday(String paramString)
  {
    this.tuesday = paramString;
  }
  
  public final void setWednesday(String paramString)
  {
    this.wednesday = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordPlanInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", monday=");
    localStringBuilder.append(this.monday);
    localStringBuilder.append(", tuesday=");
    localStringBuilder.append(this.tuesday);
    localStringBuilder.append(", wednesday=");
    localStringBuilder.append(this.wednesday);
    localStringBuilder.append(", thursday=");
    localStringBuilder.append(this.thursday);
    localStringBuilder.append(", friday=");
    localStringBuilder.append(this.friday);
    localStringBuilder.append(", saturday=");
    localStringBuilder.append(this.saturday);
    localStringBuilder.append(", sunday=");
    localStringBuilder.append(this.sunday);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\RecordPlanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */