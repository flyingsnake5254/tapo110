package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

final class zza
  extends AsyncTask<Void, Void, Integer>
{
  zza(Context paramContext, ProviderInstaller.ProviderInstallListener paramProviderInstallListener) {}
  
  private final Integer zza(Void... paramVarArgs)
  {
    try
    {
      ProviderInstaller.installIfNeeded(this.val$context);
      return Integer.valueOf(0);
    }
    catch (GooglePlayServicesNotAvailableException paramVarArgs)
    {
      return Integer.valueOf(paramVarArgs.errorCode);
    }
    catch (GooglePlayServicesRepairableException paramVarArgs) {}
    return Integer.valueOf(paramVarArgs.getConnectionStatusCode());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\security\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */