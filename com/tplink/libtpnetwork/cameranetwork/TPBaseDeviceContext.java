package com.tplink.libtpnetwork.cameranetwork;

import androidx.annotation.Nullable;
import b.d.w.h.a;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.io.Serializable;

public class TPBaseDeviceContext<T extends BaseALIoTDevice>
  implements Serializable
{
  protected String deviceIdMD5;
  protected T iotDevice;
  protected b tcAccountContext;
  
  public TPBaseDeviceContext() {}
  
  public TPBaseDeviceContext(String paramString, b paramb)
  {
    this.deviceIdMD5 = paramString;
    this.tcAccountContext = paramb;
  }
  
  public b getAccountContext()
  {
    return this.tcAccountContext;
  }
  
  @Nullable
  public T getCameraDevice()
  {
    return getIoTDevice();
  }
  
  @Nullable
  public String getDeviceId()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getDeviceId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getDeviceIdMD5()
  {
    Object localObject = this.iotDevice;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getDeviceIdMD5();
    } else {
      localObject = this.deviceIdMD5;
    }
    return (String)localObject;
  }
  
  public T getIoTDevice()
  {
    return this.iotDevice;
  }
  
  public b getTcAccountContext()
  {
    return this.tcAccountContext;
  }
  
  public String getThingUrl()
  {
    Object localObject = this.iotDevice;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getThingDevice() != null)) {
      localObject = this.iotDevice.getThingDevice().getThingUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public boolean isOwner()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    boolean bool = false;
    if (localBaseALIoTDevice != null)
    {
      if ((localBaseALIoTDevice.getCloudIoTDevice() != null) && (this.iotDevice.getCloudIoTDevice().getRole() != null))
      {
        if (this.iotDevice.getCloudIoTDevice().getRole() == EnumUserRole.ROLE_OWNER) {
          bool = true;
        }
        return bool;
      }
      if (this.iotDevice.getTDPIoTDevice() != null) {
        return a.g(this.tcAccountContext.c().getCloudUserName()).equalsIgnoreCase(this.iotDevice.getTDPIoTDevice().getOwner());
      }
    }
    return false;
  }
  
  public boolean isSubDevice()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isSubDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSupportChild()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.iotDevice;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isSupportChild())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setIoTDevice(T paramT)
  {
    this.iotDevice = paramT;
  }
  
  public void setTcAccountContext(b paramb)
  {
    this.tcAccountContext = paramb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\TPBaseDeviceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */