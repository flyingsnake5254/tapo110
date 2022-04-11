package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzaq
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  private static final Uri zzfb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern zzfc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern zzfd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean zzfe = new AtomicBoolean();
  private static HashMap<String, String> zzff;
  private static final HashMap<String, Boolean> zzfg = new HashMap();
  private static final HashMap<String, Integer> zzfh = new HashMap();
  private static final HashMap<String, Long> zzfi = new HashMap();
  private static final HashMap<String, Float> zzfj = new HashMap();
  private static Object zzfk;
  private static boolean zzfl;
  private static String[] zzfm = new String[0];
  
  /* Error */
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_2
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_3
    //   16: ifnonnull +63 -> 79
    //   19: getstatic 66	com/google/android/gms/internal/vision/zzaq:zzfe	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: iconst_0
    //   23: invokevirtual 91	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   26: new 68	java/util/HashMap
    //   29: astore_3
    //   30: aload_3
    //   31: invokespecial 69	java/util/HashMap:<init>	()V
    //   34: aload_3
    //   35: putstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   38: new 4	java/lang/Object
    //   41: astore_3
    //   42: aload_3
    //   43: invokespecial 83	java/lang/Object:<init>	()V
    //   46: aload_3
    //   47: putstatic 93	com/google/android/gms/internal/vision/zzaq:zzfk	Ljava/lang/Object;
    //   50: iconst_0
    //   51: putstatic 95	com/google/android/gms/internal/vision/zzaq:zzfl	Z
    //   54: getstatic 41	com/google/android/gms/internal/vision/zzaq:CONTENT_URI	Landroid/net/Uri;
    //   57: astore 6
    //   59: new 97	com/google/android/gms/internal/vision/zzat
    //   62: astore_3
    //   63: aload_3
    //   64: aconst_null
    //   65: invokespecial 100	com/google/android/gms/internal/vision/zzat:<init>	(Landroid/os/Handler;)V
    //   68: aload_0
    //   69: aload 6
    //   71: iconst_1
    //   72: aload_3
    //   73: invokevirtual 106	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   76: goto +59 -> 135
    //   79: getstatic 66	com/google/android/gms/internal/vision/zzaq:zzfe	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   82: iconst_0
    //   83: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   86: ifeq +49 -> 135
    //   89: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   92: invokevirtual 113	java/util/HashMap:clear	()V
    //   95: getstatic 71	com/google/android/gms/internal/vision/zzaq:zzfg	Ljava/util/HashMap;
    //   98: invokevirtual 113	java/util/HashMap:clear	()V
    //   101: getstatic 73	com/google/android/gms/internal/vision/zzaq:zzfh	Ljava/util/HashMap;
    //   104: invokevirtual 113	java/util/HashMap:clear	()V
    //   107: getstatic 75	com/google/android/gms/internal/vision/zzaq:zzfi	Ljava/util/HashMap;
    //   110: invokevirtual 113	java/util/HashMap:clear	()V
    //   113: getstatic 77	com/google/android/gms/internal/vision/zzaq:zzfj	Ljava/util/HashMap;
    //   116: invokevirtual 113	java/util/HashMap:clear	()V
    //   119: new 4	java/lang/Object
    //   122: astore_3
    //   123: aload_3
    //   124: invokespecial 83	java/lang/Object:<init>	()V
    //   127: aload_3
    //   128: putstatic 93	com/google/android/gms/internal/vision/zzaq:zzfk	Ljava/lang/Object;
    //   131: iconst_0
    //   132: putstatic 95	com/google/android/gms/internal/vision/zzaq:zzfl	Z
    //   135: getstatic 93	com/google/android/gms/internal/vision/zzaq:zzfk	Ljava/lang/Object;
    //   138: astore_3
    //   139: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   142: aload_1
    //   143: invokevirtual 117	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   146: ifeq +28 -> 174
    //   149: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   152: aload_1
    //   153: invokevirtual 121	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 79	java/lang/String
    //   159: astore_1
    //   160: aload 5
    //   162: astore_0
    //   163: aload_1
    //   164: ifnull +5 -> 169
    //   167: aload_1
    //   168: astore_0
    //   169: ldc 2
    //   171: monitorexit
    //   172: aload_0
    //   173: areturn
    //   174: getstatic 81	com/google/android/gms/internal/vision/zzaq:zzfm	[Ljava/lang/String;
    //   177: astore 5
    //   179: aload 5
    //   181: arraylength
    //   182: istore 7
    //   184: iconst_0
    //   185: istore 8
    //   187: iload 8
    //   189: iload 7
    //   191: if_icmpge +95 -> 286
    //   194: aload_1
    //   195: aload 5
    //   197: iload 8
    //   199: aaload
    //   200: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   203: ifeq +77 -> 280
    //   206: getstatic 95	com/google/android/gms/internal/vision/zzaq:zzfl	Z
    //   209: ifeq +12 -> 221
    //   212: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   215: invokevirtual 129	java/util/HashMap:isEmpty	()Z
    //   218: ifeq +57 -> 275
    //   221: getstatic 81	com/google/android/gms/internal/vision/zzaq:zzfm	[Ljava/lang/String;
    //   224: astore_2
    //   225: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   228: aload_0
    //   229: aload_2
    //   230: invokestatic 132	com/google/android/gms/internal/vision/zzaq:zza	(Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   233: invokevirtual 136	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   236: iconst_1
    //   237: putstatic 95	com/google/android/gms/internal/vision/zzaq:zzfl	Z
    //   240: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   243: aload_1
    //   244: invokevirtual 117	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   247: ifeq +28 -> 275
    //   250: getstatic 87	com/google/android/gms/internal/vision/zzaq:zzff	Ljava/util/HashMap;
    //   253: aload_1
    //   254: invokevirtual 121	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 79	java/lang/String
    //   260: astore_1
    //   261: aload 4
    //   263: astore_0
    //   264: aload_1
    //   265: ifnull +5 -> 270
    //   268: aload_1
    //   269: astore_0
    //   270: ldc 2
    //   272: monitorexit
    //   273: aload_0
    //   274: areturn
    //   275: ldc 2
    //   277: monitorexit
    //   278: aconst_null
    //   279: areturn
    //   280: iinc 8 1
    //   283: goto -96 -> 187
    //   286: ldc 2
    //   288: monitorexit
    //   289: aload_0
    //   290: getstatic 41	com/google/android/gms/internal/vision/zzaq:CONTENT_URI	Landroid/net/Uri;
    //   293: aconst_null
    //   294: aconst_null
    //   295: iconst_1
    //   296: anewarray 79	java/lang/String
    //   299: dup
    //   300: iconst_0
    //   301: aload_1
    //   302: aastore
    //   303: aconst_null
    //   304: invokevirtual 140	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   307: astore 5
    //   309: aload 5
    //   311: ifnonnull +17 -> 328
    //   314: aload 5
    //   316: ifnull +10 -> 326
    //   319: aload 5
    //   321: invokeinterface 145 1 0
    //   326: aconst_null
    //   327: areturn
    //   328: aload 5
    //   330: invokeinterface 148 1 0
    //   335: ifne +18 -> 353
    //   338: aload_3
    //   339: aload_1
    //   340: aconst_null
    //   341: invokestatic 151	com/google/android/gms/internal/vision/zzaq:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload 5
    //   346: invokeinterface 145 1 0
    //   351: aconst_null
    //   352: areturn
    //   353: aload 5
    //   355: iconst_1
    //   356: invokeinterface 155 2 0
    //   361: astore 4
    //   363: aload 4
    //   365: astore_0
    //   366: aload 4
    //   368: ifnull +17 -> 385
    //   371: aload 4
    //   373: astore_0
    //   374: aload 4
    //   376: aconst_null
    //   377: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   380: ifeq +5 -> 385
    //   383: aconst_null
    //   384: astore_0
    //   385: aload_3
    //   386: aload_1
    //   387: aload_0
    //   388: invokestatic 151	com/google/android/gms/internal/vision/zzaq:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_2
    //   392: astore_1
    //   393: aload_0
    //   394: ifnull +5 -> 399
    //   397: aload_0
    //   398: astore_1
    //   399: aload 5
    //   401: invokeinterface 145 1 0
    //   406: aload_1
    //   407: areturn
    //   408: astore_0
    //   409: aload 5
    //   411: invokeinterface 145 1 0
    //   416: aload_0
    //   417: athrow
    //   418: astore_0
    //   419: ldc 2
    //   421: monitorexit
    //   422: aload_0
    //   423: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	paramContentResolver	ContentResolver
    //   0	424	1	paramString1	String
    //   0	424	2	paramString2	String
    //   6	380	3	localObject1	Object
    //   8	367	4	str	String
    //   13	397	5	localObject2	Object
    //   57	13	6	localUri	Uri
    //   182	10	7	i	int
    //   185	96	8	j	int
    // Exception table:
    //   from	to	target	type
    //   328	344	408	finally
    //   353	363	408	finally
    //   374	383	408	finally
    //   385	391	408	finally
    //   3	7	418	finally
    //   19	76	418	finally
    //   79	135	418	finally
    //   135	160	418	finally
    //   169	172	418	finally
    //   174	184	418	finally
    //   194	221	418	finally
    //   221	261	418	finally
    //   270	273	418	finally
    //   275	278	418	finally
    //   286	289	418	finally
    //   419	422	418	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(zzfb, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      while (paramContentResolver.moveToNext()) {
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzfk) {
        zzff.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */