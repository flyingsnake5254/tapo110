package org.greenrobot.greendao.rx;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.Query;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;

@Experimental
public class RxQuery<T>
  extends RxBase
{
  private final Query<T> query;
  
  public RxQuery(Query<T> paramQuery)
  {
    this.query = paramQuery;
  }
  
  public RxQuery(Query<T> paramQuery, Scheduler paramScheduler)
  {
    super(paramScheduler);
    this.query = paramQuery;
  }
  
  @Experimental
  public Observable<List<T>> list()
  {
    wrap(new Callable()
    {
      public List<T> call()
        throws Exception
      {
        return RxQuery.this.query.forCurrentThread().list();
      }
    });
  }
  
  public Observable<T> oneByOne()
  {
    wrap(Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        try
        {
          LazyList localLazyList = RxQuery.this.query.forCurrentThread().listLazyUncached();
          try
          {
            Iterator localIterator = localLazyList.iterator();
            while (localIterator.hasNext())
            {
              Object localObject1 = localIterator.next();
              if (paramAnonymousSubscriber.isUnsubscribed()) {
                break;
              }
              paramAnonymousSubscriber.onNext(localObject1);
            }
            localLazyList.close();
            if (paramAnonymousSubscriber.isUnsubscribed()) {}
          }
          finally
          {
            localLazyList.close();
          }
          return;
        }
        finally
        {
          Exceptions.throwIfFatal(localThrowable);
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }));
  }
  
  @Experimental
  public Observable<T> unique()
  {
    wrap(new Callable()
    {
      public T call()
        throws Exception
      {
        return (T)RxQuery.this.query.forCurrentThread().unique();
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\rx\RxQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */