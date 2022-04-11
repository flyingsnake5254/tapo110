package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class zzfr
  extends zzgo
{
  private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
  @Nullable
  private zzfq zza;
  @Nullable
  private zzfq zzb;
  private final PriorityBlockingQueue<zzfp<?>> zzc = new PriorityBlockingQueue();
  private final BlockingQueue<zzfp<?>> zzd = new LinkedBlockingQueue();
  private final Thread.UncaughtExceptionHandler zze = new zzfo(this, "Thread death: Uncaught exception on worker thread");
  private final Thread.UncaughtExceptionHandler zzf = new zzfo(this, "Thread death: Uncaught exception on network thread");
  private final Object zzg = new Object();
  private final Semaphore zzh = new Semaphore(2);
  private volatile boolean zzi;
  
  zzfr(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  private final void zzt(zzfp<?> paramzzfp)
  {
    synchronized (this.zzg)
    {
      this.zzc.add(paramzzfp);
      paramzzfp = this.zza;
      if (paramzzfp == null)
      {
        paramzzfp = new com/google/android/gms/measurement/internal/zzfq;
        paramzzfp.<init>(this, "Measurement Worker", this.zzc);
        this.zza = paramzzfp;
        paramzzfp.setUncaughtExceptionHandler(this.zze);
        this.zza.start();
      }
      else
      {
        paramzzfp.zza();
      }
      return;
    }
  }
  
  protected final boolean zza()
  {
    return false;
  }
  
  public final void zzaw()
  {
    if (Thread.currentThread() == this.zzb) {
      return;
    }
    throw new IllegalStateException("Call expected from network thread");
  }
  
  public final boolean zzd()
  {
    return Thread.currentThread() == this.zza;
  }
  
  public final <V> Future<V> zze(Callable<V> paramCallable)
    throws IllegalStateException
  {
    zzv();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzfp(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == this.zza)
    {
      if (!this.zzc.isEmpty()) {
        this.zzs.zzau().zze().zza("Callable skipped the worker queue.");
      }
      paramCallable.run();
    }
    else
    {
      zzt(paramCallable);
    }
    return paramCallable;
  }
  
  public final <V> Future<V> zzf(Callable<V> paramCallable)
    throws IllegalStateException
  {
    zzv();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzfp(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == this.zza) {
      paramCallable.run();
    } else {
      zzt(paramCallable);
    }
    return paramCallable;
  }
  
  public final void zzg()
  {
    if (Thread.currentThread() == this.zza) {
      return;
    }
    throw new IllegalStateException("Call expected from worker thread");
  }
  
  public final void zzh(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzv();
    Preconditions.checkNotNull(paramRunnable);
    zzt(new zzfp(this, paramRunnable, false, "Task exception on worker thread"));
  }
  
  /* Error */
  @Nullable
  final <T> T zzi(java.util.concurrent.atomic.AtomicReference<T> paramAtomicReference, long paramLong, String paramString, Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 161	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   6: invokevirtual 200	com/google/android/gms/measurement/internal/zzfu:zzav	()Lcom/google/android/gms/measurement/internal/zzfr;
    //   9: aload 5
    //   11: invokevirtual 202	com/google/android/gms/measurement/internal/zzfr:zzh	(Ljava/lang/Runnable;)V
    //   14: aload_1
    //   15: lload_2
    //   16: invokevirtual 205	java/lang/Object:wait	(J)V
    //   19: aload_1
    //   20: monitorexit
    //   21: aload_1
    //   22: invokevirtual 211	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +50 -> 79
    //   32: aload_0
    //   33: getfield 161	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   36: invokevirtual 167	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   39: invokevirtual 172	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   42: astore 5
    //   44: aload 4
    //   46: invokevirtual 217	java/lang/String:length	()I
    //   49: ifeq +14 -> 63
    //   52: ldc -37
    //   54: aload 4
    //   56: invokevirtual 223	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: goto +13 -> 73
    //   63: new 213	java/lang/String
    //   66: dup
    //   67: ldc -37
    //   69: invokespecial 224	java/lang/String:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: aload 5
    //   75: aload_1
    //   76: invokevirtual 178	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   79: aload 6
    //   81: areturn
    //   82: astore 5
    //   84: aload_0
    //   85: getfield 161	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   88: invokevirtual 167	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   91: invokevirtual 172	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   94: astore 5
    //   96: aload 4
    //   98: invokevirtual 217	java/lang/String:length	()I
    //   101: ifeq +15 -> 116
    //   104: ldc -30
    //   106: aload 4
    //   108: invokevirtual 223	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 4
    //   113: goto +14 -> 127
    //   116: new 213	java/lang/String
    //   119: dup
    //   120: ldc -30
    //   122: invokespecial 224	java/lang/String:<init>	(Ljava/lang/String;)V
    //   125: astore 4
    //   127: aload 5
    //   129: aload 4
    //   131: invokevirtual 178	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   134: aload_1
    //   135: monitorexit
    //   136: aconst_null
    //   137: areturn
    //   138: astore 4
    //   140: aload_1
    //   141: monitorexit
    //   142: aload 4
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	zzfr
    //   0	145	1	paramAtomicReference	java.util.concurrent.atomic.AtomicReference<T>
    //   0	145	2	paramLong	long
    //   0	145	4	paramString	String
    //   0	145	5	paramRunnable	Runnable
    //   25	55	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	82	java/lang/InterruptedException
    //   2	14	138	finally
    //   14	19	138	finally
    //   19	21	138	finally
    //   84	113	138	finally
    //   116	127	138	finally
    //   127	136	138	finally
    //   140	142	138	finally
  }
  
  public final void zzj(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzv();
    Preconditions.checkNotNull(paramRunnable);
    zzt(new zzfp(this, paramRunnable, true, "Task exception on worker thread"));
  }
  
  public final void zzk(Runnable arg1)
    throws IllegalStateException
  {
    zzv();
    Preconditions.checkNotNull(???);
    Object localObject1 = new zzfp(this, ???, false, "Task exception on network thread");
    synchronized (this.zzg)
    {
      this.zzd.add(localObject1);
      localObject1 = this.zzb;
      if (localObject1 == null)
      {
        localObject1 = new com/google/android/gms/measurement/internal/zzfq;
        ((zzfq)localObject1).<init>(this, "Measurement Network", this.zzd);
        this.zzb = ((zzfq)localObject1);
        ((Thread)localObject1).setUncaughtExceptionHandler(this.zzf);
        this.zzb.start();
      }
      else
      {
        ((zzfq)localObject1).zza();
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */