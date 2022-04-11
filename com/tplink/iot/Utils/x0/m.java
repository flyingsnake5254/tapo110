package com.tplink.iot.Utils.x0;

import com.google.gson.f;
import com.google.gson.k;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.model.firmware.t;
import java.util.Iterator;
import java.util.List;

public class m
{
  public static void a()
  {
    h.i("batch_firmware_update", "firmware_update_click", new l[0]);
  }
  
  public static void b(IotSeriesBean paramIotSeriesBean)
  {
    f localf1 = new f();
    f localf2 = new f();
    if ((paramIotSeriesBean != null) && (paramIotSeriesBean.getIoTDeviceStateList() != null))
    {
      paramIotSeriesBean = paramIotSeriesBean.getIoTDeviceStateList().iterator();
      while (paramIotSeriesBean.hasNext())
      {
        t localt = (t)paramIotSeriesBean.next();
        k localk = h.b(localt.a());
        if (localk != null)
        {
          localf1.j(localk);
          if (localt.b() == 3) {
            localf2.j(localk);
          }
        }
      }
    }
    h.i("batch_firmware_update", "firmware_update_complete", new l[] { new l("upgrade_device_list", localf1), new l("success_upgrade_device_list", localf2) });
  }
  
  public static void c(String paramString)
  {
    h.i("batch_firmware_update", "enter_firmware_update_page", new l[] { new l("entry", paramString) });
  }
  
  public static void d()
  {
    h.i("firmware_update", "enter_firmware_update_page", new l[0]);
  }
  
  public static void e()
  {
    h.i("firmware_update", "firmware_update_click", new l[0]);
  }
  
  public static void f(String paramString, boolean paramBoolean)
  {
    f localf1 = new f();
    f localf2 = new f();
    paramString = h.b(paramString);
    if (paramString != null)
    {
      localf1.j(paramString);
      if (paramBoolean) {
        localf2.j(paramString);
      }
    }
    h.i("batch_firmware_update", "firmware_update_complete", new l[] { new l("upgrade_device_list", localf1), new l("success_upgrade_device_list", localf2) });
    h.i("firmware_update", "firmware_update_complete", new l[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */