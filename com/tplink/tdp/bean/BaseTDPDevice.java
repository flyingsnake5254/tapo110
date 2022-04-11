package com.tplink.tdp.bean;

import b.d.c0.m.d.a;
import b.d.c0.m.d.c;
import com.tplink.tdp.tlv.adapter.IPAdapter;

public abstract class BaseTDPDevice
{
  @a(IPAdapter.class)
  @c(1)
  protected String ip;
  @c(2)
  protected String mac;
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\bean\BaseTDPDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */