package com.tplink.iot.Utils.x0;

import com.google.gson.f;
import com.tplink.iot.model.home.e;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static void a(String paramString, boolean paramBoolean)
  {
    h.h("all", "bulb_on_off", paramString, new l[] { new l("device_status", h.c(paramBoolean)) });
  }
  
  public static void b(List<e> paramList)
  {
    c("favorite", paramList);
  }
  
  private static void c(String paramString, List<e> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      f localf = new f();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (e)paramList.next();
        if ((localObject1 instanceof com.tplink.iot.model.home.k))
        {
          Object localObject2 = ((com.tplink.iot.model.home.k)localObject1).g();
          if (localObject2 != null)
          {
            String str = ((BaseALIoTDevice)localObject2).getDeviceType();
            localObject1 = ((BaseALIoTDevice)localObject2).getDeviceModel();
            localObject2 = ((BaseALIoTDevice)localObject2).getDeviceIdMD5();
            com.google.gson.k localk = new com.google.gson.k();
            localk.m("type", str);
            localk.m("model", (String)localObject1);
            localk.m("device_id", (String)localObject2);
            localf.j(localk);
          }
        }
      }
      h.i("all", "long_press", new l[] { new l("click", paramString), new l("device_list", localf) });
    }
  }
  
  public static void d(String paramString)
  {
    h.g("all", "offline_device_click", paramString, new l[0]);
  }
  
  public static void e(String paramString, boolean paramBoolean)
  {
    h.h("all", "plug_on_off", paramString, new l[] { new l("device_status", h.c(paramBoolean)) });
  }
  
  public static void f(List<e> paramList)
  {
    c("relocate", paramList);
  }
  
  public static void g(List<e> paramList)
  {
    c("remove", paramList);
  }
  
  public static void h(List<e> paramList)
  {
    c("share", paramList);
  }
  
  public static void i(List<e> paramList)
  {
    c("unfavorite", paramList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */