package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import java.io.File;

class SQLiteCopyOpenHelperFactory
  implements SupportSQLiteOpenHelper.Factory
{
  @Nullable
  private final String mCopyFromAssetPath;
  @Nullable
  private final File mCopyFromFile;
  @NonNull
  private final SupportSQLiteOpenHelper.Factory mDelegate;
  
  SQLiteCopyOpenHelperFactory(@Nullable String paramString, @Nullable File paramFile, @NonNull SupportSQLiteOpenHelper.Factory paramFactory)
  {
    this.mCopyFromAssetPath = paramString;
    this.mCopyFromFile = paramFile;
    this.mDelegate = paramFactory;
  }
  
  public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration paramConfiguration)
  {
    return new SQLiteCopyOpenHelper(paramConfiguration.context, this.mCopyFromAssetPath, this.mCopyFromFile, paramConfiguration.callback.version, this.mDelegate.create(paramConfiguration));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\SQLiteCopyOpenHelperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */