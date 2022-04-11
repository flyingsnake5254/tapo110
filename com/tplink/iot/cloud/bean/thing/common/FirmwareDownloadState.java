package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

public class FirmwareDownloadState
{
  public static final int UPGRADE_STATE_CHECK_FAIL = -1002;
  public static final int UPGRADE_STATE_DOWNLOADED = 3;
  public static final int UPGRADE_STATE_DOWNLOADED_BUT_NOT_TRANSFERRED = 4;
  public static final int UPGRADE_STATE_DOWNLOADING = 2;
  public static final int UPGRADE_STATE_DOWNLOAD_FAIL = -1001;
  public static final int UPGRADE_STATE_IDLE = 0;
  public static final int UPGRADE_STATE_PREPARING = 1;
  public static final int UPGRADE_STATE_TRANSFER_FAIL = -1003;
  @c("download_progress")
  private int downloadProgress;
  @c("reboot_time")
  private int rebootTime;
  private int status;
  @c("upgrade_time")
  private int upgradeTime;
  
  public int getDownloadProgress()
  {
    return this.downloadProgress;
  }
  
  public int getRebootTime()
  {
    return this.rebootTime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public int getUpgradeTime()
  {
    return this.upgradeTime;
  }
  
  public void setDownloadProgress(int paramInt)
  {
    this.downloadProgress = paramInt;
  }
  
  public void setRebootTime(int paramInt)
  {
    this.rebootTime = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setUpgradeTime(int paramInt)
  {
    this.upgradeTime = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\FirmwareDownloadState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */