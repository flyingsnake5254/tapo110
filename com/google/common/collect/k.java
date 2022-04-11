package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class k<C extends Comparable>
  implements f2<C>
{
  public abstract void add(Range<C> paramRange);
  
  public void addAll(f2<C> paramf2)
  {
    addAll(paramf2.asRanges());
  }
  
  public void addAll(Iterable<Range<C>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add((Range)paramIterable.next());
    }
  }
  
  public void clear()
  {
    remove(Range.all());
  }
  
  public boolean contains(C paramC)
  {
    boolean bool;
    if (rangeContaining(paramC) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean encloses(Range<C> paramRange);
  
  public boolean enclosesAll(f2<C> paramf2)
  {
    return enclosesAll(paramf2.asRanges());
  }
  
  public boolean enclosesAll(Iterable<Range<C>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!encloses((Range)paramIterable.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f2))
    {
      paramObject = (f2)paramObject;
      return asRanges().equals(((f2)paramObject).asRanges());
    }
    return false;
  }
  
  public final int hashCode()
  {
    return asRanges().hashCode();
  }
  
  public abstract boolean intersects(Range<C> paramRange);
  
  public boolean isEmpty()
  {
    return asRanges().isEmpty();
  }
  
  public abstract Range<C> rangeContaining(C paramC);
  
  public abstract void remove(Range<C> paramRange);
  
  public void removeAll(f2<C> paramf2)
  {
    removeAll(paramf2.asRanges());
  }
  
  public void removeAll(Iterable<Range<C>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      remove((Range)paramIterable.next());
    }
  }
  
  public final String toString()
  {
    return asRanges().toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */