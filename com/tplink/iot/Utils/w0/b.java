package com.tplink.iot.Utils.w0;

import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import kotlin.jvm.internal.j;

public final class b
{
  public static final boolean a(LocalIoTBaseDevice paramLocalIoTBaseDevice, EnumIoTComponent paramEnumIoTComponent)
  {
    j.e(paramEnumIoTComponent, "component");
    boolean bool;
    if (paramLocalIoTBaseDevice != null) {
      bool = paramLocalIoTBaseDevice.isSupportComponent(paramEnumIoTComponent);
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\w0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */