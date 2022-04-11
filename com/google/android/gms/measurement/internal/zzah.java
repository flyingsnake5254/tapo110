package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

@VisibleForTesting
final class zzah
  extends SQLiteOpenHelper
{
  zzah(zzai paramzzai, Context paramContext, String paramString)
  {
    super(paramContext, "google_app_measurement.db", null, 1);
  }
  
  @WorkerThread
  public final SQLiteDatabase getWritableDatabase()
  {
    Object localObject = zzai.zzN(this.zza);
    this.zza.zzs.zzc();
    if (((zzka)localObject).zzc(3600000L)) {
      try
      {
        localObject = super.getWritableDatabase();
        return (SQLiteDatabase)localObject;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zzai.zzN(this.zza).zza();
        this.zza.zzs.zzau().zzb().zza("Opening the database failed, dropping and recreating it");
        this.zza.zzs.zzc();
        if (!this.zza.zzs.zzax().getDatabasePath("google_app_measurement.db").delete()) {
          this.zza.zzs.zzau().zzb().zzb("Failed to delete corrupted db file", "google_app_measurement.db");
        }
        try
        {
          SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
          zzai.zzN(this.zza).zzb();
          return localSQLiteDatabase;
        }
        catch (SQLiteException localSQLiteException2)
        {
          this.zza.zzs.zzau().zzb().zzb("Failed to open freshly created database", localSQLiteException2);
          throw localSQLiteException2;
        }
      }
    }
    throw new SQLiteException("Database open failed");
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
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzai.zzO());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzai.zzP());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzai.zzQ());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzai.zzR());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzai.zzS());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", zzai.zzT());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", zzai.zzU());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzai.zzV());
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
    zzaj.zza(this.zza.zzs.zzau(), paramSQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
  }
  
  @WorkerThread
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */