package com.tplink.libtpmediastatistics;

import java.util.ArrayList;
import java.util.List;

public class ConnectionVO
{
  private long flowUsed = 0L;
  private Integer natTypeApp;
  private Integer natTypeDev;
  private List<Integer> stopReason = new ArrayList();
  private List<Integer> success = new ArrayList();
  private List<Integer> traverseTime = new ArrayList();
  private List<List<Integer>> usageTimes = new ArrayList();
  private int watchTime = 0;
  
  public void addData(OnceConnectionVO paramOnceConnectionVO)
  {
    this.success.add(Integer.valueOf(paramOnceConnectionVO.getSuccess()));
    this.traverseTime.add(Integer.valueOf(paramOnceConnectionVO.getTraverseTime()));
    this.stopReason.add(Integer.valueOf(paramOnceConnectionVO.getStopReason()));
    this.usageTimes.add(paramOnceConnectionVO.getUsageTime());
    doAddFlowUsed(paramOnceConnectionVO.getFlowUsed());
    doAddWatchTime(paramOnceConnectionVO.getWatchTime());
  }
  
  public void doAddFlowUsed(long paramLong)
  {
    this.flowUsed += paramLong;
  }
  
  public void doAddWatchTime(int paramInt)
  {
    this.watchTime += paramInt;
  }
  
  public long getFlowUsed()
  {
    return this.flowUsed;
  }
  
  public Integer getNatTypeApp()
  {
    return this.natTypeApp;
  }
  
  public Integer getNatTypeDev()
  {
    return this.natTypeDev;
  }
  
  public List<Integer> getStopReason()
  {
    return this.stopReason;
  }
  
  public List<Integer> getSuccess()
  {
    return this.success;
  }
  
  public List<Integer> getTraverseTime()
  {
    return this.traverseTime;
  }
  
  public List<List<Integer>> getUsageTimes()
  {
    return this.usageTimes;
  }
  
  public int getWatchTime()
  {
    return this.watchTime;
  }
  
  public void setFlowUsed(long paramLong)
  {
    this.flowUsed = paramLong;
  }
  
  public void setNatTypeApp(Integer paramInteger)
  {
    this.natTypeApp = paramInteger;
  }
  
  public void setNatTypeDev(Integer paramInteger)
  {
    this.natTypeDev = paramInteger;
  }
  
  public void setStopReason(List<Integer> paramList)
  {
    this.stopReason = paramList;
  }
  
  public void setSuccess(List<Integer> paramList)
  {
    this.success = paramList;
  }
  
  public void setTraverseTime(List<Integer> paramList)
  {
    this.traverseTime = paramList;
  }
  
  public void setWatchTime(int paramInt)
  {
    this.watchTime = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionVO{success=");
    localStringBuilder.append(this.success);
    localStringBuilder.append(", traverseTime=");
    localStringBuilder.append(this.traverseTime);
    localStringBuilder.append(", stopReason=");
    localStringBuilder.append(this.stopReason);
    localStringBuilder.append(", watchTime=");
    localStringBuilder.append(this.watchTime);
    localStringBuilder.append(", usageTimes=");
    localStringBuilder.append(this.usageTimes);
    localStringBuilder.append(", flowUsed=");
    localStringBuilder.append(this.flowUsed);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\ConnectionVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */