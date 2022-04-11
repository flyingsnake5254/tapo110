package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;

class FrameworkSQLiteOpenHelper
  implements SupportSQLiteOpenHelper
{
  private final OpenHelper mDelegate = createDelegate(paramContext, paramString, paramCallback);
  
  FrameworkSQLiteOpenHelper(Context paramContext, String paramString, SupportSQLiteOpenHelper.Callback paramCallback) {}
  
  private OpenHelper createDelegate(Context paramContext, String paramString, SupportSQLiteOpenHelper.Callback paramCallback)
  {
    return new OpenHelper(paramContext, paramString, new FrameworkSQLiteDatabase[1], paramCallback);
  }
  
  public void close()
  {
    this.mDelegate.close();
  }
  
  public String getDatabaseName()
  {
    return this.mDelegate.getDatabaseName();
  }
  
  public SupportSQLiteDatabase getReadableDatabase()
  {
    return this.mDelegate.getReadableSupportDatabase();
  }
  
  public SupportSQLiteDatabase getWritableDatabase()
  {
    return this.mDelegate.getWritableSupportDatabase();
  }
  
  @RequiresApi(api=16)
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    this.mDelegate.setWriteAheadLoggingEnabled(paramBoolean);
  }
  
  static class OpenHelper
    extends SQLiteOpenHelper
  {
    final SupportSQLiteOpenHelper.Callback mCallback;
    final FrameworkSQLiteDatabase[] mDbRef;
    private boolean mMigrated;
    
    OpenHelper(Context paramContext, String paramString, final FrameworkSQLiteDatabase[] paramArrayOfFrameworkSQLiteDatabase, SupportSQLiteOpenHelper.Callback paramCallback)
    {
      super(paramString, null, paramCallback.version, new DatabaseErrorHandler()
      {
        public void onCorruption(SQLiteDatabase paramAnonymousSQLiteDatabase)
        {
          FrameworkSQLiteOpenHelper.OpenHelper.this.onCorruption(FrameworkSQLiteOpenHelper.OpenHelper.getWrappedDb(paramArrayOfFrameworkSQLiteDatabase, paramAnonymousSQLiteDatabase));
        }
      });
      this.mCallback = paramCallback;
      this.mDbRef = paramArrayOfFrameworkSQLiteDatabase;
    }
    
    static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] paramArrayOfFrameworkSQLiteDatabase, SQLiteDatabase paramSQLiteDatabase)
    {
      FrameworkSQLiteDatabase localFrameworkSQLiteDatabase = paramArrayOfFrameworkSQLiteDatabase[0];
      if ((localFrameworkSQLiteDatabase == null) || (!localFrameworkSQLiteDatabase.isDelegate(paramSQLiteDatabase))) {
        paramArrayOfFrameworkSQLiteDatabase[0] = new FrameworkSQLiteDatabase(paramSQLiteDatabase);
      }
      return paramArrayOfFrameworkSQLiteDatabase[0];
    }
    
    public void close()
    {
      try
      {
        super.close();
        this.mDbRef[0] = null;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    SupportSQLiteDatabase getReadableSupportDatabase()
    {
      try
      {
        this.mMigrated = false;
        Object localObject1 = super.getReadableDatabase();
        if (this.mMigrated)
        {
          close();
          localObject1 = getReadableSupportDatabase();
          return (SupportSQLiteDatabase)localObject1;
        }
        localObject1 = getWrappedDb((SQLiteDatabase)localObject1);
        return (SupportSQLiteDatabase)localObject1;
      }
      finally {}
    }
    
    FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase paramSQLiteDatabase)
    {
      return getWrappedDb(this.mDbRef, paramSQLiteDatabase);
    }
    
    SupportSQLiteDatabase getWritableSupportDatabase()
    {
      try
      {
        this.mMigrated = false;
        Object localObject1 = super.getWritableDatabase();
        if (this.mMigrated)
        {
          close();
          localObject1 = getWritableSupportDatabase();
          return (SupportSQLiteDatabase)localObject1;
        }
        localObject1 = getWrappedDb((SQLiteDatabase)localObject1);
        return (SupportSQLiteDatabase)localObject1;
      }
      finally {}
    }
    
    public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
    {
      this.mCallback.onConfigure(getWrappedDb(paramSQLiteDatabase));
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      this.mCallback.onCreate(getWrappedDb(paramSQLiteDatabase));
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.mMigrated = true;
      this.mCallback.onDowngrade(getWrappedDb(paramSQLiteDatabase), paramInt1, paramInt2);
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (!this.mMigrated) {
        this.mCallback.onOpen(getWrappedDb(paramSQLiteDatabase));
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.mMigrated = true;
      this.mCallback.onUpgrade(getWrappedDb(paramSQLiteDatabase), paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\sqlite\db\framework\FrameworkSQLiteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */