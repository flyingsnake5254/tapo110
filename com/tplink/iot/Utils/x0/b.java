package com.tplink.iot.Utils.x0;

public class b
{
  public static void a()
  {
    h.k("app_data", "app_startup", new l[0]);
  }
  
  public static void b(long paramLong1, long paramLong2)
  {
    h.i("app_data", "foreground_time", new l[] { new l("duration", Long.valueOf(paramLong1 - paramLong2)) });
  }
  
  public static void c(boolean paramBoolean)
  {
    h.i("app_data", "privacy_switch", new l[] { new l("status", h.c(paramBoolean)) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */