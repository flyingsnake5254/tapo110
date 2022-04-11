package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.Observable;
import rx.functions.Func0;

@Internal
class RxUtils
{
  @Internal
  static <T> Observable<T> fromCallable(Callable<T> paramCallable)
  {
    Observable.defer(new Func0()
    {
      public Observable<T> call()
      {
        try
        {
          Object localObject = RxUtils.this.call();
          return Observable.just(localObject);
        }
        catch (Exception localException)
        {
          return Observable.error(localException);
        }
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\rx\RxUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */