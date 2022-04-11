package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class zzgv
{
  public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  static HashMap<String, String> zze;
  static final HashMap<String, Boolean> zzf = new HashMap();
  static final HashMap<String, Integer> zzg = new HashMap();
  static final HashMap<String, Long> zzh = new HashMap();
  static final HashMap<String, Float> zzi = new HashMap();
  static final String[] zzj = new String[0];
  private static final AtomicBoolean zzk = new AtomicBoolean();
  private static Object zzl;
  private static boolean zzm;
  
  /* Error */
  public static String zza(android.content.ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 86	com/google/android/gms/internal/measurement/zzgv:zze	Ljava/util/HashMap;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_3
    //   13: ifnonnull +63 -> 76
    //   16: getstatic 66	com/google/android/gms/internal/measurement/zzgv:zzk	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   19: iconst_0
    //   20: invokevirtual 90	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   23: new 68	java/util/HashMap
    //   26: astore_3
    //   27: aload_3
    //   28: invokespecial 69	java/util/HashMap:<init>	()V
    //   31: aload_3
    //   32: putstatic 86	com/google/android/gms/internal/measurement/zzgv:zze	Ljava/util/HashMap;
    //   35: new 4	java/lang/Object
    //   38: astore_3
    //   39: aload_3
    //   40: invokespecial 83	java/lang/Object:<init>	()V
    //   43: aload_3
    //   44: putstatic 92	com/google/android/gms/internal/measurement/zzgv:zzl	Ljava/lang/Object;
    //   47: iconst_0
    //   48: putstatic 94	com/google/android/gms/internal/measurement/zzgv:zzm	Z
    //   51: getstatic 41	com/google/android/gms/internal/measurement/zzgv:zza	Landroid/net/Uri;
    //   54: astore 5
    //   56: new 96	com/google/android/gms/internal/measurement/zzgu
    //   59: astore_3
    //   60: aload_3
    //   61: aconst_null
    //   62: invokespecial 99	com/google/android/gms/internal/measurement/zzgu:<init>	(Landroid/os/Handler;)V
    //   65: aload_0
    //   66: aload 5
    //   68: iconst_1
    //   69: aload_3
    //   70: invokevirtual 105	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   73: goto +59 -> 132
    //   76: getstatic 66	com/google/android/gms/internal/measurement/zzgv:zzk	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   79: iconst_0
    //   80: invokevirtual 109	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   83: ifeq +49 -> 132
    //   86: getstatic 86	com/google/android/gms/internal/measurement/zzgv:zze	Ljava/util/HashMap;
    //   89: invokevirtual 112	java/util/HashMap:clear	()V
    //   92: getstatic 71	com/google/android/gms/internal/measurement/zzgv:zzf	Ljava/util/HashMap;
    //   95: invokevirtual 112	java/util/HashMap:clear	()V
    //   98: getstatic 73	com/google/android/gms/internal/measurement/zzgv:zzg	Ljava/util/HashMap;
    //   101: invokevirtual 112	java/util/HashMap:clear	()V
    //   104: getstatic 75	com/google/android/gms/internal/measurement/zzgv:zzh	Ljava/util/HashMap;
    //   107: invokevirtual 112	java/util/HashMap:clear	()V
    //   110: getstatic 77	com/google/android/gms/internal/measurement/zzgv:zzi	Ljava/util/HashMap;
    //   113: invokevirtual 112	java/util/HashMap:clear	()V
    //   116: new 4	java/lang/Object
    //   119: astore_3
    //   120: aload_3
    //   121: invokespecial 83	java/lang/Object:<init>	()V
    //   124: aload_3
    //   125: putstatic 92	com/google/android/gms/internal/measurement/zzgv:zzl	Ljava/lang/Object;
    //   128: iconst_0
    //   129: putstatic 94	com/google/android/gms/internal/measurement/zzgv:zzm	Z
    //   132: getstatic 92	com/google/android/gms/internal/measurement/zzgv:zzl	Ljava/lang/Object;
    //   135: astore 5
    //   137: getstatic 86	com/google/android/gms/internal/measurement/zzgv:zze	Ljava/util/HashMap;
    //   140: aload_1
    //   141: invokevirtual 116	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   144: ifeq +29 -> 173
    //   147: getstatic 86	com/google/android/gms/internal/measurement/zzgv:zze	Ljava/util/HashMap;
    //   150: aload_1
    //   151: invokevirtual 120	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: checkcast 79	java/lang/String
    //   157: astore_0
    //   158: aload_0
    //   159: ifnonnull +9 -> 168
    //   162: aload 4
    //   164: astore_0
    //   165: goto +3 -> 168
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_0
    //   172: areturn
    //   173: getstatic 81	com/google/android/gms/internal/measurement/zzgv:zzj	[Ljava/lang/String;
    //   176: arraylength
    //   177: istore 6
    //   179: ldc 2
    //   181: monitorexit
    //   182: aload_0
    //   183: getstatic 41	com/google/android/gms/internal/measurement/zzgv:zza	Landroid/net/Uri;
    //   186: aconst_null
    //   187: aconst_null
    //   188: iconst_1
    //   189: anewarray 79	java/lang/String
    //   192: dup
    //   193: iconst_0
    //   194: aload_1
    //   195: aastore
    //   196: aconst_null
    //   197: invokevirtual 124	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   200: astore_3
    //   201: aload_3
    //   202: ifnonnull +5 -> 207
    //   205: aconst_null
    //   206: areturn
    //   207: aload_3
    //   208: invokeinterface 130 1 0
    //   213: ifne +18 -> 231
    //   216: aload 5
    //   218: aload_1
    //   219: aconst_null
    //   220: invokestatic 133	com/google/android/gms/internal/measurement/zzgv:zzc	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_3
    //   224: invokeinterface 136 1 0
    //   229: aconst_null
    //   230: areturn
    //   231: aload_3
    //   232: iconst_1
    //   233: invokeinterface 140 2 0
    //   238: astore 4
    //   240: aload 4
    //   242: astore_0
    //   243: aload 4
    //   245: ifnull +17 -> 262
    //   248: aload 4
    //   250: astore_0
    //   251: aload 4
    //   253: aconst_null
    //   254: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifeq +5 -> 262
    //   260: aconst_null
    //   261: astore_0
    //   262: aload 5
    //   264: aload_1
    //   265: aload_0
    //   266: invokestatic 133	com/google/android/gms/internal/measurement/zzgv:zzc	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_0
    //   270: ifnonnull +8 -> 278
    //   273: aload_2
    //   274: astore_0
    //   275: goto +3 -> 278
    //   278: aload_3
    //   279: invokeinterface 136 1 0
    //   284: aload_0
    //   285: areturn
    //   286: astore_0
    //   287: aload_3
    //   288: invokeinterface 136 1 0
    //   293: aload_0
    //   294: athrow
    //   295: astore_0
    //   296: ldc 2
    //   298: monitorexit
    //   299: aload_0
    //   300: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContentResolver	android.content.ContentResolver
    //   0	301	1	paramString1	String
    //   0	301	2	paramString2	String
    //   6	282	3	localObject1	Object
    //   10	242	4	str	String
    //   54	209	5	localObject2	Object
    //   177	1	6	i	int
    // Exception table:
    //   from	to	target	type
    //   207	223	286	finally
    //   231	240	286	finally
    //   251	260	286	finally
    //   262	269	286	finally
    //   3	7	295	finally
    //   16	73	295	finally
    //   76	132	295	finally
    //   132	158	295	finally
    //   168	171	295	finally
    //   173	182	295	finally
    //   296	299	295	finally
  }
  
  private static void zzc(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzl) {
        zze.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */