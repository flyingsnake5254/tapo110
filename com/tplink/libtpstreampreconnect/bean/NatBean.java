package com.tplink.libtpstreampreconnect.bean;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import java.util.ArrayList;
import java.util.List;

public class NatBean
{
  private String deviceIdMD5;
  private DeviceModel deviceModel;
  private String ip;
  private int port;
  private int portId;
  private List<NatStatistics> statistics;
  
  public void addStatistics(NatStatistics paramNatStatistics)
  {
    if (this.statistics == null) {
      this.statistics = new ArrayList();
    }
    this.statistics.add(paramNatStatistics);
  }
  
  public String getDeviceIdMD5()
  {
    return this.deviceIdMD5;
  }
  
  public DeviceModel getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public int getPortId()
  {
    return this.portId;
  }
  
  public List<NatStatistics> getStatistics()
  {
    return this.statistics;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setDeviceModel(DeviceModel paramDeviceModel)
  {
    this.deviceModel = paramDeviceModel;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public void setPortId(int paramInt)
  {
    this.portId = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MAC : ");
    localStringBuilder.append(this.deviceIdMD5);
    localStringBuilder.append("\nIP : ");
    localStringBuilder.append(this.ip);
    localStringBuilder.append("\nportId : ");
    localStringBuilder.append(this.portId);
    localStringBuilder.append("\nport : ");
    localStringBuilder.append(this.port);
    localStringBuilder.append("\nDeviceModel : ");
    localStringBuilder.append(this.deviceModel.value());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\NatBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */