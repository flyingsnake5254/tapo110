package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import java.io.Serializable;

public class FwDownloadStatus
  implements Serializable
{
  public static final int ERROR_CODE_FW_ALL_SUCCESS = 6;
  public static final int ERROR_CODE_FW_DOWNLOAD_FAIL = 3;
  public static final int ERROR_CODE_FW_DOWNLOAD_PROGRESS = 4;
  public static final int ERROR_CODE_FW_SEND_DOWNLOAD_FAIL = 1;
  public static final int ERROR_CODE_FW_SEND_DOWNLOAD_SUCCESS = 2;
  public static final int ERROR_CODE_FW_START_INSTALL = 5;
  private int downloadProgress;
  private int errorCode;
  private int installTime;
  
  public FwDownloadStatus(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public int getDownloadProgress()
  {
    return this.downloadProgress;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public int getInstallTime()
  {
    return this.installTime;
  }
  
  public void setDownloadProgress(int paramInt)
  {
    this.downloadProgress = paramInt;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setInstallTime(int paramInt)
  {
    this.installTime = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\FwDownloadStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */