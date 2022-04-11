package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class zas
  implements zabs
{
  private final Context mContext;
  private final Looper zabj;
  private final zaaw zaee;
  private final zabe zaef;
  private final zabe zaeg;
  private final Map<Api.AnyClientKey<?>, zabe> zaeh;
  private final Set<SignInConnectionListener> zaei = Collections.newSetFromMap(new WeakHashMap());
  private final Api.Client zaej;
  private Bundle zaek;
  private ConnectionResult zael = null;
  private ConnectionResult zaem = null;
  private boolean zaen = false;
  private final Lock zaeo;
  @GuardedBy("mLock")
  private int zaep = 0;
  
  private zas(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, Map<Api.AnyClientKey<?>, Api.Client> paramMap2, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Api.Client paramClient, ArrayList<zaq> paramArrayList1, ArrayList<zaq> paramArrayList2, Map<Api<?>, Boolean> paramMap3, Map<Api<?>, Boolean> paramMap4)
  {
    this.mContext = paramContext;
    this.zaee = paramzaaw;
    this.zaeo = paramLock;
    this.zabj = paramLooper;
    this.zaej = paramClient;
    this.zaef = new zabe(paramContext, paramzaaw, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new zau(this, null));
    this.zaeg = new zabe(paramContext, paramzaaw, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramClientSettings, paramMap3, paramAbstractClientBuilder, paramArrayList1, new zav(this, null));
    paramContext = new ArrayMap();
    paramzaaw = paramMap2.keySet().iterator();
    while (paramzaaw.hasNext()) {
      paramContext.put((Api.AnyClientKey)paramzaaw.next(), this.zaef);
    }
    paramzaaw = paramMap1.keySet().iterator();
    while (paramzaaw.hasNext()) {
      paramContext.put((Api.AnyClientKey)paramzaaw.next(), this.zaeg);
    }
    this.zaeh = Collections.unmodifiableMap(paramContext);
  }
  
  public static zas zaa(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject1 = paramMap.entrySet().iterator();
    paramMap = null;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Api.Client)((Map.Entry)localObject2).getValue();
      if (((Api.Client)localObject3).providesSignIn()) {
        paramMap = (Map<Api.AnyClientKey<?>, Api.Client>)localObject3;
      }
      if (((Api.Client)localObject3).requiresSignIn()) {
        localArrayMap1.put((Api.AnyClientKey)((Map.Entry)localObject2).getKey(), localObject3);
      } else {
        localArrayMap2.put((Api.AnyClientKey)((Map.Entry)localObject2).getKey(), localObject3);
      }
    }
    Preconditions.checkState(localArrayMap1.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    localObject1 = new ArrayMap();
    Object localObject3 = new ArrayMap();
    Object localObject2 = paramMap1.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject2).next();
      localObject4 = localApi.getClientKey();
      if (localArrayMap1.containsKey(localObject4)) {
        ((Map)localObject1).put(localApi, (Boolean)paramMap1.get(localApi));
      } else if (localArrayMap2.containsKey(localObject4)) {
        ((Map)localObject3).put(localApi, (Boolean)paramMap1.get(localApi));
      } else {
        throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
      }
    }
    paramMap1 = new ArrayList();
    localObject2 = new ArrayList();
    int i = paramArrayList.size();
    int j = 0;
    while (j < i)
    {
      localObject4 = paramArrayList.get(j);
      j++;
      localObject4 = (zaq)localObject4;
      if (((Map)localObject1).containsKey(((zaq)localObject4).mApi)) {
        paramMap1.add(localObject4);
      } else if (((Map)localObject3).containsKey(((zaq)localObject4).mApi)) {
        ((ArrayList)localObject2).add(localObject4);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
      }
    }
    return new zas(paramContext, paramzaaw, paramLock, paramLooper, paramGoogleApiAvailabilityLight, localArrayMap1, localArrayMap2, paramClientSettings, paramAbstractClientBuilder, paramMap, paramMap1, (ArrayList)localObject2, (Map)localObject1, (Map)localObject3);
  }
  
  @GuardedBy("mLock")
  private final void zaa(int paramInt, boolean paramBoolean)
  {
    this.zaee.zab(paramInt, paramBoolean);
    this.zaem = null;
    this.zael = null;
  }
  
  private final void zaa(Bundle paramBundle)
  {
    Bundle localBundle = this.zaek;
    if (localBundle == null)
    {
      this.zaek = paramBundle;
      return;
    }
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
  }
  
  @GuardedBy("mLock")
  private final void zaa(ConnectionResult paramConnectionResult)
  {
    int i = this.zaep;
    if (i != 1)
    {
      if (i != 2) {
        Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
      } else {
        this.zaee.zac(paramConnectionResult);
      }
    }
    else {
      zay();
    }
    this.zaep = 0;
  }
  
  private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> paramApiMethodImpl)
  {
    paramApiMethodImpl = paramApiMethodImpl.getClientKey();
    Preconditions.checkArgument(this.zaeh.containsKey(paramApiMethodImpl), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zabe)this.zaeh.get(paramApiMethodImpl)).equals(this.zaeg);
  }
  
  @Nullable
  private final PendingIntent zaaa()
  {
    if (this.zaej == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaee), this.zaej.getSignInIntent(), 134217728);
  }
  
  private static boolean zab(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  @GuardedBy("mLock")
  private final void zax()
  {
    Object localObject;
    if (zab(this.zael))
    {
      if ((!zab(this.zaem)) && (!zaz()))
      {
        localObject = this.zaem;
        if (localObject != null)
        {
          if (this.zaep == 1)
          {
            zay();
            return;
          }
          zaa((ConnectionResult)localObject);
          this.zaef.disconnect();
        }
      }
      else
      {
        int i = this.zaep;
        if (i != 1)
        {
          if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
          } else {
            this.zaee.zab(this.zaek);
          }
        }
        else {
          zay();
        }
        this.zaep = 0;
      }
    }
    else
    {
      if ((this.zael != null) && (zab(this.zaem)))
      {
        this.zaeg.disconnect();
        zaa(this.zael);
        return;
      }
      localObject = this.zael;
      if (localObject != null)
      {
        ConnectionResult localConnectionResult = this.zaem;
        if (localConnectionResult != null)
        {
          if (this.zaeg.zahs < this.zaef.zahs) {
            localObject = localConnectionResult;
          }
          zaa((ConnectionResult)localObject);
        }
      }
    }
  }
  
  @GuardedBy("mLock")
  private final void zay()
  {
    Iterator localIterator = this.zaei.iterator();
    while (localIterator.hasNext()) {
      ((SignInConnectionListener)localIterator.next()).onComplete();
    }
    this.zaei.clear();
  }
  
  @GuardedBy("mLock")
  private final boolean zaz()
  {
    ConnectionResult localConnectionResult = this.zaem;
    return (localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  @GuardedBy("mLock")
  public final void connect()
  {
    this.zaep = 2;
    this.zaen = false;
    this.zaem = null;
    this.zael = null;
    this.zaef.connect();
    this.zaeg.connect();
  }
  
  @GuardedBy("mLock")
  public final void disconnect()
  {
    this.zaem = null;
    this.zael = null;
    this.zaep = 0;
    this.zaef.disconnect();
    this.zaeg.disconnect();
    zay();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zaeg.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zaef.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT)
  {
    if (zaa(paramT))
    {
      if (zaz())
      {
        paramT.setFailedResult(new Status(4, null, zaaa()));
        return paramT;
      }
      return this.zaeg.enqueue(paramT);
    }
    return this.zaef.enqueue(paramT);
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT)
  {
    if (zaa(paramT))
    {
      if (zaz())
      {
        paramT.setFailedResult(new Status(4, null, zaaa()));
        return paramT;
      }
      return this.zaeg.execute(paramT);
    }
    return this.zaef.execute(paramT);
  }
  
  @Nullable
  @GuardedBy("mLock")
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    if (((zabe)this.zaeh.get(paramApi.getClientKey())).equals(this.zaeg))
    {
      if (zaz()) {
        return new ConnectionResult(4, zaaa());
      }
      return this.zaeg.getConnectionResult(paramApi);
    }
    return this.zaef.getConnectionResult(paramApi);
  }
  
  public final boolean isConnected()
  {
    this.zaeo.lock();
    try
    {
      boolean bool1 = this.zaef.isConnected();
      boolean bool2 = true;
      if (bool1)
      {
        bool1 = bool2;
        if (this.zaeg.isConnected()) {
          break label61;
        }
        bool1 = bool2;
        if (zaz()) {
          break label61;
        }
        int i = this.zaep;
        if (i == 1)
        {
          bool1 = bool2;
          break label61;
        }
      }
      bool1 = false;
      label61:
      return bool1;
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
      int i = this.zaep;
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
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
      if (((isConnecting()) || (isConnected())) && (!this.zaeg.isConnected()))
      {
        this.zaei.add(paramSignInConnectionListener);
        if (this.zaep == 0) {
          this.zaep = 1;
        }
        this.zaem = null;
        this.zaeg.connect();
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
      boolean bool = isConnecting();
      this.zaeg.disconnect();
      Object localObject1 = new com/google/android/gms/common/ConnectionResult;
      ((ConnectionResult)localObject1).<init>(4);
      this.zaem = ((ConnectionResult)localObject1);
      if (bool)
      {
        zap localzap = new com/google/android/gms/internal/base/zap;
        localzap.<init>(this.zabj);
        localObject1 = new com/google/android/gms/common/api/internal/zat;
        ((zat)localObject1).<init>(this);
        localzap.post((Runnable)localObject1);
      }
      else
      {
        zay();
      }
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
    this.zaef.zaw();
    this.zaeg.zaw();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */