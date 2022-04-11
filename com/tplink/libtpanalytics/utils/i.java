package com.tplink.libtpanalytics.utils;

import b.d.w.c.a;
import com.tplink.libtpanalytics.database.d.b;

public class i
{
  public static boolean a = true;
  
  public static void a(String paramString)
  {
    if (a) {
      a.c("TPA", paramString);
    }
  }
  
  public static void b(String paramString)
  {
    if (a) {
      a.e("TPA", paramString);
    }
  }
  
  public static void c(String paramString)
  {
    if (a) {
      a.i("TPA", paramString);
    }
  }
  
  public static void d(b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.f());
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramb.d());
    c(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */