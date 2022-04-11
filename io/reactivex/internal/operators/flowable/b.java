package io.reactivex.internal.operators.flowable;

import e.b.a;
import e.b.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class b<T>
  extends h<T>
{
  final a<? extends T>[] d;
  final boolean f;
  
  public b(a<? extends T>[] paramArrayOfa, boolean paramBoolean)
  {
    this.d = paramArrayOfa;
    this.f = paramBoolean;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    a locala = new a(this.d, this.f, paramb);
    paramb.onSubscribe(locala);
    locala.onComplete();
  }
  
  static final class a<T>
    extends SubscriptionArbiter
    implements k<T>
  {
    final e.b.b<? super T> c;
    final a<? extends T>[] d;
    final boolean f;
    final AtomicInteger q;
    int x;
    List<Throwable> y;
    long z;
    
    a(a<? extends T>[] paramArrayOfa, boolean paramBoolean, e.b.b<? super T> paramb)
    {
      super();
      this.c = paramb;
      this.d = paramArrayOfa;
      this.f = paramBoolean;
      this.q = new AtomicInteger();
    }
    
    public void onComplete()
    {
      if (this.q.getAndIncrement() == 0)
      {
        a[] arrayOfa = this.d;
        int i = arrayOfa.length;
        int j = this.x;
        label195:
        do
        {
          Object localObject;
          NullPointerException localNullPointerException;
          for (;;)
          {
            if (j == i)
            {
              localObject = this.y;
              if (localObject != null)
              {
                if (((List)localObject).size() == 1) {
                  this.c.onError((Throwable)((List)localObject).get(0));
                } else {
                  this.c.onError(new CompositeException((Iterable)localObject));
                }
              }
              else {
                this.c.onComplete();
              }
              return;
            }
            localObject = arrayOfa[j];
            if (localObject != null) {
              break label195;
            }
            localNullPointerException = new NullPointerException("A Publisher entry is null");
            if (!this.f) {
              break;
            }
            List localList = this.y;
            localObject = localList;
            if (localList == null)
            {
              localObject = new ArrayList(i - j + 1);
              this.y = ((List)localObject);
            }
            ((List)localObject).add(localNullPointerException);
            j++;
          }
          this.c.onError(localNullPointerException);
          return;
          long l = this.z;
          if (l != 0L)
          {
            this.z = 0L;
            produced(l);
          }
          ((a)localObject).a(this);
          j++;
          this.x = j;
        } while (this.q.decrementAndGet() != 0);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        List localList = this.y;
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList(this.d.length - this.x + 1);
          this.y = ((List)localObject);
        }
        ((List)localObject).add(paramThrowable);
        onComplete();
      }
      else
      {
        this.c.onError(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      this.z += 1L;
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      setSubscription(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */