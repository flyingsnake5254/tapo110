package com.tplink.iot.Utils.x0;

import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.Utils.n;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.Utils.i;

public class u
{
  private static long a()
  {
    return (System.currentTimeMillis() - AppContext.c.d) / 1000L;
  }
  
  private static String b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    k localk = new k();
    localk.l("error_code", Integer.valueOf(paramInt));
    localk.m("account_id", paramString1);
    localk.m("saved_password", b.d.w.h.a.g(paramString3));
    localk.m("email", b.d.w.h.a.g(paramString2));
    localk.l("since_launch_time", Long.valueOf(a()));
    return i.f(localk);
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = b.d.s.a.a.h();
    k localk1 = new k();
    k localk2 = new k();
    localk1.m("type", paramString3);
    localk1.m("model", paramString4);
    localk1.m("WIFI", paramString2);
    localk1.m("device_id", paramString1);
    paramString2 = new f();
    paramString2.j(localk1);
    localk2.j("device_list", paramString2);
    localk2.m("user_email", str);
    paramString2 = i.f(localk2);
    localk2 = new k();
    localk1 = new k();
    localk2.m("type", paramString3);
    localk2.m("model", paramString4);
    localk2.m("location", paramString5);
    localk2.m("device_id", paramString1);
    localk1.j("device_info", localk2);
    localk1.m("user_email", str);
    paramString1 = i.f(localk1);
    n.b().f("user_assets", "add_device", paramString2);
    n.b().f("onboarding", "onboarding_succeed", paramString1);
  }
  
  private static void d(String paramString1, String paramString2, String paramString3)
  {
    n.b().f(paramString1, paramString2, paramString3);
  }
  
  public static void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    d("onboarding", "check_password_fail", b(paramInt, paramString1, paramString2, paramString3));
  }
  
  public static void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    d("onboarding", "check_password_fail_other", b(paramInt, paramString1, paramString2, paramString3));
  }
  
  public static void g(int paramInt)
  {
    String str = b.d.s.a.a.h();
    k localk = new k();
    localk.l("error_code", Integer.valueOf(paramInt));
    localk.m("user_email", str);
    str = i.f(localk);
    n.b().f("onboarding", "onboarding_failed", str);
  }
  
  public static void h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    d("onboarding", "offline_account_info_empty", b(paramInt, paramString1, paramString2, paramString3));
  }
  
  public static void i(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    d("onboarding", "online_account_info_empty", b(paramInt, paramString1, paramString2, paramString3));
  }
  
  public static void j(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    d("onboarding", "check_password_success", b(paramInt, paramString1, paramString2, paramString3));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */