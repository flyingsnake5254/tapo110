package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.service.zac;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaaw
  extends GoogleApiClient
  implements zabt
{
  private final Context mContext;
  private final Looper zabj;
  private final int zacb;
  private final GoogleApiAvailability zacd;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  private boolean zach;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api<?>, Boolean> zaew;
  @VisibleForTesting
  final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafc = new LinkedList();
  private final GmsClientEventManager zags;
  private zabs zagt = null;
  private volatile boolean zagu;
  private long zagv;
  private long zagw;
  private final zabb zagx;
  @VisibleForTesting
  private zabq zagy;
  final Map<Api.AnyClientKey<?>, Api.Client> zagz;
  Set<Scope> zaha;
  private final ListenerHolders zahb;
  private final ArrayList<zaq> zahc;
  private Integer zahd;
  Set<zacm> zahe;
  final zacp zahf;
  private final GmsClientEventManager.GmsClientEventState zahg;
  
  public zaaw(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, int paramInt1, int paramInt2, ArrayList<zaq> paramArrayList, boolean paramBoolean)
  {
    long l;
    if (ClientLibraryUtils.isPackageSide()) {
      l = 10000L;
    } else {
      l = 120000L;
    }
    this.zagv = l;
    this.zagw = 5000L;
    this.zaha = new HashSet();
    this.zahb = new ListenerHolders();
    this.zahd = null;
    this.zahe = null;
    zaax localzaax = new zaax(this);
    this.zahg = localzaax;
    this.mContext = paramContext;
    this.zaeo = paramLock;
    this.zach = false;
    this.zags = new GmsClientEventManager(paramLooper, localzaax);
    this.zabj = paramLooper;
    this.zagx = new zabb(this, paramLooper);
    this.zacd = paramGoogleApiAvailability;
    this.zacb = paramInt1;
    if (paramInt1 >= 0) {
      this.zahd = Integer.valueOf(paramInt2);
    }
    this.zaew = paramMap;
    this.zagz = paramMap1;
    this.zahc = paramArrayList;
    this.zahf = new zacp(paramMap1);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      this.zags.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      this.zags.registerConnectionFailedListener(paramLock);
    }
    this.zaet = paramClientSettings;
    this.zace = paramAbstractClientBuilder;
  }
  
  private final void resume()
  {
    this.zaeo.lock();
    try
    {
      if (this.zagu) {
        zaau();
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public static int zaa(Iterable<Api.Client> paramIterable, boolean paramBoolean)
  {
    Iterator localIterator = paramIterable.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      paramIterable = (Api.Client)localIterator.next();
      int k = i;
      if (paramIterable.requiresSignIn()) {
        k = 1;
      }
      i = k;
      if (paramIterable.providesSignIn())
      {
        j = 1;
        i = k;
      }
    }
    if (i != 0)
    {
      if ((j != 0) && (paramBoolean)) {
        return 2;
      }
      return 1;
    }
    return 3;
  }
  
  private final void zaa(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean)
  {
    Common.zapi.zaa(paramGoogleApiClient).setResultCallback(new zaba(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
  }
  
  @GuardedBy("mLock")
  private final void zaau()
  {
    this.zags.enableCallbacks();
    this.zagt.connect();
  }
  
  private final void zaav()
  {
    this.zaeo.lock();
    try
    {
      if (zaaw()) {
        zaau();
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  private final void zae(int paramInt)
  {
    Object localObject1 = this.zahd;
    if (localObject1 == null) {
      this.zahd = Integer.valueOf(paramInt);
    } else {
      if (((Integer)localObject1).intValue() != paramInt) {
        break label386;
      }
    }
    if (this.zagt != null) {
      return;
    }
    Object localObject2 = this.zagz.values().iterator();
    int i = 0;
    paramInt = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Api.Client)((Iterator)localObject2).next();
      j = i;
      if (((Api.Client)localObject1).requiresSignIn()) {
        j = 1;
      }
      i = j;
      if (((Api.Client)localObject1).providesSignIn())
      {
        paramInt = 1;
        i = j;
      }
    }
    int j = this.zahd.intValue();
    if (j != 1)
    {
      if ((j == 2) && (i != 0))
      {
        if (this.zach)
        {
          this.zagt = new zax(this.mContext, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc, this, true);
          return;
        }
        this.zagt = zas.zaa(this.mContext, this, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc);
      }
    }
    else
    {
      if (i == 0) {
        break label375;
      }
      if (paramInt != 0) {
        break label364;
      }
    }
    if ((this.zach) && (paramInt == 0))
    {
      this.zagt = new zax(this.mContext, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc, this, false);
      return;
    }
    this.zagt = new zabe(this.mContext, this, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc, this);
    return;
    label364:
    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
    label375:
    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    label386:
    localObject1 = zaf(paramInt);
    localObject2 = zaf(this.zahd.intValue());
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1).length() + 51 + String.valueOf(localObject2).length());
    localStringBuilder.append("Cannot use sign-in mode: ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(". Mode was already set to ");
    localStringBuilder.append((String)localObject2);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static String zaf(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
      }
      return "SIGN_IN_MODE_OPTIONAL";
    }
    return "SIGN_IN_MODE_REQUIRED";
  }
  
  public final ConnectionResult blockingConnect()
  {
    Object localObject1 = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool1 = true;
    boolean bool2;
    if (localObject1 != localLooper) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkState(bool2, "blockingConnect must not be called on the UI thread");
    this.zaeo.lock();
    try
    {
      if (this.zacb >= 0)
      {
        if (this.zahd != null) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        Preconditions.checkState(bool2, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else
      {
        localObject1 = this.zahd;
        if (localObject1 == null) {
          this.zahd = Integer.valueOf(zaa(this.zagz.values(), false));
        } else {
          if (((Integer)localObject1).intValue() == 2) {
            break label154;
          }
        }
      }
      zae(this.zahd.intValue());
      this.zags.enableCallbacks();
      localObject1 = this.zagt.blockingConnect();
      return (ConnectionResult)localObject1;
      label154:
      localObject1 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject1).<init>("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      throw ((Throwable)localObject1);
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    this.zaeo.lock();
    try
    {
      Integer localInteger = this.zahd;
      if (localInteger == null) {
        this.zahd = Integer.valueOf(zaa(this.zagz.values(), false));
      } else {
        if (localInteger.intValue() == 2) {
          break label127;
        }
      }
      zae(this.zahd.intValue());
      this.zags.enableCallbacks();
      paramTimeUnit = this.zagt.blockingConnect(paramLong, paramTimeUnit);
      return paramTimeUnit;
      label127:
      paramTimeUnit = new java/lang/IllegalStateException;
      paramTimeUnit.<init>("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      throw paramTimeUnit;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
    boolean bool;
    if (this.zahd.intValue() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(this);
    if (this.zagz.containsKey(Common.CLIENT_KEY))
    {
      zaa(this, localStatusPendingResult, false);
    }
    else
    {
      AtomicReference localAtomicReference = new AtomicReference();
      zaay localzaay = new zaay(this, localAtomicReference, localStatusPendingResult);
      Object localObject = new zaaz(this, localStatusPendingResult);
      localObject = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks(localzaay).addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)localObject).setHandler(this.zagx).build();
      localAtomicReference.set(localObject);
      ((GoogleApiClient)localObject).connect();
    }
    return localStatusPendingResult;
  }
  
  public final void connect()
  {
    this.zaeo.lock();
    try
    {
      int i = this.zacb;
      boolean bool = false;
      if (i >= 0)
      {
        if (this.zahd != null) {
          bool = true;
        }
        Preconditions.checkState(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else
      {
        localObject1 = this.zahd;
        if (localObject1 == null) {
          this.zahd = Integer.valueOf(zaa(this.zagz.values(), false));
        } else {
          if (((Integer)localObject1).intValue() == 2) {
            break label100;
          }
        }
      }
      connect(this.zahd.intValue());
      return;
      label100:
      Object localObject1 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject1).<init>("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      throw ((Throwable)localObject1);
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void connect(int paramInt)
  {
    this.zaeo.lock();
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramInt != 3)
    {
      bool2 = bool1;
      if (paramInt != 1) {
        if (paramInt == 2) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
    }
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(33);
      localStringBuilder.append("Illegal sign-in mode: ");
      localStringBuilder.append(paramInt);
      Preconditions.checkArgument(bool2, localStringBuilder.toString());
      zae(paramInt);
      zaau();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void disconnect()
  {
    this.zaeo.lock();
    try
    {
      this.zahf.release();
      Object localObject1 = this.zagt;
      if (localObject1 != null) {
        ((zabs)localObject1).disconnect();
      }
      this.zahb.release();
      localObject1 = this.zafc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)((Iterator)localObject1).next();
        localApiMethodImpl.zaa(null);
        localApiMethodImpl.cancel();
      }
      this.zafc.clear();
      localObject1 = this.zagt;
      if (localObject1 == null) {
        return;
      }
      zaaw();
      this.zags.disableCallbacks();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zagu);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zafc.size());
    Object localObject = this.zahf;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(((zacp)localObject).zakz.size());
    localObject = this.zagt;
    if (localObject != null) {
      ((zabs)localObject).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT)
  {
    if (paramT.getClientKey() != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
    boolean bool = this.zagz.containsKey(paramT.getClientKey());
    Object localObject;
    if (paramT.getApi() != null) {
      localObject = paramT.getApi().getName();
    } else {
      localObject = "the API";
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 65);
    localStringBuilder.append("GoogleApiClient is not configured to use ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
    this.zaeo.lock();
    try
    {
      localObject = this.zagt;
      if (localObject == null)
      {
        this.zafc.add(paramT);
        return paramT;
      }
      paramT = ((zabs)localObject).enqueue(paramT);
      return paramT;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT)
  {
    if (paramT.getClientKey() != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "This task can not be executed (it's probably a Batch or malformed)");
    boolean bool = this.zagz.containsKey(paramT.getClientKey());
    Object localObject;
    if (paramT.getApi() != null) {
      localObject = paramT.getApi().getName();
    } else {
      localObject = "the API";
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 65);
    localStringBuilder.append("GoogleApiClient is not configured to use ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
    this.zaeo.lock();
    try
    {
      if (this.zagt != null)
      {
        if (this.zagu)
        {
          this.zafc.add(paramT);
          while (!this.zafc.isEmpty())
          {
            localObject = (BaseImplementation.ApiMethodImpl)this.zafc.remove();
            this.zahf.zab((BasePendingResult)localObject);
            ((BaseImplementation.ApiMethodImpl)localObject).setFailedResult(Status.RESULT_INTERNAL_ERROR);
          }
          return paramT;
        }
        paramT = this.zagt.execute(paramT);
        return paramT;
      }
      paramT = new java/lang/IllegalStateException;
      paramT.<init>("GoogleApiClient is not connected yet.");
      throw paramT;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  @NonNull
  public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> paramAnyClientKey)
  {
    paramAnyClientKey = (Api.Client)this.zagz.get(paramAnyClientKey);
    Preconditions.checkNotNull(paramAnyClientKey, "Appropriate Api was not requested.");
    return paramAnyClientKey;
  }
  
  @NonNull
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    this.zaeo.lock();
    try
    {
      if ((!isConnected()) && (!this.zagu))
      {
        paramApi = new java/lang/IllegalStateException;
        paramApi.<init>("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
        throw paramApi;
      }
      if (this.zagz.containsKey(paramApi.getClientKey()))
      {
        localObject = this.zagt.getConnectionResult(paramApi);
        if (localObject == null)
        {
          if (this.zagu)
          {
            paramApi = ConnectionResult.RESULT_SUCCESS;
            return paramApi;
          }
          Log.w("GoogleApiClientImpl", zaay());
          localObject = String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map");
          paramApi = new java/lang/Exception;
          paramApi.<init>();
          Log.wtf("GoogleApiClientImpl", (String)localObject, paramApi);
          paramApi = new ConnectionResult(8, null);
          return paramApi;
        }
        return (ConnectionResult)localObject;
      }
      Object localObject = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject).<init>(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
      throw ((Throwable)localObject);
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zabj;
  }
  
  public final boolean hasApi(@NonNull Api<?> paramApi)
  {
    return this.zagz.containsKey(paramApi.getClientKey());
  }
  
  public final boolean hasConnectedApi(@NonNull Api<?> paramApi)
  {
    if (!isConnected()) {
      return false;
    }
    paramApi = (Api.Client)this.zagz.get(paramApi.getClientKey());
    return (paramApi != null) && (paramApi.isConnected());
  }
  
  public final boolean isConnected()
  {
    zabs localzabs = this.zagt;
    return (localzabs != null) && (localzabs.isConnected());
  }
  
  public final boolean isConnecting()
  {
    zabs localzabs = this.zagt;
    return (localzabs != null) && (localzabs.isConnecting());
  }
  
  public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zags.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zags.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    zabs localzabs = this.zagt;
    return (localzabs != null) && (localzabs.maybeSignIn(paramSignInConnectionListener));
  }
  
  public final void maybeSignOut()
  {
    zabs localzabs = this.zagt;
    if (localzabs != null) {
      localzabs.maybeSignOut();
    }
  }
  
  public final void reconnect()
  {
    disconnect();
    connect();
  }
  
  public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zags.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zags.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final <L> ListenerHolder<L> registerListener(@NonNull L paramL)
  {
    this.zaeo.lock();
    try
    {
      paramL = this.zahb.zaa(paramL, this.zabj, "NO_TYPE");
      return paramL;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
    if (this.zacb >= 0)
    {
      zaj.zaa(paramFragmentActivity).zaa(this.zacb);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zags.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zags.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void zaa(zacm paramzacm)
  {
    this.zaeo.lock();
    try
    {
      if (this.zahe == null)
      {
        HashSet localHashSet = new java/util/HashSet;
        localHashSet.<init>();
        this.zahe = localHashSet;
      }
      this.zahe.add(paramzacm);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  @GuardedBy("mLock")
  final boolean zaaw()
  {
    if (!this.zagu) {
      return false;
    }
    this.zagu = false;
    this.zagx.removeMessages(2);
    this.zagx.removeMessages(1);
    zabq localzabq = this.zagy;
    if (localzabq != null)
    {
      localzabq.unregister();
      this.zagy = null;
    }
    return true;
  }
  
  final boolean zaax()
  {
    this.zaeo.lock();
    try
    {
      Set localSet = this.zahe;
      if (localSet == null) {
        return false;
      }
      boolean bool = localSet.isEmpty();
      return bool ^ true;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final String zaay()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  @GuardedBy("mLock")
  public final void zab(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!this.zagu))
    {
      this.zagu = true;
      if ((this.zagy == null) && (!ClientLibraryUtils.isPackageSide())) {
        this.zagy = this.zacd.zaa(this.mContext.getApplicationContext(), new zabc(this));
      }
      zabb localzabb = this.zagx;
      localzabb.sendMessageDelayed(localzabb.obtainMessage(1), this.zagv);
      localzabb = this.zagx;
      localzabb.sendMessageDelayed(localzabb.obtainMessage(2), this.zagw);
    }
    this.zahf.zabx();
    this.zags.onUnintentionalDisconnection(paramInt);
    this.zags.disableCallbacks();
    if (paramInt == 2) {
      zaau();
    }
  }
  
  @GuardedBy("mLock")
  public final void zab(Bundle paramBundle)
  {
    while (!this.zafc.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)this.zafc.remove());
    }
    this.zags.onConnectionSuccess(paramBundle);
  }
  
  public final void zab(zacm paramzacm)
  {
    this.zaeo.lock();
    try
    {
      Set localSet = this.zahe;
      if (localSet == null)
      {
        paramzacm = new java/lang/Exception;
        paramzacm.<init>();
        Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", paramzacm);
      }
      else if (!localSet.remove(paramzacm))
      {
        paramzacm = new java/lang/Exception;
        paramzacm.<init>();
        Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", paramzacm);
      }
      else if (!zaax())
      {
        this.zagt.zaw();
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  @GuardedBy("mLock")
  public final void zac(ConnectionResult paramConnectionResult)
  {
    if (!this.zacd.isPlayServicesPossiblyUpdating(this.mContext, paramConnectionResult.getErrorCode())) {
      zaaw();
    }
    if (!this.zagu)
    {
      this.zags.onConnectionFailure(paramConnectionResult);
      this.zags.disableCallbacks();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */