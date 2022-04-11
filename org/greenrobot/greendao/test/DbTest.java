package org.greenrobot.greendao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.DbUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;

public abstract class DbTest
  extends AndroidTestCase
{
  public static final String DB_NAME = "greendao-unittest-db.temp";
  private Application application;
  protected Database db;
  protected final boolean inMemory;
  protected final Random random;
  
  public DbTest()
  {
    this(true);
  }
  
  public DbTest(boolean paramBoolean)
  {
    this.inMemory = paramBoolean;
    this.random = new Random();
  }
  
  public <T extends Application> T createApplication(Class<T> paramClass)
  {
    AndroidTestCase.assertNull("Application already created", this.application);
    try
    {
      localObject = Instrumentation.newApplication(paramClass, getContext());
      ((Application)localObject).onCreate();
      this.application = ((Application)localObject);
      return (T)localObject;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not create application ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), localException);
    }
  }
  
  protected Database createDatabase()
  {
    SQLiteDatabase localSQLiteDatabase;
    if (this.inMemory)
    {
      localSQLiteDatabase = SQLiteDatabase.create(null);
    }
    else
    {
      getContext().deleteDatabase("greendao-unittest-db.temp");
      localSQLiteDatabase = getContext().openOrCreateDatabase("greendao-unittest-db.temp", 0, null);
    }
    return new StandardDatabase(localSQLiteDatabase);
  }
  
  public <T extends Application> T getApplication()
  {
    AndroidTestCase.assertNotNull("Application not yet created", this.application);
    return this.application;
  }
  
  protected void logTableDump(String paramString)
  {
    Database localDatabase = this.db;
    if ((localDatabase instanceof StandardDatabase))
    {
      DbUtils.logTableDump(((StandardDatabase)localDatabase).getSQLiteDatabase(), paramString);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("Table dump unsupported for ");
      paramString.append(this.db);
      DaoLog.w(paramString.toString());
    }
  }
  
  protected void setUp()
    throws Exception
  {
    super.setUp();
    this.db = createDatabase();
  }
  
  protected void tearDown()
    throws Exception
  {
    if (this.application != null) {
      terminateApplication();
    }
    this.db.close();
    if (!this.inMemory) {
      getContext().deleteDatabase("greendao-unittest-db.temp");
    }
    super.tearDown();
  }
  
  public void terminateApplication()
  {
    AndroidTestCase.assertNotNull("Application not yet created", this.application);
    this.application.onTerminate();
    this.application = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\test\DbTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */