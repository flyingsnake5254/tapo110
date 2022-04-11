package com.tplink.iot.view.smart.b;

import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

public final class g
  implements d
{
  private final l<BaseALIoTDevice<?>, ThingModel> a;
  
  public g(l<? super BaseALIoTDevice<?>, ? extends ThingModel> paraml)
  {
    this.a = paraml;
  }
  
  public boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    paramBaseALIoTDevice = (ThingModel)this.a.invoke(paramBaseALIoTDevice);
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramBaseALIoTDevice != null)
    {
      List localList = paramBaseALIoTDevice.getProperties();
      int i;
      if ((localList != null) && (!localList.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      paramBaseALIoTDevice = paramBaseALIoTDevice.getEvents();
      int j;
      if ((paramBaseALIoTDevice != null) && (!paramBaseALIoTDevice.isEmpty())) {
        j = 0;
      } else {
        j = 1;
      }
      if ((i ^ 0x1) == 0)
      {
        bool2 = bool1;
        if ((j ^ 0x1) == 0) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */