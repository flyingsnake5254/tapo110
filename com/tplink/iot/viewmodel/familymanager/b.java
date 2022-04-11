package com.tplink.iot.viewmodel.familymanager;

import android.text.TextUtils;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class b
{
  private static int b(String paramString)
  {
    if (EnumDeviceType.BULB == EnumDeviceType.fromType(paramString)) {
      return 1;
    }
    if (EnumDeviceType.PLUG == EnumDeviceType.fromType(paramString)) {
      return 2;
    }
    return 3;
  }
  
  public static void c(List<DeviceBean> paramList)
  {
    Collections.sort(paramList, new a());
  }
  
  public static void d(List<GroupInfo> paramList)
  {
    Collections.sort(paramList, new b());
  }
  
  static final class a
    implements Comparator<DeviceBean>
  {
    public int a(DeviceBean paramDeviceBean1, DeviceBean paramDeviceBean2)
    {
      String str1 = paramDeviceBean1.getDeviceType();
      String str2 = paramDeviceBean2.getDeviceType();
      if (b.a(str1) < b.a(str2)) {
        return -1;
      }
      if (b.a(str1) > b.a(str2)) {
        return 1;
      }
      if ((!TextUtils.isEmpty(paramDeviceBean1.getDeviceName())) && (!TextUtils.isEmpty(paramDeviceBean2.getDeviceName()))) {
        return paramDeviceBean1.getDeviceName().compareToIgnoreCase(paramDeviceBean2.getDeviceName());
      }
      return 1;
    }
  }
  
  static final class b
    implements Comparator<GroupInfo>
  {
    public int a(GroupInfo paramGroupInfo1, GroupInfo paramGroupInfo2)
    {
      if ((!TextUtils.isEmpty(paramGroupInfo1.getName())) && (!TextUtils.isEmpty(paramGroupInfo2.getName()))) {
        return paramGroupInfo1.getName().compareToIgnoreCase(paramGroupInfo2.getName());
      }
      return 1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\familymanager\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */