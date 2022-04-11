package com.tplink.iot.Utils.x0;

import android.text.TextUtils;
import com.google.gson.k;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import java.math.BigDecimal;
import java.util.Calendar;

public class e
{
  public static void A(String paramString, double paramDouble)
  {
    h.e("detail", "talk_end", paramString, new l[] { new l("duration", Double.valueOf(a(paramDouble))) });
  }
  
  public static void B(String paramString)
  {
    h.e("detail", "reach_max_count_of_viewer_live", paramString, new l[0]);
  }
  
  public static void C(String paramString)
  {
    h.e("detail", "reach_max_count_of_viewer_playback", paramString, new l[0]);
  }
  
  public static void D(String paramString, double paramDouble)
  {
    h.e("detail", "voice_call_end", paramString, new l[] { new l("duration", Double.valueOf(a(paramDouble))) });
  }
  
  public static void E(String paramString, boolean paramBoolean)
  {
    h.e("detail", "voice_call_mute_click", paramString, new l[] { new l("is_on", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void F(String paramString, boolean paramBoolean)
  {
    h.e("detail", "voice_call_speaker_click", paramString, new l[] { new l("is_on", Boolean.valueOf(paramBoolean)) });
  }
  
  private static double a(double paramDouble)
  {
    return new BigDecimal(paramDouble).setScale(2, 4).doubleValue();
  }
  
  private static k b()
  {
    k localk = new k();
    localk.m("type", "SMART.IPCAMERA");
    return localk;
  }
  
  public static void c()
  {
    h.i("away_mode", "start_away_mode", new l[] { new l("device_info", b()) });
  }
  
  public static void d(String paramString)
  {
    h.e("detail", "change_live_view", paramString, new l[0]);
  }
  
  public static void e(String paramString, double paramDouble)
  {
    h.e("detail", "change_microphone", paramString, new l[] { new l("volume", Double.valueOf(a(paramDouble))) });
  }
  
  public static void f(String paramString)
  {
    h.e("detail", "change_quality", paramString, new l[0]);
  }
  
  public static void g(String paramString, double paramDouble)
  {
    h.e("detail", "change_speaker", paramString, new l[] { new l("volume", Double.valueOf(paramDouble)) });
  }
  
  public static void h(String paramString)
  {
    h.e("detail", "cruise_click", paramString, new l[0]);
  }
  
  public static void i(String paramString)
  {
    h.e("detail", "cruise_stop", paramString, new l[0]);
  }
  
  public static void j(String paramString)
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localCalendar.get(11));
    localStringBuilder.append(":");
    localStringBuilder.append(localCalendar.get(12));
    localStringBuilder.append(":");
    localStringBuilder.append(localCalendar.get(13));
    h.e("detail", "enter_privacy_mode", paramString, new l[] { new l("time", localStringBuilder.toString()) });
  }
  
  public static void k()
  {
    h.i("home_mode", "start_home_mode", new l[] { new l("device_info", b()) });
  }
  
  public static void l(String paramString)
  {
    h.e("detail", "joystick_click", paramString, new l[0]);
  }
  
  public static void m(String paramString1, double paramDouble, BitStreamType paramBitStreamType, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if (paramDouble < 0.0D) {
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      if (BitStreamType.MINOR_VGA.equals(paramBitStreamType)) {
        paramBitStreamType = "lq";
      } else {
        paramBitStreamType = "hq";
      }
      paramString3 = paramBitStreamType;
    }
    if (paramBoolean1) {
      paramBitStreamType = "fourscreen";
    } else if (paramBoolean2) {
      paramBitStreamType = "fullscreen";
    } else {
      paramBitStreamType = "portrait";
    }
    h.e("detail", "live_end", paramString1, new l[] { new l("duration", Double.valueOf(a(paramDouble))), new l("quality", paramString3), new l("connect_type", paramString2), new l("screen_type", paramBitStreamType) });
  }
  
  public static void n(String paramString)
  {
    h.e("camera_preview", "manage_click", paramString, new l[0]);
  }
  
  public static void o(String paramString)
  {
    h.e("detail", "mark_succeed", paramString, new l[0]);
  }
  
  public static void p(String paramString)
  {
    h.e("camera_preview", "play_click", paramString, new l[0]);
  }
  
  public static void q(String paramString1, double paramDouble, String paramString2)
  {
    h.e("detail", "playback_end", paramString1, new l[] { new l("duration", Double.valueOf(a(paramDouble))), new l("connect_type", paramString2) });
  }
  
  public static void r()
  {
    h.i("camera_preview", "change_mode_success", new l[] { new l("device_info", b()) });
  }
  
  public static void s(String paramString1, double paramDouble, String paramString2)
  {
    if (paramDouble < 0.0D) {
      return;
    }
    h.e("camera_preview", "preview_end", paramString1, new l[] { new l("duration", Double.valueOf(a(paramDouble))), new l("connect_type", paramString2) });
  }
  
  public static void t(String paramString)
  {
    h.e("detail", "record_click", paramString, new l[0]);
  }
  
  public static void u(String paramString)
  {
    h.e("detail", "resume_play", paramString, new l[0]);
  }
  
  public static void v(String paramString)
  {
    h.e("detail", "screenshot_click", paramString, new l[0]);
  }
  
  public static void w(String paramString)
  {
    h.e("detail", "sdcard_user_count", paramString, new l[0]);
  }
  
  public static void x()
  {
    h.e("memory", "share_click", null, new l[0]);
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    h.e("camera_preview", "sound_click", paramString, new l[] { new l("sound_status", str) });
  }
  
  public static void z(String paramString, boolean paramBoolean)
  {
    h.e("detail", "speaker_click", paramString, new l[] { new l("is_on", Boolean.valueOf(paramBoolean)) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */