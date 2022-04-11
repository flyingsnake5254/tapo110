package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class ConnectAndStatus
{
  private final ConnectResult connectResult;
  private final ConnectStatus connectStatus;
  
  public ConnectAndStatus(ConnectResult paramConnectResult, ConnectStatus paramConnectStatus)
  {
    this.connectResult = paramConnectResult;
    this.connectStatus = paramConnectStatus;
  }
  
  public ConnectAndStatus(Wrappers paramWrappers)
  {
    this((ConnectResult)Model.typeCast(paramWrappers, ConnectResult.class), (ConnectStatus)Model.typeCast(paramWrappers, ConnectStatus.class));
  }
  
  public final ConnectResult component1()
  {
    return this.connectResult;
  }
  
  public final ConnectStatus component2()
  {
    return this.connectStatus;
  }
  
  public final ConnectAndStatus copy(ConnectResult paramConnectResult, ConnectStatus paramConnectStatus)
  {
    return new ConnectAndStatus(paramConnectResult, paramConnectStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ConnectAndStatus))
      {
        paramObject = (ConnectAndStatus)paramObject;
        if ((j.a(this.connectResult, ((ConnectAndStatus)paramObject).connectResult)) && (j.a(this.connectStatus, ((ConnectAndStatus)paramObject).connectStatus))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final ConnectResult getConnectResult()
  {
    return this.connectResult;
  }
  
  public final ConnectStatus getConnectStatus()
  {
    return this.connectStatus;
  }
  
  public int hashCode()
  {
    Object localObject = this.connectResult;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.connectStatus;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectAndStatus(connectResult=");
    localStringBuilder.append(this.connectResult);
    localStringBuilder.append(", connectStatus=");
    localStringBuilder.append(this.connectStatus);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ConnectAndStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */