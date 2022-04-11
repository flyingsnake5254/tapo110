package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import java.io.Serializable;

public class CloudConnectStatus
  implements Serializable
{
  public static final int ERROR_CODE_CLOUD_SEND_CONNECT_FAIL = 1;
  public static final String ERROR_MSG_CLOUD_SEND_CONNECT_FAIL = "send_connect_fail";
  private int errorCode;
  private String errorMsg;
  
  public CloudConnectStatus(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\CloudConnectStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */