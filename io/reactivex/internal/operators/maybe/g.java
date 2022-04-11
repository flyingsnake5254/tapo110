package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T>
  extends a<T, T>
{
  final j<? super Throwable, ? extends o<? extends T>> d;
  final boolean f;
  
  public g(o<T> paramo, j<? super Throwable, ? extends o<? extends T>> paramj, boolean paramBoolean)
  {
    super(paramo);
    this.d = paramj;
    this.f = paramBoolean;
  }
  
  protected void n(n<? super T> paramn)
  {
    this.c.a(new a(paramn, this.d, this.f));
  }
  
  static final class a<T>
    extends AtomicReference<c>
    implements n<T>, c
  {
    final n<? super T> c;
    final j<? super Throwable, ? extends o<? extends T>> d;
    final boolean f;
    
    a(n<? super T> paramn, j<? super Throwable, ? extends o<? extends T>> paramj, boolean paramBoolean)
    {
      this.c = paramn;
      this.d = paramj;
      this.f = paramBoolean;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)get());
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if ((!this.f) && (!(paramThrowable instanceof Exception)))
      {
        this.c.onError(paramThrowable);
        return;
      }
      try
      {
        o localo = (o)b.e(this.d.apply(paramThrowable), "The resumeFunction returned a null MaybeSource");
        DisposableHelper.replace(this, null);
        localo.a(new a(this.c, this));
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.setOnce(this, paramc)) {
        this.c.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.c.onSuccess(paramT);
    }
    
    static final class a<T>
      implements n<T>
    {
      final n<? super T> c;
      final AtomicReference<c> d;
      
      a(n<? super T> paramn, AtomicReference<c> paramAtomicReference)
      {
        this.c = paramn;
        this.d = paramAtomicReference;
      }
      
      public void onComplete()
      {
        this.c.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.c.onError(paramThrowable);
      }
      
      public void onSubscribe(c paramc)
      {
        DisposableHelper.setOnce(this.d, paramc);
      }
      
      public void onSuccess(T paramT)
      {
        this.c.onSuccess(paramT);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */