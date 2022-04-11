package com.tplink.libtpstreampreconnect.bean;

public class NatStatistics
{
  public static final int STATUS_FAILURE_UNKNOWN = -1;
  private int failureReason;
  private long penetrationTime;
  
  public int getFailureReason()
  {
    return this.failureReason;
  }
  
  public long getPenetrationTime()
  {
    return this.penetrationTime;
  }
  
  public void setFailureReason(int paramInt)
  {
    this.failureReason = paramInt;
  }
  
  public void setPenetrationTime(long paramLong)
  {
    this.penetrationTime = paramLong;
  }
  
  public String toString()
  {
    return "failureReason : ".concat(String.valueOf(this.failureReason)).concat("   penetrationTime : ").concat(String.valueOf(this.penetrationTime));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\NatStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */