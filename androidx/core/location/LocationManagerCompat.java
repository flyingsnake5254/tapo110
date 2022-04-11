package androidx.core.location;

import android.location.LocationManager;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class LocationManagerCompat
{
  public static boolean isLocationEnabled(@NonNull LocationManager paramLocationManager)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramLocationManager.isLocationEnabled();
    }
    boolean bool;
    if ((!paramLocationManager.isProviderEnabled("network")) && (!paramLocationManager.isProviderEnabled("gps"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\location\LocationManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */