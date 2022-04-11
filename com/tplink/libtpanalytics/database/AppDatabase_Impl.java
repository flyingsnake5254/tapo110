package com.tplink.libtpanalytics.database;

import android.database.Cursor;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase.Callback;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import com.tplink.libtpanalytics.database.e.a;
import com.tplink.libtpanalytics.database.e.b;
import com.tplink.libtpanalytics.database.e.c;
import com.tplink.libtpanalytics.database.e.d;
import com.tplink.libtpanalytics.database.e.e;
import com.tplink.libtpanalytics.database.e.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class AppDatabase_Impl
  extends AppDatabase
{
  private volatile c a;
  private volatile e b;
  private volatile a c;
  
  public a a()
  {
    if (this.c != null) {
      return this.c;
    }
    try
    {
      if (this.c == null)
      {
        localObject1 = new com/tplink/libtpanalytics/database/e/b;
        ((b)localObject1).<init>(this);
        this.c = ((a)localObject1);
      }
      Object localObject1 = this.c;
      return (a)localObject1;
    }
    finally {}
  }
  
  public c b()
  {
    if (this.a != null) {
      return this.a;
    }
    try
    {
      if (this.a == null)
      {
        localObject1 = new com/tplink/libtpanalytics/database/e/d;
        ((d)localObject1).<init>(this);
        this.a = ((c)localObject1);
      }
      Object localObject1 = this.a;
      return (c)localObject1;
    }
    finally {}
  }
  
  public e c()
  {
    if (this.b != null) {
      return this.b;
    }
    try
    {
      if (this.b == null)
      {
        localObject1 = new com/tplink/libtpanalytics/database/e/f;
        ((f)localObject1).<init>(this);
        this.b = ((e)localObject1);
      }
      Object localObject1 = this.b;
      return (e)localObject1;
    }
    finally {}
  }
  
  public void clearAllTables()
  {
    super.assertNotMainThread();
    SupportSQLiteDatabase localSupportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
    try
    {
      super.beginTransaction();
      localSupportSQLiteDatabase.execSQL("DELETE FROM `EVENT`");
      localSupportSQLiteDatabase.execSQL("DELETE FROM `TEMP_EVENT`");
      localSupportSQLiteDatabase.execSQL("DELETE FROM `ENCRYPT`");
      super.setTransactionSuccessful();
      return;
    }
    finally
    {
      super.endTransaction();
      localSupportSQLiteDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!localSupportSQLiteDatabase.inTransaction()) {
        localSupportSQLiteDatabase.execSQL("VACUUM");
      }
    }
  }
  
  protected InvalidationTracker createInvalidationTracker()
  {
    return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[] { "EVENT", "TEMP_EVENT", "ENCRYPT" });
  }
  
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration paramDatabaseConfiguration)
  {
    Object localObject = new RoomOpenHelper(paramDatabaseConfiguration, new a(3), "b97075af58af54ef618b2964fffe826b", "a81320292e4823d4e79369673bb5079c");
    localObject = SupportSQLiteOpenHelper.Configuration.builder(paramDatabaseConfiguration.context).name(paramDatabaseConfiguration.name).callback((SupportSQLiteOpenHelper.Callback)localObject).build();
    return paramDatabaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper.Configuration)localObject);
  }
  
  class a
    extends RoomOpenHelper.Delegate
  {
    a(int paramInt)
    {
      super();
    }
    
    public void createAllTables(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `EVENT` (`EVENT_ID` TEXT NOT NULL, `EVENT_NAME` TEXT NOT NULL, `USER_ID` TEXT, `TIME` INTEGER NOT NULL, `ENCRYPTED_PARAM` TEXT, `PLAINTEXT_PARAM` TEXT, `LEN` INTEGER NOT NULL, `ENCRYPT_VER` INTEGER NOT NULL, `APP_VER` TEXT, `REGION` TEXT, `OS_VER` TEXT, `LANGUAGE` TEXT, `ENCRYPT_VERSION_ID` TEXT NOT NULL, PRIMARY KEY(`EVENT_ID`))");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TEMP_EVENT` (`EVENT_ID` TEXT NOT NULL, `LEN` INTEGER NOT NULL, PRIMARY KEY(`EVENT_ID`))");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ENCRYPT` (`ENCRYPT_VERSION_ID` TEXT NOT NULL, `TRANSFORMATION` TEXT NOT NULL, `KEY` TEXT NOT NULL, `KEY_SIZE` INTEGER NOT NULL, PRIMARY KEY(`ENCRYPT_VERSION_ID`))");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
      paramSupportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b97075af58af54ef618b2964fffe826b')");
    }
    
    public void dropAllTables(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      paramSupportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `EVENT`");
      paramSupportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TEMP_EVENT`");
      paramSupportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ENCRYPT`");
      if (AppDatabase_Impl.d(AppDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = AppDatabase_Impl.e(AppDatabase_Impl.this).size();
        while (i < j)
        {
          ((RoomDatabase.Callback)AppDatabase_Impl.g(AppDatabase_Impl.this).get(i)).onDestructiveMigration(paramSupportSQLiteDatabase);
          i++;
        }
      }
    }
    
    protected void onCreate(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      if (AppDatabase_Impl.h(AppDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = AppDatabase_Impl.i(AppDatabase_Impl.this).size();
        while (i < j)
        {
          ((RoomDatabase.Callback)AppDatabase_Impl.j(AppDatabase_Impl.this).get(i)).onCreate(paramSupportSQLiteDatabase);
          i++;
        }
      }
    }
    
    public void onOpen(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      AppDatabase_Impl.k(AppDatabase_Impl.this, paramSupportSQLiteDatabase);
      AppDatabase_Impl.l(AppDatabase_Impl.this, paramSupportSQLiteDatabase);
      if (AppDatabase_Impl.m(AppDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = AppDatabase_Impl.n(AppDatabase_Impl.this).size();
        while (i < j)
        {
          ((RoomDatabase.Callback)AppDatabase_Impl.f(AppDatabase_Impl.this).get(i)).onOpen(paramSupportSQLiteDatabase);
          i++;
        }
      }
    }
    
    public void onPostMigrate(SupportSQLiteDatabase paramSupportSQLiteDatabase) {}
    
    public void onPreMigrate(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      DBUtil.dropFtsSyncTriggers(paramSupportSQLiteDatabase);
    }
    
    protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      Object localObject1 = new HashMap(13);
      ((HashMap)localObject1).put("EVENT_ID", new TableInfo.Column("EVENT_ID", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("EVENT_NAME", new TableInfo.Column("EVENT_NAME", "TEXT", true, 0, null, 1));
      ((HashMap)localObject1).put("USER_ID", new TableInfo.Column("USER_ID", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("TIME", new TableInfo.Column("TIME", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("ENCRYPTED_PARAM", new TableInfo.Column("ENCRYPTED_PARAM", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("PLAINTEXT_PARAM", new TableInfo.Column("PLAINTEXT_PARAM", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("LEN", new TableInfo.Column("LEN", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("ENCRYPT_VER", new TableInfo.Column("ENCRYPT_VER", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("APP_VER", new TableInfo.Column("APP_VER", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("REGION", new TableInfo.Column("REGION", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("OS_VER", new TableInfo.Column("OS_VER", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("LANGUAGE", new TableInfo.Column("LANGUAGE", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("ENCRYPT_VERSION_ID", new TableInfo.Column("ENCRYPT_VERSION_ID", "TEXT", true, 0, null, 1));
      Object localObject2 = new TableInfo("EVENT", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject1 = TableInfo.read(paramSupportSQLiteDatabase, "EVENT");
      if (!((TableInfo)localObject2).equals(localObject1))
      {
        paramSupportSQLiteDatabase = new StringBuilder();
        paramSupportSQLiteDatabase.append("EVENT(com.tplink.libtpanalytics.database.bean.Event).\n Expected:\n");
        paramSupportSQLiteDatabase.append(localObject2);
        paramSupportSQLiteDatabase.append("\n Found:\n");
        paramSupportSQLiteDatabase.append(localObject1);
        return new RoomOpenHelper.ValidationResult(false, paramSupportSQLiteDatabase.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("EVENT_ID", new TableInfo.Column("EVENT_ID", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("LEN", new TableInfo.Column("LEN", "INTEGER", true, 0, null, 1));
      localObject2 = new TableInfo("TEMP_EVENT", (Map)localObject1, new HashSet(0), new HashSet(0));
      localObject1 = TableInfo.read(paramSupportSQLiteDatabase, "TEMP_EVENT");
      if (!((TableInfo)localObject2).equals(localObject1))
      {
        paramSupportSQLiteDatabase = new StringBuilder();
        paramSupportSQLiteDatabase.append("TEMP_EVENT(com.tplink.libtpanalytics.database.bean.TempEvent).\n Expected:\n");
        paramSupportSQLiteDatabase.append(localObject2);
        paramSupportSQLiteDatabase.append("\n Found:\n");
        paramSupportSQLiteDatabase.append(localObject1);
        return new RoomOpenHelper.ValidationResult(false, paramSupportSQLiteDatabase.toString());
      }
      localObject1 = new HashMap(4);
      ((HashMap)localObject1).put("ENCRYPT_VERSION_ID", new TableInfo.Column("ENCRYPT_VERSION_ID", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("TRANSFORMATION", new TableInfo.Column("TRANSFORMATION", "TEXT", true, 0, null, 1));
      ((HashMap)localObject1).put("KEY", new TableInfo.Column("KEY", "TEXT", true, 0, null, 1));
      ((HashMap)localObject1).put("KEY_SIZE", new TableInfo.Column("KEY_SIZE", "INTEGER", true, 0, null, 1));
      localObject1 = new TableInfo("ENCRYPT", (Map)localObject1, new HashSet(0), new HashSet(0));
      paramSupportSQLiteDatabase = TableInfo.read(paramSupportSQLiteDatabase, "ENCRYPT");
      if (!((TableInfo)localObject1).equals(paramSupportSQLiteDatabase))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ENCRYPT(com.tplink.libtpanalytics.database.bean.EncryptInfo).\n Expected:\n");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("\n Found:\n");
        ((StringBuilder)localObject2).append(paramSupportSQLiteDatabase);
        return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)localObject2).toString());
      }
      return new RoomOpenHelper.ValidationResult(true, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\AppDatabase_Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */