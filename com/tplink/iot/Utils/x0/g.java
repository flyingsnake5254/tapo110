package com.tplink.iot.Utils.x0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordPlanRepository;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g
{
  public static void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    h.e("camera_settings", "change_auto_reboot", paramString1, new l[] { new l("is_on", Boolean.valueOf(paramBoolean)), new l("auto_reboot_time", paramString2) });
  }
  
  public static void b(String paramString1, String paramString2)
  {
    h.e("camera_settings", "change_device_location", paramString1, new l[] { new l("location", paramString2) });
  }
  
  public static void c(String paramString)
  {
    h.e("camera_settings", "change_device_name", paramString, new l[0]);
  }
  
  public static void d(String paramString)
  {
    h.e("camera_settings", "change_device_timezone", paramString, new l[0]);
  }
  
  public static void e(String paramString, boolean paramBoolean)
  {
    i("change_LED", paramString, paramBoolean);
  }
  
  public static void f(String paramString, boolean paramBoolean)
  {
    i("change_local_recording", paramString, paramBoolean);
  }
  
  public static void g(String paramString, boolean paramBoolean)
  {
    i("change_rotation", paramString, paramBoolean);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void h(String paramString, Map<DayOfWeek, List<Schedule>> paramMap)
  {
    k localk1 = new k();
    k localk2 = new k();
    localk2.k("isEnabled", Boolean.valueOf(TextUtils.equals("on", RecordPlanRepository.s(paramMap).getEnabled())));
    localk2.l("maxPlansPerDay", Integer.valueOf(10));
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (((List)localEntry.getValue()).size() > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          paramMap = (Schedule)localIterator2.next();
          localStringBuilder.append("(");
          localStringBuilder.append(String.format("%02d", new Object[] { Integer.valueOf(paramMap.getStartHour()) }));
          localStringBuilder.append(String.format("%02d", new Object[] { Integer.valueOf(paramMap.getStartMinute()) }));
          localStringBuilder.append("-");
          localStringBuilder.append(String.format("%02d", new Object[] { Integer.valueOf(paramMap.getEndHour()) }));
          localStringBuilder.append(String.format("%02d", new Object[] { Integer.valueOf(paramMap.getEndMinute()) }));
          localStringBuilder.append("-");
          if (paramMap.getType() == 2) {
            paramMap = "detection";
          } else {
            paramMap = "continuous";
          }
          localStringBuilder.append(paramMap);
          localStringBuilder.append(")");
        }
        localk2.m(String.valueOf(((DayOfWeek)localEntry.getKey()).ordinal() + 1), localStringBuilder.toString());
      }
    }
    localk1.j("schedule_config", localk2);
    h.e("camera_settings", "change_record_schedule", paramString, new l[] { new l("schedule_config", localk2) });
  }
  
  private static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    h.e("camera_settings", paramString1, paramString2, new l[] { new l("is_on", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void j(String paramString, boolean paramBoolean)
  {
    i("diagnostics_switch", paramString, paramBoolean);
  }
  
  public static void k(String paramString, boolean paramBoolean)
  {
    i("distortion_correction_switch", paramString, paramBoolean);
  }
  
  public static void l(String paramString)
  {
    h.e("firmware_update", "firmware_update_click", paramString, new l[0]);
  }
  
  public static void m(String... paramVarArgs)
  {
    f localf = new f();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localf.j(com.tplink.iot.Utils.z0.h.g(paramVarArgs[j]));
    }
    h.i("firmware_update", "firmware_update_complete", new l[] { new l("success_upgrade_device_list", localf) });
  }
  
  public static void n(String paramString, boolean paramBoolean)
  {
    h.e("camera_settings", "osd_log_click", paramString, new l[] { new l("isOn", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void o(String paramString, boolean paramBoolean)
  {
    h.e("camera_settings", "osd_text_click", paramString, new l[] { new l("isOn", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void p(String paramString, boolean paramBoolean)
  {
    h.e("camera_settings", "osd_timestamp_click", paramString, new l[] { new l("isOn", Boolean.valueOf(paramBoolean)) });
  }
  
  public static void q(String paramString)
  {
    h.e("camera_settings", "pt_correction_click", paramString, new l[0]);
  }
  
  public static void r(String paramString, boolean paramBoolean)
  {
    i("record_audio_switch", paramString, paramBoolean);
  }
  
  public static void s(String... paramVarArgs)
  {
    f localf = new f();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localf.j(com.tplink.iot.Utils.z0.h.g(paramVarArgs[j]));
    }
    h.i("camera_settings", "remove_camera_complete", new l[] { new l("device_list", localf) });
  }
  
  public static void t(String... paramVarArgs)
  {
    f localf = new f();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localf.j(com.tplink.iot.Utils.z0.h.g(paramVarArgs[j]));
    }
    h.i("camera_settings", "remove_camera", new l[] { new l("device_list", localf) });
  }
  
  public static void u(String paramString, boolean paramBoolean)
  {
    i("change_upnp", paramString, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */