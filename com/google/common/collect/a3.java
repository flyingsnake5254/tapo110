package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

public abstract interface a3<E>
  extends x2<E>
{
  public abstract Comparator<? super E> comparator();
  
  public abstract a3<E> descendingMultiset();
  
  public abstract NavigableSet<E> elementSet();
  
  public abstract Set<u1.a<E>> entrySet();
  
  public abstract u1.a<E> firstEntry();
  
  public abstract a3<E> headMultiset(E paramE, BoundType paramBoundType);
  
  public abstract u1.a<E> lastEntry();
  
  public abstract u1.a<E> pollFirstEntry();
  
  public abstract u1.a<E> pollLastEntry();
  
  public abstract a3<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2);
  
  public abstract a3<E> tailMultiset(E paramE, BoundType paramBoundType);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\a3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */