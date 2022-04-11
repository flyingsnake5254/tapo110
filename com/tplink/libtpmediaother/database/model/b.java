package com.tplink.libtpmediaother.database.model;

import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class b
  extends AbstractDaoSession
{
  private final DaoConfig a;
  private final DaoConfig b;
  private final DaoConfig c;
  private final DeviceInfoDao d;
  private final FileMemoryInfoDao e;
  private final ModeSettingInfoDao f;
  
  public b(Database paramDatabase, IdentityScopeType paramIdentityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> paramMap)
  {
    super(paramDatabase);
    DaoConfig localDaoConfig1 = ((DaoConfig)paramMap.get(DeviceInfoDao.class)).clone();
    this.a = localDaoConfig1;
    localDaoConfig1.initIdentityScope(paramIdentityScopeType);
    DaoConfig localDaoConfig2 = ((DaoConfig)paramMap.get(FileMemoryInfoDao.class)).clone();
    this.b = localDaoConfig2;
    localDaoConfig2.initIdentityScope(paramIdentityScopeType);
    paramDatabase = ((DaoConfig)paramMap.get(ModeSettingInfoDao.class)).clone();
    this.c = paramDatabase;
    paramDatabase.initIdentityScope(paramIdentityScopeType);
    paramIdentityScopeType = new DeviceInfoDao(localDaoConfig1, this);
    this.d = paramIdentityScopeType;
    paramMap = new FileMemoryInfoDao(localDaoConfig2, this);
    this.e = paramMap;
    paramDatabase = new ModeSettingInfoDao(paramDatabase, this);
    this.f = paramDatabase;
    registerDao(c.class, paramIdentityScopeType);
    registerDao(d.class, paramMap);
    registerDao(e.class, paramDatabase);
  }
  
  public DeviceInfoDao a()
  {
    return this.d;
  }
  
  public FileMemoryInfoDao b()
  {
    return this.e;
  }
  
  public ModeSettingInfoDao c()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\database\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */