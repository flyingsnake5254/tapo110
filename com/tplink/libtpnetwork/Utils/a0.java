package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import b.d.w.c.a;

public class a0
{
  public static String a()
  {
    String str1 = e();
    if ("dist".equals(str1)) {
      return "prod";
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = "beta";
    }
    return str2;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nbu.iot-app-server.app");
    localStringBuilder.append(i());
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nbu.iot-cloud-gateway.app");
    localStringBuilder.append(i());
    return localStringBuilder.toString();
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nbu.iot-security.appdevice");
    localStringBuilder.append(i());
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    return o.h0().f("sp_iot_test_environment", "");
  }
  
  public static String f()
  {
    return o.h0().f("sp_tapo_care_environment", "");
  }
  
  public static String g()
  {
    if (!j()) {
      return "tapocare.app.nbu";
    }
    String str = f();
    if ("dev".equals(str))
    {
      str = ".alpha";
    }
    else if ((!TextUtils.isEmpty(str)) && (!"dist".equals(str)) && (!"beta".equals(str)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
    }
    else
    {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tapocare.app.nbu");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String h()
  {
    if (!j()) {
      return "https://tapo.tplinkcloud.com";
    }
    String str = f();
    if ("dev".equals(str)) {
      return "https://tapo-alpha.tplinkcloud.com";
    }
    if ("beta2".equals(str)) {
      return "https://tapo-beta2.tplinkcloud.com";
    }
    if ("beta3".equals(str)) {
      return "https://tapo-beta3.tplinkcloud.com";
    }
    if ("staging".equals(str)) {
      return "https://tapo-staging.tplinkcloud.com";
    }
    if ("dist".equals(str)) {
      return "https://tapo.tplinkcloud.com";
    }
    return "https://tapo-care-beta.tplinknbu.com";
  }
  
  private static String i()
  {
    Object localObject1 = e();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getTestEnvi=");
    ((StringBuilder)localObject2).append((String)localObject1);
    a.e("test111", ((StringBuilder)localObject2).toString());
    if ("dist".equals(localObject1)) {
      return "";
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "beta";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append((String)localObject2);
    return ((StringBuilder)localObject1).toString();
  }
  
  public static boolean j()
  {
    return false;
  }
  
  public static boolean k()
  {
    return "dist".equals(e());
  }
  
  public static void l(String paramString)
  {
    o.h0().k("sp_iot_test_environment", paramString);
  }
  
  public static void m(String paramString)
  {
    o.h0().k("sp_tapo_care_environment", paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */