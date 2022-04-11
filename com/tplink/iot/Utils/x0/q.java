package com.tplink.iot.Utils.x0;

import com.google.gson.f;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class q
{
  public static void a()
  {
    h.i("me", "about_click", new l[0]);
  }
  
  public static void b()
  {
    h.i("me", "yandex_alice_click", new l[0]);
  }
  
  public static void c()
  {
    h.i("me", "amazon_alexa_click", new l[0]);
  }
  
  public static void d()
  {
    h.i("me", "camera_memory_click", new l[0]);
  }
  
  public static void e()
  {
    h.i("me", "filter_click", new l[0]);
  }
  
  public static void f()
  {
    h.i("camera_preference", "camera_preference_click", new l[0]);
  }
  
  public static void g(boolean paramBoolean)
  {
    h.i("camera_preference", "camera_preference_live_tag_click", new l[] { new l("status", h.c(paramBoolean)) });
  }
  
  public static void h(boolean paramBoolean)
  {
    h.i("camera_preference", "camera_preference_speed_tag_click", new l[] { new l("status", h.c(paramBoolean)) });
  }
  
  public static void i(com.tplink.iot.viewmodel.quicksetup.i<Void> parami)
  {
    if (parami == null) {
      return;
    }
    h.i("share", "share_click_fail", new l[] { new l("error_code", Integer.valueOf(parami.b())) });
  }
  
  public static void j(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      f localf = new f();
      for (int i = 0; i < paramList.size(); i++)
      {
        Object localObject = (BaseALIoTDevice)paramList.get(i);
        String str1 = ((BaseALIoTDevice)localObject).getDeviceType();
        String str2 = ((BaseALIoTDevice)localObject).getDeviceModel();
        String str3 = ((BaseALIoTDevice)localObject).getDeviceIdMD5();
        localObject = new k();
        ((k)localObject).m("type", str1);
        ((k)localObject).m("model", str2);
        ((k)localObject).m("device_id", str3);
        localf.j((com.google.gson.i)localObject);
      }
      h.i("share", "share_click_success", new l[] { new l("device_list", localf) });
    }
  }
  
  public static void k()
  {
    h.i("me", "google_assistant_click", new l[0]);
  }
  
  public static void l()
  {
    h.i("me", "mail_ru_click", new l[0]);
  }
  
  public static void m()
  {
    h.i("me", "notifications_click", new l[0]);
  }
  
  public static void n(boolean paramBoolean, String paramString)
  {
    h.i("me", "notification_switch", new l[] { new l("on", Boolean.valueOf(paramBoolean)), new l("type", paramString) });
  }
  
  public static void o()
  {
    h.i("share", "remove_accept_share", new l[0]);
  }
  
  public static void p()
  {
    h.i("me", "share_blacklist_add", new l[0]);
  }
  
  public static void q()
  {
    h.i("me", "device_share_blacklist_click", new l[0]);
  }
  
  public static void r()
  {
    h.i("share", "remove_all_share", new l[0]);
  }
  
  public static void s()
  {
    h.i("share", "remove_single_share", new l[0]);
  }
  
  public static void t()
  {
    h.i("me", "samsung_smartthings_click", new l[0]);
  }
  
  public static void u()
  {
    h.i("me", "voice_control_click", new l[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */