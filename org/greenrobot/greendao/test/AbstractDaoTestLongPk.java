package org.greenrobot.greendao.test;

import android.test.AndroidTestCase;
import java.util.Random;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;

public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T>
  extends AbstractDaoTestSinglePk<D, T, Long>
{
  public AbstractDaoTestLongPk(Class<D> paramClass)
  {
    super(paramClass);
  }
  
  protected Long createRandomPk()
  {
    return Long.valueOf(this.random.nextLong());
  }
  
  public void testAssignPk()
  {
    Object localObject2;
    if (this.daoAccess.isEntityUpdateable())
    {
      Object localObject1 = createEntity(null);
      if (localObject1 != null)
      {
        localObject2 = createEntity(null);
        this.dao.insert(localObject1);
        this.dao.insert(localObject2);
        localObject1 = (Long)this.daoAccess.getKey(localObject1);
        AndroidTestCase.assertNotNull(localObject1);
        localObject2 = (Long)this.daoAccess.getKey(localObject2);
        AndroidTestCase.assertNotNull(localObject2);
        AndroidTestCase.assertFalse(((Long)localObject1).equals(localObject2));
        AndroidTestCase.assertNotNull(this.dao.load(localObject1));
        AndroidTestCase.assertNotNull(this.dao.load(localObject2));
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Skipping testAssignPk for ");
        ((StringBuilder)localObject2).append(this.daoClass);
        ((StringBuilder)localObject2).append(" (createEntity returned null for null key)");
        DaoLog.d(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Skipping testAssignPk for not updateable ");
      ((StringBuilder)localObject2).append(this.daoClass);
      DaoLog.d(((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\test\AbstractDaoTestLongPk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */