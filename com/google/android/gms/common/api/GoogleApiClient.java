package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient
{
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  @GuardedBy("sAllClients")
  private static final Set<GoogleApiClient> zabq = Collections.newSetFromMap(new WeakHashMap());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Set localSet = zabq;
    int i = 0;
    try
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i++;
      }
      return;
    }
    finally {}
  }
  
  @KeepForSdk
  public static Set<GoogleApiClient> getAllClients()
  {
    synchronized (zabq)
    {
      return (Set<GoogleApiClient>)???;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @KeepForSdk
  public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  @KeepForSdk
  public <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> paramAnyClientKey)
  {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);
  
  @KeepForSdk
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public boolean hasApi(@NonNull Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(@NonNull Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @KeepForSdk
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public void maybeSignOut()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @KeepForSdk
  public <L> ListenerHolder<L> registerListener(@NonNull L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void zaa(zacm paramzacm)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zab(zacm paramzacm)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public static final class Builder
  {
    private final Context mContext;
    private Looper zabj;
    private final Set<Scope> zabr = new HashSet();
    private final Set<Scope> zabs = new HashSet();
    private int zabt;
    private View zabu;
    private String zabv;
    private String zabw;
    private final Map<Api<?>, ClientSettings.OptionalApiSettings> zabx = new ArrayMap();
    private boolean zaby = false;
    private final Map<Api<?>, Api.ApiOptions> zabz = new ArrayMap();
    private LifecycleActivity zaca;
    private int zacb = -1;
    private GoogleApiClient.OnConnectionFailedListener zacc;
    private GoogleApiAvailability zacd = GoogleApiAvailability.getInstance();
    private Api.AbstractClientBuilder<? extends zad, SignInOptions> zace = zaa.zaph;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zacf = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zacg = new ArrayList();
    private boolean zach = false;
    private Account zax;
    
    @KeepForSdk
    public Builder(@NonNull Context paramContext)
    {
      this.mContext = paramContext;
      this.zabj = paramContext.getMainLooper();
      this.zabv = paramContext.getPackageName();
      this.zabw = paramContext.getClass().getName();
    }
    
    @KeepForSdk
    public Builder(@NonNull Context paramContext, @NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      Preconditions.checkNotNull(paramConnectionCallbacks, "Must provide a connected listener");
      this.zacf.add(paramConnectionCallbacks);
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.zacg.add(paramOnConnectionFailedListener);
    }
    
    private final <O extends Api.ApiOptions> void zaa(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      paramO = new HashSet(paramApi.zah().getImpliedScopes(paramO));
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        paramO.add(paramVarArgs[j]);
      }
      this.zabx.put(paramApi, new ClientSettings.OptionalApiSettings(paramO));
    }
    
    public final Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zabz.put(paramApi, null);
      paramApi = paramApi.zah().getImpliedScopes(null);
      this.zabs.addAll(paramApi);
      this.zabr.addAll(paramApi);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> paramApi, @NonNull O paramO)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zabz.put(paramApi, paramO);
      paramApi = paramApi.zah().getImpliedScopes(paramO);
      this.zabs.addAll(paramApi);
      this.zabr.addAll(paramApi);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> paramApi, @NonNull O paramO, Scope... paramVarArgs)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zabz.put(paramApi, paramO);
      zaa(paramApi, paramO, paramVarArgs);
      return this;
    }
    
    public final Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zabz.put(paramApi, null);
      zaa(paramApi, null, paramVarArgs);
      return this;
    }
    
    public final Builder addConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      Preconditions.checkNotNull(paramConnectionCallbacks, "Listener must not be null");
      this.zacf.add(paramConnectionCallbacks);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Listener must not be null");
      this.zacg.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public final Builder addScope(@NonNull Scope paramScope)
    {
      Preconditions.checkNotNull(paramScope, "Scope must not be null");
      this.zabr.add(paramScope);
      return this;
    }
    
    @KeepForSdk
    public final Builder addScopeNames(String[] paramArrayOfString)
    {
      for (int i = 0; i < paramArrayOfString.length; i++) {
        this.zabr.add(new Scope(paramArrayOfString[i]));
      }
      return this;
    }
    
    public final GoogleApiClient build()
    {
      Preconditions.checkArgument(this.zabz.isEmpty() ^ true, "must call addApi() to add at least one API");
      ClientSettings localClientSettings = buildClientSettings();
      ??? = null;
      Map localMap = localClientSettings.getOptionalApiSettings();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      Object localObject2 = new ArrayList();
      Iterator localIterator = this.zabz.keySet().iterator();
      int i = 0;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject3 = (Api)localIterator.next();
        Object localObject5 = this.zabz.get(localObject3);
        if (localMap.get(localObject3) != null) {
          bool = true;
        } else {
          bool = false;
        }
        localArrayMap1.put(localObject3, Boolean.valueOf(bool));
        Object localObject6 = new zaq((Api)localObject3, bool);
        ((ArrayList)localObject2).add(localObject6);
        Api.AbstractClientBuilder localAbstractClientBuilder = ((Api)localObject3).zai();
        localObject6 = localAbstractClientBuilder.buildClient(this.mContext, this.zabj, localClientSettings, localObject5, (GoogleApiClient.ConnectionCallbacks)localObject6, (GoogleApiClient.OnConnectionFailedListener)localObject6);
        localArrayMap2.put(((Api)localObject3).getClientKey(), localObject6);
        j = i;
        if (localAbstractClientBuilder.getPriority() == 1) {
          if (localObject5 != null) {
            j = 1;
          } else {
            j = 0;
          }
        }
        i = j;
        if (((Api.Client)localObject6).providesSignIn()) {
          if (??? == null)
          {
            ??? = localObject3;
            i = j;
          }
          else
          {
            localObject3 = ((Api)localObject3).getName();
            localObject2 = ((Api)???).getName();
            ??? = new StringBuilder(String.valueOf(localObject3).length() + 21 + String.valueOf(localObject2).length());
            ((StringBuilder)???).append((String)localObject3);
            ((StringBuilder)???).append(" cannot be used with ");
            ((StringBuilder)???).append((String)localObject2);
            throw new IllegalStateException(((StringBuilder)???).toString());
          }
        }
      }
      if (??? != null) {
        if (i == 0)
        {
          if (this.zax == null) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkState(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)???).getName() });
          Preconditions.checkState(this.zabr.equals(this.zabs), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)???).getName() });
        }
        else
        {
          localObject3 = ((Api)???).getName();
          ??? = new StringBuilder(String.valueOf(localObject3).length() + 82);
          ((StringBuilder)???).append("With using ");
          ((StringBuilder)???).append((String)localObject3);
          ((StringBuilder)???).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          throw new IllegalStateException(((StringBuilder)???).toString());
        }
      }
      int j = zaaw.zaa(localArrayMap2.values(), true);
      Object localObject3 = new zaaw(this.mContext, new ReentrantLock(), this.zabj, localClientSettings, this.zacd, this.zace, localArrayMap1, this.zacf, this.zacg, localArrayMap2, this.zacb, j, (ArrayList)localObject2, false);
      synchronized (GoogleApiClient.zal())
      {
        GoogleApiClient.zal().add(localObject3);
        if (this.zacb >= 0) {
          zaj.zaa(this.zaca).zaa(this.zacb, (GoogleApiClient)localObject3, this.zacc);
        }
        return (GoogleApiClient)localObject3;
      }
    }
    
    @KeepForSdk
    @VisibleForTesting
    public final ClientSettings buildClientSettings()
    {
      SignInOptions localSignInOptions = SignInOptions.DEFAULT;
      Map localMap = this.zabz;
      Api localApi = zaa.API;
      if (localMap.containsKey(localApi)) {
        localSignInOptions = (SignInOptions)this.zabz.get(localApi);
      }
      return new ClientSettings(this.zax, this.zabr, this.zabx, this.zabt, this.zabu, this.zabv, this.zabw, localSignInOptions, false);
    }
    
    public final Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "clientId must be non-negative");
      this.zacb = paramInt;
      this.zacc = paramOnConnectionFailedListener;
      this.zaca = paramFragmentActivity;
      return this;
    }
    
    public final Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }
    
    public final Builder setAccountName(String paramString)
    {
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = new Account(paramString, "com.google");
      }
      this.zax = paramString;
      return this;
    }
    
    public final Builder setGravityForPopups(int paramInt)
    {
      this.zabt = paramInt;
      return this;
    }
    
    public final Builder setHandler(@NonNull Handler paramHandler)
    {
      Preconditions.checkNotNull(paramHandler, "Handler must not be null");
      this.zabj = paramHandler.getLooper();
      return this;
    }
    
    public final Builder setViewForPopups(@NonNull View paramView)
    {
      Preconditions.checkNotNull(paramView, "View must not be null");
      this.zabu = paramView;
      return this;
    }
    
    public final Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(@Nullable Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */