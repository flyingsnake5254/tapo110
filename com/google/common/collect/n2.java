package com.google.common.collect;

import com.google.common.base.n;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class n2<E>
  extends ImmutableSortedSet<E>
{
  static final n2<Comparable> c = new n2(ImmutableList.of(), a2.g());
  final transient ImmutableList<E> d;
  
  n2(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    this.d = paramImmutableList;
  }
  
  private int f(Object paramObject)
    throws ClassCastException
  {
    return Collections.binarySearch(this.d, paramObject, g());
  }
  
  n2<E> a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      return new n2(this.d.subList(paramInt1, paramInt2), this.comparator);
    }
    return ImmutableSortedSet.emptySet(this.comparator);
  }
  
  public ImmutableList<E> asList()
  {
    return this.d;
  }
  
  int b(E paramE, boolean paramBoolean)
  {
    int i = Collections.binarySearch(this.d, n.o(paramE), comparator());
    if (i >= 0)
    {
      int j = i;
      if (paramBoolean) {
        j = i + 1;
      }
      return j;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public E ceiling(E paramE)
  {
    int i = d(paramE, true);
    if (i == size()) {
      paramE = null;
    } else {
      paramE = this.d.get(i);
    }
    return paramE;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    bool1 = false;
    bool2 = bool1;
    if (paramObject != null) {}
    try
    {
      int i = f(paramObject);
      bool2 = bool1;
      if (i >= 0) {
        bool2 = true;
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof u1)) {
      localObject = ((u1)paramCollection).elementSet();
    }
    j3 localj3;
    Iterator localIterator;
    if ((y2.b(comparator(), (Iterable)localObject)) && (((Collection)localObject).size() > 1))
    {
      localj3 = iterator();
      localIterator = ((Collection)localObject).iterator();
      if (!localj3.hasNext()) {
        return false;
      }
      localObject = localIterator.next();
      paramCollection = localj3.next();
    }
    try
    {
      int i;
      do
      {
        for (;;)
        {
          i = unsafeCompare(paramCollection, localObject);
          if (i < 0)
          {
            if (!localj3.hasNext()) {
              return false;
            }
            paramCollection = localj3.next();
          }
          else
          {
            if (i != 0) {
              break;
            }
            if (!localIterator.hasNext()) {
              return true;
            }
            localObject = localIterator.next();
          }
        }
      } while (i <= 0);
    }
    catch (NullPointerException|ClassCastException paramCollection)
    {
      for (;;) {}
    }
    return false;
    return super.containsAll((Collection)localObject);
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    return this.d.copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableSortedSet<E> createDescendingSet()
  {
    Object localObject = Collections.reverseOrder(this.comparator);
    if (isEmpty()) {
      localObject = ImmutableSortedSet.emptySet((Comparator)localObject);
    } else {
      localObject = new n2(this.d.reverse(), (Comparator)localObject);
    }
    return (ImmutableSortedSet<E>)localObject;
  }
  
  int d(E paramE, boolean paramBoolean)
  {
    int i = Collections.binarySearch(this.d, n.o(paramE), comparator());
    if (i >= 0)
    {
      if (!paramBoolean) {
        i++;
      }
      return i;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public j3<E> descendingIterator()
  {
    return this.d.reverse().iterator();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Set)) {
      return false;
    }
    paramObject = (Set)paramObject;
    if (size() != ((Set)paramObject).size()) {
      return false;
    }
    if (isEmpty()) {
      return true;
    }
    if (y2.b(this.comparator, (Iterable)paramObject))
    {
      Iterator localIterator = ((Set)paramObject).iterator();
      try
      {
        j3 localj3 = iterator();
        while (localj3.hasNext())
        {
          paramObject = localj3.next();
          Object localObject = localIterator.next();
          if (localObject != null)
          {
            int i = unsafeCompare(paramObject, localObject);
            if (i == 0) {
              break;
            }
          }
          else
          {
            return false;
          }
        }
        return true;
      }
      catch (ClassCastException|NoSuchElementException paramObject)
      {
        return false;
      }
    }
    return containsAll((Collection)paramObject);
  }
  
  public E first()
  {
    if (!isEmpty()) {
      return (E)this.d.get(0);
    }
    throw new NoSuchElementException();
  }
  
  public E floor(E paramE)
  {
    int i = b(paramE, true) - 1;
    if (i == -1) {
      paramE = null;
    } else {
      paramE = this.d.get(i);
    }
    return paramE;
  }
  
  Comparator<Object> g()
  {
    return this.comparator;
  }
  
  ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean)
  {
    return a(0, b(paramE, paramBoolean));
  }
  
  public E higher(E paramE)
  {
    int i = d(paramE, false);
    if (i == size()) {
      paramE = null;
    } else {
      paramE = this.d.get(i);
    }
    return paramE;
  }
  
  int indexOf(@NullableDecl Object paramObject)
  {
    int i = -1;
    if (paramObject == null) {
      return -1;
    }
    try
    {
      int j = Collections.binarySearch(this.d, paramObject, g());
      if (j >= 0) {
        i = j;
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;) {}
    }
    return i;
  }
  
  Object[] internalArray()
  {
    return this.d.internalArray();
  }
  
  int internalArrayEnd()
  {
    return this.d.internalArrayEnd();
  }
  
  int internalArrayStart()
  {
    return this.d.internalArrayStart();
  }
  
  boolean isPartialView()
  {
    return this.d.isPartialView();
  }
  
  public j3<E> iterator()
  {
    return this.d.iterator();
  }
  
  public E last()
  {
    if (!isEmpty()) {
      return (E)this.d.get(size() - 1);
    }
    throw new NoSuchElementException();
  }
  
  public E lower(E paramE)
  {
    int i = b(paramE, false) - 1;
    if (i == -1) {
      paramE = null;
    } else {
      paramE = this.d.get(i);
    }
    return paramE;
  }
  
  public int size()
  {
    return this.d.size();
  }
  
  ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return tailSetImpl(paramE1, paramBoolean1).headSetImpl(paramE2, paramBoolean2);
  }
  
  ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean)
  {
    return a(d(paramE, paramBoolean), size());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\n2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */