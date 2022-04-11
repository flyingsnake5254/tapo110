package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zacm<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final Object zado = new Object();
  private final WeakReference<GoogleApiClient> zadq;
  private ResultTransform<? super R, ? extends Result> zako = null;
  private zacm<? extends Result> zakp = null;
  private volatile ResultCallbacks<? super R> zakq = null;
  private PendingResult<R> zakr = null;
  private Status zaks = null;
  private final zaco zakt;
  private boolean zaku = false;
  
  public zacm(WeakReference<GoogleApiClient> paramWeakReference)
  {
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zadq = paramWeakReference;
    paramWeakReference = (GoogleApiClient)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference = paramWeakReference.getLooper();
    } else {
      paramWeakReference = Looper.getMainLooper();
    }
    this.zakt = new zaco(this, paramWeakReference);
  }
  
  private static void zab(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        String str = String.valueOf(paramResult);
        paramResult = new StringBuilder(str.length() + 18);
        paramResult.append("Unable to release ");
        paramResult.append(str);
        Log.w("TransformedResultImpl", paramResult.toString(), localRuntimeException);
      }
    }
  }
  
  @GuardedBy("mSyncToken")
  private final void zabu()
  {
    if ((this.zako == null) && (this.zakq == null)) {
      return;
    }
    Object localObject = (GoogleApiClient)this.zadq.get();
    if ((!this.zaku) && (this.zako != null) && (localObject != null))
    {
      ((GoogleApiClient)localObject).zaa(this);
      this.zaku = true;
    }
    localObject = this.zaks;
    if (localObject != null)
    {
      zae((Status)localObject);
      return;
    }
    localObject = this.zakr;
    if (localObject != null) {
      ((PendingResult)localObject).setResultCallback(this);
    }
  }
  
  @GuardedBy("mSyncToken")
  private final boolean zabw()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zadq.get();
    return (this.zakq != null) && (localGoogleApiClient != null);
  }
  
  private final void zad(Status paramStatus)
  {
    synchronized (this.zado)
    {
      this.zaks = paramStatus;
      zae(paramStatus);
      return;
    }
  }
  
  private final void zae(Status paramStatus)
  {
    synchronized (this.zado)
    {
      ResultTransform localResultTransform = this.zako;
      if (localResultTransform != null)
      {
        paramStatus = localResultTransform.onFailure(paramStatus);
        Preconditions.checkNotNull(paramStatus, "onFailure must not return null");
        this.zakp.zad(paramStatus);
      }
      else if (zabw())
      {
        this.zakq.onFailure(paramStatus);
      }
      return;
    }
  }
  
  public final void andFinally(@NonNull ResultCallbacks<? super R> paramResultCallbacks)
  {
    synchronized (this.zado)
    {
      ResultCallbacks localResultCallbacks = this.zakq;
      boolean bool1 = true;
      boolean bool2;
      if (localResultCallbacks == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Preconditions.checkState(bool2, "Cannot call andFinally() twice.");
      if (this.zako == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      Preconditions.checkState(bool2, "Cannot call then() and andFinally() on the same TransformedResult.");
      this.zakq = paramResultCallbacks;
      zabu();
      return;
    }
  }
  
  public final void onResult(R paramR)
  {
    synchronized (this.zado)
    {
      if (paramR.getStatus().isSuccess())
      {
        if (this.zako != null)
        {
          ExecutorService localExecutorService = zacc.zabb();
          zacn localzacn = new com/google/android/gms/common/api/internal/zacn;
          localzacn.<init>(this, paramR);
          localExecutorService.submit(localzacn);
        }
        else if (zabw())
        {
          this.zakq.onSuccess(paramR);
        }
      }
      else
      {
        zad(paramR.getStatus());
        zab(paramR);
      }
      return;
    }
  }
  
  @NonNull
  public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    synchronized (this.zado)
    {
      ResultTransform localResultTransform = this.zako;
      boolean bool1 = true;
      boolean bool2;
      if (localResultTransform == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Preconditions.checkState(bool2, "Cannot call then() twice.");
      if (this.zakq == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      Preconditions.checkState(bool2, "Cannot call then() and andFinally() on the same TransformedResult.");
      this.zako = paramResultTransform;
      paramResultTransform = new com/google/android/gms/common/api/internal/zacm;
      paramResultTransform.<init>(this.zadq);
      this.zakp = paramResultTransform;
      zabu();
      return paramResultTransform;
    }
  }
  
  public final void zaa(PendingResult<?> paramPendingResult)
  {
    synchronized (this.zado)
    {
      this.zakr = paramPendingResult;
      zabu();
      return;
    }
  }
  
  final void zabv()
  {
    this.zakq = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zacm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */