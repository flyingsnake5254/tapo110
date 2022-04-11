package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.h;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class r<T, U>
  extends a<T, U>
{
  final j<? super T, ? extends t<? extends U>> d;
  final boolean f;
  final int q;
  final int x;
  
  public r(t<T> paramt, j<? super T, ? extends t<? extends U>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramBoolean;
    this.q = paramInt1;
    this.x = paramInt2;
  }
  
  public void K0(v<? super U> paramv)
  {
    if (ObservableScalarXMap.b(this.c, paramv, this.d)) {
      return;
    }
    this.c.a(new b(paramv, this.d, this.f, this.q, this.x));
  }
  
  static final class a<T, U>
    extends AtomicReference<c>
    implements v<U>
  {
    final long c;
    final r.b<T, U> d;
    volatile boolean f;
    volatile i<U> q;
    int x;
    
    a(r.b<T, U> paramb, long paramLong)
    {
      this.c = paramLong;
      this.d = paramb;
    }
    
    public void a()
    {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete()
    {
      this.f = true;
      this.d.f();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d.p2.addThrowable(paramThrowable))
      {
        paramThrowable = this.d;
        if (!paramThrowable.x) {
          paramThrowable.d();
        }
        this.f = true;
        this.d.f();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(U paramU)
    {
      if (this.x == 0) {
        this.d.k(paramU, this);
      } else {
        this.d.f();
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if ((DisposableHelper.setOnce(this, paramc)) && ((paramc instanceof d)))
      {
        paramc = (d)paramc;
        int i = paramc.requestFusion(7);
        if (i == 1)
        {
          this.x = i;
          this.q = paramc;
          this.f = true;
          this.d.f();
          return;
        }
        if (i == 2)
        {
          this.x = i;
          this.q = paramc;
        }
      }
    }
  }
  
  static final class b<T, U>
    extends AtomicInteger
    implements c, v<T>
  {
    static final r.a<?, ?>[] c = new r.a[0];
    static final r.a<?, ?>[] d = new r.a[0];
    final AtomicReference<r.a<?, ?>[]> H3;
    c I3;
    long J3;
    long K3;
    int L3;
    Queue<t<? extends U>> M3;
    int N3;
    final v<? super U> f;
    volatile h<U> p0;
    volatile boolean p1;
    final AtomicThrowable p2 = new AtomicThrowable();
    volatile boolean p3;
    final j<? super T, ? extends t<? extends U>> q;
    final boolean x;
    final int y;
    final int z;
    
    b(v<? super U> paramv, j<? super T, ? extends t<? extends U>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.f = paramv;
      this.q = paramj;
      this.x = paramBoolean;
      this.y = paramInt1;
      this.z = paramInt2;
      if (paramInt1 != Integer.MAX_VALUE) {
        this.M3 = new ArrayDeque(paramInt1);
      }
      this.H3 = new AtomicReference(c);
    }
    
    boolean a(r.a<T, U> parama)
    {
      r.a[] arrayOfa1;
      r.a[] arrayOfa2;
      do
      {
        arrayOfa1 = (r.a[])this.H3.get();
        if (arrayOfa1 == d)
        {
          parama.a();
          return false;
        }
        int i = arrayOfa1.length;
        arrayOfa2 = new r.a[i + 1];
        System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
        arrayOfa2[i] = parama;
      } while (!this.H3.compareAndSet(arrayOfa1, arrayOfa2));
      return true;
    }
    
    boolean b()
    {
      if (this.p3) {
        return true;
      }
      Throwable localThrowable = (Throwable)this.p2.get();
      if ((!this.x) && (localThrowable != null))
      {
        d();
        localThrowable = this.p2.terminate();
        if (localThrowable != io.reactivex.internal.util.e.a) {
          this.f.onError(localThrowable);
        }
        return true;
      }
      return false;
    }
    
    boolean d()
    {
      this.I3.dispose();
      r.a[] arrayOfa1 = (r.a[])this.H3.get();
      r.a[] arrayOfa2 = d;
      int i = 0;
      if (arrayOfa1 != arrayOfa2)
      {
        arrayOfa1 = (r.a[])this.H3.getAndSet(arrayOfa2);
        if (arrayOfa1 != arrayOfa2)
        {
          int j = arrayOfa1.length;
          while (i < j)
          {
            arrayOfa1[i].a();
            i++;
          }
          return true;
        }
      }
      return false;
    }
    
    public void dispose()
    {
      if (!this.p3)
      {
        this.p3 = true;
        if (d())
        {
          Throwable localThrowable = this.p2.terminate();
          if ((localThrowable != null) && (localThrowable != io.reactivex.internal.util.e.a)) {
            io.reactivex.j0.a.r(localThrowable);
          }
        }
      }
    }
    
    void f()
    {
      if (getAndIncrement() == 0) {
        g();
      }
    }
    
    void g()
    {
      v localv = this.f;
      int i = 1;
      int j;
      label582:
      do
      {
        for (;;)
        {
          if (b()) {
            return;
          }
          h localh = this.p0;
          j = 0;
          int k = 0;
          Object localObject2;
          if (localh != null) {
            for (j = k;; j++)
            {
              if (b()) {
                return;
              }
              localObject2 = localh.poll();
              if (localObject2 == null) {
                break;
              }
              localv.onNext(localObject2);
            }
          }
          if (j != 0)
          {
            if (this.y != Integer.MAX_VALUE) {
              j(j);
            }
          }
          else
          {
            boolean bool = this.p1;
            localh = this.p0;
            localObject2 = (r.a[])this.H3.get();
            int m = localObject2.length;
            if (this.y != Integer.MAX_VALUE) {
              try
              {
                k = this.M3.size();
              }
              finally {}
            } else {
              k = 0;
            }
            if ((bool) && ((localh == null) || (localh.isEmpty())) && (m == 0) && (k == 0))
            {
              localObject2 = this.p2.terminate();
              if (localObject2 != io.reactivex.internal.util.e.a) {
                if (localObject2 == null) {
                  ((v)localObject1).onComplete();
                } else {
                  ((v)localObject1).onError((Throwable)localObject2);
                }
              }
              return;
            }
            k = j;
            if (m != 0)
            {
              long l = this.K3;
              int n = this.L3;
              if (m > n)
              {
                k = n;
                if (localObject2[n].c == l) {}
              }
              else
              {
                k = n;
                if (m <= n) {
                  k = 0;
                }
                for (n = 0; (n < m) && (localObject2[k].c != l); n++)
                {
                  i1 = k + 1;
                  k = i1;
                  if (i1 == m) {
                    k = 0;
                  }
                }
                this.L3 = k;
                this.K3 = localObject2[k].c;
              }
              int i1 = 0;
              int i2 = k;
              k = j;
              while (i1 < m)
              {
                if (b()) {
                  return;
                }
                localh = localObject2[i2];
                i locali1 = localh.q;
                if (locali1 != null)
                {
                  try
                  {
                    do
                    {
                      Object localObject3 = locali1.poll();
                      if (localObject3 == null) {
                        break;
                      }
                      ((v)localObject1).onNext(localObject3);
                    } while (!b());
                    return;
                  }
                  finally
                  {
                    io.reactivex.exceptions.a.b(localThrowable);
                    localh.a();
                    this.p2.addThrowable(localThrowable);
                    if (b()) {
                      return;
                    }
                    h(localh);
                    n = k + 1;
                    i2++;
                    k = n;
                    j = i2;
                    if (i2 != m) {
                      break label582;
                    }
                  }
                  k = n;
                }
                else
                {
                  bool = localh.f;
                  i locali2 = localh.q;
                  n = k;
                  if (bool) {
                    if (locali2 != null)
                    {
                      n = k;
                      if (!locali2.isEmpty()) {}
                    }
                    else
                    {
                      h(localh);
                      if (b()) {
                        return;
                      }
                      n = k + 1;
                    }
                  }
                  i2++;
                  k = n;
                  j = i2;
                  if (i2 != m) {
                    break label582;
                  }
                  k = n;
                }
                j = 0;
                i1++;
                i2 = j;
              }
              this.L3 = i2;
              this.K3 = localObject2[i2].c;
            }
            if (k == 0) {
              break;
            }
            if (this.y != Integer.MAX_VALUE) {
              j(k);
            }
          }
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    void h(r.a<T, U> parama)
    {
      r.a[] arrayOfa1;
      r.a[] arrayOfa2;
      do
      {
        arrayOfa1 = (r.a[])this.H3.get();
        int i = arrayOfa1.length;
        if (i == 0) {
          return;
        }
        int j = -1;
        int m;
        for (int k = 0;; k++)
        {
          m = j;
          if (k >= i) {
            break;
          }
          if (arrayOfa1[k] == parama)
          {
            m = k;
            break;
          }
        }
        if (m < 0) {
          return;
        }
        if (i == 1)
        {
          arrayOfa2 = c;
        }
        else
        {
          arrayOfa2 = new r.a[i - 1];
          System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, m);
          System.arraycopy(arrayOfa1, m + 1, arrayOfa2, m, i - m - 1);
        }
      } while (!this.H3.compareAndSet(arrayOfa1, arrayOfa2));
    }
    
    void i(t<? extends U> paramt)
    {
      while ((paramt instanceof Callable))
      {
        if ((!l((Callable)paramt)) || (this.y == Integer.MAX_VALUE)) {
          return;
        }
        int i = 0;
        try
        {
          paramt = (t)this.M3.poll();
          if (paramt == null)
          {
            this.N3 -= 1;
            i = 1;
          }
          if (i != 0)
          {
            f();
            return;
          }
        }
        finally {}
      }
      long l = this.J3;
      this.J3 = (1L + l);
      r.a locala = new r.a(this, l);
      if (a(locala)) {
        paramt.a(locala);
      }
    }
    
    public boolean isDisposed()
    {
      return this.p3;
    }
    
    void j(int paramInt)
    {
      while (paramInt != 0) {
        try
        {
          t localt = (t)this.M3.poll();
          if (localt == null) {
            this.N3 -= 1;
          } else {
            i(localt);
          }
          paramInt--;
        }
        finally {}
      }
    }
    
    void k(U paramU, r.a<T, U> parama)
    {
      if ((get() == 0) && (compareAndSet(0, 1)))
      {
        this.f.onNext(paramU);
        if (decrementAndGet() != 0) {}
      }
      else
      {
        i locali = parama.q;
        Object localObject = locali;
        if (locali == null)
        {
          localObject = new io.reactivex.internal.queue.b(this.z);
          parama.q = ((i)localObject);
        }
        ((i)localObject).offer(paramU);
        if (getAndIncrement() != 0) {
          return;
        }
      }
      g();
    }
    
    boolean l(Callable<? extends U> paramCallable)
    {
      try
      {
        Object localObject = paramCallable.call();
        if (localObject == null) {
          return true;
        }
        if ((get() == 0) && (compareAndSet(0, 1)))
        {
          this.f.onNext(localObject);
          if (decrementAndGet() == 0) {
            return true;
          }
        }
        else
        {
          h localh = this.p0;
          paramCallable = localh;
          if (localh == null)
          {
            if (this.y == Integer.MAX_VALUE) {
              paramCallable = new io.reactivex.internal.queue.b(this.z);
            } else {
              paramCallable = new SpscArrayQueue(this.y);
            }
            this.p0 = paramCallable;
          }
          if (!paramCallable.offer(localObject))
          {
            onError(new IllegalStateException("Scalar queue full?!"));
            return true;
          }
          if (getAndIncrement() != 0) {
            return false;
          }
        }
        g();
        return true;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramCallable);
        this.p2.addThrowable(paramCallable);
        f();
      }
      return true;
    }
    
    public void onComplete()
    {
      if (this.p1) {
        return;
      }
      this.p1 = true;
      f();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.p1)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      if (this.p2.addThrowable(paramThrowable))
      {
        this.p1 = true;
        f();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.p1) {
        return;
      }
      try
      {
        paramT = (t)io.reactivex.h0.a.b.e(this.q.apply(paramT), "The mapper returned a null ObservableSource");
        if (this.y != Integer.MAX_VALUE) {
          try
          {
            int i = this.N3;
            if (i == this.y)
            {
              this.M3.offer(paramT);
              return;
            }
            this.N3 = (i + 1);
          }
          finally {}
        }
        i(paramT);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.I3.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.I3, paramc))
      {
        this.I3 = paramc;
        this.f.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */