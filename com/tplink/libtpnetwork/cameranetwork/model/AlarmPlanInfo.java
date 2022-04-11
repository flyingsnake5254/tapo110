package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class AlarmPlanInfo
{
  private final String enabled;
  @c("alarm_plan_1")
  private final String plan;
  
  public AlarmPlanInfo(String paramString1, String paramString2)
  {
    this.enabled = paramString1;
    this.plan = paramString2;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final String component2()
  {
    return this.plan;
  }
  
  public final AlarmPlanInfo copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "enabled");
    j.e(paramString2, "plan");
    return new AlarmPlanInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AlarmPlanInfo))
      {
        paramObject = (AlarmPlanInfo)paramObject;
        if ((j.a(this.enabled, ((AlarmPlanInfo)paramObject).enabled)) && (j.a(this.plan, ((AlarmPlanInfo)paramObject).plan))) {}
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
  
  public final String getPlan()
  {
    return this.plan;
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
    str = this.plan;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlarmPlanInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", plan=");
    localStringBuilder.append(this.plan);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AlarmPlanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */