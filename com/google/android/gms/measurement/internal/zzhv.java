package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.google.android.gms.common.util.Clock;

@TargetApi(14)
@MainThread
final class zzhv
  implements Application.ActivityLifecycleCallbacks
{
  /* Error */
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   4: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   7: invokevirtual 36	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   10: invokevirtual 42	com/google/android/gms/measurement/internal/zzem:zzk	()Lcom/google/android/gms/measurement/internal/zzek;
    //   13: ldc 43
    //   15: invokevirtual 48	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: invokevirtual 54	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +21 -> 45
    //   27: aload_0
    //   28: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   31: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   34: astore_3
    //   35: aload_3
    //   36: invokevirtual 58	com/google/android/gms/measurement/internal/zzfu:zzx	()Lcom/google/android/gms/measurement/internal/zzik;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 63	com/google/android/gms/measurement/internal/zzik:zzo	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   44: return
    //   45: aload_3
    //   46: invokevirtual 69	android/content/Intent:getData	()Landroid/net/Uri;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +164 -> 217
    //   56: aload 4
    //   58: invokevirtual 75	android/net/Uri:isHierarchical	()Z
    //   61: ifne +6 -> 67
    //   64: goto +153 -> 217
    //   67: aload_0
    //   68: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   71: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   74: invokevirtual 79	com/google/android/gms/measurement/internal/zzfu:zzl	()Lcom/google/android/gms/measurement/internal/zzku;
    //   77: pop
    //   78: aload_3
    //   79: ldc 81
    //   81: invokevirtual 85	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: ldc 87
    //   87: aload_3
    //   88: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: istore 5
    //   93: iconst_1
    //   94: istore 6
    //   96: iload 5
    //   98: ifne +34 -> 132
    //   101: ldc 95
    //   103: aload_3
    //   104: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +25 -> 132
    //   110: ldc 97
    //   112: aload_3
    //   113: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: istore 5
    //   118: iload 5
    //   120: ifeq +6 -> 126
    //   123: goto +9 -> 132
    //   126: iconst_0
    //   127: istore 7
    //   129: goto +6 -> 135
    //   132: iconst_1
    //   133: istore 7
    //   135: iconst_1
    //   136: iload 7
    //   138: if_icmpeq +9 -> 147
    //   141: ldc 99
    //   143: astore_3
    //   144: goto +6 -> 150
    //   147: ldc 101
    //   149: astore_3
    //   150: aload 4
    //   152: ldc 103
    //   154: invokevirtual 106	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 8
    //   159: aload_2
    //   160: ifnonnull +6 -> 166
    //   163: goto +6 -> 169
    //   166: iconst_0
    //   167: istore 6
    //   169: aload_0
    //   170: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   173: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   176: invokevirtual 110	com/google/android/gms/measurement/internal/zzfu:zzav	()Lcom/google/android/gms/measurement/internal/zzfr;
    //   179: astore 9
    //   181: new 112	com/google/android/gms/measurement/internal/zzhu
    //   184: astore 10
    //   186: aload 10
    //   188: aload_0
    //   189: iload 6
    //   191: aload 4
    //   193: aload_3
    //   194: aload 8
    //   196: invokespecial 115	com/google/android/gms/measurement/internal/zzhu:<init>	(Lcom/google/android/gms/measurement/internal/zzhv;ZLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 9
    //   201: aload 10
    //   203: invokevirtual 121	com/google/android/gms/measurement/internal/zzfr:zzh	(Ljava/lang/Runnable;)V
    //   206: aload_0
    //   207: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   210: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   213: astore_3
    //   214: goto -179 -> 35
    //   217: aload_0
    //   218: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   221: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   224: astore_3
    //   225: goto -190 -> 35
    //   228: astore_3
    //   229: goto +34 -> 263
    //   232: astore_3
    //   233: aload_0
    //   234: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   237: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   240: invokevirtual 36	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   243: invokevirtual 124	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   246: ldc 126
    //   248: aload_3
    //   249: invokevirtual 129	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   252: aload_0
    //   253: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   256: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   259: astore_3
    //   260: goto -225 -> 35
    //   263: aload_0
    //   264: getfield 16	com/google/android/gms/measurement/internal/zzhv:zza	Lcom/google/android/gms/measurement/internal/zzhw;
    //   267: getfield 30	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   270: invokevirtual 58	com/google/android/gms/measurement/internal/zzfu:zzx	()Lcom/google/android/gms/measurement/internal/zzik;
    //   273: aload_1
    //   274: aload_2
    //   275: invokevirtual 63	com/google/android/gms/measurement/internal/zzik:zzo	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   278: aload_3
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	zzhv
    //   0	280	1	paramActivity	Activity
    //   0	280	2	paramBundle	Bundle
    //   22	203	3	localObject1	Object
    //   228	1	3	localObject2	Object
    //   232	17	3	localRuntimeException	RuntimeException
    //   259	20	3	localzzfu	zzfu
    //   49	143	4	localUri	android.net.Uri
    //   91	28	5	bool1	boolean
    //   94	96	6	bool2	boolean
    //   127	12	7	i	int
    //   157	38	8	str	String
    //   179	21	9	localzzfr	zzfr
    //   184	18	10	localzzhu	zzhu
    // Exception table:
    //   from	to	target	type
    //   0	23	228	finally
    //   45	51	228	finally
    //   56	64	228	finally
    //   67	93	228	finally
    //   101	118	228	finally
    //   150	159	228	finally
    //   169	206	228	finally
    //   233	252	228	finally
    //   0	23	232	java/lang/RuntimeException
    //   45	51	232	java/lang/RuntimeException
    //   56	64	232	java/lang/RuntimeException
    //   67	93	232	java/lang/RuntimeException
    //   101	118	232	java/lang/RuntimeException
    //   150	159	232	java/lang/RuntimeException
    //   169	206	232	java/lang/RuntimeException
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.zza.zzs.zzx().zzt(paramActivity);
  }
  
  @MainThread
  public final void onActivityPaused(Activity paramActivity)
  {
    this.zza.zzs.zzx().zzr(paramActivity);
    paramActivity = this.zza.zzs.zzh();
    long l = paramActivity.zzs.zzay().elapsedRealtime();
    paramActivity.zzs.zzav().zzh(new zzjs(paramActivity, l));
  }
  
  @MainThread
  public final void onActivityResumed(Activity paramActivity)
  {
    zzjz localzzjz = this.zza.zzs.zzh();
    long l = localzzjz.zzs.zzay().elapsedRealtime();
    localzzjz.zzs.zzav().zzh(new zzjr(localzzjz, l));
    this.zza.zzs.zzx().zzq(paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.zza.zzs.zzx().zzs(paramActivity, paramBundle);
  }
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */