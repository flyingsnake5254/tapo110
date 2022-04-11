package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.zad;
import java.util.concurrent.locks.Lock;

final class zaat
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zaat(zaak paramzaak) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    if (zaak.zai(this.zagj).isSignInClientDisconnectFixEnabled())
    {
      zaak.zac(this.zagj).lock();
      try
      {
        paramBundle = zaak.zaf(this.zagj);
        if (paramBundle == null) {
          return;
        }
        zad localzad = zaak.zaf(this.zagj);
        paramBundle = new com/google/android/gms/common/api/internal/zaar;
        paramBundle.<init>(this.zagj);
        localzad.zaa(paramBundle);
        return;
      }
      finally
      {
        zaak.zac(this.zagj).unlock();
      }
    }
    zaak.zaf(this.zagj).zaa(new zaar(this.zagj));
  }
  
  public final void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    zaak.zac(this.zagj).lock();
    try
    {
      if (zaak.zab(this.zagj, paramConnectionResult))
      {
        zaak.zaj(this.zagj);
        zaak.zak(this.zagj);
      }
      else
      {
        zaak.zaa(this.zagj, paramConnectionResult);
      }
      return;
    }
    finally
    {
      zaak.zac(this.zagj).unlock();
    }
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */