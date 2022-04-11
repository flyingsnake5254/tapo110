package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingTemperatureRecords;
import java.util.List;
import kotlin.jvm.internal.j;

public final class TRVTemperatureRecordsResult
{
  public static final Companion Companion = new Companion(null);
  public static final int INVALID_VAL = -200;
  public static final int STATUS_HEATING = 2;
  public static final int STATUS_OFF = 0;
  public static final int STATUS_WORKING = 1;
  @c("current_temp")
  private final float currentTemp;
  @c("local_time")
  private final long localTime;
  private final List<Integer> today;
  @c("today_status")
  private final List<Integer> todayStatus;
  private final List<Integer> yesterday;
  @c("yesterday_status")
  private final List<Integer> yesterdayStatus;
  
  public TRVTemperatureRecordsResult(long paramLong, float paramFloat, List<Integer> paramList1, List<Integer> paramList2, List<Integer> paramList3, List<Integer> paramList4)
  {
    this.localTime = paramLong;
    this.currentTemp = paramFloat;
    this.today = paramList1;
    this.todayStatus = paramList2;
    this.yesterday = paramList3;
    this.yesterdayStatus = paramList4;
  }
  
  public TRVTemperatureRecordsResult(ThingTemperatureRecords paramThingTemperatureRecords)
  {
    this(paramThingTemperatureRecords.getLocalTime(), paramThingTemperatureRecords.getCurrentTemp(), paramThingTemperatureRecords.getToday(), paramThingTemperatureRecords.getTodayStatus(), paramThingTemperatureRecords.getYesterday(), paramThingTemperatureRecords.getYesterdayStatus());
  }
  
  public final long component1()
  {
    return this.localTime;
  }
  
  public final float component2()
  {
    return this.currentTemp;
  }
  
  public final List<Integer> component3()
  {
    return this.today;
  }
  
  public final List<Integer> component4()
  {
    return this.todayStatus;
  }
  
  public final List<Integer> component5()
  {
    return this.yesterday;
  }
  
  public final List<Integer> component6()
  {
    return this.yesterdayStatus;
  }
  
  public final TRVTemperatureRecordsResult copy(long paramLong, float paramFloat, List<Integer> paramList1, List<Integer> paramList2, List<Integer> paramList3, List<Integer> paramList4)
  {
    return new TRVTemperatureRecordsResult(paramLong, paramFloat, paramList1, paramList2, paramList3, paramList4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TRVTemperatureRecordsResult))
      {
        paramObject = (TRVTemperatureRecordsResult)paramObject;
        if ((this.localTime == ((TRVTemperatureRecordsResult)paramObject).localTime) && (Float.compare(this.currentTemp, ((TRVTemperatureRecordsResult)paramObject).currentTemp) == 0) && (j.a(this.today, ((TRVTemperatureRecordsResult)paramObject).today)) && (j.a(this.todayStatus, ((TRVTemperatureRecordsResult)paramObject).todayStatus)) && (j.a(this.yesterday, ((TRVTemperatureRecordsResult)paramObject).yesterday)) && (j.a(this.yesterdayStatus, ((TRVTemperatureRecordsResult)paramObject).yesterdayStatus))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final float getCurrentTemp()
  {
    return this.currentTemp;
  }
  
  public final long getLocalTime()
  {
    return this.localTime;
  }
  
  public final List<Integer> getToday()
  {
    return this.today;
  }
  
  public final List<Integer> getTodayStatus()
  {
    return this.todayStatus;
  }
  
  public final List<Integer> getYesterday()
  {
    return this.yesterday;
  }
  
  public final List<Integer> getYesterdayStatus()
  {
    return this.yesterdayStatus;
  }
  
  public int hashCode()
  {
    long l = this.localTime;
    int i = (int)(l ^ l >>> 32);
    int j = Float.floatToIntBits(this.currentTemp);
    List localList = this.today;
    int k = 0;
    int m;
    if (localList != null) {
      m = localList.hashCode();
    } else {
      m = 0;
    }
    localList = this.todayStatus;
    int n;
    if (localList != null) {
      n = localList.hashCode();
    } else {
      n = 0;
    }
    localList = this.yesterday;
    int i1;
    if (localList != null) {
      i1 = localList.hashCode();
    } else {
      i1 = 0;
    }
    localList = this.yesterdayStatus;
    if (localList != null) {
      k = localList.hashCode();
    }
    return ((((i * 31 + j) * 31 + m) * 31 + n) * 31 + i1) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRVTemperatureRecordsResult(localTime=");
    localStringBuilder.append(this.localTime);
    localStringBuilder.append(", currentTemp=");
    localStringBuilder.append(this.currentTemp);
    localStringBuilder.append(", today=");
    localStringBuilder.append(this.today);
    localStringBuilder.append(", todayStatus=");
    localStringBuilder.append(this.todayStatus);
    localStringBuilder.append(", yesterday=");
    localStringBuilder.append(this.yesterday);
    localStringBuilder.append(", yesterdayStatus=");
    localStringBuilder.append(this.yesterdayStatus);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\result\TRVTemperatureRecordsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */