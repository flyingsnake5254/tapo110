package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

public final class RemoveScaleStatusResult
{
  public static final Companion Companion = new Companion(null);
  public static final int STATUS_IDLE = 0;
  public static final int STATUS_REMOVING = 1;
  private int status;
  
  public RemoveScaleStatusResult(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final int component1()
  {
    return this.status;
  }
  
  public final RemoveScaleStatusResult copy(int paramInt)
  {
    return new RemoveScaleStatusResult(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RemoveScaleStatusResult))
      {
        paramObject = (RemoveScaleStatusResult)paramObject;
        if (this.status == ((RemoveScaleStatusResult)paramObject).status) {}
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
    localStringBuilder.append("RemoveScaleStatusResult(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\result\RemoveScaleStatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */