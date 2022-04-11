package com.tplink.libtpnetwork.cameranetwork;

import androidx.annotation.Nullable;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.io.Serializable;

public class TPCameraDeviceContext
  extends TPBaseDeviceContext<ALCameraDevice>
  implements Serializable
{
  private ThingModel thingModel;
  
  public TPCameraDeviceContext(b paramb, BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.tcAccountContext = paramb;
    if (paramBaseALIoTDevice != null) {
      this.deviceIdMD5 = paramBaseALIoTDevice.getDeviceIdMD5();
    }
    if ((paramBaseALIoTDevice instanceof ALCameraDevice)) {
      this.iotDevice = ((ALCameraDevice)paramBaseALIoTDevice);
    }
  }
  
  public TPCameraDeviceContext(String paramString, b paramb)
  {
    super(paramString, paramb);
  }
  
  @Nullable
  public ThingModel getThingModel()
  {
    return this.thingModel;
  }
  
  @Nullable
  public String getThingModelId()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALCameraDevice)localObject).getThingModelId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingUrl()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((ALCameraDevice)localObject).getThingUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public void setThingModel(ThingModel paramThingModel)
  {
    this.thingModel = paramThingModel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\TPCameraDeviceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */