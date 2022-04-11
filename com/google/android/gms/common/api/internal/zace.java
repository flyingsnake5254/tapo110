package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace
  extends zac
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static Api.AbstractClientBuilder<? extends zad, SignInOptions> zaki = zaa.zaph;
  private final Context mContext;
  private final Handler mHandler;
  private Set<Scope> mScopes;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zaau;
  private ClientSettings zaet;
  private zad zagb;
  private zach zakj;
  
  @WorkerThread
  public zace(Context paramContext, Handler paramHandler, @NonNull ClientSettings paramClientSettings)
  {
    this(paramContext, paramHandler, paramClientSettings, zaki);
  }
  
  @WorkerThread
  public zace(Context paramContext, Handler paramHandler, @NonNull ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zaet = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings, "ClientSettings must not be null"));
    this.mScopes = paramClientSettings.getRequiredScopes();
    this.zaau = paramAbstractClientBuilder;
  }
  
  @WorkerThread
  private final void zac(zaj paramzaj)
  {
    Object localObject = paramzaj.getConnectionResult();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramzaj.zacx();
      paramzaj = ((ResolveAccountResponse)localObject).getConnectionResult();
      if (!paramzaj.isSuccess())
      {
        String str = String.valueOf(paramzaj);
        localObject = new StringBuilder(str.length() + 48);
        ((StringBuilder)localObject).append("Sign-in succeeded with resolve account failure: ");
        ((StringBuilder)localObject).append(str);
        Log.wtf("SignInCoordinator", ((StringBuilder)localObject).toString(), new Exception());
        this.zakj.zag(paramzaj);
        this.zagb.disconnect();
        return;
      }
      this.zakj.zaa(((ResolveAccountResponse)localObject).getAccountAccessor(), this.mScopes);
    }
    else
    {
      this.zakj.zag((ConnectionResult)localObject);
    }
    this.zagb.disconnect();
  }
  
  @WorkerThread
  public final void onConnected(@Nullable Bundle paramBundle)
  {
    this.zagb.zaa(this);
  }
  
  @WorkerThread
  public final void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    this.zakj.zag(paramConnectionResult);
  }
  
  @WorkerThread
  public final void onConnectionSuspended(int paramInt)
  {
    this.zagb.disconnect();
  }
  
  @WorkerThread
  public final void zaa(zach paramzach)
  {
    Object localObject = this.zagb;
    if (localObject != null) {
      ((Api.Client)localObject).disconnect();
    }
    this.zaet.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
    Api.AbstractClientBuilder localAbstractClientBuilder = this.zaau;
    Context localContext = this.mContext;
    localObject = this.mHandler.getLooper();
    ClientSettings localClientSettings = this.zaet;
    this.zagb = ((zad)localAbstractClientBuilder.buildClient(localContext, (Looper)localObject, localClientSettings, localClientSettings.getSignInOptions(), this, this));
    this.zakj = paramzach;
    paramzach = this.mScopes;
    if ((paramzach != null) && (!paramzach.isEmpty()))
    {
      this.zagb.connect();
      return;
    }
    this.mHandler.post(new zacf(this));
  }
  
  @BinderThread
  public final void zab(zaj paramzaj)
  {
    this.mHandler.post(new zacg(this, paramzaj));
  }
  
  public final zad zabq()
  {
    return this.zagb;
  }
  
  public final void zabs()
  {
    zad localzad = this.zagb;
    if (localzad != null) {
      localzad.disconnect();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */