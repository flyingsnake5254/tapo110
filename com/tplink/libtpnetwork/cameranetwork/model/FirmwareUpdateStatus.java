package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class FirmwareUpdateStatus
{
  @c("lastUpgradingSuccess")
  private final boolean lastUpgradingSuccess;
  @c("state")
  private final String status;
  
  public FirmwareUpdateStatus(String paramString, boolean paramBoolean)
  {
    this.status = paramString;
    this.lastUpgradingSuccess = paramBoolean;
  }
  
  public final String component1()
  {
    return this.status;
  }
  
  public final boolean component2()
  {
    return this.lastUpgradingSuccess;
  }
  
  public final FirmwareUpdateStatus copy(String paramString, boolean paramBoolean)
  {
    j.e(paramString, "status");
    return new FirmwareUpdateStatus(paramString, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FirmwareUpdateStatus))
      {
        paramObject = (FirmwareUpdateStatus)paramObject;
        if ((j.a(this.status, ((FirmwareUpdateStatus)paramObject).status)) && (this.lastUpgradingSuccess == ((FirmwareUpdateStatus)paramObject).lastUpgradingSuccess)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getLastUpgradingSuccess()
  {
    return this.lastUpgradingSuccess;
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
    int j = this.lastUpgradingSuccess;
    int k = j;
    if (j != 0) {
      k = 1;
    }
    return i * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FirmwareUpdateStatus(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", lastUpgradingSuccess=");
    localStringBuilder.append(this.lastUpgradingSuccess);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\FirmwareUpdateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */