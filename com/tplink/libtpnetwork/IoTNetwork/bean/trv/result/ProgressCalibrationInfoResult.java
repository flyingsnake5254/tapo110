package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

public final class ProgressCalibrationInfoResult
{
  public static final Companion Companion = new Companion(null);
  public static final int STATUS_CALIBRATION = 1;
  public static final int STATUS_DEVICE_ERROR = -1;
  public static final int STATUS_IDLE = 0;
  private int status;
  
  public ProgressCalibrationInfoResult(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final int component1()
  {
    return this.status;
  }
  
  public final ProgressCalibrationInfoResult copy(int paramInt)
  {
    return new ProgressCalibrationInfoResult(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ProgressCalibrationInfoResult))
      {
        paramObject = (ProgressCalibrationInfoResult)paramObject;
        if (this.status == ((ProgressCalibrationInfoResult)paramObject).status) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    return this.status;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProgressCalibrationInfoResult(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\result\ProgressCalibrationInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */