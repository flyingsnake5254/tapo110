package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzy
{
  private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  private static final Uri zzcq = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern zzcr = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern zzcs = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean zzct = new AtomicBoolean();
  private static HashMap<String, String> zzcu;
  private static final HashMap<String, Boolean> zzcv = new HashMap();
  private static final HashMap<String, Integer> zzcw = new HashMap();
  private static final HashMap<String, Long> zzcx = new HashMap();
  private static final HashMap<String, Float> zzcy = new HashMap();
  private static Object zzcz;
  private static boolean zzda;
  private static String[] zzdb = new String[0];
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    Object localObject1 = zzb(paramContentResolver);
    Object localObject2 = zzcx;
    long l = 0L;
    localObject2 = (Long)zza((HashMap)localObject2, paramString, Long.valueOf(0L));
    if (localObject2 != null) {
      return ((Long)localObject2).longValue();
    }
    paramContentResolver = zza(paramContentResolver, paramString, null);
    if (paramContentResolver == null)
    {
      paramLong = l;
      paramContentResolver = (ContentResolver)localObject2;
    }
    try
    {
      paramLong = Long.parseLong(paramContentResolver);
      paramContentResolver = Long.valueOf(paramLong);
      zza(localObject1, zzcx, paramString, paramContentResolver);
      return paramLong;
    }
    catch (NumberFormatException paramContentResolver)
    {
      for (;;)
      {
        paramLong = l;
        paramContentResolver = (ContentResolver)localObject2;
      }
    }
  }
  
  private static <T> T zza(HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    try
    {
      if (paramHashMap.containsKey(paramString))
      {
        paramHashMap = paramHashMap.get(paramString);
        if (paramHashMap != null) {
          paramT = paramHashMap;
        }
        return paramT;
      }
      return null;
    }
    finally {}
  }
  
  /* Error */
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 128	com/google/android/gms/internal/clearcut/zzy:zza	(Landroid/content/ContentResolver;)V
    //   7: getstatic 130	com/google/android/gms/internal/clearcut/zzy:zzcz	Ljava/lang/Object;
    //   10: astore_3
    //   11: getstatic 132	com/google/android/gms/internal/clearcut/zzy:zzcu	Ljava/util/HashMap;
    //   14: aload_1
    //   15: invokevirtual 119	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: istore 4
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore_2
    //   25: aconst_null
    //   26: astore 6
    //   28: iload 4
    //   30: ifeq +28 -> 58
    //   33: getstatic 132	com/google/android/gms/internal/clearcut/zzy:zzcu	Ljava/util/HashMap;
    //   36: aload_1
    //   37: invokevirtual 123	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 79	java/lang/String
    //   43: astore_1
    //   44: aload 6
    //   46: astore_0
    //   47: aload_1
    //   48: ifnull +5 -> 53
    //   51: aload_1
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: getstatic 81	com/google/android/gms/internal/clearcut/zzy:zzdb	[Ljava/lang/String;
    //   61: astore 6
    //   63: aload 6
    //   65: arraylength
    //   66: istore 7
    //   68: iconst_0
    //   69: istore 8
    //   71: iload 8
    //   73: iload 7
    //   75: if_icmpge +95 -> 170
    //   78: aload_1
    //   79: aload 6
    //   81: iload 8
    //   83: aaload
    //   84: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   87: ifeq +77 -> 164
    //   90: getstatic 138	com/google/android/gms/internal/clearcut/zzy:zzda	Z
    //   93: ifeq +12 -> 105
    //   96: getstatic 132	com/google/android/gms/internal/clearcut/zzy:zzcu	Ljava/util/HashMap;
    //   99: invokevirtual 142	java/util/HashMap:isEmpty	()Z
    //   102: ifeq +57 -> 159
    //   105: getstatic 81	com/google/android/gms/internal/clearcut/zzy:zzdb	[Ljava/lang/String;
    //   108: astore_2
    //   109: getstatic 132	com/google/android/gms/internal/clearcut/zzy:zzcu	Ljava/util/HashMap;
    //   112: aload_0
    //   113: aload_2
    //   114: invokestatic 145	com/google/android/gms/internal/clearcut/zzy:zza	(Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   117: invokevirtual 149	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   120: iconst_1
    //   121: putstatic 138	com/google/android/gms/internal/clearcut/zzy:zzda	Z
    //   124: getstatic 132	com/google/android/gms/internal/clearcut/zzy:zzcu	Ljava/util/HashMap;
    //   127: aload_1
    //   128: invokevirtual 119	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   131: ifeq +28 -> 159
    //   134: getstatic 132	com/google/android/gms/internal/clearcut/zzy:zzcu	Ljava/util/HashMap;
    //   137: aload_1
    //   138: invokevirtual 123	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: checkcast 79	java/lang/String
    //   144: astore_1
    //   145: aload 5
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull +5 -> 154
    //   152: aload_1
    //   153: astore_0
    //   154: ldc 2
    //   156: monitorexit
    //   157: aload_0
    //   158: areturn
    //   159: ldc 2
    //   161: monitorexit
    //   162: aconst_null
    //   163: areturn
    //   164: iinc 8 1
    //   167: goto -96 -> 71
    //   170: ldc 2
    //   172: monitorexit
    //   173: aload_0
    //   174: getstatic 41	com/google/android/gms/internal/clearcut/zzy:CONTENT_URI	Landroid/net/Uri;
    //   177: aconst_null
    //   178: aconst_null
    //   179: iconst_1
    //   180: anewarray 79	java/lang/String
    //   183: dup
    //   184: iconst_0
    //   185: aload_1
    //   186: aastore
    //   187: aconst_null
    //   188: invokevirtual 155	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   191: astore 6
    //   193: aload 6
    //   195: ifnull +71 -> 266
    //   198: aload 6
    //   200: invokeinterface 160 1 0
    //   205: ifne +6 -> 211
    //   208: goto +58 -> 266
    //   211: aload 6
    //   213: iconst_1
    //   214: invokeinterface 164 2 0
    //   219: astore 5
    //   221: aload 5
    //   223: astore_0
    //   224: aload 5
    //   226: ifnull +17 -> 243
    //   229: aload 5
    //   231: astore_0
    //   232: aload 5
    //   234: aconst_null
    //   235: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +5 -> 243
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_3
    //   244: aload_1
    //   245: aload_0
    //   246: invokestatic 170	com/google/android/gms/internal/clearcut/zzy:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: astore_1
    //   251: aload_0
    //   252: ifnull +5 -> 257
    //   255: aload_0
    //   256: astore_1
    //   257: aload 6
    //   259: invokeinterface 173 1 0
    //   264: aload_1
    //   265: areturn
    //   266: aload_3
    //   267: aload_1
    //   268: aconst_null
    //   269: invokestatic 170	com/google/android/gms/internal/clearcut/zzy:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 6
    //   274: ifnull +10 -> 284
    //   277: aload 6
    //   279: invokeinterface 173 1 0
    //   284: aconst_null
    //   285: areturn
    //   286: astore_0
    //   287: aload 6
    //   289: ifnull +10 -> 299
    //   292: aload 6
    //   294: invokeinterface 173 1 0
    //   299: aload_0
    //   300: athrow
    //   301: astore_0
    //   302: ldc 2
    //   304: monitorexit
    //   305: aload_0
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramContentResolver	ContentResolver
    //   0	307	1	paramString1	String
    //   0	307	2	paramString2	String
    //   10	257	3	localObject1	Object
    //   18	11	4	bool	boolean
    //   21	212	5	str	String
    //   26	267	6	localObject2	Object
    //   66	10	7	i	int
    //   69	96	8	j	int
    // Exception table:
    //   from	to	target	type
    //   198	208	286	finally
    //   211	221	286	finally
    //   232	241	286	finally
    //   243	249	286	finally
    //   266	272	286	finally
    //   3	20	301	finally
    //   33	44	301	finally
    //   53	56	301	finally
    //   58	68	301	finally
    //   78	105	301	finally
    //   105	145	301	finally
    //   154	157	301	finally
    //   159	162	301	finally
    //   170	173	301	finally
    //   302	305	301	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(zzcq, null, null, paramVarArgs, null);
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
  
  private static void zza(ContentResolver paramContentResolver)
  {
    if (zzcu == null)
    {
      zzct.set(false);
      zzcu = new HashMap();
      zzcz = new Object();
      zzda = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzz(null));
      return;
    }
    if (zzct.getAndSet(false))
    {
      zzcu.clear();
      zzcv.clear();
      zzcw.clear();
      zzcx.clear();
      zzcy.clear();
      zzcz = new Object();
      zzda = false;
    }
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzcz) {
        zzcu.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  private static <T> void zza(Object paramObject, HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    try
    {
      if (paramObject == zzcz)
      {
        paramHashMap.put(paramString, paramT);
        zzcu.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    Object localObject = zzb(paramContentResolver);
    HashMap localHashMap = zzcv;
    Boolean localBoolean = (Boolean)zza(localHashMap, paramString, Boolean.valueOf(paramBoolean));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    String str = zza(paramContentResolver, paramString, null);
    paramContentResolver = localBoolean;
    boolean bool = paramBoolean;
    if (str != null) {
      if (str.equals(""))
      {
        paramContentResolver = localBoolean;
        bool = paramBoolean;
      }
      else if (zzcr.matcher(str).matches())
      {
        bool = true;
        paramContentResolver = Boolean.TRUE;
      }
      else if (zzcs.matcher(str).matches())
      {
        bool = false;
        paramContentResolver = Boolean.FALSE;
      }
      else
      {
        paramContentResolver = new StringBuilder("attempt to read gservices key ");
        paramContentResolver.append(paramString);
        paramContentResolver.append(" (value \"");
        paramContentResolver.append(str);
        paramContentResolver.append("\") as boolean");
        Log.w("Gservices", paramContentResolver.toString());
        bool = paramBoolean;
        paramContentResolver = localBoolean;
      }
    }
    zza(localObject, localHashMap, paramString, paramContentResolver);
    return bool;
  }
  
  private static Object zzb(ContentResolver paramContentResolver)
  {
    try
    {
      zza(paramContentResolver);
      paramContentResolver = zzcz;
      return paramContentResolver;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */