package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzj
  extends GmsClient<zzn>
{
  public zzj(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 40, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final int getMinApkVersion()
  {
    return 11925000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.clearcut.service.START";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */