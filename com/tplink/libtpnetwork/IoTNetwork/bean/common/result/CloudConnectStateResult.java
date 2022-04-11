package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import java.io.Serializable;

public class CloudConnectStateResult
  implements Serializable
{
  public static final int STATE_CONNECTED = 0;
  public static final int STATE_CONNECTING = 2;
  public static final int STATE_DISCONNECTED = 1;
  public static final int STATE_DISCONNECTING = 3;
  private int status;
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\CloudConnectStateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */