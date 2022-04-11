package com.tplink.iot.viewmodel.home;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Comparator;

public class v
  implements Comparator<BaseALIoTDevice>
{
  public int a(BaseALIoTDevice paramBaseALIoTDevice1, BaseALIoTDevice paramBaseALIoTDevice2)
  {
    int i = paramBaseALIoTDevice1.getOnBoardingTime();
    int j = paramBaseALIoTDevice2.getOnBoardingTime();
    if ((i != 0) && (j != 0)) {
      return j - i;
    }
    if (i != 0) {
      return Integer.MIN_VALUE;
    }
    if (j != 0) {
      return Integer.MAX_VALUE;
    }
    paramBaseALIoTDevice1 = paramBaseALIoTDevice1.getDeviceName();
    paramBaseALIoTDevice2 = paramBaseALIoTDevice2.getDeviceName();
    if ((paramBaseALIoTDevice1.isEmpty()) && (paramBaseALIoTDevice2.isEmpty())) {
      return 0;
    }
    if (paramBaseALIoTDevice1.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    if (paramBaseALIoTDevice2.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return paramBaseALIoTDevice1.compareToIgnoreCase(paramBaseALIoTDevice2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */