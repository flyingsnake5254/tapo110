package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class BindStatus
{
  @c("err_code")
  private final String errorCode;
  private final String owner;
  @c("action_status")
  private final String status;
  
  public BindStatus(String paramString1, String paramString2, String paramString3)
  {
    this.errorCode = paramString1;
    this.status = paramString2;
    this.owner = paramString3;
  }
  
  public final String component1()
  {
    return this.errorCode;
  }
  
  public final String component2()
  {
    return this.status;
  }
  
  public final String component3()
  {
    return this.owner;
  }
  
  public final BindStatus copy(String paramString1, String paramString2, String paramString3)
  {
    return new BindStatus(paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BindStatus))
      {
        paramObject = (BindStatus)paramObject;
        if ((j.a(this.errorCode, ((BindStatus)paramObject).errorCode)) && (j.a(this.status, ((BindStatus)paramObject).status)) && (j.a(this.owner, ((BindStatus)paramObject).owner))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getErrorCode()
  {
    return this.errorCode;
  }
  
  public final String getOwner()
  {
    return this.owner;
  }
  
  public final String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    String str = this.errorCode;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.status;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.owner;
    if (str != null) {
      i = str.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BindStatus(errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", owner=");
    localStringBuilder.append(this.owner);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\BindStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */