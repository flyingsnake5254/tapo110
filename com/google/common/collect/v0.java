package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class v0<E>
  extends u0<E>
  implements SortedSet<E>
{
  private int b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    Comparator localComparator = comparator();
    int i;
    if (localComparator == null) {
      i = ((Comparable)paramObject1).compareTo(paramObject2);
    } else {
      i = localComparator.compare(paramObject1, paramObject2);
    }
    return i;
  }
  
  protected abstract SortedSet<E> a();
  
  public Comparator<? super E> comparator()
  {
    return a().comparator();
  }
  
  public E first()
  {
    return (E)a().first();
  }
  
  public SortedSet<E> headSet(E paramE)
  {
    return a().headSet(paramE);
  }
  
  public E last()
  {
    return (E)a().last();
  }
  
  protected boolean standardContains(@NullableDecl Object paramObject)
  {
    boolean bool = false;
    try
    {
      int i = b(tailSet(paramObject).first(), paramObject);
      if (i == 0) {
        bool = true;
      }
    }
    catch (ClassCastException|NoSuchElementException|NullPointerException paramObject)
    {
      for (;;) {}
    }
    return bool;
  }
  
  protected boolean standardRemove(@NullableDecl Object paramObject)
  {
    try
    {
      Iterator localIterator = tailSet(paramObject).iterator();
      if ((localIterator.hasNext()) && (b(localIterator.next(), paramObject) == 0))
      {
        localIterator.remove();
        return true;
      }
    }
    catch (ClassCastException|NullPointerException paramObject)
    {
      for (;;) {}
    }
    return false;
  }
  
  public SortedSet<E> subSet(E paramE1, E paramE2)
  {
    return a().subSet(paramE1, paramE2);
  }
  
  public SortedSet<E> tailSet(E paramE)
  {
    return a().tailSet(paramE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\v0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */