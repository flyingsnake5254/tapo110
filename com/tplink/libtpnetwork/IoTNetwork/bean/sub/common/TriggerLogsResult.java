package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class TriggerLogsResult
{
  private List<TriggerLog> logs;
  @c("start_id")
  private int startId;
  private int sum;
  
  public TriggerLogsResult(int paramInt1, int paramInt2, List<TriggerLog> paramList)
  {
    this.startId = paramInt1;
    this.sum = paramInt2;
    this.logs = paramList;
  }
  
  public final int component1()
  {
    return this.startId;
  }
  
  public final int component2()
  {
    return this.sum;
  }
  
  public final List<TriggerLog> component3()
  {
    return this.logs;
  }
  
  public final TriggerLogsResult copy(int paramInt1, int paramInt2, List<TriggerLog> paramList)
  {
    j.e(paramList, "logs");
    return new TriggerLogsResult(paramInt1, paramInt2, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TriggerLogsResult))
      {
        paramObject = (TriggerLogsResult)paramObject;
        if ((this.startId == ((TriggerLogsResult)paramObject).startId) && (this.sum == ((TriggerLogsResult)paramObject).sum) && (j.a(this.logs, ((TriggerLogsResult)paramObject).logs))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<TriggerLog> getLogs()
  {
    return this.logs;
  }
  
  public final int getStartId()
  {
    return this.startId;
  }
  
  public final int getSum()
  {
    return this.sum;
  }
  
  public int hashCode()
  {
    int i = this.startId;
    int j = this.sum;
    List localList = this.logs;
    int k;
    if (localList != null) {
      k = localList.hashCode();
    } else {
      k = 0;
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public final void setLogs(List<TriggerLog> paramList)
  {
    j.e(paramList, "<set-?>");
    this.logs = paramList;
  }
  
  public final void setStartId(int paramInt)
  {
    this.startId = paramInt;
  }
  
  public final void setSum(int paramInt)
  {
    this.sum = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TriggerLogsResult(startId=");
    localStringBuilder.append(this.startId);
    localStringBuilder.append(", sum=");
    localStringBuilder.append(this.sum);
    localStringBuilder.append(", logs=");
    localStringBuilder.append(this.logs);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\TriggerLogsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */