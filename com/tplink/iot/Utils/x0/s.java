package com.tplink.iot.Utils.x0;

import com.tplink.libtpnetwork.Utils.o;

public class s
{
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if (o.h0().L()) {
      return;
    }
    h.i("time", "different_client_region", new l[] { new l("isDifferent", Boolean.valueOf(paramBoolean)) });
    o.h0().R0();
  }
  
  public static void b(String paramString)
  {
    h.g("other", "sunrise_sunset_dialog", paramString, new l[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */