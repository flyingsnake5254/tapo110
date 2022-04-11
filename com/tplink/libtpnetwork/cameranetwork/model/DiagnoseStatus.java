package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class DiagnoseStatus
{
  private final String status;
  
  public DiagnoseStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public final String component1()
  {
    return this.status;
  }
  
  public final DiagnoseStatus copy(String paramString)
  {
    j.e(paramString, "status");
    return new DiagnoseStatus(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DiagnoseStatus))
      {
        paramObject = (DiagnoseStatus)paramObject;
        if (j.a(this.status, ((DiagnoseStatus)paramObject).status)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    String str = this.status;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiagnoseStatus(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DiagnoseStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */