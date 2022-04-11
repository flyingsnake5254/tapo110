package com.tplink.iot.Utils.x0;

import android.util.Log;
import b.d.w.h.b;
import com.google.gson.k;
import com.tplink.iot.Utils.n;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.tdp.bean.BaseTDPDevice;

public class f
{
  private static final String a = "f";
  private static boolean b = false;
  
  public static void A(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_expected_ssid_unfound", paramTDPCameraDevice, new l[0]);
  }
  
  public static void B(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    b = true;
    e("softap_manual_ssid", paramTDPCameraDevice, paramWifi, true);
  }
  
  public static void C(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_multi_request_failed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void D(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_multi_request_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void E()
  {
    h.i("onboarding", "softap_scan_disconnected", new l[0]);
  }
  
  public static void F(TDPCameraDevice paramTDPCameraDevice)
  {
    if (paramTDPCameraDevice == null)
    {
      b.d.w.c.a.e(a, Log.getStackTraceString(new Throwable("cameraDevice is null!")));
      return;
    }
    h.d("onboarding", "softap_scan_not_factory_succeed", paramTDPCameraDevice, new l[] { new l("mac", paramTDPCameraDevice.getMac()), new l("owner", paramTDPCameraDevice.getOwner()), new l("connectSSID", paramTDPCameraDevice.getConnectSsid()) });
  }
  
  public static void G(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_scan_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void H()
  {
    h.i("onboarding", "softap_scan_timeout", new l[0]);
  }
  
  public static void I(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    b = false;
    e("softap_select_ssid", paramTDPCameraDevice, paramWifi, false);
  }
  
  public static void J(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_user_confirm_and_ssid_not_same_connect_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void K(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_wifilist_failed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void L(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_wifilist_manual_failed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void M(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "softap_wifilist_manual_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void N(TDPCameraDevice paramTDPCameraDevice, boolean paramBoolean)
  {
    h.d("onboarding", "softap_wifilist_succeed", paramTDPCameraDevice, new l[] { new l("ssid_used", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void a(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    String str1 = b.d.s.a.a.h();
    com.google.gson.f localf = new com.google.gson.f();
    k localk = new k();
    localk.m("type", "SMART.IPCAMERA");
    String str2 = "";
    if (paramTDPCameraDevice != null) {
      localObject1 = paramTDPCameraDevice.getDeviceModel();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localk.m("model", (String)localObject2);
    if (paramWifi != null) {
      paramWifi = paramWifi.getSsid();
    } else {
      paramWifi = "";
    }
    Object localObject1 = paramWifi;
    if (b.d(paramWifi)) {
      localObject1 = "";
    }
    localk.m("WIFI", b.d.w.h.a.g((String)localObject1));
    if (paramTDPCameraDevice != null) {
      paramTDPCameraDevice = paramTDPCameraDevice.getDeviceId();
    } else {
      paramTDPCameraDevice = "";
    }
    if (paramTDPCameraDevice == null) {
      paramTDPCameraDevice = str2;
    }
    localk.m("device_id", b.d.w.h.a.g(paramTDPCameraDevice));
    localf.j(localk);
    paramTDPCameraDevice = new k();
    paramTDPCameraDevice.j("device_list", localf);
    paramTDPCameraDevice.m("user_email", str1);
    paramTDPCameraDevice = i.f(paramTDPCameraDevice);
    n.b().f("user_assets", "add_device", paramTDPCameraDevice);
  }
  
  public static void b(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_cloud_save_device_name_failed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void c(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_cloud_save_device_name_succeeded", paramTDPCameraDevice, new l[0]);
  }
  
  public static void d(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_cloud_discovery_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  private static void e(String paramString, TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi, boolean paramBoolean)
  {
    if (paramWifi == null)
    {
      b.d.w.c.a.e(a, Log.getStackTraceString(new Throwable("wifi is null!")));
      paramWifi = null;
    }
    else
    {
      paramWifi = h.a(new l[] { new l("rssi", Integer.valueOf(paramWifi.getRssi())), new l("encrypt_type", paramWifi.getEncryption()), new l("is_manual", Boolean.valueOf(paramBoolean)) });
    }
    h.d("onboarding", paramString, paramTDPCameraDevice, new l[] { new l("ssid_info", paramWifi) });
  }
  
  public static void f(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_local_save_device_name_failed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void g(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_local_save_device_name_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void h(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    e("ap_scan_succeed", paramTDPCameraDevice, paramWifi, b);
  }
  
  public static void i()
  {
    h.i("onboarding", "location_denied", new l[0]);
  }
  
  public static void j()
  {
    h.i("onboarding", "location_granted", new l[0]);
  }
  
  public static void k(TDPCameraDevice paramTDPCameraDevice, String paramString)
  {
    h.d("onboarding", "onboarding_break", paramTDPCameraDevice, new l[] { new l("break_page", paramString) });
  }
  
  public static void l(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi, String paramString1, String paramString2)
  {
    q("onboarding_failed", paramTDPCameraDevice, paramString1, paramString2, paramWifi, b);
  }
  
  public static void m(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "onboarding_retry", paramTDPCameraDevice, new l[0]);
  }
  
  public static void n(TDPCameraDevice paramTDPCameraDevice, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramTDPCameraDevice = com.tplink.iot.Utils.z0.h.f(paramTDPCameraDevice);
    if (paramTDPCameraDevice != null)
    {
      if (paramString1 != null) {
        paramTDPCameraDevice.m("location", paramString1);
      }
      if (paramString2 != null) {
        paramTDPCameraDevice.m("device_name", paramString2);
      }
    }
    paramString1 = new l("device_info", paramTDPCameraDevice);
    if (paramBoolean) {
      paramTDPCameraDevice = "wired";
    } else {
      paramTDPCameraDevice = "wireless";
    }
    h.f("onboarding", "onboarding_succeed", new l[] { paramString1, new l("onboarding_type", paramTDPCameraDevice) });
  }
  
  public static void o(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "watch_video_click", paramTDPCameraDevice, new l[0]);
  }
  
  public static void p(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi, String paramString1, String paramString2)
  {
    q("quicksetup_save_click", paramTDPCameraDevice, paramString1, paramString2, paramWifi, b);
  }
  
  private static void q(String paramString1, TDPCameraDevice paramTDPCameraDevice, String paramString2, String paramString3, Wifi paramWifi, boolean paramBoolean)
  {
    if (paramWifi == null)
    {
      b.d.w.c.a.e(a, Log.getStackTraceString(new Throwable("wifi is null!")));
      paramWifi = null;
    }
    else
    {
      paramWifi = h.a(new l[] { new l("rssi", Integer.valueOf(paramWifi.getRssi())), new l("encrypt_type", paramWifi.getEncryption()), new l("is_manual", Boolean.valueOf(paramBoolean)) });
    }
    paramTDPCameraDevice = com.tplink.iot.Utils.z0.h.f(paramTDPCameraDevice);
    if (paramTDPCameraDevice != null)
    {
      if (paramString2 != null) {
        paramTDPCameraDevice.m("location", paramString2);
      }
      if (paramString3 != null) {
        paramTDPCameraDevice.m("device_name", paramString3);
      }
    }
    h.f("onboarding", paramString1, new l[] { new l("device_info", paramTDPCameraDevice), new l("ssid_info", paramWifi) });
  }
  
  public static void r()
  {
    h.i("onboarding", "request_location", new l[0]);
  }
  
  public static void s(String paramString)
  {
    h.i("onboarding", "softap_succeed", new l[] { new l("softap_name", paramString) });
  }
  
  public static void t(TDPCameraDevice paramTDPCameraDevice)
  {
    h.d("onboarding", "ap_user_confirm_and_ssid_unknown_connect_succeed", paramTDPCameraDevice, new l[0]);
  }
  
  public static void u(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    e("softap_connect_assert_succeed", paramTDPCameraDevice, paramWifi, b);
  }
  
  public static void v(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    e("softap_connect_comm_failed", paramTDPCameraDevice, paramWifi, b);
  }
  
  public static void w(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    e("softap_connect_no_ip", paramTDPCameraDevice, paramWifi, b);
  }
  
  public static void x(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    e("softap_connect_succeed", paramTDPCameraDevice, paramWifi, b);
  }
  
  public static void y(TDPCameraDevice paramTDPCameraDevice, boolean paramBoolean, Wifi paramWifi)
  {
    if (paramWifi == null)
    {
      b.d.w.c.a.e(a, Log.getStackTraceString(new Throwable("wifi is null!")));
      return;
    }
    paramWifi = h.a(new l[] { new l("rssi", Integer.valueOf(paramWifi.getRssi())), new l("encrypt_type", paramWifi.getEncryption()), new l("is_manual", Boolean.valueOf(b)) });
    h.d("onboarding", "softap_connect_to_ap", paramTDPCameraDevice, new l[] { new l("is_save_password", Boolean.valueOf(paramBoolean)), new l("ssid_info", paramWifi) });
  }
  
  public static void z(TDPCameraDevice paramTDPCameraDevice, Wifi paramWifi)
  {
    e("softap_connect_wrong_pwd", paramTDPCameraDevice, paramWifi, b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */