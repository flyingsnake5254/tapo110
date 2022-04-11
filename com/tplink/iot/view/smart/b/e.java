package com.tplink.iot.view.smart.b;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;

public final class e
  implements d
{
  public boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    return paramBaseALIoTDevice.isSupportIoTCloud();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */