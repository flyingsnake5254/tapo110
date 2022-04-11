package org.greenrobot.greendao;

import android.database.Cursor;
import java.lang.reflect.Constructor;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.internal.DaoConfig;

public class InternalUnitTestDaoAccess<T, K>
{
  private final AbstractDao<T, K> dao;
  
  public InternalUnitTestDaoAccess(Database paramDatabase, Class<AbstractDao<T, K>> paramClass, IdentityScope<?, ?> paramIdentityScope)
    throws Exception
  {
    paramDatabase = new DaoConfig(paramDatabase, paramClass);
    paramDatabase.setIdentityScope(paramIdentityScope);
    this.dao = ((AbstractDao)paramClass.getConstructor(new Class[] { DaoConfig.class }).newInstance(new Object[] { paramDatabase }));
  }
  
  public AbstractDao<T, K> getDao()
  {
    return this.dao;
  }
  
  public K getKey(T paramT)
  {
    return (K)this.dao.getKey(paramT);
  }
  
  public Property[] getProperties()
  {
    return this.dao.getProperties();
  }
  
  public boolean isEntityUpdateable()
  {
    return this.dao.isEntityUpdateable();
  }
  
  public T readEntity(Cursor paramCursor, int paramInt)
  {
    return (T)this.dao.readEntity(paramCursor, paramInt);
  }
  
  public K readKey(Cursor paramCursor, int paramInt)
  {
    return (K)this.dao.readKey(paramCursor, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\InternalUnitTestDaoAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */