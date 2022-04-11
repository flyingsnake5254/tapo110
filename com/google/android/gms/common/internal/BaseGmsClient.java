package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface>
{
  @KeepForSdk
  public static final int CONNECT_STATE_CONNECTED = 4;
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  @KeepForSdk
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  @KeepForSdk
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  private static final Feature[] zzbt = new Feature[0];
  private final Context mContext;
  final Handler mHandler;
  private final Object mLock = new Object();
  private int zzbu;
  private long zzbv;
  private long zzbw;
  private int zzbx;
  private long zzby;
  @VisibleForTesting
  private zzh zzbz;
  private final Looper zzca;
  private final GmsClientSupervisor zzcb;
  private final GoogleApiAvailabilityLight zzcc;
  private final Object zzcd = new Object();
  @GuardedBy("mServiceBrokerLock")
  private IGmsServiceBroker zzce;
  @VisibleForTesting
  protected ConnectionProgressReportCallbacks zzcf;
  @GuardedBy("mLock")
  private T zzcg;
  private final ArrayList<zzc<?>> zzch = new ArrayList();
  @GuardedBy("mLock")
  private zze zzci;
  @GuardedBy("mLock")
  private int zzcj = 1;
  private final BaseConnectionCallbacks zzck;
  private final BaseOnConnectionFailedListener zzcl;
  private final int zzcm;
  private final String zzcn;
  private ConnectionResult zzco = null;
  private boolean zzcp = false;
  private volatile zzb zzcq = null;
  @VisibleForTesting
  protected AtomicInteger zzcr = new AtomicInteger(0);
  
  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.mHandler = ((Handler)Preconditions.checkNotNull(paramHandler, "Handler must not be null"));
    this.zzca = paramHandler.getLooper();
    this.zzcb = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzcc = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.zzcm = paramInt;
    this.zzck = paramBaseConnectionCallbacks;
    this.zzcl = paramBaseOnConnectionFailedListener;
    this.zzcn = null;
  }
  
  @KeepForSdk
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, (BaseConnectionCallbacks)Preconditions.checkNotNull(paramBaseConnectionCallbacks), (BaseOnConnectionFailedListener)Preconditions.checkNotNull(paramBaseOnConnectionFailedListener), paramString);
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.zzca = ((Looper)Preconditions.checkNotNull(paramLooper, "Looper must not be null"));
    this.zzcb = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzcc = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.mHandler = new zzb(paramLooper);
    this.zzcm = paramInt;
    this.zzck = paramBaseConnectionCallbacks;
    this.zzcl = paramBaseOnConnectionFailedListener;
    this.zzcn = paramString;
  }
  
  private final void zza(int paramInt, T paramT)
  {
    int i;
    if (paramInt == 4) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramT != null) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    synchronized (this.mLock)
    {
      this.zzcj = paramInt;
      this.zzcg = paramT;
      onSetConnectState(paramInt, paramT);
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4) {
            onConnectedLocked(paramT);
          }
        }
        else
        {
          if (this.zzci != null)
          {
            paramT = this.zzbz;
            if (paramT != null)
            {
              paramT = paramT.zzt();
              localObject2 = this.zzbz.getPackageName();
              i = String.valueOf(paramT).length();
              paramInt = String.valueOf(localObject2).length();
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>(i + 70 + paramInt);
              ((StringBuilder)localObject3).append("Calling connect() while still connected, missing disconnect() for ");
              ((StringBuilder)localObject3).append(paramT);
              ((StringBuilder)localObject3).append(" on ");
              ((StringBuilder)localObject3).append((String)localObject2);
              Log.e("GmsClient", ((StringBuilder)localObject3).toString());
              this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
              this.zzcr.incrementAndGet();
            }
          }
          paramT = new com/google/android/gms/common/internal/BaseGmsClient$zze;
          paramT.<init>(this, this.zzcr.get());
          this.zzci = paramT;
          if ((this.zzcj == 3) && (getLocalStartServiceAction() != null))
          {
            paramT = new com/google/android/gms/common/internal/zzh;
            paramT.<init>(getContext().getPackageName(), getLocalStartServiceAction(), true, 129);
          }
          else
          {
            paramT = new zzh(getStartServicePackage(), getStartServiceAction(), false, 129);
          }
          this.zzbz = paramT;
          Object localObject2 = this.zzcb;
          Object localObject3 = paramT.zzt();
          String str = this.zzbz.getPackageName();
          paramInt = this.zzbz.zzq();
          zze localzze = this.zzci;
          paramT = zzj();
          GmsClientSupervisor.zza localzza = new com/google/android/gms/common/internal/GmsClientSupervisor$zza;
          localzza.<init>((String)localObject3, str, paramInt);
          if (!((GmsClientSupervisor)localObject2).zza(localzza, localzze, paramT))
          {
            localObject2 = this.zzbz.zzt();
            paramT = this.zzbz.getPackageName();
            paramInt = String.valueOf(localObject2).length();
            i = String.valueOf(paramT).length();
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>(paramInt + 34 + i);
            ((StringBuilder)localObject3).append("unable to connect to service: ");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(" on ");
            ((StringBuilder)localObject3).append(paramT);
            Log.e("GmsClient", ((StringBuilder)localObject3).toString());
            zza(16, null, this.zzcr.get());
          }
        }
      }
      else if (this.zzci != null)
      {
        this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
        this.zzci = null;
      }
      return;
    }
  }
  
  private final void zza(zzb paramzzb)
  {
    this.zzcq = paramzzb;
  }
  
  private final boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.mLock)
    {
      if (this.zzcj != paramInt1) {
        return false;
      }
      zza(paramInt2, paramT);
      return true;
    }
  }
  
  private final void zzb(int paramInt)
  {
    if (zzk())
    {
      paramInt = 5;
      this.zzcp = true;
    }
    else
    {
      paramInt = 4;
    }
    Handler localHandler = this.mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(paramInt, this.zzcr.get(), 16));
  }
  
  @Nullable
  private final String zzj()
  {
    String str1 = this.zzcn;
    String str2 = str1;
    if (str1 == null) {
      str2 = this.mContext.getClass().getName();
    }
    return str2;
  }
  
  private final boolean zzk()
  {
    synchronized (this.mLock)
    {
      boolean bool;
      if (this.zzcj == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  private final boolean zzl()
  {
    if (this.zzcp) {
      return false;
    }
    if (TextUtils.isEmpty(getServiceDescriptor())) {
      return false;
    }
    if (TextUtils.isEmpty(getLocalStartServiceAction())) {
      return false;
    }
    try
    {
      Class.forName(getServiceDescriptor());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  @KeepForSdk
  public void checkAvailabilityAndConnect()
  {
    int i = this.zzcc.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
    if (i != 0)
    {
      zza(1, null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(), i, null);
      return;
    }
    connect(new LegacyClientCallbackAdapter());
  }
  
  @KeepForSdk
  protected final void checkConnected()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  @KeepForSdk
  public void connect(@NonNull ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    this.zzcf = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    zza(2, null);
  }
  
  @Nullable
  @KeepForSdk
  protected abstract T createServiceInterface(IBinder paramIBinder);
  
  @KeepForSdk
  public void disconnect()
  {
    this.zzcr.incrementAndGet();
    synchronized (this.zzch)
    {
      int i = this.zzch.size();
      for (int j = 0; j < i; j++) {
        ((zzc)this.zzch.get(j)).removeListener();
      }
      this.zzch.clear();
      synchronized (this.zzcd)
      {
        this.zzce = null;
        zza(1, null);
        return;
      }
    }
  }
  
  @KeepForSdk
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] arg4)
  {
    synchronized (this.mLock)
    {
      int i = this.zzcj;
      paramFileDescriptor = this.zzcg;
      synchronized (this.zzcd)
      {
        Object localObject = this.zzce;
        paramPrintWriter.append(paramString).append("mConnectState=");
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  paramPrintWriter.print("UNKNOWN");
                } else {
                  paramPrintWriter.print("DISCONNECTING");
                }
              }
              else {
                paramPrintWriter.print("CONNECTED");
              }
            }
            else {
              paramPrintWriter.print("LOCAL_CONNECTING");
            }
          }
          else {
            paramPrintWriter.print("REMOTE_CONNECTING");
          }
        }
        else {
          paramPrintWriter.print("DISCONNECTED");
        }
        paramPrintWriter.append(" mService=");
        if (paramFileDescriptor == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(paramFileDescriptor.asBinder())));
        }
        paramPrintWriter.append(" mServiceBroker=");
        if (localObject == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((IInterface)localObject).asBinder())));
        }
        paramFileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        PrintWriter localPrintWriter;
        long l;
        if (this.zzbw > 0L)
        {
          localPrintWriter = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          l = this.zzbw;
          ??? = paramFileDescriptor.format(new Date(this.zzbw));
          localObject = new StringBuilder(String.valueOf(???).length() + 21);
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(???);
          localPrintWriter.println(((StringBuilder)localObject).toString());
        }
        if (this.zzbv > 0L)
        {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = this.zzbu;
          if (i != 1)
          {
            if (i != 2) {
              paramPrintWriter.append(String.valueOf(i));
            } else {
              paramPrintWriter.append("CAUSE_NETWORK_LOST");
            }
          }
          else {
            paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
          }
          localPrintWriter = paramPrintWriter.append(" lastSuspendedTime=");
          l = this.zzbv;
          ??? = paramFileDescriptor.format(new Date(this.zzbv));
          localObject = new StringBuilder(String.valueOf(???).length() + 21);
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(???);
          localPrintWriter.println(((StringBuilder)localObject).toString());
        }
        if (this.zzby > 0L)
        {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzbx));
          paramString = paramPrintWriter.append(" lastFailedTime=");
          l = this.zzby;
          paramFileDescriptor = paramFileDescriptor.format(new Date(this.zzby));
          paramPrintWriter = new StringBuilder(String.valueOf(paramFileDescriptor).length() + 21);
          paramPrintWriter.append(l);
          paramPrintWriter.append(" ");
          paramPrintWriter.append(paramFileDescriptor);
          paramString.println(paramPrintWriter.toString());
        }
        return;
      }
    }
  }
  
  @KeepForSdk
  protected boolean enableLocalFallback()
  {
    return false;
  }
  
  @KeepForSdk
  public Account getAccount()
  {
    return null;
  }
  
  @KeepForSdk
  public Feature[] getApiFeatures()
  {
    return zzbt;
  }
  
  @Nullable
  @KeepForSdk
  public final Feature[] getAvailableFeatures()
  {
    zzb localzzb = this.zzcq;
    if (localzzb == null) {
      return null;
    }
    return localzzb.zzdb;
  }
  
  @KeepForSdk
  public Bundle getConnectionHint()
  {
    return null;
  }
  
  @KeepForSdk
  public final Context getContext()
  {
    return this.mContext;
  }
  
  @KeepForSdk
  public String getEndpointPackageName()
  {
    if (isConnected())
    {
      zzh localzzh = this.zzbz;
      if (localzzh != null) {
        return localzzh.getPackageName();
      }
    }
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  @KeepForSdk
  protected Bundle getGetServiceRequestExtraArgs()
  {
    return new Bundle();
  }
  
  @Nullable
  @KeepForSdk
  protected String getLocalStartServiceAction()
  {
    return null;
  }
  
  @KeepForSdk
  public final Looper getLooper()
  {
    return this.zzca;
  }
  
  @KeepForSdk
  public int getMinApkVersion()
  {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  @WorkerThread
  @KeepForSdk
  public void getRemoteService(IAccountAccessor arg1, Set<Scope> paramSet)
  {
    Object localObject = getGetServiceRequestExtraArgs();
    GetServiceRequest localGetServiceRequest = new GetServiceRequest(this.zzcm);
    localGetServiceRequest.zzy = this.mContext.getPackageName();
    localGetServiceRequest.zzdk = ((Bundle)localObject);
    if (paramSet != null) {
      localGetServiceRequest.zzdj = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
    }
    if (requiresSignIn())
    {
      if (getAccount() != null) {
        paramSet = getAccount();
      } else {
        paramSet = new Account("<<default account>>", "com.google");
      }
      localGetServiceRequest.zzdl = paramSet;
      if (??? != null) {
        localGetServiceRequest.zzdi = ???.asBinder();
      }
    }
    else if (requiresAccount())
    {
      localGetServiceRequest.zzdl = getAccount();
    }
    localGetServiceRequest.zzdm = zzbt;
    localGetServiceRequest.zzdn = getApiFeatures();
    try
    {
      try
      {
        synchronized (this.zzcd)
        {
          localObject = this.zzce;
          if (localObject != null)
          {
            paramSet = new com/google/android/gms/common/internal/BaseGmsClient$zzd;
            paramSet.<init>(this, this.zzcr.get());
            ((IGmsServiceBroker)localObject).getService(paramSet, localGetServiceRequest);
          }
          else
          {
            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
          }
          return;
        }
        Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      }
      catch (RuntimeException ???) {}catch (RemoteException ???) {}
      onPostInitHandler(8, null, null, this.zzcr.get());
      return;
    }
    catch (SecurityException ???)
    {
      throw ???;
    }
    catch (DeadObjectException ???)
    {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      triggerConnectionSuspended(1);
    }
  }
  
  @KeepForSdk
  protected Set<Scope> getScopes()
  {
    return Collections.EMPTY_SET;
  }
  
  @KeepForSdk
  public final T getService()
    throws DeadObjectException
  {
    synchronized (this.mLock)
    {
      if (this.zzcj != 5)
      {
        checkConnected();
        boolean bool;
        if (this.zzcg != null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "Client is connected but service is null");
        localObject2 = this.zzcg;
        return (T)localObject2;
      }
      Object localObject2 = new android/os/DeadObjectException;
      ((DeadObjectException)localObject2).<init>();
      throw ((Throwable)localObject2);
    }
  }
  
  @Nullable
  @KeepForSdk
  public IBinder getServiceBrokerBinder()
  {
    synchronized (this.zzcd)
    {
      Object localObject2 = this.zzce;
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((IInterface)localObject2).asBinder();
      return (IBinder)localObject2;
    }
  }
  
  @NonNull
  @KeepForSdk
  protected abstract String getServiceDescriptor();
  
  @KeepForSdk
  public Intent getSignInIntent()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  @NonNull
  @KeepForSdk
  protected abstract String getStartServiceAction();
  
  @KeepForSdk
  protected String getStartServicePackage()
  {
    return "com.google.android.gms";
  }
  
  @KeepForSdk
  public boolean isConnected()
  {
    synchronized (this.mLock)
    {
      boolean bool;
      if (this.zzcj == 4) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  @KeepForSdk
  public boolean isConnecting()
  {
    synchronized (this.mLock)
    {
      int i = this.zzcj;
      boolean bool;
      if ((i != 2) && (i != 3)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectedLocked(@NonNull T paramT)
  {
    this.zzbw = System.currentTimeMillis();
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzbx = paramConnectionResult.getErrorCode();
    this.zzby = System.currentTimeMillis();
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectionSuspended(int paramInt)
  {
    this.zzbu = paramInt;
    this.zzbv = System.currentTimeMillis();
  }
  
  @KeepForSdk
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    Handler localHandler = this.mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(1, paramInt2, -1, new zzf(paramInt1, paramIBinder, paramBundle)));
  }
  
  @KeepForSdk
  void onSetConnectState(int paramInt, T paramT) {}
  
  @KeepForSdk
  public void onUserSignOut(@NonNull SignOutCallbacks paramSignOutCallbacks)
  {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  @KeepForSdk
  public boolean providesSignIn()
  {
    return false;
  }
  
  @KeepForSdk
  public boolean requiresAccount()
  {
    return false;
  }
  
  @KeepForSdk
  public boolean requiresGooglePlayServices()
  {
    return true;
  }
  
  @KeepForSdk
  public boolean requiresSignIn()
  {
    return false;
  }
  
  @KeepForSdk
  public void triggerConnectionSuspended(int paramInt)
  {
    Handler localHandler = this.mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(6, this.zzcr.get(), paramInt));
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, @Nullable PendingIntent paramPendingIntent)
  {
    this.zzcf = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    paramConnectionProgressReportCallbacks = this.mHandler;
    paramConnectionProgressReportCallbacks.sendMessage(paramConnectionProgressReportCallbacks.obtainMessage(3, this.zzcr.get(), paramInt, paramPendingIntent));
  }
  
  protected final void zza(int paramInt1, @Nullable Bundle paramBundle, int paramInt2)
  {
    paramBundle = this.mHandler;
    paramBundle.sendMessage(paramBundle.obtainMessage(7, paramInt2, -1, new zzg(paramInt1, null)));
  }
  
  @KeepForSdk
  public static abstract interface BaseConnectionCallbacks
  {
    @KeepForSdk
    public abstract void onConnected(@Nullable Bundle paramBundle);
    
    @KeepForSdk
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  @KeepForSdk
  public static abstract interface BaseOnConnectionFailedListener
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
  
  @KeepForSdk
  public static abstract interface ConnectionProgressReportCallbacks
  {
    @KeepForSdk
    public abstract void onReportServiceBinding(@NonNull ConnectionResult paramConnectionResult);
  }
  
  protected class LegacyClientCallbackAdapter
    implements BaseGmsClient.ConnectionProgressReportCallbacks
  {
    @KeepForSdk
    public LegacyClientCallbackAdapter() {}
    
    public void onReportServiceBinding(@NonNull ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
      {
        paramConnectionResult = BaseGmsClient.this;
        paramConnectionResult.getRemoteService(null, paramConnectionResult.getScopes());
        return;
      }
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null) {
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
    }
  }
  
  @KeepForSdk
  public static abstract interface SignOutCallbacks
  {
    @KeepForSdk
    public abstract void onSignOutComplete();
  }
  
  private abstract class zza
    extends BaseGmsClient.zzc<Boolean>
  {
    private final int statusCode;
    private final Bundle zzcs;
    
    @BinderThread
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.TRUE);
      this.statusCode = paramInt;
      this.zzcs = paramBundle;
    }
    
    protected abstract void zza(ConnectionResult paramConnectionResult);
    
    protected abstract boolean zzm();
    
    protected final void zzn() {}
  }
  
  final class zzb
    extends zze
  {
    public zzb(Looper paramLooper)
    {
      super();
    }
    
    private static void zza(Message paramMessage)
    {
      paramMessage = (BaseGmsClient.zzc)paramMessage.obj;
      paramMessage.zzn();
      paramMessage.unregister();
    }
    
    private static boolean zzb(Message paramMessage)
    {
      int i = paramMessage.what;
      return (i == 2) || (i == 1) || (i == 7);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (BaseGmsClient.this.zzcr.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      int i = paramMessage.what;
      if (((i == 1) || (i == 7) || ((i == 4) && (!BaseGmsClient.this.enableLocalFallback())) || (paramMessage.what == 5)) && (!BaseGmsClient.this.isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      i = paramMessage.what;
      PendingIntent localPendingIntent = null;
      if (i == 4)
      {
        BaseGmsClient.zza(BaseGmsClient.this, new ConnectionResult(paramMessage.arg2));
        if ((BaseGmsClient.zzb(BaseGmsClient.this)) && (!BaseGmsClient.zzc(BaseGmsClient.this)))
        {
          BaseGmsClient.zza(BaseGmsClient.this, 3, null);
          return;
        }
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null) {
          paramMessage = BaseGmsClient.zzd(BaseGmsClient.this);
        } else {
          paramMessage = new ConnectionResult(8);
        }
        BaseGmsClient.this.zzcf.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        return;
      }
      if (i == 5)
      {
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null) {
          paramMessage = BaseGmsClient.zzd(BaseGmsClient.this);
        } else {
          paramMessage = new ConnectionResult(8);
        }
        BaseGmsClient.this.zzcf.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        return;
      }
      if (i == 3)
      {
        Object localObject = paramMessage.obj;
        if ((localObject instanceof PendingIntent)) {
          localPendingIntent = (PendingIntent)localObject;
        }
        paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        BaseGmsClient.this.zzcf.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        return;
      }
      if (i == 6)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 5, null);
        if (BaseGmsClient.zze(BaseGmsClient.this) != null) {
          BaseGmsClient.zze(BaseGmsClient.this).onConnectionSuspended(paramMessage.arg2);
        }
        BaseGmsClient.this.onConnectionSuspended(paramMessage.arg2);
        BaseGmsClient.zza(BaseGmsClient.this, 5, 1, null);
        return;
      }
      if ((i == 2) && (!BaseGmsClient.this.isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((BaseGmsClient.zzc)paramMessage.obj).zzo();
        return;
      }
      i = paramMessage.what;
      paramMessage = new StringBuilder(45);
      paramMessage.append("Don't know how to handle message: ");
      paramMessage.append(i);
      Log.wtf("GmsClient", paramMessage.toString(), new Exception());
    }
  }
  
  protected abstract class zzc<TListener>
  {
    private TListener zzcu;
    private boolean zzcv;
    
    public zzc()
    {
      Object localObject;
      this.zzcu = localObject;
      this.zzcv = false;
    }
    
    public final void removeListener()
    {
      try
      {
        this.zzcu = null;
        return;
      }
      finally {}
    }
    
    public final void unregister()
    {
      removeListener();
      synchronized (BaseGmsClient.zzf(BaseGmsClient.this))
      {
        BaseGmsClient.zzf(BaseGmsClient.this).remove(this);
        return;
      }
    }
    
    protected abstract void zza(TListener paramTListener);
    
    protected abstract void zzn();
    
    /* Error */
    public final void zzo()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcu	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcv	Z
      //   11: ifeq +61 -> 72
      //   14: aload_0
      //   15: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore_2
      //   19: aload_2
      //   20: invokevirtual 59	java/lang/String:length	()I
      //   23: istore_3
      //   24: new 61	java/lang/StringBuilder
      //   27: astore 4
      //   29: aload 4
      //   31: iload_3
      //   32: bipush 47
      //   34: iadd
      //   35: invokespecial 64	java/lang/StringBuilder:<init>	(I)V
      //   38: aload 4
      //   40: ldc 66
      //   42: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: pop
      //   46: aload 4
      //   48: aload_2
      //   49: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: pop
      //   53: aload 4
      //   55: ldc 72
      //   57: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   60: pop
      //   61: ldc 74
      //   63: aload 4
      //   65: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   68: invokestatic 84	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   71: pop
      //   72: aload_0
      //   73: monitorexit
      //   74: aload_1
      //   75: ifnull +20 -> 95
      //   78: aload_0
      //   79: aload_1
      //   80: invokevirtual 86	com/google/android/gms/common/internal/BaseGmsClient$zzc:zza	(Ljava/lang/Object;)V
      //   83: goto +16 -> 99
      //   86: astore 4
      //   88: aload_0
      //   89: invokevirtual 88	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzn	()V
      //   92: aload 4
      //   94: athrow
      //   95: aload_0
      //   96: invokevirtual 88	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzn	()V
      //   99: aload_0
      //   100: monitorenter
      //   101: aload_0
      //   102: iconst_1
      //   103: putfield 26	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcv	Z
      //   106: aload_0
      //   107: monitorexit
      //   108: aload_0
      //   109: invokevirtual 90	com/google/android/gms/common/internal/BaseGmsClient$zzc:unregister	()V
      //   112: return
      //   113: astore 4
      //   115: aload_0
      //   116: monitorexit
      //   117: aload 4
      //   119: athrow
      //   120: astore 4
      //   122: aload_0
      //   123: monitorexit
      //   124: aload 4
      //   126: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	127	0	this	zzc
      //   6	74	1	localObject1	Object
      //   18	31	2	str	String
      //   23	12	3	i	int
      //   27	37	4	localStringBuilder	StringBuilder
      //   86	7	4	localRuntimeException	RuntimeException
      //   113	5	4	localObject2	Object
      //   120	5	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   78	83	86	java/lang/RuntimeException
      //   101	108	113	finally
      //   115	117	113	finally
      //   2	72	120	finally
      //   72	74	120	finally
      //   122	124	120	finally
    }
  }
  
  @VisibleForTesting
  public static final class zzd
    extends IGmsCallbacks.zza
  {
    private BaseGmsClient zzcw;
    private final int zzcx;
    
    public zzd(@NonNull BaseGmsClient paramBaseGmsClient, int paramInt)
    {
      this.zzcw = paramBaseGmsClient;
      this.zzcx = paramInt;
    }
    
    @BinderThread
    public final void onPostInitComplete(int paramInt, @NonNull IBinder paramIBinder, @Nullable Bundle paramBundle)
    {
      Preconditions.checkNotNull(this.zzcw, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzcw.onPostInitHandler(paramInt, paramIBinder, paramBundle, this.zzcx);
      this.zzcw = null;
    }
    
    @BinderThread
    public final void zza(int paramInt, @Nullable Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
    
    @BinderThread
    public final void zza(int paramInt, @NonNull IBinder paramIBinder, @NonNull zzb paramzzb)
    {
      Preconditions.checkNotNull(this.zzcw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
      Preconditions.checkNotNull(paramzzb);
      BaseGmsClient.zza(this.zzcw, paramzzb);
      onPostInitComplete(paramInt, paramIBinder, paramzzb.zzda);
    }
  }
  
  @VisibleForTesting
  public final class zze
    implements ServiceConnection
  {
    private final int zzcx;
    
    public zze(int paramInt)
    {
      this.zzcx = paramInt;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (paramIBinder == null)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 16);
        return;
      }
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient localBaseGmsClient = BaseGmsClient.this;
        paramComponentName = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        if ((paramComponentName != null) && ((paramComponentName instanceof IGmsServiceBroker))) {
          paramComponentName = (IGmsServiceBroker)paramComponentName;
        } else {
          paramComponentName = new IGmsServiceBroker.Stub.zza(paramIBinder);
        }
        BaseGmsClient.zza(localBaseGmsClient, paramComponentName);
        BaseGmsClient.this.zza(0, null, this.zzcx);
        return;
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient.zza(BaseGmsClient.this, null);
        paramComponentName = BaseGmsClient.this.mHandler;
        paramComponentName.sendMessage(paramComponentName.obtainMessage(6, this.zzcx, 1));
        return;
      }
    }
  }
  
  protected final class zzf
    extends BaseGmsClient.zza
  {
    private final IBinder zzcy;
    
    @BinderThread
    public zzf(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.zzcy = paramIBinder;
    }
    
    protected final void zza(ConnectionResult paramConnectionResult)
    {
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null) {
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected final boolean zzm()
    {
      try
      {
        String str = this.zzcy.getInterfaceDescriptor();
        if (!BaseGmsClient.this.getServiceDescriptor().equals(str))
        {
          localObject = BaseGmsClient.this.getServiceDescriptor();
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 34 + String.valueOf(str).length());
          localStringBuilder.append("service descriptor mismatch: ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" vs. ");
          localStringBuilder.append(str);
          Log.e("GmsClient", localStringBuilder.toString());
          return false;
        }
        Object localObject = BaseGmsClient.this.createServiceInterface(this.zzcy);
        if ((localObject != null) && ((BaseGmsClient.zza(BaseGmsClient.this, 2, 4, (IInterface)localObject)) || (BaseGmsClient.zza(BaseGmsClient.this, 3, 4, (IInterface)localObject))))
        {
          BaseGmsClient.zza(BaseGmsClient.this, null);
          localObject = BaseGmsClient.this.getConnectionHint();
          if (BaseGmsClient.zze(BaseGmsClient.this) != null) {
            BaseGmsClient.zze(BaseGmsClient.this).onConnected((Bundle)localObject);
          }
          return true;
        }
        return false;
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
      }
      return false;
    }
  }
  
  protected final class zzg
    extends BaseGmsClient.zza
  {
    @BinderThread
    public zzg(@Nullable int paramInt, Bundle paramBundle)
    {
      super(paramInt, null);
    }
    
    protected final void zza(ConnectionResult paramConnectionResult)
    {
      if ((BaseGmsClient.this.enableLocalFallback()) && (BaseGmsClient.zzb(BaseGmsClient.this)))
      {
        BaseGmsClient.zza(BaseGmsClient.this, 16);
        return;
      }
      BaseGmsClient.this.zzcf.onReportServiceBinding(paramConnectionResult);
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected final boolean zzm()
    {
      BaseGmsClient.this.zzcf.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\BaseGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */