package com.tplink.iot.Utils.x0;

import com.google.gson.k;
import com.tplink.iot.Utils.n;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import kotlin.jvm.internal.j;
import org.apache.commons.lang.b;

public final class h
{
  public static final k a(l... paramVarArgs)
  {
    j.e(paramVarArgs, "eventValuePairs");
    k localk = new k();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      if (localObject != null)
      {
        String str = ((l)localObject).a();
        if (str != null)
        {
          localObject = ((l)localObject).b();
          if ((localObject instanceof Number)) {
            localk.l(str, (Number)localObject);
          } else if ((localObject instanceof String)) {
            localk.m(str, (String)localObject);
          } else if ((localObject instanceof Boolean)) {
            localk.k(str, (Boolean)localObject);
          } else if ((localObject instanceof com.google.gson.i)) {
            localk.j(str, (com.google.gson.i)localObject);
          } else if (localObject != null) {
            localk.m(str, com.tplink.libtpnetwork.Utils.i.f(localObject));
          }
        }
      }
    }
    return localk;
  }
  
  public static final k b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject1 = TPIoTClientManager.I1(paramString);
    if (localObject1 != null)
    {
      String str1 = ((BaseALIoTDevice)localObject1).getDeviceType();
      Object localObject2 = "Unknown";
      if (str1 == null) {
        str1 = "Unknown";
      }
      String str2 = ((BaseALIoTDevice)localObject1).getDeviceModel();
      if (str2 == null) {
        str2 = "Unknown";
      }
      localObject1 = ((BaseALIoTDevice)localObject1).getDeviceFwVer();
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
      localObject1 = new k();
      ((k)localObject1).m("type", str1);
      ((k)localObject1).m("model", str2);
      ((k)localObject1).m("device_id", paramString);
      ((k)localObject1).m("fw_ver", (String)localObject2);
      return (k)localObject1;
    }
    return null;
  }
  
  public static final String c(boolean paramBoolean)
  {
    String str;
    if (b.b(Boolean.valueOf(paramBoolean))) {
      str = "on";
    } else {
      str = "off";
    }
    return str;
  }
  
  public static final void d(String paramString1, String paramString2, TDPCameraDevice paramTDPCameraDevice, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    j(paramString1, paramString2, com.tplink.iot.Utils.z0.h.f(paramTDPCameraDevice), paramVarArgs, false);
  }
  
  public static final void e(String paramString1, String paramString2, String paramString3, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    j(paramString1, paramString2, com.tplink.iot.Utils.z0.h.g(paramString3), paramVarArgs, false);
  }
  
  public static final void f(String paramString1, String paramString2, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    j(paramString1, paramString2, null, paramVarArgs, false);
  }
  
  public static final void g(String paramString1, String paramString2, String paramString3, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    j(paramString1, paramString2, b(paramString3), paramVarArgs, false);
  }
  
  public static final void h(String paramString1, String paramString2, String paramString3, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    j(paramString1, paramString2, b(paramString3), paramVarArgs, true);
  }
  
  public static final void i(String paramString1, String paramString2, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    j(paramString1, paramString2, null, paramVarArgs, false);
  }
  
  private static final void j(String paramString1, String paramString2, com.google.gson.i parami, l[] paramArrayOfl, boolean paramBoolean)
  {
    l(paramString1, paramString2, parami, paramArrayOfl, paramBoolean);
  }
  
  public static final void k(String paramString1, String paramString2, l... paramVarArgs)
  {
    j.e(paramString1, "category");
    j.e(paramString2, "action");
    j.e(paramVarArgs, "eventValuePairs");
    k localk = new k();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      if (localObject != null)
      {
        str = ((l)localObject).a();
        if (str != null)
        {
          localObject = ((l)localObject).b();
          if ((localObject instanceof Number)) {
            localk.l(str, (Number)localObject);
          } else if ((localObject instanceof String)) {
            localk.m(str, (String)localObject);
          } else if ((localObject instanceof Boolean)) {
            localk.k(str, (Boolean)localObject);
          } else if ((localObject instanceof com.google.gson.i)) {
            localk.j(str, (com.google.gson.i)localObject);
          } else if (localObject != null) {
            localk.m(str, com.tplink.libtpnetwork.Utils.i.f(localObject));
          }
        }
      }
    }
    String str = com.tplink.libtpnetwork.Utils.i.f(localk);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("category:");
    paramVarArgs.append(paramString1);
    paramVarArgs.append("\naction:");
    paramVarArgs.append(paramString2);
    paramVarArgs.append("\nevent_value:");
    paramVarArgs.append(str);
    b.d.w.c.a.c("CommonFireBaseUtil", paramVarArgs.toString());
    n.b().f(paramString1, paramString2, str);
  }
  
  private static final void l(String paramString1, String paramString2, com.google.gson.i parami, l[] paramArrayOfl, boolean paramBoolean)
  {
    k localk1 = new k();
    int i = paramArrayOfl.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfl[j];
      if (localObject != null)
      {
        String str = ((l)localObject).a();
        if (str != null)
        {
          localObject = ((l)localObject).b();
          if ((localObject instanceof Number))
          {
            localk1.l(str, (Number)localObject);
          }
          else if ((localObject instanceof String))
          {
            localk1.m(str, (String)localObject);
          }
          else if ((localObject instanceof Boolean))
          {
            localk1.k(str, (Boolean)localObject);
          }
          else if ((localObject instanceof com.google.gson.i))
          {
            localk1.j(str, (com.google.gson.i)localObject);
          }
          else if (localObject != null)
          {
            k localk2;
            try
            {
              localObject = com.tplink.libtpnetwork.Utils.i.i(localObject);
              j.d(localObject, "GsonUtils.toJsonTree(value)");
            }
            catch (Exception localException)
            {
              localk2 = new k();
            }
            localk1.j(str, localk2);
          }
        }
      }
    }
    if (parami != null) {
      localk1.j("device_info", parami);
    }
    parami = b.d.s.a.a.h();
    if (parami == null) {
      parami = "";
    }
    localk1.m("user_email", parami);
    if (b.b(Boolean.valueOf(paramBoolean))) {
      localk1.l("time_stamp", Long.valueOf(System.currentTimeMillis()));
    }
    paramArrayOfl = com.tplink.libtpnetwork.Utils.i.f(localk1);
    parami = new StringBuilder();
    parami.append("category:");
    parami.append(paramString1);
    parami.append("\naction:");
    parami.append(paramString2);
    parami.append("\nevent_value:");
    parami.append(paramArrayOfl);
    b.d.w.c.a.c("CommonFireBaseUtil", parami.toString());
    n.b().f(paramString1, paramString2, paramArrayOfl);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */