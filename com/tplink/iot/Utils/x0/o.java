package com.tplink.iot.Utils.x0;

import android.text.TextUtils;
import b.d.s.a.a;
import com.google.gson.f;
import com.tplink.iot.Utils.n;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.Utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class o
{
  private static com.google.gson.k a(com.tplink.iot.model.home.k paramk)
  {
    Object localObject1 = paramk.g();
    int i = 0;
    Object localObject2 = "";
    int j;
    if (localObject1 != null)
    {
      str = ((BaseALIoTDevice)localObject1).getDeviceType();
      localObject3 = ((BaseALIoTDevice)localObject1).getDeviceModel();
      DeviceManagerInfoBean localDeviceManagerInfoBean = ((BaseALIoTDevice)localObject1).getDeviceManagerInfo();
      j = i;
      localObject2 = str;
      localObject1 = localObject3;
      if (localDeviceManagerInfoBean != null)
      {
        j = i;
        localObject2 = str;
        localObject1 = localObject3;
        if (localDeviceManagerInfoBean.getUserInfo() != null)
        {
          j = i;
          localObject2 = str;
          localObject1 = localObject3;
          if (localDeviceManagerInfoBean.getUserInfo().size() > 1)
          {
            j = 1;
            localObject2 = str;
            localObject1 = localObject3;
          }
        }
      }
    }
    else
    {
      localObject1 = "";
      j = i;
    }
    boolean bool1 = paramk.w();
    boolean bool2 = paramk.g().isOnline();
    boolean bool3 = paramk.q();
    String str = paramk.l();
    Object localObject3 = new com.google.gson.k();
    ((com.google.gson.k)localObject3).m("type", (String)localObject2);
    ((com.google.gson.k)localObject3).m("model", (String)localObject1);
    localObject1 = "true";
    if (bool1) {
      paramk = "true";
    } else {
      paramk = "false";
    }
    ((com.google.gson.k)localObject3).m("isOwner", paramk);
    if (bool3) {
      paramk = "true";
    } else {
      paramk = "false";
    }
    ((com.google.gson.k)localObject3).m("isFavorite", paramk);
    if (j != 0) {
      paramk = "true";
    } else {
      paramk = "false";
    }
    ((com.google.gson.k)localObject3).m("isShared", paramk);
    if (bool2) {
      paramk = (com.tplink.iot.model.home.k)localObject1;
    } else {
      paramk = "false";
    }
    ((com.google.gson.k)localObject3).m("isOnline", paramk);
    ((com.google.gson.k)localObject3).m("device_id", str);
    return (com.google.gson.k)localObject3;
  }
  
  private static com.google.gson.k b(g paramg)
  {
    paramg = paramg.h();
    Object localObject = "";
    int i = 0;
    if (paramg != null)
    {
      String str = paramg.getName();
      List localList = paramg.getThingNames();
      paramg = str;
      if (localList != null)
      {
        i = localList.size();
        paramg = str;
      }
    }
    else
    {
      paramg = "";
    }
    if (paramg == null) {
      paramg = (g)localObject;
    }
    localObject = new com.google.gson.k();
    ((com.google.gson.k)localObject).m("group_name", paramg);
    ((com.google.gson.k)localObject).l("device_number", Integer.valueOf(i));
    return (com.google.gson.k)localObject;
  }
  
  private static com.google.gson.k c(BaseALIoTDevice paramBaseALIoTDevice)
  {
    String str1 = paramBaseALIoTDevice.getDeviceType();
    String str2 = paramBaseALIoTDevice.getDeviceModel();
    String str3 = paramBaseALIoTDevice.getDeviceIdMD5();
    paramBaseALIoTDevice = new com.google.gson.k();
    paramBaseALIoTDevice.m("type", str1);
    paramBaseALIoTDevice.m("model", str2);
    paramBaseALIoTDevice.m("device_id", str3);
    return paramBaseALIoTDevice;
  }
  
  public static void d(boolean paramBoolean, String paramString)
  {
    if (!com.tplink.libtpnetwork.Utils.o.h0().v())
    {
      com.google.gson.k localk = new com.google.gson.k();
      String str;
      if (paramBoolean) {
        str = "true";
      } else {
        str = "false";
      }
      localk.m("has_device", str);
      localk.m("user_email", paramString);
      paramString = i.f(localk);
      n.b().f("app_data", "active_login_user", paramString);
      com.tplink.libtpnetwork.Utils.o.h0().x0(true);
    }
  }
  
  public static void e()
  {
    h.i("home", "add_device_button_click", new l[0]);
  }
  
  public static void f()
  {
    h.i("home", "all_click", new l[0]);
  }
  
  public static void g(String paramString, boolean paramBoolean)
  {
    h.h("home", "bulb_on_off", paramString, new l[] { new l("device_status", h.c(paramBoolean)) });
  }
  
  public static void h()
  {
    h.i("home", "card_long_press_to_edit", new l[0]);
  }
  
  public static void i()
  {
    h.i("home", "drag_to_sort", new l[0]);
  }
  
  public static void j()
  {
    h.i("home", "enter_home", new l[0]);
  }
  
  public static void k(boolean paramBoolean1, boolean paramBoolean2)
  {
    h.i("system", "google_service_check", new l[] { new l("google_play", Boolean.valueOf(paramBoolean1)), new l("google_service", Boolean.valueOf(paramBoolean2)) });
  }
  
  public static void l()
  {
    h.i("home", "home_setting_click", new l[0]);
  }
  
  private static void m(String paramString, List<e> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      f localf = new f();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (e)paramList.next();
        if ((localObject instanceof com.tplink.iot.model.home.k))
        {
          localObject = ((com.tplink.iot.model.home.k)localObject).g();
          if (localObject != null) {
            localf.j(c((BaseALIoTDevice)localObject));
          }
        }
      }
      h.i("home", "long_press", new l[] { new l("click", paramString), new l("device_list", localf) });
    }
  }
  
  public static void n()
  {
    h.i("home", "next_event_click", new l[0]);
  }
  
  public static void o()
  {
    h.i("home", "notification_center_click", new l[0]);
  }
  
  public static void p(String paramString)
  {
    h.h("home", "offline_device_click", paramString, new l[0]);
  }
  
  public static void q(String paramString, boolean paramBoolean)
  {
    h.h("home", "plug_on_off", paramString, new l[] { new l("device_status", h.c(paramBoolean)) });
  }
  
  public static void r()
  {
    h.i("home", "preview_click", new l[0]);
  }
  
  public static void s(List<e> paramList)
  {
    m("relocate", paramList);
  }
  
  public static void t(List<e> paramList)
  {
    m("remove", paramList);
  }
  
  public static void u(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramBaseALIoTDevice);
      v(localArrayList);
    }
  }
  
  private static void v(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      com.google.gson.k localk1 = new com.google.gson.k();
      f localf = new f();
      for (int i = 0; i < paramList.size(); i++)
      {
        Object localObject = (BaseALIoTDevice)paramList.get(i);
        if (localObject != null)
        {
          String str1 = ((BaseALIoTDevice)localObject).getDeviceType();
          String str2 = ((BaseALIoTDevice)localObject).getDeviceModel();
          localObject = ((BaseALIoTDevice)localObject).getDeviceIdMD5();
          com.google.gson.k localk2 = new com.google.gson.k();
          localk2.m("type", str1);
          localk2.m("model", str2);
          localk2.m("device_id", (String)localObject);
          localf.j(localk2);
        }
      }
      localk1.j("device_list", localf);
      if (!TextUtils.isEmpty(a.h())) {
        paramList = a.h();
      } else {
        paramList = "";
      }
      localk1.m("user_email", paramList);
      paramList = i.f(localk1);
      n.b().f("core_function", "remove_plug", paramList);
    }
  }
  
  public static void w(List<e> paramList)
  {
    m("share", paramList);
  }
  
  public static void x()
  {
    h.i("home", "home_shortcut_click", new l[0]);
  }
  
  public static void y(List<e> paramList)
  {
    m("unfavorite", paramList);
  }
  
  public static void z(List<e> paramList)
  {
    f localf1 = new f();
    f localf2 = new f();
    for (int i = 0; i < paramList.size(); i++)
    {
      e locale = (e)paramList.get(i);
      if ((locale instanceof com.tplink.iot.model.home.k)) {
        localf1.j(a((com.tplink.iot.model.home.k)locale));
      } else if ((locale instanceof g)) {
        localf2.j(b((g)locale));
      }
    }
    h.i("user_assets", "get_devices", new l[] { new l("device_list", localf1) });
    h.i("user_assets", "get_groups", new l[] { new l("group_number", Integer.valueOf(localf2.size())), new l("group_list", localf2) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */