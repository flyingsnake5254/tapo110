package com.tplink.iot.Utils.x0;

import com.google.gson.k;

public class d
{
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("change_alert", paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void b(String paramString, int paramInt, boolean paramBoolean)
  {
    h.e("camera_detection", "change_area_intrusion_region", paramString, new l[] { new l("number", Integer.valueOf(paramInt)), new l("is_home_away_mode", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("area_intrusion_switch", paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void d(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      paramObject = com.tplink.libtpnetwork.Utils.i.i(paramObject);
    }
    catch (Exception paramObject)
    {
      paramObject = new k();
    }
    h.e("camera_detection", "change_area_intrusion_schedule", paramString, new l[] { new l("area_intrusion_schedule_config", paramObject), new l("is_home_away_mode", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void e(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      paramObject = com.tplink.libtpnetwork.Utils.i.i(paramObject);
    }
    catch (Exception paramObject)
    {
      paramObject = new k();
    }
    h.e("camera_detection", "change_line_crossing_region", paramString, new l[] { new l("change_line_crossing_schedule", paramObject), new l("is_home_away_mode", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    h.e("camera_detection", "change_notification", paramString, new l[] { new l("status", h.c(paramBoolean1)), new l("is_home_away_mode", Boolean.valueOf(paramBoolean2)) });
  }
  
  private static void g(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    h.e("camera_detection", paramString1, paramString2, new l[] { new l("status", h.c(paramBoolean1)), new l("is_home_away_mode", Boolean.valueOf(paramBoolean2)) });
  }
  
  public static void h(String paramString, int paramInt, boolean paramBoolean)
  {
    h.e("camera_detection", "change_line_crossing_region", paramString, new l[] { new l("number", Integer.valueOf(paramInt)), new l("is_home_away_mode", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void i(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("line_crossing_switch", paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void j(String paramString, int paramInt, boolean paramBoolean)
  {
    h.e("camera_detection", "change_activity_zone_succeed", paramString, new l[] { new l("number", Integer.valueOf(paramInt)), new l("is_home_away_mode", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    h.e("camera_detection", "change_motion_sensitivity", paramString1, new l[] { new l("sensitivity", paramString2), new l("is_home_away_mode", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("change_motion_detection", paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("msg_notification_switch", paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("msg_rich_notification_switch", paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void o(String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    h.e("camera_detection", "msg_notification_schedule", paramString, new l[] { new l("start_time", i.b(paramInt1)), new l("end_time", i.b(paramInt2)), new l("is_home_away_mode", Boolean.valueOf(paramBoolean2)), new l("repeat_day", i.c(paramInt3)) });
  }
  
  public static void p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g("tampering_switch", paramString, paramBoolean1, paramBoolean2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */