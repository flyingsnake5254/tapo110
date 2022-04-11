package com.tplink.iot.view.quicksetup.base.f;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import b.d.w.c.a;

public class b
  implements LocationListener
{
  private String a = b.class.getSimpleName();
  private LocationListener b;
  private LocationManager c;
  
  public b(LocationListener paramLocationListener, LocationManager paramLocationManager)
  {
    this.b = paramLocationListener;
    this.c = paramLocationManager;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    LocationManager localLocationManager = this.c;
    if (localLocationManager != null) {
      try
      {
        localLocationManager.removeUpdates(this);
      }
      catch (SecurityException localSecurityException)
      {
        a.c(this.a, Log.getStackTraceString(localSecurityException));
      }
    }
    LocationListener localLocationListener = this.b;
    if (localLocationListener != null) {
      localLocationListener.onLocationChanged(paramLocation);
    }
  }
  
  public void onProviderDisabled(String paramString)
  {
    LocationListener localLocationListener = this.b;
    if (localLocationListener != null) {
      localLocationListener.onProviderDisabled(paramString);
    }
  }
  
  public void onProviderEnabled(String paramString)
  {
    LocationListener localLocationListener = this.b;
    if (localLocationListener != null) {
      localLocationListener.onProviderEnabled(paramString);
    }
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    LocationListener localLocationListener = this.b;
    if (localLocationListener != null) {
      localLocationListener.onStatusChanged(paramString, paramInt, paramBundle);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */