package com.tplink.iot.model.about;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import b.d.c.a.e;
import com.google.gson.f;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfo;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfoParams;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAppUpdateRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;

public class c
{
  public static void a()
  {
    int i = com.tplink.iot.core.n.e;
    String str = b.b();
    int j = o.h0().d(str, 0);
    if ((j == 0) || (j < i))
    {
      o.h0().i(str, i);
      m();
    }
  }
  
  @SuppressLint({"CheckResult"})
  public static void b()
  {
    String str = b.c();
    str = o.h0().f(str, "");
    boolean bool = f();
    if ((TextUtils.isEmpty(str)) || (OptionSwitch.isOn(str) != bool)) {
      n(bool).y();
    }
  }
  
  public static void c()
  {
    b.d.w.c.a.c("TPA", "关闭");
    com.tplink.iot.Utils.n.b().a(false);
    e.l().b();
  }
  
  public static void d()
  {
    b.d.w.c.a.c("TPA", "开启");
    com.tplink.iot.Utils.n.b().a(true);
    e.l().c();
  }
  
  public static boolean e()
  {
    return o.h0().c("sp_has_agree_privacy_policy", false);
  }
  
  public static boolean f()
  {
    return o.h0().c("is_enable_user_experience_improvement", false);
  }
  
  public static boolean g()
  {
    return o.h0().c("has_remind_user_experience_improvement", false);
  }
  
  public static void i(boolean paramBoolean)
  {
    o.h0().h("sp_has_agree_privacy_policy", paramBoolean);
  }
  
  public static void j(boolean paramBoolean)
  {
    o.h0().h("is_enable_user_experience_improvement", paramBoolean);
  }
  
  public static void k(boolean paramBoolean)
  {
    o.h0().h("has_remind_user_experience_improvement", paramBoolean);
  }
  
  public static void l()
  {
    com.tplink.iot.Utils.n.b().a(f());
    if (f())
    {
      b.d.w.c.a.c("TPA", "开启");
      e.l().c();
    }
    else
    {
      b.d.w.c.a.c("TPA", "关闭");
      e.l().b();
    }
  }
  
  private static void m()
  {
    boolean bool = f();
    TCAppUpdateRepository localTCAppUpdateRepository = (TCAppUpdateRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAppUpdateRepository.class);
    ServiceStatusInfo localServiceStatusInfo = new ServiceStatusInfo("userExperienceImprove", "automatic", bool);
    f localf = new f();
    localf.j(i.i(localServiceStatusInfo));
    localTCAppUpdateRepository.d(new ServiceStatusInfoParams("TP-Link_Tapo_Android", "ANDROID", com.tplink.iot.core.n.a, localf)).y();
  }
  
  public static io.reactivex.a n(boolean paramBoolean)
  {
    TCAppUpdateRepository localTCAppUpdateRepository = (TCAppUpdateRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAppUpdateRepository.class);
    Object localObject1 = new ServiceStatusInfo("userExperienceImprove", "manual", paramBoolean);
    Object localObject2 = new f();
    ((f)localObject2).j(i.i(localObject1));
    localObject2 = new ServiceStatusInfoParams("TP-Link_Tapo_Android", "ANDROID", com.tplink.iot.core.n.a, (f)localObject2);
    localObject1 = b.c();
    return localTCAppUpdateRepository.d((ServiceStatusInfoParams)localObject2).r(io.reactivex.d0.b.a.a()).i(new a((String)localObject1, paramBoolean));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\about\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */