package com.hannesdorfmann.mosby3.mvi;

class b<VS>
  extends io.reactivex.observers.b<VS>
{
  private final io.reactivex.m0.b<VS> d;
  
  public b(io.reactivex.m0.b<VS> paramb)
  {
    this.d = paramb;
  }
  
  public void onComplete() {}
  
  public void onError(Throwable paramThrowable)
  {
    throw new IllegalStateException("ViewState observable must not reach error state - onError()", paramThrowable);
  }
  
  public void onNext(VS paramVS)
  {
    this.d.onNext(paramVS);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */