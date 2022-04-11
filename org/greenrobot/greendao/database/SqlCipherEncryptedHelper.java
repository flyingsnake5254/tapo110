package org.greenrobot.greendao.database;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

class SqlCipherEncryptedHelper
  extends SQLiteOpenHelper
  implements DatabaseOpenHelper.EncryptedHelper
{
  private final DatabaseOpenHelper delegate;
  
  public SqlCipherEncryptedHelper(DatabaseOpenHelper paramDatabaseOpenHelper, Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramString, null, paramInt);
    this.delegate = paramDatabaseOpenHelper;
    if (paramBoolean) {
      SQLiteDatabase.loadLibs(paramContext);
    }
  }
  
  private Database wrap(SQLiteDatabase paramSQLiteDatabase)
  {
    return new EncryptedDatabase(paramSQLiteDatabase);
  }
  
  public Database getEncryptedReadableDb(String paramString)
  {
    return wrap(getReadableDatabase(paramString));
  }
  
  public Database getEncryptedReadableDb(char[] paramArrayOfChar)
  {
    return wrap(getReadableDatabase(paramArrayOfChar));
  }
  
  public Database getEncryptedWritableDb(String paramString)
  {
    return wrap(getWritableDatabase(paramString));
  }
  
  public Database getEncryptedWritableDb(char[] paramArrayOfChar)
  {
    return wrap(getWritableDatabase(paramArrayOfChar));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.delegate.onCreate(wrap(paramSQLiteDatabase));
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    this.delegate.onOpen(wrap(paramSQLiteDatabase));
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.delegate.onUpgrade(wrap(paramSQLiteDatabase), paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\database\SqlCipherEncryptedHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */