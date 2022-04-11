package com.tplink.libtpnetwork.Utils;

import b.d.w.g.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.Iterator;
import java.util.List;

public class t
{
  public static boolean a()
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_has_already_filter_old_camera");
    localStringBuilder.append(o.E());
    return localo.c(localStringBuilder.toString(), false);
  }
  
  public static boolean b(String paramString)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_is_old_camera");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    return localo.c(localStringBuilder.toString(), false);
  }
  
  public static void c(List<BaseALIoTDevice> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      if ((localBaseALIoTDevice instanceof ALCameraDevice)) {
        e(localBaseALIoTDevice.getDeviceIdMD5(), true);
      }
    }
    d(true);
  }
  
  public static void d(boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_has_already_filter_old_camera");
    localStringBuilder.append(o.E());
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
  
  public static void e(String paramString, boolean paramBoolean)
  {
    o localo = o.h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_is_old_camera");
    localStringBuilder.append(o.E());
    localStringBuilder.append(paramString);
    localo.h(localStringBuilder.toString(), paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */