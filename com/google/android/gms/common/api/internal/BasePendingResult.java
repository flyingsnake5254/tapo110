package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zadn = new zap();
  @KeepName
  private zaa mResultGuardian;
  private Status mStatus;
  private R zacj;
  private final Object zado = new Object();
  private final CallbackHandler<R> zadp;
  private final WeakReference<GoogleApiClient> zadq;
  private final CountDownLatch zadr = new CountDownLatch(1);
  private final ArrayList<PendingResult.StatusListener> zads = new ArrayList();
  private ResultCallback<? super R> zadt;
  private final AtomicReference<zacs> zadu = new AtomicReference();
  private volatile boolean zadv;
  private boolean zadw;
  private boolean zadx;
  private ICancelToken zady;
  private volatile zacm<R> zadz;
  private boolean zaea = false;
  
  @Deprecated
  BasePendingResult()
  {
    this.zadp = new CallbackHandler(Looper.getMainLooper());
    this.zadq = new WeakReference(null);
  }
  
  @Deprecated
  @KeepForSdk
  protected BasePendingResult(Looper paramLooper)
  {
    this.zadp = new CallbackHandler(paramLooper);
    this.zadq = new WeakReference(null);
  }
  
  @KeepForSdk
  protected BasePendingResult(GoogleApiClient paramGoogleApiClient)
  {
    Looper localLooper;
    if (paramGoogleApiClient != null) {
      localLooper = paramGoogleApiClient.getLooper();
    } else {
      localLooper = Looper.getMainLooper();
    }
    this.zadp = new CallbackHandler(localLooper);
    this.zadq = new WeakReference(paramGoogleApiClient);
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BasePendingResult(@NonNull CallbackHandler<R> paramCallbackHandler)
  {
    this.zadp = ((CallbackHandler)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null"));
    this.zadq = new WeakReference(null);
  }
  
  private final R get()
  {
    synchronized (this.zado)
    {
      boolean bool;
      if (!this.zadv) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Result has already been consumed.");
      Preconditions.checkState(isReady(), "Result is not ready.");
      Result localResult = this.zacj;
      this.zacj = null;
      this.zadt = null;
      this.zadv = true;
      ??? = (zacs)this.zadu.getAndSet(null);
      if (??? != null) {
        ((zacs)???).zac(this);
      }
      return localResult;
    }
  }
  
  private final void zaa(R paramR)
  {
    this.zacj = paramR;
    this.zady = null;
    this.zadr.countDown();
    this.mStatus = this.zacj.getStatus();
    if (this.zadw)
    {
      this.zadt = null;
    }
    else if (this.zadt == null)
    {
      if ((this.zacj instanceof Releasable)) {
        this.mResultGuardian = new zaa(null);
      }
    }
    else
    {
      this.zadp.removeMessages(2);
      this.zadp.zaa(this.zadt, get());
    }
    paramR = this.zads;
    int i = paramR.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = paramR.get(j);
      j++;
      ((PendingResult.StatusListener)localObject).onComplete(this.mStatus);
    }
    this.zads.clear();
  }
  
  public static void zab(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        paramResult = String.valueOf(paramResult);
        StringBuilder localStringBuilder = new StringBuilder(paramResult.length() + 18);
        localStringBuilder.append("Unable to release ");
        localStringBuilder.append(paramResult);
        Log.w("BasePendingResult", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    boolean bool;
    if (paramStatusListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Callback cannot be null.");
    synchronized (this.zado)
    {
      if (isReady()) {
        paramStatusListener.onComplete(this.mStatus);
      } else {
        this.zads.add(paramStatusListener);
      }
      return;
    }
  }
  
  public final R await()
  {
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool1 = this.zadv;
    boolean bool2 = true;
    Preconditions.checkState(bool1 ^ true, "Result has already been consumed");
    if (this.zadz != null) {
      bool2 = false;
    }
    Preconditions.checkState(bool2, "Cannot await if then() has been called.");
    try
    {
      this.zadr.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      zab(Status.RESULT_INTERRUPTED);
    }
    Preconditions.checkState(isReady(), "Result is not ready.");
    return get();
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L) {
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
    }
    boolean bool1 = this.zadv;
    boolean bool2 = true;
    Preconditions.checkState(bool1 ^ true, "Result has already been consumed.");
    if (this.zadz != null) {
      bool2 = false;
    }
    Preconditions.checkState(bool2, "Cannot await if then() has been called.");
    try
    {
      if (!this.zadr.await(paramLong, paramTimeUnit)) {
        zab(Status.RESULT_TIMEOUT);
      }
    }
    catch (InterruptedException paramTimeUnit)
    {
      zab(Status.RESULT_INTERRUPTED);
    }
    Preconditions.checkState(isReady(), "Result is not ready.");
    return get();
  }
  
  @KeepForSdk
  public void cancel()
  {
    ICancelToken localICancelToken;
    synchronized (this.zado)
    {
      if ((!this.zadw) && (!this.zadv))
      {
        localICancelToken = this.zady;
        if (localICancelToken == null) {}
      }
    }
    try
    {
      localICancelToken.cancel();
      zab(this.zacj);
      this.zadw = true;
      zaa(createFailedResult(Status.RESULT_CANCELED));
      return;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  @NonNull
  @KeepForSdk
  protected abstract R createFailedResult(Status paramStatus);
  
  public boolean isCanceled()
  {
    synchronized (this.zado)
    {
      boolean bool = this.zadw;
      return bool;
    }
  }
  
  @KeepForSdk
  public final boolean isReady()
  {
    return this.zadr.getCount() == 0L;
  }
  
  @KeepForSdk
  protected final void setCancelToken(ICancelToken paramICancelToken)
  {
    synchronized (this.zado)
    {
      this.zady = paramICancelToken;
      return;
    }
  }
  
  @KeepForSdk
  public final void setResult(R paramR)
  {
    synchronized (this.zado)
    {
      if ((!this.zadx) && (!this.zadw))
      {
        isReady();
        boolean bool1 = isReady();
        boolean bool2 = true;
        if (!bool1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        Preconditions.checkState(bool1, "Results have already been set");
        if (!this.zadv) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        Preconditions.checkState(bool1, "Result has already been consumed");
        zaa(paramR);
        return;
      }
      zab(paramR);
      return;
    }
  }
  
  @KeepForSdk
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    localObject = this.zado;
    if (paramResultCallback == null) {}
    try
    {
      this.zadt = null;
      return;
    }
    finally {}
    boolean bool1 = this.zadv;
    boolean bool2 = true;
    if (!bool1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Result has already been consumed.");
    if (this.zadz == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
    if (isCanceled()) {
      return;
    }
    if (isReady()) {
      this.zadp.zaa(paramResultCallback, get());
    } else {
      this.zadt = paramResultCallback;
    }
  }
  
  @KeepForSdk
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    localObject = this.zado;
    if (paramResultCallback == null) {}
    try
    {
      this.zadt = null;
      return;
    }
    finally {}
    boolean bool1 = this.zadv;
    boolean bool2 = true;
    if (!bool1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Result has already been consumed.");
    if (this.zadz == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
    if (isCanceled()) {
      return;
    }
    if (isReady())
    {
      this.zadp.zaa(paramResultCallback, get());
    }
    else
    {
      this.zadt = paramResultCallback;
      paramResultCallback = this.zadp;
      paramLong = paramTimeUnit.toMillis(paramLong);
      paramResultCallback.sendMessageDelayed(paramResultCallback.obtainMessage(2, this), paramLong);
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    Preconditions.checkState(this.zadv ^ true, "Result has already been consumed.");
    synchronized (this.zado)
    {
      zacm localzacm = this.zadz;
      boolean bool1 = false;
      if (localzacm == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Preconditions.checkState(bool2, "Cannot call then() twice.");
      if (this.zadt == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Preconditions.checkState(bool2, "Cannot call then() if callbacks are set.");
      boolean bool2 = bool1;
      if (!this.zadw) {
        bool2 = true;
      }
      Preconditions.checkState(bool2, "Cannot call then() if result was canceled.");
      this.zaea = true;
      localzacm = new com/google/android/gms/common/api/internal/zacm;
      localzacm.<init>(this.zadq);
      this.zadz = localzacm;
      paramResultTransform = this.zadz.then(paramResultTransform);
      if (isReady()) {
        this.zadp.zaa(this.zadz, get());
      } else {
        this.zadt = this.zadz;
      }
      return paramResultTransform;
    }
  }
  
  public final void zaa(zacs paramzacs)
  {
    this.zadu.set(paramzacs);
  }
  
  public final void zab(Status paramStatus)
  {
    synchronized (this.zado)
    {
      if (!isReady())
      {
        setResult(createFailedResult(paramStatus));
        this.zadx = true;
      }
      return;
    }
  }
  
  public final Integer zam()
  {
    return null;
  }
  
  public final boolean zat()
  {
    synchronized (this.zado)
    {
      if (((GoogleApiClient)this.zadq.get() == null) || (!this.zaea)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public final void zau()
  {
    boolean bool;
    if ((!this.zaea) && (!((Boolean)zadn.get()).booleanValue())) {
      bool = false;
    } else {
      bool = true;
    }
    this.zaea = bool;
  }
  
  @VisibleForTesting
  public static class CallbackHandler<R extends Result>
    extends com.google.android.gms.internal.base.zap
  {
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          paramMessage = new StringBuilder(45);
          paramMessage.append("Don't know how to handle message: ");
          paramMessage.append(i);
          Log.wtf("BasePendingResult", paramMessage.toString(), new Exception());
          return;
        }
        ((BasePendingResult)paramMessage.obj).zab(Status.RESULT_TIMEOUT);
        return;
      }
      paramMessage = (Pair)paramMessage.obj;
      ResultCallback localResultCallback = (ResultCallback)paramMessage.first;
      paramMessage = (Result)paramMessage.second;
      try
      {
        localResultCallback.onResult(paramMessage);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        BasePendingResult.zab(paramMessage);
        throw localRuntimeException;
      }
    }
    
    public final void zaa(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
  }
  
  private final class zaa
  {
    private zaa() {}
    
    protected final void finalize()
      throws Throwable
    {
      BasePendingResult.zab(BasePendingResult.zaa(BasePendingResult.this));
      super.finalize();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\BasePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */