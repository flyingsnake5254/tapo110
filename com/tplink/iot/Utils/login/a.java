package com.tplink.iot.Utils.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import b.d.q.b.i;
import com.tplink.iot.Utils.u;
import com.tplink.iot.Utils.y0.d;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.libtpnetwork.Utils.o;
import java.util.Locale;

public class a
{
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject1 = null;
    if (localTelephonyManager != null)
    {
      localObject2 = localTelephonyManager.getSimCountryIso();
      localObject3 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject3 = localTelephonyManager.getNetworkCountryIso();
      }
    }
    else
    {
      localObject3 = null;
    }
    Object localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = paramContext.getResources().getConfiguration().locale.getCountry();
    }
    Object localObject3 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (TextUtils.isEmpty(c(paramContext, (String)localObject2))) {
        localObject3 = localObject1;
      } else {
        localObject3 = localObject2;
      }
    }
    return (String)localObject3;
  }
  
  public static String b(Context paramContext)
  {
    String str = a(paramContext);
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    String str = "";
    try
    {
      int i = CloudRegionCode.fromSymbol(paramString);
      paramString = str;
      if (-1 != i) {
        paramString = paramContext.getString(i);
      }
    }
    catch (Exception paramContext)
    {
      b.d.w.c.a.e("LoginUtils", "getRegionStr error");
      paramString = str;
    }
    return paramString;
  }
  
  private static void d(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing()))
    {
      Intent localIntent = new Intent(paramActivity, LoginActivity.class);
      String str = i.b();
      if ((!TextUtils.isEmpty(str)) && (o.h0().u())) {
        localIntent.putExtra("SignUpEmail", str);
      }
      localIntent.putExtra("SignUpE_pwd_error", true);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static boolean e(Context paramContext)
  {
    return Locale.US.getLanguage().equalsIgnoreCase(paramContext.getResources().getConfiguration().locale.getLanguage());
  }
  
  public static boolean f(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return CloudRegionCode.isSymbolEuRegion(paramString);
  }
  
  public static void g(Activity paramActivity)
  {
    u.a(paramActivity);
    c.c();
    d.a(AppContext.c);
    d(paramActivity);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\login\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */