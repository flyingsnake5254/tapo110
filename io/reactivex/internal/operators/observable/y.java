package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.v;
import java.util.Iterator;

public final class y<T>
  extends q<T>
{
  final Iterable<? extends T> c;
  
  public y(Iterable<? extends T> paramIterable)
  {
    this.c = paramIterable;
  }
  
  public void K0(v<? super T> paramv)
  {
    try
    {
      Object localObject = this.c.iterator();
      try
      {
        boolean bool = ((Iterator)localObject).hasNext();
        if (!bool)
        {
          EmptyDisposable.complete(paramv);
          return;
        }
        localObject = new a(paramv, (Iterator)localObject);
        paramv.onSubscribe((c)localObject);
        if (!((a)localObject).q) {
          ((a)localObject).a();
        }
        return;
      }
      finally {}
      return;
    }
    finally
    {
      a.b(localThrowable2);
      EmptyDisposable.error(localThrowable2, paramv);
    }
  }
  
  static final class a<T>
    extends io.reactivex.internal.observers.b<T>
  {
    final v<? super T> c;
    final Iterator<? extends T> d;
    volatile boolean f;
    boolean q;
    boolean x;
    boolean y;
    
    a(v<? super T> paramv, Iterator<? extends T> paramIterator)
    {
      this.c = paramv;
      this.d = paramIterator;
    }
    
    void a()
    {
      for (;;)
      {
        if (isDisposed()) {
          return;
        }
        try
        {
          Object localObject = io.reactivex.h0.a.b.e(this.d.next(), "The iterator returned a null value");
          this.c.onNext(localObject);
          if (isDisposed()) {
            return;
          }
          try
          {
            boolean bool = this.d.hasNext();
            if (bool) {
              continue;
            }
            if (!isDisposed()) {
              this.c.onComplete();
            }
            return;
          }
          finally {}
          return;
        }
        finally
        {
          a.b(localThrowable2);
          this.c.onError(localThrowable2);
        }
      }
    }
    
    public void clear()
    {
      this.x = true;
    }
    
    public void dispose()
    {
      this.f = true;
    }
    
    public boolean isDisposed()
    {
      return this.f;
    }
    
    public boolean isEmpty()
    {
      return this.x;
    }
    
    public T poll()
    {
      if (this.x) {
        return null;
      }
      if (this.y)
      {
        if (!this.d.hasNext())
        {
          this.x = true;
          return null;
        }
      }
      else {
        this.y = true;
      }
      return (T)io.reactivex.h0.a.b.e(this.d.next(), "The iterator returned a null value");
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        this.q = true;
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */