package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class ArmScheduleInfo
{
  private final String friday;
  private final String monday;
  private final String saturday;
  private final String sunday;
  private final String thursday;
  private final String tuesday;
  private final String wednesday;
  
  public ArmScheduleInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.monday = paramString1;
    this.tuesday = paramString2;
    this.wednesday = paramString3;
    this.thursday = paramString4;
    this.friday = paramString5;
    this.saturday = paramString6;
    this.sunday = paramString7;
  }
  
  public final String component1()
  {
    return this.monday;
  }
  
  public final String component2()
  {
    return this.tuesday;
  }
  
  public final String component3()
  {
    return this.wednesday;
  }
  
  public final String component4()
  {
    return this.thursday;
  }
  
  public final String component5()
  {
    return this.friday;
  }
  
  public final String component6()
  {
    return this.saturday;
  }
  
  public final String component7()
  {
    return this.sunday;
  }
  
  public final ArmScheduleInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return new ArmScheduleInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ArmScheduleInfo))
      {
        paramObject = (ArmScheduleInfo)paramObject;
        if ((j.a(this.monday, ((ArmScheduleInfo)paramObject).monday)) && (j.a(this.tuesday, ((ArmScheduleInfo)paramObject).tuesday)) && (j.a(this.wednesday, ((ArmScheduleInfo)paramObject).wednesday)) && (j.a(this.thursday, ((ArmScheduleInfo)paramObject).thursday)) && (j.a(this.friday, ((ArmScheduleInfo)paramObject).friday)) && (j.a(this.saturday, ((ArmScheduleInfo)paramObject).saturday)) && (j.a(this.sunday, ((ArmScheduleInfo)paramObject).sunday))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
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
    String str = this.monday;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.tuesday;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.wednesday;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.thursday;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.friday;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.saturday;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.sunday;
    if (str != null) {
      i = str.hashCode();
    }
    return (((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArmScheduleInfo(monday=");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ArmScheduleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */