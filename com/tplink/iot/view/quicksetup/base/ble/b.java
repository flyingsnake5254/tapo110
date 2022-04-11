package com.tplink.iot.view.quicksetup.base.ble;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

public class b
{
  private static final String[] a = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  
  public static void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt, a parama)
  {
    if (paramInt == 25) {
      if (b(paramArrayOfInt)) {
        parama.b();
      } else {
        parama.a();
      }
    }
  }
  
  private static boolean b(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length < a.length) {
      return false;
    }
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (Integer.valueOf(paramArrayOfInt[j]).intValue() != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static void c(Activity paramActivity)
  {
    ActivityCompat.requestPermissions(paramActivity, a, 25);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\ble\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */