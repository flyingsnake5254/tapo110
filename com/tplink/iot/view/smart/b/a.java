package com.tplink.iot.view.smart.b;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;

public final class a
  implements d
{
  public boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    if (!paramBaseALIoTDevice.isCamera()) {
      return true;
    }
    int i;
    if ((paramBaseALIoTDevice.isCamera()) && (paramBaseALIoTDevice.isUserRoleTypeDevice())) {
      i = 1;
    } else {
      i = 0;
    }
    return i ^ 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */