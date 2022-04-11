package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;

public final class FrameworkSQLiteOpenHelperFactory
  implements SupportSQLiteOpenHelper.Factory
{
  public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration paramConfiguration)
  {
    return new FrameworkSQLiteOpenHelper(paramConfiguration.context, paramConfiguration.name, paramConfiguration.callback);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\sqlite\db\framework\FrameworkSQLiteOpenHelperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */