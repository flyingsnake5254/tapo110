package com.tplink.iot.Utils.v0;

import com.tplink.iot.core.n;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.x;

public class e
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g;
  
  static
  {
    String str = a0.h();
    a = str;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/tapo_app/#/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/tapo_app/#/tapolist");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/tapo_app/#/intro/subscribe/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/tapo_app/#/intro/trial/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/tapo_app/#/reselect-devices");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/tapo_app/#/trialCancel");
    g = localStringBuilder.toString();
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("termID=");
    localStringBuilder.append(n.a);
    localStringBuilder.append("&ospf=");
    localStringBuilder.append(n.b);
    localStringBuilder.append("&appName=");
    localStringBuilder.append(n.d);
    localStringBuilder.append("&netType=wifi&platform=android&lang=");
    localStringBuilder.append(x.c());
    localStringBuilder.append("&environment=");
    localStringBuilder.append(b());
    localStringBuilder.append("&usertoken=");
    return localStringBuilder.toString();
  }
  
  private static String b()
  {
    return "prd";
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(e());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(e());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AIDetection?");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(p());
    localStringBuilder.append(c.a());
    return localStringBuilder.toString();
  }
  
  public static String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(p());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloudVideo?");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  public static String i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(h());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(h());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&status=ok");
    return localStringBuilder.toString();
  }
  
  public static String k(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(h());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String l(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(p());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&deviceType=");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotionTracking?");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  public static String n(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(m());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String o(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(m());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  private static String q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrivacyMask?");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  public static String r(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(q());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String s(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(q());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RichNotification?");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  public static String u(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(t());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String v(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(t());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&deviceId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String w(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f);
    localStringBuilder.append(p());
    localStringBuilder.append(c.a());
    localStringBuilder.append("&orderId=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&newDeviceNum=");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String x()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(p());
    localStringBuilder.append(c.a());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */