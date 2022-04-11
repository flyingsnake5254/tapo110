package org.greenrobot.greendao.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.identityscope.IdentityScopeObject;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public final class DaoConfig
  implements Cloneable
{
  public final String[] allColumns;
  public final Database db;
  private IdentityScope<?, ?> identityScope;
  public final boolean keyIsNumeric;
  public final String[] nonPkColumns;
  public final String[] pkColumns;
  public final Property pkProperty;
  public final Property[] properties;
  public final TableStatements statements;
  public final String tablename;
  
  public DaoConfig(Database paramDatabase, Class<? extends AbstractDao<?, ?>> paramClass)
  {
    this.db = paramDatabase;
    try
    {
      Object localObject = paramClass.getField("TABLENAME");
      Class<? extends AbstractDao<?, ?>> localClass = null;
      this.tablename = ((String)((Field)localObject).get(null));
      Property[] arrayOfProperty = reflectProperties(paramClass);
      this.properties = arrayOfProperty;
      this.allColumns = new String[arrayOfProperty.length];
      ArrayList localArrayList1 = new java/util/ArrayList;
      localArrayList1.<init>();
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>();
      boolean bool = false;
      paramClass = null;
      for (int i = 0; i < arrayOfProperty.length; i++)
      {
        localObject = arrayOfProperty[i];
        String str = ((Property)localObject).columnName;
        this.allColumns[i] = str;
        if (((Property)localObject).primaryKey)
        {
          localArrayList1.add(str);
          paramClass = (Class<? extends AbstractDao<?, ?>>)localObject;
        }
        else
        {
          localArrayList2.add(str);
        }
      }
      this.nonPkColumns = ((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
      localObject = (String[])localArrayList1.toArray(new String[localArrayList1.size()]);
      this.pkColumns = ((String[])localObject);
      if (localObject.length == 1) {
        localClass = paramClass;
      }
      this.pkProperty = localClass;
      paramClass = new org/greenrobot/greendao/internal/TableStatements;
      paramClass.<init>(paramDatabase, this.tablename, this.allColumns, (String[])localObject);
      this.statements = paramClass;
      if (localClass != null)
      {
        paramDatabase = localClass.type;
        if ((paramDatabase.equals(Long.TYPE)) || (paramDatabase.equals(Long.class)) || (paramDatabase.equals(Integer.TYPE)) || (paramDatabase.equals(Integer.class)) || (paramDatabase.equals(Short.TYPE)) || (paramDatabase.equals(Short.class)) || (paramDatabase.equals(Byte.TYPE)) || (paramDatabase.equals(Byte.class))) {
          bool = true;
        }
        this.keyIsNumeric = bool;
      }
      else
      {
        this.keyIsNumeric = false;
      }
      return;
    }
    catch (Exception paramDatabase)
    {
      throw new DaoException("Could not init DAOConfig", paramDatabase);
    }
  }
  
  public DaoConfig(DaoConfig paramDaoConfig)
  {
    this.db = paramDaoConfig.db;
    this.tablename = paramDaoConfig.tablename;
    this.properties = paramDaoConfig.properties;
    this.allColumns = paramDaoConfig.allColumns;
    this.pkColumns = paramDaoConfig.pkColumns;
    this.nonPkColumns = paramDaoConfig.nonPkColumns;
    this.pkProperty = paramDaoConfig.pkProperty;
    this.statements = paramDaoConfig.statements;
    this.keyIsNumeric = paramDaoConfig.keyIsNumeric;
  }
  
  private static Property[] reflectProperties(Class<? extends AbstractDao<?, ?>> paramClass)
    throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramClass.getName());
    ((StringBuilder)localObject1).append("$Properties");
    localObject1 = Class.forName(((StringBuilder)localObject1).toString()).getDeclaredFields();
    paramClass = new ArrayList();
    int i = localObject1.length;
    for (int j = 0; j < i; j++)
    {
      localObject2 = localObject1[j];
      if ((((Field)localObject2).getModifiers() & 0x9) == 9)
      {
        localObject2 = ((Field)localObject2).get(null);
        if ((localObject2 instanceof Property)) {
          paramClass.add((Property)localObject2);
        }
      }
    }
    localObject1 = new Property[paramClass.size()];
    Object localObject2 = paramClass.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramClass = (Property)((Iterator)localObject2).next();
      j = paramClass.ordinal;
      if (localObject1[j] == null) {
        localObject1[j] = paramClass;
      } else {
        throw new DaoException("Duplicate property ordinals");
      }
    }
    return (Property[])localObject1;
  }
  
  public void clearIdentityScope()
  {
    IdentityScope localIdentityScope = this.identityScope;
    if (localIdentityScope != null) {
      localIdentityScope.clear();
    }
  }
  
  public DaoConfig clone()
  {
    return new DaoConfig(this);
  }
  
  public IdentityScope<?, ?> getIdentityScope()
  {
    return this.identityScope;
  }
  
  public void initIdentityScope(IdentityScopeType paramIdentityScopeType)
  {
    if (paramIdentityScopeType == IdentityScopeType.None)
    {
      this.identityScope = null;
    }
    else
    {
      if (paramIdentityScopeType != IdentityScopeType.Session) {
        break label55;
      }
      if (this.keyIsNumeric) {
        this.identityScope = new IdentityScopeLong();
      } else {
        this.identityScope = new IdentityScopeObject();
      }
    }
    return;
    label55:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported type: ");
    localStringBuilder.append(paramIdentityScopeType);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setIdentityScope(IdentityScope<?, ?> paramIdentityScope)
  {
    this.identityScope = paramIdentityScope;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\internal\DaoConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */