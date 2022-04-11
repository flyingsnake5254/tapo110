package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.h;
import io.reactivex.q;
import io.reactivex.v;

public final class l<T>
  extends h<T>
{
  private final q<T> d;
  
  public l(q<T> paramq)
  {
    this.d = paramq;
  }
  
  protected void H(b<? super T> paramb)
  {
    this.d.a(new a(paramb));
  }
  
  static final class a<T>
    implements v<T>, e.b.c
  {
    final b<? super T> c;
    io.reactivex.e0.c d;
    
    a(b<? super T> paramb)
    {
      this.c = paramb;
    }
    
    public void cancel()
    {
      this.d.dispose();
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      this.d = paramc;
      this.c.onSubscribe(this);
    }
    
    public void request(long paramLong) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */