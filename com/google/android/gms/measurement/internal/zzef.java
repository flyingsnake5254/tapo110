package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

@VisibleForTesting
final class zzef
  extends SQLiteOpenHelper
{
  zzef(zzeg paramzzeg, Context paramContext, String paramString)
  {
    super(paramContext, "google_app_measurement_local.db", null, 1);
  }
  
  @WorkerThread
  public final SQLiteDatabase getWritableDatabase()
    throws SQLiteException
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = super.getWritableDatabase();
      return localSQLiteDatabase1;
    }
    catch (SQLiteException localSQLiteException1)
    {
      this.zza.zzs.zzau().zzb().zza("Opening the local database failed, dropping and recreating it");
      this.zza.zzs.zzc();
      if (!this.zza.zzs.zzax().getDatabasePath("google_app_measurement_local.db").delete()) {
        this.zza.zzs.zzau().zzb().zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        return localSQLiteDatabase2;
      }
      catch (SQLiteException localSQLiteException2)
      {
        this.zza.zzs.zzau().zzb().zzb("Failed to open local database. Events will bypass local storage", localSQLiteException2);
        return null;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      throw localSQLiteDatabaseLockedException;
    }
  }
  
  @WorkerThread
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzaj.zzb(this.zza.zzs.zzau(), paramSQLiteDatabase);
  }
  
  @WorkerThread
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  @WorkerThread
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
  }
  
  @WorkerThread
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */