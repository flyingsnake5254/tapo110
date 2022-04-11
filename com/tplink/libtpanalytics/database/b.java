package com.tplink.libtpanalytics.database;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class b
{
  public static final Migration a = new a(1, 2);
  public static final Migration b = new b(2, 3);
  public static final Migration c = new c(1, 3);
  
  class a
    extends Migration
  {
    a(int paramInt)
    {
      super(paramInt);
    }
    
    public void migrate(@NonNull SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      paramSupportSQLiteDatabase.execSQL("ALTER TABLE EVENT ADD COLUMN ENCRYPT_VERSION_ID TEXT NOT NULL DEFAULT ''");
      paramSupportSQLiteDatabase.execSQL("ALTER TABLE TEMP_EVENT ADD COLUMN ENCRYPT_VERSION_ID TEXT NOT NULL DEFAULT ''");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ENCRYPT` (`ENCRYPT_VERSION_ID` TEXT NOT NULL, `TRANSFORMATION` TEXT NOT NULL, `KEY` TEXT NOT NULL, `KEY_SIZE` INTEGER NOT NULL, PRIMARY KEY(`ENCRYPT_VERSION_ID`))");
    }
  }
  
  class b
    extends Migration
  {
    b(int paramInt)
    {
      super(paramInt);
    }
    
    public void migrate(@NonNull SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      paramSupportSQLiteDatabase.execSQL("DROP TABLE TEMP_EVENT");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TEMP_EVENT` (`EVENT_ID` TEXT NOT NULL, `LEN` INTEGER NOT NULL, PRIMARY KEY(`EVENT_ID`))");
    }
  }
  
  class c
    extends Migration
  {
    c(int paramInt)
    {
      super(paramInt);
    }
    
    public void migrate(@NonNull SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      paramSupportSQLiteDatabase.execSQL("ALTER TABLE EVENT ADD COLUMN ENCRYPT_VERSION_ID TEXT NOT NULL DEFAULT ''");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ENCRYPT` (`ENCRYPT_VERSION_ID` TEXT NOT NULL, `TRANSFORMATION` TEXT NOT NULL, `KEY` TEXT NOT NULL, `KEY_SIZE` INTEGER NOT NULL, PRIMARY KEY(`ENCRYPT_VERSION_ID`))");
      paramSupportSQLiteDatabase.execSQL("DROP TABLE TEMP_EVENT");
      paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TEMP_EVENT` (`EVENT_ID` TEXT NOT NULL, `LEN` INTEGER NOT NULL, PRIMARY KEY(`EVENT_ID`))");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */