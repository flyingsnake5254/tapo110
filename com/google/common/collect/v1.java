package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class v1
{
  private static <E> boolean a(u1<E> paramu1, f<? extends E> paramf)
  {
    if (paramf.isEmpty()) {
      return false;
    }
    paramf.addTo(paramu1);
    return true;
  }
  
  private static <E> boolean b(u1<E> paramu1, u1<? extends E> paramu11)
  {
    if ((paramu11 instanceof f)) {
      return a(paramu1, (f)paramu11);
    }
    if (paramu11.isEmpty()) {
      return false;
    }
    Iterator localIterator = paramu11.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramu11 = (u1.a)localIterator.next();
      paramu1.add(paramu11.a(), paramu11.getCount());
    }
    return true;
  }
  
  static <E> boolean c(u1<E> paramu1, Collection<? extends E> paramCollection)
  {
    n.o(paramu1);
    n.o(paramCollection);
    if ((paramCollection instanceof u1)) {
      return b(paramu1, d(paramCollection));
    }
    if (paramCollection.isEmpty()) {
      return false;
    }
    return k1.a(paramu1, paramCollection.iterator());
  }
  
  static <T> u1<T> d(Iterable<T> paramIterable)
  {
    return (u1)paramIterable;
  }
  
  static <E> Iterator<E> e(Iterator<u1.a<E>> paramIterator)
  {
    return new a(paramIterator);
  }
  
  static boolean f(u1<?> paramu1, @NullableDecl Object paramObject)
  {
    if (paramObject == paramu1) {
      return true;
    }
    if ((paramObject instanceof u1))
    {
      paramObject = (u1)paramObject;
      if ((paramu1.size() == ((u1)paramObject).size()) && (paramu1.entrySet().size() == ((u1)paramObject).entrySet().size()))
      {
        Iterator localIterator = ((u1)paramObject).entrySet().iterator();
        while (localIterator.hasNext())
        {
          paramObject = (u1.a)localIterator.next();
          if (paramu1.count(((u1.a)paramObject).a()) != ((u1.a)paramObject).getCount()) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public static <E> u1.a<E> g(@NullableDecl E paramE, int paramInt)
  {
    return new e(paramE, paramInt);
  }
  
  static int h(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof u1)) {
      return ((u1)paramIterable).elementSet().size();
    }
    return 11;
  }
  
  static <E> Iterator<E> i(u1<E> paramu1)
  {
    return new f(paramu1, paramu1.entrySet().iterator());
  }
  
  static boolean j(u1<?> paramu1, Collection<?> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof u1)) {
      localObject = ((u1)paramCollection).elementSet();
    }
    return paramu1.elementSet().removeAll((Collection)localObject);
  }
  
  static boolean k(u1<?> paramu1, Collection<?> paramCollection)
  {
    n.o(paramCollection);
    Object localObject = paramCollection;
    if ((paramCollection instanceof u1)) {
      localObject = ((u1)paramCollection).elementSet();
    }
    return paramu1.elementSet().retainAll((Collection)localObject);
  }
  
  static <E> int l(u1<E> paramu1, E paramE, int paramInt)
  {
    v.b(paramInt, "count");
    int i = paramu1.count(paramE);
    paramInt -= i;
    if (paramInt > 0) {
      paramu1.add(paramE, paramInt);
    } else if (paramInt < 0) {
      paramu1.remove(paramE, -paramInt);
    }
    return i;
  }
  
  static <E> boolean m(u1<E> paramu1, E paramE, int paramInt1, int paramInt2)
  {
    v.b(paramInt1, "oldCount");
    v.b(paramInt2, "newCount");
    if (paramu1.count(paramE) == paramInt1)
    {
      paramu1.setCount(paramE, paramInt2);
      return true;
    }
    return false;
  }
  
  static final class a
    extends h3<u1.a<E>, E>
  {
    a(Iterator paramIterator)
    {
      super();
    }
    
    E b(u1.a<E> parama)
    {
      return (E)parama.a();
    }
  }
  
  static abstract class b<E>
    implements u1.a<E>
  {
    public boolean equals(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof u1.a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (u1.a)paramObject;
        bool3 = bool2;
        if (getCount() == ((u1.a)paramObject).getCount())
        {
          bool3 = bool2;
          if (k.a(a(), ((u1.a)paramObject).a())) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      Object localObject = a();
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = localObject.hashCode();
      }
      return i ^ getCount();
    }
    
    public String toString()
    {
      String str = String.valueOf(a());
      int i = getCount();
      if (i != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" x ");
        localStringBuilder.append(i);
        str = localStringBuilder.toString();
      }
      return str;
    }
  }
  
  static abstract class c<E>
    extends u2.b<E>
  {
    abstract u1<E> c();
    
    public void clear()
    {
      c().clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return c().contains(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return c().containsAll(paramCollection);
    }
    
    public boolean isEmpty()
    {
      return c().isEmpty();
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool;
      if (c().remove(paramObject, Integer.MAX_VALUE) > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int size()
    {
      return c().entrySet().size();
    }
  }
  
  static abstract class d<E>
    extends u2.b<u1.a<E>>
  {
    abstract u1<E> c();
    
    public void clear()
    {
      c().clear();
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof u1.a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (u1.a)paramObject;
        if (((u1.a)paramObject).getCount() <= 0) {
          return false;
        }
        bool3 = bool2;
        if (c().count(((u1.a)paramObject).a()) == ((u1.a)paramObject).getCount()) {
          bool3 = true;
        }
      }
      return bool3;
    }
    
    public boolean remove(Object paramObject)
    {
      if ((paramObject instanceof u1.a))
      {
        paramObject = (u1.a)paramObject;
        Object localObject = ((u1.a)paramObject).a();
        int i = ((u1.a)paramObject).getCount();
        if (i != 0) {
          return c().setCount(localObject, i, 0);
        }
      }
      return false;
    }
  }
  
  static class e<E>
    extends v1.b<E>
    implements Serializable
  {
    @NullableDecl
    private final E c;
    private final int d;
    
    e(@NullableDecl E paramE, int paramInt)
    {
      this.c = paramE;
      this.d = paramInt;
      v.b(paramInt, "count");
    }
    
    @NullableDecl
    public final E a()
    {
      return (E)this.c;
    }
    
    public final int getCount()
    {
      return this.d;
    }
  }
  
  static final class f<E>
    implements Iterator<E>
  {
    private final u1<E> c;
    private final Iterator<u1.a<E>> d;
    @MonotonicNonNullDecl
    private u1.a<E> f;
    private int q;
    private int x;
    private boolean y;
    
    f(u1<E> paramu1, Iterator<u1.a<E>> paramIterator)
    {
      this.c = paramu1;
      this.d = paramIterator;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if ((this.q <= 0) && (!this.d.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public E next()
    {
      if (hasNext())
      {
        if (this.q == 0)
        {
          u1.a locala = (u1.a)this.d.next();
          this.f = locala;
          int i = locala.getCount();
          this.q = i;
          this.x = i;
        }
        this.q -= 1;
        this.y = true;
        return (E)this.f.a();
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      v.e(this.y);
      if (this.x == 1) {
        this.d.remove();
      } else {
        this.c.remove(this.f.a());
      }
      this.x -= 1;
      this.y = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\v1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */