package com.tplink.iot.view.smart.b;

import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

public final class i
  implements d
{
  private final a<List<SmartThingAction>> a;
  
  public i(a<? extends List<? extends SmartThingAction>> parama)
  {
    this.a = parama;
  }
  
  private final boolean b(BaseALIoTDevice<?> paramBaseALIoTDevice, List<? extends SmartThingAction> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (SmartThingAction)localIterator.next();
      if (j.a(paramBaseALIoTDevice.getDeviceId(), paramList.getThingName()))
      {
        paramList = paramList.getService();
        if (paramList != null) {
          paramList = paramList.getServiceId();
        } else {
          paramList = null;
        }
        if (j.a("ring", paramList))
        {
          bool = true;
          break label77;
        }
      }
    }
    boolean bool = false;
    label77:
    return bool;
  }
  
  public boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    if (!paramBaseALIoTDevice.isHub()) {
      return true;
    }
    return b(paramBaseALIoTDevice, (List)this.a.invoke()) ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */