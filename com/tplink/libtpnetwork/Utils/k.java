package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class k
{
  private static k a;
  private String b = "PreferenceHelper";
  private Context c;
  private String d;
  private SharedPreferences e;
  private b f;
  
  public static k a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          k localk = new com/tplink/libtpnetwork/Utils/k;
          localk.<init>();
          a = localk;
        }
      }
      finally {}
    }
    return a;
  }
  
  private String b(String paramString1, String paramString2)
  {
    return this.e.getString(paramString1, paramString2);
  }
  
  private void d(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    SharedPreferences.Editor localEditor = this.e.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void c(Context paramContext, String paramString)
  {
    this.c = paramContext;
    this.d = paramString;
    this.e = paramContext.getSharedPreferences("DecoSmartPrefsFile", 0);
    this.f = new b(this.d);
  }
  
  public boolean e(String paramString, boolean paramBoolean)
  {
    return this.e.getBoolean(paramString, paramBoolean);
  }
  
  public String f(String paramString1, String paramString2)
  {
    if (this.f != null) {
      paramString1 = b(paramString1, paramString2);
    }
    try
    {
      paramString1 = this.f.c(paramString1, this.c);
      paramString2 = paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    return paramString2;
    return b(paramString1, paramString2);
  }
  
  public void g(String paramString)
  {
    SharedPreferences.Editor localEditor = this.e.edit();
    localEditor.remove(paramString);
    localEditor.commit();
  }
  
  public void h(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.e.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public void i(String paramString1, String paramString2)
  {
    b localb = this.f;
    if (localb != null) {
      if (paramString2 == null) {
        paramString2 = null;
      }
    }
    try
    {
      paramString2 = localb.f(paramString2, this.c);
      d(paramString1, paramString2);
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    d(paramString1, paramString2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */