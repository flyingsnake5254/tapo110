package com.tplink.iot.Utils;

import b.d.w.c.a;

public class v
{
  public static void a(Class paramClass1, Class paramClass2, String paramString)
  {
    a.e("OnboardingLog", String.format("from %s to %s, errMsg=%s.", new Object[] { paramClass1.getSimpleName(), paramClass2.getSimpleName(), paramString }));
  }
  
  public static void b(String paramString)
  {
    a.e("OnboardingLog", paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */