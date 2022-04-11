package com.google.android.gms.vision.clearcut;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@Keep
public class LoggingConnectionCallbacks
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public void onConnected(Bundle paramBundle)
  {
    throw new NoSuchMethodError();
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    throw new NoSuchMethodError();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\clearcut\LoggingConnectionCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */