package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

public final class zzeg
  extends zzf
{
  private final zzef zza;
  private boolean zzb;
  
  zzeg(zzfu paramzzfu)
  {
    super(paramzzfu);
    paramzzfu = this.zzs.zzax();
    this.zzs.zzc();
    this.zza = new zzef(this, paramzzfu, "google_app_measurement_local.db");
  }
  
  /* Error */
  @WorkerThread
  private final boolean zzq(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   4: aload_0
    //   5: getfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: new 55	android/content/ContentValues
    //   16: dup
    //   17: invokespecial 57	android/content/ContentValues:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: ldc 59
    //   24: iload_1
    //   25: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 69	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   31: aload_3
    //   32: ldc 71
    //   34: aload_2
    //   35: invokevirtual 74	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   38: aload_0
    //   39: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   42: invokevirtual 28	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   45: pop
    //   46: iconst_0
    //   47: istore 4
    //   49: iconst_5
    //   50: istore 5
    //   52: iload 4
    //   54: iconst_5
    //   55: if_icmpge +580 -> 635
    //   58: aconst_null
    //   59: astore 6
    //   61: aconst_null
    //   62: astore 7
    //   64: aconst_null
    //   65: astore 8
    //   67: aconst_null
    //   68: astore 9
    //   70: aconst_null
    //   71: astore 10
    //   73: aload_0
    //   74: invokevirtual 78	com/google/android/gms/measurement/internal/zzeg:zzo	()Landroid/database/sqlite/SQLiteDatabase;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnonnull +17 -> 96
    //   82: aload 10
    //   84: astore 9
    //   86: aload_2
    //   87: astore 8
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 10
    //   98: astore 9
    //   100: aload_2
    //   101: astore 8
    //   103: aload_2
    //   104: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   107: aload 10
    //   109: astore 9
    //   111: aload_2
    //   112: astore 8
    //   114: aload_2
    //   115: ldc 85
    //   117: aconst_null
    //   118: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore 6
    //   123: lconst_0
    //   124: lstore 11
    //   126: lload 11
    //   128: lstore 13
    //   130: aload 6
    //   132: ifnull +45 -> 177
    //   135: lload 11
    //   137: lstore 13
    //   139: aload 6
    //   141: invokeinterface 95 1 0
    //   146: ifeq +31 -> 177
    //   149: aload 6
    //   151: iconst_0
    //   152: invokeinterface 99 2 0
    //   157: lstore 13
    //   159: goto +18 -> 177
    //   162: astore 8
    //   164: goto +437 -> 601
    //   167: astore 8
    //   169: goto +159 -> 328
    //   172: astore 8
    //   174: goto +170 -> 344
    //   177: lload 13
    //   179: ldc2_w 100
    //   182: lcmp
    //   183: iflt +92 -> 275
    //   186: aload_0
    //   187: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   190: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   193: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   196: ldc 112
    //   198: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   201: ldc2_w 100
    //   204: lload 13
    //   206: lsub
    //   207: lconst_1
    //   208: ladd
    //   209: lstore 11
    //   211: aload_2
    //   212: ldc 119
    //   214: ldc 121
    //   216: iconst_1
    //   217: anewarray 123	java/lang/String
    //   220: dup
    //   221: iconst_0
    //   222: lload 11
    //   224: invokestatic 129	java/lang/Long:toString	(J)Ljava/lang/String;
    //   227: aastore
    //   228: invokevirtual 133	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   231: i2l
    //   232: lstore 13
    //   234: lload 13
    //   236: lload 11
    //   238: lcmp
    //   239: ifeq +36 -> 275
    //   242: aload_0
    //   243: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   246: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   249: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   252: ldc -121
    //   254: lload 11
    //   256: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   259: lload 13
    //   261: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: lload 11
    //   266: lload 13
    //   268: lsub
    //   269: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   272: invokevirtual 142	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   275: aload_2
    //   276: ldc 119
    //   278: aconst_null
    //   279: aload_3
    //   280: invokevirtual 146	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   283: pop2
    //   284: aload_2
    //   285: invokevirtual 149	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   288: aload_2
    //   289: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   292: aload 6
    //   294: ifnull +10 -> 304
    //   297: aload 6
    //   299: invokeinterface 155 1 0
    //   304: aload_2
    //   305: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   308: iconst_1
    //   309: ireturn
    //   310: astore 8
    //   312: goto +152 -> 464
    //   315: astore_2
    //   316: aload 8
    //   318: astore 6
    //   320: goto +291 -> 611
    //   323: astore 8
    //   325: aconst_null
    //   326: astore 6
    //   328: aload 8
    //   330: astore 7
    //   332: aload 6
    //   334: astore 9
    //   336: goto +34 -> 370
    //   339: astore 8
    //   341: aconst_null
    //   342: astore 6
    //   344: aload 8
    //   346: astore 7
    //   348: aload 6
    //   350: astore 9
    //   352: goto +169 -> 521
    //   355: astore_2
    //   356: aconst_null
    //   357: astore 6
    //   359: goto +252 -> 611
    //   362: astore 7
    //   364: aconst_null
    //   365: astore 9
    //   367: aload 6
    //   369: astore_2
    //   370: aload_2
    //   371: ifnull +28 -> 399
    //   374: aload_2
    //   375: astore 8
    //   377: aload 9
    //   379: astore 6
    //   381: aload_2
    //   382: invokevirtual 159	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   385: ifeq +14 -> 399
    //   388: aload_2
    //   389: astore 8
    //   391: aload 9
    //   393: astore 6
    //   395: aload_2
    //   396: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   399: aload_2
    //   400: astore 8
    //   402: aload 9
    //   404: astore 6
    //   406: aload_0
    //   407: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   410: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   413: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   416: ldc -95
    //   418: aload 7
    //   420: invokevirtual 164	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   423: aload_2
    //   424: astore 8
    //   426: aload 9
    //   428: astore 6
    //   430: aload_0
    //   431: iconst_1
    //   432: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   435: aload 9
    //   437: ifnull +10 -> 447
    //   440: aload 9
    //   442: invokeinterface 155 1 0
    //   447: iload 5
    //   449: istore_1
    //   450: aload_2
    //   451: ifnull +132 -> 583
    //   454: goto +122 -> 576
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_2
    //   460: aload 7
    //   462: astore 6
    //   464: iload 5
    //   466: i2l
    //   467: lstore 13
    //   469: aload 6
    //   471: astore 9
    //   473: aload_2
    //   474: astore 8
    //   476: lload 13
    //   478: invokestatic 170	android/os/SystemClock:sleep	(J)V
    //   481: iinc 5 20
    //   484: aload 6
    //   486: ifnull +10 -> 496
    //   489: aload 6
    //   491: invokeinterface 155 1 0
    //   496: iload 5
    //   498: istore_1
    //   499: aload_2
    //   500: ifnull +83 -> 583
    //   503: aload_2
    //   504: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   507: iload 5
    //   509: istore_1
    //   510: goto +73 -> 583
    //   513: astore 7
    //   515: aconst_null
    //   516: astore 9
    //   518: aload 8
    //   520: astore_2
    //   521: aload_2
    //   522: astore 8
    //   524: aload 9
    //   526: astore 6
    //   528: aload_0
    //   529: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   532: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   535: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   538: ldc -84
    //   540: aload 7
    //   542: invokevirtual 164	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   545: aload_2
    //   546: astore 8
    //   548: aload 9
    //   550: astore 6
    //   552: aload_0
    //   553: iconst_1
    //   554: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   557: aload 9
    //   559: ifnull +10 -> 569
    //   562: aload 9
    //   564: invokeinterface 155 1 0
    //   569: iload 5
    //   571: istore_1
    //   572: aload_2
    //   573: ifnull +10 -> 583
    //   576: aload_2
    //   577: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   580: iload 5
    //   582: istore_1
    //   583: iinc 4 1
    //   586: iload_1
    //   587: istore 5
    //   589: goto -537 -> 52
    //   592: astore 9
    //   594: aload 8
    //   596: astore_2
    //   597: aload 9
    //   599: astore 8
    //   601: aload 6
    //   603: astore 9
    //   605: aload_2
    //   606: astore 6
    //   608: aload 8
    //   610: astore_2
    //   611: aload 9
    //   613: ifnull +10 -> 623
    //   616: aload 9
    //   618: invokeinterface 155 1 0
    //   623: aload 6
    //   625: ifnull +8 -> 633
    //   628: aload 6
    //   630: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   633: aload_2
    //   634: athrow
    //   635: aload_0
    //   636: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   639: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   642: invokevirtual 175	com/google/android/gms/measurement/internal/zzem:zzk	()Lcom/google/android/gms/measurement/internal/zzek;
    //   645: ldc -79
    //   647: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   650: iconst_0
    //   651: ireturn
    //   652: astore 6
    //   654: aload 7
    //   656: astore 6
    //   658: goto -194 -> 464
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	zzeg
    //   0	661	1	paramInt	int
    //   0	661	2	paramArrayOfByte	byte[]
    //   20	260	3	localContentValues	android.content.ContentValues
    //   47	537	4	i	int
    //   50	538	5	j	int
    //   59	570	6	localObject1	Object
    //   652	1	6	localSQLiteDatabaseLockedException1	android.database.sqlite.SQLiteDatabaseLockedException
    //   656	1	6	localObject2	Object
    //   62	285	7	localObject3	Object
    //   362	99	7	localSQLiteException1	SQLiteException
    //   513	142	7	localSQLiteFullException1	android.database.sqlite.SQLiteFullException
    //   65	48	8	arrayOfByte	byte[]
    //   162	1	8	localObject4	Object
    //   167	1	8	localSQLiteException2	SQLiteException
    //   172	1	8	localSQLiteFullException2	android.database.sqlite.SQLiteFullException
    //   310	7	8	localSQLiteDatabaseLockedException2	android.database.sqlite.SQLiteDatabaseLockedException
    //   323	6	8	localSQLiteException3	SQLiteException
    //   339	6	8	localSQLiteFullException3	android.database.sqlite.SQLiteFullException
    //   375	234	8	localObject5	Object
    //   68	495	9	localObject6	Object
    //   592	6	9	localObject7	Object
    //   603	14	9	localObject8	Object
    //   71	37	10	localObject9	Object
    //   124	141	11	l1	long
    //   128	349	13	l2	long
    // Exception table:
    //   from	to	target	type
    //   139	159	162	finally
    //   186	201	162	finally
    //   211	234	162	finally
    //   242	275	162	finally
    //   275	292	162	finally
    //   139	159	167	android/database/sqlite/SQLiteException
    //   186	201	167	android/database/sqlite/SQLiteException
    //   211	234	167	android/database/sqlite/SQLiteException
    //   242	275	167	android/database/sqlite/SQLiteException
    //   275	292	167	android/database/sqlite/SQLiteException
    //   139	159	172	android/database/sqlite/SQLiteFullException
    //   186	201	172	android/database/sqlite/SQLiteFullException
    //   211	234	172	android/database/sqlite/SQLiteFullException
    //   242	275	172	android/database/sqlite/SQLiteFullException
    //   275	292	172	android/database/sqlite/SQLiteFullException
    //   139	159	310	android/database/sqlite/SQLiteDatabaseLockedException
    //   186	201	310	android/database/sqlite/SQLiteDatabaseLockedException
    //   211	234	310	android/database/sqlite/SQLiteDatabaseLockedException
    //   242	275	310	android/database/sqlite/SQLiteDatabaseLockedException
    //   275	292	310	android/database/sqlite/SQLiteDatabaseLockedException
    //   89	94	315	finally
    //   103	107	315	finally
    //   114	123	315	finally
    //   476	481	315	finally
    //   89	94	323	android/database/sqlite/SQLiteException
    //   103	107	323	android/database/sqlite/SQLiteException
    //   114	123	323	android/database/sqlite/SQLiteException
    //   89	94	339	android/database/sqlite/SQLiteFullException
    //   103	107	339	android/database/sqlite/SQLiteFullException
    //   114	123	339	android/database/sqlite/SQLiteFullException
    //   73	78	355	finally
    //   73	78	362	android/database/sqlite/SQLiteException
    //   73	78	457	android/database/sqlite/SQLiteDatabaseLockedException
    //   73	78	513	android/database/sqlite/SQLiteFullException
    //   381	388	592	finally
    //   395	399	592	finally
    //   406	423	592	finally
    //   430	435	592	finally
    //   528	545	592	finally
    //   552	557	592	finally
    //   89	94	652	android/database/sqlite/SQLiteDatabaseLockedException
    //   103	107	652	android/database/sqlite/SQLiteDatabaseLockedException
    //   114	123	652	android/database/sqlite/SQLiteDatabaseLockedException
  }
  
  protected final boolean zze()
  {
    return false;
  }
  
  @WorkerThread
  public final void zzh()
  {
    zzg();
    try
    {
      SQLiteDatabase localSQLiteDatabase = zzo();
      if (localSQLiteDatabase != null)
      {
        int i = localSQLiteDatabase.delete("messages", null, null);
        if (i > 0) {
          this.zzs.zzau().zzk().zzb("Reset local analytics data. records", Integer.valueOf(i));
        }
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.zzs.zzau().zzb().zzb("Error resetting local analytics data. error", localSQLiteException);
    }
  }
  
  public final boolean zzi(zzas paramzzas)
  {
    Parcel localParcel = Parcel.obtain();
    zzat.zza(paramzzas, localParcel, 0);
    paramzzas = localParcel.marshall();
    localParcel.recycle();
    if (paramzzas.length > 131072)
    {
      this.zzs.zzau().zzc().zza("Event is too long for local database. Sending event directly to service");
      return false;
    }
    return zzq(0, paramzzas);
  }
  
  public final boolean zzj(zzkq paramzzkq)
  {
    Parcel localParcel = Parcel.obtain();
    zzkr.zza(paramzzkq, localParcel, 0);
    paramzzkq = localParcel.marshall();
    localParcel.recycle();
    if (paramzzkq.length > 131072)
    {
      this.zzs.zzau().zzc().zza("User property too long for local database. Sending directly to service");
      return false;
    }
    return zzq(1, paramzzkq);
  }
  
  public final boolean zzk(zzaa paramzzaa)
  {
    paramzzaa = this.zzs.zzl().zzX(paramzzaa);
    if (paramzzaa.length > 131072)
    {
      this.zzs.zzau().zzc().zza("Conditional user property too long for local database. Sending directly to service");
      return false;
    }
    return zzq(2, paramzzaa);
  }
  
  /* Error */
  public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzl(int arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   4: aload_0
    //   5: getfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   8: istore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: iload_2
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 238	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 239	java/util/ArrayList:<init>	()V
    //   27: astore 5
    //   29: aload_0
    //   30: invokevirtual 242	com/google/android/gms/measurement/internal/zzeg:zzp	()Z
    //   33: ifeq +1240 -> 1273
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_5
    //   40: istore_1
    //   41: iload 6
    //   43: iconst_5
    //   44: if_icmpge +1211 -> 1255
    //   47: aload_0
    //   48: invokevirtual 78	com/google/android/gms/measurement/internal/zzeg:zzo	()Landroid/database/sqlite/SQLiteDatabase;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnonnull +10 -> 65
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   63: aconst_null
    //   64: areturn
    //   65: aload 7
    //   67: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   70: aload 7
    //   72: ldc 119
    //   74: iconst_1
    //   75: anewarray 123	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: ldc -12
    //   82: aastore
    //   83: ldc -10
    //   85: iconst_1
    //   86: anewarray 123	java/lang/String
    //   89: dup
    //   90: iconst_0
    //   91: ldc -8
    //   93: aastore
    //   94: aconst_null
    //   95: aconst_null
    //   96: ldc -6
    //   98: ldc -4
    //   100: invokevirtual 256	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore 8
    //   105: aload 8
    //   107: invokeinterface 95 1 0
    //   112: istore_2
    //   113: ldc2_w 257
    //   116: lstore 9
    //   118: iload_2
    //   119: ifeq +23 -> 142
    //   122: aload 8
    //   124: iconst_0
    //   125: invokeinterface 99 2 0
    //   130: lstore 11
    //   132: aload 8
    //   134: invokeinterface 155 1 0
    //   139: goto +15 -> 154
    //   142: aload 8
    //   144: invokeinterface 155 1 0
    //   149: ldc2_w 257
    //   152: lstore 11
    //   154: lload 11
    //   156: ldc2_w 257
    //   159: lcmp
    //   160: ifeq +25 -> 185
    //   163: ldc_w 260
    //   166: astore 13
    //   168: iconst_1
    //   169: anewarray 123	java/lang/String
    //   172: dup
    //   173: iconst_0
    //   174: lload 11
    //   176: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   179: aastore
    //   180: astore 8
    //   182: goto +10 -> 192
    //   185: aconst_null
    //   186: astore 13
    //   188: aload 13
    //   190: astore 8
    //   192: bipush 100
    //   194: invokestatic 265	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   197: astore 14
    //   199: aload 7
    //   201: ldc 119
    //   203: iconst_3
    //   204: anewarray 123	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: ldc -12
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: ldc 59
    //   216: aastore
    //   217: dup
    //   218: iconst_2
    //   219: ldc 71
    //   221: aastore
    //   222: aload 13
    //   224: aload 8
    //   226: aconst_null
    //   227: aconst_null
    //   228: ldc_w 267
    //   231: aload 14
    //   233: invokevirtual 256	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   236: astore 13
    //   238: lload 9
    //   240: lstore 11
    //   242: aload 13
    //   244: invokeinterface 270 1 0
    //   249: ifeq +433 -> 682
    //   252: aload 13
    //   254: iconst_0
    //   255: invokeinterface 99 2 0
    //   260: lstore 9
    //   262: aload 13
    //   264: iconst_1
    //   265: invokeinterface 274 2 0
    //   270: istore 15
    //   272: aload 13
    //   274: iconst_2
    //   275: invokeinterface 278 2 0
    //   280: astore 16
    //   282: iload 15
    //   284: ifne +114 -> 398
    //   287: invokestatic 192	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   290: astore 8
    //   292: aload 8
    //   294: aload 16
    //   296: iconst_0
    //   297: aload 16
    //   299: arraylength
    //   300: invokevirtual 282	android/os/Parcel:unmarshall	([BII)V
    //   303: aload 8
    //   305: iconst_0
    //   306: invokevirtual 286	android/os/Parcel:setDataPosition	(I)V
    //   309: getstatic 292	com/google/android/gms/measurement/internal/zzas:CREATOR	Landroid/os/Parcelable$Creator;
    //   312: aload 8
    //   314: invokeinterface 298 2 0
    //   319: checkcast 288	com/google/android/gms/measurement/internal/zzas
    //   322: astore 14
    //   324: aload 8
    //   326: invokevirtual 204	android/os/Parcel:recycle	()V
    //   329: lload 9
    //   331: lstore 11
    //   333: aload 14
    //   335: ifnull -93 -> 242
    //   338: aload 5
    //   340: aload 14
    //   342: invokeinterface 304 2 0
    //   347: pop
    //   348: lload 9
    //   350: lstore 11
    //   352: goto -110 -> 242
    //   355: astore 14
    //   357: goto +33 -> 390
    //   360: astore 14
    //   362: aload_0
    //   363: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   366: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   369: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   372: ldc_w 306
    //   375: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   378: aload 8
    //   380: invokevirtual 204	android/os/Parcel:recycle	()V
    //   383: lload 9
    //   385: lstore 11
    //   387: goto -145 -> 242
    //   390: aload 8
    //   392: invokevirtual 204	android/os/Parcel:recycle	()V
    //   395: aload 14
    //   397: athrow
    //   398: iload 15
    //   400: iconst_1
    //   401: if_icmpne +113 -> 514
    //   404: invokestatic 192	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   407: astore 14
    //   409: aload 14
    //   411: aload 16
    //   413: iconst_0
    //   414: aload 16
    //   416: arraylength
    //   417: invokevirtual 282	android/os/Parcel:unmarshall	([BII)V
    //   420: aload 14
    //   422: iconst_0
    //   423: invokevirtual 286	android/os/Parcel:setDataPosition	(I)V
    //   426: getstatic 309	com/google/android/gms/measurement/internal/zzkq:CREATOR	Landroid/os/Parcelable$Creator;
    //   429: aload 14
    //   431: invokeinterface 298 2 0
    //   436: checkcast 308	com/google/android/gms/measurement/internal/zzkq
    //   439: astore 8
    //   441: aload 14
    //   443: invokevirtual 204	android/os/Parcel:recycle	()V
    //   446: goto +34 -> 480
    //   449: astore 8
    //   451: goto +55 -> 506
    //   454: astore 8
    //   456: aload_0
    //   457: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   460: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   463: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   466: ldc_w 311
    //   469: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   472: aload 14
    //   474: invokevirtual 204	android/os/Parcel:recycle	()V
    //   477: aconst_null
    //   478: astore 8
    //   480: lload 9
    //   482: lstore 11
    //   484: aload 8
    //   486: ifnull -244 -> 242
    //   489: aload 5
    //   491: aload 8
    //   493: invokeinterface 304 2 0
    //   498: pop
    //   499: lload 9
    //   501: lstore 11
    //   503: goto -261 -> 242
    //   506: aload 14
    //   508: invokevirtual 204	android/os/Parcel:recycle	()V
    //   511: aload 8
    //   513: athrow
    //   514: iload 15
    //   516: iconst_2
    //   517: if_icmpne +113 -> 630
    //   520: invokestatic 192	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   523: astore 14
    //   525: aload 14
    //   527: aload 16
    //   529: iconst_0
    //   530: aload 16
    //   532: arraylength
    //   533: invokevirtual 282	android/os/Parcel:unmarshall	([BII)V
    //   536: aload 14
    //   538: iconst_0
    //   539: invokevirtual 286	android/os/Parcel:setDataPosition	(I)V
    //   542: getstatic 314	com/google/android/gms/measurement/internal/zzaa:CREATOR	Landroid/os/Parcelable$Creator;
    //   545: aload 14
    //   547: invokeinterface 298 2 0
    //   552: checkcast 313	com/google/android/gms/measurement/internal/zzaa
    //   555: astore 8
    //   557: aload 14
    //   559: invokevirtual 204	android/os/Parcel:recycle	()V
    //   562: goto +34 -> 596
    //   565: astore 8
    //   567: goto +55 -> 622
    //   570: astore 8
    //   572: aload_0
    //   573: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   576: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   579: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   582: ldc_w 316
    //   585: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   588: aload 14
    //   590: invokevirtual 204	android/os/Parcel:recycle	()V
    //   593: aconst_null
    //   594: astore 8
    //   596: lload 9
    //   598: lstore 11
    //   600: aload 8
    //   602: ifnull -360 -> 242
    //   605: aload 5
    //   607: aload 8
    //   609: invokeinterface 304 2 0
    //   614: pop
    //   615: lload 9
    //   617: lstore 11
    //   619: goto -377 -> 242
    //   622: aload 14
    //   624: invokevirtual 204	android/os/Parcel:recycle	()V
    //   627: aload 8
    //   629: athrow
    //   630: iload 15
    //   632: iconst_3
    //   633: if_icmpne +26 -> 659
    //   636: aload_0
    //   637: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   640: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   643: invokevirtual 318	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   646: ldc_w 320
    //   649: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   652: lload 9
    //   654: lstore 11
    //   656: goto -414 -> 242
    //   659: aload_0
    //   660: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   663: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   666: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   669: ldc_w 322
    //   672: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   675: lload 9
    //   677: lstore 11
    //   679: goto -437 -> 242
    //   682: lload 11
    //   684: invokestatic 129	java/lang/Long:toString	(J)Ljava/lang/String;
    //   687: astore 14
    //   689: aload 7
    //   691: astore 8
    //   693: aload 8
    //   695: ldc 119
    //   697: ldc_w 324
    //   700: iconst_1
    //   701: anewarray 123	java/lang/String
    //   704: dup
    //   705: iconst_0
    //   706: aload 14
    //   708: aastore
    //   709: invokevirtual 133	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   712: aload 5
    //   714: invokeinterface 328 1 0
    //   719: if_icmpge +19 -> 738
    //   722: aload_0
    //   723: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   726: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   729: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   732: ldc_w 330
    //   735: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   738: aload 8
    //   740: invokevirtual 149	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   743: aload 8
    //   745: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   748: aload 13
    //   750: invokeinterface 155 1 0
    //   755: aload 8
    //   757: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   760: aload 5
    //   762: areturn
    //   763: astore 8
    //   765: goto +15 -> 780
    //   768: astore 8
    //   770: goto +139 -> 909
    //   773: astore 8
    //   775: goto +170 -> 945
    //   778: astore 8
    //   780: aload 13
    //   782: astore 14
    //   784: aload 8
    //   786: astore 13
    //   788: aload 14
    //   790: astore 8
    //   792: goto +97 -> 889
    //   795: astore 8
    //   797: goto +112 -> 909
    //   800: astore 8
    //   802: goto +127 -> 929
    //   805: astore 8
    //   807: goto +138 -> 945
    //   810: astore 13
    //   812: aload 4
    //   814: astore 8
    //   816: goto +73 -> 889
    //   819: astore 8
    //   821: goto +85 -> 906
    //   824: astore 13
    //   826: goto +100 -> 926
    //   829: astore 8
    //   831: goto +111 -> 942
    //   834: astore 13
    //   836: goto +13 -> 849
    //   839: astore 13
    //   841: goto +5 -> 846
    //   844: astore 8
    //   846: aconst_null
    //   847: astore 8
    //   849: aload 8
    //   851: ifnull +10 -> 861
    //   854: aload 8
    //   856: invokeinterface 155 1 0
    //   861: aload 13
    //   863: athrow
    //   864: astore 13
    //   866: aload 4
    //   868: astore 8
    //   870: goto +19 -> 889
    //   873: astore 8
    //   875: goto +31 -> 906
    //   878: astore 8
    //   880: goto +62 -> 942
    //   883: astore 13
    //   885: aload 4
    //   887: astore 8
    //   889: aload 7
    //   891: astore 14
    //   893: aload 8
    //   895: astore 7
    //   897: aload 14
    //   899: astore 8
    //   901: goto +329 -> 1230
    //   904: astore 8
    //   906: aconst_null
    //   907: astore 13
    //   909: aload 8
    //   911: astore 16
    //   913: aload 13
    //   915: astore 14
    //   917: aload 7
    //   919: astore 8
    //   921: goto +59 -> 980
    //   924: astore 13
    //   926: aconst_null
    //   927: astore 13
    //   929: aload 13
    //   931: astore 14
    //   933: aload 7
    //   935: astore 8
    //   937: goto +148 -> 1085
    //   940: astore 8
    //   942: aconst_null
    //   943: astore 13
    //   945: aload 8
    //   947: astore 16
    //   949: aload 13
    //   951: astore 14
    //   953: aload 7
    //   955: astore 8
    //   957: goto +188 -> 1145
    //   960: astore 13
    //   962: aconst_null
    //   963: astore 8
    //   965: aload_3
    //   966: astore 7
    //   968: goto +262 -> 1230
    //   971: astore 16
    //   973: aconst_null
    //   974: astore 14
    //   976: aload 14
    //   978: astore 8
    //   980: aload 8
    //   982: ifnull +32 -> 1014
    //   985: aload 14
    //   987: astore 13
    //   989: aload 8
    //   991: astore 7
    //   993: aload 8
    //   995: invokevirtual 159	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   998: ifeq +16 -> 1014
    //   1001: aload 14
    //   1003: astore 13
    //   1005: aload 8
    //   1007: astore 7
    //   1009: aload 8
    //   1011: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1014: aload 14
    //   1016: astore 13
    //   1018: aload 8
    //   1020: astore 7
    //   1022: aload_0
    //   1023: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   1026: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1029: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   1032: ldc_w 332
    //   1035: aload 16
    //   1037: invokevirtual 164	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1040: aload 14
    //   1042: astore 13
    //   1044: aload 8
    //   1046: astore 7
    //   1048: aload_0
    //   1049: iconst_1
    //   1050: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   1053: aload 14
    //   1055: ifnull +10 -> 1065
    //   1058: aload 14
    //   1060: invokeinterface 155 1 0
    //   1065: iload_1
    //   1066: istore 15
    //   1068: aload 8
    //   1070: ifnull +137 -> 1207
    //   1073: goto +52 -> 1125
    //   1076: astore 7
    //   1078: aconst_null
    //   1079: astore 14
    //   1081: aload 14
    //   1083: astore 8
    //   1085: iload_1
    //   1086: i2l
    //   1087: lstore 11
    //   1089: aload 14
    //   1091: astore 13
    //   1093: aload 8
    //   1095: astore 7
    //   1097: lload 11
    //   1099: invokestatic 170	android/os/SystemClock:sleep	(J)V
    //   1102: iinc 1 20
    //   1105: aload 14
    //   1107: ifnull +10 -> 1117
    //   1110: aload 14
    //   1112: invokeinterface 155 1 0
    //   1117: iload_1
    //   1118: istore 15
    //   1120: aload 8
    //   1122: ifnull +85 -> 1207
    //   1125: aload 8
    //   1127: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   1130: iload_1
    //   1131: istore 15
    //   1133: goto +74 -> 1207
    //   1136: astore 16
    //   1138: aconst_null
    //   1139: astore 14
    //   1141: aload 14
    //   1143: astore 8
    //   1145: aload 14
    //   1147: astore 13
    //   1149: aload 8
    //   1151: astore 7
    //   1153: aload_0
    //   1154: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   1157: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1160: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   1163: ldc_w 332
    //   1166: aload 16
    //   1168: invokevirtual 164	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1171: aload 14
    //   1173: astore 13
    //   1175: aload 8
    //   1177: astore 7
    //   1179: aload_0
    //   1180: iconst_1
    //   1181: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   1184: aload 14
    //   1186: ifnull +10 -> 1196
    //   1189: aload 14
    //   1191: invokeinterface 155 1 0
    //   1196: iload_1
    //   1197: istore 15
    //   1199: aload 8
    //   1201: ifnull +6 -> 1207
    //   1204: goto -79 -> 1125
    //   1207: iinc 6 1
    //   1210: iload 15
    //   1212: istore_1
    //   1213: goto -1172 -> 41
    //   1216: astore 14
    //   1218: aload 7
    //   1220: astore 8
    //   1222: aload 13
    //   1224: astore 7
    //   1226: aload 14
    //   1228: astore 13
    //   1230: aload 7
    //   1232: ifnull +10 -> 1242
    //   1235: aload 7
    //   1237: invokeinterface 155 1 0
    //   1242: aload 8
    //   1244: ifnull +8 -> 1252
    //   1247: aload 8
    //   1249: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   1252: aload 13
    //   1254: athrow
    //   1255: aload_0
    //   1256: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   1259: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1262: invokevirtual 318	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   1265: ldc_w 334
    //   1268: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   1271: aconst_null
    //   1272: areturn
    //   1273: aload 5
    //   1275: areturn
    //   1276: astore 8
    //   1278: goto -349 -> 929
    //   1281: astore 13
    //   1283: goto -357 -> 926
    // Exception table:
    //   from	to	target	type
    //   292	324	355	finally
    //   362	378	355	finally
    //   292	324	360	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   409	441	449	finally
    //   456	472	449	finally
    //   409	441	454	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   525	557	565	finally
    //   572	588	565	finally
    //   525	557	570	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   693	738	763	finally
    //   738	748	763	finally
    //   693	738	768	android/database/sqlite/SQLiteException
    //   738	748	768	android/database/sqlite/SQLiteException
    //   693	738	773	android/database/sqlite/SQLiteFullException
    //   738	748	773	android/database/sqlite/SQLiteFullException
    //   242	282	778	finally
    //   287	292	778	finally
    //   324	329	778	finally
    //   338	348	778	finally
    //   378	383	778	finally
    //   390	398	778	finally
    //   404	409	778	finally
    //   441	446	778	finally
    //   472	477	778	finally
    //   489	499	778	finally
    //   506	514	778	finally
    //   520	525	778	finally
    //   557	562	778	finally
    //   588	593	778	finally
    //   605	615	778	finally
    //   622	630	778	finally
    //   636	652	778	finally
    //   659	675	778	finally
    //   682	689	778	finally
    //   242	282	795	android/database/sqlite/SQLiteException
    //   287	292	795	android/database/sqlite/SQLiteException
    //   324	329	795	android/database/sqlite/SQLiteException
    //   338	348	795	android/database/sqlite/SQLiteException
    //   378	383	795	android/database/sqlite/SQLiteException
    //   390	398	795	android/database/sqlite/SQLiteException
    //   404	409	795	android/database/sqlite/SQLiteException
    //   441	446	795	android/database/sqlite/SQLiteException
    //   472	477	795	android/database/sqlite/SQLiteException
    //   489	499	795	android/database/sqlite/SQLiteException
    //   506	514	795	android/database/sqlite/SQLiteException
    //   520	525	795	android/database/sqlite/SQLiteException
    //   557	562	795	android/database/sqlite/SQLiteException
    //   588	593	795	android/database/sqlite/SQLiteException
    //   605	615	795	android/database/sqlite/SQLiteException
    //   622	630	795	android/database/sqlite/SQLiteException
    //   636	652	795	android/database/sqlite/SQLiteException
    //   659	675	795	android/database/sqlite/SQLiteException
    //   682	689	795	android/database/sqlite/SQLiteException
    //   242	282	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   287	292	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   324	329	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   338	348	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   378	383	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   390	398	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   404	409	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   441	446	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   472	477	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   489	499	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   506	514	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   520	525	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   557	562	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   588	593	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   605	615	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   622	630	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   636	652	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   659	675	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   682	689	800	android/database/sqlite/SQLiteDatabaseLockedException
    //   242	282	805	android/database/sqlite/SQLiteFullException
    //   287	292	805	android/database/sqlite/SQLiteFullException
    //   324	329	805	android/database/sqlite/SQLiteFullException
    //   338	348	805	android/database/sqlite/SQLiteFullException
    //   378	383	805	android/database/sqlite/SQLiteFullException
    //   390	398	805	android/database/sqlite/SQLiteFullException
    //   404	409	805	android/database/sqlite/SQLiteFullException
    //   441	446	805	android/database/sqlite/SQLiteFullException
    //   472	477	805	android/database/sqlite/SQLiteFullException
    //   489	499	805	android/database/sqlite/SQLiteFullException
    //   506	514	805	android/database/sqlite/SQLiteFullException
    //   520	525	805	android/database/sqlite/SQLiteFullException
    //   557	562	805	android/database/sqlite/SQLiteFullException
    //   588	593	805	android/database/sqlite/SQLiteFullException
    //   605	615	805	android/database/sqlite/SQLiteFullException
    //   622	630	805	android/database/sqlite/SQLiteFullException
    //   636	652	805	android/database/sqlite/SQLiteFullException
    //   659	675	805	android/database/sqlite/SQLiteFullException
    //   682	689	805	android/database/sqlite/SQLiteFullException
    //   132	139	810	finally
    //   142	149	810	finally
    //   168	182	810	finally
    //   192	238	810	finally
    //   132	139	819	android/database/sqlite/SQLiteException
    //   142	149	819	android/database/sqlite/SQLiteException
    //   168	182	819	android/database/sqlite/SQLiteException
    //   192	238	819	android/database/sqlite/SQLiteException
    //   132	139	824	android/database/sqlite/SQLiteDatabaseLockedException
    //   142	149	824	android/database/sqlite/SQLiteDatabaseLockedException
    //   168	182	824	android/database/sqlite/SQLiteDatabaseLockedException
    //   192	238	824	android/database/sqlite/SQLiteDatabaseLockedException
    //   132	139	829	android/database/sqlite/SQLiteFullException
    //   142	149	829	android/database/sqlite/SQLiteFullException
    //   168	182	829	android/database/sqlite/SQLiteFullException
    //   192	238	829	android/database/sqlite/SQLiteFullException
    //   105	113	834	finally
    //   122	132	834	finally
    //   70	105	839	finally
    //   854	861	864	finally
    //   861	864	864	finally
    //   854	861	873	android/database/sqlite/SQLiteException
    //   861	864	873	android/database/sqlite/SQLiteException
    //   854	861	878	android/database/sqlite/SQLiteFullException
    //   861	864	878	android/database/sqlite/SQLiteFullException
    //   58	63	883	finally
    //   65	70	883	finally
    //   58	63	904	android/database/sqlite/SQLiteException
    //   65	70	904	android/database/sqlite/SQLiteException
    //   58	63	924	android/database/sqlite/SQLiteDatabaseLockedException
    //   65	70	924	android/database/sqlite/SQLiteDatabaseLockedException
    //   58	63	940	android/database/sqlite/SQLiteFullException
    //   65	70	940	android/database/sqlite/SQLiteFullException
    //   47	53	960	finally
    //   47	53	971	android/database/sqlite/SQLiteException
    //   47	53	1076	android/database/sqlite/SQLiteDatabaseLockedException
    //   47	53	1136	android/database/sqlite/SQLiteFullException
    //   993	1001	1216	finally
    //   1009	1014	1216	finally
    //   1022	1040	1216	finally
    //   1048	1053	1216	finally
    //   1097	1102	1216	finally
    //   1153	1171	1216	finally
    //   1179	1184	1216	finally
    //   693	738	1276	android/database/sqlite/SQLiteDatabaseLockedException
    //   738	748	1276	android/database/sqlite/SQLiteDatabaseLockedException
    //   854	861	1281	android/database/sqlite/SQLiteDatabaseLockedException
    //   861	864	1281	android/database/sqlite/SQLiteDatabaseLockedException
  }
  
  @WorkerThread
  public final boolean zzm()
  {
    return zzq(3, new byte[0]);
  }
  
  /* Error */
  @WorkerThread
  public final boolean zzn()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   4: aload_0
    //   5: getfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: invokevirtual 242	com/google/android/gms/measurement/internal/zzeg:zzp	()Z
    //   17: ifeq +355 -> 372
    //   20: iconst_0
    //   21: istore_1
    //   22: iconst_5
    //   23: istore_2
    //   24: iload_1
    //   25: iconst_5
    //   26: if_icmpge +330 -> 356
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore 4
    //   34: aconst_null
    //   35: astore 5
    //   37: aconst_null
    //   38: astore 6
    //   40: aload_0
    //   41: invokevirtual 78	com/google/android/gms/measurement/internal/zzeg:zzo	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnonnull +25 -> 73
    //   51: aload 7
    //   53: astore 6
    //   55: aload 7
    //   57: astore_3
    //   58: aload 7
    //   60: astore 4
    //   62: aload 7
    //   64: astore 5
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   71: iconst_0
    //   72: ireturn
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: astore_3
    //   80: aload 7
    //   82: astore 4
    //   84: aload 7
    //   86: astore 5
    //   88: aload 7
    //   90: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   93: aload 7
    //   95: astore 6
    //   97: aload 7
    //   99: astore_3
    //   100: aload 7
    //   102: astore 4
    //   104: aload 7
    //   106: astore 5
    //   108: aload 7
    //   110: ldc 119
    //   112: ldc_w 340
    //   115: iconst_1
    //   116: anewarray 123	java/lang/String
    //   119: dup
    //   120: iconst_0
    //   121: iconst_3
    //   122: invokestatic 265	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   125: aastore
    //   126: invokevirtual 133	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   129: pop
    //   130: aload 7
    //   132: astore 6
    //   134: aload 7
    //   136: astore_3
    //   137: aload 7
    //   139: astore 4
    //   141: aload 7
    //   143: astore 5
    //   145: aload 7
    //   147: invokevirtual 149	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   150: aload 7
    //   152: astore 6
    //   154: aload 7
    //   156: astore_3
    //   157: aload 7
    //   159: astore 4
    //   161: aload 7
    //   163: astore 5
    //   165: aload 7
    //   167: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   170: aload 7
    //   172: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: iconst_1
    //   176: ireturn
    //   177: astore_3
    //   178: goto +166 -> 344
    //   181: astore 4
    //   183: goto +7 -> 190
    //   186: astore_3
    //   187: goto +101 -> 288
    //   190: aload_3
    //   191: ifnull +20 -> 211
    //   194: aload_3
    //   195: astore 6
    //   197: aload_3
    //   198: invokevirtual 159	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   201: ifeq +10 -> 211
    //   204: aload_3
    //   205: astore 6
    //   207: aload_3
    //   208: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   211: aload_3
    //   212: astore 6
    //   214: aload_0
    //   215: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   218: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   221: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   224: ldc_w 342
    //   227: aload 4
    //   229: invokevirtual 164	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   232: aload_3
    //   233: astore 6
    //   235: aload_0
    //   236: iconst_1
    //   237: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   240: iload_2
    //   241: istore 8
    //   243: aload_3
    //   244: ifnull +91 -> 335
    //   247: iload_2
    //   248: istore 8
    //   250: goto +31 -> 281
    //   253: astore 6
    //   255: aload 5
    //   257: astore 6
    //   259: iload_2
    //   260: i2l
    //   261: invokestatic 170	android/os/SystemClock:sleep	(J)V
    //   264: iinc 2 20
    //   267: iload_2
    //   268: istore 8
    //   270: aload 5
    //   272: ifnull +63 -> 335
    //   275: aload 5
    //   277: astore_3
    //   278: iload_2
    //   279: istore 8
    //   281: aload_3
    //   282: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   285: goto +50 -> 335
    //   288: aload 4
    //   290: astore 6
    //   292: aload_0
    //   293: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   296: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   299: invokevirtual 110	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   302: ldc_w 342
    //   305: aload_3
    //   306: invokevirtual 164	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   309: aload 4
    //   311: astore 6
    //   313: aload_0
    //   314: iconst_1
    //   315: putfield 53	com/google/android/gms/measurement/internal/zzeg:zzb	Z
    //   318: iload_2
    //   319: istore 8
    //   321: aload 4
    //   323: ifnull +12 -> 335
    //   326: iload_2
    //   327: istore 8
    //   329: aload 4
    //   331: astore_3
    //   332: goto -51 -> 281
    //   335: iinc 1 1
    //   338: iload 8
    //   340: istore_2
    //   341: goto -317 -> 24
    //   344: aload 6
    //   346: ifnull +8 -> 354
    //   349: aload 6
    //   351: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   354: aload_3
    //   355: athrow
    //   356: aload_0
    //   357: getfield 18	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   360: invokevirtual 105	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   363: invokevirtual 318	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   366: ldc_w 344
    //   369: invokevirtual 117	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   372: iconst_0
    //   373: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	zzeg
    //   21	315	1	i	int
    //   23	318	2	j	int
    //   30	127	3	localObject1	Object
    //   177	1	3	localObject2	Object
    //   186	58	3	localSQLiteFullException	android.database.sqlite.SQLiteFullException
    //   277	78	3	localObject3	Object
    //   32	128	4	localObject4	Object
    //   181	149	4	localSQLiteException	SQLiteException
    //   35	241	5	localObject5	Object
    //   38	196	6	localObject6	Object
    //   253	1	6	localSQLiteDatabaseLockedException	android.database.sqlite.SQLiteDatabaseLockedException
    //   257	93	6	localObject7	Object
    //   44	127	7	localSQLiteDatabase	SQLiteDatabase
    //   241	98	8	k	int
    // Exception table:
    //   from	to	target	type
    //   40	46	177	finally
    //   66	71	177	finally
    //   88	93	177	finally
    //   108	130	177	finally
    //   145	150	177	finally
    //   165	170	177	finally
    //   197	204	177	finally
    //   207	211	177	finally
    //   214	232	177	finally
    //   235	240	177	finally
    //   259	264	177	finally
    //   292	309	177	finally
    //   313	318	177	finally
    //   40	46	181	android/database/sqlite/SQLiteException
    //   66	71	181	android/database/sqlite/SQLiteException
    //   88	93	181	android/database/sqlite/SQLiteException
    //   108	130	181	android/database/sqlite/SQLiteException
    //   145	150	181	android/database/sqlite/SQLiteException
    //   165	170	181	android/database/sqlite/SQLiteException
    //   40	46	186	android/database/sqlite/SQLiteFullException
    //   66	71	186	android/database/sqlite/SQLiteFullException
    //   88	93	186	android/database/sqlite/SQLiteFullException
    //   108	130	186	android/database/sqlite/SQLiteFullException
    //   145	150	186	android/database/sqlite/SQLiteFullException
    //   165	170	186	android/database/sqlite/SQLiteFullException
    //   40	46	253	android/database/sqlite/SQLiteDatabaseLockedException
    //   66	71	253	android/database/sqlite/SQLiteDatabaseLockedException
    //   88	93	253	android/database/sqlite/SQLiteDatabaseLockedException
    //   108	130	253	android/database/sqlite/SQLiteDatabaseLockedException
    //   145	150	253	android/database/sqlite/SQLiteDatabaseLockedException
    //   165	170	253	android/database/sqlite/SQLiteDatabaseLockedException
  }
  
  @WorkerThread
  @VisibleForTesting
  final SQLiteDatabase zzo()
    throws SQLiteException
  {
    if (this.zzb) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = this.zza.getWritableDatabase();
    if (localSQLiteDatabase == null)
    {
      this.zzb = true;
      return null;
    }
    return localSQLiteDatabase;
  }
  
  @VisibleForTesting
  final boolean zzp()
  {
    Context localContext = this.zzs.zzax();
    this.zzs.zzc();
    return localContext.getDatabasePath("google_app_measurement_local.db").exists();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */