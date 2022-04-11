package org.greenrobot.greendao.test;

import java.lang.reflect.Method;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;

public abstract class AbstractDaoTest<D extends AbstractDao<T, K>, T, K>
  extends DbTest
{
  protected D dao;
  protected InternalUnitTestDaoAccess<T, K> daoAccess;
  protected final Class<D> daoClass;
  protected IdentityScope<K, T> identityScopeForDao;
  protected Property pkColumn;
  
  public AbstractDaoTest(Class<D> paramClass)
  {
    this(paramClass, true);
  }
  
  public AbstractDaoTest(Class<D> paramClass, boolean paramBoolean)
  {
    super(paramBoolean);
    this.daoClass = paramClass;
  }
  
  protected void clearIdentityScopeIfAny()
  {
    IdentityScope localIdentityScope = this.identityScopeForDao;
    if (localIdentityScope != null)
    {
      localIdentityScope.clear();
      DaoLog.d("Identity scope cleared");
    }
    else
    {
      DaoLog.d("No identity scope to clear");
    }
  }
  
  protected void logTableDump()
  {
    logTableDump(this.dao.getTablename());
  }
  
  public void setIdentityScopeBeforeSetUp(IdentityScope<K, T> paramIdentityScope)
  {
    this.identityScopeForDao = paramIdentityScope;
  }
  
  protected void setUp()
    throws Exception
  {
    super.setUp();
    try
    {
      setUpTableForDao();
      InternalUnitTestDaoAccess localInternalUnitTestDaoAccess = new org/greenrobot/greendao/InternalUnitTestDaoAccess;
      localInternalUnitTestDaoAccess.<init>(this.db, this.daoClass, this.identityScopeForDao);
      this.daoAccess = localInternalUnitTestDaoAccess;
      this.dao = localInternalUnitTestDaoAccess.getDao();
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Could not prepare DAO Test", localException);
    }
  }
  
  protected void setUpTableForDao()
    throws Exception
  {
    try
    {
      this.daoClass.getMethod("createTable", new Class[] { Database.class, Boolean.TYPE }).invoke(null, new Object[] { this.db, Boolean.FALSE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      DaoLog.i("No createTable method");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\test\AbstractDaoTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */