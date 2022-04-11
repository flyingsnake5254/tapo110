package com.tplink.iot.viewmodel.home;

import android.text.TextUtils;
import b.d.w.c.a;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class t
{
  private static Comparator<k> a = new a();
  private static Comparator<BaseALIoTDevice> b = new v();
  private static Comparator<k> c = new b();
  
  private static int b(String paramString)
  {
    paramString = EnumDeviceType.fromType(paramString);
    if (paramString == null) {
      return EnumDeviceType.values().length;
    }
    return paramString.ordinal();
  }
  
  public static String c(k paramk)
  {
    String str = paramk.g().getDeviceType();
    if (r.j(paramk.g())) {
      str = EnumDeviceType.SWITCH.getDeviceType();
    }
    return str;
  }
  
  public static void d(List<GroupInfo> paramList)
  {
    Collections.sort(paramList, new d());
  }
  
  public static void e(List<k> paramList)
  {
    Collections.sort(paramList, a);
  }
  
  public static void f(List<g> paramList)
  {
    Collections.sort(paramList, new c());
  }
  
  public static void g(List<k> paramList)
  {
    Collections.sort(paramList, a);
  }
  
  public static void h(List<BaseALIoTDevice> paramList)
  {
    Collections.sort(paramList, b);
  }
  
  public static void i(List<e> paramList, List<String> paramList1)
  {
    Collections.sort(paramList, new w(paramList1));
  }
  
  public static void j(List<k> paramList, List<String> paramList1)
  {
    a.n("HomeSort", "HomeDeviceSortUtils.sortHomeOnlineDeviceList DefaultOrder");
    Collections.sort(paramList, new x(paramList1));
  }
  
  static final class a
    implements Comparator<k>
  {
    public int a(k paramk1, k paramk2)
    {
      String str1 = t.c(paramk1);
      String str2 = t.c(paramk2);
      if (t.a(str1) < t.a(str2)) {
        return -1;
      }
      if (t.a(str1) > t.a(str2)) {
        return 1;
      }
      if ((paramk1.g() != null) && (!TextUtils.isEmpty(paramk1.g().getDeviceName())) && (paramk2.g() != null) && (!TextUtils.isEmpty(paramk2.g().getDeviceName()))) {
        return paramk1.g().getDeviceName().compareToIgnoreCase(paramk2.g().getDeviceName());
      }
      return 1;
    }
  }
  
  static final class b
    implements Comparator<k>
  {
    public int a(k paramk1, k paramk2)
    {
      if (paramk1.n() < paramk2.n()) {
        return -1;
      }
      if ((paramk1.n() == paramk2.n()) && (paramk1.g() != null) && (!TextUtils.isEmpty(paramk1.g().getDeviceName())) && (paramk2.g() != null) && (!TextUtils.isEmpty(paramk2.g().getDeviceName()))) {
        return paramk1.g().getDeviceName().compareToIgnoreCase(paramk2.g().getDeviceName());
      }
      return 1;
    }
  }
  
  static final class c
    implements Comparator<g>
  {
    public int a(g paramg1, g paramg2)
    {
      GroupBean localGroupBean = paramg1.h();
      long l1 = 0L;
      long l2;
      if (localGroupBean == null) {
        l2 = 0L;
      } else {
        l2 = paramg1.h().getCreateTime();
      }
      if (paramg2.h() != null) {
        l1 = paramg2.h().getCreateTime();
      }
      boolean bool = l2 < l1;
      if (bool) {
        return 1;
      }
      if (bool) {
        return -1;
      }
      return 0;
    }
  }
  
  static final class d
    implements Comparator<GroupInfo>
  {
    public int a(GroupInfo paramGroupInfo1, GroupInfo paramGroupInfo2)
    {
      long l1 = 0L;
      long l2;
      if ((paramGroupInfo1 != null) && (paramGroupInfo1.getCtime() != null)) {
        l2 = paramGroupInfo1.getCtime().longValue();
      } else {
        l2 = 0L;
      }
      long l3 = l1;
      if (paramGroupInfo2 != null)
      {
        l3 = l1;
        if (paramGroupInfo2.getCtime() != null) {
          l3 = paramGroupInfo2.getCtime().longValue();
        }
      }
      boolean bool = l2 < l3;
      if (bool) {
        return 1;
      }
      if (bool) {
        return -1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */