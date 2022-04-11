package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public abstract class AbstractDaoMaster
{
  protected final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap;
  protected final Database db;
  protected final int schemaVersion;
  
  public AbstractDaoMaster(Database paramDatabase, int paramInt)
  {
    this.db = paramDatabase;
    this.schemaVersion = paramInt;
    this.daoConfigMap = new HashMap();
  }
  
  public Database getDatabase()
  {
    return this.db;
  }
  
  public int getSchemaVersion()
  {
    return this.schemaVersion;
  }
  
  public abstract AbstractDaoSession newSession();
  
  public abstract AbstractDaoSession newSession(IdentityScopeType paramIdentityScopeType);
  
  protected void registerDaoClass(Class<? extends AbstractDao<?, ?>> paramClass)
  {
    DaoConfig localDaoConfig = new DaoConfig(this.db, paramClass);
    this.daoConfigMap.put(paramClass, localDaoConfig);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\AbstractDaoMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */