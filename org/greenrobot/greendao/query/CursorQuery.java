package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

public class CursorQuery<T>
  extends AbstractQueryWithLimit<T>
{
  private final QueryData<T> queryData;
  
  private CursorQuery(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(paramAbstractDao, paramString, paramArrayOfString, paramInt1, paramInt2);
    this.queryData = paramQueryData;
  }
  
  static <T2> CursorQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    return (CursorQuery)new QueryData(paramAbstractDao, paramString, AbstractQuery.toStringArray(paramArrayOfObject), paramInt1, paramInt2).forCurrentThread();
  }
  
  public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return create(paramAbstractDao, paramString, paramArrayOfObject, -1, -1);
  }
  
  public CursorQuery forCurrentThread()
  {
    return (CursorQuery)this.queryData.forCurrentThread(this);
  }
  
  public Cursor query()
  {
    checkThread();
    return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
  }
  
  public CursorQuery<T> setParameter(int paramInt, Boolean paramBoolean)
  {
    return (CursorQuery)super.setParameter(paramInt, paramBoolean);
  }
  
  public CursorQuery<T> setParameter(int paramInt, Object paramObject)
  {
    return (CursorQuery)super.setParameter(paramInt, paramObject);
  }
  
  public CursorQuery<T> setParameter(int paramInt, Date paramDate)
  {
    return (CursorQuery)super.setParameter(paramInt, paramDate);
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, CursorQuery<T2>>
  {
    private final int limitPosition;
    private final int offsetPosition;
    
    QueryData(AbstractDao paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
    {
      super(paramString, paramArrayOfString);
      this.limitPosition = paramInt1;
      this.offsetPosition = paramInt2;
    }
    
    protected CursorQuery<T2> createQuery()
    {
      return new CursorQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), this.limitPosition, this.offsetPosition, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\CursorQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */