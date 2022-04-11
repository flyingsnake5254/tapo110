package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

public final class zzaj
{
  /* Error */
  @androidx.annotation.WorkerThread
  static void zza(zzem paramzzem, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
    throws android.database.sqlite.SQLiteException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +434 -> 435
    //   4: iconst_0
    //   5: istore 6
    //   7: aconst_null
    //   8: astore 7
    //   10: aload_1
    //   11: ldc 11
    //   13: iconst_1
    //   14: anewarray 13	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 15
    //   21: aastore
    //   22: ldc 17
    //   24: iconst_1
    //   25: anewarray 13	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_2
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 23	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 8
    //   40: aload 8
    //   42: astore 7
    //   44: aload 8
    //   46: invokeinterface 29 1 0
    //   51: istore 9
    //   53: aload 8
    //   55: invokeinterface 33 1 0
    //   60: iload 9
    //   62: ifne +56 -> 118
    //   65: goto +48 -> 113
    //   68: astore 10
    //   70: goto +15 -> 85
    //   73: astore_0
    //   74: aload 7
    //   76: astore_1
    //   77: goto +346 -> 423
    //   80: astore 10
    //   82: aconst_null
    //   83: astore 8
    //   85: aload 8
    //   87: astore 7
    //   89: aload_0
    //   90: invokevirtual 39	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   93: ldc 41
    //   95: aload_2
    //   96: aload 10
    //   98: invokevirtual 47	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   101: aload 8
    //   103: ifnull +10 -> 113
    //   106: aload 8
    //   108: invokeinterface 33 1 0
    //   113: aload_1
    //   114: aload_3
    //   115: invokevirtual 51	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   118: new 53	java/util/HashSet
    //   121: astore_3
    //   122: aload_3
    //   123: invokespecial 56	java/util/HashSet:<init>	()V
    //   126: aload_2
    //   127: invokevirtual 60	java/lang/String:length	()I
    //   130: istore 11
    //   132: new 62	java/lang/StringBuilder
    //   135: astore 7
    //   137: aload 7
    //   139: iload 11
    //   141: bipush 22
    //   143: iadd
    //   144: invokespecial 65	java/lang/StringBuilder:<init>	(I)V
    //   147: aload 7
    //   149: ldc 67
    //   151: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 7
    //   157: aload_2
    //   158: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 7
    //   164: ldc 73
    //   166: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload 7
    //   173: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aconst_null
    //   177: invokevirtual 81	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   180: astore 7
    //   182: aload_3
    //   183: aload 7
    //   185: invokeinterface 85 1 0
    //   190: invokestatic 91	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   193: pop
    //   194: aload 7
    //   196: invokeinterface 33 1 0
    //   201: aload 4
    //   203: ldc 93
    //   205: invokevirtual 97	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   208: astore 7
    //   210: aload 7
    //   212: arraylength
    //   213: istore 12
    //   215: iconst_0
    //   216: istore 11
    //   218: iload 11
    //   220: iload 12
    //   222: if_icmpge +100 -> 322
    //   225: aload 7
    //   227: iload 11
    //   229: aaload
    //   230: astore 4
    //   232: aload_3
    //   233: aload 4
    //   235: invokeinterface 103 2 0
    //   240: ifeq +9 -> 249
    //   243: iinc 11 1
    //   246: goto -28 -> 218
    //   249: new 8	android/database/sqlite/SQLiteException
    //   252: astore_3
    //   253: aload_2
    //   254: invokevirtual 60	java/lang/String:length	()I
    //   257: istore 6
    //   259: aload 4
    //   261: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   264: invokevirtual 60	java/lang/String:length	()I
    //   267: istore 11
    //   269: new 62	java/lang/StringBuilder
    //   272: astore_1
    //   273: aload_1
    //   274: iload 6
    //   276: bipush 35
    //   278: iadd
    //   279: iload 11
    //   281: iadd
    //   282: invokespecial 65	java/lang/StringBuilder:<init>	(I)V
    //   285: aload_1
    //   286: ldc 109
    //   288: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_1
    //   293: aload_2
    //   294: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: ldc 111
    //   301: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: aload 4
    //   308: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_3
    //   313: aload_1
    //   314: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokespecial 113	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   320: aload_3
    //   321: athrow
    //   322: aload 5
    //   324: ifnull +46 -> 370
    //   327: iload 6
    //   329: istore 11
    //   331: iload 11
    //   333: aload 5
    //   335: arraylength
    //   336: if_icmpge +34 -> 370
    //   339: aload_3
    //   340: aload 5
    //   342: iload 11
    //   344: aaload
    //   345: invokeinterface 103 2 0
    //   350: ifne +14 -> 364
    //   353: aload_1
    //   354: aload 5
    //   356: iload 11
    //   358: iconst_1
    //   359: iadd
    //   360: aaload
    //   361: invokevirtual 51	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   364: iinc 11 2
    //   367: goto -36 -> 331
    //   370: aload_3
    //   371: invokeinterface 116 1 0
    //   376: ifne +19 -> 395
    //   379: aload_0
    //   380: invokevirtual 39	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   383: ldc 118
    //   385: aload_2
    //   386: ldc 120
    //   388: aload_3
    //   389: invokestatic 126	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   392: invokevirtual 47	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   395: return
    //   396: astore_1
    //   397: aload 7
    //   399: invokeinterface 33 1 0
    //   404: aload_1
    //   405: athrow
    //   406: astore_1
    //   407: aload_0
    //   408: invokevirtual 129	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   411: ldc -125
    //   413: aload_2
    //   414: invokevirtual 134	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   417: aload_1
    //   418: athrow
    //   419: astore_0
    //   420: aload 7
    //   422: astore_1
    //   423: aload_1
    //   424: ifnull +9 -> 433
    //   427: aload_1
    //   428: invokeinterface 33 1 0
    //   433: aload_0
    //   434: athrow
    //   435: new 136	java/lang/IllegalArgumentException
    //   438: dup
    //   439: ldc -118
    //   441: invokespecial 139	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramzzem	zzem
    //   0	445	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	445	2	paramString1	String
    //   0	445	3	paramString2	String
    //   0	445	4	paramString3	String
    //   0	445	5	paramArrayOfString	String[]
    //   5	323	6	i	int
    //   8	413	7	localObject	Object
    //   38	69	8	localCursor	android.database.Cursor
    //   51	10	9	bool	boolean
    //   68	1	10	localSQLiteException1	android.database.sqlite.SQLiteException
    //   80	17	10	localSQLiteException2	android.database.sqlite.SQLiteException
    //   130	235	11	j	int
    //   213	10	12	k	int
    // Exception table:
    //   from	to	target	type
    //   44	53	68	android/database/sqlite/SQLiteException
    //   10	40	73	finally
    //   10	40	80	android/database/sqlite/SQLiteException
    //   182	194	396	finally
    //   118	182	406	android/database/sqlite/SQLiteException
    //   194	215	406	android/database/sqlite/SQLiteException
    //   232	243	406	android/database/sqlite/SQLiteException
    //   249	322	406	android/database/sqlite/SQLiteException
    //   331	364	406	android/database/sqlite/SQLiteException
    //   370	395	406	android/database/sqlite/SQLiteException
    //   397	406	406	android/database/sqlite/SQLiteException
    //   44	53	419	finally
    //   89	101	419	finally
  }
  
  static void zzb(zzem paramzzem, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramzzem != null)
    {
      paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
      if (!paramSQLiteDatabase.setReadable(false, false)) {
        paramzzem.zze().zza("Failed to turn off database read permission");
      }
      if (!paramSQLiteDatabase.setWritable(false, false)) {
        paramzzem.zze().zza("Failed to turn off database write permission");
      }
      if (!paramSQLiteDatabase.setReadable(true, true)) {
        paramzzem.zze().zza("Failed to turn on database read permission for owner");
      }
      if (!paramSQLiteDatabase.setWritable(true, true)) {
        paramzzem.zze().zza("Failed to turn on database write permission for owner");
      }
      return;
    }
    throw new IllegalArgumentException("Monitor must not be null");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */