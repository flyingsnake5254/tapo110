package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

abstract class AbstractQuery<T>
{
  protected final AbstractDao<T, ?> dao;
  protected final InternalQueryDaoAccess<T> daoAccess;
  protected final Thread ownerThread;
  protected final String[] parameters;
  protected final String sql;
  
  protected AbstractQuery(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    this.dao = paramAbstractDao;
    this.daoAccess = new InternalQueryDaoAccess(paramAbstractDao);
    this.sql = paramString;
    this.parameters = paramArrayOfString;
    this.ownerThread = Thread.currentThread();
  }
  
  protected static String[] toStringArray(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfObject[j];
      if (localObject != null) {
        arrayOfString[j] = localObject.toString();
      } else {
        arrayOfString[j] = null;
      }
    }
    return arrayOfString;
  }
  
  protected void checkThread()
  {
    if (Thread.currentThread() == this.ownerThread) {
      return;
    }
    throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
  }
  
  public AbstractQuery<T> setParameter(int paramInt, Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      paramBoolean = Integer.valueOf(paramBoolean.booleanValue());
    } else {
      paramBoolean = null;
    }
    return setParameter(paramInt, paramBoolean);
  }
  
  public AbstractQuery<T> setParameter(int paramInt, Object paramObject)
  {
    checkThread();
    if (paramObject != null) {
      this.parameters[paramInt] = paramObject.toString();
    } else {
      this.parameters[paramInt] = null;
    }
    return this;
  }
  
  public AbstractQuery<T> setParameter(int paramInt, Date paramDate)
  {
    if (paramDate != null) {
      paramDate = Long.valueOf(paramDate.getTime());
    } else {
      paramDate = null;
    }
    return setParameter(paramInt, paramDate);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\AbstractQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */