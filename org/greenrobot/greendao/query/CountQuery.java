package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.database.Database;

public class CountQuery<T>
  extends AbstractQuery<T>
{
  private final QueryData<T> queryData;
  
  private CountQuery(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
  }
  
  static <T2> CountQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return (CountQuery)new QueryData(paramAbstractDao, paramString, AbstractQuery.toStringArray(paramArrayOfObject), null).forCurrentThread();
  }
  
  public long count()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    try
    {
      if (localCursor.moveToNext())
      {
        if (localCursor.isLast())
        {
          if (localCursor.getColumnCount() == 1)
          {
            long l = localCursor.getLong(0);
            return l;
          }
          localDaoException = new org/greenrobot/greendao/DaoException;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Unexpected column count: ");
          localStringBuilder.append(localCursor.getColumnCount());
          localDaoException.<init>(localStringBuilder.toString());
          throw localDaoException;
        }
        localDaoException = new org/greenrobot/greendao/DaoException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Unexpected row count: ");
        localStringBuilder.append(localCursor.getCount());
        localDaoException.<init>(localStringBuilder.toString());
        throw localDaoException;
      }
      DaoException localDaoException = new org/greenrobot/greendao/DaoException;
      localDaoException.<init>("No result for count");
      throw localDaoException;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public CountQuery<T> forCurrentThread()
  {
    return (CountQuery)this.queryData.forCurrentThread(this);
  }
  
  public CountQuery<T> setParameter(int paramInt, Boolean paramBoolean)
  {
    return (CountQuery)super.setParameter(paramInt, paramBoolean);
  }
  
  public CountQuery<T> setParameter(int paramInt, Object paramObject)
  {
    return (CountQuery)super.setParameter(paramInt, paramObject);
  }
  
  public CountQuery<T> setParameter(int paramInt, Date paramDate)
  {
    return (CountQuery)super.setParameter(paramInt, paramDate);
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, CountQuery<T2>>
  {
    private QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }
    
    protected CountQuery<T2> createQuery()
    {
      return new CountQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\CountQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */