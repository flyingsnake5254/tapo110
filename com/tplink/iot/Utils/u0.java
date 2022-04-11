package com.tplink.iot.Utils;

import android.content.Context;
import android.os.Vibrator;
import com.tplink.libtpnetwork.Utils.o;

public class u0
{
  public static void a(Context paramContext, long paramLong)
  {
    if (b()) {
      ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(paramLong);
    }
  }
  
  public static boolean b()
  {
    return o.h0().f0();
  }
  
  public static void c(boolean paramBoolean)
  {
    o.h0().j1(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */