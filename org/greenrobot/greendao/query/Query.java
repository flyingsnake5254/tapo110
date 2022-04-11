package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;
import org.greenrobot.greendao.annotation.apihint.Internal;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.rx.RxQuery;
import rx.schedulers.Schedulers;

public class Query<T>
  extends AbstractQueryWithLimit<T>
{
  private final QueryData<T> queryData;
  private volatile RxQuery rxTxIo;
  private volatile RxQuery rxTxPlain;
  
  private Query(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(paramAbstractDao, paramString, paramArrayOfString, paramInt1, paramInt2);
    this.queryData = paramQueryData;
  }
  
  static <T2> Query<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    return (Query)new QueryData(paramAbstractDao, paramString, AbstractQuery.toStringArray(paramArrayOfObject), paramInt1, paramInt2).forCurrentThread();
  }
  
  public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return create(paramAbstractDao, paramString, paramArrayOfObject, -1, -1);
  }
  
  @Internal
  public RxQuery __InternalRx()
  {
    if (this.rxTxIo == null) {
      this.rxTxIo = new RxQuery(this, Schedulers.io());
    }
    return this.rxTxIo;
  }
  
  @Internal
  public RxQuery __internalRxPlain()
  {
    if (this.rxTxPlain == null) {
      this.rxTxPlain = new RxQuery(this);
    }
    return this.rxTxPlain;
  }
  
  public Query<T> forCurrentThread()
  {
    return (Query)this.queryData.forCurrentThread(this);
  }
  
  public List<T> list()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return this.daoAccess.loadAllAndCloseCursor(localCursor);
  }
  
  public CloseableListIterator<T> listIterator()
  {
    return listLazyUncached().listIteratorAutoClose();
  }
  
  public LazyList<T> listLazy()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return new LazyList(this.daoAccess, localCursor, true);
  }
  
  public LazyList<T> listLazyUncached()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return new LazyList(this.daoAccess, localCursor, false);
  }
  
  public Query<T> setParameter(int paramInt, Boolean paramBoolean)
  {
    return (Query)super.setParameter(paramInt, paramBoolean);
  }
  
  public Query<T> setParameter(int paramInt, Object paramObject)
  {
    return (Query)super.setParameter(paramInt, paramObject);
  }
  
  public Query<T> setParameter(int paramInt, Date paramDate)
  {
    return (Query)super.setParameter(paramInt, paramDate);
  }
  
  public T unique()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return (T)this.daoAccess.loadUniqueAndCloseCursor(localCursor);
  }
  
  public T uniqueOrThrow()
  {
    Object localObject = unique();
    if (localObject != null) {
      return (T)localObject;
    }
    throw new DaoException("No entity found for query");
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, Query<T2>>
  {
    private final int limitPosition;
    private final int offsetPosition;
    
    QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
    {
      super(paramString, paramArrayOfString);
      this.limitPosition = paramInt1;
      this.offsetPosition = paramInt2;
    }
    
    protected Query<T2> createQuery()
    {
      return new Query(this, this.dao, this.sql, (String[])this.initialValues.clone(), this.limitPosition, this.offsetPosition, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */