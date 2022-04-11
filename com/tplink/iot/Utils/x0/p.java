package com.tplink.iot.Utils.x0;

import android.text.TextUtils;

public class p
{
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    } else {
      paramString = b.d.w.h.a.g(paramString);
    }
    h.k("account_opt", "agree_privacy_policy", new l[] { new l("user_email", paramString) });
  }
  
  public static void b()
  {
    h.i("account_opt", "change_avatar", new l[0]);
  }
  
  public static void c()
  {
    h.i("account_opt", "change_nickname", new l[0]);
  }
  
  public static void d()
  {
    h.i("account_opt", "change_pwd", new l[0]);
  }
  
  public static void e(String paramString)
  {
    h.k("account_opt", "forget_pwd", new l[] { new l("user_email", paramString) });
  }
  
  public static void f()
  {
    h.k("account_opt", "login_click", new l[] { new l("user_email", "") });
  }
  
  public static void g(Integer paramInteger, String paramString)
  {
    if ((paramInteger != null) && (paramInteger.intValue() != 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        paramString = "";
      } else {
        paramString = b.d.w.h.a.g(paramString);
      }
      h.k("account_opt", "login_failed", new l[] { new l("user_email", paramString), new l("error_code", paramInteger) });
    }
  }
  
  public static void h()
  {
    h.k("account_opt", "login_progress", new l[] { new l("screen", "InfoInputPage") });
  }
  
  public static void i()
  {
    String str;
    if (TextUtils.isEmpty(b.d.s.a.a.h())) {
      str = "";
    } else {
      str = b.d.s.a.a.h();
    }
    h.k("account_opt", "login_succeed", new l[] { new l("user_email", str) });
  }
  
  public static void j()
  {
    h.i("account_opt", "logout", new l[0]);
  }
  
  public static void k()
  {
    h.k("account_opt", "sign_click", new l[] { new l("user_email", "") });
  }
  
  public static void l()
  {
    h.k("account_opt", "sign_progress", new l[] { new l("screen", "ActivePage") });
  }
  
  public static void m()
  {
    h.k("account_opt", "sign_progress", new l[] { new l("screen", "SetUpPage") });
  }
  
  public static void n(String paramString, Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() != 16))
    {
      if (TextUtils.isEmpty(paramString)) {
        paramString = "";
      } else {
        paramString = b.d.w.h.a.g(paramString);
      }
      h.k("account_opt", "sign_failed", new l[] { new l("user_email", paramString), new l("error_code", paramInteger) });
    }
  }
  
  public static void o(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    } else {
      paramString = b.d.w.h.a.g(paramString);
    }
    h.k("account_opt", "sign_succeed", new l[] { new l("user_email", paramString) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */