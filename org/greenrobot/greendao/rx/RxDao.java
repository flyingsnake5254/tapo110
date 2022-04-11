package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import rx.Observable;
import rx.Scheduler;

@Experimental
public class RxDao<T, K>
  extends RxBase
{
  private final AbstractDao<T, K> dao;
  
  @Experimental
  public RxDao(AbstractDao<T, K> paramAbstractDao)
  {
    this(paramAbstractDao, null);
  }
  
  @Experimental
  public RxDao(AbstractDao<T, K> paramAbstractDao, Scheduler paramScheduler)
  {
    super(paramScheduler);
    this.dao = paramAbstractDao;
  }
  
  @Experimental
  public Observable<Long> count()
  {
    wrap(new Callable()
    {
      public Long call()
        throws Exception
      {
        return Long.valueOf(RxDao.this.dao.count());
      }
    });
  }
  
  @Experimental
  public Observable<Void> delete(final T paramT)
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.delete(paramT);
        return null;
      }
    });
  }
  
  @Experimental
  public Observable<Void> deleteAll()
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.deleteAll();
        return null;
      }
    });
  }
  
  @Experimental
  public Observable<Void> deleteByKey(final K paramK)
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.deleteByKey(paramK);
        return null;
      }
    });
  }
  
  @Experimental
  public Observable<Void> deleteByKeyInTx(final Iterable<K> paramIterable)
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.deleteByKeyInTx(paramIterable);
        return null;
      }
    });
  }
  
  @Experimental
  public Observable<Void> deleteByKeyInTx(final K... paramVarArgs)
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.deleteByKeyInTx(paramVarArgs);
        return null;
      }
    });
  }
  
  @Experimental
  public Observable<Void> deleteInTx(final Iterable<T> paramIterable)
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.deleteInTx(paramIterable);
        return null;
      }
    });
  }
  
  @Experimental
  public Observable<Void> deleteInTx(final T... paramVarArgs)
  {
    wrap(new Callable()
    {
      public Void call()
        throws Exception
      {
        RxDao.this.dao.deleteInTx(paramVarArgs);
        return null;
      }
    });
  }
  
  @Experimental
  public AbstractDao<T, K> getDao()
  {
    return this.dao;
  }
  
  @Experimental
  public Observable<T> insert(final T paramT)
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        RxDao.this.dao.insert(paramT);
        return (T)paramT;
      }
    });
  }
  
  @Experimental
  public Observable<Iterable<T>> insertInTx(final Iterable<T> paramIterable)
  {
    wrap(new Callable()
    {
      public Iterable<T> call()
        throws Exception
      {
        RxDao.this.dao.insertInTx(paramIterable);
        return paramIterable;
      }
    });
  }
  
  @Experimental
  public Observable<Object[]> insertInTx(final T... paramVarArgs)
  {
    wrap(new Callable()
    {
      public Object[] call()
        throws Exception
      {
        RxDao.this.dao.insertInTx(paramVarArgs);
        return paramVarArgs;
      }
    });
  }
  
  @Experimental
  public Observable<T> insertOrReplace(final T paramT)
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        RxDao.this.dao.insertOrReplace(paramT);
        return (T)paramT;
      }
    });
  }
  
  @Experimental
  public Observable<Iterable<T>> insertOrReplaceInTx(final Iterable<T> paramIterable)
  {
    wrap(new Callable()
    {
      public Iterable<T> call()
        throws Exception
      {
        RxDao.this.dao.insertOrReplaceInTx(paramIterable);
        return paramIterable;
      }
    });
  }
  
  @Experimental
  public Observable<Object[]> insertOrReplaceInTx(final T... paramVarArgs)
  {
    wrap(new Callable()
    {
      public Object[] call()
        throws Exception
      {
        RxDao.this.dao.insertOrReplaceInTx(paramVarArgs);
        return paramVarArgs;
      }
    });
  }
  
  @Experimental
  public Observable<T> load(final K paramK)
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        return (T)RxDao.this.dao.load(paramK);
      }
    });
  }
  
  @Experimental
  public Observable<List<T>> loadAll()
  {
    wrap(new Callable()
    {
      public List<T> call()
        throws Exception
      {
        return RxDao.this.dao.loadAll();
      }
    });
  }
  
  @Experimental
  public Observable<T> refresh(final T paramT)
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        RxDao.this.dao.refresh(paramT);
        return (T)paramT;
      }
    });
  }
  
  @Experimental
  public Observable<T> save(final T paramT)
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        RxDao.this.dao.save(paramT);
        return (T)paramT;
      }
    });
  }
  
  @Experimental
  public Observable<Iterable<T>> saveInTx(final Iterable<T> paramIterable)
  {
    wrap(new Callable()
    {
      public Iterable<T> call()
        throws Exception
      {
        RxDao.this.dao.saveInTx(paramIterable);
        return paramIterable;
      }
    });
  }
  
  @Experimental
  public Observable<Object[]> saveInTx(final T... paramVarArgs)
  {
    wrap(new Callable()
    {
      public Object[] call()
        throws Exception
      {
        RxDao.this.dao.saveInTx(paramVarArgs);
        return paramVarArgs;
      }
    });
  }
  
  @Experimental
  public Observable<T> update(final T paramT)
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        RxDao.this.dao.update(paramT);
        return (T)paramT;
      }
    });
  }
  
  @Experimental
  public Observable<Iterable<T>> updateInTx(final Iterable<T> paramIterable)
  {
    wrap(new Callable()
    {
      public Iterable<T> call()
        throws Exception
      {
        RxDao.this.dao.updateInTx(paramIterable);
        return paramIterable;
      }
    });
  }
  
  @Experimental
  public Observable<Object[]> updateInTx(final T... paramVarArgs)
  {
    wrap(new Callable()
    {
      public Object[] call()
        throws Exception
      {
        RxDao.this.dao.updateInTx(paramVarArgs);
        return paramVarArgs;
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\rx\RxDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */