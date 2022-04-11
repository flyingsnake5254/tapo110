package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.Observable;
import rx.Scheduler;

@Internal
class RxBase
{
  protected final Scheduler scheduler;
  
  RxBase()
  {
    this.scheduler = null;
  }
  
  @Experimental
  RxBase(Scheduler paramScheduler)
  {
    this.scheduler = paramScheduler;
  }
  
  @Experimental
  public Scheduler getScheduler()
  {
    return this.scheduler;
  }
  
  protected <R> Observable<R> wrap(Callable<R> paramCallable)
  {
    return wrap(RxUtils.fromCallable(paramCallable));
  }
  
  protected <R> Observable<R> wrap(Observable<R> paramObservable)
  {
    Scheduler localScheduler = this.scheduler;
    Object localObject = paramObservable;
    if (localScheduler != null) {
      localObject = paramObservable.subscribeOn(localScheduler);
    }
    return (Observable<R>)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\rx\RxBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */