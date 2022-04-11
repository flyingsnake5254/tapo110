package org.greenrobot.greendao.database;

import android.database.Cursor;
import android.database.SQLException;

public abstract interface Database
{
  public abstract void beginTransaction();
  
  public abstract void close();
  
  public abstract DatabaseStatement compileStatement(String paramString);
  
  public abstract void endTransaction();
  
  public abstract void execSQL(String paramString)
    throws SQLException;
  
  public abstract void execSQL(String paramString, Object[] paramArrayOfObject)
    throws SQLException;
  
  public abstract Object getRawDatabase();
  
  public abstract boolean inTransaction();
  
  public abstract boolean isDbLockedByCurrentThread();
  
  public abstract boolean isOpen();
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
  
  public abstract void setTransactionSuccessful();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\database\Database.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */