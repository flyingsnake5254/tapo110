package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@KeepForSdk
public class AdvertisingIdClient
{
  @GuardedBy("this")
  private final Context mContext;
  @Nullable
  @GuardedBy("this")
  private BlockingServiceConnection zze;
  @Nullable
  @GuardedBy("this")
  private zze zzf;
  @GuardedBy("this")
  private boolean zzg;
  private final Object zzh = new Object();
  @Nullable
  @GuardedBy("mAutoDisconnectTaskLock")
  private zza zzi;
  private final boolean zzj;
  private final long zzk;
  
  @KeepForSdk
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false, false);
  }
  
  @VisibleForTesting
  private AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramContext);
    Context localContext = paramContext;
    if (paramBoolean1)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext == null) {
        localContext = paramContext;
      }
    }
    this.mContext = localContext;
    this.zzg = false;
    this.zzk = paramLong;
    this.zzj = paramBoolean2;
  }
  
  @KeepForSdk
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    Object localObject1 = new zzb(paramContext);
    boolean bool = ((zzb)localObject1).getBoolean("gads:ad_id_app_context:enabled", false);
    float f = ((zzb)localObject1).getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
    String str = ((zzb)localObject1).getString("gads:ad_id_use_shared_preference:experiment_id", "");
    paramContext = new AdvertisingIdClient(paramContext, -1L, bool, ((zzb)localObject1).getBoolean("gads:ad_id_use_persistent_service:enabled", false));
    try
    {
      long l = SystemClock.elapsedRealtime();
      paramContext.zza(false);
      localObject1 = paramContext.getInfo();
      paramContext.zza((Info)localObject1, bool, f, SystemClock.elapsedRealtime() - l, str, null);
      paramContext.finish();
      return (Info)localObject1;
    }
    finally
    {
      try
      {
        paramContext.zza(null, bool, f, -1L, str, localThrowable);
        throw localThrowable;
      }
      finally
      {
        paramContext.finish();
      }
    }
  }
  
  @KeepForSdk
  public static boolean getIsAdIdFakeForDebugLogging(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzb localzzb = new zzb(paramContext);
    paramContext = new AdvertisingIdClient(paramContext, -1L, localzzb.getBoolean("gads:ad_id_app_context:enabled", false), localzzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
    try
    {
      paramContext.zza(false);
      boolean bool = paramContext.zzb();
      return bool;
    }
    finally
    {
      paramContext.finish();
    }
  }
  
  @KeepForSdk
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  /* Error */
  private static BlockingServiceConnection zza(Context paramContext, boolean paramBoolean)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 141	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: ldc -113
    //   6: iconst_0
    //   7: invokevirtual 149	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   10: pop
    //   11: invokestatic 155	com/google/android/gms/common/GoogleApiAvailabilityLight:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   14: aload_0
    //   15: ldc -100
    //   17: invokevirtual 160	com/google/android/gms/common/GoogleApiAvailabilityLight:isGooglePlayServicesAvailable	(Landroid/content/Context;I)I
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +21 -> 43
    //   25: iload_2
    //   26: iconst_2
    //   27: if_icmpne +6 -> 33
    //   30: goto +13 -> 43
    //   33: new 71	java/io/IOException
    //   36: dup
    //   37: ldc -94
    //   39: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: iload_1
    //   44: ifeq +9 -> 53
    //   47: ldc -127
    //   49: astore_3
    //   50: goto +6 -> 56
    //   53: ldc -89
    //   55: astore_3
    //   56: new 169	com/google/android/gms/common/BlockingServiceConnection
    //   59: dup
    //   60: invokespecial 170	com/google/android/gms/common/BlockingServiceConnection:<init>	()V
    //   63: astore 4
    //   65: new 172	android/content/Intent
    //   68: dup
    //   69: aload_3
    //   70: invokespecial 173	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   73: astore_3
    //   74: aload_3
    //   75: ldc -81
    //   77: invokevirtual 179	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: invokestatic 184	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   84: aload_0
    //   85: aload_3
    //   86: aload 4
    //   88: iconst_1
    //   89: invokevirtual 188	com/google/android/gms/common/stats/ConnectionTracker:bindService	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq +6 -> 100
    //   97: aload 4
    //   99: areturn
    //   100: new 71	java/io/IOException
    //   103: dup
    //   104: ldc -66
    //   106: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   109: athrow
    //   110: astore_0
    //   111: new 71	java/io/IOException
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   119: athrow
    //   120: astore_0
    //   121: new 75	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   124: dup
    //   125: bipush 9
    //   127: invokespecial 196	com/google/android/gms/common/GooglePlayServicesNotAvailableException:<init>	(I)V
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramContext	Context
    //   0	131	1	paramBoolean	boolean
    //   20	8	2	i	int
    //   49	37	3	localObject	Object
    //   63	35	4	localBlockingServiceConnection	BlockingServiceConnection
    // Exception table:
    //   from	to	target	type
    //   81	93	110	finally
    //   0	11	120	android/content/pm/PackageManager$NameNotFoundException
  }
  
  /* Error */
  @VisibleForTesting
  private static zze zza(Context paramContext, BlockingServiceConnection paramBlockingServiceConnection)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc2_w 200
    //   4: getstatic 207	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   7: invokevirtual 211	com/google/android/gms/common/BlockingServiceConnection:getServiceWithTimeout	(JLjava/util/concurrent/TimeUnit;)Landroid/os/IBinder;
    //   10: invokestatic 216	com/google/android/gms/internal/ads_identifier/zzf:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/ads_identifier/zze;
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: astore_0
    //   17: new 71	java/io/IOException
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   25: athrow
    //   26: astore_0
    //   27: new 71	java/io/IOException
    //   30: dup
    //   31: ldc -38
    //   33: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramContext	Context
    //   0	37	1	paramBlockingServiceConnection	BlockingServiceConnection
    // Exception table:
    //   from	to	target	type
    //   0	14	16	finally
    //   0	14	26	java/lang/InterruptedException
  }
  
  private final void zza()
  {
    zza localzza;
    synchronized (this.zzh)
    {
      localzza = this.zzi;
      if (localzza != null) {
        localzza.zzo.countDown();
      }
    }
    try
    {
      this.zzi.join();
      if (this.zzk > 0L)
      {
        localzza = new com/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        localzza.<init>(this, this.zzk);
        this.zzi = localzza;
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  @VisibleForTesting
  private final void zza(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzg) {
        finish();
      }
      BlockingServiceConnection localBlockingServiceConnection = zza(this.mContext, this.zzj);
      this.zze = localBlockingServiceConnection;
      this.zzf = zza(this.mContext, localBlockingServiceConnection);
      this.zzg = true;
      if (paramBoolean) {
        zza();
      }
      return;
    }
    finally {}
  }
  
  @VisibleForTesting
  private final boolean zza(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    String str1 = "1";
    String str2;
    if (paramBoolean) {
      str2 = "1";
    } else {
      str2 = "0";
    }
    localHashMap.put("app_context", str2);
    if (paramInfo != null)
    {
      if (paramInfo.isLimitAdTrackingEnabled()) {
        str2 = str1;
      } else {
        str2 = "0";
      }
      localHashMap.put("limit_ad_tracking", str2);
    }
    if ((paramInfo != null) && (paramInfo.getId() != null)) {
      localHashMap.put("ad_id_size", Integer.toString(paramInfo.getId().length()));
    }
    if (paramThrowable != null) {
      localHashMap.put("error", paramThrowable.getClass().getName());
    }
    if ((paramString != null) && (!paramString.isEmpty())) {
      localHashMap.put("experiment_id", paramString);
    }
    localHashMap.put("tag", "AdvertisingIdClient");
    localHashMap.put("time_spent", Long.toString(paramLong));
    new zza(this, localHashMap).start();
    return true;
  }
  
  /* Error */
  private final boolean zzb()
    throws IOException
  {
    // Byte code:
    //   0: ldc -17
    //   2: invokestatic 242	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 63	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   11: ifne +89 -> 100
    //   14: aload_0
    //   15: getfield 47	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzh	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 220	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +55 -> 82
    //   30: aload_2
    //   31: getfield 338	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzp	Z
    //   34: ifeq +48 -> 82
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_0
    //   40: iconst_0
    //   41: invokespecial 114	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Z)V
    //   44: aload_0
    //   45: getfield 63	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   48: ifeq +6 -> 54
    //   51: goto +49 -> 100
    //   54: new 71	java/io/IOException
    //   57: astore_1
    //   58: aload_1
    //   59: ldc_w 340
    //   62: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: new 71	java/io/IOException
    //   71: astore_2
    //   72: aload_2
    //   73: ldc_w 340
    //   76: aload_1
    //   77: invokespecial 343	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: athrow
    //   82: new 71	java/io/IOException
    //   85: astore_2
    //   86: aload_2
    //   87: ldc_w 345
    //   90: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: aload_1
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: aload_0
    //   101: getfield 246	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   104: invokestatic 53	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_0
    //   109: getfield 250	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   112: invokestatic 53	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: aload_0
    //   117: getfield 250	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   120: invokeinterface 350 1 0
    //   125: istore_3
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_0
    //   129: invokespecial 252	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	()V
    //   132: iload_3
    //   133: ireturn
    //   134: astore_1
    //   135: ldc_w 316
    //   138: ldc_w 352
    //   141: aload_1
    //   142: invokestatic 358	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   145: pop
    //   146: new 71	java/io/IOException
    //   149: astore_1
    //   150: aload_1
    //   151: ldc_w 360
    //   154: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	AdvertisingIdClient
    //   67	30	1	localException	Exception
    //   134	8	1	localRemoteException	android.os.RemoteException
    //   149	9	1	localIOException	IOException
    //   159	4	1	localObject2	Object
    //   25	69	2	localObject3	Object
    //   95	4	2	localObject4	Object
    //   125	8	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	44	67	java/lang/Exception
    //   21	26	95	finally
    //   30	39	95	finally
    //   82	95	95	finally
    //   96	98	95	finally
    //   116	126	134	android/os/RemoteException
    //   7	21	159	finally
    //   39	44	159	finally
    //   44	51	159	finally
    //   54	67	159	finally
    //   68	82	159	finally
    //   98	100	159	finally
    //   100	116	159	finally
    //   116	126	159	finally
    //   126	128	159	finally
    //   135	159	159	finally
    //   160	162	159	finally
  }
  
  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public final void finish()
  {
    // Byte code:
    //   0: ldc -17
    //   2: invokestatic 242	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 61	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +69 -> 80
    //   14: aload_0
    //   15: getfield 246	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +6 -> 26
    //   23: goto +57 -> 80
    //   26: aload_0
    //   27: getfield 63	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   30: ifeq +32 -> 62
    //   33: invokestatic 184	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   36: aload_0
    //   37: getfield 61	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   40: aload_0
    //   41: getfield 246	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   44: invokevirtual 369	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   47: goto +15 -> 62
    //   50: astore_1
    //   51: ldc_w 316
    //   54: ldc_w 371
    //   57: aload_1
    //   58: invokestatic 358	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   61: pop
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 63	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 250	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 246	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	AdvertisingIdClient
    //   18	2	1	localBlockingServiceConnection	BlockingServiceConnection
    //   50	8	1	localThrowable	Throwable
    //   83	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	47	50	finally
    //   7	19	83	finally
    //   51	62	83	finally
    //   62	79	83	finally
    //   80	82	83	finally
    //   84	86	83	finally
  }
  
  /* Error */
  @KeepForSdk
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc -17
    //   2: invokestatic 242	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 63	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   11: ifne +89 -> 100
    //   14: aload_0
    //   15: getfield 47	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzh	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 220	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +55 -> 82
    //   30: aload_2
    //   31: getfield 338	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzp	Z
    //   34: ifeq +48 -> 82
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_0
    //   40: iconst_0
    //   41: invokespecial 114	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Z)V
    //   44: aload_0
    //   45: getfield 63	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   48: ifeq +6 -> 54
    //   51: goto +49 -> 100
    //   54: new 71	java/io/IOException
    //   57: astore_1
    //   58: aload_1
    //   59: ldc_w 340
    //   62: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: new 71	java/io/IOException
    //   71: astore_2
    //   72: aload_2
    //   73: ldc_w 340
    //   76: aload_1
    //   77: invokespecial 343	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: athrow
    //   82: new 71	java/io/IOException
    //   85: astore_2
    //   86: aload_2
    //   87: ldc_w 345
    //   90: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: aload_1
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: aload_0
    //   101: getfield 246	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   104: invokestatic 53	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_0
    //   109: getfield 250	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   112: invokestatic 53	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: new 6	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   119: astore_1
    //   120: aload_1
    //   121: aload_0
    //   122: getfield 250	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   125: invokeinterface 372 1 0
    //   130: aload_0
    //   131: getfield 250	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   134: iconst_1
    //   135: invokeinterface 375 2 0
    //   140: invokespecial 378	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_0
    //   146: invokespecial 252	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	()V
    //   149: aload_1
    //   150: areturn
    //   151: astore_1
    //   152: ldc_w 316
    //   155: ldc_w 352
    //   158: aload_1
    //   159: invokestatic 358	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   162: pop
    //   163: new 71	java/io/IOException
    //   166: astore_1
    //   167: aload_1
    //   168: ldc_w 360
    //   171: invokespecial 165	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	AdvertisingIdClient
    //   67	30	1	localException	Exception
    //   119	31	1	localInfo	Info
    //   151	8	1	localRemoteException	android.os.RemoteException
    //   166	9	1	localIOException	IOException
    //   176	4	1	localObject2	Object
    //   25	69	2	localObject3	Object
    //   95	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   39	44	67	java/lang/Exception
    //   21	26	95	finally
    //   30	39	95	finally
    //   82	95	95	finally
    //   96	98	95	finally
    //   116	143	151	android/os/RemoteException
    //   7	21	176	finally
    //   39	44	176	finally
    //   44	51	176	finally
    //   54	67	176	finally
    //   68	82	176	finally
    //   98	100	176	finally
    //   100	116	176	finally
    //   116	143	176	finally
    //   143	145	176	finally
    //   152	176	176	finally
    //   177	179	176	finally
  }
  
  @KeepForSdk
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zza(true);
  }
  
  @KeepForSdkWithMembers
  public static final class Info
  {
    private final String zzq;
    private final boolean zzr;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.zzq = paramString;
      this.zzr = paramBoolean;
    }
    
    public final String getId()
    {
      return this.zzq;
    }
    
    public final boolean isLimitAdTrackingEnabled()
    {
      return this.zzr;
    }
    
    public final String toString()
    {
      String str = this.zzq;
      boolean bool = this.zzr;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
      localStringBuilder.append("{");
      localStringBuilder.append(str);
      localStringBuilder.append("}");
      localStringBuilder.append(bool);
      return localStringBuilder.toString();
    }
  }
  
  @VisibleForTesting
  static final class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzm;
    private long zzn;
    CountDownLatch zzo;
    boolean zzp;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzm = new WeakReference(paramAdvertisingIdClient);
      this.zzn = paramLong;
      this.zzo = new CountDownLatch(1);
      this.zzp = false;
      start();
    }
    
    private final void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzm.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzp = true;
      }
    }
    
    public final void run()
    {
      try
      {
        if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\ads\identifier\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */