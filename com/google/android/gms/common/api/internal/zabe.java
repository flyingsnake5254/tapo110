package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zabe
  implements zabs, zar
{
  private final Context mContext;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  final zaaw zaee;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api<?>, Boolean> zaew;
  private final GoogleApiAvailabilityLight zaey;
  final Map<Api.AnyClientKey<?>, Api.Client> zagz;
  private final Condition zahn;
  private final zabg zaho;
  final Map<Api.AnyClientKey<?>, ConnectionResult> zahp = new HashMap();
  private volatile zabd zahq;
  private ConnectionResult zahr = null;
  int zahs;
  final zabt zaht;
  
  public zabe(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zabt paramzabt)
  {
    this.mContext = paramContext;
    this.zaeo = paramLock;
    this.zaey = paramGoogleApiAvailabilityLight;
    this.zagz = paramMap;
    this.zaet = paramClientSettings;
    this.zaew = paramMap1;
    this.zace = paramAbstractClientBuilder;
    this.zaee = paramzaaw;
    this.zaht = paramzabt;
    int i = paramArrayList.size();
    int j = 0;
    while (j < i)
    {
      paramContext = paramArrayList.get(j);
      j++;
      ((zaq)paramContext).zaa(this);
    }
    this.zaho = new zabg(this, paramLooper);
    this.zahn = paramLock.newCondition();
    this.zahq = new zaav(this);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zahn.await();
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
    ConnectionResult localConnectionResult = this.zahr;
    if (localConnectionResult != null) {
      return localConnectionResult;
    }
    return new ConnectionResult(13, null);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zahn.awaitNanos(paramLong))
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
    paramTimeUnit = this.zahr;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new ConnectionResult(13, null);
  }
  
  @GuardedBy("mLock")
  public final void connect()
  {
    this.zahq.connect();
  }
  
  @GuardedBy("mLock")
  public final void disconnect()
  {
    if (this.zahq.disconnect()) {
      this.zahp.clear();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zahq);
    Iterator localIterator = this.zaew.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.Client)this.zagz.get(localApi.getClientKey())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT)
  {
    paramT.zau();
    return this.zahq.enqueue(paramT);
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT)
  {
    paramT.zau();
    return this.zahq.execute(paramT);
  }
  
  @Nullable
  @GuardedBy("mLock")
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    paramApi = paramApi.getClientKey();
    if (this.zagz.containsKey(paramApi))
    {
      if (((Api.Client)this.zagz.get(paramApi)).isConnected()) {
        return ConnectionResult.RESULT_SUCCESS;
      }
      if (this.zahp.containsKey(paramApi)) {
        return (ConnectionResult)this.zahp.get(paramApi);
      }
    }
    return null;
  }
  
  public final boolean isConnected()
  {
    return this.zahq instanceof zaah;
  }
  
  public final boolean isConnecting()
  {
    return this.zahq instanceof zaak;
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    return false;
  }
  
  public final void maybeSignOut() {}
  
  public final void onConnected(@Nullable Bundle paramBundle)
  {
    this.zaeo.lock();
    try
    {
      this.zahq.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    this.zaeo.lock();
    try
    {
      this.zahq.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void zaa(@NonNull ConnectionResult paramConnectionResult, @NonNull Api<?> paramApi, boolean paramBoolean)
  {
    this.zaeo.lock();
    try
    {
      this.zahq.zaa(paramConnectionResult, paramApi, paramBoolean);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final void zaa(zabf paramzabf)
  {
    paramzabf = this.zaho.obtainMessage(1, paramzabf);
    this.zaho.sendMessage(paramzabf);
  }
  
  final void zaaz()
  {
    this.zaeo.lock();
    try
    {
      zaak localzaak = new com/google/android/gms/common/api/internal/zaak;
      localzaak.<init>(this, this.zaet, this.zaew, this.zaey, this.zace, this.zaeo, this.mContext);
      this.zahq = localzaak;
      this.zahq.begin();
      this.zahn.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final void zab(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.zaho.obtainMessage(2, paramRuntimeException);
    this.zaho.sendMessage(paramRuntimeException);
  }
  
  final void zaba()
  {
    this.zaeo.lock();
    try
    {
      this.zaee.zaaw();
      zaah localzaah = new com/google/android/gms/common/api/internal/zaah;
      localzaah.<init>(this);
      this.zahq = localzaah;
      this.zahq.begin();
      this.zahn.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final void zaf(ConnectionResult paramConnectionResult)
  {
    this.zaeo.lock();
    try
    {
      this.zahr = paramConnectionResult;
      paramConnectionResult = new com/google/android/gms/common/api/internal/zaav;
      paramConnectionResult.<init>(this);
      this.zahq = paramConnectionResult;
      this.zahq.begin();
      this.zahn.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  @GuardedBy("mLock")
  public final void zaw()
  {
    if (isConnected()) {
      ((zaah)this.zahq).zaam();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zabe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */