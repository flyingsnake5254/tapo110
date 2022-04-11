package com.tplink.libtpnetwork.IoTNetwork;

import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.io.Serializable;
import java.util.Map;

public class ThingContext
  extends TPBaseDeviceContext<ALIoTDevice>
  implements Serializable
{
  private ThingModel thingModel;
  
  public ThingContext(com.tplink.cloud.context.b paramb, BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.tcAccountContext = paramb;
    if (paramBaseALIoTDevice != null) {
      this.deviceIdMD5 = paramBaseALIoTDevice.getDeviceIdMD5();
    }
    if ((paramBaseALIoTDevice instanceof ALIoTDevice)) {
      this.iotDevice = ((ALIoTDevice)paramBaseALIoTDevice);
    }
  }
  
  public ThingContext(String paramString, com.tplink.cloud.context.b paramb)
  {
    super(paramString, paramb);
  }
  
  private String getThingGatewayUrl()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingGatewayUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getLang()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    if (localBaseALIoTDevice != null) {
      return ((ALIoTDevice)localBaseALIoTDevice).getLang();
    }
    return null;
  }
  
  public ThingDevice getThingDevice()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingDevice();
    } else {
      localObject = null;
    }
    return (ThingDevice)localObject;
  }
  
  public String getThingGatewayUrlV2()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingGatewayUrlV2();
    } else {
      localObject = null;
    }
    if (!b.d.w.h.b.d((CharSequence)localObject)) {
      return (String)localObject;
    }
    return getThingGatewayUrl();
  }
  
  public ThingModel getThingModel()
  {
    return this.thingModel;
  }
  
  public String getThingModelId()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingModelId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingName()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public ThingSetting getThingSetting()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingSetting();
    } else {
      localObject = null;
    }
    return (ThingSetting)localObject;
  }
  
  public ThingShadow getThingShadow()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingShadow();
    } else {
      localObject = null;
    }
    return (ThingShadow)localObject;
  }
  
  public long getThingShadowVersion()
  {
    ThingShadow localThingShadow = getThingShadow();
    if (localThingShadow != null) {
      return localThingShadow.getVersion();
    }
    return 0L;
  }
  
  public String getThingUrl()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getThingUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public boolean isDataFromThing()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    if (localBaseALIoTDevice != null) {
      return ((ALIoTDevice)localBaseALIoTDevice).isDataFromThing();
    }
    return false;
  }
  
  public boolean isThingOnline()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (((ALIoTDevice)localBaseALIoTDevice).isThingOnline())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setDataFromThing(boolean paramBoolean)
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    if (localBaseALIoTDevice != null) {
      ((ALIoTDevice)localBaseALIoTDevice).setDataFromThing(paramBoolean);
    }
  }
  
  public void setThingModel(ThingModel paramThingModel)
  {
    this.thingModel = paramThingModel;
  }
  
  public void setThingSetting(ThingSetting paramThingSetting)
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    if (localBaseALIoTDevice != null) {
      ((ALIoTDevice)localBaseALIoTDevice).setThingSetting(paramThingSetting);
    }
  }
  
  public void setThingShadow(ThingShadow paramThingShadow)
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    if (localBaseALIoTDevice != null) {
      ((ALIoTDevice)localBaseALIoTDevice).setThingShadow(paramThingShadow);
    }
  }
  
  public void updateThingShadow(long paramLong, Map<String, Object> paramMap)
  {
    updateThingShadow(paramLong, paramMap, null);
  }
  
  public void updateThingShadow(long paramLong, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    if (localBaseALIoTDevice != null) {
      ((ALIoTDevice)localBaseALIoTDevice).updateThingShadow(paramLong, paramMap1, paramMap2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\ThingContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */