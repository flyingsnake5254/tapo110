package org.greenrobot.greendao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxTransaction;
import rx.schedulers.Schedulers;

public class AbstractDaoSession
{
  private final Database db;
  private final Map<Class<?>, AbstractDao<?, ?>> entityToDao;
  private volatile RxTransaction rxTxIo;
  private volatile RxTransaction rxTxPlain;
  
  public AbstractDaoSession(Database paramDatabase)
  {
    this.db = paramDatabase;
    this.entityToDao = new HashMap();
  }
  
  public <V> V callInTx(Callable<V> paramCallable)
    throws Exception
  {
    this.db.beginTransaction();
    try
    {
      paramCallable = paramCallable.call();
      this.db.setTransactionSuccessful();
      return paramCallable;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  /* Error */
  public <V> V callInTxNoException(Callable<V> paramCallable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	org/greenrobot/greendao/AbstractDaoSession:db	Lorg/greenrobot/greendao/database/Database;
    //   4: invokeinterface 34 1 0
    //   9: aload_1
    //   10: invokeinterface 40 1 0
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 19	org/greenrobot/greendao/AbstractDaoSession:db	Lorg/greenrobot/greendao/database/Database;
    //   20: invokeinterface 43 1 0
    //   25: aload_0
    //   26: getfield 19	org/greenrobot/greendao/AbstractDaoSession:db	Lorg/greenrobot/greendao/database/Database;
    //   29: invokeinterface 46 1 0
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +17 -> 54
    //   40: astore_1
    //   41: new 52	org/greenrobot/greendao/DaoException
    //   44: astore_2
    //   45: aload_2
    //   46: ldc 54
    //   48: aload_1
    //   49: invokespecial 57	org/greenrobot/greendao/DaoException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: aload_2
    //   53: athrow
    //   54: aload_0
    //   55: getfield 19	org/greenrobot/greendao/AbstractDaoSession:db	Lorg/greenrobot/greendao/database/Database;
    //   58: invokeinterface 46 1 0
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	AbstractDaoSession
    //   0	65	1	paramCallable	Callable<V>
    //   44	9	2	localDaoException	DaoException
    // Exception table:
    //   from	to	target	type
    //   9	16	36	finally
    //   16	25	36	finally
    //   41	54	36	finally
    //   9	16	40	java/lang/Exception
  }
  
  public <T> void delete(T paramT)
  {
    getDao(paramT.getClass()).delete(paramT);
  }
  
  public <T> void deleteAll(Class<T> paramClass)
  {
    getDao(paramClass).deleteAll();
  }
  
  public Collection<AbstractDao<?, ?>> getAllDaos()
  {
    return Collections.unmodifiableCollection(this.entityToDao.values());
  }
  
  public AbstractDao<?, ?> getDao(Class<? extends Object> paramClass)
  {
    Object localObject = (AbstractDao)this.entityToDao.get(paramClass);
    if (localObject != null) {
      return (AbstractDao<?, ?>)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No DAO registered for ");
    ((StringBuilder)localObject).append(paramClass);
    throw new DaoException(((StringBuilder)localObject).toString());
  }
  
  public Database getDatabase()
  {
    return this.db;
  }
  
  public <T> long insert(T paramT)
  {
    return getDao(paramT.getClass()).insert(paramT);
  }
  
  public <T> long insertOrReplace(T paramT)
  {
    return getDao(paramT.getClass()).insertOrReplace(paramT);
  }
  
  public <T, K> T load(Class<T> paramClass, K paramK)
  {
    return (T)getDao(paramClass).load(paramK);
  }
  
  public <T, K> List<T> loadAll(Class<T> paramClass)
  {
    return getDao(paramClass).loadAll();
  }
  
  public <T> QueryBuilder<T> queryBuilder(Class<T> paramClass)
  {
    return getDao(paramClass).queryBuilder();
  }
  
  public <T, K> List<T> queryRaw(Class<T> paramClass, String paramString, String... paramVarArgs)
  {
    return getDao(paramClass).queryRaw(paramString, paramVarArgs);
  }
  
  public <T> void refresh(T paramT)
  {
    getDao(paramT.getClass()).refresh(paramT);
  }
  
  protected <T> void registerDao(Class<T> paramClass, AbstractDao<T, ?> paramAbstractDao)
  {
    this.entityToDao.put(paramClass, paramAbstractDao);
  }
  
  public void runInTx(Runnable paramRunnable)
  {
    this.db.beginTransaction();
    try
    {
      paramRunnable.run();
      this.db.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  @Experimental
  public RxTransaction rxTx()
  {
    if (this.rxTxIo == null) {
      this.rxTxIo = new RxTransaction(this, Schedulers.io());
    }
    return this.rxTxIo;
  }
  
  @Experimental
  public RxTransaction rxTxPlain()
  {
    if (this.rxTxPlain == null) {
      this.rxTxPlain = new RxTransaction(this);
    }
    return this.rxTxPlain;
  }
  
  public AsyncSession startAsyncSession()
  {
    return new AsyncSession(this);
  }
  
  public <T> void update(T paramT)
  {
    getDao(paramT.getClass()).update(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\AbstractDaoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */