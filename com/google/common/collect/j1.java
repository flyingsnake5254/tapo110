package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class j1
{
  @CanIgnoreReturnValue
  public static <T> boolean a(Collection<T> paramCollection, Iterable<? extends T> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return paramCollection.addAll(w.a(paramIterable));
    }
    return k1.a(paramCollection, ((Iterable)n.o(paramIterable)).iterator());
  }
  
  private static <E> Collection<E> b(Iterable<E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      paramIterable = (Collection)paramIterable;
    } else {
      paramIterable = n1.j(paramIterable.iterator());
    }
    return paramIterable;
  }
  
  public static <T> Iterable<T> c(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    return m0.a(paramIterable1, paramIterable2);
  }
  
  public static <T> Iterable<T> d(Iterable<T> paramIterable, final o<? super T> paramo)
  {
    n.o(paramIterable);
    n.o(paramo);
    return new a(paramIterable, paramo);
  }
  
  @NullableDecl
  public static <T> T e(Iterable<? extends T> paramIterable, @NullableDecl T paramT)
  {
    return (T)k1.n(paramIterable.iterator(), paramT);
  }
  
  public static <T> T f(Iterable<T> paramIterable)
  {
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      if (!paramIterable.isEmpty()) {
        return (T)h(paramIterable);
      }
      throw new NoSuchElementException();
    }
    return (T)k1.l(paramIterable.iterator());
  }
  
  @NullableDecl
  public static <T> T g(Iterable<? extends T> paramIterable, @NullableDecl T paramT)
  {
    if ((paramIterable instanceof Collection))
    {
      if (w.a(paramIterable).isEmpty()) {
        return paramT;
      }
      if ((paramIterable instanceof List)) {
        return (T)h(n1.a(paramIterable));
      }
    }
    return (T)k1.m(paramIterable.iterator(), paramT);
  }
  
  private static <T> T h(List<T> paramList)
  {
    return (T)paramList.get(paramList.size() - 1);
  }
  
  public static <T> T i(Iterable<T> paramIterable)
  {
    return (T)k1.o(paramIterable.iterator());
  }
  
  public static boolean j(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).isEmpty();
    }
    return paramIterable.iterator().hasNext() ^ true;
  }
  
  public static <T> Iterable<T> k(Iterable<T> paramIterable, final int paramInt)
  {
    n.o(paramIterable);
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "number to skip cannot be negative");
    return new c(paramIterable, paramInt);
  }
  
  static Object[] l(Iterable<?> paramIterable)
  {
    return b(paramIterable).toArray();
  }
  
  static <T> T[] m(Iterable<? extends T> paramIterable, T[] paramArrayOfT)
  {
    return b(paramIterable).toArray(paramArrayOfT);
  }
  
  public static String n(Iterable<?> paramIterable)
  {
    return k1.w(paramIterable.iterator());
  }
  
  public static <F, T> Iterable<T> o(Iterable<F> paramIterable, final h<? super F, ? extends T> paramh)
  {
    n.o(paramIterable);
    n.o(paramh);
    return new b(paramIterable, paramh);
  }
  
  static final class a
    extends m0<T>
  {
    a(Iterable paramIterable, o paramo) {}
    
    public Iterator<T> iterator()
    {
      return k1.k(this.d.iterator(), paramo);
    }
  }
  
  static final class b
    extends m0<T>
  {
    b(Iterable paramIterable, h paramh) {}
    
    public Iterator<T> iterator()
    {
      return k1.x(this.d.iterator(), paramh);
    }
  }
  
  static final class c
    extends m0<T>
  {
    c(Iterable paramIterable, int paramInt) {}
    
    public Iterator<T> iterator()
    {
      final Object localObject = this.d;
      if ((localObject instanceof List))
      {
        localObject = (List)localObject;
        return ((List)localObject).subList(Math.min(((List)localObject).size(), paramInt), ((List)localObject).size()).iterator();
      }
      localObject = ((Iterable)localObject).iterator();
      k1.b((Iterator)localObject, paramInt);
      return new a((Iterator)localObject);
    }
    
    class a
      implements Iterator<T>
    {
      boolean c = true;
      
      a(Iterator paramIterator) {}
      
      public boolean hasNext()
      {
        return localObject.hasNext();
      }
      
      public T next()
      {
        Object localObject = localObject.next();
        this.c = false;
        return (T)localObject;
      }
      
      public void remove()
      {
        v.e(this.c ^ true);
        localObject.remove();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\j1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */