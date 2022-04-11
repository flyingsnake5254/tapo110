package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;

public class GoogleApiAvailabilityCache
{
  private final SparseIntArray zaos = new SparseIntArray();
  private GoogleApiAvailabilityLight zaot;
  
  public GoogleApiAvailabilityCache()
  {
    this(GoogleApiAvailability.getInstance());
  }
  
  public GoogleApiAvailabilityCache(@NonNull GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight)
  {
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    this.zaot = paramGoogleApiAvailabilityLight;
  }
  
  public void flush()
  {
    this.zaos.clear();
  }
  
  public int getClientAvailability(@NonNull Context paramContext, @NonNull Api.Client paramClient)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    boolean bool = paramClient.requiresGooglePlayServices();
    int i = 0;
    if (!bool) {
      return 0;
    }
    int j = paramClient.getMinApkVersion();
    int k = this.zaos.get(j, -1);
    if (k != -1) {
      return k;
    }
    for (int m = 0; m < this.zaos.size(); m++)
    {
      int n = this.zaos.keyAt(m);
      if ((n > j) && (this.zaos.get(n) == 0))
      {
        m = i;
        break label117;
      }
    }
    m = k;
    label117:
    i = m;
    if (m == -1) {
      i = this.zaot.isGooglePlayServicesAvailable(paramContext, j);
    }
    this.zaos.put(j, i);
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\GoogleApiAvailabilityCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */