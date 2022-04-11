package com.tplink.libtpmediaother.database.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class a
  extends AbstractDaoMaster
{
  public a(SQLiteDatabase paramSQLiteDatabase)
  {
    this(new StandardDatabase(paramSQLiteDatabase));
  }
  
  public a(Database paramDatabase)
  {
    super(paramDatabase, 5);
    registerDaoClass(DeviceInfoDao.class);
    registerDaoClass(FileMemoryInfoDao.class);
    registerDaoClass(ModeSettingInfoDao.class);
  }
  
  public static void a(Database paramDatabase, boolean paramBoolean)
  {
    DeviceInfoDao.c(paramDatabase, paramBoolean);
    FileMemoryInfoDao.c(paramDatabase, paramBoolean);
    ModeSettingInfoDao.c(paramDatabase, paramBoolean);
  }
  
  public static void b(Database paramDatabase, boolean paramBoolean)
  {
    DeviceInfoDao.d(paramDatabase, paramBoolean);
    FileMemoryInfoDao.d(paramDatabase, paramBoolean);
    ModeSettingInfoDao.d(paramDatabase, paramBoolean);
  }
  
  public b c()
  {
    return new b(this.db, IdentityScopeType.Session, this.daoConfigMap);
  }
  
  public b d(IdentityScopeType paramIdentityScopeType)
  {
    return new b(this.db, paramIdentityScopeType, this.daoConfigMap);
  }
  
  public static abstract class a
    extends DatabaseOpenHelper
  {
    public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory, 5);
    }
    
    public void onCreate(Database paramDatabase)
    {
      Log.i("greenDAO", "Creating tables for schema version 5");
      a.a(paramDatabase, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\database\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */