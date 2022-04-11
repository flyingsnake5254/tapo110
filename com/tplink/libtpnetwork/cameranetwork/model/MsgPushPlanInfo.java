package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class MsgPushPlanInfo
{
  private final String enabled;
  @c("push_plan_1")
  private final String plan;
  
  public MsgPushPlanInfo(String paramString1, String paramString2)
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
  
  public final MsgPushPlanInfo copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "enabled");
    j.e(paramString2, "plan");
    return new MsgPushPlanInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MsgPushPlanInfo))
      {
        paramObject = (MsgPushPlanInfo)paramObject;
        if ((j.a(this.enabled, ((MsgPushPlanInfo)paramObject).enabled)) && (j.a(this.plan, ((MsgPushPlanInfo)paramObject).plan))) {}
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
    localStringBuilder.append("MsgPushPlanInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", plan=");
    localStringBuilder.append(this.plan);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MsgPushPlanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */