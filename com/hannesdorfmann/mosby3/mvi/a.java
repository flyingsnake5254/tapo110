package com.hannesdorfmann.mosby3.mvi;

import io.reactivex.m0.g;
import io.reactivex.observers.b;
import io.reactivex.v;

class a<I>
  extends b<I>
{
  private final g<I> d;
  
  public a(g<I> paramg)
  {
    this.d = paramg;
  }
  
  public void onComplete()
  {
    this.d.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    throw new IllegalStateException("View intents must not throw errors", paramThrowable);
  }
  
  public void onNext(I paramI)
  {
    this.d.onNext(paramI);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */