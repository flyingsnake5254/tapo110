package org.greenrobot.greendao.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.reflect.Constructor;
import org.greenrobot.greendao.DaoException;

public abstract class DatabaseOpenHelper
  extends SQLiteOpenHelper
{
  private final Context context;
  private EncryptedHelper encryptedHelper;
  private boolean loadSQLCipherNativeLibs = true;
  private final String name;
  private final int version;
  
  public DatabaseOpenHelper(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext, paramString, null, paramInt);
  }
  
  public DatabaseOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.context = paramContext;
    this.name = paramString;
    this.version = paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public DatabaseOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
    this.context = paramContext;
    this.name = paramString;
    this.version = paramInt;
  }
  
  private EncryptedHelper checkEncryptedHelper()
  {
    if (this.encryptedHelper == null) {
      try
      {
        Class.forName("net.sqlcipher.database.SQLiteOpenHelper");
        try
        {
          this.encryptedHelper = ((EncryptedHelper)Class.forName("org.greenrobot.greendao.database.SqlCipherEncryptedHelper").getConstructor(new Class[] { DatabaseOpenHelper.class, Context.class, String.class, Integer.TYPE, Boolean.TYPE }).newInstance(new Object[] { this, this.context, this.name, Integer.valueOf(this.version), Boolean.valueOf(this.loadSQLCipherNativeLibs) }));
        }
        catch (Exception localException)
        {
          throw new DaoException(localException);
        }
        return this.encryptedHelper;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new DaoException("Using an encrypted database requires SQLCipher, make sure to add it to dependencies: https://greenrobot.org/greendao/documentation/database-encryption/");
      }
    }
  }
  
  public Database getEncryptedReadableDb(String paramString)
  {
    return checkEncryptedHelper().getEncryptedReadableDb(paramString);
  }
  
  public Database getEncryptedReadableDb(char[] paramArrayOfChar)
  {
    return checkEncryptedHelper().getEncryptedReadableDb(paramArrayOfChar);
  }
  
  public Database getEncryptedWritableDb(String paramString)
  {
    return checkEncryptedHelper().getEncryptedWritableDb(paramString);
  }
  
  public Database getEncryptedWritableDb(char[] paramArrayOfChar)
  {
    return checkEncryptedHelper().getEncryptedWritableDb(paramArrayOfChar);
  }
  
  public Database getReadableDb()
  {
    return wrap(getReadableDatabase());
  }
  
  public Database getWritableDb()
  {
    return wrap(getWritableDatabase());
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    onCreate(wrap(paramSQLiteDatabase));
  }
  
  public void onCreate(Database paramDatabase) {}
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    onOpen(wrap(paramSQLiteDatabase));
  }
  
  public void onOpen(Database paramDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    onUpgrade(wrap(paramSQLiteDatabase), paramInt1, paramInt2);
  }
  
  public void onUpgrade(Database paramDatabase, int paramInt1, int paramInt2) {}
  
  public void setLoadSQLCipherNativeLibs(boolean paramBoolean)
  {
    this.loadSQLCipherNativeLibs = paramBoolean;
  }
  
  protected Database wrap(SQLiteDatabase paramSQLiteDatabase)
  {
    return new StandardDatabase(paramSQLiteDatabase);
  }
  
  static abstract interface EncryptedHelper
  {
    public abstract Database getEncryptedReadableDb(String paramString);
    
    public abstract Database getEncryptedReadableDb(char[] paramArrayOfChar);
    
    public abstract Database getEncryptedWritableDb(String paramString);
    
    public abstract Database getEncryptedWritableDb(char[] paramArrayOfChar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\database\DatabaseOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */