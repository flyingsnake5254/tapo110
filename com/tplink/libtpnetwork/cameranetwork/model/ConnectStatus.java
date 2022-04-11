package com.tplink.libtpnetwork.cameranetwork.model;

public final class ConnectStatus
{
  private final int status;
  
  public ConnectStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final int component1()
  {
    return this.status;
  }
  
  public final ConnectStatus copy(int paramInt)
  {
    return new ConnectStatus(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ConnectStatus))
      {
        paramObject = (ConnectStatus)paramObject;
        if (this.status == ((ConnectStatus)paramObject).status) {}
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectStatus(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ConnectStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */