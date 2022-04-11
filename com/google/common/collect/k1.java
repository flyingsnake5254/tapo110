package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class k1
{
  @CanIgnoreReturnValue
  public static <T> boolean a(Collection<T> paramCollection, Iterator<? extends T> paramIterator)
  {
    n.o(paramCollection);
    n.o(paramIterator);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramCollection.add(paramIterator.next());
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static int b(Iterator<?> paramIterator, int paramInt)
  {
    n.o(paramIterator);
    int i = 0;
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "numberToAdvance must be nonnegative");
    while ((i < paramInt) && (paramIterator.hasNext()))
    {
      paramIterator.next();
      i++;
    }
    return i;
  }
  
  static <T> ListIterator<T> c(Iterator<T> paramIterator)
  {
    return (ListIterator)paramIterator;
  }
  
  static void d(Iterator<?> paramIterator)
  {
    n.o(paramIterator);
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      paramIterator.remove();
    }
  }
  
  public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> paramIterator)
  {
    return new f(paramIterator);
  }
  
  public static boolean f(Iterator<?> paramIterator, @NullableDecl Object paramObject)
  {
    if (paramObject == null)
    {
      do
      {
        if (!paramIterator.hasNext()) {
          break;
        }
      } while (paramIterator.next() != null);
      return true;
    }
    while (paramIterator.hasNext()) {
      if (paramObject.equals(paramIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean g(Iterator<?> paramIterator1, Iterator<?> paramIterator2)
  {
    while (paramIterator1.hasNext())
    {
      if (!paramIterator2.hasNext()) {
        return false;
      }
      if (!k.a(paramIterator1.next(), paramIterator2.next())) {
        return false;
      }
    }
    return paramIterator2.hasNext() ^ true;
  }
  
  static <T> j3<T> h()
  {
    return i();
  }
  
  static <T> k3<T> i()
  {
    return e.f;
  }
  
  static <T> Iterator<T> j()
  {
    return g.c;
  }
  
  public static <T> j3<T> k(Iterator<T> paramIterator, final o<? super T> paramo)
  {
    n.o(paramIterator);
    n.o(paramo);
    return new b(paramIterator, paramo);
  }
  
  public static <T> T l(Iterator<T> paramIterator)
  {
    Object localObject;
    do
    {
      localObject = paramIterator.next();
    } while (paramIterator.hasNext());
    return (T)localObject;
  }
  
  @NullableDecl
  public static <T> T m(Iterator<? extends T> paramIterator, @NullableDecl T paramT)
  {
    if (paramIterator.hasNext()) {
      paramT = l(paramIterator);
    }
    return paramT;
  }
  
  @NullableDecl
  public static <T> T n(Iterator<? extends T> paramIterator, @NullableDecl T paramT)
  {
    if (paramIterator.hasNext()) {
      paramT = paramIterator.next();
    }
    return paramT;
  }
  
  public static <T> T o(Iterator<T> paramIterator)
  {
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return (T)localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected one element but was: <");
    localStringBuilder.append(localObject);
    for (int i = 0; (i < 4) && (paramIterator.hasNext()); i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramIterator.next());
    }
    if (paramIterator.hasNext()) {
      localStringBuilder.append(", ...");
    }
    localStringBuilder.append('>');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static <T> j3<T> p(Iterable<? extends Iterator<? extends T>> paramIterable, Comparator<? super T> paramComparator)
  {
    n.p(paramIterable, "iterators");
    n.p(paramComparator, "comparator");
    return new h(paramIterable, paramComparator);
  }
  
  public static <T> b2<T> q(Iterator<? extends T> paramIterator)
  {
    if ((paramIterator instanceof i)) {
      return (i)paramIterator;
    }
    return new i(paramIterator);
  }
  
  @NullableDecl
  static <T> T r(Iterator<T> paramIterator)
  {
    if (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      paramIterator.remove();
      return (T)localObject;
    }
    return null;
  }
  
  @CanIgnoreReturnValue
  public static boolean s(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    n.o(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramCollection.contains(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static boolean t(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    n.o(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (!paramCollection.contains(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  public static <T> j3<T> u(@NullableDecl T paramT)
  {
    return new d(paramT);
  }
  
  public static int v(Iterator<?> paramIterator)
  {
    for (long l = 0L; paramIterator.hasNext(); l += 1L) {
      paramIterator.next();
    }
    return d.i(l);
  }
  
  public static String w(Iterator<?> paramIterator)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int i = 1;
    while (paramIterator.hasNext())
    {
      if (i == 0) {
        localStringBuilder.append(", ");
      }
      i = 0;
      localStringBuilder.append(paramIterator.next());
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static <F, T> Iterator<T> x(Iterator<F> paramIterator, final h<? super F, ? extends T> paramh)
  {
    n.o(paramh);
    return new c(paramIterator, paramh);
  }
  
  public static <T> j3<T> y(Iterator<? extends T> paramIterator)
  {
    n.o(paramIterator);
    if ((paramIterator instanceof j3)) {
      return (j3)paramIterator;
    }
    return new a(paramIterator);
  }
  
  static final class a
    extends j3<T>
  {
    a(Iterator paramIterator) {}
    
    public boolean hasNext()
    {
      return this.c.hasNext();
    }
    
    public T next()
    {
      return (T)this.c.next();
    }
  }
  
  static final class b
    extends c<T>
  {
    b(Iterator paramIterator, o paramo) {}
    
    protected T a()
    {
      while (this.f.hasNext())
      {
        Object localObject = this.f.next();
        if (paramo.apply(localObject)) {
          return (T)localObject;
        }
      }
      return (T)b();
    }
  }
  
  static final class c
    extends h3<F, T>
  {
    c(Iterator paramIterator, h paramh)
    {
      super();
    }
    
    T a(F paramF)
    {
      return (T)paramh.apply(paramF);
    }
  }
  
  static final class d
    extends j3<T>
  {
    boolean c;
    
    d(Object paramObject) {}
    
    public boolean hasNext()
    {
      return this.c ^ true;
    }
    
    public T next()
    {
      if (!this.c)
      {
        this.c = true;
        return (T)this.d;
      }
      throw new NoSuchElementException();
    }
  }
  
  private static final class e<T>
    extends b<T>
  {
    static final k3<Object> f = new e(new Object[0], 0, 0, 0);
    private final T[] q;
    private final int x;
    
    e(T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt3);
      this.q = paramArrayOfT;
      this.x = paramInt1;
    }
    
    protected T a(int paramInt)
    {
      return (T)this.q[(this.x + paramInt)];
    }
  }
  
  private static class f<T>
    implements Iterator<T>
  {
    @NullableDecl
    private Iterator<? extends T> c;
    private Iterator<? extends T> d = k1.h();
    private Iterator<? extends Iterator<? extends T>> f;
    @NullableDecl
    private Deque<Iterator<? extends Iterator<? extends T>>> q;
    
    f(Iterator<? extends Iterator<? extends T>> paramIterator)
    {
      this.f = ((Iterator)n.o(paramIterator));
    }
    
    @NullableDecl
    private Iterator<? extends Iterator<? extends T>> a()
    {
      for (;;)
      {
        Object localObject = this.f;
        if ((localObject != null) && (((Iterator)localObject).hasNext())) {
          return this.f;
        }
        localObject = this.q;
        if ((localObject == null) || (((Deque)localObject).isEmpty())) {
          break;
        }
        this.f = ((Iterator)this.q.removeFirst());
      }
      return null;
    }
    
    public boolean hasNext()
    {
      while (!((Iterator)n.o(this.d)).hasNext())
      {
        Object localObject = a();
        this.f = ((Iterator)localObject);
        if (localObject == null) {
          return false;
        }
        localObject = (Iterator)((Iterator)localObject).next();
        this.d = ((Iterator)localObject);
        if ((localObject instanceof f))
        {
          localObject = (f)localObject;
          this.d = ((f)localObject).d;
          if (this.q == null) {
            this.q = new ArrayDeque();
          }
          this.q.addFirst(this.f);
          if (((f)localObject).q != null) {
            while (!((f)localObject).q.isEmpty()) {
              this.q.addFirst(((f)localObject).q.removeLast());
            }
          }
          this.f = ((f)localObject).f;
        }
      }
      return true;
    }
    
    public T next()
    {
      if (hasNext())
      {
        Iterator localIterator = this.d;
        this.c = localIterator;
        return (T)localIterator.next();
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      boolean bool;
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      this.c.remove();
      this.c = null;
    }
  }
  
  private static enum g
    implements Iterator<Object>
  {
    static
    {
      g localg = new g("INSTANCE", 0);
      c = localg;
      d = new g[] { localg };
    }
    
    public boolean hasNext()
    {
      return false;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      v.e(false);
    }
  }
  
  private static class h<T>
    extends j3<T>
  {
    final Queue<b2<T>> c;
    
    public h(Iterable<? extends Iterator<? extends T>> paramIterable, final Comparator<? super T> paramComparator)
    {
      this.c = new PriorityQueue(2, new a(paramComparator));
      paramComparator = paramIterable.iterator();
      while (paramComparator.hasNext())
      {
        paramIterable = (Iterator)paramComparator.next();
        if (paramIterable.hasNext()) {
          this.c.add(k1.q(paramIterable));
        }
      }
    }
    
    public boolean hasNext()
    {
      return this.c.isEmpty() ^ true;
    }
    
    public T next()
    {
      b2 localb2 = (b2)this.c.remove();
      Object localObject = localb2.next();
      if (localb2.hasNext()) {
        this.c.add(localb2);
      }
      return (T)localObject;
    }
    
    class a
      implements Comparator<b2<T>>
    {
      a(Comparator paramComparator) {}
      
      public int a(b2<T> paramb21, b2<T> paramb22)
      {
        return paramComparator.compare(paramb21.peek(), paramb22.peek());
      }
    }
  }
  
  private static class i<E>
    implements b2<E>
  {
    private final Iterator<? extends E> c;
    private boolean d;
    @NullableDecl
    private E f;
    
    public i(Iterator<? extends E> paramIterator)
    {
      this.c = ((Iterator)n.o(paramIterator));
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if ((!this.d) && (!this.c.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public E next()
    {
      if (!this.d) {
        return (E)this.c.next();
      }
      Object localObject = this.f;
      this.d = false;
      this.f = null;
      return (E)localObject;
    }
    
    public E peek()
    {
      if (!this.d)
      {
        this.f = this.c.next();
        this.d = true;
      }
      return (E)this.f;
    }
    
    public void remove()
    {
      n.v(this.d ^ true, "Can't remove after you've peeked at next");
      this.c.remove();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\k1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */