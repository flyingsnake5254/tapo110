package com.tplink.libtpanalytics.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.tplink.libtpanalytics.database.d.b;
import com.tplink.libtpanalytics.database.e.e;

@Database(entities={b.class, com.tplink.libtpanalytics.database.d.c.class, com.tplink.libtpanalytics.database.d.a.class}, version=3)
public abstract class AppDatabase
  extends RoomDatabase
{
  public abstract com.tplink.libtpanalytics.database.e.a a();
  
  public abstract com.tplink.libtpanalytics.database.e.c b();
  
  public abstract e c();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\AppDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */