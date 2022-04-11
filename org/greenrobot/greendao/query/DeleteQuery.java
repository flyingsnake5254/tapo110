package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

public class DeleteQuery<T>
  extends AbstractQuery<T>
{
  private final QueryData<T> queryData;
  
  private DeleteQuery(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
  }
  
  static <T2> DeleteQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return (DeleteQuery)new QueryData(paramAbstractDao, paramString, AbstractQuery.toStringArray(paramArrayOfObject), null).forCurrentThread();
  }
  
  public void executeDeleteWithoutDetachingEntities()
  {
    checkThread();
    Database localDatabase = this.dao.getDatabase();
    if (localDatabase.isDbLockedByCurrentThread()) {
      this.dao.getDatabase().execSQL(this.sql, this.parameters);
    } else {
      localDatabase.beginTransaction();
    }
    try
    {
      this.dao.getDatabase().execSQL(this.sql, this.parameters);
      localDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localDatabase.endTransaction();
    }
  }
  
  public DeleteQuery<T> forCurrentThread()
  {
    return (DeleteQuery)this.queryData.forCurrentThread(this);
  }
  
  public DeleteQuery<T> setParameter(int paramInt, Boolean paramBoolean)
  {
    return (DeleteQuery)super.setParameter(paramInt, paramBoolean);
  }
  
  public DeleteQuery<T> setParameter(int paramInt, Object paramObject)
  {
    return (DeleteQuery)super.setParameter(paramInt, paramObject);
  }
  
  public DeleteQuery<T> setParameter(int paramInt, Date paramDate)
  {
    return (DeleteQuery)super.setParameter(paramInt, paramDate);
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, DeleteQuery<T2>>
  {
    private QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }
    
    protected DeleteQuery<T2> createQuery()
    {
      return new DeleteQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\DeleteQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */