package com.tplink.iot.Utils.x0;

import kotlin.jvm.internal.j;

public final class r
{
  private static final l a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    return z("device_info", new k(paramString1, paramString2, paramString3));
  }
  
  public static final void b(String paramString1, String paramString2, String paramString3)
  {
    h.i("onboarding", "bluetooth_scan_succeed", new l[] { a(paramString1, paramString2, paramString3) });
  }
  
  public static final void c()
  {
    h.i("onboarding", "bluetooth_scan_timeout", new l[0]);
  }
  
  public static final void d()
  {
    h.i("onboarding", "bluetooth_succeed", new l[0]);
  }
  
  private static final void e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.i("onboarding", paramString1, new l[] { a(paramString2, paramString3, paramString4) });
  }
  
  public static final void f(String paramString1, String paramString2, String paramString3)
  {
    e("softap_manual_ssid", paramString1, paramString2, paramString3);
  }
  
  public static final void g(String paramString1, String paramString2, String paramString3)
  {
    j.e(paramString3, "breakPage");
    h.i("onboarding", "onboarding_break", new l[] { a(paramString1, paramString2, null), z("break_page", paramString3) });
  }
  
  public static final void h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    h.i("onboarding", "onboarding_succeed", new l[] { a(paramString1, paramString2, paramString3), z("duration", Integer.valueOf(paramInt)) });
  }
  
  public static final void i(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    h.i("onboarding", "quicksetup_check_firmware", new l[] { a(paramString1, paramString2, paramString3), z("fw_ver", paramString4), z("need_to_upgrade", Boolean.valueOf(paramBoolean)) });
  }
  
  public static final void j(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    paramString2 = a(paramString1, paramString2, paramString3);
    paramString1 = z("manual", Boolean.valueOf(paramBoolean));
    if (paramString4 == null) {
      paramString4 = "";
    }
    h.i("onboarding", "quicksetup_edit_location", new l[] { paramString2, paramString1, z("location", paramString4) });
  }
  
  public static final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = a(paramString1, paramString2, paramString3);
    if (paramString4 == null) {
      paramString4 = "";
    }
    h.i("onboarding", "quicksetup_edit_name", new l[] { paramString1, z("device_name", paramString4) });
  }
  
  public static final void l(String paramString1, String paramString2, String paramString3)
  {
    h.i("onboarding", "quicksetup_save_device_info_failed", new l[] { a(paramString1, paramString2, paramString3) });
  }
  
  public static final void m(String paramString1, String paramString2, String paramString3)
  {
    h.i("onboarding", "quicksetup_save_device_info_succeed", new l[] { a(paramString1, paramString2, paramString3) });
  }
  
  public static final void n(String paramString1, String paramString2, String paramString3)
  {
    e("softap_rescan_wifilist", paramString1, paramString2, paramString3);
  }
  
  public static final void o(String paramString1, String paramString2, String paramString3)
  {
    e("softap_wifilist_failed", paramString1, paramString2, paramString3);
  }
  
  public static final void p(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    h.i("onboarding", "softap_wifilist_succeed", new l[] { a(paramString1, paramString2, paramString3), z("ssid_used", Boolean.valueOf(paramBoolean)) });
  }
  
  public static final void q(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    j.e(paramString4, "keyType");
    com.google.gson.k localk = new com.google.gson.k();
    localk.l("rssi", Integer.valueOf(paramInt));
    localk.m("key_type", paramString4);
    h.i("onboarding", "softap_select_ssid", new l[] { a(paramString1, paramString2, paramString3), z("ssid_info", localk) });
  }
  
  public static final void r(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    h.i("onboarding", "ap_cloud_discovery_succeed", new l[] { a(paramString1, paramString2, paramString3), z("duration", Integer.valueOf(paramInt)) });
  }
  
  public static final void s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    h.i("onboarding", "softap_connect_succeed", new l[] { a(paramString1, paramString2, paramString3), z("duration", Integer.valueOf(paramInt)) });
  }
  
  public static final void t(String paramString1, String paramString2, String paramString3)
  {
    e("softap_connect_to_ap", paramString1, paramString2, paramString3);
  }
  
  public static final void u(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    h.i("onboarding", "ap_scan_succeed", new l[] { a(paramString1, paramString2, paramString3), z("duration", Integer.valueOf(paramInt)) });
  }
  
  public static final void v(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    h.i("onboarding", "ap_pairing_failed", new l[] { a(paramString1, paramString2, paramString3), z("duration", Integer.valueOf(paramInt)) });
  }
  
  public static final void w(String paramString1, String paramString2, String paramString3)
  {
    e("softap_scan_succeed", paramString1, paramString2, paramString3);
  }
  
  public static final void x()
  {
    h.i("onboarding", "softap_scan_timeout", new l[0]);
  }
  
  public static final void y(String paramString)
  {
    h.i("onboarding", "softap_succeed", new l[] { z("softap_name", paramString) });
  }
  
  private static final l z(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "";
    }
    return new l(paramString, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */