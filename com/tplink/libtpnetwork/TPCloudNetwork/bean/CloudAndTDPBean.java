package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CloudAndTDPBean
  implements Serializable
{
  private IoTResult<List<TCDeviceBean>> tCDeviceListResult;
  private Map<String, ? extends TDPIoTDevice> tDPIoTDeviceMap;
  private IoTResult<List<ThingDevice>> thingDeviceListResult;
  
  public CloudAndTDPBean(IoTResult<List<TCDeviceBean>> paramIoTResult, IoTResult<List<ThingDevice>> paramIoTResult1, Map<String, ? extends TDPIoTDevice> paramMap)
  {
    this.tCDeviceListResult = paramIoTResult;
    this.thingDeviceListResult = paramIoTResult1;
    this.tDPIoTDeviceMap = paramMap;
  }
  
  public CloudAndTDPBean(IoTResult<List<TCDeviceBean>> paramIoTResult, Map<String, ? extends TDPIoTDevice> paramMap)
  {
    this.tCDeviceListResult = paramIoTResult;
    this.tDPIoTDeviceMap = paramMap;
  }
  
  public IoTResult<List<TCDeviceBean>> getTCDeviceListResult()
  {
    return this.tCDeviceListResult;
  }
  
  public Map<String, ? extends TDPIoTDevice> getTDPIoTDeviceMap()
  {
    return this.tDPIoTDeviceMap;
  }
  
  public IoTResult<List<ThingDevice>> getThingDeviceListResult()
  {
    return this.thingDeviceListResult;
  }
  
  public void setTCDeviceListResult(IoTResult<List<TCDeviceBean>> paramIoTResult)
  {
    this.tCDeviceListResult = paramIoTResult;
  }
  
  public void setTDPIoTDeviceMap(Map<String, TDPIoTDevice> paramMap)
  {
    this.tDPIoTDeviceMap = paramMap;
  }
  
  public void setThingDeviceListResult(IoTResult<List<ThingDevice>> paramIoTResult)
  {
    this.thingDeviceListResult = paramIoTResult;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\CloudAndTDPBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */