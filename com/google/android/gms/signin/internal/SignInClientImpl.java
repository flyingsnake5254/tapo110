package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInOptions;

@KeepForSdk
public class SignInClientImpl
  extends GmsClient<zaf>
  implements com.google.android.gms.signin.zad
{
  private final ClientSettings zaet;
  private Integer zaoe;
  private final boolean zasb = true;
  private final Bundle zasc;
  
  private SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zaet = paramClientSettings;
    this.zasc = paramBundle;
    this.zaoe = paramClientSettings.getClientSessionId();
  }
  
  public SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, SignInOptions paramSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, true, paramClientSettings, createBundleFromClientSettings(paramClientSettings), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  @KeepForSdk
  public static Bundle createBundleFromClientSettings(ClientSettings paramClientSettings)
  {
    SignInOptions localSignInOptions = paramClientSettings.getSignInOptions();
    Integer localInteger = paramClientSettings.getClientSessionId();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramClientSettings.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localSignInOptions != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localSignInOptions.isOfflineAccessRequested());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localSignInOptions.isIdTokenRequested());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localSignInOptions.getServerClientId());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localSignInOptions.isForceCodeForRefreshToken());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localSignInOptions.getHostedDomain());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localSignInOptions.waitForAccessTokenRefresh());
      if (localSignInOptions.getAuthApiSignInModuleVersion() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localSignInOptions.getAuthApiSignInModuleVersion().longValue());
      }
      if (localSignInOptions.getRealClientLibraryVersion() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localSignInOptions.getRealClientLibraryVersion().longValue());
      }
    }
    return localBundle;
  }
  
  public final void connect()
  {
    connect(new BaseGmsClient.LegacyClientCallbackAdapter(this));
  }
  
  protected Bundle getGetServiceRequestExtraArgs()
  {
    String str = this.zaet.getRealClientPackageName();
    if (!getContext().getPackageName().equals(str)) {
      this.zasc.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zaet.getRealClientPackageName());
    }
    return this.zasc;
  }
  
  public int getMinApkVersion()
  {
    return 12451000;
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  public boolean requiresSignIn()
  {
    return this.zasb;
  }
  
  public final void zaa(IAccountAccessor paramIAccountAccessor, boolean paramBoolean)
  {
    try
    {
      ((zaf)getService()).zaa(paramIAccountAccessor, this.zaoe.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public final void zaa(zad paramzad)
  {
    Preconditions.checkNotNull(paramzad, "Expecting a valid ISignInCallbacks");
    try
    {
      localObject1 = this.zaet.getAccountOrDefault();
      Object localObject2 = null;
      if ("<<default account>>".equals(((Account)localObject1).name)) {
        localObject2 = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
      }
      ResolveAccountRequest localResolveAccountRequest = new com/google/android/gms/common/internal/ResolveAccountRequest;
      localResolveAccountRequest.<init>((Account)localObject1, this.zaoe.intValue(), (GoogleSignInAccount)localObject2);
      localObject1 = (zaf)getService();
      localObject2 = new com/google/android/gms/signin/internal/zah;
      ((zah)localObject2).<init>(localResolveAccountRequest);
      ((zaf)localObject1).zaa((zah)localObject2, paramzad);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Object localObject1;
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        localObject1 = new com/google/android/gms/signin/internal/zaj;
        ((zaj)localObject1).<init>(8);
        paramzad.zab((zaj)localObject1);
        return;
      }
      catch (RemoteException paramzad)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  public final void zacw()
  {
    try
    {
      ((zaf)getService()).zam(this.zaoe.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\signin\internal\SignInClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */