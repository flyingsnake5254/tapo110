package com.tplink.iot.viewmodel.home;

import b.d.w.c.a;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.Utils.i;
import java.util.Comparator;
import java.util.List;

public class w
  implements Comparator<e>
{
  private final List<String> c;
  
  public w(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomeOnlineDeviceGroupSortListComparator currentFamilyCommonSortList: ");
    localStringBuilder.append(i.j(paramList));
    a.n("HomeSort", localStringBuilder.toString());
    this.c = paramList;
  }
  
  private int b(e parame1, e parame2)
  {
    parame1 = parame1.f();
    parame2 = parame2.f();
    if ((parame1.isEmpty()) && (parame2.isEmpty())) {
      return 0;
    }
    if (parame1.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    if (parame2.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return parame1.compareToIgnoreCase(parame2);
  }
  
  private int c(e parame)
  {
    StringBuilder localStringBuilder;
    if ((parame instanceof k))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device-");
      localStringBuilder.append(parame.d());
      parame = localStringBuilder.toString();
      return this.c.indexOf(parame);
    }
    if ((parame instanceof g))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Group-");
      localStringBuilder.append(parame.d());
      parame = localStringBuilder.toString();
      return this.c.indexOf(parame);
    }
    return -1;
  }
  
  public int a(e parame1, e parame2)
  {
    int i = c(parame1);
    int j = c(parame2);
    if ((i != -1) && (j != -1)) {
      return i - j;
    }
    if (i != -1) {
      return Integer.MIN_VALUE;
    }
    if (j != -1) {
      return Integer.MAX_VALUE;
    }
    return b(parame1, parame2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */