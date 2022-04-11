package com.tplink.iot.Utils.x0;

import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.common.ThingUsageDetail;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public class i
{
  public static void A(String paramString)
  {
    h.g("schedule", "delete_schedule", paramString, new l[0]);
  }
  
  public static void B(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "success";
    } else {
      str = "fail";
    }
    h.g("schedule", "execute_schedule", paramString, new l[] { new l("result", str) });
  }
  
  public static void C()
  {
    h.i("detail", "device_share_click", new l[0]);
  }
  
  public static void D(String paramString, int paramInt)
  {
    h.g("detail", "slide_to_change_brightness", paramString, new l[] { new l("brightness", Integer.valueOf(paramInt)) });
  }
  
  public static void E(String paramString1, ThingRuleAwayMode paramThingRuleAwayMode, boolean paramBoolean, String paramString2)
  {
    if (paramThingRuleAwayMode == null) {
      return;
    }
    RuleTimeType localRuleTimeType1 = paramThingRuleAwayMode.getStartTimeType();
    RuleTimeType localRuleTimeType2 = paramThingRuleAwayMode.getEndTimeType();
    String str = b(p0.b(paramThingRuleAwayMode.getStartTimeMin(), paramBoolean, paramString2));
    paramString2 = b(p0.b(paramThingRuleAwayMode.getEndTimeMin(), paramBoolean, paramString2));
    h.g("away_mode", "start_away_mode", paramString1, new l[] { new l("start_time_type", a(localRuleTimeType1)), new l("start_time", str), new l("end_time_type", a(localRuleTimeType2)), new l("end_time", paramString2), new l("repeat_day", c(paramThingRuleAwayMode.getWeekOfDays())) });
  }
  
  public static void F(String paramString, CountdownRuleBean paramCountdownRuleBean)
  {
    if (paramCountdownRuleBean == null) {
      return;
    }
    Object localObject = TPIoTClientManager.I1(paramString);
    if (localObject == null) {
      return;
    }
    int i;
    if (((BaseALIoTDevice)localObject).isPlug()) {
      i = 1;
    } else if ((((BaseALIoTDevice)localObject).isBulb()) && (a.e(paramString))) {
      i = 2;
    } else {
      i = 3;
    }
    int j = paramCountdownRuleBean.getDelay() / 60;
    localObject = new k();
    if (paramCountdownRuleBean.getFormatDesiredStates() != null)
    {
      paramCountdownRuleBean = paramCountdownRuleBean.getFormatDesiredStates();
      ((k)localObject).m("device_on", h.c(paramCountdownRuleBean.isOn()));
      if ((paramCountdownRuleBean.isOn()) && (i != 1)) {
        if (paramCountdownRuleBean.isAuto())
        {
          ((k)localObject).k("auto", Boolean.valueOf(paramCountdownRuleBean.isAuto()));
          ((k)localObject).m("auto_mode", paramCountdownRuleBean.getAutoMode());
        }
        else
        {
          ((k)localObject).l("brightness", Integer.valueOf(paramCountdownRuleBean.getBrightness()));
          if (i == 2)
          {
            ((k)localObject).l("color_temperature", Integer.valueOf(paramCountdownRuleBean.getColorTemp()));
            ((k)localObject).l("hue", Integer.valueOf(paramCountdownRuleBean.getHue()));
            ((k)localObject).l("saturation", Integer.valueOf(paramCountdownRuleBean.getSaturation()));
          }
        }
      }
    }
    else
    {
      ((k)localObject).m("device_on", h.c("on".equalsIgnoreCase(paramCountdownRuleBean.getAction())));
    }
    h.g("timer", "start_timer", paramString, new l[] { new l("duration", Integer.valueOf(j)), new l("state_info", localObject) });
  }
  
  public static void G(String paramString)
  {
    h.g("away_mode", "stop_away_mode_manually", paramString, new l[0]);
  }
  
  public static void H(String paramString)
  {
    h.g("timer", "stop_timer", paramString, new l[0]);
  }
  
  public static String a(RuleTimeType paramRuleTimeType)
  {
    if (paramRuleTimeType == null) {
      return "none";
    }
    int i = a.a[paramRuleTimeType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return "none";
        }
        return "normal";
      }
      return "sunrise";
    }
    return "sunset";
  }
  
  public static String b(int paramInt)
  {
    int i = paramInt / 60 % 24;
    paramInt %= 60;
    Object localObject = new java/lang/StringBuilder;
    if (i < 10)
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("0");
    }
    else
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("");
    }
    ((StringBuilder)localObject).append(i);
    String str = ((StringBuilder)localObject).toString();
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static f c(int paramInt)
  {
    f localf = new f();
    for (int i = 0; i < 7; i++) {
      if ((1 << i & paramInt) > 0) {
        localf.k(Integer.valueOf(i));
      }
    }
    return localf;
  }
  
  public static void d(String paramString, int paramInt)
  {
    k localk = new k();
    localk.l("brightness", Integer.valueOf(paramInt));
    h.g("detail", "preset_click", paramString, new l[] { new l("state_info", localk) });
  }
  
  public static void e(String paramString, boolean paramBoolean)
  {
    h.g("detail", "bulb_on_off", paramString, new l[] { new l("device_status", h.c(paramBoolean)) });
  }
  
  public static void f(String paramString1, String paramString2)
  {
    h.g("detail", "change_device_icon", paramString1, new l[] { new l("device_icon", paramString2) });
  }
  
  public static void g(String paramString1, String paramString2)
  {
    h.g("detail", "change_device_location", paramString1, new l[] { new l("device_location", paramString2) });
  }
  
  public static void h(String paramString1, String paramString2)
  {
    h.g("detail", "change_device_name", paramString1, new l[] { new l("device_name", paramString2) });
  }
  
  public static void i(String paramString, ScheduleRuleBean paramScheduleRuleBean)
  {
    if (paramScheduleRuleBean == null) {
      return;
    }
    Object localObject = TPIoTClientManager.I1(paramString);
    if (localObject == null) {
      return;
    }
    int i;
    if (((BaseALIoTDevice)localObject).isPlug()) {
      i = 1;
    } else if ((((BaseALIoTDevice)localObject).isBulb()) && (a.e(paramString))) {
      i = 2;
    } else {
      i = 3;
    }
    boolean bool = paramScheduleRuleBean.isEnable();
    RuleTimeType localRuleTimeType = paramScheduleRuleBean.getStartTimeType();
    int j = paramScheduleRuleBean.getStartTimeMin();
    localObject = new k();
    ((k)localObject).m("enable", h.c(bool));
    ((k)localObject).m("start_time_type", a(localRuleTimeType));
    ((k)localObject).l("start_time", Integer.valueOf(j));
    if (paramScheduleRuleBean.getDesiredStates() != null)
    {
      paramScheduleRuleBean = paramScheduleRuleBean.getDesiredStates();
      bool = paramScheduleRuleBean.isOn();
      ((k)localObject).m("device_on", h.c(bool));
      if ((bool) && (i != 1)) {
        if (paramScheduleRuleBean.isAuto())
        {
          ((k)localObject).k("auto", Boolean.valueOf(paramScheduleRuleBean.isAuto()));
          ((k)localObject).m("auto_mode", paramScheduleRuleBean.getAutoMode());
        }
        else
        {
          ((k)localObject).l("brightness", Integer.valueOf(paramScheduleRuleBean.getBrightness()));
          if (i == 2)
          {
            ((k)localObject).l("color_temperature", Integer.valueOf(paramScheduleRuleBean.getColorTemp()));
            ((k)localObject).l("hue", Integer.valueOf(paramScheduleRuleBean.getHue()));
            ((k)localObject).l("saturation", Integer.valueOf(paramScheduleRuleBean.getSaturation()));
          }
        }
      }
    }
    else
    {
      ((k)localObject).m("device_on", h.c(paramScheduleRuleBean.isActionOn()));
    }
    h.g("schedule", "change_schedule", paramString, new l[] { new l("schedule_info", localObject) });
  }
  
  public static void j(String paramString)
  {
    h.g("detail", "consumption_chart_past1y", paramString, new l[0]);
  }
  
  public static void k(String paramString)
  {
    h.g("detail", "consumption_chart_past30d", paramString, new l[0]);
  }
  
  public static void l(String paramString)
  {
    h.g("detail", "power_chart_past24h", paramString, new l[0]);
  }
  
  public static void m(String paramString)
  {
    h.g("detail", "power_chart_past7d", paramString, new l[0]);
  }
  
  public static void n(String paramString, LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean == null) {
      return;
    }
    k localk = new k();
    localk.l("brightness", Integer.valueOf(paramLightStateBean.getBrightness()));
    localk.l("color_temperature", Integer.valueOf(paramLightStateBean.getColorTemp()));
    localk.l("hue", Integer.valueOf(paramLightStateBean.getHue()));
    localk.l("saturation", Integer.valueOf(paramLightStateBean.getSaturation()));
    h.g("detail", "preset_click", paramString, new l[] { new l("state_info", localk) });
  }
  
  public static void o(String paramString, int paramInt)
  {
    h.g("detail", "energy_usage_current_power_click", paramString, new l[] { new l("current_power", Integer.valueOf(paramInt)) });
  }
  
  public static void p(String paramString, int paramInt)
  {
    h.g("detail", "energy_usage_past30d_click", paramString, new l[] { new l("usage", Integer.valueOf(paramInt)) });
  }
  
  public static void q(String paramString, int paramInt)
  {
    h.g("detail", "energy_usage_today_click", paramString, new l[] { new l("usage", Integer.valueOf(paramInt)) });
  }
  
  public static void r()
  {
    h.i("away_mode", "enter_away_mode_page", new l[0]);
  }
  
  public static void s()
  {
    h.i("detail", "enter_detail", new l[0]);
  }
  
  public static void t(String paramString, ThingUsage paramThingUsage)
  {
    if ((paramThingUsage != null) && (paramThingUsage.getTimeUsage() != null)) {
      h.g("detail", "time_usage", paramString, new l[] { new l("time_usage_in_thirty_days", com.tplink.iot.Utils.z0.l.i(paramThingUsage.getTimeUsage().getPast30())) });
    }
  }
  
  public static void u()
  {
    h.i("schedule", "enter_schedule_page", new l[0]);
  }
  
  public static void v()
  {
    h.i("timer", "enter_timer_page", new l[0]);
  }
  
  public static void w()
  {
    h.i("detail", "faq_click", new l[0]);
  }
  
  public static void x(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "yes";
    } else {
      str = "no";
    }
    h.g("detail", "detail_favorite", paramString, new l[] { new l("favorite", str) });
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    h.g("detail", "plug_on_off", paramString, new l[] { new l("device_status", h.c(paramBoolean)) });
  }
  
  public static void z(int paramInt)
  {
    h.i("schedule", "schedule_count", new l[] { new l("schedule_count", Integer.valueOf(paramInt)) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */