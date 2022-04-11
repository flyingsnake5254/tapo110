package io.reactivex.internal.queue;

import io.reactivex.h0.b.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  implements h<T>
{
  private final AtomicReference<a<T>> c = new AtomicReference();
  private final AtomicReference<a<T>> d = new AtomicReference();
  
  public a()
  {
    a locala = new a();
    d(locala);
    e(locala);
  }
  
  a<T> a()
  {
    return (a)this.d.get();
  }
  
  a<T> b()
  {
    return (a)this.d.get();
  }
  
  a<T> c()
  {
    return (a)this.c.get();
  }
  
  public void clear()
  {
    while ((poll() != null) && (!isEmpty())) {}
  }
  
  void d(a<T> parama)
  {
    this.d.lazySet(parama);
  }
  
  a<T> e(a<T> parama)
  {
    return (a)this.c.getAndSet(parama);
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (b() == c()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean offer(T paramT)
  {
    Objects.requireNonNull(paramT, "Null is not a valid element");
    paramT = new a(paramT);
    e(paramT).f(paramT);
    return true;
  }
  
  public T poll()
  {
    Object localObject = a();
    a locala = ((a)localObject).d();
    if (locala != null)
    {
      localObject = locala.a();
      d(locala);
      return (T)localObject;
    }
    if (localObject != c())
    {
      do
      {
        locala = ((a)localObject).d();
      } while (locala == null);
      localObject = locala.a();
      d(locala);
      return (T)localObject;
    }
    return null;
  }
  
  static final class a<E>
    extends AtomicReference<a<E>>
  {
    private E c;
    
    a() {}
    
    a(E paramE)
    {
      g(paramE);
    }
    
    public E a()
    {
      Object localObject = b();
      g(null);
      return (E)localObject;
    }
    
    public E b()
    {
      return (E)this.c;
    }
    
    public a<E> d()
    {
      return (a)get();
    }
    
    public void f(a<E> parama)
    {
      lazySet(parama);
    }
    
    public void g(E paramE)
    {
      this.c = paramE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\queue\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */