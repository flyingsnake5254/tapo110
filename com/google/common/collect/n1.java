package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.primitives.d;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class n1
{
  static <T> List<T> a(Iterable<T> paramIterable)
  {
    return (List)paramIterable;
  }
  
  static int b(int paramInt)
  {
    v.b(paramInt, "arraySize");
    return d.i(paramInt + 5L + paramInt / 10);
  }
  
  static boolean c(List<?> paramList, @NullableDecl Object paramObject)
  {
    if (paramObject == n.o(paramList)) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    paramObject = (List)paramObject;
    int i = paramList.size();
    if (i != ((List)paramObject).size()) {
      return false;
    }
    if (((paramList instanceof RandomAccess)) && ((paramObject instanceof RandomAccess)))
    {
      for (int j = 0; j < i; j++) {
        if (!k.a(paramList.get(j), ((List)paramObject).get(j))) {
          return false;
        }
      }
      return true;
    }
    return k1.g(paramList.iterator(), ((List)paramObject).iterator());
  }
  
  static int d(List<?> paramList, @NullableDecl Object paramObject)
  {
    if ((paramList instanceof RandomAccess)) {
      return e(paramList, paramObject);
    }
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (k.a(paramObject, paramList.next())) {
        return paramList.previousIndex();
      }
    }
    return -1;
  }
  
  private static int e(List<?> paramList, @NullableDecl Object paramObject)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (paramObject == null) {
      for (j = k; j < i; j++) {
        if (paramList.get(j) == null) {
          return j;
        }
      }
    }
    while (j < i)
    {
      if (paramObject.equals(paramList.get(j))) {
        return j;
      }
      j++;
    }
    return -1;
  }
  
  static int f(List<?> paramList, @NullableDecl Object paramObject)
  {
    if ((paramList instanceof RandomAccess)) {
      return g(paramList, paramObject);
    }
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious()) {
      if (k.a(paramObject, paramList.previous())) {
        return paramList.nextIndex();
      }
    }
    return -1;
  }
  
  private static int g(List<?> paramList, @NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      for (i = paramList.size() - 1; i >= 0; i--) {
        if (paramList.get(i) == null) {
          return i;
        }
      }
    }
    for (int i = paramList.size() - 1; i >= 0; i--) {
      if (paramObject.equals(paramList.get(i))) {
        return i;
      }
    }
    return -1;
  }
  
  public static <E> ArrayList<E> h()
  {
    return new ArrayList();
  }
  
  public static <E> ArrayList<E> i(Iterable<? extends E> paramIterable)
  {
    n.o(paramIterable);
    if ((paramIterable instanceof Collection)) {
      paramIterable = new ArrayList(w.a(paramIterable));
    } else {
      paramIterable = j(paramIterable.iterator());
    }
    return paramIterable;
  }
  
  public static <E> ArrayList<E> j(Iterator<? extends E> paramIterator)
  {
    ArrayList localArrayList = h();
    k1.a(localArrayList, paramIterator);
    return localArrayList;
  }
  
  public static <E> ArrayList<E> k(int paramInt)
  {
    v.b(paramInt, "initialArraySize");
    return new ArrayList(paramInt);
  }
  
  public static <E> ArrayList<E> l(int paramInt)
  {
    return new ArrayList(b(paramInt));
  }
  
  public static <F, T> List<T> m(List<F> paramList, h<? super F, ? extends T> paramh)
  {
    if ((paramList instanceof RandomAccess)) {
      paramList = new a(paramList, paramh);
    } else {
      paramList = new b(paramList, paramh);
    }
    return paramList;
  }
  
  private static class a<F, T>
    extends AbstractList<T>
    implements RandomAccess, Serializable
  {
    final List<F> c;
    final h<? super F, ? extends T> d;
    
    a(List<F> paramList, h<? super F, ? extends T> paramh)
    {
      this.c = ((List)n.o(paramList));
      this.d = ((h)n.o(paramh));
    }
    
    public void clear()
    {
      this.c.clear();
    }
    
    public T get(int paramInt)
    {
      return (T)this.d.apply(this.c.get(paramInt));
    }
    
    public boolean isEmpty()
    {
      return this.c.isEmpty();
    }
    
    public Iterator<T> iterator()
    {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int paramInt)
    {
      return new a(this.c.listIterator(paramInt));
    }
    
    public T remove(int paramInt)
    {
      return (T)this.d.apply(this.c.remove(paramInt));
    }
    
    public int size()
    {
      return this.c.size();
    }
    
    class a
      extends i3<F, T>
    {
      a(ListIterator paramListIterator)
      {
        super();
      }
      
      T a(F paramF)
      {
        return (T)n1.a.this.d.apply(paramF);
      }
    }
  }
  
  private static class b<F, T>
    extends AbstractSequentialList<T>
    implements Serializable
  {
    final List<F> c;
    final h<? super F, ? extends T> d;
    
    b(List<F> paramList, h<? super F, ? extends T> paramh)
    {
      this.c = ((List)n.o(paramList));
      this.d = ((h)n.o(paramh));
    }
    
    public void clear()
    {
      this.c.clear();
    }
    
    public ListIterator<T> listIterator(int paramInt)
    {
      return new a(this.c.listIterator(paramInt));
    }
    
    public int size()
    {
      return this.c.size();
    }
    
    class a
      extends i3<F, T>
    {
      a(ListIterator paramListIterator)
      {
        super();
      }
      
      T a(F paramF)
      {
        return (T)n1.b.this.d.apply(paramF);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\n1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */