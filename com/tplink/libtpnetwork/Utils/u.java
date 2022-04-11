package com.tplink.libtpnetwork.Utils;

import b.d.w.g.a;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;

public class u
{
  public static Boolean a(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_baby_cry_opened");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return Boolean.valueOf(localo.c(localStringBuilder.toString(), false));
  }
  
  public static int b(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_camera_bind_tapo_care_status");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.d(localStringBuilder.toString(), 0);
  }
  
  public static long c(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_camera_tapo_care_bind_time");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.e(localStringBuilder.toString(), -1L);
  }
  
  public static boolean d(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_is_first_open_camera");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.c(localStringBuilder.toString(), true);
  }
  
  public static boolean e(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_motion_tracking_opened");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.c(localStringBuilder.toString(), false);
  }
  
  public static boolean f(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_private_zone_opened");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.c(localStringBuilder.toString(), false);
  }
  
  public static boolean g(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_tapo_care_advanced_guide_dialog_showed");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.c(localStringBuilder.toString(), false);
  }
  
  public static void h(String paramString, boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_baby_cry_opened");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
  
  public static void i(String paramString, int paramInt)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_camera_bind_tapo_care_status");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.i(localStringBuilder.toString(), paramInt);
  }
  
  public static void j(String paramString, DeviceCloudProduct paramDeviceCloudProduct)
  {
    if (!g(paramString)) {
      if ((paramDeviceCloudProduct.getStatus() != null) && ("active".equals(paramDeviceCloudProduct.getStatus())))
      {
        if (b(paramString) == -1)
        {
          k(paramString, System.currentTimeMillis());
          i(paramString, 2);
        }
        else if (b(paramString) != 2)
        {
          o(paramString, true);
          i(paramString, 1);
        }
      }
      else if (b(paramString) == 0) {
        i(paramString, -1);
      }
    }
  }
  
  public static void k(String paramString, long paramLong)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_camera_tapo_care_bind_time");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.j(localStringBuilder.toString(), paramLong);
  }
  
  public static void l(String paramString, boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_is_first_open_camera");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
  
  public static void m(String paramString, boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_motion_tracking_opened");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
  
  public static void n(String paramString, boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_private_zone_opened");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
  
  public static void o(String paramString, boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_tapo_care_advanced_guide_dialog_showed");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */