package com.tplink.iot.Utils.x0;

import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public class j
{
  public static void a(String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject = TPIoTClientManager.I1(paramString);
    int i;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice() != null)) {
      i = 0;
    } else {
      i = 1;
    }
    l locall1 = new l("loading_time", Long.valueOf(paramLong));
    if (paramBoolean) {
      localObject = "online";
    } else {
      localObject = "offline";
    }
    l locall2 = new l("final_status", localObject);
    if (i != 0) {
      localObject = "remote";
    } else {
      localObject = "local";
    }
    h.g("device", "device_loading_time", paramString, new l[] { locall1, locall2, new l("connect_type", localObject) });
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    Object localObject = TPIoTClientManager.I1(paramString);
    int i;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice() != null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (paramBoolean) {
      localObject = "online";
    } else {
      localObject = "offline";
    }
    l locall = new l("final_status", localObject);
    if (i != 0) {
      localObject = "remote";
    } else {
      localObject = "local";
    }
    h.g("device", "device_status_change", paramString, new l[] { locall, new l("connect_type", localObject) });
  }
  
  public static void c(String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject = TPIoTClientManager.I1(paramString);
    int i;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice() != null)) {
      i = 0;
    } else {
      i = 1;
    }
    l locall1 = new l("request_time", Long.valueOf(paramLong));
    l locall2 = new l("request_method", "on_off");
    if (paramBoolean) {
      localObject = "success";
    } else {
      localObject = "failed";
    }
    l locall3 = new l("result", localObject);
    if (i != 0) {
      localObject = "remote";
    } else {
      localObject = "local";
    }
    h.g("device", "device_request_time", paramString, new l[] { locall1, locall2, locall3, new l("connect_type", localObject) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */