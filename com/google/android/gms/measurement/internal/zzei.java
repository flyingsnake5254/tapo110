package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

public final class zzei
  extends BaseGmsClient<zzed>
{
  public zzei(Context paramContext, Looper paramLooper, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 93, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  @NonNull
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
  
  @NonNull
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.measurement.START";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */