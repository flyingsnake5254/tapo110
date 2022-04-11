package com.tplink.iot.viewmodel.home;

import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Comparator;
import java.util.List;

public class x
  implements Comparator<k>
{
  @Deprecated
  private final List<String> c;
  
  public x(List<String> paramList)
  {
    this.c = paramList;
  }
  
  public int a(k paramk1, k paramk2)
  {
    int i = paramk1.m();
    int j = paramk2.m();
    if ((i != 0) && (j != 0))
    {
      int k = this.c.indexOf(paramk1.l());
      int m = this.c.indexOf(paramk2.l());
      if ((k != -1) && (m != -1)) {
        return k - m;
      }
      if (k != -1) {
        return Integer.MAX_VALUE;
      }
      if (m != -1) {
        return Integer.MIN_VALUE;
      }
      return j - i;
    }
    if (i != 0) {
      return Integer.MIN_VALUE;
    }
    if (j != 0) {
      return Integer.MAX_VALUE;
    }
    paramk1 = paramk1.g().getDeviceName();
    paramk2 = paramk2.g().getDeviceName();
    if ((paramk1.isEmpty()) && (paramk2.isEmpty())) {
      return 0;
    }
    if (paramk1.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    if (paramk2.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return paramk1.compareToIgnoreCase(paramk2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */