package com.tplink.iot.core;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tplink.libtpnetwork.Utils.o;

public class n
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static int e;
  public static String f;
  public static String g;
  public static String h = "1";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    b = localStringBuilder.toString();
    String str = Build.MODEL;
    f = str;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    g = localStringBuilder.toString();
  }
  
  public static b.d.s.a.b.a a()
  {
    return new b.d.s.a.b.a("TP-Link_Tapo_Android", a, b, c, d, e, b());
  }
  
  private static String b()
  {
    String str = o.h0().Q();
    if (org.apache.commons.lang.e.a(str)) {
      FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new e(str));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("localDeviceToken=");
    localStringBuilder.append(str);
    b.d.w.c.a.c("deviceToken", localStringBuilder.toString());
    return str;
  }
  
  public static String c()
  {
    return "https://n-wap-gw.tplinkcloud.com";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */