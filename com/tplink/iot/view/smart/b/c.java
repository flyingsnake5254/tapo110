package com.tplink.iot.view.smart.b;

import com.tplink.iot.view.smart.a.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;
import kotlin.jvm.internal.j;

public final class c
  implements d
{
  public boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    EnumDeviceType localEnumDeviceType = paramBaseALIoTDevice.getEnumDeviceType();
    boolean bool = true;
    int i;
    if ((localEnumDeviceType != null) && (a.c.contains(localEnumDeviceType))) {
      i = 1;
    } else {
      i = 0;
    }
    paramBaseALIoTDevice = paramBaseALIoTDevice.getCategory();
    int j;
    if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((j == 0) && (a.d.contains(paramBaseALIoTDevice))) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) || (j == 0)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */