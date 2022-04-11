package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import android.annotation.SuppressLint;
import b.d.w.c.a;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingEnergyUsage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class EnergyUsageResult
{
  @c("current_power")
  private int currentPower;
  @c("local_time")
  private String localTime;
  @c("month_energy")
  private int monthEnergy;
  @c("month_runtime")
  private int monthRuntime;
  private List<Integer> past1y;
  private List<Integer> past24h;
  private List<Integer> past30d;
  private List<? extends List<Integer>> past7d;
  @c("today_energy")
  private int todayEnergy;
  @c("today_runtime")
  private int todayRuntime;
  
  public EnergyUsageResult(ThingEnergyUsage paramThingEnergyUsage)
  {
    this("", 0, 0, 0, 0, 0, l.d(), l.d(), l.d(), l.d());
    if (paramThingEnergyUsage != null)
    {
      Object localObject = paramThingEnergyUsage.getLocalTime();
      j.d(localObject, "it.localTime");
      this.localTime = ((String)localObject);
      this.todayRuntime = paramThingEnergyUsage.getTodayRuntime();
      this.monthRuntime = paramThingEnergyUsage.getMonthRuntime();
      this.todayEnergy = paramThingEnergyUsage.getTodayEnergy();
      this.monthEnergy = paramThingEnergyUsage.getMonthEnergy();
      localObject = paramThingEnergyUsage.getPast24h();
      j.d(localObject, "it.past24h");
      this.past24h = ((List)localObject);
      localObject = paramThingEnergyUsage.getPast7d();
      j.d(localObject, "it.past7d");
      this.past7d = ((List)localObject);
      localObject = paramThingEnergyUsage.getPast30d();
      j.d(localObject, "it.past30d");
      this.past30d = ((List)localObject);
      localObject = paramThingEnergyUsage.getPast1y();
      j.d(localObject, "it.past1y");
      this.past1y = ((List)localObject);
      this.currentPower = paramThingEnergyUsage.getCurrentPower();
    }
  }
  
  public EnergyUsageResult(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList1, List<? extends List<Integer>> paramList, List<Integer> paramList2, List<Integer> paramList3)
  {
    this.localTime = paramString;
    this.todayRuntime = paramInt1;
    this.monthRuntime = paramInt2;
    this.todayEnergy = paramInt3;
    this.monthEnergy = paramInt4;
    this.currentPower = paramInt5;
    this.past24h = paramList1;
    this.past7d = paramList;
    this.past30d = paramList2;
    this.past1y = paramList3;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private final long parseLocalTime()
  {
    Object localObject;
    try
    {
      localObject = new java/text/SimpleDateFormat;
      ((SimpleDateFormat)localObject).<init>("yyyy-MM-dd hh:mm:ss");
      localObject = ((SimpleDateFormat)localObject).parse(this.localTime);
      if (localObject == null)
      {
        localObject = new java/util/Date;
        ((Date)localObject).<init>();
      }
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Parse local time failed: ");
      ((StringBuilder)localObject).append(localException);
      a.d(((StringBuilder)localObject).toString());
      localObject = new Date();
    }
    return ((Date)localObject).getTime();
  }
  
  public final String component1()
  {
    return this.localTime;
  }
  
  public final List<Integer> component10()
  {
    return this.past1y;
  }
  
  public final int component2()
  {
    return this.todayRuntime;
  }
  
  public final int component3()
  {
    return this.monthRuntime;
  }
  
  public final int component4()
  {
    return this.todayEnergy;
  }
  
  public final int component5()
  {
    return this.monthEnergy;
  }
  
  public final int component6()
  {
    return this.currentPower;
  }
  
  public final List<Integer> component7()
  {
    return this.past24h;
  }
  
  public final List<List<Integer>> component8()
  {
    return this.past7d;
  }
  
  public final List<Integer> component9()
  {
    return this.past30d;
  }
  
  public final EnergyUsageResult copy(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList1, List<? extends List<Integer>> paramList, List<Integer> paramList2, List<Integer> paramList3)
  {
    j.e(paramString, "localTime");
    j.e(paramList1, "past24h");
    j.e(paramList, "past7d");
    j.e(paramList2, "past30d");
    j.e(paramList3, "past1y");
    return new EnergyUsageResult(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramList1, paramList, paramList2, paramList3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof EnergyUsageResult))
      {
        paramObject = (EnergyUsageResult)paramObject;
        if ((j.a(this.localTime, ((EnergyUsageResult)paramObject).localTime)) && (this.todayRuntime == ((EnergyUsageResult)paramObject).todayRuntime) && (this.monthRuntime == ((EnergyUsageResult)paramObject).monthRuntime) && (this.todayEnergy == ((EnergyUsageResult)paramObject).todayEnergy) && (this.monthEnergy == ((EnergyUsageResult)paramObject).monthEnergy) && (this.currentPower == ((EnergyUsageResult)paramObject).currentPower) && (j.a(this.past24h, ((EnergyUsageResult)paramObject).past24h)) && (j.a(this.past7d, ((EnergyUsageResult)paramObject).past7d)) && (j.a(this.past30d, ((EnergyUsageResult)paramObject).past30d)) && (j.a(this.past1y, ((EnergyUsageResult)paramObject).past1y))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getCurrentPower()
  {
    return this.currentPower;
  }
  
  public final String getLocalTime()
  {
    return this.localTime;
  }
  
  public final long getLocalTimeInMS()
  {
    return parseLocalTime();
  }
  
  public final int getMonthEnergy()
  {
    return this.monthEnergy;
  }
  
  public final int getMonthRuntime()
  {
    return this.monthRuntime;
  }
  
  public final List<Integer> getPast1y()
  {
    return this.past1y;
  }
  
  public final List<Integer> getPast24h()
  {
    return this.past24h;
  }
  
  public final List<Integer> getPast30d()
  {
    return this.past30d;
  }
  
  public final List<List<Integer>> getPast7d()
  {
    return this.past7d;
  }
  
  public final int getPast7dCount()
  {
    return l.m(this.past7d).size();
  }
  
  public final int getTodayEnergy()
  {
    return this.todayEnergy;
  }
  
  public final int getTodayRuntime()
  {
    return this.todayRuntime;
  }
  
  public int hashCode()
  {
    Object localObject = this.localTime;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    int k = this.todayRuntime;
    int m = this.monthRuntime;
    int n = this.todayEnergy;
    int i1 = this.monthEnergy;
    int i2 = this.currentPower;
    localObject = this.past24h;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.past7d;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.past30d;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.past1y;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i;
  }
  
  public final void setCurrentPower(int paramInt)
  {
    this.currentPower = paramInt;
  }
  
  public final void setLocalTime(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.localTime = paramString;
  }
  
  public final void setMonthEnergy(int paramInt)
  {
    this.monthEnergy = paramInt;
  }
  
  public final void setMonthRuntime(int paramInt)
  {
    this.monthRuntime = paramInt;
  }
  
  public final void setPast1y(List<Integer> paramList)
  {
    j.e(paramList, "<set-?>");
    this.past1y = paramList;
  }
  
  public final void setPast24h(List<Integer> paramList)
  {
    j.e(paramList, "<set-?>");
    this.past24h = paramList;
  }
  
  public final void setPast30d(List<Integer> paramList)
  {
    j.e(paramList, "<set-?>");
    this.past30d = paramList;
  }
  
  public final void setPast7d(List<? extends List<Integer>> paramList)
  {
    j.e(paramList, "<set-?>");
    this.past7d = paramList;
  }
  
  public final void setTodayEnergy(int paramInt)
  {
    this.todayEnergy = paramInt;
  }
  
  public final void setTodayRuntime(int paramInt)
  {
    this.todayRuntime = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EnergyUsageResult(localTime=");
    localStringBuilder.append(this.localTime);
    localStringBuilder.append(", todayRuntime=");
    localStringBuilder.append(this.todayRuntime);
    localStringBuilder.append(", monthRuntime=");
    localStringBuilder.append(this.monthRuntime);
    localStringBuilder.append(", todayEnergy=");
    localStringBuilder.append(this.todayEnergy);
    localStringBuilder.append(", monthEnergy=");
    localStringBuilder.append(this.monthEnergy);
    localStringBuilder.append(", currentPower=");
    localStringBuilder.append(this.currentPower);
    localStringBuilder.append(", past24h=");
    localStringBuilder.append(this.past24h);
    localStringBuilder.append(", past7d=");
    localStringBuilder.append(this.past7d);
    localStringBuilder.append(", past30d=");
    localStringBuilder.append(this.past30d);
    localStringBuilder.append(", past1y=");
    localStringBuilder.append(this.past1y);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\result\EnergyUsageResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */