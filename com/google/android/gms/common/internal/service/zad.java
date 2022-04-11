package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zad
  implements zac
{
  public final PendingResult<Status> zaa(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new zae(this, paramGoogleApiClient));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\service\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */