package org.greenrobot.greendao.query;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

class WhereCollector<T>
{
  private final AbstractDao<T, ?> dao;
  private final String tablePrefix;
  private final List<WhereCondition> whereConditions;
  
  WhereCollector(AbstractDao<T, ?> paramAbstractDao, String paramString)
  {
    this.dao = paramAbstractDao;
    this.tablePrefix = paramString;
    this.whereConditions = new ArrayList();
  }
  
  void add(WhereCondition paramWhereCondition, WhereCondition... paramVarArgs)
  {
    checkCondition(paramWhereCondition);
    this.whereConditions.add(paramWhereCondition);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      paramWhereCondition = paramVarArgs[j];
      checkCondition(paramWhereCondition);
      this.whereConditions.add(paramWhereCondition);
    }
  }
  
  void addCondition(StringBuilder paramStringBuilder, List<Object> paramList, WhereCondition paramWhereCondition)
  {
    checkCondition(paramWhereCondition);
    paramWhereCondition.appendTo(paramStringBuilder, this.tablePrefix);
    paramWhereCondition.appendValuesTo(paramList);
  }
  
  void appendWhereClause(StringBuilder paramStringBuilder, String paramString, List<Object> paramList)
  {
    ListIterator localListIterator = this.whereConditions.listIterator();
    while (localListIterator.hasNext())
    {
      if (localListIterator.hasPrevious()) {
        paramStringBuilder.append(" AND ");
      }
      WhereCondition localWhereCondition = (WhereCondition)localListIterator.next();
      localWhereCondition.appendTo(paramStringBuilder, paramString);
      localWhereCondition.appendValuesTo(paramList);
    }
  }
  
  void checkCondition(WhereCondition paramWhereCondition)
  {
    if ((paramWhereCondition instanceof WhereCondition.PropertyCondition)) {
      checkProperty(((WhereCondition.PropertyCondition)paramWhereCondition).property);
    }
  }
  
  void checkProperty(Property paramProperty)
  {
    Object localObject = this.dao;
    if (localObject != null)
    {
      localObject = ((AbstractDao)localObject).getProperties();
      int i = localObject.length;
      int j = 0;
      int m;
      for (int k = 0;; k++)
      {
        m = j;
        if (k >= i) {
          break;
        }
        if (paramProperty == localObject[k])
        {
          m = 1;
          break;
        }
      }
      if (m == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Property '");
        ((StringBuilder)localObject).append(paramProperty.name);
        ((StringBuilder)localObject).append("' is not part of ");
        ((StringBuilder)localObject).append(this.dao);
        throw new DaoException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  WhereCondition combineWhereConditions(String paramString, WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    ArrayList localArrayList = new ArrayList();
    addCondition(localStringBuilder, localArrayList, paramWhereCondition1);
    localStringBuilder.append(paramString);
    addCondition(localStringBuilder, localArrayList, paramWhereCondition2);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      paramWhereCondition1 = paramVarArgs[j];
      localStringBuilder.append(paramString);
      addCondition(localStringBuilder, localArrayList, paramWhereCondition1);
    }
    localStringBuilder.append(')');
    return new WhereCondition.StringCondition(localStringBuilder.toString(), localArrayList.toArray());
  }
  
  boolean isEmpty()
  {
    return this.whereConditions.isEmpty();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\WhereCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */