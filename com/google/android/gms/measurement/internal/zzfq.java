package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

final class zzfq
  extends Thread
{
  private final Object zzb;
  private final BlockingQueue<zzfp<?>> zzc;
  @GuardedBy("threadLifeCycleLock")
  private boolean zzd = false;
  
  public zzfq(String paramString, BlockingQueue<zzfp<?>> paramBlockingQueue)
  {
    Preconditions.checkNotNull(paramBlockingQueue);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzb = new Object();
    this.zzc = ((BlockingQueue)localObject);
    setName(paramBlockingQueue);
  }
  
  private final void zzb()
  {
    synchronized (zzfr.zzn(this.zza))
    {
      if (!this.zzd)
      {
        zzfr.zzl(this.zza).release();
        zzfr.zzn(this.zza).notifyAll();
        if (this == zzfr.zzo(this.zza)) {
          zzfr.zzp(this.zza, null);
        } else if (this == zzfr.zzq(this.zza)) {
          zzfr.zzr(this.zza, null);
        } else {
          this.zza.zzs.zzau().zzb().zza("Current scheduler thread is neither worker nor network");
        }
        this.zzd = true;
      }
      return;
    }
  }
  
  private final void zzc(InterruptedException paramInterruptedException)
  {
    this.zza.zzs.zzau().zze().zzb(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +27 -> 30
    //   6: aload_0
    //   7: getfield 20	com/google/android/gms/measurement/internal/zzfq:zza	Lcom/google/android/gms/measurement/internal/zzfr;
    //   10: invokestatic 55	com/google/android/gms/measurement/internal/zzfr:zzl	(Lcom/google/android/gms/measurement/internal/zzfr;)Ljava/util/concurrent/Semaphore;
    //   13: invokevirtual 129	java/util/concurrent/Semaphore:acquire	()V
    //   16: iconst_1
    //   17: istore_1
    //   18: goto -16 -> 2
    //   21: astore_2
    //   22: aload_0
    //   23: aload_2
    //   24: invokespecial 131	com/google/android/gms/measurement/internal/zzfq:zzc	(Ljava/lang/InterruptedException;)V
    //   27: goto -25 -> 2
    //   30: invokestatic 137	android/os/Process:myTid	()I
    //   33: invokestatic 141	android/os/Process:getThreadPriority	(I)I
    //   36: istore_3
    //   37: aload_0
    //   38: getfield 38	com/google/android/gms/measurement/internal/zzfq:zzc	Ljava/util/concurrent/BlockingQueue;
    //   41: invokeinterface 147 1 0
    //   46: checkcast 149	com/google/android/gms/measurement/internal/zzfp
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +30 -> 81
    //   54: iconst_1
    //   55: aload_2
    //   56: getfield 151	com/google/android/gms/measurement/internal/zzfp:zza	Z
    //   59: if_icmpeq +9 -> 68
    //   62: bipush 10
    //   64: istore_1
    //   65: goto +5 -> 70
    //   68: iload_3
    //   69: istore_1
    //   70: iload_1
    //   71: invokestatic 155	android/os/Process:setThreadPriority	(I)V
    //   74: aload_2
    //   75: invokevirtual 159	java/util/concurrent/FutureTask:run	()V
    //   78: goto -41 -> 37
    //   81: aload_0
    //   82: getfield 36	com/google/android/gms/measurement/internal/zzfq:zzb	Ljava/lang/Object;
    //   85: astore_2
    //   86: aload_2
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 38	com/google/android/gms/measurement/internal/zzfq:zzc	Ljava/util/concurrent/BlockingQueue;
    //   92: invokeinterface 162 1 0
    //   97: ifnonnull +32 -> 129
    //   100: aload_0
    //   101: getfield 20	com/google/android/gms/measurement/internal/zzfq:zza	Lcom/google/android/gms/measurement/internal/zzfr;
    //   104: invokestatic 166	com/google/android/gms/measurement/internal/zzfr:zzm	(Lcom/google/android/gms/measurement/internal/zzfr;)Z
    //   107: pop
    //   108: aload_0
    //   109: getfield 36	com/google/android/gms/measurement/internal/zzfq:zzb	Ljava/lang/Object;
    //   112: ldc2_w 167
    //   115: invokevirtual 172	java/lang/Object:wait	(J)V
    //   118: goto +11 -> 129
    //   121: astore 4
    //   123: aload_0
    //   124: aload 4
    //   126: invokespecial 131	com/google/android/gms/measurement/internal/zzfq:zzc	(Ljava/lang/InterruptedException;)V
    //   129: aload_2
    //   130: monitorexit
    //   131: aload_0
    //   132: getfield 20	com/google/android/gms/measurement/internal/zzfq:zza	Lcom/google/android/gms/measurement/internal/zzfr;
    //   135: invokestatic 51	com/google/android/gms/measurement/internal/zzfr:zzn	(Lcom/google/android/gms/measurement/internal/zzfr;)Ljava/lang/Object;
    //   138: astore_2
    //   139: aload_2
    //   140: monitorenter
    //   141: aload_0
    //   142: getfield 38	com/google/android/gms/measurement/internal/zzfq:zzc	Ljava/util/concurrent/BlockingQueue;
    //   145: invokeinterface 162 1 0
    //   150: ifnonnull +34 -> 184
    //   153: aload_0
    //   154: getfield 20	com/google/android/gms/measurement/internal/zzfq:zza	Lcom/google/android/gms/measurement/internal/zzfr;
    //   157: getfield 83	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   160: invokevirtual 175	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   163: aconst_null
    //   164: getstatic 181	com/google/android/gms/measurement/internal/zzea:zzao	Lcom/google/android/gms/measurement/internal/zzdz;
    //   167: invokevirtual 186	com/google/android/gms/measurement/internal/zzae:zzn	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzdz;)Z
    //   170: ifeq +7 -> 177
    //   173: aload_0
    //   174: invokespecial 188	com/google/android/gms/measurement/internal/zzfq:zzb	()V
    //   177: aload_2
    //   178: monitorexit
    //   179: aload_0
    //   180: invokespecial 188	com/google/android/gms/measurement/internal/zzfq:zzb	()V
    //   183: return
    //   184: aload_2
    //   185: monitorexit
    //   186: goto -149 -> 37
    //   189: astore 4
    //   191: aload_2
    //   192: monitorexit
    //   193: aload 4
    //   195: athrow
    //   196: astore 4
    //   198: aload_2
    //   199: monitorexit
    //   200: aload 4
    //   202: athrow
    //   203: astore_2
    //   204: aload_0
    //   205: invokespecial 188	com/google/android/gms/measurement/internal/zzfq:zzb	()V
    //   208: aload_2
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	zzfq
    //   1	70	1	i	int
    //   21	3	2	localInterruptedException1	InterruptedException
    //   203	6	2	localObject2	Object
    //   36	33	3	j	int
    //   121	4	4	localInterruptedException2	InterruptedException
    //   189	5	4	localObject3	Object
    //   196	5	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	16	21	java/lang/InterruptedException
    //   108	118	121	java/lang/InterruptedException
    //   141	177	189	finally
    //   177	179	189	finally
    //   184	186	189	finally
    //   191	193	189	finally
    //   88	108	196	finally
    //   108	118	196	finally
    //   123	129	196	finally
    //   129	131	196	finally
    //   198	200	196	finally
    //   30	37	203	finally
    //   37	50	203	finally
    //   54	62	203	finally
    //   70	78	203	finally
    //   81	88	203	finally
    //   131	141	203	finally
    //   193	196	203	finally
    //   200	203	203	finally
  }
  
  public final void zza()
  {
    synchronized (this.zzb)
    {
      this.zzb.notifyAll();
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */