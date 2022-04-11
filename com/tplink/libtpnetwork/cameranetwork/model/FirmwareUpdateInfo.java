package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class FirmwareUpdateInfo
{
  @c("connect_status")
  private final int connectStatus;
  @c("disconnect_reason")
  private final int disconnectReason;
  @c("fw_download_progress")
  private final int downloadProgress;
  @c("fw_download_status")
  private final int downloadStatus;
  @c(".name")
  private final String name;
  @c("reconnect_time")
  private final int reconnectTime;
  @c(".type")
  private final String type;
  @c("fw_verify_status")
  private final int verifyStatus;
  
  public FirmwareUpdateInfo(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    this.downloadProgress = paramInt1;
    this.type = paramString1;
    this.connectStatus = paramInt2;
    this.reconnectTime = paramInt3;
    this.name = paramString2;
    this.disconnectReason = paramInt4;
    this.downloadStatus = paramInt5;
    this.verifyStatus = paramInt6;
  }
  
  public final int component1()
  {
    return this.downloadProgress;
  }
  
  public final String component2()
  {
    return this.type;
  }
  
  public final int component3()
  {
    return this.connectStatus;
  }
  
  public final int component4()
  {
    return this.reconnectTime;
  }
  
  public final String component5()
  {
    return this.name;
  }
  
  public final int component6()
  {
    return this.disconnectReason;
  }
  
  public final int component7()
  {
    return this.downloadStatus;
  }
  
  public final int component8()
  {
    return this.verifyStatus;
  }
  
  public final FirmwareUpdateInfo copy(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    j.e(paramString1, "type");
    j.e(paramString2, "name");
    return new FirmwareUpdateInfo(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramInt4, paramInt5, paramInt6);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FirmwareUpdateInfo))
      {
        paramObject = (FirmwareUpdateInfo)paramObject;
        if ((this.downloadProgress == ((FirmwareUpdateInfo)paramObject).downloadProgress) && (j.a(this.type, ((FirmwareUpdateInfo)paramObject).type)) && (this.connectStatus == ((FirmwareUpdateInfo)paramObject).connectStatus) && (this.reconnectTime == ((FirmwareUpdateInfo)paramObject).reconnectTime) && (j.a(this.name, ((FirmwareUpdateInfo)paramObject).name)) && (this.disconnectReason == ((FirmwareUpdateInfo)paramObject).disconnectReason) && (this.downloadStatus == ((FirmwareUpdateInfo)paramObject).downloadStatus) && (this.verifyStatus == ((FirmwareUpdateInfo)paramObject).verifyStatus)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getConnectStatus()
  {
    return this.connectStatus;
  }
  
  public final int getDisconnectReason()
  {
    return this.disconnectReason;
  }
  
  public final int getDownloadProgress()
  {
    return this.downloadProgress;
  }
  
  public final int getDownloadStatus()
  {
    return this.downloadStatus;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int getReconnectTime()
  {
    return this.reconnectTime;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public final int getVerifyStatus()
  {
    return this.verifyStatus;
  }
  
  public int hashCode()
  {
    int i = this.downloadProgress;
    String str = this.type;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int m = this.connectStatus;
    int n = this.reconnectTime;
    str = this.name;
    if (str != null) {
      j = str.hashCode();
    }
    return ((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + j) * 31 + this.disconnectReason) * 31 + this.downloadStatus) * 31 + this.verifyStatus;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FirmwareUpdateInfo(downloadProgress=");
    localStringBuilder.append(this.downloadProgress);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", connectStatus=");
    localStringBuilder.append(this.connectStatus);
    localStringBuilder.append(", reconnectTime=");
    localStringBuilder.append(this.reconnectTime);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", disconnectReason=");
    localStringBuilder.append(this.disconnectReason);
    localStringBuilder.append(", downloadStatus=");
    localStringBuilder.append(this.downloadStatus);
    localStringBuilder.append(", verifyStatus=");
    localStringBuilder.append(this.verifyStatus);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\FirmwareUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */