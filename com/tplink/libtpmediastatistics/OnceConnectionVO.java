package com.tplink.libtpmediastatistics;

import java.util.ArrayList;
import java.util.List;

public class OnceConnectionVO
{
  private long flowUsed = 0L;
  private int stopReason = StopReason.USER_CLOSE.value();
  private int success;
  private int traverseTime;
  private List<Integer> usageTime = new ArrayList();
  private int watchTime = 0;
  
  public void addUsageTime(int paramInt)
  {
    this.usageTime.add(Integer.valueOf(paramInt));
  }
  
  public long getFlowUsed()
  {
    return this.flowUsed;
  }
  
  public int getStopReason()
  {
    return this.stopReason;
  }
  
  public int getSuccess()
  {
    return this.success;
  }
  
  public int getTraverseTime()
  {
    return this.traverseTime;
  }
  
  public List<Integer> getUsageTime()
  {
    return this.usageTime;
  }
  
  public int getWatchTime()
  {
    return this.watchTime;
  }
  
  public void setFlowUsed(long paramLong)
  {
    this.flowUsed = paramLong;
  }
  
  public void setStopReason(int paramInt)
  {
    this.stopReason = paramInt;
  }
  
  public void setSuccess(int paramInt)
  {
    this.success = paramInt;
  }
  
  public void setTraverseTime(int paramInt)
  {
    this.traverseTime = paramInt;
  }
  
  public void setWatchTime(int paramInt)
  {
    this.watchTime = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\OnceConnectionVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */