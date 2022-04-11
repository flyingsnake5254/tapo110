package org.greenrobot.greendao.database;

import android.database.sqlite.SQLiteStatement;

public class StandardDatabaseStatement
  implements DatabaseStatement
{
  private final SQLiteStatement delegate;
  
  public StandardDatabaseStatement(SQLiteStatement paramSQLiteStatement)
  {
    this.delegate = paramSQLiteStatement;
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    this.delegate.bindBlob(paramInt, paramArrayOfByte);
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    this.delegate.bindDouble(paramInt, paramDouble);
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    this.delegate.bindLong(paramInt, paramLong);
  }
  
  public void bindNull(int paramInt)
  {
    this.delegate.bindNull(paramInt);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    this.delegate.bindString(paramInt, paramString);
  }
  
  public void clearBindings()
  {
    this.delegate.clearBindings();
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public void execute()
  {
    this.delegate.execute();
  }
  
  public long executeInsert()
  {
    return this.delegate.executeInsert();
  }
  
  public Object getRawStatement()
  {
    return this.delegate;
  }
  
  public long simpleQueryForLong()
  {
    return this.delegate.simpleQueryForLong();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\database\StandardDatabaseStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */