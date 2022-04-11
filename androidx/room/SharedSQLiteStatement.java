package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement
{
  private final RoomDatabase mDatabase;
  private final AtomicBoolean mLock = new AtomicBoolean(false);
  private volatile SupportSQLiteStatement mStmt;
  
  public SharedSQLiteStatement(RoomDatabase paramRoomDatabase)
  {
    this.mDatabase = paramRoomDatabase;
  }
  
  private SupportSQLiteStatement createNewStatement()
  {
    String str = createQuery();
    return this.mDatabase.compileStatement(str);
  }
  
  private SupportSQLiteStatement getStmt(boolean paramBoolean)
  {
    SupportSQLiteStatement localSupportSQLiteStatement;
    if (paramBoolean)
    {
      if (this.mStmt == null) {
        this.mStmt = createNewStatement();
      }
      localSupportSQLiteStatement = this.mStmt;
    }
    else
    {
      localSupportSQLiteStatement = createNewStatement();
    }
    return localSupportSQLiteStatement;
  }
  
  public SupportSQLiteStatement acquire()
  {
    assertNotMainThread();
    return getStmt(this.mLock.compareAndSet(false, true));
  }
  
  protected void assertNotMainThread()
  {
    this.mDatabase.assertNotMainThread();
  }
  
  protected abstract String createQuery();
  
  public void release(SupportSQLiteStatement paramSupportSQLiteStatement)
  {
    if (paramSupportSQLiteStatement == this.mStmt) {
      this.mLock.set(false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\SharedSQLiteStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */