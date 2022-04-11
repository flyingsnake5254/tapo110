package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import java.util.Collections;
import java.util.Map;

final class zabo
  implements Runnable
{
  zabo(GoogleApiManager.zac paramzac, ConnectionResult paramConnectionResult) {}
  
  public final void run()
  {
    if (this.zaiz.isSuccess())
    {
      GoogleApiManager.zac.zaa(this.zajg, true);
      if (GoogleApiManager.zac.zaa(this.zajg).requiresSignIn())
      {
        GoogleApiManager.zac.zab(this.zajg);
        return;
      }
      try
      {
        GoogleApiManager.zac.zaa(this.zajg).getRemoteService(null, Collections.emptySet());
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Log.e("GoogleApiManager", "Failed to get service from broker. ", localSecurityException);
        ((GoogleApiManager.zaa)GoogleApiManager.zaj(this.zajg.zaim).get(GoogleApiManager.zac.zac(this.zajg))).onConnectionFailed(new ConnectionResult(10));
        return;
      }
    }
    ((GoogleApiManager.zaa)GoogleApiManager.zaj(this.zajg.zaim).get(GoogleApiManager.zac.zac(this.zajg))).onConnectionFailed(this.zaiz);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zabo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */