package io.reactivex;

import io.reactivex.e0.c;

public abstract interface n<T>
{
  public abstract void onComplete();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onSubscribe(c paramc);
  
  public abstract void onSuccess(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */