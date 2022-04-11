package org.greenrobot.greendao.query;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.rx.RxQuery;

public class QueryBuilder<T>
{
  public static boolean LOG_SQL;
  public static boolean LOG_VALUES;
  private final AbstractDao<T, ?> dao;
  private boolean distinct;
  private final List<Join<T, ?>> joins;
  private Integer limit;
  private Integer offset;
  private StringBuilder orderBuilder;
  private String stringOrderCollation;
  private final String tablePrefix;
  private final List<Object> values;
  private final WhereCollector<T> whereCollector;
  
  protected QueryBuilder(AbstractDao<T, ?> paramAbstractDao)
  {
    this(paramAbstractDao, "T");
  }
  
  protected QueryBuilder(AbstractDao<T, ?> paramAbstractDao, String paramString)
  {
    this.dao = paramAbstractDao;
    this.tablePrefix = paramString;
    this.values = new ArrayList();
    this.joins = new ArrayList();
    this.whereCollector = new WhereCollector(paramAbstractDao, paramString);
    this.stringOrderCollation = " COLLATE NOCASE";
  }
  
  private <J> Join<T, J> addJoin(String paramString, Property paramProperty1, AbstractDao<J, ?> paramAbstractDao, Property paramProperty2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("J");
    localStringBuilder.append(this.joins.size() + 1);
    paramString = new Join(paramString, paramProperty1, paramAbstractDao, paramProperty2, localStringBuilder.toString());
    this.joins.add(paramString);
    return paramString;
  }
  
  private void appendJoinsAndWheres(StringBuilder paramStringBuilder, String paramString)
  {
    this.values.clear();
    Iterator localIterator = this.joins.iterator();
    while (localIterator.hasNext())
    {
      Join localJoin = (Join)localIterator.next();
      paramStringBuilder.append(" JOIN ");
      paramStringBuilder.append('"');
      paramStringBuilder.append(localJoin.daoDestination.getTablename());
      paramStringBuilder.append('"');
      paramStringBuilder.append(' ');
      paramStringBuilder.append(localJoin.tablePrefix);
      paramStringBuilder.append(" ON ");
      SqlUtils.appendProperty(paramStringBuilder, localJoin.sourceTablePrefix, localJoin.joinPropertySource).append('=');
      SqlUtils.appendProperty(paramStringBuilder, localJoin.tablePrefix, localJoin.joinPropertyDestination);
    }
    boolean bool = this.whereCollector.isEmpty() ^ true;
    if (bool)
    {
      paramStringBuilder.append(" WHERE ");
      this.whereCollector.appendWhereClause(paramStringBuilder, paramString, this.values);
    }
    localIterator = this.joins.iterator();
    while (localIterator.hasNext())
    {
      paramString = (Join)localIterator.next();
      if (!paramString.whereCollector.isEmpty())
      {
        if (!bool)
        {
          paramStringBuilder.append(" WHERE ");
          bool = true;
        }
        else
        {
          paramStringBuilder.append(" AND ");
        }
        paramString.whereCollector.appendWhereClause(paramStringBuilder, paramString.tablePrefix, this.values);
      }
    }
  }
  
  private int checkAddLimit(StringBuilder paramStringBuilder)
  {
    int i;
    if (this.limit != null)
    {
      paramStringBuilder.append(" LIMIT ?");
      this.values.add(this.limit);
      i = this.values.size() - 1;
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  private int checkAddOffset(StringBuilder paramStringBuilder)
  {
    int i;
    if (this.offset != null)
    {
      if (this.limit != null)
      {
        paramStringBuilder.append(" OFFSET ?");
        this.values.add(this.offset);
        i = this.values.size() - 1;
      }
      else
      {
        throw new IllegalStateException("Offset cannot be set without limit");
      }
    }
    else {
      i = -1;
    }
    return i;
  }
  
  private void checkLog(String paramString)
  {
    if (LOG_SQL)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Built SQL for query: ");
      localStringBuilder.append(paramString);
      DaoLog.d(localStringBuilder.toString());
    }
    if (LOG_VALUES)
    {
      paramString = new StringBuilder();
      paramString.append("Values for query: ");
      paramString.append(this.values);
      DaoLog.d(paramString.toString());
    }
  }
  
  private void checkOrderBuilder()
  {
    StringBuilder localStringBuilder = this.orderBuilder;
    if (localStringBuilder == null) {
      this.orderBuilder = new StringBuilder();
    } else if (localStringBuilder.length() > 0) {
      this.orderBuilder.append(",");
    }
  }
  
  private StringBuilder createSelectBuilder()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(SqlUtils.createSqlSelect(this.dao.getTablename(), this.tablePrefix, this.dao.getAllColumns(), this.distinct));
    appendJoinsAndWheres(localStringBuilder1, this.tablePrefix);
    StringBuilder localStringBuilder2 = this.orderBuilder;
    if ((localStringBuilder2 != null) && (localStringBuilder2.length() > 0))
    {
      localStringBuilder1.append(" ORDER BY ");
      localStringBuilder1.append(this.orderBuilder);
    }
    return localStringBuilder1;
  }
  
  public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> paramAbstractDao)
  {
    return new QueryBuilder(paramAbstractDao);
  }
  
  private void orderAscOrDesc(String paramString, Property... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      checkOrderBuilder();
      append(this.orderBuilder, (Property)localObject);
      if (String.class.equals(((Property)localObject).type))
      {
        localObject = this.stringOrderCollation;
        if (localObject != null) {
          this.orderBuilder.append((String)localObject);
        }
      }
      this.orderBuilder.append(paramString);
    }
  }
  
  public WhereCondition and(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    return this.whereCollector.combineWhereConditions(" AND ", paramWhereCondition1, paramWhereCondition2, paramVarArgs);
  }
  
  protected StringBuilder append(StringBuilder paramStringBuilder, Property paramProperty)
  {
    this.whereCollector.checkProperty(paramProperty);
    paramStringBuilder.append(this.tablePrefix);
    paramStringBuilder.append('.');
    paramStringBuilder.append('\'');
    paramStringBuilder.append(paramProperty.columnName);
    paramStringBuilder.append('\'');
    return paramStringBuilder;
  }
  
  public Query<T> build()
  {
    Object localObject = createSelectBuilder();
    int i = checkAddLimit((StringBuilder)localObject);
    int j = checkAddOffset((StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    checkLog((String)localObject);
    return Query.create(this.dao, (String)localObject, this.values.toArray(), i, j);
  }
  
  public CountQuery<T> buildCount()
  {
    Object localObject = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.dao.getTablename(), this.tablePrefix));
    appendJoinsAndWheres((StringBuilder)localObject, this.tablePrefix);
    localObject = ((StringBuilder)localObject).toString();
    checkLog((String)localObject);
    return CountQuery.create(this.dao, (String)localObject, this.values.toArray());
  }
  
  public CursorQuery buildCursor()
  {
    Object localObject = createSelectBuilder();
    int i = checkAddLimit((StringBuilder)localObject);
    int j = checkAddOffset((StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    checkLog((String)localObject);
    return CursorQuery.create(this.dao, (String)localObject, this.values.toArray(), i, j);
  }
  
  public DeleteQuery<T> buildDelete()
  {
    if (this.joins.isEmpty())
    {
      String str1 = this.dao.getTablename();
      Object localObject = new StringBuilder(SqlUtils.createSqlDelete(str1, null));
      appendJoinsAndWheres((StringBuilder)localObject, this.tablePrefix);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.tablePrefix);
      localStringBuilder.append(".\"");
      String str2 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(str1);
      localStringBuilder.append("\".\"");
      str1 = ((String)localObject).replace(str2, localStringBuilder.toString());
      checkLog(str1);
      return DeleteQuery.create(this.dao, str1, this.values.toArray());
    }
    throw new DaoException("JOINs are not supported for DELETE queries");
  }
  
  public long count()
  {
    return buildCount().count();
  }
  
  public QueryBuilder<T> distinct()
  {
    this.distinct = true;
    return this;
  }
  
  public <J> Join<T, J> join(Class<J> paramClass, Property paramProperty)
  {
    return join(this.dao.getPkProperty(), paramClass, paramProperty);
  }
  
  public <J> Join<T, J> join(Property paramProperty, Class<J> paramClass)
  {
    paramClass = this.dao.getSession().getDao(paramClass);
    Property localProperty = paramClass.getPkProperty();
    return addJoin(this.tablePrefix, paramProperty, paramClass, localProperty);
  }
  
  public <J> Join<T, J> join(Property paramProperty1, Class<J> paramClass, Property paramProperty2)
  {
    paramClass = this.dao.getSession().getDao(paramClass);
    return addJoin(this.tablePrefix, paramProperty1, paramClass, paramProperty2);
  }
  
  public <J> Join<T, J> join(Join<?, T> paramJoin, Property paramProperty1, Class<J> paramClass, Property paramProperty2)
  {
    paramClass = this.dao.getSession().getDao(paramClass);
    return addJoin(paramJoin.tablePrefix, paramProperty1, paramClass, paramProperty2);
  }
  
  public QueryBuilder<T> limit(int paramInt)
  {
    this.limit = Integer.valueOf(paramInt);
    return this;
  }
  
  public List<T> list()
  {
    return build().list();
  }
  
  public CloseableListIterator<T> listIterator()
  {
    return build().listIterator();
  }
  
  public LazyList<T> listLazy()
  {
    return build().listLazy();
  }
  
  public LazyList<T> listLazyUncached()
  {
    return build().listLazyUncached();
  }
  
  public QueryBuilder<T> offset(int paramInt)
  {
    this.offset = Integer.valueOf(paramInt);
    return this;
  }
  
  public WhereCondition or(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    return this.whereCollector.combineWhereConditions(" OR ", paramWhereCondition1, paramWhereCondition2, paramVarArgs);
  }
  
  public QueryBuilder<T> orderAsc(Property... paramVarArgs)
  {
    orderAscOrDesc(" ASC", paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> orderCustom(Property paramProperty, String paramString)
  {
    checkOrderBuilder();
    append(this.orderBuilder, paramProperty).append(' ');
    this.orderBuilder.append(paramString);
    return this;
  }
  
  public QueryBuilder<T> orderDesc(Property... paramVarArgs)
  {
    orderAscOrDesc(" DESC", paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> orderRaw(String paramString)
  {
    checkOrderBuilder();
    this.orderBuilder.append(paramString);
    return this;
  }
  
  public QueryBuilder<T> preferLocalizedStringOrder()
  {
    if ((this.dao.getDatabase().getRawDatabase() instanceof SQLiteDatabase)) {
      this.stringOrderCollation = " COLLATE LOCALIZED";
    }
    return this;
  }
  
  @Experimental
  public RxQuery<T> rx()
  {
    return build().__InternalRx();
  }
  
  @Experimental
  public RxQuery<T> rxPlain()
  {
    return build().__internalRxPlain();
  }
  
  public QueryBuilder<T> stringOrderCollation(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      if (paramString.startsWith(" "))
      {
        localObject = paramString;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    this.stringOrderCollation = ((String)localObject);
    return this;
  }
  
  public T unique()
  {
    return (T)build().unique();
  }
  
  public T uniqueOrThrow()
  {
    return (T)build().uniqueOrThrow();
  }
  
  public QueryBuilder<T> where(WhereCondition paramWhereCondition, WhereCondition... paramVarArgs)
  {
    this.whereCollector.add(paramWhereCondition, paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> whereOr(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    this.whereCollector.add(or(paramWhereCondition1, paramWhereCondition2, paramVarArgs), new WhereCondition[0]);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\QueryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */