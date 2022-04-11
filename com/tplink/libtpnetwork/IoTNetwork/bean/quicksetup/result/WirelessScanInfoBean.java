package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.io.Serializable;

public class WirelessScanInfoBean
  implements Serializable
{
  @c("key_type")
  private String keyType;
  @c("signal_level")
  private int signalLevel;
  @b(Base64TypeAdapter.class)
  private String ssid;
  
  public String getKeyType()
  {
    return this.keyType;
  }
  
  public int getSignalLevel()
  {
    return this.signalLevel;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public void setKeyType(String paramString)
  {
    this.keyType = paramString;
  }
  
  public void setSignalLevel(int paramInt)
  {
    this.signalLevel = paramInt;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\WirelessScanInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */