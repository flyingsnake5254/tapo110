package com.tplink.iot.Utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import b.d.c.a.e;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.k;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import com.tplink.libtputility.security.c;
import com.tplink.libtputility.security.c.b;

public class n
{
  private static n a;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private FirebaseAnalytics f;
  private c g;
  private Context h;
  private final int i = 100;
  
  public static n b()
  {
    if (a == null) {
      a = new n();
    }
    return a;
  }
  
  private String c(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Base64.encode(this.g.d(paramString), 2);
      paramString = new java/lang/String;
      paramString.<init>(arrayOfByte, "UTF-8");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = "";
    }
    return paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    FirebaseAnalytics localFirebaseAnalytics = this.f;
    if (localFirebaseAnalytics != null) {
      localFirebaseAnalytics.setAnalyticsCollectionEnabled(paramBoolean);
    }
  }
  
  public void d(Context paramContext)
  {
    this.h = paramContext;
    this.f = FirebaseAnalytics.getInstance(paramContext);
    this.g = new c.b().b(PlainEncryptKeyDelegate.e()).a();
  }
  
  public void e(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, "");
  }
  
  public void f(String paramString1, String paramString2, String paramString3)
  {
    if ((a != null) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject3;
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject1 = b.d.s.a.a.d();
        Object localObject2 = paramString3;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          try
          {
            localObject2 = (k)i.b(paramString3, k.class);
            ((k)localObject2).m("account_id", (String)localObject1);
            localObject2 = i.f(localObject2);
          }
          catch (Exception localException)
          {
            b.d.w.c.a.a("FirebaseAnalytics gson exception");
            localObject3 = paramString3;
          }
        }
        paramString3 = c((String)localObject3);
      }
      else
      {
        localObject1 = "";
        localObject3 = paramString3;
        paramString3 = (String)localObject1;
      }
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("event_action", paramString2);
      Bundle localBundle = new Bundle();
      localBundle.putString("event_action", paramString2);
      localBundle.putString("event_label", (String)localObject3);
      e.l().f(paramString1, localBundle);
      int j = paramString3.length();
      if (j <= 100)
      {
        ((Bundle)localObject1).putString("event_value", paramString3);
      }
      else
      {
        int k = 0;
        int m = 0;
        for (;;)
        {
          int n = j - k;
          if (n <= 0) {
            break;
          }
          if (n > 100)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("event_value");
            ((StringBuilder)localObject3).append(m);
            ((Bundle)localObject1).putString(((StringBuilder)localObject3).toString(), paramString3.substring(k, k + 100));
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("event_value");
            ((StringBuilder)localObject3).append(m);
            ((Bundle)localObject1).putString(((StringBuilder)localObject3).toString(), paramString3.substring(k, j));
          }
          m++;
          k += 100;
        }
      }
      try
      {
        this.f.logEvent(paramString1, (Bundle)localObject1);
      }
      catch (Exception paramString3)
      {
        b.d.w.c.a.a("FirebaseAnalytics logEvent exception");
      }
      c = b;
      b = paramString1;
      e = d;
      d = paramString2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */