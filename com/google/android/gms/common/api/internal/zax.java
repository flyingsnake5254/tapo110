package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zax
  implements zabs
{
  private final Looper zabj;
  private final GoogleApiManager zabm;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaeu = new HashMap();
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaev = new HashMap();
  private final Map<Api<?>, Boolean> zaew;
  private final zaaw zaex;
  private final GoogleApiAvailabilityLight zaey;
  private final Condition zaez;
  private final boolean zafa;
  private final boolean zafb;
  private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafc = new LinkedList();
  @GuardedBy("mLock")
  private boolean zafd;
  @GuardedBy("mLock")
  private Map<zai<?>, ConnectionResult> zafe;
  @GuardedBy("mLock")
  private Map<zai<?>, ConnectionResult> zaff;
  @GuardedBy("mLock")
  private zaaa zafg;
  @GuardedBy("mLock")
  private ConnectionResult zafh;
  
  public zax(Context paramContext, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zaaw paramzaaw, boolean paramBoolean)
  {
    this.zaeo = paramLock;
    this.zabj = paramLooper;
    this.zaez = paramLock.newCondition();
    this.zaey = paramGoogleApiAvailabilityLight;
    this.zaex = paramzaaw;
    this.zaew = paramMap1;
    this.zaet = paramClientSettings;
    this.zafa = paramBoolean;
    paramLock = new HashMap();
    paramGoogleApiAvailabilityLight = paramMap1.keySet().iterator();
    while (paramGoogleApiAvailabilityLight.hasNext())
    {
      paramMap1 = (Api)paramGoogleApiAvailabilityLight.next();
      paramLock.put(paramMap1.getClientKey(), paramMap1);
    }
    paramGoogleApiAvailabilityLight = new HashMap();
    int i = paramArrayList.size();
    int j = 0;
    while (j < i)
    {
      paramMap1 = paramArrayList.get(j);
      j++;
      paramMap1 = (zaq)paramMap1;
      paramGoogleApiAvailabilityLight.put(paramMap1.mApi, paramMap1);
    }
    paramMap = paramMap.entrySet().iterator();
    i = 0;
    int k = 1;
    j = 0;
    while (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramzaaw = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = (Api.Client)paramMap1.getValue();
      if (paramArrayList.requiresGooglePlayServices())
      {
        paramBoolean = ((Boolean)this.zaew.get(paramzaaw)).booleanValue();
        if (!paramBoolean)
        {
          i = 1;
          j = 1;
        }
        else
        {
          i = 1;
        }
      }
      else
      {
        k = 0;
      }
      paramzaaw = new zaw(paramContext, paramzaaw, paramLooper, paramArrayList, (zaq)paramGoogleApiAvailabilityLight.get(paramzaaw), paramClientSettings, paramAbstractClientBuilder);
      this.zaeu.put((Api.AnyClientKey)paramMap1.getKey(), paramzaaw);
      if (paramArrayList.requiresSignIn()) {
        this.zaev.put((Api.AnyClientKey)paramMap1.getKey(), paramzaaw);
      }
    }
    if ((i != 0) && (k == 0) && (j == 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.zafb = paramBoolean;
    this.zabm = GoogleApiManager.zabc();
  }
  
  @Nullable
  private final ConnectionResult zaa(@NonNull Api.AnyClientKey<?> paramAnyClientKey)
  {
    this.zaeo.lock();
    try
    {
      zaw localzaw = (zaw)this.zaeu.get(paramAnyClientKey);
      paramAnyClientKey = this.zafe;
      if ((paramAnyClientKey != null) && (localzaw != null))
      {
        paramAnyClientKey = (ConnectionResult)paramAnyClientKey.get(localzaw.zak());
        return paramAnyClientKey;
      }
      return null;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  private final boolean zaa(zaw<?> paramzaw, ConnectionResult paramConnectionResult)
  {
    return (!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)this.zaew.get(paramzaw.getApi())).booleanValue()) && (paramzaw.zaab().requiresGooglePlayServices()) && (this.zaey.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }
  
  private final boolean zaac()
  {
    this.zaeo.lock();
    try
    {
      if ((this.zafd) && (this.zafa))
      {
        Iterator localIterator = this.zaev.keySet().iterator();
        while (localIterator.hasNext())
        {
          ConnectionResult localConnectionResult = zaa((Api.AnyClientKey)localIterator.next());
          if (localConnectionResult != null)
          {
            boolean bool = localConnectionResult.isSuccess();
            if (bool) {
              break;
            }
          }
          else
          {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  @GuardedBy("mLock")
  private final void zaad()
  {
    if (this.zaet == null)
    {
      this.zaex.zaha = Collections.emptySet();
      return;
    }
    HashSet localHashSet = new HashSet(this.zaet.getRequiredScopes());
    Map localMap = this.zaet.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      ConnectionResult localConnectionResult = getConnectionResult(localApi);
      if ((localConnectionResult != null) && (localConnectionResult.isSuccess())) {
        localHashSet.addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
      }
    }
    this.zaex.zaha = localHashSet;
  }
  
  @GuardedBy("mLock")
  private final void zaae()
  {
    while (!this.zafc.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)this.zafc.remove());
    }
    this.zaex.zab(null);
  }
  
  @Nullable
  @GuardedBy("mLock")
  private final ConnectionResult zaaf()
  {
    Iterator localIterator = this.zaeu.values().iterator();
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int j = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = (zaw)localIterator.next();
      Api localApi = ((GoogleApi)localObject3).getApi();
      localObject3 = ((GoogleApi)localObject3).zak();
      localObject3 = (ConnectionResult)this.zafe.get(localObject3);
      if ((!((ConnectionResult)localObject3).isSuccess()) && ((!((Boolean)this.zaew.get(localApi)).booleanValue()) || (((ConnectionResult)localObject3).hasResolution()) || (this.zaey.isUserResolvableError(((ConnectionResult)localObject3).getErrorCode()))))
      {
        int k;
        if ((((ConnectionResult)localObject3).getErrorCode() == 4) && (this.zafa))
        {
          k = localApi.zah().getPriority();
          if ((localObject2 == null) || (j > k))
          {
            localObject2 = localObject3;
            j = k;
          }
        }
        else
        {
          k = localApi.zah().getPriority();
          if ((localObject1 == null) || (i > k))
          {
            localObject1 = localObject3;
            i = k;
          }
        }
      }
    }
    if ((localObject1 != null) && (localObject2 != null) && (i > j)) {
      return (ConnectionResult)localObject2;
    }
    return (ConnectionResult)localObject1;
  }
  
  private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zab(@NonNull T paramT)
  {
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    ConnectionResult localConnectionResult = zaa(localAnyClientKey);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.setFailedResult(new Status(4, null, this.zabm.zaa(((zaw)this.zaeu.get(localAnyClientKey)).zak(), System.identityHashCode(this.zaex))));
      return true;
    }
    return false;
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zaez.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.RESULT_SUCCESS;
    }
    ConnectionResult localConnectionResult = this.zafh;
    if (localConnectionResult != null) {
      return localConnectionResult;
    }
    return new ConnectionResult(13, null);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zaez.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.RESULT_SUCCESS;
    }
    paramTimeUnit = this.zafh;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new ConnectionResult(13, null);
  }
  
  public final void connect()
  {
    this.zaeo.lock();
    try
    {
      boolean bool = this.zafd;
      if (bool) {
        return;
      }
      this.zafd = true;
      this.zafe = null;
      this.zaff = null;
      this.zafg = null;
      this.zafh = null;
      this.zabm.zao();
      Task localTask = this.zabm.zaa(this.zaeu.values());
      HandlerExecutor localHandlerExecutor = new com/google/android/gms/common/util/concurrent/HandlerExecutor;
      localHandlerExecutor.<init>(this.zabj);
      zaz localzaz = new com/google/android/gms/common/api/internal/zaz;
      localzaz.<init>(this, null);
      localTask.addOnCompleteListener(localHandlerExecutor, localzaz);
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
      this.zafd = false;
      this.zafe = null;
      this.zaff = null;
      Object localObject1 = this.zafg;
      if (localObject1 != null)
      {
        ((zaaa)localObject1).cancel();
        this.zafg = null;
      }
      this.zafh = null;
      while (!this.zafc.isEmpty())
      {
        localObject1 = (BaseImplementation.ApiMethodImpl)this.zafc.remove();
        ((BasePendingResult)localObject1).zaa(null);
        ((PendingResult)localObject1).cancel();
      }
      this.zaez.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT)
  {
    if ((this.zafa) && (zab(paramT))) {
      return paramT;
    }
    if (!isConnected())
    {
      this.zafc.add(paramT);
      return paramT;
    }
    this.zaex.zahf.zab(paramT);
    return ((zaw)this.zaeu.get(paramT.getClientKey())).doRead(paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT)
  {
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    if ((this.zafa) && (zab(paramT))) {
      return paramT;
    }
    this.zaex.zahf.zab(paramT);
    return ((zaw)this.zaeu.get(localAnyClientKey)).doWrite(paramT);
  }
  
  @Nullable
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    return zaa(paramApi.getClientKey());
  }
  
  public final boolean isConnected()
  {
    this.zaeo.lock();
    try
    {
      if (this.zafe != null)
      {
        ConnectionResult localConnectionResult = this.zafh;
        if (localConnectionResult == null)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final boolean isConnecting()
  {
    this.zaeo.lock();
    try
    {
      if (this.zafe == null)
      {
        bool = this.zafd;
        if (bool)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    this.zaeo.lock();
    try
    {
      if ((this.zafd) && (!zaac()))
      {
        this.zabm.zao();
        Object localObject = new com/google/android/gms/common/api/internal/zaaa;
        ((zaaa)localObject).<init>(this, paramSignInConnectionListener);
        this.zafg = ((zaaa)localObject);
        paramSignInConnectionListener = this.zabm.zaa(this.zaev.values());
        localObject = new com/google/android/gms/common/util/concurrent/HandlerExecutor;
        ((HandlerExecutor)localObject).<init>(this.zabj);
        paramSignInConnectionListener.addOnCompleteListener((Executor)localObject, this.zafg);
        return true;
      }
      return false;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void maybeSignOut()
  {
    this.zaeo.lock();
    try
    {
      this.zabm.maybeSignOut();
      Object localObject1 = this.zafg;
      if (localObject1 != null)
      {
        ((zaaa)localObject1).cancel();
        this.zafg = null;
      }
      if (this.zaff == null)
      {
        localObject1 = new androidx/collection/ArrayMap;
        ((ArrayMap)localObject1).<init>(this.zaev.size());
        this.zaff = ((Map)localObject1);
      }
      ConnectionResult localConnectionResult = new com/google/android/gms/common/ConnectionResult;
      localConnectionResult.<init>(4);
      localObject1 = this.zaev.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        zaw localzaw = (zaw)((Iterator)localObject1).next();
        this.zaff.put(localzaw.zak(), localConnectionResult);
      }
      localObject1 = this.zafe;
      if (localObject1 != null) {
        ((Map)localObject1).putAll(this.zaff);
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void zaw() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */