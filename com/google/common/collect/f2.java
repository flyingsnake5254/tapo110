package com.google.common.collect;

import java.util.Set;

public abstract interface f2<C extends Comparable>
{
  public abstract Set<Range<C>> asRanges();
  
  public abstract f2<C> complement();
  
  public abstract boolean encloses(Range<C> paramRange);
  
  public abstract boolean isEmpty();
  
  public abstract void removeAll(f2<C> paramf2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\f2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */