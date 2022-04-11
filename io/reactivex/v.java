package io.reactivex;

import io.reactivex.e0.c;

public abstract interface v<T>
{
  public abstract void onComplete();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(T paramT);
  
  public abstract void onSubscribe(c paramc);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */