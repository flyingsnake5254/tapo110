package com.tplink.iot.view.smart.a;

import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import kotlin.jvm.internal.j;

public final class b
{
  public static final b a = new b();
  
  public static final boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      if (!j.a(EnumIoTCategory.LIGHT.value(), paramString))
      {
        bool2 = bool1;
        if (!j.a(EnumIoTCategory.LIGHT_STRIP.value(), paramString)) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static final boolean b(ThingInfo paramThingInfo)
  {
    if (paramThingInfo != null)
    {
      int i;
      if ((j.a(paramThingInfo.getDeviceType(), EnumDeviceType.CAMERA.getDeviceType())) && (paramThingInfo.getRole() == 1)) {
        i = 1;
      } else {
        i = 0;
      }
      return i ^ 0x1;
    }
    return true;
  }
  
  public static final boolean c(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null)
    {
      int i;
      if ((paramBaseALIoTDevice.isCamera()) && (paramBaseALIoTDevice.isUserRoleTypeDevice())) {
        i = 1;
      } else {
        i = 0;
      }
      return i ^ 0x1;
    }
    return true;
  }
  
  public static final boolean d(String paramString, ThingInfo paramThingInfo)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      bool2 = bool1;
      if (paramThingInfo != null)
      {
        bool2 = bool1;
        if (j.a(paramString, paramThingInfo.getCategory()))
        {
          bool2 = bool1;
          if (b(paramThingInfo)) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public static final boolean e(String paramString, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      bool2 = bool1;
      if (paramBaseALIoTDevice != null)
      {
        bool2 = bool1;
        if (j.a(paramString, paramBaseALIoTDevice.getCategory()))
        {
          bool2 = bool1;
          if (c(paramBaseALIoTDevice)) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */