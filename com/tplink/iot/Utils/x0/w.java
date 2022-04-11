package com.tplink.iot.Utils.x0;

public class w
{
  public static void A(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    h.g("tapocare", "pd", paramString, new l[] { new l("status", str) });
  }
  
  public static void B(String paramString1, long paramLong, String paramString2)
  {
    h.g("tapocare", "play_clips", paramString1, new l[] { new l("duration", Long.valueOf(paramLong)), new l("uuid", paramString2) });
  }
  
  public static void C(String paramString, long paramLong)
  {
    h.g("tapocare", "play_clips_me", paramString, new l[] { new l("duration", Long.valueOf(paramLong)) });
  }
  
  public static void D(String paramString)
  {
    h.i("tapocare", "tapo_care_purchase_stop_by_system", new l[] { new l("error_code", paramString) });
  }
  
  public static void E(String paramString)
  {
    h.i("tapocare", "tapo_care_purchase_receipt_account_match_error", new l[] { new l("error_code", paramString) });
  }
  
  public static void F(String paramString)
  {
    h.i("tapocare", "tapo_care_purchase_receipt_verify_error", new l[] { new l("error_code", paramString) });
  }
  
  public static void G()
  {
    h.i("tapocare", "showed_subscription_entrance", new l[0]);
  }
  
  public static void H(String paramString)
  {
    h.g("tapocare", "showed_trial_entrance", paramString, new l[0]);
  }
  
  public static void I(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    h.g("tapocare", "target_track", paramString, new l[] { new l("status", str) });
  }
  
  public static void J(String paramString)
  {
    h.e("tapocare", "click_tapo_care_learn_more_button_welcom_page", paramString, new l[0]);
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    h.g("tapocare", "bcd", paramString1, new l[] { new l("status", str), new l("sensitivity", paramString2) });
  }
  
  public static void b(String paramString, boolean paramBoolean, int paramInt)
  {
    l locall = new l("number", Integer.valueOf(paramInt));
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    h.g("tapocare", "block_zone", paramString, new l[] { locall, new l("status", str) });
  }
  
  public static void c(String paramString)
  {
    h.g("tapocare", "click_tapo_care_subscribe_ai_detection", paramString, new l[0]);
  }
  
  public static void d(String paramString)
  {
    h.g("tapocare", "click_tapo_care_trial_ai_detection", paramString, new l[0]);
  }
  
  public static void e()
  {
    h.i("tapocare", "click_tapo_care_cloud_video_me", new l[0]);
  }
  
  public static void f(String paramString)
  {
    h.g("tapocare", "click_tapo_care_subscribe_motion_tracking", paramString, new l[0]);
  }
  
  public static void g(String paramString)
  {
    h.g("tapocare", "click_tapo_care_trial_motion_tracking", paramString, new l[0]);
  }
  
  public static void h(String paramString)
  {
    h.g("tapocare", "click_tapo_care_subscribe_privacy_mask", paramString, new l[0]);
  }
  
  public static void i(String paramString)
  {
    h.g("tapocare", "click_tapo_care_trial_privacy_mask", paramString, new l[0]);
  }
  
  public static void j(String paramString)
  {
    h.g("tapocare", "click_tapo_care_subscribe_rich_notification", paramString, new l[0]);
  }
  
  public static void k(String paramString)
  {
    h.g("tapocare", "click_tapo_care_trial_rich_notification", paramString, new l[0]);
  }
  
  public static void l(String paramString)
  {
    h.g("tapocare", "click_tapo_care_cloud_service_ipc_setting", paramString, new l[0]);
  }
  
  public static void m()
  {
    h.i("tapocare", "click_tapo_care_cloud_video_list", new l[0]);
  }
  
  public static void n(String paramString)
  {
    h.g("tapocare", "click_tapo_care_control_button_ipc_detail", paramString, new l[0]);
  }
  
  public static void o()
  {
    h.i("tapocare", "click_tapo_care_ipc_detail", new l[0]);
  }
  
  public static void p()
  {
    h.i("tapocare", "click_tapo_care_manage_subscription_ipc_detail", new l[0]);
  }
  
  public static void q()
  {
    h.i("tapocare", "click_tapo_care_me", new l[0]);
  }
  
  public static void r()
  {
    h.i("tapocare", "click_tapo_care_preview", new l[0]);
  }
  
  public static void s()
  {
    h.i("tapocare", "click_tapo_care_trial_ipc_detail", new l[0]);
  }
  
  public static void t(String paramString, boolean paramBoolean, int paramInt)
  {
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    h.g("tapocare", "click_tapo_care_trial_ipc_settings", paramString, new l[] { new l("status", str), new l("days_left", Integer.valueOf(paramInt)) });
  }
  
  public static void u()
  {
    h.i("tapocare", "click_tapo_care_upgrade_now_ipc_detail", new l[0]);
  }
  
  public static void v(String paramString)
  {
    h.i("tapocare", "click_tapo_care_close_banner", new l[] { new l("page", paramString) });
  }
  
  public static void w(String paramString1, String paramString2)
  {
    h.e("tapocare", "click_tapo_care_close_banner", paramString1, new l[] { new l("page", paramString2) });
  }
  
  public static void x(String paramString)
  {
    h.g("tapocare", "delete_cloud_video", paramString, new l[0]);
  }
  
  public static void y(String paramString1, long paramLong, String paramString2)
  {
    h.g("tapocare", "download_clips", paramString1, new l[] { new l("duration", Long.valueOf(paramLong)), new l("uuid", paramString2) });
  }
  
  public static void z(String paramString)
  {
    h.i("tapocare", "tapo_care_purchase_get_product_list_error", new l[] { new l("error_code", paramString) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */