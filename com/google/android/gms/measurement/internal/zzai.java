package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzeg;
import com.google.android.gms.internal.measurement.zzei;
import com.google.android.gms.internal.measurement.zzej;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzio;
import com.google.android.gms.internal.measurement.zzjz;
import com.google.android.gms.internal.measurement.zzov;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzai
  extends zzke
{
  private static final String[] zza = { "last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;" };
  private static final String[] zzb = { "origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;" };
  private static final String[] zzc = { "app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;" };
  private static final String[] zzd = { "realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;" };
  private static final String[] zze = { "has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;" };
  private static final String[] zzg = { "session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;" };
  private static final String[] zzh = { "session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;" };
  private static final String[] zzi = { "previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;" };
  private final zzah zzj;
  private final zzka zzk = new zzka(this.zzs.zzay());
  
  zzai(zzkn paramzzkn)
  {
    super(paramzzkn);
    this.zzs.zzc();
    this.zzj = new zzah(this, this.zzs.zzax(), "google_app_measurement.db");
  }
  
  @WorkerThread
  static final void zzX(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    Preconditions.checkNotEmpty("value");
    Preconditions.checkNotNull(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put("value", (String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put("value", (Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramContentValues.put("value", (Double)paramObject);
      return;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  /* Error */
  @WorkerThread
  private final long zzab(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_3
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 298	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore_2
    //   18: aload_2
    //   19: astore 5
    //   21: aload_2
    //   22: astore 4
    //   24: aload_2
    //   25: invokeinterface 304 1 0
    //   30: ifeq +27 -> 57
    //   33: aload_2
    //   34: astore 5
    //   36: aload_2
    //   37: astore 4
    //   39: aload_2
    //   40: iconst_0
    //   41: invokeinterface 308 2 0
    //   46: lstore 6
    //   48: aload_2
    //   49: invokeinterface 311 1 0
    //   54: lload 6
    //   56: lreturn
    //   57: aload_2
    //   58: astore 5
    //   60: aload_2
    //   61: astore 4
    //   63: new 289	android/database/sqlite/SQLiteException
    //   66: astore_3
    //   67: aload_2
    //   68: astore 5
    //   70: aload_2
    //   71: astore 4
    //   73: aload_3
    //   74: ldc_w 313
    //   77: invokespecial 314	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   80: aload_2
    //   81: astore 5
    //   83: aload_2
    //   84: astore 4
    //   86: aload_3
    //   87: athrow
    //   88: astore_1
    //   89: goto +32 -> 121
    //   92: astore_2
    //   93: aload 4
    //   95: astore 5
    //   97: aload_0
    //   98: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   101: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   104: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   107: ldc_w 325
    //   110: aload_1
    //   111: aload_2
    //   112: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   115: aload 4
    //   117: astore 5
    //   119: aload_2
    //   120: athrow
    //   121: aload 5
    //   123: ifnull +10 -> 133
    //   126: aload 5
    //   128: invokeinterface 311 1 0
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	zzai
    //   0	135	1	paramString	String
    //   0	135	2	paramArrayOfString	String[]
    //   4	83	3	localObject	Object
    //   6	110	4	arrayOfString1	String[]
    //   9	118	5	arrayOfString2	String[]
    //   46	9	6	l	long
    // Exception table:
    //   from	to	target	type
    //   11	18	88	finally
    //   24	33	88	finally
    //   39	48	88	finally
    //   63	67	88	finally
    //   73	80	88	finally
    //   86	88	88	finally
    //   97	115	88	finally
    //   119	121	88	finally
    //   11	18	92	android/database/sqlite/SQLiteException
    //   24	33	92	android/database/sqlite/SQLiteException
    //   39	48	92	android/database/sqlite/SQLiteException
    //   63	67	92	android/database/sqlite/SQLiteException
    //   73	80	92	android/database/sqlite/SQLiteException
    //   86	88	92	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  @WorkerThread
  private final long zzac(String paramString, String[] paramArrayOfString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aload 5
    //   14: aload_1
    //   15: aload_2
    //   16: invokevirtual 298	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore 7
    //   23: aload_2
    //   24: astore 6
    //   26: aload_2
    //   27: invokeinterface 304 1 0
    //   32: ifeq +25 -> 57
    //   35: aload_2
    //   36: astore 7
    //   38: aload_2
    //   39: astore 6
    //   41: aload_2
    //   42: iconst_0
    //   43: invokeinterface 308 2 0
    //   48: lstore_3
    //   49: aload_2
    //   50: invokeinterface 311 1 0
    //   55: lload_3
    //   56: lreturn
    //   57: aload_2
    //   58: invokeinterface 311 1 0
    //   63: lload_3
    //   64: lreturn
    //   65: astore_1
    //   66: goto +32 -> 98
    //   69: astore_2
    //   70: aload 6
    //   72: astore 7
    //   74: aload_0
    //   75: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   78: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   81: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   84: ldc_w 325
    //   87: aload_1
    //   88: aload_2
    //   89: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: aload 6
    //   94: astore 7
    //   96: aload_2
    //   97: athrow
    //   98: aload 7
    //   100: ifnull +10 -> 110
    //   103: aload 7
    //   105: invokeinterface 311 1 0
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	zzai
    //   0	112	1	paramString	String
    //   0	112	2	paramArrayOfString	String[]
    //   0	112	3	paramLong	long
    //   4	9	5	localSQLiteDatabase	SQLiteDatabase
    //   7	86	6	arrayOfString1	String[]
    //   10	94	7	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   12	20	65	finally
    //   26	35	65	finally
    //   41	49	65	finally
    //   74	92	65	finally
    //   96	98	65	finally
    //   12	20	69	android/database/sqlite/SQLiteException
    //   26	35	69	android/database/sqlite/SQLiteException
    //   41	49	69	android/database/sqlite/SQLiteException
  }
  
  @WorkerThread
  final void zzA()
  {
    zzg();
    zzZ();
    if (zzM())
    {
      long l1 = this.zzf.zzn().zza.zza();
      long l2 = this.zzs.zzay().elapsedRealtime();
      l1 = Math.abs(l2 - l1);
      this.zzs.zzc();
      if (l1 > ((Long)zzea.zzx.zzb(null)).longValue())
      {
        this.zzf.zzn().zza.zzb(l2);
        zzg();
        zzZ();
        if (zzM())
        {
          SQLiteDatabase localSQLiteDatabase = zze();
          l2 = this.zzs.zzay().currentTimeMillis();
          this.zzs.zzc();
          int i = localSQLiteDatabase.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(l2), String.valueOf(zzae.zzA()) });
          if (i > 0) {
            this.zzs.zzau().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
          }
        }
      }
    }
  }
  
  @WorkerThread
  @VisibleForTesting
  final void zzB(List<Long> paramList)
  {
    zzg();
    zzZ();
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotZero(paramList.size());
    if (!zzM()) {
      return;
    }
    Object localObject = TextUtils.join(",", paramList);
    paramList = new StringBuilder(String.valueOf(localObject).length() + 2);
    paramList.append("(");
    paramList.append((String)localObject);
    paramList.append(")");
    paramList = paramList.toString();
    localObject = new StringBuilder(String.valueOf(paramList).length() + 80);
    ((StringBuilder)localObject).append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(" AND retry_count =  2147483647 LIMIT 1");
    if (zzab(((StringBuilder)localObject).toString(), null) > 0L) {
      this.zzs.zzau().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
    }
    try
    {
      localObject = zze();
      int i = String.valueOf(paramList).length();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(i + 127);
      localStringBuilder.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
      localStringBuilder.append(paramList);
      localStringBuilder.append(" AND (retry_count IS NULL OR retry_count < ");
      localStringBuilder.append(Integer.MAX_VALUE);
      localStringBuilder.append(")");
      ((SQLiteDatabase)localObject).execSQL(localStringBuilder.toString());
      return;
    }
    catch (SQLiteException paramList)
    {
      this.zzs.zzau().zzb().zzb("Error incrementing retry count. error", paramList);
    }
  }
  
  @WorkerThread
  @VisibleForTesting
  final Object zzC(Cursor paramCursor, int paramInt)
  {
    int i = paramCursor.getType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              this.zzs.zzau().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
              return null;
            }
            this.zzs.zzau().zzb().zza("Loaded invalid blob type value, ignoring it");
            return null;
          }
          return paramCursor.getString(paramInt);
        }
        return Double.valueOf(paramCursor.getDouble(paramInt));
      }
      return Long.valueOf(paramCursor.getLong(paramInt));
    }
    this.zzs.zzau().zzb().zza("Loaded invalid null value from database");
    return null;
  }
  
  @WorkerThread
  public final long zzD()
  {
    return zzac("select max(bundle_end_timestamp) from queue", null, 0L);
  }
  
  /* Error */
  @WorkerThread
  @VisibleForTesting
  protected final long zzE(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: ldc_w 526
    //   8: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   11: pop
    //   12: aload_0
    //   13: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   16: aload_0
    //   17: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   20: aload_0
    //   21: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 529	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   29: lconst_0
    //   30: lstore 4
    //   32: new 444	java/lang/StringBuilder
    //   35: astore_2
    //   36: aload_2
    //   37: bipush 48
    //   39: invokespecial 453	java/lang/StringBuilder:<init>	(I)V
    //   42: aload_2
    //   43: ldc_w 531
    //   46: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc_w 526
    //   54: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: ldc_w 533
    //   62: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_0
    //   67: aload_2
    //   68: invokevirtual 465	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: iconst_1
    //   72: anewarray 21	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: aload_1
    //   78: aastore
    //   79: ldc2_w 534
    //   82: invokespecial 522	com/google/android/gms/measurement/internal/zzai:zzac	(Ljava/lang/String;[Ljava/lang/String;J)J
    //   85: lstore 6
    //   87: lload 6
    //   89: lstore 8
    //   91: lload 6
    //   93: ldc2_w 534
    //   96: lcmp
    //   97: ifne +93 -> 190
    //   100: new 263	android/content/ContentValues
    //   103: astore_2
    //   104: aload_2
    //   105: invokespecial 537	android/content/ContentValues:<init>	()V
    //   108: aload_2
    //   109: ldc_w 539
    //   112: aload_1
    //   113: invokevirtual 267	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: iconst_0
    //   117: invokestatic 418	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: astore 10
    //   122: aload_2
    //   123: ldc_w 526
    //   126: aload 10
    //   128: invokevirtual 542	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   131: aload_2
    //   132: ldc -65
    //   134: aload 10
    //   136: invokevirtual 542	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   139: aload_3
    //   140: ldc_w 544
    //   143: aconst_null
    //   144: aload_2
    //   145: iconst_5
    //   146: invokevirtual 548	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   149: ldc2_w 534
    //   152: lcmp
    //   153: ifne +34 -> 187
    //   156: aload_0
    //   157: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   160: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   163: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   166: ldc_w 550
    //   169: aload_1
    //   170: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   173: ldc_w 526
    //   176: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   179: aload_3
    //   180: invokevirtual 557	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   183: ldc2_w 534
    //   186: lreturn
    //   187: lconst_0
    //   188: lstore 8
    //   190: new 263	android/content/ContentValues
    //   193: astore_2
    //   194: aload_2
    //   195: invokespecial 537	android/content/ContentValues:<init>	()V
    //   198: aload_2
    //   199: ldc_w 539
    //   202: aload_1
    //   203: invokevirtual 267	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_2
    //   207: ldc_w 526
    //   210: lconst_1
    //   211: lload 8
    //   213: ladd
    //   214: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   217: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   220: aload_3
    //   221: ldc_w 544
    //   224: aload_2
    //   225: ldc_w 559
    //   228: iconst_1
    //   229: anewarray 21	java/lang/String
    //   232: dup
    //   233: iconst_0
    //   234: aload_1
    //   235: aastore
    //   236: invokevirtual 563	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   239: i2l
    //   240: lconst_0
    //   241: lcmp
    //   242: ifne +34 -> 276
    //   245: aload_0
    //   246: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   249: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   252: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   255: ldc_w 565
    //   258: aload_1
    //   259: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   262: ldc_w 526
    //   265: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   268: aload_3
    //   269: invokevirtual 557	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   272: ldc2_w 534
    //   275: lreturn
    //   276: aload_3
    //   277: invokevirtual 568	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   280: aload_3
    //   281: invokevirtual 557	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   284: goto +44 -> 328
    //   287: astore_2
    //   288: goto +12 -> 300
    //   291: astore_1
    //   292: goto +39 -> 331
    //   295: astore_2
    //   296: lload 4
    //   298: lstore 8
    //   300: aload_0
    //   301: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   304: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   307: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   310: ldc_w 570
    //   313: aload_1
    //   314: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   317: ldc_w 526
    //   320: aload_2
    //   321: invokevirtual 573	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   324: aload_3
    //   325: invokevirtual 557	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   328: lload 8
    //   330: lreturn
    //   331: aload_3
    //   332: invokevirtual 557	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   335: aload_1
    //   336: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	zzai
    //   0	337	1	paramString1	String
    //   0	337	2	paramString2	String
    //   24	308	3	localSQLiteDatabase	SQLiteDatabase
    //   30	267	4	l1	long
    //   85	7	6	l2	long
    //   89	240	8	l3	long
    //   120	15	10	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   190	268	287	android/database/sqlite/SQLiteException
    //   276	280	287	android/database/sqlite/SQLiteException
    //   32	87	291	finally
    //   100	179	291	finally
    //   190	268	291	finally
    //   276	280	291	finally
    //   300	324	291	finally
    //   32	87	295	android/database/sqlite/SQLiteException
    //   100	179	295	android/database/sqlite/SQLiteException
  }
  
  @WorkerThread
  public final long zzF()
  {
    return zzac("select max(timestamp) from raw_events", null, 0L);
  }
  
  public final boolean zzG()
  {
    return zzab("select count(1) > 0 from raw_events", null) != 0L;
  }
  
  public final boolean zzH()
  {
    return zzab("select count(1) > 0 from raw_events where realtime = 1", null) != 0L;
  }
  
  public final long zzI(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    return zzac("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { paramString }, 0L);
  }
  
  public final boolean zzJ(String paramString, Long paramLong, long paramLong1, zzfo paramzzfo)
  {
    zzg();
    zzZ();
    Preconditions.checkNotNull(paramzzfo);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramLong);
    paramzzfo = paramzzfo.zzbp();
    this.zzs.zzau().zzk().zzc("Saving complex main event, appId, data size", this.zzs.zzm().zzc(paramString), Integer.valueOf(paramzzfo.length));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramString);
    localContentValues.put("event_id", paramLong);
    localContentValues.put("children_to_process", Long.valueOf(paramLong1));
    localContentValues.put("main_event", paramzzfo);
    try
    {
      if (zze().insertWithOnConflict("main_event_params", null, localContentValues, 5) == -1L)
      {
        this.zzs.zzau().zzb().zzb("Failed to insert complex main event (got -1). appId", zzem.zzl(paramString));
        return false;
      }
      return true;
    }
    catch (SQLiteException paramLong)
    {
      this.zzs.zzau().zzb().zzc("Error storing complex main event. appId", zzem.zzl(paramString), paramLong);
    }
    return false;
  }
  
  /* Error */
  public final android.os.Bundle zzK(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   4: aload_0
    //   5: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc_w 625
    //   17: iconst_1
    //   18: anewarray 21	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: invokevirtual 298	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokeinterface 304 1 0
    //   37: ifne +29 -> 66
    //   40: aload_3
    //   41: astore_2
    //   42: aload_0
    //   43: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   46: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   49: invokevirtual 411	com/google/android/gms/measurement/internal/zzem:zzk	()Lcom/google/android/gms/measurement/internal/zzek;
    //   52: ldc_w 627
    //   55: invokevirtual 477	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   58: aload_3
    //   59: invokeinterface 311 1 0
    //   64: aconst_null
    //   65: areturn
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: iconst_0
    //   70: invokeinterface 631 2 0
    //   75: astore 4
    //   77: aload_3
    //   78: astore_2
    //   79: invokestatic 636	com/google/android/gms/internal/measurement/zzfo:zzk	()Lcom/google/android/gms/internal/measurement/zzfn;
    //   82: aload 4
    //   84: invokestatic 642	com/google/android/gms/measurement/internal/zzkp:zzt	(Lcom/google/android/gms/internal/measurement/zzlh;[B)Lcom/google/android/gms/internal/measurement/zzlh;
    //   87: checkcast 644	com/google/android/gms/internal/measurement/zzfn
    //   90: invokevirtual 650	com/google/android/gms/internal/measurement/zzjz:zzaA	()Lcom/google/android/gms/internal/measurement/zzkd;
    //   93: checkcast 633	com/google/android/gms/internal/measurement/zzfo
    //   96: astore 4
    //   98: aload_3
    //   99: astore_2
    //   100: aload_0
    //   101: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   104: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   107: pop
    //   108: aload_3
    //   109: astore_2
    //   110: aload 4
    //   112: invokevirtual 656	com/google/android/gms/internal/measurement/zzfo:zza	()Ljava/util/List;
    //   115: astore 4
    //   117: aload_3
    //   118: astore_2
    //   119: new 658	android/os/Bundle
    //   122: astore_1
    //   123: aload_3
    //   124: astore_2
    //   125: aload_1
    //   126: invokespecial 659	android/os/Bundle:<init>	()V
    //   129: aload_3
    //   130: astore_2
    //   131: aload 4
    //   133: invokeinterface 663 1 0
    //   138: astore 5
    //   140: aload_3
    //   141: astore_2
    //   142: aload 5
    //   144: invokeinterface 668 1 0
    //   149: ifeq +130 -> 279
    //   152: aload_3
    //   153: astore_2
    //   154: aload 5
    //   156: invokeinterface 672 1 0
    //   161: checkcast 674	com/google/android/gms/internal/measurement/zzfs
    //   164: astore 4
    //   166: aload_3
    //   167: astore_2
    //   168: aload 4
    //   170: invokevirtual 676	com/google/android/gms/internal/measurement/zzfs:zzb	()Ljava/lang/String;
    //   173: astore 6
    //   175: aload_3
    //   176: astore_2
    //   177: aload 4
    //   179: invokevirtual 678	com/google/android/gms/internal/measurement/zzfs:zzi	()Z
    //   182: ifeq +19 -> 201
    //   185: aload_3
    //   186: astore_2
    //   187: aload_1
    //   188: aload 6
    //   190: aload 4
    //   192: invokevirtual 681	com/google/android/gms/internal/measurement/zzfs:zzj	()D
    //   195: invokevirtual 685	android/os/Bundle:putDouble	(Ljava/lang/String;D)V
    //   198: goto -58 -> 140
    //   201: aload_3
    //   202: astore_2
    //   203: aload 4
    //   205: invokevirtual 687	com/google/android/gms/internal/measurement/zzfs:zzg	()Z
    //   208: ifeq +19 -> 227
    //   211: aload_3
    //   212: astore_2
    //   213: aload_1
    //   214: aload 6
    //   216: aload 4
    //   218: invokevirtual 690	com/google/android/gms/internal/measurement/zzfs:zzh	()F
    //   221: invokevirtual 694	android/os/Bundle:putFloat	(Ljava/lang/String;F)V
    //   224: goto -84 -> 140
    //   227: aload_3
    //   228: astore_2
    //   229: aload 4
    //   231: invokevirtual 696	com/google/android/gms/internal/measurement/zzfs:zzc	()Z
    //   234: ifeq +19 -> 253
    //   237: aload_3
    //   238: astore_2
    //   239: aload_1
    //   240: aload 6
    //   242: aload 4
    //   244: invokevirtual 698	com/google/android/gms/internal/measurement/zzfs:zzd	()Ljava/lang/String;
    //   247: invokevirtual 701	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: goto -110 -> 140
    //   253: aload_3
    //   254: astore_2
    //   255: aload 4
    //   257: invokevirtual 703	com/google/android/gms/internal/measurement/zzfs:zze	()Z
    //   260: ifeq -120 -> 140
    //   263: aload_3
    //   264: astore_2
    //   265: aload_1
    //   266: aload 6
    //   268: aload 4
    //   270: invokevirtual 705	com/google/android/gms/internal/measurement/zzfs:zzf	()J
    //   273: invokevirtual 709	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   276: goto -136 -> 140
    //   279: aload_3
    //   280: invokeinterface 311 1 0
    //   285: aload_1
    //   286: areturn
    //   287: astore 4
    //   289: aload_3
    //   290: astore_2
    //   291: aload_0
    //   292: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   295: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   298: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   301: ldc_w 711
    //   304: aload_1
    //   305: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   308: aload 4
    //   310: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   313: aload_3
    //   314: invokeinterface 311 1 0
    //   319: aconst_null
    //   320: areturn
    //   321: astore_2
    //   322: aload_3
    //   323: astore_1
    //   324: aload_2
    //   325: astore_3
    //   326: goto +12 -> 338
    //   329: astore_3
    //   330: aload_2
    //   331: astore_1
    //   332: goto +42 -> 374
    //   335: astore_3
    //   336: aconst_null
    //   337: astore_1
    //   338: aload_1
    //   339: astore_2
    //   340: aload_0
    //   341: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   344: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   347: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   350: ldc_w 713
    //   353: aload_3
    //   354: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   357: aload_1
    //   358: ifnull +9 -> 367
    //   361: aload_1
    //   362: invokeinterface 311 1 0
    //   367: aconst_null
    //   368: areturn
    //   369: astore_1
    //   370: aload_1
    //   371: astore_3
    //   372: aload_2
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull +9 -> 384
    //   378: aload_1
    //   379: invokeinterface 311 1 0
    //   384: aload_3
    //   385: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	zzai
    //   0	386	1	paramString	String
    //   9	282	2	localObject1	Object
    //   321	10	2	localSQLiteException1	SQLiteException
    //   339	34	2	str1	String
    //   28	298	3	localObject2	Object
    //   329	1	3	localObject3	Object
    //   335	19	3	localSQLiteException2	SQLiteException
    //   371	14	3	str2	String
    //   75	194	4	localObject4	Object
    //   287	22	4	localIOException	IOException
    //   138	17	5	localIterator	Iterator
    //   173	94	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   79	98	287	java/io/IOException
    //   31	40	321	android/database/sqlite/SQLiteException
    //   42	58	321	android/database/sqlite/SQLiteException
    //   68	77	321	android/database/sqlite/SQLiteException
    //   79	98	321	android/database/sqlite/SQLiteException
    //   100	108	321	android/database/sqlite/SQLiteException
    //   110	117	321	android/database/sqlite/SQLiteException
    //   119	123	321	android/database/sqlite/SQLiteException
    //   125	129	321	android/database/sqlite/SQLiteException
    //   131	140	321	android/database/sqlite/SQLiteException
    //   142	152	321	android/database/sqlite/SQLiteException
    //   154	166	321	android/database/sqlite/SQLiteException
    //   168	175	321	android/database/sqlite/SQLiteException
    //   177	185	321	android/database/sqlite/SQLiteException
    //   187	198	321	android/database/sqlite/SQLiteException
    //   203	211	321	android/database/sqlite/SQLiteException
    //   213	224	321	android/database/sqlite/SQLiteException
    //   229	237	321	android/database/sqlite/SQLiteException
    //   239	250	321	android/database/sqlite/SQLiteException
    //   255	263	321	android/database/sqlite/SQLiteException
    //   265	276	321	android/database/sqlite/SQLiteException
    //   291	313	321	android/database/sqlite/SQLiteException
    //   10	29	329	finally
    //   10	29	335	android/database/sqlite/SQLiteException
    //   31	40	369	finally
    //   42	58	369	finally
    //   68	77	369	finally
    //   79	98	369	finally
    //   100	108	369	finally
    //   110	117	369	finally
    //   119	123	369	finally
    //   125	129	369	finally
    //   131	140	369	finally
    //   142	152	369	finally
    //   154	166	369	finally
    //   168	175	369	finally
    //   177	185	369	finally
    //   187	198	369	finally
    //   203	211	369	finally
    //   213	224	369	finally
    //   229	237	369	finally
    //   239	250	369	finally
    //   255	263	369	finally
    //   265	276	369	finally
    //   291	313	369	finally
    //   340	357	369	finally
  }
  
  @WorkerThread
  final void zzL(String paramString, List<com.google.android.gms.internal.measurement.zzeh> paramList)
  {
    Object localObject1 = "app_id=? and audience_id=?";
    Preconditions.checkNotNull(paramList);
    Object localObject2;
    Object localObject3;
    Object localObject6;
    Object localObject8;
    int k;
    Object localObject9;
    for (int i = 0; i < paramList.size(); i++)
    {
      localObject2 = (zzeg)((com.google.android.gms.internal.measurement.zzeh)paramList.get(i)).zzbu();
      if (((zzeg)localObject2).zzd() != 0)
      {
        localObject3 = localObject2;
        int j = 0;
        while (j < ((zzeg)localObject3).zzd())
        {
          localObject6 = (zzei)((zzeg)localObject3).zze(j).zzbu();
          localObject7 = (zzei)((zzjz)localObject6).zzay();
          localObject8 = zzgr.zzb(((zzei)localObject6).zza());
          if (localObject8 != null)
          {
            ((zzei)localObject7).zzb((String)localObject8);
            k = 1;
          }
          else
          {
            k = 0;
          }
          int m = 0;
          int n = k;
          for (k = m; k < ((zzei)localObject6).zzc(); k++)
          {
            localObject9 = ((zzei)localObject6).zzd(k);
            localObject8 = zzic.zzc(((zzel)localObject9).zzh(), zzgs.zza, zzgs.zzb);
            if (localObject8 != null)
            {
              localObject9 = (com.google.android.gms.internal.measurement.zzek)((com.google.android.gms.internal.measurement.zzkd)localObject9).zzbu();
              ((com.google.android.gms.internal.measurement.zzek)localObject9).zza((String)localObject8);
              ((zzei)localObject7).zze(k, (zzel)((zzjz)localObject9).zzaA());
              n = 1;
            }
          }
          localObject6 = localObject3;
          if (n != 0)
          {
            ((zzeg)localObject3).zzf(j, (zzei)localObject7);
            paramList.set(i, (com.google.android.gms.internal.measurement.zzeh)((zzjz)localObject2).zzaA());
            localObject6 = localObject2;
          }
          j++;
          localObject3 = localObject6;
        }
      }
      else
      {
        localObject3 = localObject2;
      }
      if (((zzeg)localObject3).zza() != 0)
      {
        k = 0;
        while (k < ((zzeg)localObject3).zza())
        {
          localObject8 = ((zzeg)localObject3).zzb(k);
          localObject7 = zzic.zzc(((zzes)localObject8).zzc(), zzgt.zza, zzgt.zzb);
          localObject6 = localObject3;
          if (localObject7 != null)
          {
            localObject6 = (zzer)((com.google.android.gms.internal.measurement.zzkd)localObject8).zzbu();
            ((zzer)localObject6).zza((String)localObject7);
            ((zzeg)localObject3).zzc(k, (zzer)localObject6);
            paramList.set(i, (com.google.android.gms.internal.measurement.zzeh)((zzjz)localObject2).zzaA());
            localObject6 = localObject2;
          }
          k++;
          localObject3 = localObject6;
        }
      }
    }
    zzZ();
    zzg();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramList);
    Object localObject7 = zze();
    ((SQLiteDatabase)localObject7).beginTransaction();
    try
    {
      zzZ();
      zzg();
      Preconditions.checkNotEmpty(paramString);
      localObject2 = zze();
      ((SQLiteDatabase)localObject2).delete("property_filters", "app_id=?", new String[] { paramString });
      ((SQLiteDatabase)localObject2).delete("event_filters", "app_id=?", new String[] { paramString });
      localObject3 = paramList.iterator();
      localObject2 = localObject1;
      localObject1 = localObject3;
      label1372:
      label1448:
      while (((Iterator)localObject1).hasNext())
      {
        localObject6 = (com.google.android.gms.internal.measurement.zzeh)((Iterator)localObject1).next();
        zzZ();
        zzg();
        Preconditions.checkNotEmpty(paramString);
        Preconditions.checkNotNull(localObject6);
        boolean bool = ((com.google.android.gms.internal.measurement.zzeh)localObject6).zza();
        if (!bool) {}
        try
        {
          this.zzs.zzau().zze().zzb("Audience with no ID. appId", zzem.zzl(paramString));
        }
        finally
        {
          Object localObject10;
          Object localObject4;
          Object localObject5;
          long l;
          break label1839;
        }
        k = ((com.google.android.gms.internal.measurement.zzeh)localObject6).zzb();
        localObject3 = ((com.google.android.gms.internal.measurement.zzeh)localObject6).zzf().iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext()) {
            if (!((zzej)((Iterator)localObject3).next()).zza())
            {
              this.zzs.zzau().zze().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzem.zzl(paramString), Integer.valueOf(k));
              break;
            }
          }
        }
        localObject3 = ((com.google.android.gms.internal.measurement.zzeh)localObject6).zzc().iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext()) {
            if (!((zzes)((Iterator)localObject3).next()).zza())
            {
              this.zzs.zzau().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", zzem.zzl(paramString), Integer.valueOf(k));
              break;
            }
          }
        }
        localObject8 = ((com.google.android.gms.internal.measurement.zzeh)localObject6).zzf().iterator();
        for (;;)
        {
          bool = ((Iterator)localObject8).hasNext();
          if (bool)
          {
            zzej localzzej = (zzej)((Iterator)localObject8).next();
            zzZ();
            zzg();
            Preconditions.checkNotEmpty(paramString);
            Preconditions.checkNotNull(localzzej);
            if (TextUtils.isEmpty(localzzej.zzc()))
            {
              localObject8 = this.zzs.zzau().zze();
              localObject6 = zzem.zzl(paramString);
              if (localzzej.zza()) {
                localObject3 = Integer.valueOf(localzzej.zzb());
              } else {
                localObject3 = null;
              }
              ((zzek)localObject8).zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", localObject6, Integer.valueOf(k), String.valueOf(localObject3));
              break label1372;
            }
            localObject9 = localzzej.zzbp();
            localObject10 = new android/content/ContentValues;
            ((ContentValues)localObject10).<init>();
            ((ContentValues)localObject10).put("app_id", paramString);
            ((ContentValues)localObject10).put("audience_id", Integer.valueOf(k));
            if (localzzej.zza()) {
              localObject3 = Integer.valueOf(localzzej.zzb());
            } else {
              localObject3 = null;
            }
            ((ContentValues)localObject10).put("filter_id", (Integer)localObject3);
            ((ContentValues)localObject10).put("event_name", localzzej.zzc());
            if (localzzej.zzk()) {
              localObject3 = Boolean.valueOf(localzzej.zzm());
            } else {
              localObject3 = null;
            }
            ((ContentValues)localObject10).put("session_scoped", (Boolean)localObject3);
            ((ContentValues)localObject10).put("data", (byte[])localObject9);
            try
            {
              if (zze().insertWithOnConflict("event_filters", null, (ContentValues)localObject10, 5) == -1L) {
                this.zzs.zzau().zzb().zzb("Failed to insert event filter (got -1). appId", zzem.zzl(paramString));
              }
            }
            catch (SQLiteException localSQLiteException1)
            {
              this.zzs.zzau().zzb().zzc("Error storing event filter. appId", zzem.zzl(paramString), localSQLiteException1);
              break label1372;
            }
          }
        }
        localObject4 = ((com.google.android.gms.internal.measurement.zzeh)localObject6).zzc().iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label1448;
          }
          localObject10 = (zzes)((Iterator)localObject4).next();
          zzZ();
          zzg();
          Preconditions.checkNotEmpty(paramString);
          Preconditions.checkNotNull(localObject10);
          if (TextUtils.isEmpty(((zzes)localObject10).zzc()))
          {
            localObject6 = this.zzs.zzau().zze();
            localObject8 = zzem.zzl(paramString);
            if (((zzes)localObject10).zza()) {
              localObject4 = Integer.valueOf(((zzes)localObject10).zzb());
            } else {
              localObject4 = null;
            }
            ((zzek)localObject6).zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", localObject8, Integer.valueOf(k), String.valueOf(localObject4));
          }
          else
          {
            localObject8 = ((zzio)localObject10).zzbp();
            localObject9 = new android/content/ContentValues;
            ((ContentValues)localObject9).<init>();
            ((ContentValues)localObject9).put("app_id", paramString);
            ((ContentValues)localObject9).put("audience_id", Integer.valueOf(k));
            if (((zzes)localObject10).zza()) {
              localObject6 = Integer.valueOf(((zzes)localObject10).zzb());
            } else {
              localObject6 = null;
            }
            ((ContentValues)localObject9).put("filter_id", (Integer)localObject6);
            ((ContentValues)localObject9).put("property_name", ((zzes)localObject10).zzc());
            if (((zzes)localObject10).zzg()) {
              localObject6 = Boolean.valueOf(((zzes)localObject10).zzh());
            } else {
              localObject6 = null;
            }
            ((ContentValues)localObject9).put("session_scoped", (Boolean)localObject6);
            ((ContentValues)localObject9).put("data", (byte[])localObject8);
            try
            {
              if (zze().insertWithOnConflict("property_filters", null, (ContentValues)localObject9, 5) == -1L) {
                this.zzs.zzau().zzb().zzb("Failed to insert property filter (got -1). appId", zzem.zzl(paramString));
              }
            }
            catch (SQLiteException localSQLiteException2)
            {
              this.zzs.zzau().zzb().zzc("Error storing property filter. appId", zzem.zzl(paramString), localSQLiteException2);
            }
          }
        }
        zzZ();
        zzg();
        Preconditions.checkNotEmpty(paramString);
        localObject5 = zze();
        ((SQLiteDatabase)localObject5).delete("property_filters", (String)localObject2, new String[] { paramString, String.valueOf(k) });
        ((SQLiteDatabase)localObject5).delete("event_filters", (String)localObject2, new String[] { paramString, String.valueOf(k) });
      }
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramList = (com.google.android.gms.internal.measurement.zzeh)((Iterator)localObject2).next();
        if (paramList.zza()) {
          paramList = Integer.valueOf(paramList.zzb());
        } else {
          paramList = null;
        }
        ((List)localObject1).add(paramList);
      }
      Preconditions.checkNotEmpty(paramString);
      zzZ();
      zzg();
      paramList = zze();
      try
      {
        l = zzab("select count(1) from audience_filter_values where app_id=?", new String[] { paramString });
        i = Math.max(0, Math.min(2000, this.zzs.zzc().zzk(paramString, zzea.zzE)));
        if (l > i)
        {
          localObject2 = new java/util/ArrayList;
          ((ArrayList)localObject2).<init>();
          for (k = 0; k < ((List)localObject1).size(); k++)
          {
            localObject5 = (Integer)((List)localObject1).get(k);
            if (localObject5 == null) {
              break label1823;
            }
            ((List)localObject2).add(Integer.toString(((Integer)localObject5).intValue()));
          }
          localObject1 = TextUtils.join(",", (Iterable)localObject2);
          k = String.valueOf(localObject1).length();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(k + 2);
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(")");
          localObject1 = ((StringBuilder)localObject2).toString();
          k = String.valueOf(localObject1).length();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(k + 140);
          ((StringBuilder)localObject2).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" order by rowid desc limit -1 offset ?)");
          paramList.delete("audience_filter_values", ((StringBuilder)localObject2).toString(), new String[] { paramString, Integer.toString(i) });
        }
      }
      catch (SQLiteException paramList)
      {
        this.zzs.zzau().zzb().zzc("Database error querying filters. appId", zzem.zzl(paramString), paramList);
      }
      label1823:
      ((SQLiteDatabase)localObject7).setTransactionSuccessful();
      ((SQLiteDatabase)localObject7).endTransaction();
      return;
    }
    finally {}
    label1839:
    ((SQLiteDatabase)localObject7).endTransaction();
    throw paramString;
  }
  
  @VisibleForTesting
  protected final boolean zzM()
  {
    Context localContext = this.zzs.zzax();
    this.zzs.zzc();
    return localContext.getDatabasePath("google_app_measurement.db").exists();
  }
  
  /* Error */
  public final void zzW(String paramString, long paramLong1, long paramLong2, zzkm paramzzkm)
  {
    // Byte code:
    //   0: aload 6
    //   2: invokestatic 261	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5: pop
    //   6: aload_0
    //   7: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   10: aload_0
    //   11: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   14: aconst_null
    //   15: astore 7
    //   17: aconst_null
    //   18: astore 8
    //   20: aconst_null
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 10
    //   26: aload_0
    //   27: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 11
    //   32: aconst_null
    //   33: invokestatic 832	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore 12
    //   38: ldc_w 923
    //   41: astore_1
    //   42: iload 12
    //   44: ifeq +242 -> 286
    //   47: lload 4
    //   49: ldc2_w 534
    //   52: lcmp
    //   53: istore 13
    //   55: iload 13
    //   57: ifeq +29 -> 86
    //   60: iconst_2
    //   61: anewarray 21	java/lang/String
    //   64: astore 14
    //   66: aload 14
    //   68: iconst_0
    //   69: lload 4
    //   71: invokestatic 401	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   74: aastore
    //   75: aload 14
    //   77: iconst_1
    //   78: lload_2
    //   79: invokestatic 401	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: aastore
    //   83: goto +17 -> 100
    //   86: iconst_1
    //   87: anewarray 21	java/lang/String
    //   90: astore 14
    //   92: aload 14
    //   94: iconst_0
    //   95: lload_2
    //   96: invokestatic 401	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   99: aastore
    //   100: iload 13
    //   102: ifeq +7 -> 109
    //   105: ldc_w 925
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 450	java/lang/String:length	()I
    //   113: istore 13
    //   115: new 444	java/lang/StringBuilder
    //   118: astore 7
    //   120: aload 7
    //   122: iload 13
    //   124: sipush 148
    //   127: iadd
    //   128: invokespecial 453	java/lang/StringBuilder:<init>	(I)V
    //   131: aload 7
    //   133: ldc_w 927
    //   136: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 7
    //   142: aload_1
    //   143: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 7
    //   149: ldc_w 929
    //   152: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 11
    //   158: aload 7
    //   160: invokevirtual 465	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aload 14
    //   165: invokevirtual 298	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   168: astore 7
    //   170: aload 10
    //   172: astore 9
    //   174: aload 7
    //   176: astore 8
    //   178: aload 7
    //   180: astore_1
    //   181: aload 7
    //   183: invokeinterface 304 1 0
    //   188: istore 12
    //   190: iload 12
    //   192: ifne +11 -> 203
    //   195: aload 7
    //   197: invokeinterface 311 1 0
    //   202: return
    //   203: aload 10
    //   205: astore 9
    //   207: aload 7
    //   209: astore 8
    //   211: aload 7
    //   213: astore_1
    //   214: aload 7
    //   216: iconst_0
    //   217: invokeinterface 505 2 0
    //   222: astore 14
    //   224: aload 14
    //   226: astore 9
    //   228: aload 7
    //   230: astore 8
    //   232: aload 7
    //   234: astore_1
    //   235: aload 7
    //   237: iconst_1
    //   238: invokeinterface 505 2 0
    //   243: astore 10
    //   245: aload 14
    //   247: astore 9
    //   249: aload 7
    //   251: astore 8
    //   253: aload 7
    //   255: astore_1
    //   256: aload 7
    //   258: invokeinterface 311 1 0
    //   263: aload 7
    //   265: astore_1
    //   266: aload 10
    //   268: astore 9
    //   270: goto +214 -> 484
    //   273: astore 7
    //   275: aload 9
    //   277: astore 14
    //   279: aload 8
    //   281: astore 6
    //   283: goto +849 -> 1132
    //   286: lload 4
    //   288: ldc2_w 534
    //   291: lcmp
    //   292: istore 13
    //   294: iload 13
    //   296: ifeq +26 -> 322
    //   299: iconst_2
    //   300: anewarray 21	java/lang/String
    //   303: astore 14
    //   305: aload 14
    //   307: iconst_0
    //   308: aconst_null
    //   309: aastore
    //   310: aload 14
    //   312: iconst_1
    //   313: lload 4
    //   315: invokestatic 401	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   318: aastore
    //   319: goto +13 -> 332
    //   322: iconst_1
    //   323: anewarray 21	java/lang/String
    //   326: dup
    //   327: iconst_0
    //   328: aconst_null
    //   329: aastore
    //   330: astore 14
    //   332: iload 13
    //   334: ifeq +7 -> 341
    //   337: ldc_w 931
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 450	java/lang/String:length	()I
    //   345: istore 13
    //   347: new 444	java/lang/StringBuilder
    //   350: astore 15
    //   352: aload 15
    //   354: iload 13
    //   356: bipush 84
    //   358: iadd
    //   359: invokespecial 453	java/lang/StringBuilder:<init>	(I)V
    //   362: aload 15
    //   364: ldc_w 933
    //   367: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 15
    //   373: aload_1
    //   374: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 15
    //   380: ldc_w 935
    //   383: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 11
    //   389: aload 15
    //   391: invokevirtual 465	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: aload 14
    //   396: invokevirtual 298	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   399: astore 14
    //   401: aload 10
    //   403: astore 9
    //   405: aload 14
    //   407: astore 8
    //   409: aload 14
    //   411: astore_1
    //   412: aload 14
    //   414: invokeinterface 304 1 0
    //   419: istore 12
    //   421: iload 12
    //   423: ifne +11 -> 434
    //   426: aload 14
    //   428: invokeinterface 311 1 0
    //   433: return
    //   434: aload 10
    //   436: astore 9
    //   438: aload 14
    //   440: astore 8
    //   442: aload 14
    //   444: astore_1
    //   445: aload 14
    //   447: iconst_0
    //   448: invokeinterface 505 2 0
    //   453: astore 15
    //   455: aload 10
    //   457: astore 9
    //   459: aload 14
    //   461: astore 8
    //   463: aload 14
    //   465: astore_1
    //   466: aload 14
    //   468: invokeinterface 311 1 0
    //   473: aload 15
    //   475: astore 9
    //   477: aload 14
    //   479: astore_1
    //   480: aload 7
    //   482: astore 14
    //   484: aload 11
    //   486: ldc_w 937
    //   489: iconst_1
    //   490: anewarray 21	java/lang/String
    //   493: dup
    //   494: iconst_0
    //   495: ldc_w 939
    //   498: aastore
    //   499: ldc_w 941
    //   502: iconst_2
    //   503: anewarray 21	java/lang/String
    //   506: dup
    //   507: iconst_0
    //   508: aload 14
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload 9
    //   515: aastore
    //   516: aconst_null
    //   517: aconst_null
    //   518: ldc_w 943
    //   521: ldc_w 945
    //   524: invokevirtual 949	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   527: astore 8
    //   529: aload 8
    //   531: invokeinterface 304 1 0
    //   536: ifne +32 -> 568
    //   539: aload_0
    //   540: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   543: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   546: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   549: ldc_w 951
    //   552: aload 14
    //   554: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   557: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   560: aload 8
    //   562: invokeinterface 311 1 0
    //   567: return
    //   568: aload 8
    //   570: iconst_0
    //   571: invokeinterface 631 2 0
    //   576: astore_1
    //   577: invokestatic 957	com/google/android/gms/internal/measurement/zzfw:zzaj	()Lcom/google/android/gms/internal/measurement/zzfv;
    //   580: aload_1
    //   581: invokestatic 642	com/google/android/gms/measurement/internal/zzkp:zzt	(Lcom/google/android/gms/internal/measurement/zzlh;[B)Lcom/google/android/gms/internal/measurement/zzlh;
    //   584: checkcast 959	com/google/android/gms/internal/measurement/zzfv
    //   587: invokevirtual 650	com/google/android/gms/internal/measurement/zzjz:zzaA	()Lcom/google/android/gms/internal/measurement/zzkd;
    //   590: checkcast 953	com/google/android/gms/internal/measurement/zzfw
    //   593: astore_1
    //   594: aload 8
    //   596: invokeinterface 962 1 0
    //   601: ifeq +24 -> 625
    //   604: aload_0
    //   605: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   608: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   611: invokevirtual 473	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   614: ldc_w 964
    //   617: aload 14
    //   619: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   622: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   625: aload 8
    //   627: invokeinterface 311 1 0
    //   632: aload_1
    //   633: invokestatic 261	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   636: pop
    //   637: aload 6
    //   639: aload_1
    //   640: putfield 969	com/google/android/gms/measurement/internal/zzkm:zza	Lcom/google/android/gms/internal/measurement/zzfw;
    //   643: lload 4
    //   645: ldc2_w 534
    //   648: lcmp
    //   649: ifeq +34 -> 683
    //   652: ldc_w 971
    //   655: astore_1
    //   656: iconst_3
    //   657: anewarray 21	java/lang/String
    //   660: dup
    //   661: iconst_0
    //   662: aload 14
    //   664: aastore
    //   665: dup
    //   666: iconst_1
    //   667: aload 9
    //   669: aastore
    //   670: dup
    //   671: iconst_2
    //   672: lload 4
    //   674: invokestatic 401	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   677: aastore
    //   678: astore 9
    //   680: goto +23 -> 703
    //   683: ldc_w 941
    //   686: astore_1
    //   687: iconst_2
    //   688: anewarray 21	java/lang/String
    //   691: dup
    //   692: iconst_0
    //   693: aload 14
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: aload 9
    //   700: aastore
    //   701: astore 9
    //   703: aload 11
    //   705: ldc_w 973
    //   708: iconst_4
    //   709: anewarray 21	java/lang/String
    //   712: dup
    //   713: iconst_0
    //   714: ldc_w 943
    //   717: aastore
    //   718: dup
    //   719: iconst_1
    //   720: ldc_w 975
    //   723: aastore
    //   724: dup
    //   725: iconst_2
    //   726: ldc_w 977
    //   729: aastore
    //   730: dup
    //   731: iconst_3
    //   732: ldc_w 855
    //   735: aastore
    //   736: aload_1
    //   737: aload 9
    //   739: aconst_null
    //   740: aconst_null
    //   741: ldc_w 943
    //   744: aconst_null
    //   745: invokevirtual 949	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   748: astore 7
    //   750: aload 14
    //   752: astore 9
    //   754: aload 7
    //   756: astore 8
    //   758: aload 7
    //   760: astore_1
    //   761: aload 7
    //   763: invokeinterface 304 1 0
    //   768: ifeq +227 -> 995
    //   771: aload 14
    //   773: astore 9
    //   775: aload 7
    //   777: astore 8
    //   779: aload 7
    //   781: astore_1
    //   782: aload 7
    //   784: iconst_0
    //   785: invokeinterface 308 2 0
    //   790: lstore_2
    //   791: aload 14
    //   793: astore 9
    //   795: aload 7
    //   797: astore 8
    //   799: aload 7
    //   801: astore_1
    //   802: aload 7
    //   804: iconst_3
    //   805: invokeinterface 631 2 0
    //   810: astore 10
    //   812: aload 14
    //   814: astore 9
    //   816: aload 7
    //   818: astore 8
    //   820: aload 7
    //   822: astore_1
    //   823: invokestatic 636	com/google/android/gms/internal/measurement/zzfo:zzk	()Lcom/google/android/gms/internal/measurement/zzfn;
    //   826: aload 10
    //   828: invokestatic 642	com/google/android/gms/measurement/internal/zzkp:zzt	(Lcom/google/android/gms/internal/measurement/zzlh;[B)Lcom/google/android/gms/internal/measurement/zzlh;
    //   831: checkcast 644	com/google/android/gms/internal/measurement/zzfn
    //   834: astore 10
    //   836: aload 14
    //   838: astore 9
    //   840: aload 7
    //   842: astore 8
    //   844: aload 7
    //   846: astore_1
    //   847: aload 10
    //   849: aload 7
    //   851: iconst_1
    //   852: invokeinterface 505 2 0
    //   857: invokevirtual 980	com/google/android/gms/internal/measurement/zzfn:zzl	(Ljava/lang/String;)Lcom/google/android/gms/internal/measurement/zzfn;
    //   860: pop
    //   861: aload 14
    //   863: astore 9
    //   865: aload 7
    //   867: astore 8
    //   869: aload 7
    //   871: astore_1
    //   872: aload 10
    //   874: aload 7
    //   876: iconst_2
    //   877: invokeinterface 308 2 0
    //   882: invokevirtual 984	com/google/android/gms/internal/measurement/zzfn:zzo	(J)Lcom/google/android/gms/internal/measurement/zzfn;
    //   885: pop
    //   886: aload 14
    //   888: astore 9
    //   890: aload 7
    //   892: astore 8
    //   894: aload 7
    //   896: astore_1
    //   897: aload 6
    //   899: lload_2
    //   900: aload 10
    //   902: invokevirtual 650	com/google/android/gms/internal/measurement/zzjz:zzaA	()Lcom/google/android/gms/internal/measurement/zzkd;
    //   905: checkcast 633	com/google/android/gms/internal/measurement/zzfo
    //   908: invokevirtual 987	com/google/android/gms/measurement/internal/zzkm:zza	(JLcom/google/android/gms/internal/measurement/zzfo;)Z
    //   911: istore 12
    //   913: iload 12
    //   915: ifne +47 -> 962
    //   918: aload 7
    //   920: invokeinterface 311 1 0
    //   925: return
    //   926: astore 10
    //   928: aload 14
    //   930: astore 9
    //   932: aload 7
    //   934: astore 8
    //   936: aload 7
    //   938: astore_1
    //   939: aload_0
    //   940: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   943: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   946: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   949: ldc_w 989
    //   952: aload 14
    //   954: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   957: aload 10
    //   959: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   962: aload 14
    //   964: astore 9
    //   966: aload 7
    //   968: astore 8
    //   970: aload 7
    //   972: astore_1
    //   973: aload 7
    //   975: invokeinterface 962 1 0
    //   980: istore 12
    //   982: iload 12
    //   984: ifne -213 -> 771
    //   987: aload 7
    //   989: invokeinterface 311 1 0
    //   994: return
    //   995: aload 14
    //   997: astore 9
    //   999: aload 7
    //   1001: astore 8
    //   1003: aload 7
    //   1005: astore_1
    //   1006: aload_0
    //   1007: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   1010: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1013: invokevirtual 473	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   1016: ldc_w 991
    //   1019: aload 14
    //   1021: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   1024: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1027: aload 7
    //   1029: invokeinterface 311 1 0
    //   1034: return
    //   1035: astore_1
    //   1036: aload_0
    //   1037: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   1040: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1043: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   1046: ldc_w 993
    //   1049: aload 14
    //   1051: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   1054: aload_1
    //   1055: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1058: aload 8
    //   1060: invokeinterface 311 1 0
    //   1065: return
    //   1066: astore_1
    //   1067: goto +9 -> 1076
    //   1070: astore 7
    //   1072: goto +13 -> 1085
    //   1075: astore_1
    //   1076: aload 8
    //   1078: astore 6
    //   1080: goto +99 -> 1179
    //   1083: astore 7
    //   1085: aload 8
    //   1087: astore 6
    //   1089: goto +43 -> 1132
    //   1092: astore 6
    //   1094: aload_1
    //   1095: astore 14
    //   1097: aload 6
    //   1099: astore_1
    //   1100: aload 14
    //   1102: astore 6
    //   1104: goto +75 -> 1179
    //   1107: astore 7
    //   1109: aload_1
    //   1110: astore 6
    //   1112: goto +20 -> 1132
    //   1115: astore_1
    //   1116: aload 9
    //   1118: astore 6
    //   1120: goto +59 -> 1179
    //   1123: astore 7
    //   1125: aconst_null
    //   1126: astore 6
    //   1128: aload 8
    //   1130: astore 14
    //   1132: aload 6
    //   1134: astore_1
    //   1135: aload_0
    //   1136: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   1139: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1142: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   1145: ldc_w 995
    //   1148: aload 14
    //   1150: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   1153: aload 7
    //   1155: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1158: aload 6
    //   1160: ifnull +10 -> 1170
    //   1163: aload 6
    //   1165: invokeinterface 311 1 0
    //   1170: return
    //   1171: astore 14
    //   1173: aload_1
    //   1174: astore 6
    //   1176: aload 14
    //   1178: astore_1
    //   1179: aload 6
    //   1181: ifnull +10 -> 1191
    //   1184: aload 6
    //   1186: invokeinterface 311 1 0
    //   1191: aload_1
    //   1192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1193	0	this	zzai
    //   0	1193	1	paramString	String
    //   0	1193	2	paramLong1	long
    //   0	1193	4	paramLong2	long
    //   0	1193	6	paramzzkm	zzkm
    //   15	249	7	localObject1	Object
    //   273	208	7	localSQLiteException1	SQLiteException
    //   748	280	7	localCursor	Cursor
    //   1070	1	7	localSQLiteException2	SQLiteException
    //   1083	1	7	localSQLiteException3	SQLiteException
    //   1107	1	7	localSQLiteException4	SQLiteException
    //   1123	31	7	localSQLiteException5	SQLiteException
    //   18	1111	8	localObject2	Object
    //   21	1096	9	localObject3	Object
    //   24	877	10	localObject4	Object
    //   926	32	10	localIOException	IOException
    //   30	674	11	localSQLiteDatabase	SQLiteDatabase
    //   36	947	12	bool1	boolean
    //   53	48	13	bool2	boolean
    //   113	15	13	i	int
    //   292	41	13	bool3	boolean
    //   345	14	13	j	int
    //   64	1085	14	localObject5	Object
    //   1171	6	14	localObject6	Object
    //   350	124	15	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   181	190	273	android/database/sqlite/SQLiteException
    //   214	224	273	android/database/sqlite/SQLiteException
    //   235	245	273	android/database/sqlite/SQLiteException
    //   256	263	273	android/database/sqlite/SQLiteException
    //   412	421	273	android/database/sqlite/SQLiteException
    //   445	455	273	android/database/sqlite/SQLiteException
    //   466	473	273	android/database/sqlite/SQLiteException
    //   761	771	273	android/database/sqlite/SQLiteException
    //   782	791	273	android/database/sqlite/SQLiteException
    //   802	812	273	android/database/sqlite/SQLiteException
    //   823	836	273	android/database/sqlite/SQLiteException
    //   847	861	273	android/database/sqlite/SQLiteException
    //   872	886	273	android/database/sqlite/SQLiteException
    //   897	913	273	android/database/sqlite/SQLiteException
    //   939	962	273	android/database/sqlite/SQLiteException
    //   973	982	273	android/database/sqlite/SQLiteException
    //   1006	1027	273	android/database/sqlite/SQLiteException
    //   823	836	926	java/io/IOException
    //   577	594	1035	java/io/IOException
    //   703	750	1066	finally
    //   1036	1058	1066	finally
    //   703	750	1070	android/database/sqlite/SQLiteException
    //   1036	1058	1070	android/database/sqlite/SQLiteException
    //   529	560	1075	finally
    //   568	577	1075	finally
    //   577	594	1075	finally
    //   594	625	1075	finally
    //   625	643	1075	finally
    //   656	680	1075	finally
    //   687	703	1075	finally
    //   529	560	1083	android/database/sqlite/SQLiteException
    //   568	577	1083	android/database/sqlite/SQLiteException
    //   577	594	1083	android/database/sqlite/SQLiteException
    //   594	625	1083	android/database/sqlite/SQLiteException
    //   625	643	1083	android/database/sqlite/SQLiteException
    //   656	680	1083	android/database/sqlite/SQLiteException
    //   687	703	1083	android/database/sqlite/SQLiteException
    //   484	529	1092	finally
    //   484	529	1107	android/database/sqlite/SQLiteException
    //   26	38	1115	finally
    //   60	83	1115	finally
    //   86	100	1115	finally
    //   109	170	1115	finally
    //   299	305	1115	finally
    //   310	319	1115	finally
    //   322	332	1115	finally
    //   341	401	1115	finally
    //   26	38	1123	android/database/sqlite/SQLiteException
    //   60	83	1123	android/database/sqlite/SQLiteException
    //   86	100	1123	android/database/sqlite/SQLiteException
    //   109	170	1123	android/database/sqlite/SQLiteException
    //   299	305	1123	android/database/sqlite/SQLiteException
    //   310	319	1123	android/database/sqlite/SQLiteException
    //   322	332	1123	android/database/sqlite/SQLiteException
    //   341	401	1123	android/database/sqlite/SQLiteException
    //   181	190	1171	finally
    //   214	224	1171	finally
    //   235	245	1171	finally
    //   256	263	1171	finally
    //   412	421	1171	finally
    //   445	455	1171	finally
    //   466	473	1171	finally
    //   761	771	1171	finally
    //   782	791	1171	finally
    //   802	812	1171	finally
    //   823	836	1171	finally
    //   847	861	1171	finally
    //   872	886	1171	finally
    //   897	913	1171	finally
    //   939	962	1171	finally
    //   973	982	1171	finally
    //   1006	1027	1171	finally
    //   1135	1158	1171	finally
  }
  
  protected final boolean zzaA()
  {
    return false;
  }
  
  @WorkerThread
  public final void zzb()
  {
    zzZ();
    zze().beginTransaction();
  }
  
  @WorkerThread
  public final void zzc()
  {
    zzZ();
    zze().setTransactionSuccessful();
  }
  
  @WorkerThread
  public final void zzd()
  {
    zzZ();
    zze().endTransaction();
  }
  
  @WorkerThread
  @VisibleForTesting
  final SQLiteDatabase zze()
  {
    zzg();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzj.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.zzs.zzau().zze().zzb("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  /* Error */
  @WorkerThread
  public final zzao zzf(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   14: aload_0
    //   15: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   18: new 875	java/util/ArrayList
    //   21: dup
    //   22: bipush 9
    //   24: anewarray 21	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc_w 1003
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: ldc_w 1005
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc_w 1007
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 23
    //   49: aastore
    //   50: dup
    //   51: iconst_4
    //   52: ldc 27
    //   54: aastore
    //   55: dup
    //   56: iconst_5
    //   57: ldc 31
    //   59: aastore
    //   60: dup
    //   61: bipush 6
    //   63: ldc 35
    //   65: aastore
    //   66: dup
    //   67: bipush 7
    //   69: ldc 39
    //   71: aastore
    //   72: dup
    //   73: bipush 8
    //   75: ldc 43
    //   77: aastore
    //   78: invokestatic 1013	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   81: invokespecial 1016	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   84: astore_3
    //   85: aconst_null
    //   86: astore 4
    //   88: aload_0
    //   89: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   92: astore 5
    //   94: iconst_0
    //   95: istore 6
    //   97: aload 5
    //   99: ldc_w 1018
    //   102: aload_3
    //   103: iconst_0
    //   104: anewarray 21	java/lang/String
    //   107: invokevirtual 1022	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   110: checkcast 1023	[Ljava/lang/String;
    //   113: ldc_w 1025
    //   116: iconst_2
    //   117: anewarray 21	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: aload_1
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_2
    //   127: aastore
    //   128: aconst_null
    //   129: aconst_null
    //   130: aconst_null
    //   131: invokevirtual 1028	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   134: astore 5
    //   136: aload 5
    //   138: invokeinterface 304 1 0
    //   143: istore 7
    //   145: iload 7
    //   147: ifne +12 -> 159
    //   150: aload 5
    //   152: invokeinterface 311 1 0
    //   157: aconst_null
    //   158: areturn
    //   159: aload 5
    //   161: iconst_0
    //   162: invokeinterface 308 2 0
    //   167: lstore 8
    //   169: aload 5
    //   171: iconst_1
    //   172: invokeinterface 308 2 0
    //   177: lstore 10
    //   179: aload 5
    //   181: iconst_2
    //   182: invokeinterface 308 2 0
    //   187: lstore 12
    //   189: aload 5
    //   191: iconst_3
    //   192: invokeinterface 1032 2 0
    //   197: ifeq +9 -> 206
    //   200: lconst_0
    //   201: lstore 14
    //   203: goto +13 -> 216
    //   206: aload 5
    //   208: iconst_3
    //   209: invokeinterface 308 2 0
    //   214: lstore 14
    //   216: aload 5
    //   218: iconst_4
    //   219: invokeinterface 1032 2 0
    //   224: ifeq +9 -> 233
    //   227: aconst_null
    //   228: astore 4
    //   230: goto +16 -> 246
    //   233: aload 5
    //   235: iconst_4
    //   236: invokeinterface 308 2 0
    //   241: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: astore 4
    //   246: aload 5
    //   248: iconst_5
    //   249: invokeinterface 1032 2 0
    //   254: ifeq +8 -> 262
    //   257: aconst_null
    //   258: astore_3
    //   259: goto +15 -> 274
    //   262: aload 5
    //   264: iconst_5
    //   265: invokeinterface 308 2 0
    //   270: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: astore_3
    //   274: aload 5
    //   276: bipush 6
    //   278: invokeinterface 1032 2 0
    //   283: ifeq +9 -> 292
    //   286: aconst_null
    //   287: astore 16
    //   289: goto +17 -> 306
    //   292: aload 5
    //   294: bipush 6
    //   296: invokeinterface 308 2 0
    //   301: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   304: astore 16
    //   306: aload 5
    //   308: bipush 7
    //   310: invokeinterface 1032 2 0
    //   315: ifne +30 -> 345
    //   318: aload 5
    //   320: bipush 7
    //   322: invokeinterface 308 2 0
    //   327: lconst_1
    //   328: lcmp
    //   329: ifne +6 -> 335
    //   332: iconst_1
    //   333: istore 6
    //   335: iload 6
    //   337: invokestatic 850	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   340: astore 17
    //   342: goto +6 -> 348
    //   345: aconst_null
    //   346: astore 17
    //   348: aload 5
    //   350: bipush 8
    //   352: invokeinterface 1032 2 0
    //   357: ifeq +9 -> 366
    //   360: lconst_0
    //   361: lstore 18
    //   363: goto +14 -> 377
    //   366: aload 5
    //   368: bipush 8
    //   370: invokeinterface 308 2 0
    //   375: lstore 18
    //   377: new 1034	com/google/android/gms/measurement/internal/zzao
    //   380: astore 20
    //   382: aload 5
    //   384: astore 21
    //   386: aload 20
    //   388: aload_1
    //   389: aload_2
    //   390: lload 8
    //   392: lload 10
    //   394: lload 18
    //   396: lload 12
    //   398: lload 14
    //   400: aload 4
    //   402: aload_3
    //   403: aload 16
    //   405: aload 17
    //   407: invokespecial 1037	com/google/android/gms/measurement/internal/zzao:<init>	(Ljava/lang/String;Ljava/lang/String;JJJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V
    //   410: aload 21
    //   412: invokeinterface 962 1 0
    //   417: ifeq +23 -> 440
    //   420: aload_0
    //   421: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   424: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   427: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   430: ldc_w 1039
    //   433: aload_1
    //   434: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   437: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   440: aload 21
    //   442: invokeinterface 311 1 0
    //   447: aload 20
    //   449: areturn
    //   450: astore_1
    //   451: goto +9 -> 460
    //   454: astore 4
    //   456: goto +12 -> 468
    //   459: astore_1
    //   460: aload 5
    //   462: astore_2
    //   463: goto +71 -> 534
    //   466: astore 4
    //   468: goto +15 -> 483
    //   471: astore_1
    //   472: aload 4
    //   474: astore_2
    //   475: goto +59 -> 534
    //   478: astore 4
    //   480: aconst_null
    //   481: astore 5
    //   483: aload_0
    //   484: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   487: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   490: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   493: ldc_w 1041
    //   496: aload_1
    //   497: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   500: aload_0
    //   501: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   504: invokevirtual 600	com/google/android/gms/measurement/internal/zzfu:zzm	()Lcom/google/android/gms/measurement/internal/zzeh;
    //   507: aload_2
    //   508: invokevirtual 604	com/google/android/gms/measurement/internal/zzeh:zzc	(Ljava/lang/String;)Ljava/lang/String;
    //   511: aload 4
    //   513: invokevirtual 573	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   516: aload 5
    //   518: ifnull +10 -> 528
    //   521: aload 5
    //   523: invokeinterface 311 1 0
    //   528: aconst_null
    //   529: areturn
    //   530: astore_1
    //   531: aload 5
    //   533: astore_2
    //   534: aload_2
    //   535: ifnull +9 -> 544
    //   538: aload_2
    //   539: invokeinterface 311 1 0
    //   544: aload_1
    //   545: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	zzai
    //   0	546	1	paramString1	String
    //   0	546	2	paramString2	String
    //   84	319	3	localObject1	Object
    //   86	315	4	localLong1	Long
    //   454	1	4	localSQLiteException1	SQLiteException
    //   466	7	4	localSQLiteException2	SQLiteException
    //   478	34	4	localSQLiteException3	SQLiteException
    //   92	440	5	localObject2	Object
    //   95	241	6	bool1	boolean
    //   143	3	7	bool2	boolean
    //   167	224	8	l1	long
    //   177	216	10	l2	long
    //   187	210	12	l3	long
    //   201	198	14	l4	long
    //   287	117	16	localLong2	Long
    //   340	66	17	localBoolean	Boolean
    //   361	34	18	l5	long
    //   380	68	20	localzzao	zzao
    //   384	57	21	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   386	440	450	finally
    //   386	440	454	android/database/sqlite/SQLiteException
    //   136	145	459	finally
    //   159	200	459	finally
    //   206	216	459	finally
    //   216	227	459	finally
    //   233	246	459	finally
    //   246	257	459	finally
    //   262	274	459	finally
    //   274	286	459	finally
    //   292	306	459	finally
    //   306	318	459	finally
    //   318	332	459	finally
    //   335	342	459	finally
    //   348	360	459	finally
    //   366	377	459	finally
    //   377	382	459	finally
    //   136	145	466	android/database/sqlite/SQLiteException
    //   159	200	466	android/database/sqlite/SQLiteException
    //   206	216	466	android/database/sqlite/SQLiteException
    //   216	227	466	android/database/sqlite/SQLiteException
    //   233	246	466	android/database/sqlite/SQLiteException
    //   246	257	466	android/database/sqlite/SQLiteException
    //   262	274	466	android/database/sqlite/SQLiteException
    //   274	286	466	android/database/sqlite/SQLiteException
    //   292	306	466	android/database/sqlite/SQLiteException
    //   306	318	466	android/database/sqlite/SQLiteException
    //   318	332	466	android/database/sqlite/SQLiteException
    //   335	342	466	android/database/sqlite/SQLiteException
    //   348	360	466	android/database/sqlite/SQLiteException
    //   366	377	466	android/database/sqlite/SQLiteException
    //   377	382	466	android/database/sqlite/SQLiteException
    //   88	94	471	finally
    //   97	136	471	finally
    //   88	94	478	android/database/sqlite/SQLiteException
    //   97	136	478	android/database/sqlite/SQLiteException
    //   483	516	530	finally
  }
  
  @WorkerThread
  public final void zzh(zzao paramzzao)
  {
    Preconditions.checkNotNull(paramzzao);
    zzg();
    zzZ();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzao.zza);
    localContentValues.put("name", paramzzao.zzb);
    localContentValues.put("lifetime_count", Long.valueOf(paramzzao.zzc));
    localContentValues.put("current_bundle_count", Long.valueOf(paramzzao.zzd));
    localContentValues.put("last_fire_timestamp", Long.valueOf(paramzzao.zzf));
    localContentValues.put("last_bundled_timestamp", Long.valueOf(paramzzao.zzg));
    localContentValues.put("last_bundled_day", paramzzao.zzh);
    localContentValues.put("last_sampled_complex_event_id", paramzzao.zzi);
    localContentValues.put("last_sampling_rate", paramzzao.zzj);
    localContentValues.put("current_session_count", Long.valueOf(paramzzao.zze));
    Object localObject = paramzzao.zzk;
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      localObject = Long.valueOf(1L);
    } else {
      localObject = null;
    }
    localContentValues.put("last_exempt_from_sampling", (Long)localObject);
    try
    {
      if (zze().insertWithOnConflict("events", null, localContentValues, 5) == -1L) {
        this.zzs.zzau().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzem.zzl(paramzzao.zza));
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.zzs.zzau().zzb().zzc("Error storing event aggregates. appId", zzem.zzl(paramzzao.zza), localSQLiteException);
    }
  }
  
  @WorkerThread
  public final void zzi(String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzg();
    zzZ();
    try
    {
      zze().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.zzs.zzau().zzb().zzd("Error deleting user property. appId", zzem.zzl(paramString1), this.zzs.zzm().zze(paramString2), localSQLiteException);
    }
  }
  
  @WorkerThread
  public final boolean zzj(zzks paramzzks)
  {
    Preconditions.checkNotNull(paramzzks);
    zzg();
    zzZ();
    if (zzk(paramzzks.zza, paramzzks.zzc) == null) {
      if (zzku.zzh(paramzzks.zzc))
      {
        if (zzab("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { paramzzks.zza }) >= this.zzs.zzc().zzl(paramzzks.zza, zzea.zzF, 25, 100)) {
          return false;
        }
      }
      else if (!"_npa".equals(paramzzks.zzc))
      {
        long l = zzab("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { paramzzks.zza, paramzzks.zzb });
        this.zzs.zzc();
        if (l >= 25L) {
          return false;
        }
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzks.zza);
    localContentValues.put("origin", paramzzks.zzb);
    localContentValues.put("name", paramzzks.zzc);
    localContentValues.put("set_timestamp", Long.valueOf(paramzzks.zzd));
    zzX(localContentValues, "value", paramzzks.zze);
    try
    {
      if (zze().insertWithOnConflict("user_attributes", null, localContentValues, 5) == -1L) {
        this.zzs.zzau().zzb().zzb("Failed to insert/update user property (got -1). appId", zzem.zzl(paramzzks.zza));
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      this.zzs.zzau().zzb().zzc("Error storing user property. appId", zzem.zzl(paramzzks.zza), localSQLiteException);
    }
    return true;
  }
  
  /* Error */
  @WorkerThread
  public final zzks zzk(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   14: aload_0
    //   15: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc_w 1077
    //   27: iconst_3
    //   28: anewarray 21	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 1114
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc -5
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc 49
    //   46: aastore
    //   47: ldc_w 1025
    //   50: iconst_2
    //   51: anewarray 21	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload_2
    //   61: aastore
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 1028	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 4
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 304 1 0
    //   80: istore 5
    //   82: iload 5
    //   84: ifne +12 -> 96
    //   87: aload 4
    //   89: invokeinterface 311 1 0
    //   94: aconst_null
    //   95: areturn
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: iconst_0
    //   102: invokeinterface 308 2 0
    //   107: lstore 6
    //   109: aload 4
    //   111: astore_3
    //   112: aload_0
    //   113: aload 4
    //   115: iconst_1
    //   116: invokevirtual 1126	com/google/android/gms/measurement/internal/zzai:zzC	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   119: astore 8
    //   121: aload 8
    //   123: ifnonnull +12 -> 135
    //   126: aload 4
    //   128: invokeinterface 311 1 0
    //   133: aconst_null
    //   134: areturn
    //   135: aload 4
    //   137: astore_3
    //   138: aload 4
    //   140: iconst_2
    //   141: invokeinterface 505 2 0
    //   146: astore 9
    //   148: aload 4
    //   150: astore_3
    //   151: new 1084	com/google/android/gms/measurement/internal/zzks
    //   154: astore 10
    //   156: aload 4
    //   158: astore_3
    //   159: aload 10
    //   161: aload_1
    //   162: aload 9
    //   164: aload_2
    //   165: lload 6
    //   167: aload 8
    //   169: invokespecial 1129	com/google/android/gms/measurement/internal/zzks:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   172: aload 4
    //   174: astore_3
    //   175: aload 4
    //   177: invokeinterface 962 1 0
    //   182: ifeq +26 -> 208
    //   185: aload 4
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   192: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   195: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   198: ldc_w 1131
    //   201: aload_1
    //   202: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   205: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   208: aload 4
    //   210: invokeinterface 311 1 0
    //   215: aload 10
    //   217: areturn
    //   218: astore 10
    //   220: goto +14 -> 234
    //   223: astore_1
    //   224: aload_3
    //   225: astore_2
    //   226: goto +61 -> 287
    //   229: astore 10
    //   231: aconst_null
    //   232: astore 4
    //   234: aload 4
    //   236: astore_3
    //   237: aload_0
    //   238: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   241: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   244: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   247: ldc_w 1133
    //   250: aload_1
    //   251: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   254: aload_0
    //   255: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   258: invokevirtual 600	com/google/android/gms/measurement/internal/zzfu:zzm	()Lcom/google/android/gms/measurement/internal/zzeh;
    //   261: aload_2
    //   262: invokevirtual 1081	com/google/android/gms/measurement/internal/zzeh:zze	(Ljava/lang/String;)Ljava/lang/String;
    //   265: aload 10
    //   267: invokevirtual 573	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   270: aload 4
    //   272: ifnull +10 -> 282
    //   275: aload 4
    //   277: invokeinterface 311 1 0
    //   282: aconst_null
    //   283: areturn
    //   284: astore_1
    //   285: aload_3
    //   286: astore_2
    //   287: aload_2
    //   288: ifnull +9 -> 297
    //   291: aload_2
    //   292: invokeinterface 311 1 0
    //   297: aload_1
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	zzai
    //   0	299	1	paramString1	String
    //   0	299	2	paramString2	String
    //   19	267	3	localObject1	Object
    //   68	208	4	localCursor	Cursor
    //   80	3	5	bool	boolean
    //   107	59	6	l	long
    //   119	49	8	localObject2	Object
    //   146	17	9	str	String
    //   154	62	10	localzzks	zzks
    //   218	1	10	localSQLiteException1	SQLiteException
    //   229	37	10	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   73	82	218	android/database/sqlite/SQLiteException
    //   99	109	218	android/database/sqlite/SQLiteException
    //   112	121	218	android/database/sqlite/SQLiteException
    //   138	148	218	android/database/sqlite/SQLiteException
    //   151	156	218	android/database/sqlite/SQLiteException
    //   159	172	218	android/database/sqlite/SQLiteException
    //   175	185	218	android/database/sqlite/SQLiteException
    //   188	208	218	android/database/sqlite/SQLiteException
    //   20	70	223	finally
    //   20	70	229	android/database/sqlite/SQLiteException
    //   73	82	284	finally
    //   99	109	284	finally
    //   112	121	284	finally
    //   138	148	284	finally
    //   151	156	284	finally
    //   159	172	284	finally
    //   175	185	284	finally
    //   188	208	284	finally
    //   237	270	284	finally
  }
  
  /* Error */
  @WorkerThread
  public final List<zzks> zzl(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   9: aload_0
    //   10: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   13: new 875	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 876	java/util/ArrayList:<init>	()V
    //   20: astore_2
    //   21: aconst_null
    //   22: astore_3
    //   23: aconst_null
    //   24: astore 4
    //   26: aload 4
    //   28: astore 5
    //   30: aload_3
    //   31: astore 6
    //   33: aload_0
    //   34: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore 7
    //   39: aload 4
    //   41: astore 5
    //   43: aload_3
    //   44: astore 6
    //   46: aload_0
    //   47: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   50: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   53: pop
    //   54: aload 4
    //   56: astore 5
    //   58: aload_3
    //   59: astore 6
    //   61: aload 7
    //   63: ldc_w 1077
    //   66: iconst_4
    //   67: anewarray 21	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc_w 975
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: ldc 49
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc_w 1114
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: ldc -5
    //   91: aastore
    //   92: ldc_w 807
    //   95: iconst_1
    //   96: anewarray 21	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: aconst_null
    //   104: aconst_null
    //   105: ldc_w 943
    //   108: ldc_w 1136
    //   111: invokevirtual 949	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore 4
    //   116: aload 4
    //   118: astore 5
    //   120: aload 4
    //   122: astore 6
    //   124: aload 4
    //   126: invokeinterface 304 1 0
    //   131: ifeq +204 -> 335
    //   134: aload 4
    //   136: astore 5
    //   138: aload 4
    //   140: astore 6
    //   142: aload 4
    //   144: iconst_0
    //   145: invokeinterface 505 2 0
    //   150: astore 8
    //   152: aload 4
    //   154: astore 5
    //   156: aload 4
    //   158: astore 6
    //   160: aload 4
    //   162: iconst_1
    //   163: invokeinterface 505 2 0
    //   168: astore 7
    //   170: aload 7
    //   172: astore_3
    //   173: aload 7
    //   175: ifnonnull +7 -> 182
    //   178: ldc_w 923
    //   181: astore_3
    //   182: aload 4
    //   184: astore 5
    //   186: aload 4
    //   188: astore 6
    //   190: aload 4
    //   192: iconst_2
    //   193: invokeinterface 308 2 0
    //   198: lstore 9
    //   200: aload 4
    //   202: astore 5
    //   204: aload 4
    //   206: astore 6
    //   208: aload_0
    //   209: aload 4
    //   211: iconst_3
    //   212: invokevirtual 1126	com/google/android/gms/measurement/internal/zzai:zzC	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   215: astore 11
    //   217: aload 11
    //   219: ifnonnull +34 -> 253
    //   222: aload 4
    //   224: astore 5
    //   226: aload 4
    //   228: astore 6
    //   230: aload_0
    //   231: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   234: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   237: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   240: ldc_w 1138
    //   243: aload_1
    //   244: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   247: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   250: goto +54 -> 304
    //   253: aload 4
    //   255: astore 5
    //   257: aload 4
    //   259: astore 6
    //   261: new 1084	com/google/android/gms/measurement/internal/zzks
    //   264: astore 7
    //   266: aload 4
    //   268: astore 5
    //   270: aload 4
    //   272: astore 6
    //   274: aload 7
    //   276: aload_1
    //   277: aload_3
    //   278: aload 8
    //   280: lload 9
    //   282: aload 11
    //   284: invokespecial 1129	com/google/android/gms/measurement/internal/zzks:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   287: aload 4
    //   289: astore 5
    //   291: aload 4
    //   293: astore 6
    //   295: aload_2
    //   296: aload 7
    //   298: invokeinterface 880 2 0
    //   303: pop
    //   304: aload 4
    //   306: astore 5
    //   308: aload 4
    //   310: astore 6
    //   312: aload 4
    //   314: invokeinterface 962 1 0
    //   319: istore 12
    //   321: iload 12
    //   323: ifne -189 -> 134
    //   326: aload 4
    //   328: invokeinterface 311 1 0
    //   333: aload_2
    //   334: areturn
    //   335: aload 4
    //   337: invokeinterface 311 1 0
    //   342: aload_2
    //   343: areturn
    //   344: astore_1
    //   345: goto +53 -> 398
    //   348: astore 4
    //   350: aload 6
    //   352: astore 5
    //   354: aload_0
    //   355: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   358: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   361: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   364: ldc_w 1140
    //   367: aload_1
    //   368: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   371: aload 4
    //   373: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   376: aload 6
    //   378: astore 5
    //   380: invokestatic 1145	java/util/Collections:emptyList	()Ljava/util/List;
    //   383: astore_1
    //   384: aload 6
    //   386: ifnull +10 -> 396
    //   389: aload 6
    //   391: invokeinterface 311 1 0
    //   396: aload_1
    //   397: areturn
    //   398: aload 5
    //   400: ifnull +10 -> 410
    //   403: aload 5
    //   405: invokeinterface 311 1 0
    //   410: aload_1
    //   411: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	zzai
    //   0	412	1	paramString	String
    //   20	323	2	localArrayList	ArrayList
    //   22	256	3	localObject1	Object
    //   24	312	4	localCursor	Cursor
    //   348	24	4	localSQLiteException	SQLiteException
    //   28	376	5	localObject2	Object
    //   31	359	6	localObject3	Object
    //   37	260	7	localObject4	Object
    //   150	129	8	str	String
    //   198	83	9	l	long
    //   215	68	11	localObject5	Object
    //   319	3	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	39	344	finally
    //   46	54	344	finally
    //   61	116	344	finally
    //   124	134	344	finally
    //   142	152	344	finally
    //   160	170	344	finally
    //   190	200	344	finally
    //   208	217	344	finally
    //   230	250	344	finally
    //   261	266	344	finally
    //   274	287	344	finally
    //   295	304	344	finally
    //   312	321	344	finally
    //   354	376	344	finally
    //   380	384	344	finally
    //   33	39	348	android/database/sqlite/SQLiteException
    //   46	54	348	android/database/sqlite/SQLiteException
    //   61	116	348	android/database/sqlite/SQLiteException
    //   124	134	348	android/database/sqlite/SQLiteException
    //   142	152	348	android/database/sqlite/SQLiteException
    //   160	170	348	android/database/sqlite/SQLiteException
    //   190	200	348	android/database/sqlite/SQLiteException
    //   208	217	348	android/database/sqlite/SQLiteException
    //   230	250	348	android/database/sqlite/SQLiteException
    //   261	266	348	android/database/sqlite/SQLiteException
    //   274	287	348	android/database/sqlite/SQLiteException
    //   295	304	348	android/database/sqlite/SQLiteException
    //   312	321	348	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  @WorkerThread
  public final List<zzks> zzm(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   9: aload_0
    //   10: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   13: new 875	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 876	java/util/ArrayList:<init>	()V
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 7
    //   31: aload 5
    //   33: astore 8
    //   35: new 875	java/util/ArrayList
    //   38: astore 9
    //   40: aload 5
    //   42: astore 8
    //   44: aload 9
    //   46: iconst_3
    //   47: invokespecial 1148	java/util/ArrayList:<init>	(I)V
    //   50: aload 5
    //   52: astore 8
    //   54: aload 9
    //   56: aload_1
    //   57: invokeinterface 880 2 0
    //   62: pop
    //   63: aload 5
    //   65: astore 8
    //   67: new 444	java/lang/StringBuilder
    //   70: astore 10
    //   72: aload 5
    //   74: astore 8
    //   76: aload 10
    //   78: ldc_w 807
    //   81: invokespecial 1149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload 5
    //   86: astore 8
    //   88: aload_2
    //   89: invokestatic 832	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: istore 11
    //   94: iload 11
    //   96: ifne +52 -> 148
    //   99: aload_2
    //   100: astore 12
    //   102: aload 7
    //   104: astore 6
    //   106: aload 12
    //   108: astore 13
    //   110: aload 5
    //   112: astore 8
    //   114: aload 9
    //   116: aload 12
    //   118: invokeinterface 880 2 0
    //   123: pop
    //   124: aload 7
    //   126: astore 6
    //   128: aload 12
    //   130: astore 13
    //   132: aload 5
    //   134: astore 8
    //   136: aload 10
    //   138: ldc_w 1151
    //   141: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: goto +3 -> 148
    //   148: aload 7
    //   150: astore 6
    //   152: aload_2
    //   153: astore 13
    //   155: aload 5
    //   157: astore 8
    //   159: aload_3
    //   160: invokestatic 832	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifne +52 -> 215
    //   166: aload 7
    //   168: astore 6
    //   170: aload_2
    //   171: astore 13
    //   173: aload 5
    //   175: astore 8
    //   177: aload 9
    //   179: aload_3
    //   180: invokestatic 447	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   183: ldc_w 1153
    //   186: invokevirtual 1156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokeinterface 880 2 0
    //   194: pop
    //   195: aload 7
    //   197: astore 6
    //   199: aload_2
    //   200: astore 13
    //   202: aload 5
    //   204: astore 8
    //   206: aload 10
    //   208: ldc_w 1158
    //   211: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 7
    //   217: astore 6
    //   219: aload_2
    //   220: astore 13
    //   222: aload 5
    //   224: astore 8
    //   226: aload 9
    //   228: aload 9
    //   230: invokeinterface 430 1 0
    //   235: anewarray 21	java/lang/String
    //   238: invokeinterface 1159 2 0
    //   243: checkcast 1023	[Ljava/lang/String;
    //   246: astore 9
    //   248: aload 7
    //   250: astore 6
    //   252: aload_2
    //   253: astore 13
    //   255: aload 5
    //   257: astore 8
    //   259: aload_0
    //   260: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   263: astore 12
    //   265: aload 7
    //   267: astore 6
    //   269: aload_2
    //   270: astore 13
    //   272: aload 5
    //   274: astore 8
    //   276: aload 10
    //   278: invokevirtual 465	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore 10
    //   283: aload 7
    //   285: astore 6
    //   287: aload_2
    //   288: astore 13
    //   290: aload 5
    //   292: astore 8
    //   294: aload_0
    //   295: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   298: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   301: pop
    //   302: aload 7
    //   304: astore 6
    //   306: aload_2
    //   307: astore 13
    //   309: aload 5
    //   311: astore 8
    //   313: aload 12
    //   315: ldc_w 1077
    //   318: iconst_4
    //   319: anewarray 21	java/lang/String
    //   322: dup
    //   323: iconst_0
    //   324: ldc_w 975
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: ldc_w 1114
    //   333: aastore
    //   334: dup
    //   335: iconst_2
    //   336: ldc -5
    //   338: aastore
    //   339: dup
    //   340: iconst_3
    //   341: ldc 49
    //   343: aastore
    //   344: aload 10
    //   346: aload 9
    //   348: aconst_null
    //   349: aconst_null
    //   350: ldc_w 943
    //   353: ldc_w 1161
    //   356: invokevirtual 949	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   359: astore 12
    //   361: aload 12
    //   363: astore 6
    //   365: aload_2
    //   366: astore 13
    //   368: aload 12
    //   370: astore 8
    //   372: aload 12
    //   374: invokeinterface 304 1 0
    //   379: istore 11
    //   381: iload 11
    //   383: ifne +13 -> 396
    //   386: aload 12
    //   388: invokeinterface 311 1 0
    //   393: aload 4
    //   395: areturn
    //   396: aload 12
    //   398: astore 6
    //   400: aload_2
    //   401: astore 13
    //   403: aload 12
    //   405: astore 8
    //   407: aload 4
    //   409: invokeinterface 430 1 0
    //   414: istore 14
    //   416: aload 12
    //   418: astore 6
    //   420: aload_2
    //   421: astore 13
    //   423: aload 12
    //   425: astore 8
    //   427: aload_0
    //   428: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   431: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   434: pop
    //   435: iload 14
    //   437: sipush 1000
    //   440: if_icmplt +71 -> 511
    //   443: aload 12
    //   445: astore 6
    //   447: aload_2
    //   448: astore 13
    //   450: aload 12
    //   452: astore 8
    //   454: aload_0
    //   455: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   458: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   461: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   464: astore_3
    //   465: aload 12
    //   467: astore 6
    //   469: aload_2
    //   470: astore 13
    //   472: aload 12
    //   474: astore 8
    //   476: aload_0
    //   477: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   480: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   483: pop
    //   484: aload 12
    //   486: astore 6
    //   488: aload_2
    //   489: astore 13
    //   491: aload 12
    //   493: astore 8
    //   495: aload_3
    //   496: ldc_w 1163
    //   499: sipush 1000
    //   502: invokestatic 418	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   508: goto +215 -> 723
    //   511: aload 12
    //   513: astore 6
    //   515: aload_2
    //   516: astore 13
    //   518: aload 12
    //   520: astore 8
    //   522: aload 12
    //   524: iconst_0
    //   525: invokeinterface 505 2 0
    //   530: astore 5
    //   532: aload 12
    //   534: astore 6
    //   536: aload_2
    //   537: astore 13
    //   539: aload 12
    //   541: astore 8
    //   543: aload 12
    //   545: iconst_1
    //   546: invokeinterface 308 2 0
    //   551: lstore 15
    //   553: aload 12
    //   555: astore 6
    //   557: aload_2
    //   558: astore 13
    //   560: aload 12
    //   562: astore 8
    //   564: aload_0
    //   565: aload 12
    //   567: iconst_2
    //   568: invokevirtual 1126	com/google/android/gms/measurement/internal/zzai:zzC	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   571: astore 7
    //   573: aload 12
    //   575: astore 6
    //   577: aload_2
    //   578: astore 13
    //   580: aload 12
    //   582: astore 8
    //   584: aload 12
    //   586: iconst_3
    //   587: invokeinterface 505 2 0
    //   592: astore_2
    //   593: aload 7
    //   595: ifnonnull +39 -> 634
    //   598: aload 12
    //   600: astore 6
    //   602: aload_2
    //   603: astore 13
    //   605: aload 12
    //   607: astore 8
    //   609: aload_0
    //   610: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   613: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   616: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   619: ldc_w 1165
    //   622: aload_1
    //   623: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   626: aload_2
    //   627: aload_3
    //   628: invokevirtual 573	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   631: goto +64 -> 695
    //   634: aload 12
    //   636: astore 6
    //   638: aload_2
    //   639: astore 13
    //   641: aload 12
    //   643: astore 8
    //   645: new 1084	com/google/android/gms/measurement/internal/zzks
    //   648: astore 10
    //   650: aload 12
    //   652: astore 6
    //   654: aload_2
    //   655: astore 13
    //   657: aload 12
    //   659: astore 8
    //   661: aload 10
    //   663: aload_1
    //   664: aload_2
    //   665: aload 5
    //   667: lload 15
    //   669: aload 7
    //   671: invokespecial 1129	com/google/android/gms/measurement/internal/zzks:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   674: aload 12
    //   676: astore 6
    //   678: aload_2
    //   679: astore 13
    //   681: aload 12
    //   683: astore 8
    //   685: aload 4
    //   687: aload 10
    //   689: invokeinterface 880 2 0
    //   694: pop
    //   695: aload 12
    //   697: astore 6
    //   699: aload_2
    //   700: astore 13
    //   702: aload 12
    //   704: astore 8
    //   706: aload 12
    //   708: invokeinterface 962 1 0
    //   713: istore 11
    //   715: iload 11
    //   717: ifeq +6 -> 723
    //   720: goto -324 -> 396
    //   723: aload 12
    //   725: invokeinterface 311 1 0
    //   730: aload 4
    //   732: areturn
    //   733: astore_3
    //   734: goto +15 -> 749
    //   737: astore_1
    //   738: goto +60 -> 798
    //   741: astore_3
    //   742: goto +4 -> 746
    //   745: astore_3
    //   746: aload_2
    //   747: astore 13
    //   749: aload 6
    //   751: astore 8
    //   753: aload_0
    //   754: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   757: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   760: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   763: ldc_w 1167
    //   766: aload_1
    //   767: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   770: aload 13
    //   772: aload_3
    //   773: invokevirtual 573	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   776: aload 6
    //   778: astore 8
    //   780: invokestatic 1145	java/util/Collections:emptyList	()Ljava/util/List;
    //   783: astore_1
    //   784: aload 6
    //   786: ifnull +10 -> 796
    //   789: aload 6
    //   791: invokeinterface 311 1 0
    //   796: aload_1
    //   797: areturn
    //   798: aload 8
    //   800: ifnull +10 -> 810
    //   803: aload 8
    //   805: invokeinterface 311 1 0
    //   810: aload_1
    //   811: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	zzai
    //   0	812	1	paramString1	String
    //   0	812	2	paramString2	String
    //   0	812	3	paramString3	String
    //   20	711	4	localArrayList	ArrayList
    //   23	643	5	str	String
    //   26	764	6	localObject1	Object
    //   29	641	7	localObject2	Object
    //   33	771	8	localObject3	Object
    //   38	309	9	localObject4	Object
    //   70	618	10	localObject5	Object
    //   92	624	11	bool	boolean
    //   100	624	12	localObject6	Object
    //   108	663	13	localObject7	Object
    //   414	27	14	i	int
    //   551	117	15	l	long
    // Exception table:
    //   from	to	target	type
    //   114	124	733	android/database/sqlite/SQLiteException
    //   136	145	733	android/database/sqlite/SQLiteException
    //   159	166	733	android/database/sqlite/SQLiteException
    //   177	195	733	android/database/sqlite/SQLiteException
    //   206	215	733	android/database/sqlite/SQLiteException
    //   226	248	733	android/database/sqlite/SQLiteException
    //   259	265	733	android/database/sqlite/SQLiteException
    //   276	283	733	android/database/sqlite/SQLiteException
    //   294	302	733	android/database/sqlite/SQLiteException
    //   313	361	733	android/database/sqlite/SQLiteException
    //   372	381	733	android/database/sqlite/SQLiteException
    //   407	416	733	android/database/sqlite/SQLiteException
    //   427	435	733	android/database/sqlite/SQLiteException
    //   454	465	733	android/database/sqlite/SQLiteException
    //   476	484	733	android/database/sqlite/SQLiteException
    //   495	508	733	android/database/sqlite/SQLiteException
    //   522	532	733	android/database/sqlite/SQLiteException
    //   543	553	733	android/database/sqlite/SQLiteException
    //   564	573	733	android/database/sqlite/SQLiteException
    //   584	593	733	android/database/sqlite/SQLiteException
    //   609	631	733	android/database/sqlite/SQLiteException
    //   645	650	733	android/database/sqlite/SQLiteException
    //   661	674	733	android/database/sqlite/SQLiteException
    //   685	695	733	android/database/sqlite/SQLiteException
    //   706	715	733	android/database/sqlite/SQLiteException
    //   35	40	737	finally
    //   44	50	737	finally
    //   54	63	737	finally
    //   67	72	737	finally
    //   76	84	737	finally
    //   88	94	737	finally
    //   114	124	737	finally
    //   136	145	737	finally
    //   159	166	737	finally
    //   177	195	737	finally
    //   206	215	737	finally
    //   226	248	737	finally
    //   259	265	737	finally
    //   276	283	737	finally
    //   294	302	737	finally
    //   313	361	737	finally
    //   372	381	737	finally
    //   407	416	737	finally
    //   427	435	737	finally
    //   454	465	737	finally
    //   476	484	737	finally
    //   495	508	737	finally
    //   522	532	737	finally
    //   543	553	737	finally
    //   564	573	737	finally
    //   584	593	737	finally
    //   609	631	737	finally
    //   645	650	737	finally
    //   661	674	737	finally
    //   685	695	737	finally
    //   706	715	737	finally
    //   753	776	737	finally
    //   780	784	737	finally
    //   54	63	741	android/database/sqlite/SQLiteException
    //   67	72	741	android/database/sqlite/SQLiteException
    //   76	84	741	android/database/sqlite/SQLiteException
    //   88	94	741	android/database/sqlite/SQLiteException
    //   35	40	745	android/database/sqlite/SQLiteException
    //   44	50	745	android/database/sqlite/SQLiteException
  }
  
  @WorkerThread
  public final boolean zzn(zzaa paramzzaa)
  {
    Preconditions.checkNotNull(paramzzaa);
    zzg();
    zzZ();
    String str = paramzzaa.zza;
    Preconditions.checkNotNull(str);
    if (zzk(str, paramzzaa.zzc.zzb) == null)
    {
      long l = zzab("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[] { str });
      this.zzs.zzc();
      if (l >= 1000L) {
        return false;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", str);
    localContentValues.put("origin", paramzzaa.zzb);
    localContentValues.put("name", paramzzaa.zzc.zzb);
    zzX(localContentValues, "value", Preconditions.checkNotNull(paramzzaa.zzc.zza()));
    localContentValues.put("active", Boolean.valueOf(paramzzaa.zze));
    localContentValues.put("trigger_event_name", paramzzaa.zzf);
    localContentValues.put("trigger_timeout", Long.valueOf(paramzzaa.zzh));
    localContentValues.put("timed_out_event", this.zzs.zzl().zzX(paramzzaa.zzg));
    localContentValues.put("creation_timestamp", Long.valueOf(paramzzaa.zzd));
    localContentValues.put("triggered_event", this.zzs.zzl().zzX(paramzzaa.zzi));
    localContentValues.put("triggered_timestamp", Long.valueOf(paramzzaa.zzc.zzc));
    localContentValues.put("time_to_live", Long.valueOf(paramzzaa.zzj));
    localContentValues.put("expired_event", this.zzs.zzl().zzX(paramzzaa.zzk));
    try
    {
      if (zze().insertWithOnConflict("conditional_properties", null, localContentValues, 5) == -1L) {
        this.zzs.zzau().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzem.zzl(str));
      }
    }
    catch (SQLiteException paramzzaa)
    {
      this.zzs.zzau().zzb().zzc("Error storing conditional user property", zzem.zzl(str), paramzzaa);
    }
    return true;
  }
  
  /* Error */
  @WorkerThread
  public final zzaa zzo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   14: aload_0
    //   15: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc_w 1229
    //   27: bipush 11
    //   29: anewarray 21	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc 49
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc -5
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc_w 1187
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: ldc_w 1192
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc_w 1196
    //   59: aastore
    //   60: dup
    //   61: iconst_5
    //   62: ldc_w 1200
    //   65: aastore
    //   66: dup
    //   67: bipush 6
    //   69: ldc_w 1211
    //   72: aastore
    //   73: dup
    //   74: bipush 7
    //   76: ldc_w 1214
    //   79: aastore
    //   80: dup
    //   81: bipush 8
    //   83: ldc_w 1218
    //   86: aastore
    //   87: dup
    //   88: bipush 9
    //   90: ldc_w 1221
    //   93: aastore
    //   94: dup
    //   95: bipush 10
    //   97: ldc_w 1225
    //   100: aastore
    //   101: ldc_w 1025
    //   104: iconst_2
    //   105: anewarray 21	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_1
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload_2
    //   115: aastore
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: invokevirtual 1028	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   122: astore 4
    //   124: aload 4
    //   126: astore_3
    //   127: aload 4
    //   129: invokeinterface 304 1 0
    //   134: istore 5
    //   136: iload 5
    //   138: ifne +12 -> 150
    //   141: aload 4
    //   143: invokeinterface 311 1 0
    //   148: aconst_null
    //   149: areturn
    //   150: aload 4
    //   152: astore_3
    //   153: aload 4
    //   155: iconst_0
    //   156: invokeinterface 505 2 0
    //   161: astore 6
    //   163: aload 4
    //   165: astore_3
    //   166: aload_0
    //   167: aload 4
    //   169: iconst_1
    //   170: invokevirtual 1126	com/google/android/gms/measurement/internal/zzai:zzC	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   173: astore 7
    //   175: aload 4
    //   177: astore_3
    //   178: aload 4
    //   180: iconst_2
    //   181: invokeinterface 1237 2 0
    //   186: ifeq +9 -> 195
    //   189: iconst_1
    //   190: istore 5
    //   192: goto +6 -> 198
    //   195: iconst_0
    //   196: istore 5
    //   198: aload 4
    //   200: astore_3
    //   201: aload 4
    //   203: iconst_3
    //   204: invokeinterface 505 2 0
    //   209: astore 8
    //   211: aload 4
    //   213: astore_3
    //   214: aload 4
    //   216: iconst_4
    //   217: invokeinterface 308 2 0
    //   222: lstore 9
    //   224: aload 4
    //   226: astore_3
    //   227: aload_0
    //   228: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   231: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   234: astore 11
    //   236: aload 4
    //   238: astore_3
    //   239: aload 4
    //   241: iconst_5
    //   242: invokeinterface 631 2 0
    //   247: astore 12
    //   249: aload 4
    //   251: astore_3
    //   252: getstatic 1243	com/google/android/gms/measurement/internal/zzas:CREATOR	Landroid/os/Parcelable$Creator;
    //   255: astore 13
    //   257: aload 4
    //   259: astore_3
    //   260: aload 11
    //   262: aload 12
    //   264: aload 13
    //   266: invokevirtual 1246	com/google/android/gms/measurement/internal/zzkp:zzk	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   269: checkcast 1239	com/google/android/gms/measurement/internal/zzas
    //   272: astore 12
    //   274: aload 4
    //   276: astore_3
    //   277: aload 4
    //   279: bipush 6
    //   281: invokeinterface 308 2 0
    //   286: lstore 14
    //   288: aload 4
    //   290: astore_3
    //   291: aload_0
    //   292: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   295: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   298: aload 4
    //   300: bipush 7
    //   302: invokeinterface 631 2 0
    //   307: aload 13
    //   309: invokevirtual 1246	com/google/android/gms/measurement/internal/zzkp:zzk	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   312: checkcast 1239	com/google/android/gms/measurement/internal/zzas
    //   315: astore 11
    //   317: aload 4
    //   319: astore_3
    //   320: aload 4
    //   322: bipush 8
    //   324: invokeinterface 308 2 0
    //   329: lstore 16
    //   331: aload 4
    //   333: astore_3
    //   334: aload 4
    //   336: bipush 9
    //   338: invokeinterface 308 2 0
    //   343: lstore 18
    //   345: aload 4
    //   347: astore_3
    //   348: aload_0
    //   349: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   352: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   355: aload 4
    //   357: bipush 10
    //   359: invokeinterface 631 2 0
    //   364: aload 13
    //   366: invokevirtual 1246	com/google/android/gms/measurement/internal/zzkp:zzk	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   369: checkcast 1239	com/google/android/gms/measurement/internal/zzas
    //   372: astore 13
    //   374: aload 4
    //   376: astore_3
    //   377: new 1177	com/google/android/gms/measurement/internal/zzkq
    //   380: astore 20
    //   382: aload 4
    //   384: astore_3
    //   385: aload 20
    //   387: aload_2
    //   388: lload 16
    //   390: aload 7
    //   392: aload 6
    //   394: invokespecial 1249	com/google/android/gms/measurement/internal/zzkq:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   397: aload 4
    //   399: astore_3
    //   400: new 1171	com/google/android/gms/measurement/internal/zzaa
    //   403: astore 7
    //   405: aload 4
    //   407: astore_3
    //   408: aload 7
    //   410: aload_1
    //   411: aload 6
    //   413: aload 20
    //   415: lload 14
    //   417: iload 5
    //   419: aload 8
    //   421: aload 12
    //   423: lload 9
    //   425: aload 11
    //   427: lload 18
    //   429: aload 13
    //   431: invokespecial 1252	com/google/android/gms/measurement/internal/zzaa:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzkq;JZLjava/lang/String;Lcom/google/android/gms/measurement/internal/zzas;JLcom/google/android/gms/measurement/internal/zzas;JLcom/google/android/gms/measurement/internal/zzas;)V
    //   434: aload 4
    //   436: astore_3
    //   437: aload 4
    //   439: invokeinterface 962 1 0
    //   444: ifeq +37 -> 481
    //   447: aload 4
    //   449: astore_3
    //   450: aload_0
    //   451: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   454: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   457: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   460: ldc_w 1254
    //   463: aload_1
    //   464: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   467: aload_0
    //   468: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   471: invokevirtual 600	com/google/android/gms/measurement/internal/zzfu:zzm	()Lcom/google/android/gms/measurement/internal/zzeh;
    //   474: aload_2
    //   475: invokevirtual 1081	com/google/android/gms/measurement/internal/zzeh:zze	(Ljava/lang/String;)Ljava/lang/String;
    //   478: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   481: aload 4
    //   483: invokeinterface 311 1 0
    //   488: aload 7
    //   490: areturn
    //   491: astore 6
    //   493: goto +14 -> 507
    //   496: astore_1
    //   497: aload_3
    //   498: astore_2
    //   499: goto +61 -> 560
    //   502: astore 6
    //   504: aconst_null
    //   505: astore 4
    //   507: aload 4
    //   509: astore_3
    //   510: aload_0
    //   511: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   514: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   517: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   520: ldc_w 1256
    //   523: aload_1
    //   524: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   527: aload_0
    //   528: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   531: invokevirtual 600	com/google/android/gms/measurement/internal/zzfu:zzm	()Lcom/google/android/gms/measurement/internal/zzeh;
    //   534: aload_2
    //   535: invokevirtual 1081	com/google/android/gms/measurement/internal/zzeh:zze	(Ljava/lang/String;)Ljava/lang/String;
    //   538: aload 6
    //   540: invokevirtual 573	com/google/android/gms/measurement/internal/zzek:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   543: aload 4
    //   545: ifnull +10 -> 555
    //   548: aload 4
    //   550: invokeinterface 311 1 0
    //   555: aconst_null
    //   556: areturn
    //   557: astore_1
    //   558: aload_3
    //   559: astore_2
    //   560: aload_2
    //   561: ifnull +9 -> 570
    //   564: aload_2
    //   565: invokeinterface 311 1 0
    //   570: aload_1
    //   571: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	zzai
    //   0	572	1	paramString1	String
    //   0	572	2	paramString2	String
    //   19	540	3	localObject1	Object
    //   122	427	4	localCursor	Cursor
    //   134	284	5	bool	boolean
    //   161	251	6	str1	String
    //   491	1	6	localSQLiteException1	SQLiteException
    //   502	37	6	localSQLiteException2	SQLiteException
    //   173	316	7	localObject2	Object
    //   209	211	8	str2	String
    //   222	202	9	l1	long
    //   234	192	11	localObject3	Object
    //   247	175	12	localObject4	Object
    //   255	175	13	localObject5	Object
    //   286	130	14	l2	long
    //   329	60	16	l3	long
    //   343	85	18	l4	long
    //   380	34	20	localzzkq	zzkq
    // Exception table:
    //   from	to	target	type
    //   127	136	491	android/database/sqlite/SQLiteException
    //   153	163	491	android/database/sqlite/SQLiteException
    //   166	175	491	android/database/sqlite/SQLiteException
    //   178	189	491	android/database/sqlite/SQLiteException
    //   201	211	491	android/database/sqlite/SQLiteException
    //   214	224	491	android/database/sqlite/SQLiteException
    //   227	236	491	android/database/sqlite/SQLiteException
    //   239	249	491	android/database/sqlite/SQLiteException
    //   252	257	491	android/database/sqlite/SQLiteException
    //   260	274	491	android/database/sqlite/SQLiteException
    //   277	288	491	android/database/sqlite/SQLiteException
    //   291	317	491	android/database/sqlite/SQLiteException
    //   320	331	491	android/database/sqlite/SQLiteException
    //   334	345	491	android/database/sqlite/SQLiteException
    //   348	374	491	android/database/sqlite/SQLiteException
    //   377	382	491	android/database/sqlite/SQLiteException
    //   385	397	491	android/database/sqlite/SQLiteException
    //   400	405	491	android/database/sqlite/SQLiteException
    //   408	434	491	android/database/sqlite/SQLiteException
    //   437	447	491	android/database/sqlite/SQLiteException
    //   450	481	491	android/database/sqlite/SQLiteException
    //   20	124	496	finally
    //   20	124	502	android/database/sqlite/SQLiteException
    //   127	136	557	finally
    //   153	163	557	finally
    //   166	175	557	finally
    //   178	189	557	finally
    //   201	211	557	finally
    //   214	224	557	finally
    //   227	236	557	finally
    //   239	249	557	finally
    //   252	257	557	finally
    //   260	274	557	finally
    //   277	288	557	finally
    //   291	317	557	finally
    //   320	331	557	finally
    //   334	345	557	finally
    //   348	374	557	finally
    //   377	382	557	finally
    //   385	397	557	finally
    //   400	405	557	finally
    //   408	434	557	finally
    //   437	447	557	finally
    //   450	481	557	finally
    //   510	543	557	finally
  }
  
  @WorkerThread
  public final int zzp(String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzg();
    zzZ();
    try
    {
      int i = zze().delete("conditional_properties", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.zzs.zzau().zzb().zzd("Error deleting conditional property", zzem.zzl(paramString1), this.zzs.zzm().zze(paramString2), localSQLiteException);
    }
    return 0;
  }
  
  @WorkerThread
  public final List<zzaa> zzq(String paramString1, String paramString2, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    zzg();
    zzZ();
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(paramString1);
    paramString1 = new StringBuilder("app_id=?");
    if (!TextUtils.isEmpty(paramString2))
    {
      localArrayList.add(paramString2);
      paramString1.append(" and origin=?");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localArrayList.add(String.valueOf(paramString3).concat("*"));
      paramString1.append(" and name glob ?");
    }
    paramString2 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return zzr(paramString1.toString(), paramString2);
  }
  
  /* Error */
  public final List<zzaa> zzr(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   4: aload_0
    //   5: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   8: new 875	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 876	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore 5
    //   22: aload 5
    //   24: astore 6
    //   26: aload 4
    //   28: astore 7
    //   30: aload_0
    //   31: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 8
    //   36: aload 5
    //   38: astore 6
    //   40: aload 4
    //   42: astore 7
    //   44: aload_0
    //   45: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   48: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   51: pop
    //   52: aload 5
    //   54: astore 6
    //   56: aload 4
    //   58: astore 7
    //   60: aload 8
    //   62: ldc_w 1229
    //   65: bipush 13
    //   67: anewarray 21	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc_w 539
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: ldc 49
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc_w 975
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: ldc -5
    //   91: aastore
    //   92: dup
    //   93: iconst_4
    //   94: ldc_w 1187
    //   97: aastore
    //   98: dup
    //   99: iconst_5
    //   100: ldc_w 1192
    //   103: aastore
    //   104: dup
    //   105: bipush 6
    //   107: ldc_w 1196
    //   110: aastore
    //   111: dup
    //   112: bipush 7
    //   114: ldc_w 1200
    //   117: aastore
    //   118: dup
    //   119: bipush 8
    //   121: ldc_w 1211
    //   124: aastore
    //   125: dup
    //   126: bipush 9
    //   128: ldc_w 1214
    //   131: aastore
    //   132: dup
    //   133: bipush 10
    //   135: ldc_w 1218
    //   138: aastore
    //   139: dup
    //   140: bipush 11
    //   142: ldc_w 1221
    //   145: aastore
    //   146: dup
    //   147: bipush 12
    //   149: ldc_w 1225
    //   152: aastore
    //   153: aload_1
    //   154: aload_2
    //   155: aconst_null
    //   156: aconst_null
    //   157: ldc_w 943
    //   160: ldc_w 1161
    //   163: invokevirtual 949	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore_1
    //   167: aload_1
    //   168: astore 6
    //   170: aload_1
    //   171: astore 7
    //   173: aload_1
    //   174: invokeinterface 304 1 0
    //   179: ifeq +492 -> 671
    //   182: aload_1
    //   183: astore 6
    //   185: aload_1
    //   186: astore 7
    //   188: aload_3
    //   189: invokeinterface 430 1 0
    //   194: istore 9
    //   196: aload_1
    //   197: astore 6
    //   199: aload_1
    //   200: astore 7
    //   202: aload_0
    //   203: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   206: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   209: pop
    //   210: iload 9
    //   212: sipush 1000
    //   215: if_icmplt +56 -> 271
    //   218: aload_1
    //   219: astore 6
    //   221: aload_1
    //   222: astore 7
    //   224: aload_0
    //   225: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   228: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   231: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   234: astore_2
    //   235: aload_1
    //   236: astore 6
    //   238: aload_1
    //   239: astore 7
    //   241: aload_0
    //   242: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   245: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   248: pop
    //   249: aload_1
    //   250: astore 6
    //   252: aload_1
    //   253: astore 7
    //   255: aload_2
    //   256: ldc_w 1268
    //   259: sipush 1000
    //   262: invokestatic 418	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   268: goto +395 -> 663
    //   271: aload_1
    //   272: astore 6
    //   274: aload_1
    //   275: astore 7
    //   277: aload_1
    //   278: iconst_0
    //   279: invokeinterface 505 2 0
    //   284: astore 5
    //   286: aload_1
    //   287: astore 6
    //   289: aload_1
    //   290: astore 7
    //   292: aload_1
    //   293: iconst_1
    //   294: invokeinterface 505 2 0
    //   299: astore_2
    //   300: aload_1
    //   301: astore 6
    //   303: aload_1
    //   304: astore 7
    //   306: aload_1
    //   307: iconst_2
    //   308: invokeinterface 505 2 0
    //   313: astore 10
    //   315: aload_1
    //   316: astore 6
    //   318: aload_1
    //   319: astore 7
    //   321: aload_0
    //   322: aload_1
    //   323: iconst_3
    //   324: invokevirtual 1126	com/google/android/gms/measurement/internal/zzai:zzC	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   327: astore 8
    //   329: aload_1
    //   330: astore 6
    //   332: aload_1
    //   333: astore 7
    //   335: aload_1
    //   336: iconst_4
    //   337: invokeinterface 1237 2 0
    //   342: ifeq +9 -> 351
    //   345: iconst_1
    //   346: istore 11
    //   348: goto +6 -> 354
    //   351: iconst_0
    //   352: istore 11
    //   354: aload_1
    //   355: astore 6
    //   357: aload_1
    //   358: astore 7
    //   360: aload_1
    //   361: iconst_5
    //   362: invokeinterface 505 2 0
    //   367: astore 4
    //   369: aload_1
    //   370: astore 6
    //   372: aload_1
    //   373: astore 7
    //   375: aload_1
    //   376: bipush 6
    //   378: invokeinterface 308 2 0
    //   383: lstore 12
    //   385: aload_1
    //   386: astore 6
    //   388: aload_1
    //   389: astore 7
    //   391: aload_0
    //   392: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   395: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   398: astore 14
    //   400: aload_1
    //   401: astore 6
    //   403: aload_1
    //   404: astore 7
    //   406: aload_1
    //   407: bipush 7
    //   409: invokeinterface 631 2 0
    //   414: astore 15
    //   416: aload_1
    //   417: astore 6
    //   419: aload_1
    //   420: astore 7
    //   422: getstatic 1243	com/google/android/gms/measurement/internal/zzas:CREATOR	Landroid/os/Parcelable$Creator;
    //   425: astore 16
    //   427: aload_1
    //   428: astore 6
    //   430: aload_1
    //   431: astore 7
    //   433: aload 14
    //   435: aload 15
    //   437: aload 16
    //   439: invokevirtual 1246	com/google/android/gms/measurement/internal/zzkp:zzk	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   442: checkcast 1239	com/google/android/gms/measurement/internal/zzas
    //   445: astore 15
    //   447: aload_1
    //   448: astore 6
    //   450: aload_1
    //   451: astore 7
    //   453: aload_1
    //   454: bipush 8
    //   456: invokeinterface 308 2 0
    //   461: lstore 17
    //   463: aload_1
    //   464: astore 6
    //   466: aload_1
    //   467: astore 7
    //   469: aload_0
    //   470: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   473: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   476: aload_1
    //   477: bipush 9
    //   479: invokeinterface 631 2 0
    //   484: aload 16
    //   486: invokevirtual 1246	com/google/android/gms/measurement/internal/zzkp:zzk	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   489: checkcast 1239	com/google/android/gms/measurement/internal/zzas
    //   492: astore 14
    //   494: aload_1
    //   495: astore 6
    //   497: aload_1
    //   498: astore 7
    //   500: aload_1
    //   501: bipush 10
    //   503: invokeinterface 308 2 0
    //   508: lstore 19
    //   510: aload_1
    //   511: astore 6
    //   513: aload_1
    //   514: astore 7
    //   516: aload_1
    //   517: bipush 11
    //   519: invokeinterface 308 2 0
    //   524: lstore 21
    //   526: aload_1
    //   527: astore 6
    //   529: aload_1
    //   530: astore 7
    //   532: aload_0
    //   533: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   536: invokevirtual 653	com/google/android/gms/measurement/internal/zzkn:zzm	()Lcom/google/android/gms/measurement/internal/zzkp;
    //   539: aload_1
    //   540: bipush 12
    //   542: invokeinterface 631 2 0
    //   547: aload 16
    //   549: invokevirtual 1246	com/google/android/gms/measurement/internal/zzkp:zzk	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   552: checkcast 1239	com/google/android/gms/measurement/internal/zzas
    //   555: astore 23
    //   557: aload_1
    //   558: astore 6
    //   560: aload_1
    //   561: astore 7
    //   563: new 1177	com/google/android/gms/measurement/internal/zzkq
    //   566: astore 16
    //   568: aload_1
    //   569: astore 6
    //   571: aload_1
    //   572: astore 7
    //   574: aload 16
    //   576: aload 10
    //   578: lload 19
    //   580: aload 8
    //   582: aload_2
    //   583: invokespecial 1249	com/google/android/gms/measurement/internal/zzkq:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   586: aload_1
    //   587: astore 6
    //   589: aload_1
    //   590: astore 7
    //   592: new 1171	com/google/android/gms/measurement/internal/zzaa
    //   595: astore 8
    //   597: aload_1
    //   598: astore 6
    //   600: aload_1
    //   601: astore 7
    //   603: aload 8
    //   605: aload 5
    //   607: aload_2
    //   608: aload 16
    //   610: lload 17
    //   612: iload 11
    //   614: aload 4
    //   616: aload 15
    //   618: lload 12
    //   620: aload 14
    //   622: lload 21
    //   624: aload 23
    //   626: invokespecial 1252	com/google/android/gms/measurement/internal/zzaa:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzkq;JZLjava/lang/String;Lcom/google/android/gms/measurement/internal/zzas;JLcom/google/android/gms/measurement/internal/zzas;JLcom/google/android/gms/measurement/internal/zzas;)V
    //   629: aload_1
    //   630: astore 6
    //   632: aload_1
    //   633: astore 7
    //   635: aload_3
    //   636: aload 8
    //   638: invokeinterface 880 2 0
    //   643: pop
    //   644: aload_1
    //   645: astore 6
    //   647: aload_1
    //   648: astore 7
    //   650: aload_1
    //   651: invokeinterface 962 1 0
    //   656: istore 11
    //   658: iload 11
    //   660: ifne -478 -> 182
    //   663: aload_1
    //   664: invokeinterface 311 1 0
    //   669: aload_3
    //   670: areturn
    //   671: aload_1
    //   672: invokeinterface 311 1 0
    //   677: aload_3
    //   678: areturn
    //   679: astore_1
    //   680: goto +47 -> 727
    //   683: astore_1
    //   684: aload 7
    //   686: astore 6
    //   688: aload_0
    //   689: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   692: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   695: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   698: ldc_w 1270
    //   701: aload_1
    //   702: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   705: aload 7
    //   707: astore 6
    //   709: invokestatic 1145	java/util/Collections:emptyList	()Ljava/util/List;
    //   712: astore_1
    //   713: aload 7
    //   715: ifnull +10 -> 725
    //   718: aload 7
    //   720: invokeinterface 311 1 0
    //   725: aload_1
    //   726: areturn
    //   727: aload 6
    //   729: ifnull +10 -> 739
    //   732: aload 6
    //   734: invokeinterface 311 1 0
    //   739: aload_1
    //   740: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	741	0	this	zzai
    //   0	741	1	paramString	String
    //   0	741	2	paramArrayOfString	String[]
    //   15	663	3	localArrayList	ArrayList
    //   17	598	4	str1	String
    //   20	586	5	str2	String
    //   24	709	6	localObject1	Object
    //   28	691	7	str3	String
    //   34	603	8	localObject2	Object
    //   194	22	9	i	int
    //   313	264	10	str4	String
    //   346	313	11	bool	boolean
    //   383	236	12	l1	long
    //   398	223	14	localObject3	Object
    //   414	203	15	localObject4	Object
    //   425	184	16	localObject5	Object
    //   461	150	17	l2	long
    //   508	71	19	l3	long
    //   524	99	21	l4	long
    //   555	70	23	localzzas	zzas
    // Exception table:
    //   from	to	target	type
    //   30	36	679	finally
    //   44	52	679	finally
    //   60	167	679	finally
    //   173	182	679	finally
    //   188	196	679	finally
    //   202	210	679	finally
    //   224	235	679	finally
    //   241	249	679	finally
    //   255	268	679	finally
    //   277	286	679	finally
    //   292	300	679	finally
    //   306	315	679	finally
    //   321	329	679	finally
    //   335	345	679	finally
    //   360	369	679	finally
    //   375	385	679	finally
    //   391	400	679	finally
    //   406	416	679	finally
    //   422	427	679	finally
    //   433	447	679	finally
    //   453	463	679	finally
    //   469	494	679	finally
    //   500	510	679	finally
    //   516	526	679	finally
    //   532	557	679	finally
    //   563	568	679	finally
    //   574	586	679	finally
    //   592	597	679	finally
    //   603	629	679	finally
    //   635	644	679	finally
    //   650	658	679	finally
    //   688	705	679	finally
    //   709	713	679	finally
    //   30	36	683	android/database/sqlite/SQLiteException
    //   44	52	683	android/database/sqlite/SQLiteException
    //   60	167	683	android/database/sqlite/SQLiteException
    //   173	182	683	android/database/sqlite/SQLiteException
    //   188	196	683	android/database/sqlite/SQLiteException
    //   202	210	683	android/database/sqlite/SQLiteException
    //   224	235	683	android/database/sqlite/SQLiteException
    //   241	249	683	android/database/sqlite/SQLiteException
    //   255	268	683	android/database/sqlite/SQLiteException
    //   277	286	683	android/database/sqlite/SQLiteException
    //   292	300	683	android/database/sqlite/SQLiteException
    //   306	315	683	android/database/sqlite/SQLiteException
    //   321	329	683	android/database/sqlite/SQLiteException
    //   335	345	683	android/database/sqlite/SQLiteException
    //   360	369	683	android/database/sqlite/SQLiteException
    //   375	385	683	android/database/sqlite/SQLiteException
    //   391	400	683	android/database/sqlite/SQLiteException
    //   406	416	683	android/database/sqlite/SQLiteException
    //   422	427	683	android/database/sqlite/SQLiteException
    //   433	447	683	android/database/sqlite/SQLiteException
    //   453	463	683	android/database/sqlite/SQLiteException
    //   469	494	683	android/database/sqlite/SQLiteException
    //   500	510	683	android/database/sqlite/SQLiteException
    //   516	526	683	android/database/sqlite/SQLiteException
    //   532	557	683	android/database/sqlite/SQLiteException
    //   563	568	683	android/database/sqlite/SQLiteException
    //   574	586	683	android/database/sqlite/SQLiteException
    //   592	597	683	android/database/sqlite/SQLiteException
    //   603	629	683	android/database/sqlite/SQLiteException
    //   635	644	683	android/database/sqlite/SQLiteException
    //   650	658	683	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  @WorkerThread
  public final zzg zzs(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   9: aload_0
    //   10: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore_3
    //   20: iconst_1
    //   21: istore 4
    //   23: aload_3
    //   24: ldc_w 1274
    //   27: bipush 28
    //   29: anewarray 21	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 1276
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 1278
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc_w 1280
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: ldc_w 1282
    //   55: aastore
    //   56: dup
    //   57: iconst_4
    //   58: ldc 75
    //   60: aastore
    //   61: dup
    //   62: iconst_5
    //   63: ldc_w 1284
    //   66: aastore
    //   67: dup
    //   68: bipush 6
    //   70: ldc 55
    //   72: aastore
    //   73: dup
    //   74: bipush 7
    //   76: ldc 59
    //   78: aastore
    //   79: dup
    //   80: bipush 8
    //   82: ldc 63
    //   84: aastore
    //   85: dup
    //   86: bipush 9
    //   88: ldc 67
    //   90: aastore
    //   91: dup
    //   92: bipush 10
    //   94: ldc 71
    //   96: aastore
    //   97: dup
    //   98: bipush 11
    //   100: ldc 79
    //   102: aastore
    //   103: dup
    //   104: bipush 12
    //   106: ldc 83
    //   108: aastore
    //   109: dup
    //   110: bipush 13
    //   112: ldc 87
    //   114: aastore
    //   115: dup
    //   116: bipush 14
    //   118: ldc 91
    //   120: aastore
    //   121: dup
    //   122: bipush 15
    //   124: ldc 99
    //   126: aastore
    //   127: dup
    //   128: bipush 16
    //   130: ldc 103
    //   132: aastore
    //   133: dup
    //   134: bipush 17
    //   136: ldc 107
    //   138: aastore
    //   139: dup
    //   140: bipush 18
    //   142: ldc 111
    //   144: aastore
    //   145: dup
    //   146: bipush 19
    //   148: ldc 115
    //   150: aastore
    //   151: dup
    //   152: bipush 20
    //   154: ldc 119
    //   156: aastore
    //   157: dup
    //   158: bipush 21
    //   160: ldc 123
    //   162: aastore
    //   163: dup
    //   164: bipush 22
    //   166: ldc 127
    //   168: aastore
    //   169: dup
    //   170: bipush 23
    //   172: ldc -125
    //   174: aastore
    //   175: dup
    //   176: bipush 24
    //   178: ldc -117
    //   180: aastore
    //   181: dup
    //   182: bipush 25
    //   184: ldc -109
    //   186: aastore
    //   187: dup
    //   188: bipush 26
    //   190: ldc -105
    //   192: aastore
    //   193: dup
    //   194: bipush 27
    //   196: ldc -101
    //   198: aastore
    //   199: ldc_w 807
    //   202: iconst_1
    //   203: anewarray 21	java/lang/String
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: aastore
    //   210: aconst_null
    //   211: aconst_null
    //   212: aconst_null
    //   213: invokevirtual 1028	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   216: astore_3
    //   217: aload_3
    //   218: astore_2
    //   219: aload_3
    //   220: invokeinterface 304 1 0
    //   225: istore 5
    //   227: iload 5
    //   229: ifne +11 -> 240
    //   232: aload_3
    //   233: invokeinterface 311 1 0
    //   238: aconst_null
    //   239: areturn
    //   240: aload_3
    //   241: astore_2
    //   242: new 1286	com/google/android/gms/measurement/internal/zzg
    //   245: astore 6
    //   247: aload_3
    //   248: astore_2
    //   249: aload 6
    //   251: aload_0
    //   252: getfield 347	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   255: invokevirtual 1289	com/google/android/gms/measurement/internal/zzkn:zzN	()Lcom/google/android/gms/measurement/internal/zzfu;
    //   258: aload_1
    //   259: invokespecial 1292	com/google/android/gms/measurement/internal/zzg:<init>	(Lcom/google/android/gms/measurement/internal/zzfu;Ljava/lang/String;)V
    //   262: aload_3
    //   263: astore_2
    //   264: aload 6
    //   266: aload_3
    //   267: iconst_0
    //   268: invokeinterface 505 2 0
    //   273: invokevirtual 1294	com/google/android/gms/measurement/internal/zzg:zze	(Ljava/lang/String;)V
    //   276: aload_3
    //   277: astore_2
    //   278: aload 6
    //   280: aload_3
    //   281: iconst_1
    //   282: invokeinterface 505 2 0
    //   287: invokevirtual 1296	com/google/android/gms/measurement/internal/zzg:zzg	(Ljava/lang/String;)V
    //   290: aload_3
    //   291: astore_2
    //   292: aload 6
    //   294: aload_3
    //   295: iconst_2
    //   296: invokeinterface 505 2 0
    //   301: invokevirtual 1298	com/google/android/gms/measurement/internal/zzg:zzm	(Ljava/lang/String;)V
    //   304: aload_3
    //   305: astore_2
    //   306: aload 6
    //   308: aload_3
    //   309: iconst_3
    //   310: invokeinterface 308 2 0
    //   315: invokevirtual 1300	com/google/android/gms/measurement/internal/zzg:zzH	(J)V
    //   318: aload_3
    //   319: astore_2
    //   320: aload 6
    //   322: aload_3
    //   323: iconst_4
    //   324: invokeinterface 308 2 0
    //   329: invokevirtual 1302	com/google/android/gms/measurement/internal/zzg:zzq	(J)V
    //   332: aload_3
    //   333: astore_2
    //   334: aload 6
    //   336: aload_3
    //   337: iconst_5
    //   338: invokeinterface 308 2 0
    //   343: invokevirtual 1304	com/google/android/gms/measurement/internal/zzg:zzs	(J)V
    //   346: aload_3
    //   347: astore_2
    //   348: aload 6
    //   350: aload_3
    //   351: bipush 6
    //   353: invokeinterface 505 2 0
    //   358: invokevirtual 1307	com/google/android/gms/measurement/internal/zzg:zzu	(Ljava/lang/String;)V
    //   361: aload_3
    //   362: astore_2
    //   363: aload 6
    //   365: aload_3
    //   366: bipush 7
    //   368: invokeinterface 505 2 0
    //   373: invokevirtual 1310	com/google/android/gms/measurement/internal/zzg:zzy	(Ljava/lang/String;)V
    //   376: aload_3
    //   377: astore_2
    //   378: aload 6
    //   380: aload_3
    //   381: bipush 8
    //   383: invokeinterface 308 2 0
    //   388: invokevirtual 1312	com/google/android/gms/measurement/internal/zzg:zzA	(J)V
    //   391: aload_3
    //   392: astore_2
    //   393: aload 6
    //   395: aload_3
    //   396: bipush 9
    //   398: invokeinterface 308 2 0
    //   403: invokevirtual 1314	com/google/android/gms/measurement/internal/zzg:zzC	(J)V
    //   406: aload_3
    //   407: astore_2
    //   408: aload_3
    //   409: bipush 10
    //   411: invokeinterface 1032 2 0
    //   416: ifne +25 -> 441
    //   419: aload_3
    //   420: astore_2
    //   421: aload_3
    //   422: bipush 10
    //   424: invokeinterface 1237 2 0
    //   429: ifeq +6 -> 435
    //   432: goto +9 -> 441
    //   435: iconst_0
    //   436: istore 5
    //   438: goto +6 -> 444
    //   441: iconst_1
    //   442: istore 5
    //   444: aload_3
    //   445: astore_2
    //   446: aload 6
    //   448: iload 5
    //   450: invokevirtual 1317	com/google/android/gms/measurement/internal/zzg:zzG	(Z)V
    //   453: aload_3
    //   454: astore_2
    //   455: aload 6
    //   457: aload_3
    //   458: bipush 11
    //   460: invokeinterface 308 2 0
    //   465: invokevirtual 1319	com/google/android/gms/measurement/internal/zzg:zzP	(J)V
    //   468: aload_3
    //   469: astore_2
    //   470: aload 6
    //   472: aload_3
    //   473: bipush 12
    //   475: invokeinterface 308 2 0
    //   480: invokevirtual 1321	com/google/android/gms/measurement/internal/zzg:zzR	(J)V
    //   483: aload_3
    //   484: astore_2
    //   485: aload 6
    //   487: aload_3
    //   488: bipush 13
    //   490: invokeinterface 308 2 0
    //   495: invokevirtual 1323	com/google/android/gms/measurement/internal/zzg:zzT	(J)V
    //   498: aload_3
    //   499: astore_2
    //   500: aload 6
    //   502: aload_3
    //   503: bipush 14
    //   505: invokeinterface 308 2 0
    //   510: invokevirtual 1325	com/google/android/gms/measurement/internal/zzg:zzV	(J)V
    //   513: aload_3
    //   514: astore_2
    //   515: aload 6
    //   517: aload_3
    //   518: bipush 15
    //   520: invokeinterface 308 2 0
    //   525: invokevirtual 1327	com/google/android/gms/measurement/internal/zzg:zzK	(J)V
    //   528: aload_3
    //   529: astore_2
    //   530: aload 6
    //   532: aload_3
    //   533: bipush 16
    //   535: invokeinterface 308 2 0
    //   540: invokevirtual 1329	com/google/android/gms/measurement/internal/zzg:zzM	(J)V
    //   543: aload_3
    //   544: astore_2
    //   545: aload_3
    //   546: bipush 17
    //   548: invokeinterface 1032 2 0
    //   553: ifeq +11 -> 564
    //   556: ldc2_w 1330
    //   559: lstore 7
    //   561: goto +16 -> 577
    //   564: aload_3
    //   565: astore_2
    //   566: aload_3
    //   567: bipush 17
    //   569: invokeinterface 1237 2 0
    //   574: i2l
    //   575: lstore 7
    //   577: aload_3
    //   578: astore_2
    //   579: aload 6
    //   581: lload 7
    //   583: invokevirtual 1334	com/google/android/gms/measurement/internal/zzg:zzw	(J)V
    //   586: aload_3
    //   587: astore_2
    //   588: aload 6
    //   590: aload_3
    //   591: bipush 18
    //   593: invokeinterface 505 2 0
    //   598: invokevirtual 1336	com/google/android/gms/measurement/internal/zzg:zzo	(Ljava/lang/String;)V
    //   601: aload_3
    //   602: astore_2
    //   603: aload 6
    //   605: aload_3
    //   606: bipush 19
    //   608: invokeinterface 308 2 0
    //   613: invokevirtual 1338	com/google/android/gms/measurement/internal/zzg:zzZ	(J)V
    //   616: aload_3
    //   617: astore_2
    //   618: aload 6
    //   620: aload_3
    //   621: bipush 20
    //   623: invokeinterface 308 2 0
    //   628: invokevirtual 1340	com/google/android/gms/measurement/internal/zzg:zzX	(J)V
    //   631: aload_3
    //   632: astore_2
    //   633: aload 6
    //   635: aload_3
    //   636: bipush 21
    //   638: invokeinterface 505 2 0
    //   643: invokevirtual 1342	com/google/android/gms/measurement/internal/zzg:zzac	(Ljava/lang/String;)V
    //   646: aload_3
    //   647: astore_2
    //   648: aload_0
    //   649: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   652: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   655: aconst_null
    //   656: getstatic 1345	com/google/android/gms/measurement/internal/zzea:zzat	Lcom/google/android/gms/measurement/internal/zzdz;
    //   659: invokevirtual 1348	com/google/android/gms/measurement/internal/zzae:zzn	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzdz;)Z
    //   662: istore 5
    //   664: lconst_0
    //   665: lstore 9
    //   667: iload 5
    //   669: ifne +43 -> 712
    //   672: aload_3
    //   673: astore_2
    //   674: aload_3
    //   675: bipush 22
    //   677: invokeinterface 1032 2 0
    //   682: ifeq +9 -> 691
    //   685: lconst_0
    //   686: lstore 7
    //   688: goto +15 -> 703
    //   691: aload_3
    //   692: astore_2
    //   693: aload_3
    //   694: bipush 22
    //   696: invokeinterface 308 2 0
    //   701: lstore 7
    //   703: aload_3
    //   704: astore_2
    //   705: aload 6
    //   707: lload 7
    //   709: invokevirtual 1351	com/google/android/gms/measurement/internal/zzg:zzae	(J)V
    //   712: iload 4
    //   714: istore 5
    //   716: aload_3
    //   717: astore_2
    //   718: aload_3
    //   719: bipush 23
    //   721: invokeinterface 1032 2 0
    //   726: ifne +26 -> 752
    //   729: aload_3
    //   730: astore_2
    //   731: aload_3
    //   732: bipush 23
    //   734: invokeinterface 1237 2 0
    //   739: ifeq +10 -> 749
    //   742: iload 4
    //   744: istore 5
    //   746: goto +6 -> 752
    //   749: iconst_0
    //   750: istore 5
    //   752: aload_3
    //   753: astore_2
    //   754: aload 6
    //   756: iload 5
    //   758: invokevirtual 1354	com/google/android/gms/measurement/internal/zzg:zzag	(Z)V
    //   761: aload_3
    //   762: astore_2
    //   763: aload 6
    //   765: aload_3
    //   766: bipush 24
    //   768: invokeinterface 505 2 0
    //   773: invokevirtual 1356	com/google/android/gms/measurement/internal/zzg:zzi	(Ljava/lang/String;)V
    //   776: aload_3
    //   777: astore_2
    //   778: aload_3
    //   779: bipush 25
    //   781: invokeinterface 1032 2 0
    //   786: ifeq +10 -> 796
    //   789: lload 9
    //   791: lstore 7
    //   793: goto +15 -> 808
    //   796: aload_3
    //   797: astore_2
    //   798: aload_3
    //   799: bipush 25
    //   801: invokeinterface 308 2 0
    //   806: lstore 7
    //   808: aload_3
    //   809: astore_2
    //   810: aload 6
    //   812: lload 7
    //   814: invokevirtual 1358	com/google/android/gms/measurement/internal/zzg:zzE	(J)V
    //   817: aload_3
    //   818: astore_2
    //   819: aload_3
    //   820: bipush 26
    //   822: invokeinterface 1032 2 0
    //   827: ifne +28 -> 855
    //   830: aload_3
    //   831: astore_2
    //   832: aload 6
    //   834: aload_3
    //   835: bipush 26
    //   837: invokeinterface 505 2 0
    //   842: ldc_w 436
    //   845: iconst_m1
    //   846: invokevirtual 1362	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   849: invokestatic 1013	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   852: invokevirtual 1365	com/google/android/gms/measurement/internal/zzg:zzak	(Ljava/util/List;)V
    //   855: aload_3
    //   856: astore_2
    //   857: invokestatic 1369	com/google/android/gms/internal/measurement/zzov:zzb	()Z
    //   860: pop
    //   861: aload_3
    //   862: astore_2
    //   863: aload_0
    //   864: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   867: invokevirtual 222	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   870: aload_1
    //   871: getstatic 1371	com/google/android/gms/measurement/internal/zzea:zzag	Lcom/google/android/gms/measurement/internal/zzdz;
    //   874: invokevirtual 1348	com/google/android/gms/measurement/internal/zzae:zzn	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzdz;)Z
    //   877: ifeq +18 -> 895
    //   880: aload_3
    //   881: astore_2
    //   882: aload 6
    //   884: aload_3
    //   885: bipush 27
    //   887: invokeinterface 505 2 0
    //   892: invokevirtual 1373	com/google/android/gms/measurement/internal/zzg:zzk	(Ljava/lang/String;)V
    //   895: aload_3
    //   896: astore_2
    //   897: aload 6
    //   899: invokevirtual 1375	com/google/android/gms/measurement/internal/zzg:zzb	()V
    //   902: aload_3
    //   903: astore_2
    //   904: aload_3
    //   905: invokeinterface 962 1 0
    //   910: ifeq +25 -> 935
    //   913: aload_3
    //   914: astore_2
    //   915: aload_0
    //   916: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   919: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   922: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   925: ldc_w 1377
    //   928: aload_1
    //   929: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   932: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   935: aload_3
    //   936: invokeinterface 311 1 0
    //   941: aload 6
    //   943: areturn
    //   944: astore 6
    //   946: goto +11 -> 957
    //   949: astore_1
    //   950: goto +44 -> 994
    //   953: astore 6
    //   955: aconst_null
    //   956: astore_3
    //   957: aload_3
    //   958: astore_2
    //   959: aload_0
    //   960: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   963: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   966: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   969: ldc_w 1379
    //   972: aload_1
    //   973: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   976: aload 6
    //   978: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   981: aload_3
    //   982: ifnull +9 -> 991
    //   985: aload_3
    //   986: invokeinterface 311 1 0
    //   991: aconst_null
    //   992: areturn
    //   993: astore_1
    //   994: aload_2
    //   995: ifnull +9 -> 1004
    //   998: aload_2
    //   999: invokeinterface 311 1 0
    //   1004: aload_1
    //   1005: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	zzai
    //   0	1006	1	paramString	String
    //   14	985	2	localObject1	Object
    //   19	967	3	localObject2	Object
    //   21	722	4	bool1	boolean
    //   225	532	5	bool2	boolean
    //   245	697	6	localzzg	zzg
    //   944	1	6	localSQLiteException1	SQLiteException
    //   953	24	6	localSQLiteException2	SQLiteException
    //   559	254	7	l1	long
    //   665	125	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   219	227	944	android/database/sqlite/SQLiteException
    //   242	247	944	android/database/sqlite/SQLiteException
    //   249	262	944	android/database/sqlite/SQLiteException
    //   264	276	944	android/database/sqlite/SQLiteException
    //   278	290	944	android/database/sqlite/SQLiteException
    //   292	304	944	android/database/sqlite/SQLiteException
    //   306	318	944	android/database/sqlite/SQLiteException
    //   320	332	944	android/database/sqlite/SQLiteException
    //   334	346	944	android/database/sqlite/SQLiteException
    //   348	361	944	android/database/sqlite/SQLiteException
    //   363	376	944	android/database/sqlite/SQLiteException
    //   378	391	944	android/database/sqlite/SQLiteException
    //   393	406	944	android/database/sqlite/SQLiteException
    //   408	419	944	android/database/sqlite/SQLiteException
    //   421	432	944	android/database/sqlite/SQLiteException
    //   446	453	944	android/database/sqlite/SQLiteException
    //   455	468	944	android/database/sqlite/SQLiteException
    //   470	483	944	android/database/sqlite/SQLiteException
    //   485	498	944	android/database/sqlite/SQLiteException
    //   500	513	944	android/database/sqlite/SQLiteException
    //   515	528	944	android/database/sqlite/SQLiteException
    //   530	543	944	android/database/sqlite/SQLiteException
    //   545	556	944	android/database/sqlite/SQLiteException
    //   566	577	944	android/database/sqlite/SQLiteException
    //   579	586	944	android/database/sqlite/SQLiteException
    //   588	601	944	android/database/sqlite/SQLiteException
    //   603	616	944	android/database/sqlite/SQLiteException
    //   618	631	944	android/database/sqlite/SQLiteException
    //   633	646	944	android/database/sqlite/SQLiteException
    //   648	664	944	android/database/sqlite/SQLiteException
    //   674	685	944	android/database/sqlite/SQLiteException
    //   693	703	944	android/database/sqlite/SQLiteException
    //   705	712	944	android/database/sqlite/SQLiteException
    //   718	729	944	android/database/sqlite/SQLiteException
    //   731	742	944	android/database/sqlite/SQLiteException
    //   754	761	944	android/database/sqlite/SQLiteException
    //   763	776	944	android/database/sqlite/SQLiteException
    //   778	789	944	android/database/sqlite/SQLiteException
    //   798	808	944	android/database/sqlite/SQLiteException
    //   810	817	944	android/database/sqlite/SQLiteException
    //   819	830	944	android/database/sqlite/SQLiteException
    //   832	855	944	android/database/sqlite/SQLiteException
    //   857	861	944	android/database/sqlite/SQLiteException
    //   863	880	944	android/database/sqlite/SQLiteException
    //   882	895	944	android/database/sqlite/SQLiteException
    //   897	902	944	android/database/sqlite/SQLiteException
    //   904	913	944	android/database/sqlite/SQLiteException
    //   915	935	944	android/database/sqlite/SQLiteException
    //   15	20	949	finally
    //   23	217	949	finally
    //   15	20	953	android/database/sqlite/SQLiteException
    //   23	217	953	android/database/sqlite/SQLiteException
    //   219	227	993	finally
    //   242	247	993	finally
    //   249	262	993	finally
    //   264	276	993	finally
    //   278	290	993	finally
    //   292	304	993	finally
    //   306	318	993	finally
    //   320	332	993	finally
    //   334	346	993	finally
    //   348	361	993	finally
    //   363	376	993	finally
    //   378	391	993	finally
    //   393	406	993	finally
    //   408	419	993	finally
    //   421	432	993	finally
    //   446	453	993	finally
    //   455	468	993	finally
    //   470	483	993	finally
    //   485	498	993	finally
    //   500	513	993	finally
    //   515	528	993	finally
    //   530	543	993	finally
    //   545	556	993	finally
    //   566	577	993	finally
    //   579	586	993	finally
    //   588	601	993	finally
    //   603	616	993	finally
    //   618	631	993	finally
    //   633	646	993	finally
    //   648	664	993	finally
    //   674	685	993	finally
    //   693	703	993	finally
    //   705	712	993	finally
    //   718	729	993	finally
    //   731	742	993	finally
    //   754	761	993	finally
    //   763	776	993	finally
    //   778	789	993	finally
    //   798	808	993	finally
    //   810	817	993	finally
    //   819	830	993	finally
    //   832	855	993	finally
    //   857	861	993	finally
    //   863	880	993	finally
    //   882	895	993	finally
    //   897	902	993	finally
    //   904	913	993	finally
    //   915	935	993	finally
    //   959	981	993	finally
  }
  
  @WorkerThread
  public final void zzt(zzg paramzzg)
  {
    Preconditions.checkNotNull(paramzzg);
    zzg();
    zzZ();
    String str = paramzzg.zzc();
    Preconditions.checkNotNull(str);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", str);
    localContentValues.put("app_instance_id", paramzzg.zzd());
    localContentValues.put("gmp_app_id", paramzzg.zzf());
    localContentValues.put("resettable_device_id_hash", paramzzg.zzl());
    localContentValues.put("last_bundle_index", Long.valueOf(paramzzg.zzI()));
    localContentValues.put("last_bundle_start_timestamp", Long.valueOf(paramzzg.zzp()));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzzg.zzr()));
    localContentValues.put("app_version", paramzzg.zzt());
    localContentValues.put("app_store", paramzzg.zzx());
    localContentValues.put("gmp_version", Long.valueOf(paramzzg.zzz()));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramzzg.zzB()));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramzzg.zzF()));
    localContentValues.put("day", Long.valueOf(paramzzg.zzO()));
    localContentValues.put("daily_public_events_count", Long.valueOf(paramzzg.zzQ()));
    localContentValues.put("daily_events_count", Long.valueOf(paramzzg.zzS()));
    localContentValues.put("daily_conversions_count", Long.valueOf(paramzzg.zzU()));
    localContentValues.put("config_fetched_time", Long.valueOf(paramzzg.zzJ()));
    localContentValues.put("failed_config_fetch_time", Long.valueOf(paramzzg.zzL()));
    localContentValues.put("app_version_int", Long.valueOf(paramzzg.zzv()));
    localContentValues.put("firebase_instance_id", paramzzg.zzn());
    localContentValues.put("daily_error_events_count", Long.valueOf(paramzzg.zzY()));
    localContentValues.put("daily_realtime_events_count", Long.valueOf(paramzzg.zzW()));
    localContentValues.put("health_monitor_sample", paramzzg.zzaa());
    localContentValues.put("android_id", Long.valueOf(paramzzg.zzad()));
    localContentValues.put("adid_reporting_enabled", Boolean.valueOf(paramzzg.zzaf()));
    localContentValues.put("admob_app_id", paramzzg.zzh());
    localContentValues.put("dynamite_version", Long.valueOf(paramzzg.zzD()));
    List localList = paramzzg.zzaj();
    if (localList != null) {
      if (localList.size() == 0) {
        this.zzs.zzau().zze().zzb("Safelisted events should not be an empty list. appId", str);
      } else {
        localContentValues.put("safelisted_events", TextUtils.join(",", localList));
      }
    }
    zzov.zzb();
    if (this.zzs.zzc().zzn(str, zzea.zzag)) {
      localContentValues.put("ga_app_id", paramzzg.zzj());
    }
    try
    {
      paramzzg = zze();
      if ((paramzzg.update("apps", localContentValues, "app_id = ?", new String[] { str }) == 0L) && (paramzzg.insertWithOnConflict("apps", null, localContentValues, 5) == -1L)) {
        this.zzs.zzau().zzb().zzb("Failed to insert/update app (got -1). appId", zzem.zzl(str));
      }
      return;
    }
    catch (SQLiteException paramzzg)
    {
      this.zzs.zzau().zzb().zzc("Error storing app. appId", zzem.zzl(str), paramzzg);
    }
  }
  
  @WorkerThread
  public final zzag zzu(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    return zzv(paramLong, paramString, 1L, false, false, paramBoolean3, false, paramBoolean5);
  }
  
  /* Error */
  @WorkerThread
  public final zzag zzv(long paramLong1, String paramString, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 257	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 335	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   9: aload_0
    //   10: invokevirtual 338	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   13: new 1453	com/google/android/gms/measurement/internal/zzag
    //   16: dup
    //   17: invokespecial 1454	com/google/android/gms/measurement/internal/zzag:<init>	()V
    //   20: astore 11
    //   22: aconst_null
    //   23: astore 12
    //   25: aconst_null
    //   26: astore 13
    //   28: aload 13
    //   30: astore 14
    //   32: aload 12
    //   34: astore 15
    //   36: aload_0
    //   37: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore 16
    //   42: aload 13
    //   44: astore 14
    //   46: aload 12
    //   48: astore 15
    //   50: aload 16
    //   52: ldc_w 1274
    //   55: bipush 6
    //   57: anewarray 21	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 79
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: ldc 87
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 83
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: ldc 91
    //   79: aastore
    //   80: dup
    //   81: iconst_4
    //   82: ldc 115
    //   84: aastore
    //   85: dup
    //   86: iconst_5
    //   87: ldc 119
    //   89: aastore
    //   90: ldc_w 807
    //   93: iconst_1
    //   94: anewarray 21	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: aload_3
    //   100: aastore
    //   101: aconst_null
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokevirtual 1028	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   107: astore 13
    //   109: aload 13
    //   111: astore 14
    //   113: aload 13
    //   115: astore 15
    //   117: aload 13
    //   119: invokeinterface 304 1 0
    //   124: ifne +41 -> 165
    //   127: aload 13
    //   129: astore 14
    //   131: aload 13
    //   133: astore 15
    //   135: aload_0
    //   136: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   139: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   142: invokevirtual 473	com/google/android/gms/measurement/internal/zzem:zze	()Lcom/google/android/gms/measurement/internal/zzek;
    //   145: ldc_w 1456
    //   148: aload_3
    //   149: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   152: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   155: aload 13
    //   157: invokeinterface 311 1 0
    //   162: aload 11
    //   164: areturn
    //   165: aload 13
    //   167: astore 14
    //   169: aload 13
    //   171: astore 15
    //   173: aload 13
    //   175: iconst_0
    //   176: invokeinterface 308 2 0
    //   181: lload_1
    //   182: lcmp
    //   183: ifne +108 -> 291
    //   186: aload 13
    //   188: astore 14
    //   190: aload 13
    //   192: astore 15
    //   194: aload 11
    //   196: aload 13
    //   198: iconst_1
    //   199: invokeinterface 308 2 0
    //   204: putfield 1458	com/google/android/gms/measurement/internal/zzag:zzb	J
    //   207: aload 13
    //   209: astore 14
    //   211: aload 13
    //   213: astore 15
    //   215: aload 11
    //   217: aload 13
    //   219: iconst_2
    //   220: invokeinterface 308 2 0
    //   225: putfield 1460	com/google/android/gms/measurement/internal/zzag:zza	J
    //   228: aload 13
    //   230: astore 14
    //   232: aload 13
    //   234: astore 15
    //   236: aload 11
    //   238: aload 13
    //   240: iconst_3
    //   241: invokeinterface 308 2 0
    //   246: putfield 1461	com/google/android/gms/measurement/internal/zzag:zzc	J
    //   249: aload 13
    //   251: astore 14
    //   253: aload 13
    //   255: astore 15
    //   257: aload 11
    //   259: aload 13
    //   261: iconst_4
    //   262: invokeinterface 308 2 0
    //   267: putfield 1462	com/google/android/gms/measurement/internal/zzag:zzd	J
    //   270: aload 13
    //   272: astore 14
    //   274: aload 13
    //   276: astore 15
    //   278: aload 11
    //   280: aload 13
    //   282: iconst_5
    //   283: invokeinterface 308 2 0
    //   288: putfield 1463	com/google/android/gms/measurement/internal/zzag:zze	J
    //   291: iload 6
    //   293: ifeq +24 -> 317
    //   296: aload 13
    //   298: astore 14
    //   300: aload 13
    //   302: astore 15
    //   304: aload 11
    //   306: aload 11
    //   308: getfield 1458	com/google/android/gms/measurement/internal/zzag:zzb	J
    //   311: lload 4
    //   313: ladd
    //   314: putfield 1458	com/google/android/gms/measurement/internal/zzag:zzb	J
    //   317: iload 7
    //   319: ifeq +24 -> 343
    //   322: aload 13
    //   324: astore 14
    //   326: aload 13
    //   328: astore 15
    //   330: aload 11
    //   332: aload 11
    //   334: getfield 1460	com/google/android/gms/measurement/internal/zzag:zza	J
    //   337: lload 4
    //   339: ladd
    //   340: putfield 1460	com/google/android/gms/measurement/internal/zzag:zza	J
    //   343: iload 8
    //   345: ifeq +24 -> 369
    //   348: aload 13
    //   350: astore 14
    //   352: aload 13
    //   354: astore 15
    //   356: aload 11
    //   358: aload 11
    //   360: getfield 1461	com/google/android/gms/measurement/internal/zzag:zzc	J
    //   363: lload 4
    //   365: ladd
    //   366: putfield 1461	com/google/android/gms/measurement/internal/zzag:zzc	J
    //   369: iload 9
    //   371: ifeq +24 -> 395
    //   374: aload 13
    //   376: astore 14
    //   378: aload 13
    //   380: astore 15
    //   382: aload 11
    //   384: aload 11
    //   386: getfield 1462	com/google/android/gms/measurement/internal/zzag:zzd	J
    //   389: lload 4
    //   391: ladd
    //   392: putfield 1462	com/google/android/gms/measurement/internal/zzag:zzd	J
    //   395: iload 10
    //   397: ifeq +24 -> 421
    //   400: aload 13
    //   402: astore 14
    //   404: aload 13
    //   406: astore 15
    //   408: aload 11
    //   410: aload 11
    //   412: getfield 1463	com/google/android/gms/measurement/internal/zzag:zze	J
    //   415: lload 4
    //   417: ladd
    //   418: putfield 1463	com/google/android/gms/measurement/internal/zzag:zze	J
    //   421: aload 13
    //   423: astore 14
    //   425: aload 13
    //   427: astore 15
    //   429: new 263	android/content/ContentValues
    //   432: astore 12
    //   434: aload 13
    //   436: astore 14
    //   438: aload 13
    //   440: astore 15
    //   442: aload 12
    //   444: invokespecial 537	android/content/ContentValues:<init>	()V
    //   447: aload 13
    //   449: astore 14
    //   451: aload 13
    //   453: astore 15
    //   455: aload 12
    //   457: ldc 79
    //   459: lload_1
    //   460: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   463: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   466: aload 13
    //   468: astore 14
    //   470: aload 13
    //   472: astore 15
    //   474: aload 12
    //   476: ldc 83
    //   478: aload 11
    //   480: getfield 1460	com/google/android/gms/measurement/internal/zzag:zza	J
    //   483: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   486: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   489: aload 13
    //   491: astore 14
    //   493: aload 13
    //   495: astore 15
    //   497: aload 12
    //   499: ldc 87
    //   501: aload 11
    //   503: getfield 1458	com/google/android/gms/measurement/internal/zzag:zzb	J
    //   506: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   512: aload 13
    //   514: astore 14
    //   516: aload 13
    //   518: astore 15
    //   520: aload 12
    //   522: ldc 91
    //   524: aload 11
    //   526: getfield 1461	com/google/android/gms/measurement/internal/zzag:zzc	J
    //   529: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   532: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   535: aload 13
    //   537: astore 14
    //   539: aload 13
    //   541: astore 15
    //   543: aload 12
    //   545: ldc 115
    //   547: aload 11
    //   549: getfield 1462	com/google/android/gms/measurement/internal/zzag:zzd	J
    //   552: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   555: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   558: aload 13
    //   560: astore 14
    //   562: aload 13
    //   564: astore 15
    //   566: aload 12
    //   568: ldc 119
    //   570: aload 11
    //   572: getfield 1463	com/google/android/gms/measurement/internal/zzag:zze	J
    //   575: invokestatic 515	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   578: invokevirtual 272	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   581: aload 13
    //   583: astore 14
    //   585: aload 13
    //   587: astore 15
    //   589: aload 16
    //   591: ldc_w 1274
    //   594: aload 12
    //   596: ldc_w 807
    //   599: iconst_1
    //   600: anewarray 21	java/lang/String
    //   603: dup
    //   604: iconst_0
    //   605: aload_3
    //   606: aastore
    //   607: invokevirtual 563	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   610: pop
    //   611: aload 13
    //   613: invokeinterface 311 1 0
    //   618: aload 11
    //   620: areturn
    //   621: astore_3
    //   622: goto +46 -> 668
    //   625: astore 13
    //   627: aload 15
    //   629: astore 14
    //   631: aload_0
    //   632: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   635: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   638: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   641: ldc_w 1465
    //   644: aload_3
    //   645: invokestatic 554	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   648: aload 13
    //   650: invokevirtual 330	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   653: aload 15
    //   655: ifnull +10 -> 665
    //   658: aload 15
    //   660: invokeinterface 311 1 0
    //   665: aload 11
    //   667: areturn
    //   668: aload 14
    //   670: ifnull +10 -> 680
    //   673: aload 14
    //   675: invokeinterface 311 1 0
    //   680: aload_3
    //   681: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	zzai
    //   0	682	1	paramLong1	long
    //   0	682	3	paramString	String
    //   0	682	4	paramLong2	long
    //   0	682	6	paramBoolean1	boolean
    //   0	682	7	paramBoolean2	boolean
    //   0	682	8	paramBoolean3	boolean
    //   0	682	9	paramBoolean4	boolean
    //   0	682	10	paramBoolean5	boolean
    //   20	646	11	localzzag	zzag
    //   23	572	12	localContentValues	ContentValues
    //   26	586	13	localCursor	Cursor
    //   625	24	13	localSQLiteException	SQLiteException
    //   30	644	14	localObject1	Object
    //   34	625	15	localObject2	Object
    //   40	550	16	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   36	42	621	finally
    //   50	109	621	finally
    //   117	127	621	finally
    //   135	155	621	finally
    //   173	186	621	finally
    //   194	207	621	finally
    //   215	228	621	finally
    //   236	249	621	finally
    //   257	270	621	finally
    //   278	291	621	finally
    //   304	317	621	finally
    //   330	343	621	finally
    //   356	369	621	finally
    //   382	395	621	finally
    //   408	421	621	finally
    //   429	434	621	finally
    //   442	447	621	finally
    //   455	466	621	finally
    //   474	489	621	finally
    //   497	512	621	finally
    //   520	535	621	finally
    //   543	558	621	finally
    //   566	581	621	finally
    //   589	611	621	finally
    //   631	653	621	finally
    //   36	42	625	android/database/sqlite/SQLiteException
    //   50	109	625	android/database/sqlite/SQLiteException
    //   117	127	625	android/database/sqlite/SQLiteException
    //   135	155	625	android/database/sqlite/SQLiteException
    //   173	186	625	android/database/sqlite/SQLiteException
    //   194	207	625	android/database/sqlite/SQLiteException
    //   215	228	625	android/database/sqlite/SQLiteException
    //   236	249	625	android/database/sqlite/SQLiteException
    //   257	270	625	android/database/sqlite/SQLiteException
    //   278	291	625	android/database/sqlite/SQLiteException
    //   304	317	625	android/database/sqlite/SQLiteException
    //   330	343	625	android/database/sqlite/SQLiteException
    //   356	369	625	android/database/sqlite/SQLiteException
    //   382	395	625	android/database/sqlite/SQLiteException
    //   408	421	625	android/database/sqlite/SQLiteException
    //   429	434	625	android/database/sqlite/SQLiteException
    //   442	447	625	android/database/sqlite/SQLiteException
    //   455	466	625	android/database/sqlite/SQLiteException
    //   474	489	625	android/database/sqlite/SQLiteException
    //   497	512	625	android/database/sqlite/SQLiteException
    //   520	535	625	android/database/sqlite/SQLiteException
    //   543	558	625	android/database/sqlite/SQLiteException
    //   566	581	625	android/database/sqlite/SQLiteException
    //   589	611	625	android/database/sqlite/SQLiteException
  }
  
  @WorkerThread
  public final void zzw(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    zzg();
    zzZ();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("remote_config", paramArrayOfByte);
    localContentValues.put("config_last_modified_time", paramString2);
    try
    {
      if (zze().update("apps", localContentValues, "app_id = ?", new String[] { paramString1 }) == 0L) {
        this.zzs.zzau().zzb().zzb("Failed to update remote config (got 0). appId", zzem.zzl(paramString1));
      }
      return;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      this.zzs.zzau().zzb().zzc("Error storing remote config. appId", zzem.zzl(paramString1), paramArrayOfByte);
    }
  }
  
  @WorkerThread
  public final boolean zzx(zzfw paramzzfw, boolean paramBoolean)
  {
    zzg();
    zzZ();
    Preconditions.checkNotNull(paramzzfw);
    Preconditions.checkNotEmpty(paramzzfw.zzA());
    Preconditions.checkState(paramzzfw.zzn());
    zzA();
    long l1 = this.zzs.zzay().currentTimeMillis();
    long l2 = paramzzfw.zzo();
    this.zzs.zzc();
    if (l2 >= l1 - zzae.zzA())
    {
      l2 = paramzzfw.zzo();
      this.zzs.zzc();
      if (l2 <= zzae.zzA() + l1) {}
    }
    else
    {
      this.zzs.zzau().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzem.zzl(paramzzfw.zzA()), Long.valueOf(l1), Long.valueOf(paramzzfw.zzo()));
    }
    byte[] arrayOfByte = paramzzfw.zzbp();
    try
    {
      arrayOfByte = this.zzf.zzm().zzs(arrayOfByte);
      this.zzs.zzau().zzk().zzb("Saving bundle, size", Integer.valueOf(arrayOfByte.length));
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("app_id", paramzzfw.zzA());
      localContentValues.put("bundle_end_timestamp", Long.valueOf(paramzzfw.zzo()));
      localContentValues.put("data", arrayOfByte);
      localContentValues.put("has_realtime", Integer.valueOf(paramBoolean));
      if (paramzzfw.zzab()) {
        localContentValues.put("retry_count", Integer.valueOf(paramzzfw.zzac()));
      }
      try
      {
        if (zze().insert("queue", null, localContentValues) == -1L)
        {
          this.zzs.zzau().zzb().zzb("Failed to insert bundle (got -1). appId", zzem.zzl(paramzzfw.zzA()));
          return false;
        }
        return true;
      }
      catch (SQLiteException localSQLiteException)
      {
        this.zzs.zzau().zzb().zzc("Error storing bundle. appId", zzem.zzl(paramzzfw.zzA()), localSQLiteException);
        return false;
      }
      return false;
    }
    catch (IOException localIOException)
    {
      this.zzs.zzau().zzb().zzc("Data loss. Failed to serialize bundle. appId", zzem.zzl(paramzzfw.zzA()), localIOException);
    }
  }
  
  /* Error */
  @WorkerThread
  public final String zzy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 292	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: ldc_w 1507
    //   11: aconst_null
    //   12: invokevirtual 298	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_3
    //   16: aload_3
    //   17: astore_1
    //   18: aload_3
    //   19: invokeinterface 304 1 0
    //   24: ifeq +21 -> 45
    //   27: aload_3
    //   28: astore_1
    //   29: aload_3
    //   30: iconst_0
    //   31: invokeinterface 505 2 0
    //   36: astore_2
    //   37: aload_3
    //   38: invokeinterface 311 1 0
    //   43: aload_2
    //   44: areturn
    //   45: aload_3
    //   46: invokeinterface 311 1 0
    //   51: aconst_null
    //   52: areturn
    //   53: astore_2
    //   54: goto +12 -> 66
    //   57: astore_1
    //   58: aload_2
    //   59: astore_3
    //   60: goto +42 -> 102
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_3
    //   67: astore_1
    //   68: aload_0
    //   69: getfield 208	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   72: invokevirtual 318	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   75: invokevirtual 323	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   78: ldc_w 1509
    //   81: aload_2
    //   82: invokevirtual 421	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   85: aload_3
    //   86: ifnull +9 -> 95
    //   89: aload_3
    //   90: invokeinterface 311 1 0
    //   95: aconst_null
    //   96: areturn
    //   97: astore_2
    //   98: aload_1
    //   99: astore_3
    //   100: aload_2
    //   101: astore_1
    //   102: aload_3
    //   103: ifnull +9 -> 112
    //   106: aload_3
    //   107: invokeinterface 311 1 0
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	zzai
    //   4	25	1	localObject1	Object
    //   57	1	1	localObject2	Object
    //   67	46	1	localObject3	Object
    //   6	38	2	str	String
    //   53	6	2	localSQLiteException1	SQLiteException
    //   63	19	2	localSQLiteException2	SQLiteException
    //   97	4	2	localObject4	Object
    //   15	92	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	53	android/database/sqlite/SQLiteException
    //   29	37	53	android/database/sqlite/SQLiteException
    //   7	16	57	finally
    //   7	16	63	android/database/sqlite/SQLiteException
    //   18	27	97	finally
    //   29	37	97	finally
    //   68	85	97	finally
  }
  
  public final boolean zzz()
  {
    return zzab("select count(1) > 0 from queue where has_realtime = 1", null) != 0L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */