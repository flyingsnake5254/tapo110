package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class UpnpCommStatus
{
  private Status status;
  private String timestamp;
  
  public UpnpCommStatus(Status paramStatus, String paramString)
  {
    this.status = paramStatus;
    this.timestamp = paramString;
  }
  
  public final Status component1()
  {
    return this.status;
  }
  
  public final String component2()
  {
    return this.timestamp;
  }
  
  public final UpnpCommStatus copy(Status paramStatus, String paramString)
  {
    return new UpnpCommStatus(paramStatus, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpnpCommStatus))
      {
        paramObject = (UpnpCommStatus)paramObject;
        if ((j.a(this.status, ((UpnpCommStatus)paramObject).status)) && (j.a(this.timestamp, ((UpnpCommStatus)paramObject).timestamp))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Status getStatus()
  {
    return this.status;
  }
  
  public final String getTimestamp()
  {
    return this.timestamp;
  }
  
  public int hashCode()
  {
    Object localObject = this.status;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.timestamp;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setStatus(Status paramStatus)
  {
    this.status = paramStatus;
  }
  
  public final void setTimestamp(String paramString)
  {
    this.timestamp = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpnpCommStatus(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\UpnpCommStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */