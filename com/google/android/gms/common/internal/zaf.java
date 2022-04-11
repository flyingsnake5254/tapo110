package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

final class zaf
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zaf(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {}
  
  public final void onConnected(@Nullable Bundle paramBundle)
  {
    this.zaoj.onConnected(paramBundle);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    this.zaoj.onConnectionSuspended(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */