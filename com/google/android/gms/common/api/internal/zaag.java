package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zaag
  extends GoogleApiClient
{
  private final String zafs;
  
  public zaag(String paramString)
  {
    this.zafs = paramString;
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void connect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void disconnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  @NonNull
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean hasConnectedApi(@NonNull Api<?> paramApi)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnected()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnecting()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void reconnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */