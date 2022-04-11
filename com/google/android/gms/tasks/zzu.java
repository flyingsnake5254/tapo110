package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzu<TResult>
  extends Task<TResult>
{
  private final Object mLock = new Object();
  @GuardedBy("mLock")
  private TResult zzaa;
  @GuardedBy("mLock")
  private Exception zzab;
  private final zzr<TResult> zzx = new zzr();
  @GuardedBy("mLock")
  private boolean zzy;
  private volatile boolean zzz;
  
  @GuardedBy("mLock")
  private final void zzb()
  {
    Preconditions.checkState(this.zzy, "Task is not yet complete");
  }
  
  @GuardedBy("mLock")
  private final void zzc()
  {
    Preconditions.checkState(this.zzy ^ true, "Task is already complete");
  }
  
  @GuardedBy("mLock")
  private final void zzd()
  {
    if (!this.zzz) {
      return;
    }
    throw new CancellationException("Task is already canceled.");
  }
  
  private final void zze()
  {
    synchronized (this.mLock)
    {
      if (!this.zzy) {
        return;
      }
      this.zzx.zza(this);
      return;
    }
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull Activity paramActivity, @NonNull OnCanceledListener paramOnCanceledListener)
  {
    paramOnCanceledListener = new zzg(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzx.zza(paramOnCanceledListener);
    zza.zza(paramActivity).zzb(paramOnCanceledListener);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener paramOnCanceledListener)
  {
    return addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull Executor paramExecutor, @NonNull OnCanceledListener paramOnCanceledListener)
  {
    this.zzx.zza(new zzg(paramExecutor, paramOnCanceledListener));
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull Activity paramActivity, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    paramOnCompleteListener = new zzi(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzx.zza(paramOnCompleteListener);
    zza.zza(paramActivity).zzb(paramOnCompleteListener);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzx.zza(new zzi(paramExecutor, paramOnCompleteListener));
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull Activity paramActivity, @NonNull OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new zzk(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzx.zza(paramOnFailureListener);
    zza.zza(paramActivity).zzb(paramOnFailureListener);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener)
  {
    this.zzx.zza(new zzk(paramExecutor, paramOnFailureListener));
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull Activity paramActivity, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    paramOnSuccessListener = new zzm(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzx.zza(paramOnSuccessListener);
    zza.zza(paramActivity).zzb(paramOnSuccessListener);
    zze();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzx.zza(new zzm(paramExecutor, paramOnSuccessListener));
    zze();
    return this;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zzc(paramExecutor, paramContinuation, localzzu));
    zze();
    return localzzu;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zze(paramExecutor, paramContinuation, localzzu));
    zze();
    return localzzu;
  }
  
  @Nullable
  public final Exception getException()
  {
    synchronized (this.mLock)
    {
      Exception localException = this.zzab;
      return localException;
    }
  }
  
  public final TResult getResult()
  {
    synchronized (this.mLock)
    {
      zzb();
      zzd();
      if (this.zzab == null)
      {
        localObject2 = this.zzaa;
        return (TResult)localObject2;
      }
      Object localObject2 = new com/google/android/gms/tasks/RuntimeExecutionException;
      ((RuntimeExecutionException)localObject2).<init>(this.zzab);
      throw ((Throwable)localObject2);
    }
  }
  
  public final <X extends Throwable> TResult getResult(@NonNull Class<X> paramClass)
    throws Throwable
  {
    synchronized (this.mLock)
    {
      zzb();
      zzd();
      if (!paramClass.isInstance(this.zzab))
      {
        if (this.zzab == null)
        {
          paramClass = this.zzaa;
          return paramClass;
        }
        paramClass = new com/google/android/gms/tasks/RuntimeExecutionException;
        paramClass.<init>(this.zzab);
        throw paramClass;
      }
      throw ((Throwable)paramClass.cast(this.zzab));
    }
  }
  
  public final boolean isCanceled()
  {
    return this.zzz;
  }
  
  public final boolean isComplete()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.zzy;
      return bool;
    }
  }
  
  public final boolean isSuccessful()
  {
    synchronized (this.mLock)
    {
      boolean bool;
      if ((this.zzy) && (!this.zzz) && (this.zzab == null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    return onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zzo(paramExecutor, paramSuccessContinuation, localzzu));
    zze();
    return localzzu;
  }
  
  public final void setException(@NonNull Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      zzc();
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return;
    }
  }
  
  public final void setResult(TResult paramTResult)
  {
    synchronized (this.mLock)
    {
      zzc();
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return;
    }
  }
  
  public final boolean trySetException(@NonNull Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      if (this.zzy) {
        return false;
      }
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return true;
    }
  }
  
  public final boolean trySetResult(TResult paramTResult)
  {
    synchronized (this.mLock)
    {
      if (this.zzy) {
        return false;
      }
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return true;
    }
  }
  
  public final boolean zza()
  {
    synchronized (this.mLock)
    {
      if (this.zzy) {
        return false;
      }
      this.zzy = true;
      this.zzz = true;
      this.zzx.zza(this);
      return true;
    }
  }
  
  private static class zza
    extends LifecycleCallback
  {
    private final List<WeakReference<zzq<?>>> zzac = new ArrayList();
    
    private zza(LifecycleFragment paramLifecycleFragment)
    {
      super();
      this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }
    
    public static zza zza(Activity paramActivity)
    {
      LifecycleFragment localLifecycleFragment = LifecycleCallback.getFragment(paramActivity);
      zza localzza = (zza)localLifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
      paramActivity = localzza;
      if (localzza == null) {
        paramActivity = new zza(localLifecycleFragment);
      }
      return paramActivity;
    }
    
    @MainThread
    public void onStop()
    {
      synchronized (this.zzac)
      {
        Iterator localIterator = this.zzac.iterator();
        while (localIterator.hasNext())
        {
          zzq localzzq = (zzq)((WeakReference)localIterator.next()).get();
          if (localzzq != null) {
            localzzq.cancel();
          }
        }
        this.zzac.clear();
        return;
      }
    }
    
    public final <T> void zzb(zzq<T> paramzzq)
    {
      synchronized (this.zzac)
      {
        List localList2 = this.zzac;
        WeakReference localWeakReference = new java/lang/ref/WeakReference;
        localWeakReference.<init>(paramzzq);
        localList2.add(localWeakReference);
        return;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */